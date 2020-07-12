package com.itfitness.fitnesslib.utils;

import android.content.Context;
import android.content.Intent;

import com.itfitness.fitnesslib.activity.GoodsDetailsImageActivity;

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
}
