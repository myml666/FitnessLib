package com.itfitness.ftlib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * @ProjectName: o2o_user_android
 * @Package: com.jinyou.o2o.widget
 * @ClassName: WripGridView
 * @Description: java类作用描述 自适应高度的GridView(用法跟GridView一样)
 * @Author: 作者名 itfitness
 * @UpdateRemark: 更新说明：
 * @Style: Eggla
 */
public class WripGridView extends GridView {
    public WripGridView(Context context) {
        super(context);
    }

    public WripGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WripGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightSpec;
        if(getLayoutParams().height == LayoutParams.WRAP_CONTENT){
            heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        }else {
            heightSpec = heightMeasureSpec;
        }

        // 这几行代码比较重要
        super.onMeasure(widthMeasureSpec, heightSpec);
    }
}
