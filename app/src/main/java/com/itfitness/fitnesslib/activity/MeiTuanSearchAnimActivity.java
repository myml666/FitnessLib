package com.itfitness.fitnesslib.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.blankj.utilcode.util.ToastUtils;
import com.itfitness.fitnesslib.R;
import com.itfitness.fitnesslib.adapter.FTFragmentAdapter;
import com.itfitness.fitnesslib.fragment.ViewPagerFloatRecyclerFragment;
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
 * @ClassName: MeiTuanSearchAnimActivity
 * @Description: java类作用描述 仿美团搜索动画
 * @Author: 作者名
 * @CreateDate: 2020/9/26 17:50
 * @UpdateUser: 更新者：itfitness
 * @UpdateDate: 2020/9/26 17:50
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MeiTuanSearchAnimActivity extends AppCompatActivity {
    private MagicIndicator mIndicator;
    private ViewPager mViewPager;
    private ScrollableLayout mScrollablelayout;
    private LinearLayout mHeaderView;
    private FrameLayout flSearchContainer;
    private LinearLayout llSearch;
    private View vMargenTop;//上滑渐变的距离
    private View vMarginLeftMax;//上滑左边距
    private View vMask;//白色背景
    private View vSearchBg;//搜索的背景
    private ImageView imgBack;
    private List<Fragment> mFragments;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meituansearchanim);
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
//                ViewHelper.setTranslationY(mHeaderView, (float) (currentY * 0.5));
                //搜索顶部的边距变化
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) flSearchContainer.getLayoutParams();
                int searchContainerMarginTop = vMargenTop.getHeight() - currentY;
                if(searchContainerMarginTop < 0){
                    searchContainerMarginTop =0 ;
                }
                layoutParams.topMargin = searchContainerMarginTop;
                flSearchContainer.setLayoutParams(layoutParams);

                //搜索的左边距变化
                LinearLayout.LayoutParams backLayoutParams = (LinearLayout.LayoutParams) imgBack.getLayoutParams();
                FrameLayout.LayoutParams layoutParams1 = (FrameLayout.LayoutParams) llSearch.getLayoutParams();
                int searchLeftMargin = backLayoutParams.leftMargin + (int)(((double)vMarginLeftMax.getWidth()/(double) vMargenTop.getHeight())*currentY);
                if(searchLeftMargin > vMarginLeftMax.getWidth()){
                    searchLeftMargin = vMarginLeftMax.getWidth();
                }
                layoutParams1.leftMargin = searchLeftMargin;
                llSearch.setLayoutParams(layoutParams1);

                //背景及标题栏的渐变效果
                float maskAlpha = (float) searchContainerMarginTop / (float)vMargenTop.getHeight();
                vMask.setAlpha(1f - maskAlpha);//黄色背景逐渐变白
//                vSearchBg.setAlpha(1f - maskAlpha);//搜索的背景逐渐变白
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
        mScrollablelayout = findViewById(R.id.activity_meituansearch_sl);
        mHeaderView = findViewById(R.id.activity_viewpagerfloat_header);
        mIndicator = findViewById(R.id.activity_meituansearch_mi);
        mViewPager = findViewById(R.id.activity_meituansearch_vp);
        flSearchContainer = findViewById(R.id.activity_meituansearch_fl_searchcontainer);
        llSearch = findViewById(R.id.activity_meituansearch_ll_search);
        vMargenTop = findViewById(R.id.activity_meituansearch_v_top);
        vMarginLeftMax = findViewById(R.id.activity_meituansearch_v_searchmarginleft);
        imgBack = findViewById(R.id.activity_meituansearch_img_back);
        vMask = findViewById(R.id.activity_meituansearch_v_whitemask);
        vSearchBg = findViewById(R.id.activity_meituansearch_v_searchbg);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        llSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShort("搜索");
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
