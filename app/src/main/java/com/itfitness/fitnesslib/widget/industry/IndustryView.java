package com.itfitness.fitnesslib.widget.industry;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.itfitness.fitnesslib.R;
import com.itfitness.fitnesslib.bean.IndustryModule;

import java.util.List;

/**
 * 类似外卖首页的行业入口控件
 */
public class IndustryView extends FrameLayout implements PagerGridLayoutManager
        .PageListener {
    private RecyclerView recyclerViewClass;
    private PagerGridLayoutManager mLayoutManager;
    //一级分类的行和列
    private int mRows = 2;
    private int mColumns = 5;//行业入口一行几列（默认5列）
    private OnItemSelectListener onItemSelectListener;
    private BaseQuickAdapter<IndustryModule, BaseViewHolder> mIndustryAdapter;
    private int mItemLayout;

    public OnItemSelectListener getOnItemSelectListener() {
        return onItemSelectListener;
    }
    public void setOnItemSelectListener(OnItemSelectListener onItemSelectListener) {
        this.onItemSelectListener = onItemSelectListener;
    }
    public IndustryView(@NonNull Context context) {
        this(context, null);
    }

    public IndustryView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public IndustryView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.view_industry, this);
        initView();
    }
    //初始化LayManager--两行的情况
    private void initLayoutManagerLayManager(int row) {
        mLayoutManager = new PagerGridLayoutManager(row, mColumns, PagerGridLayoutManager.HORIZONTAL);
        mLayoutManager.setPageListener(this);    // 设置页面变化监听器
        recyclerViewClass.setLayoutManager(mLayoutManager);
    }
    private void initView() {
        recyclerViewClass = findViewById(R.id.eggla_view_home_industry_rv_class);
        // 设置滚动辅助工具
        PagerGridSnapHelper pageSnapHelper = new PagerGridSnapHelper();
        pageSnapHelper.attachToRecyclerView(recyclerViewClass);
    }

    /**
     * 设置数据
     * @param classDatas
     */
    public void setDatas(@NonNull final List<IndustryModule> classDatas, @LayoutRes final int itemLayout) {
        mItemLayout = itemLayout;
        //计算数据所占的行数
        int rows = (int) Math.ceil(classDatas.size() * 1.0 / mColumns);
        //如果实际行数比预设的行数要多则以预设行数为主
        if(rows > mRows){
            rows = mRows;
        }
        initLayoutManagerLayManager(rows);
        initAdapter(classDatas,itemLayout);
    }

    /**
     * 更新数据
     * @param classDatas
     */
    public void updateDatas(@NonNull final List<IndustryModule> classDatas) {
        //计算数据所占的行数
        int rows = (int) Math.ceil(classDatas.size() * 1.0 / mColumns);
        //如果实际行数比预设的行数要多则以预设行数为主
        if(rows > mRows){
            rows = mRows;
        }
        initLayoutManagerLayManager(rows);
        initAdapter(classDatas,mItemLayout);
    }
    /**
     * 加载适配器
     */
    private void initAdapter(List<IndustryModule> classDatas, int itemLayout) {
        if(mIndustryAdapter == null){
            mIndustryAdapter = new BaseQuickAdapter<IndustryModule, BaseViewHolder>(itemLayout,classDatas) {
                @Override
                protected void convert(BaseViewHolder helper, IndustryModule item) {
                    ImageView imageView = helper.getView(R.id.item_industry_img);
                    Glide.with(mContext).load(item.getImgUrl()).into(imageView);
                    helper.setText(R.id.item_industry_tv,item.getName());
                }
            };
            mIndustryAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    IndustryModule industryModule = mIndustryAdapter.getData().get(position);
                    if(onItemSelectListener!=null){
                        onItemSelectListener.onItemSelect(industryModule);
                    }
                }
            });
            recyclerViewClass.setAdapter(mIndustryAdapter);
        }else {
            mIndustryAdapter.setNewData(classDatas);
            mIndustryAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onPageSizeChanged(int pageSize) {

    }

    @Override
    public void onPageSelect(int pageIndex) {

    }
    /**
     * 设置Item点击事件
     */
    public interface OnItemSelectListener<T> {
        /**
         * 当条目点击
         */
        void onItemSelect(T model);
    }
}
