package com.itfitness.fitnesslib.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @ProjectName: o2o_user_android
 * @Package: com.jinyou.o2o.adapter.easyinfo
 * @ClassName: EasyInfoFragmentAdapter
 * @Description: java类作用描述 Fragment的适配器
 * @Author: 作者名
 * @CreateDate: 2019/12/19 8:53
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019/12/19 8:53
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class FTFragmentAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;
    public FTFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
