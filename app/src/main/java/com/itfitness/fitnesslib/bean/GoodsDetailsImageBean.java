package com.itfitness.fitnesslib.bean;


import com.itfitness.ftlib.widget.goodsdetailsview.GoodsDetailsImageItemModulImpl;

/**
 * @ProjectName: GoodsDetailsView
 * @Package: com.itfitness.goodsdetailsview.bean
 * @ClassName: GoodsDetailsImageBean
 * @Description: java类作用描述 实现了GoodsDetailsModulImpl接口(商品详情实体类)
 * @Author: 作者名
 * @CreateDate: 2020/7/11 23:28
 * @UpdateUser: 更新者：itfitness
 * @UpdateDate: 2020/7/11 23:28
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class GoodsDetailsImageBean implements GoodsDetailsImageItemModulImpl {
    private String imgUrl;
    private String name;

    public GoodsDetailsImageBean(String imgUrl, String name) {
        this.imgUrl = imgUrl;
        this.name = name;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getImgUrl() {
        return imgUrl;
    }
}
