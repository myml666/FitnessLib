package com.itfitness.fitnesslib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.itfitness.fitnesslib.utils.JumpUtil;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerViewDemos;
    private BaseQuickAdapter<String, BaseViewHolder> mDemoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerViewDemos = findViewById(R.id.rv_demos);
        mRecyclerViewDemos.setLayoutManager(new LinearLayoutManager(this));
        initAdapter();
    }

    private void initAdapter() {
        ArrayList<String> demos = new ArrayList<>();
        demos.add("商品详情图片列表");
        demos.add("ViewPager Indicator悬浮置顶");
        demos.add("圆角图片");
        demos.add("下拉刷新和上拉加载更多");
        if(mDemoAdapter == null){
            mDemoAdapter = new BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_demo,demos) {
                @Override
                protected void convert(BaseViewHolder helper, String item) {
                    helper.setText(R.id.item_demo_tv,item);
                }
            };
            mDemoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    switch (position){
                        case 0:
                            //商品详情图片列表
                            JumpUtil.gotoGoodsDetailsImageActivity(MainActivity.this);
                            break;
                        case 1:
                            //ViewPager上滑Indicator悬浮置顶
                            JumpUtil.gotoViewPagerFloatActivity(MainActivity.this);
                            break;
                        case 2:
                            //圆角图片
                            JumpUtil.gotoRoundImageActivity(MainActivity.this);
                            break;
                        case 3:
                            //下拉刷新和上拉加载更多
                            JumpUtil.gotoRefreshAndLoadMore(MainActivity.this);
                            break;
                    }
                }
            });
            mRecyclerViewDemos.setAdapter(mDemoAdapter);
        }else {
            mDemoAdapter.setNewData(demos);
            mDemoAdapter.notifyDataSetChanged();
        }
    }
}
