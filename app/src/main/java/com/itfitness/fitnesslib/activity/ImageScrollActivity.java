package com.itfitness.fitnesslib.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.itfitness.fitnesslib.R;
import com.itfitness.fitnesslib.adapter.FTFragmentAdapter;
import com.itfitness.fitnesslib.fragment.ViewPagerFloatRecyclerFragment;
import com.itfitness.fitnesslib.fragment.ViewPagerImageScrollFragment;
import com.itfitness.ftlib.widget.scrollablelayoutlib.ScrollableHelper;
import com.itfitness.ftlib.widget.scrollablelayoutlib.ScrollableLayout;
import com.nineoldandroids.view.ViewHelper;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: FitnessLib
 * @Package: com.itfitness.fitnesslib.activity
 * @ClassName: ViewPagerFloatActivity
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/7/19 10:23
 * @UpdateUser: 更新者：itfitness
 * @UpdateDate: 2020/7/19 10:23
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ImageScrollActivity extends AppCompatActivity {
    private MagicIndicator mIndicator;
    private ViewPager mViewPager;
    private ScrollableLayout mScrollablelayout;
    private LinearLayout mHeaderView;
    private List<Fragment> mFragments;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagescroll);
        initView();
        initDatas();
        initListener();
    }

    private void initListener() {
        mScrollablelayout.setOnScrollListener(new ScrollableLayout.OnScrollListener() {
            @Override
            public void onScroll(int currentY, int maxY) {
//                float alpha = (float) currentY / (float) maxY;
//                alpha = Math.min(1,Math.max(0,alpha));
                ViewHelper.setTranslationY(mHeaderView, (float) (currentY * 0.5));
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

    private void initDatas() {
        initFragments();
        initIndefator();
    }

    private void initView() {
        mScrollablelayout = findViewById(R.id.activity_viewpagerfloat_sl);
        mHeaderView = findViewById(R.id.activity_viewpagerfloat_header);
        mIndicator = findViewById(R.id.activity_viewpagerfloat_mi);
        mViewPager = findViewById(R.id.activity_viewpagerfloat_vp);
    }
    /**
     * 加载每页的信息
     */
    private void initFragments() {
        if (mFragments == null) {
            mFragments = new ArrayList<>();
        }
        mFragments.clear();
        mFragments.add(new ViewPagerImageScrollFragment());
        mFragments.add(new ViewPagerFloatRecyclerFragment());
        mFragments.add(new ViewPagerFloatRecyclerFragment());
        mViewPager.setAdapter(new FTFragmentAdapter(getSupportFragmentManager(), mFragments));
        mViewPager.setOffscreenPageLimit(mFragments.size());
        mScrollablelayout.getHelper().setCurrentScrollableContainer((ScrollableHelper.ScrollableContainer) mFragments.get(0));
    }
    /**
     * 加载指示器
     */
    private void initIndefator() {
        final ArrayList<String> indefatorDatas = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            indefatorDatas.add("分类"+i);
        }
        mIndicator.setBackgroundColor(Color.WHITE);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {

            @Override
            public int getCount() {
                return indefatorDatas.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setNormalColor(Color.BLACK);
                simplePagerTitleView.setSelectedColor(getResources().getColor(R.color.colorAccent));
                simplePagerTitleView.setText(indefatorDatas.get(index));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                linePagerIndicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                linePagerIndicator.setColors(getResources().getColor(R.color.colorAccent));
                linePagerIndicator.setLineHeight(5);
                return linePagerIndicator;
            }
        });
        mIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mIndicator, mViewPager);
    }
}
