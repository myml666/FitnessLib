package com.itfitness.fitnesslib.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.IBottomView;
import com.lcodecore.tkrefreshlayout.IHeaderView;
import com.lcodecore.tkrefreshlayout.OnAnimEndListener;

/**
 * Created by lcodecore on 2016/10/1.
 */

public class TextFooterView extends TextView implements IBottomView {


    public TextFooterView(Context context) {
        super(context);
    }

    public TextFooterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TextFooterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public View getView() {
        return this;
    }

    @Override
    public void onPullingUp(float fraction, float maxHeadHeight, float headHeight) {
        if (fraction < 1f) setText("上拉加载更多");
        if (fraction > 1f) setText("释放加载");
    }



    @Override
    public void onFinish() {

    }

    @Override
    public void startAnim(float maxHeadHeight, float headHeight) {
        setText("正在加载");
    }
    @Override
    public void onPullReleasing(float fraction, float maxHeadHeight, float headHeight) {
        if (fraction < 1f) setText("上拉加载更多");
    }
    @Override
    public void reset() {
        setText("上拉加载更多");
    }
}
