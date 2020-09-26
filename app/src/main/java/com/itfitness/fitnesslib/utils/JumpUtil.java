package com.itfitness.fitnesslib.utils;

import android.content.Context;
import android.content.Intent;

import com.itfitness.fitnesslib.activity.GoodsDetailsImageActivity;
import com.itfitness.fitnesslib.activity.IndustryActivity;
import com.itfitness.fitnesslib.activity.MeiTuanSearchAnimActivity;
import com.itfitness.fitnesslib.activity.RefreshAndLoadMore;
import com.itfitness.fitnesslib.activity.RoundImageActivity;
import com.itfitness.fitnesslib.activity.ViewPagerFloatActivity;

/**
 * @ProjectName: FitnessLib
 * @Package: com.itfitness.fitnesslib.utils
 * @ClassName: JumpUtil
 * @Description: java类作用描述 跳转工具类
 * @Author: 作者名
 * @CreateDate: 2020/7/12 10:36
 * @UpdateUser: 更新者：itfitness
 * @UpdateDate: 2020/7/12 10:36
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class JumpUtil {
    /**
     * 跳转商品详情图片列表页面
     * @param context
     */
    public static void gotoGoodsDetailsImageActivity(Context context){
        context.startActivity(new Intent(context, GoodsDetailsImageActivity.class));
    }

    /**
     * 跳转ViewPager Indicator悬浮置顶
     * @param context
     */
    public static void gotoViewPagerFloatActivity(Context context){
        context.startActivity(new Intent(context, ViewPagerFloatActivity.class));
    }

    /**
     * 圆角图片
     * @param context
     */
    public static void gotoRoundImageActivity(Context context){
        context.startActivity(new Intent(context, RoundImageActivity.class));
    }
    /**
     * 下拉刷新和上拉加载更多
     */
    public static void gotoRefreshAndLoadMore(Context context){
        context.startActivity(new Intent(context, RefreshAndLoadMore.class));
    }
    /**
     * 外卖行业入口控件
     */
    public static void gotoIndustryActivity(Context context){
        context.startActivity(new Intent(context, IndustryActivity.class));
    }

    /**
     * 仿美团搜索动画
     * @param context
     */
    public static void gotoMeiTuanSearchActivity(Context context){
        context.startActivity(new Intent(context, MeiTuanSearchAnimActivity.class));
    }
}
