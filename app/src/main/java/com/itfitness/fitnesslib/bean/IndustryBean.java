package com.itfitness.fitnesslib.bean;

/**
 * @ProjectName: IndustryView
 * @Package: com.itfitness.industryview.bean
 * @ClassName: IndustryBean
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2020/9/13 11:12
 * @UpdateUser: 更新者：itfitness
 * @UpdateDate: 2020/9/13 11:12
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class IndustryBean implements IndustryModule {
    private String name;
    private String imgUrl;

    public IndustryBean(String name, String imgUrl) {
        this.name = name;
        this.imgUrl = imgUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getImgUrl() {
        return imgUrl;
    }
}
