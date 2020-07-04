package com.example.myshopping.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myshopping.bean.Information;
import com.example.myshopping.R;
import com.example.myshopping.adapter.LeftRecyclerViewAdapter;
import com.example.myshopping.adapter.RightRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class MenuFragment extends Fragment {

    List<String> leftList=new ArrayList<>();
    public static List<Information> rightList=new ArrayList<>();
    public static List<Information> rightList2=new ArrayList<>();
    public static List<Information> rightList3=new ArrayList<>();
    public static List<Information> rightList4=new ArrayList<>();
    public static List<Information> rightList5=new ArrayList<>();
    public static List<Information> rightList6=new ArrayList<>();
    public static List<Information> rightList7=new ArrayList<>();
    public static List<Information> rightList8=new ArrayList<>();
    public static List<Information> rightList9=new ArrayList<>();
    public static List<Information> rightList10=new ArrayList<>();
    public static List<Information> rightList11=new ArrayList<>();
    public static List<Information> rightList12=new ArrayList<>();
    public static List<Information> rightList13=new ArrayList<>();
    public static RecyclerView rightRecyclerView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_menu,container,false);

        initLeftData();
        initRightData();
        initRightData2();
        initRightData3();
        initRightData4();
        initRightData5();
        initRightData6();
        initRightData7();
        initRightData8();
        initRightData9();
        initRightData10();
        initRightData11();
        initRightData12();
        initRightData13();
        //找RecyclerView控件对象
        RecyclerView leftRecyclerView=view.findViewById(R.id.leftRecyclerView);
         rightRecyclerView=view.findViewById(R.id.rightRecyclerView);
        //设置布局管理器
        leftRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        rightRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        //设置适配器
        leftRecyclerView.setAdapter(new LeftRecyclerViewAdapter(leftList));
        rightRecyclerView.setAdapter(new RightRecyclerViewAdapter(rightList));
        //添加分割线
        leftRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        rightRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL));
        return view;
    }




    private void initLeftData() {
            leftList.add("洗面奶");
            leftList.add("面膜");
            leftList.add("水乳霜");
            leftList.add("防晒霜");
            leftList.add("隔离霜");
            leftList.add("遮瑕");
            leftList.add("粉底液");
            leftList.add("气垫");
            leftList.add("散粉");
            leftList.add("腮红");
            leftList.add("眼影");
            leftList.add("眉笔");
            leftList.add("口红");
    }
    private void initRightData() {
        rightList.add(new Information(R.drawable.p1,"赫丽尔斯","209",0 ));
        rightList.add(new Information(R.drawable.p2,"elta","137" ,0));
        rightList.add(new Information(R.drawable.p3,"悦诗风吟","79",0));
        rightList.add(new Information(R.drawable.p4,"菲诗小铺","36" ,0));
        rightList.add(new Information(R.drawable.p5,"AHC","59",0 ));
        rightList.add(new Information(R.drawable.p6,"UNNY","69" ,0));
        rightList.add(new Information(R.drawable.p7,"芙丽芳丝","119",0 ));
        rightList.add(new Information(R.drawable.p8,"SK-II","799" ,0));
        rightList.add(new Information(R.drawable.p9,"科润","109" ,0));
        }
    private void initRightData2() {
        rightList2.add(new Information(R.drawable.m1, "小迷糊", "59",0));
        rightList2.add(new Information(R.drawable.m2, "SK-II", "199",0));
        rightList2.add(new Information(R.drawable.m3, "JM急救", "69",0));
        rightList2.add(new Information(R.drawable.m4, "可莱丝", "79",0));
        rightList2.add(new Information(R.drawable.m5, "WIS", "99",0));
        rightList2.add(new Information(R.drawable.m7, "素肌秘", "56",0));
    }
    private void initRightData3() {
        rightList3.add(new Information(R.drawable.s1, "AHC", "179",0));
        rightList3.add(new Information(R.drawable.s2, "SK-II", "1790",0));
        rightList3.add(new Information(R.drawable.s3, "兰芝", "399",0));
        rightList3.add(new Information(R.drawable.s4, "悦诗风吟", "269",0));
        rightList3.add(new Information(R.drawable.s5, "呼吸", "179",0));
        rightList3.add(new Information(R.drawable.s6, "欧惠","899",0));
    }
    private void initRightData4() {
        rightList4.add(new Information(R.drawable.f1, "安耐晒", "169",0));
        rightList4.add(new Information(R.drawable.f2, "Za", "119",0));
        rightList4.add(new Information(R.drawable.f3, "近江兄弟", "36",0));
    }
    private void initRightData5() {
        rightList5.add(new Information(R.drawable.g1, "悦诗风吟", "89",0));
        rightList5.add(new Information(R.drawable.g2, "兰芝", "139",0));
        rightList5.add(new Information(R.drawable.g3, "苏菲娜", "89",0));
    }
    private void initRightData6() {
        rightList6.add(new Information(R.drawable.z1, "得鲜", "39",0));
        rightList6.add(new Information(R.drawable.z2, "UNNY", "49",0));
        rightList6.add(new Information(R.drawable.z3, "黛玛寇", "129",0));
    }
    private void initRightData7() {
        rightList7.add(new Information(R.drawable.d1, "Dior", "339",0));
        rightList7.add(new Information(R.drawable.d2, "YSL", "229",0));
        rightList7.add(new Information(R.drawable.d3, "阿玛尼", "599",0));
        rightList7.add(new Information(R.drawable.d4, "完美日记", "79",0));
    }
    private void initRightData8() {
        rightList8.add(new Information(R.drawable.q1, "悦诗风吟", "159",0));
        rightList8.add(new Information(R.drawable.q2, "兰芝", "139",0));
        rightList8.add(new Information(R.drawable.q3, "老虎", "189",0));
        rightList8.add(new Information(R.drawable.q4, "透密", "89",0));
    }
    private void initRightData9() {
        rightList9.add(new Information(R.drawable.b1, "悦诗风吟", "39",0));
        rightList9.add(new Information(R.drawable.b2, "纪梵希", "89",0));
        rightList9.add(new Information(R.drawable.b3, "花西子", "129",0));
    }
    private void initRightData10() {
        rightList10.add(new Information(R.drawable.h1, "香奈儿", "256",0));
        rightList10.add(new Information(R.drawable.h2, "橘朵", "19",0));
        rightList10.add(new Information(R.drawable.h3, "MAC", "198",0));
    }
    private void initRightData11() {
        rightList11.add(new Information(R.drawable.y1, "橘朵", "19",0));
        rightList11.add(new Information(R.drawable.y2, "完美日记", "69",0));
    }
    private void initRightData12() {
        rightList12.add(new Information(R.drawable.j1, "悦诗风吟", "39",0));
        rightList12.add(new Information(R.drawable.j2, "爱丽小屋", "29",0));
    }
    private void initRightData13() {
        rightList13.add(new Information(R.drawable.k1,"dior","399",0));
        rightList13.add(new Information(R.drawable.k2,"mac","178",0));
        rightList13.add(new Information(R.drawable.k3,"ysl","266",0));
    }


}







