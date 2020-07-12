package com.itfitness.ftlib.widget.simplelistview;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.List;

/**
 * @ProjectName: SimpleListView
 * @Package: com.itfitness.simplelistview
 * @ClassName: SimpleListView
 * @Description: java类作用描述 简单的列表控件（能够实现自适应高度，但是需要被ScrollView包裹）
 * @Author: 作者名
 * @CreateDate: 2020/3/22 17:41
 * @UpdateUser: 更新者：itfitness
 * @UpdateDate: 2020/3/22 17:41
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class SimpleListView extends LinearLayout {
    private OnItemClickListener onItemClickListener;
    private Context mContext;
    private int itemLayout;
    private CovertViewListener covertViewListener;

    public CovertViewListener getCovertViewListener() {
        return covertViewListener;
    }

    public void setCovertViewListener(CovertViewListener covertViewListener) {
        this.covertViewListener = covertViewListener;
    }

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public SimpleListView(Context context) {
        this(context,null);
    }

    public SimpleListView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SimpleListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setOrientation(VERTICAL);
    }

    /**
     * 设置数据
     * @param layoutRes
     * @param items
     * @param covertViewListener
     */
    public <T> void setDatas(@LayoutRes int layoutRes , @NonNull final List<T> items, CovertViewListener<T> covertViewListener){
        itemLayout = layoutRes;
        this.covertViewListener = covertViewListener;
        removeAllViews();
        for(int i = 0 ; i < items.size() ; i++){
            View itemView = View.inflate(mContext, layoutRes, null);
            if(covertViewListener!=null){
                covertViewListener.covert(itemView,items.get(i));
            }
            final int finalI = i;
            itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemClickListener!=null){
                        onItemClickListener.onItemClick(finalI,items.get(finalI));
                    }
                }
            });
            addView(itemView);
        }
    }

    /**
     * 更新数据
     * @param items
     */
    public void updateDatas(@NonNull final List<?> items){
        removeAllViews();
        for(int i = 0 ; i < items.size() ; i++){
            View itemView = View.inflate(mContext, itemLayout, null);
            if(covertViewListener!=null){
                covertViewListener.covert(itemView,items.get(i));
            }
            final int finalI = i;
            itemView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(onItemClickListener!=null){
                        onItemClickListener.onItemClick(finalI,items.get(finalI));
                    }
                }
            });
            addView(itemView);
        }
    }
    /**
     * 给item添加数据
     */
    public interface CovertViewListener<T>{
        void covert(View view, T data);
    }
    public interface OnItemClickListener<T>{
        void onItemClick(int position, T data);
    }
}
