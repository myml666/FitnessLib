package com.itfitness.fitnesslib.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.itfitness.fitnesslib.R;
import com.itfitness.fitnesslib.widget.TextFooterView;
import com.lcodecore.tkrefreshlayout.Footer.LoadingView;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.header.SinaRefreshView;

import java.util.ArrayList;

/**
 * @ProjectName: FitnessLib
 * @Package: com.itfitness.fitnesslib.activity
 * @ClassName: RefreshAndLoadMore
 * @Description: java类作用描述 下拉刷新和上拉加载更多
 * @Author: 作者名
 * @CreateDate: 2020/7/19 18:17
 * @UpdateUser: 更新者：itfitness
 * @UpdateDate: 2020/7/19 18:17
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class RefreshAndLoadMore extends AppCompatActivity {
    private TwinklingRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private BaseQuickAdapter<String, BaseViewHolder> mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refreshandloadmore);
        initView();
        initDatas();
        initListener();
    }

    private void initListener() {
        SinaRefreshView headerView = new SinaRefreshView(this);
//        headerView.setArrowResource(R.drawable.arrow);
        headerView.setTextColor(0xff745D5C);
//        TextHeaderView headerView = (TextHeaderView) View.inflate(this,R.layout.header_tv,null);
        mRefreshLayout.setHeaderView(headerView);

        TextFooterView loadingView = new TextFooterView(this);
        mRefreshLayout.setBottomView(loadingView);
        mRefreshLayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.finishRefreshing();
                    }
                }, 2000);
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mRefreshLayout.finishLoadmore();
                        ArrayList<String> items = new ArrayList<>();
                        for (int i = mAdapter.getData().size() ; i < mAdapter.getData().size()+10 ; i++){
                            items.add("我是条目"+i);
                        }
                        mAdapter.getData().addAll(items);
                        mAdapter.notifyDataSetChanged();
                    }
                }, 2000);
            }
        });
    }

    private void initView() {
        mRefreshLayout = findViewById(R.id.activity_refreshandloadmore_trl);
        mRecyclerView = findViewById(R.id.activity_refreshandloadmore_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    private void initDatas() {
        initAdapter();
    }
    private void initAdapter() {
        ArrayList<String> items = new ArrayList<>();
        for (int i = 0 ; i < 10 ; i++){
            items.add("我是条目"+i);
        }
        if(mAdapter == null){
            mAdapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_demo,items) {
                @Override
                protected void convert(BaseViewHolder helper, String item) {
                    helper.setText(R.id.item_demo_tv,item);
                }
            };
            mRecyclerView.setAdapter(mAdapter);
        }else {
            mAdapter.setNewData(items);
            mAdapter.notifyDataSetChanged();
        }
    }
}
