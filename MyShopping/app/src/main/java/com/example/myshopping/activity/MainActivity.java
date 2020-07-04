package com.example.myshopping.activity;

import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.myshopping.adapter.MyFramgmentPagerAdapter;
import com.example.myshopping.R;
import com.example.myshopping.fragment.CartFragment;
import com.example.myshopping.fragment.HomePageFragment;
import com.example.myshopping.fragment.MenuFragment;
import com.example.myshopping.receiver.MyBroadcastReceiver;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Fragment> fragmentList=new ArrayList<>();
    private BottomNavigationView bottomNavigationView;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化ViewPager显示的Fragment
        initViewPager();
        initBottomNavigationView();
        initBroadcastReceiver();
    }

    private void initBroadcastReceiver() {
        MyBroadcastReceiver receiver=new MyBroadcastReceiver();
        IntentFilter filter=new IntentFilter();
        filter.addAction("totalPrice");
        registerReceiver(receiver,filter);
    }

    private void initBottomNavigationView() {
        //初始化BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setItemIconTintList(null);  //把底部导航菜单图标以原图方式显示
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            //当选中菜单项触发事件
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               //判断用户点击了第几个底部导航菜单项
                switch (item.getItemId()){
                    case R.id.menu_homepage:
                        //设置当前ViewPager显示第几个页面
                        viewPager.setCurrentItem(0,false);
                        break;
                    case R.id.menu_menu:
                        viewPager.setCurrentItem(1,false);
                        break;
                    case R.id.menu_cart:
                        viewPager.setCurrentItem(2,false);
                        break;
                }
                return true;
            }
        });
    }

    //初始化ViewPager显示的Fragment
    private void initViewPager() {
        HomePageFragment homePageFragment=new HomePageFragment();
        fragmentList.add(homePageFragment);
        MenuFragment menuFragment=new MenuFragment();
        fragmentList.add(menuFragment);
        CartFragment cartFragment=new CartFragment();
        fragmentList.add(cartFragment);

        //找viewPager控件
        viewPager = findViewById(R.id.viewPager);
        //创建适配器对象
        MyFramgmentPagerAdapter adapter=new MyFramgmentPagerAdapter(getSupportFragmentManager(),fragmentList);
        //设置适配器
        viewPager.setAdapter(adapter);

        //为ViewPager添加左右滑动的监听事件
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //当显示的页面给选中（给客户看）--改变底部导航的图标属性
            @Override
            public void onPageSelected(int position) {
                //获取bottomNavigationVeiw的菜单项
                Menu menu=bottomNavigationView.getMenu();
                //获取菜单项的子项
                MenuItem menuItem=menu.getItem(position);
                //改变被选中的菜单子项的状态
                menuItem.setChecked(true);

                //bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
