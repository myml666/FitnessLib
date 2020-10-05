package com.itfitness.fitnesslib.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.itfitness.fitnesslib.R;
import com.itfitness.fitnesslib.adapter.FTFragmentAdapter;
import com.itfitness.ftlib.widget.scrollablelayoutlib.ScrollableHelper;
import com.itfitness.ftlib.widget.scrollablelayoutlib.ScrollableLayout;
import com.nineoldandroids.view.ViewHelper;

import java.util.ArrayList;
import java.util.List;

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
public class ViewPagerImageScrollFragment extends Fragment implements ScrollableHelper.ScrollableContainer{
    private View mView;
    private ViewPager mViewPager;
    private ScrollableLayout mScrollablelayout;
    private LinearLayout mHeaderView;
    private List<Fragment> mFragments;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_imagescroll, container, false);
        initView();
        return mView;
    }

    private void initView() {
        mScrollablelayout = mView.findViewById(R.id.activity_viewpagerfloat_sl);
        mHeaderView = mView.findViewById(R.id.activity_viewpagerfloat_header);
        mViewPager = mView.findViewById(R.id.activity_viewpagerfloat_vp);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initDatas();
    }
    private void initDatas() {
        initListener();
        initFragments();
    }
    private void initListener() {
        mScrollablelayout.setOnScrollListener(new ScrollableLayout.OnScrollListener() {
            @Override
            public void onScroll(int currentY, int maxY) {

            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mScrollablelayout.getHelper().setCurrentScrollableContainer((ScrollableHelper.ScrollableContainer) mFragments.get(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    /**
     * 加载每页的信息
     */
    private void initFragments() {
        if (mFragments == null) {
            mFragments = new ArrayList<>();
        }
        mFragments.clear();
        mFragments.add(new ViewPagerFloatRecyclerFragment());
        mViewPager.setAdapter(new FTFragmentAdapter(getChildFragmentManager(), mFragments));
        mViewPager.setOffscreenPageLimit(mFragments.size());
        mScrollablelayout.getHelper().setCurrentScrollableContainer((ScrollableHelper.ScrollableContainer) mFragments.get(0));
    }

    /**
     * 返回滑动的View（也可以是WebView,ScrollView,ListView等）
     * @return
     */
    @Override
    public View getScrollableView() {
        return mScrollablelayout;
    }
}
