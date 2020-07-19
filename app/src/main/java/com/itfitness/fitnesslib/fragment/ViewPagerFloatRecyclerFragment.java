package com.itfitness.fitnesslib.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.itfitness.fitnesslib.MainActivity;
import com.itfitness.fitnesslib.R;
import com.itfitness.fitnesslib.utils.JumpUtil;
import com.itfitness.ftlib.widget.scrollablelayoutlib.ScrollableHelper;

import java.util.ArrayList;

/**
 * @ProjectName: FitnessLib
 * @Package: com.itfitness.fitnesslib.fragment
 * @ClassName: ViewPagerFloatRecyclerFragment
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/7/19 10:42
 * @UpdateUser: 更新者：itfitness
 * @UpdateDate: 2020/7/19 10:42
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ViewPagerFloatRecyclerFragment extends Fragment implements ScrollableHelper.ScrollableContainer{
    private View mView;
    private RecyclerView mRecyclerView;
    private BaseQuickAdapter<String, BaseViewHolder> mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_viewpagerfloatrecycler, container, false);
        initView();
        return mView;
    }

    private void initView() {
        mRecyclerView = mView.findViewById(R.id.fragment_viewpagerfloatrecycler_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initDatas();
    }
    private void initDatas() {
        initAdapter();
    }
    private void initAdapter() {
        ArrayList<String> items = new ArrayList<>();
        for (int i = 0 ; i < 20 ; i++){
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

    /**
     * 返回滑动的View（也可以是WebView,ScrollView,ListView等）
     * @return
     */
    @Override
    public View getScrollableView() {
        return mRecyclerView;
    }
}
