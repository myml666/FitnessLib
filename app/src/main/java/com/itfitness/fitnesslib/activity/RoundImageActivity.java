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
 * @Description: java类作用描述 圆角图片
 * @Author: 作者名
 * @CreateDate: 2020/7/19 10:23
 * @UpdateUser: 更新者：itfitness
 * @UpdateDate: 2020/7/19 10:23
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class RoundImageActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roundimage);
    }
}
