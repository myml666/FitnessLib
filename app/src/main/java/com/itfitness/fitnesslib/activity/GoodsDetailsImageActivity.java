package com.itfitness.fitnesslib.activity;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.itfitness.fitnesslib.R;
import com.itfitness.fitnesslib.bean.GoodsDetailsImageBean;
import com.itfitness.ftlib.widget.goodsdetailsview.GoodsDetailsImageListView;
import com.itfitness.ftlib.widget.simplelistview.SimpleListView;

import java.util.ArrayList;

public class GoodsDetailsImageActivity extends AppCompatActivity {
    private GoodsDetailsImageListView gdv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodsdetailsimage);
        gdv = findViewById(R.id.activity_goodsdetailsimage_gdv);
        initAdapter();
    }
    private void initAdapter() {
        ArrayList<GoodsDetailsImageBean> imgs = new ArrayList();
        imgs.add(new GoodsDetailsImageBean("https://img30.360buyimg.com/vc/jfs/t1/112804/24/9911/1397445/5ee33f26Edcedbe3d/64e6b563847632ce.jpg","第一张图"));
        imgs.add(new GoodsDetailsImageBean("https://img30.360buyimg.com/vc/jfs/t1/95426/16/18104/35361/5e8ed7bfE5555f504/caf9e65c440613e8.jpg","第二张图"));
        gdv.setImgDatas(imgs);
        gdv.setOnItemClickListener(new SimpleListView.OnItemClickListener<GoodsDetailsImageBean>() {
            @Override
            public void onItemClick(int position, GoodsDetailsImageBean data) {
                Toast.makeText(GoodsDetailsImageActivity.this, data.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
