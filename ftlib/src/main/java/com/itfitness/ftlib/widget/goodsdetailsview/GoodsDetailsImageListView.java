package com.itfitness.ftlib.widget.goodsdetailsview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.itfitness.ftlib.R;
import com.itfitness.ftlib.widget.simplelistview.SimpleListView;

import java.util.ArrayList;

/**
 * @ProjectName: GoodsDetailsView
 * @Package: com.itfitness.goodsdetailsview.widget
 * @ClassName: GoodsDetailsView
 * @Description: java类作用描述 商品详情控件(展示类似淘宝京东等商品详情图的控件)
 * @Author: 作者名
 * @CreateDate: 2020/7/11 23:08
 * @UpdateUser: 更新者：itfitness
 * @UpdateDate: 2020/7/11 23:08
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class GoodsDetailsImageListView extends FrameLayout {
    private SimpleListView simpleListView;
    private SimpleListView.OnItemClickListener onItemClickListener;
    public GoodsDetailsImageListView(@NonNull Context context) {
        this(context,null);
    }
    public GoodsDetailsImageListView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }
    public GoodsDetailsImageListView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        simpleListView = new SimpleListView(getContext());
        addView(simpleListView);
    }

    /**
     * 此处类型可随意切换ArrayList<T> datas
     * @param datas
     */
    public <T extends GoodsDetailsImageItemModulImpl> void setImgDatas(ArrayList<T> datas){
        simpleListView.setDatas(R.layout.ftlib_item_goodsdetailsview, datas, new SimpleListView.CovertViewListener<T>() {
            @Override
            public void covert(View view, T data) {
                ImageView imageView = view.findViewById(R.id.ftlib_item_goodsdetailsview_img);
                Glide.with(getContext()).load(data.getImgUrl()).into(imageView);
            }
        });
    }

    public SimpleListView.OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(SimpleListView.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
        simpleListView.setOnItemClickListener(onItemClickListener);
    }
}
