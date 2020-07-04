package com.example.myshopping.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.List;

public class MyFramgmentPagerAdapter extends FragmentPagerAdapter {

    List<Fragment>fragmentList;
    FragmentManager fragmentManager;

    public MyFramgmentPagerAdapter(FragmentManager fm,List<Fragment> list) {
        super(fm);
        fragmentManager=fm;
        fragmentList=list;
    }

    //初始化ViewPager中当前要显示的Fragment
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Fragment fragment= (Fragment) super.instantiateItem(container, position);
        //把将要显示给用户看的碎片重新显示
        fragmentManager.beginTransaction().show(fragment).commit();
        return fragment;
    }
    //销毁不出现在用户面前的Fragment
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
        //获取将要销毁的碎片对象
        Fragment fragment=fragmentList.get(position);
        //隐藏准备被销毁的碎片（并非真正的销毁）
        fragmentManager.beginTransaction().hide(fragment).commit();
    }

    //获取当前显示的是哪个Fragment
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    //返回viewPager显示的Fragment的数量
    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
