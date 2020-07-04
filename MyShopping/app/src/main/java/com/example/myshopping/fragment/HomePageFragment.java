package com.example.myshopping.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.myshopping.R;
import com.example.myshopping.adapter.MyPageAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class HomePageFragment extends Fragment {
    List<View> dotsList;
    List<ImageView> imageViewList;
    private  int[] imageIds=new int[]{R.drawable.timg2,R.drawable.timg3,R.drawable.timg4};
    private ViewPager viewPager;
    int currentItem=0;
    private ScheduledExecutorService scheduledExecutorService;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_homepage,container,false);

        //点的View对象保存到集合中
        View view0=view.findViewById(R.id.dot_0);
        View view1=view.findViewById(R.id.dot_1);
        View view2=view.findViewById(R.id.dot_2);
        dotsList=new ArrayList<>();
        dotsList.add(view0);
        dotsList.add(view1);
        dotsList.add(view2);

        //ViewPage中的图片保存到集合中
        imageViewList=new ArrayList<>();
        for (int i=0;i<imageIds.length;i++){
            ImageView imageView=new ImageView(getActivity());
            imageView.setBackgroundResource(imageIds[i]);
            imageViewList.add(imageView);
        }


         //找到ViewPage控件
        viewPager = view.findViewById(R.id.vp);
        MyPageAdapter adapter=new MyPageAdapter(imageViewList);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //
                for (int i=0;i<dotsList.size();i++){
                    if (i==position){
                        dotsList.get(position).setBackgroundResource(R.drawable.point_selected);
                    }else {
                        dotsList.get(i).setBackgroundResource(R.drawable.point_unselected);
                    }
                }
                //记录ViewPage页面改变的位置
                currentItem=position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        //执行线程任务
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                //发送消息--设置当前ViewPage显示页面
                currentItem=(currentItem+1)%imageIds.length;
                handler.sendEmptyMessage(0);
            }
        },1,1, TimeUnit.SECONDS);
    }
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            viewPager.setCurrentItem(currentItem);
        }
    };

    @Override
    public void onStop() {
        super.onStop();
        if (scheduledExecutorService!=null){
            scheduledExecutorService.shutdown();//让线程服务停止
            scheduledExecutorService=null;
        }
    }
}
