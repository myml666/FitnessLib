package com.itfitness.fitnesslib.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;
import com.itfitness.fitnesslib.R;
import com.itfitness.fitnesslib.bean.IndustryBean;
import com.itfitness.fitnesslib.bean.IndustryModule;
import com.itfitness.fitnesslib.widget.industry.IndustryView;

import java.util.ArrayList;

public class IndustryActivity extends AppCompatActivity {
    private IndustryView industryView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_industry);
        initView();
        initDatas();
    }

    private void initDatas() {
        ArrayList<IndustryModule> industryBeans = new ArrayList<>();
        for(int i = 0 ; i < 5 ; i ++){
            industryBeans.add(new IndustryBean("条目" + i,"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2001382863,1289112909&fm=26&gp=0.jpg"));
        }
        //设置数据
        industryView.setDatas(industryBeans,R.layout.item_industry);
        //设置点击事件
        industryView.setOnItemSelectListener(new IndustryView.OnItemSelectListener<IndustryBean>() {
            @Override
            public void onItemSelect(IndustryBean model) {
                ToastUtils.showShort(model.getName());
            }
        });
    }

    private void initView() {
        industryView = findViewById(R.id.iv_industry);
    }

    public void onClick(View v){
        ArrayList<IndustryModule> industryBeans = new ArrayList<>();
        for(int i = 0 ; i < 12 ; i ++){
            industryBeans.add(new IndustryBean("条目" + i,"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2001382863,1289112909&fm=26&gp=0.jpg"));
        }
        industryView.updateDatas(industryBeans);
    }
}
