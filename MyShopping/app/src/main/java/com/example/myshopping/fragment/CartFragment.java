package com.example.myshopping.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myshopping.R;
import com.example.myshopping.adapter.CartRecyclerViewAdapter;
import com.example.myshopping.bean.Information;
import com.example.myshopping.inteface.OnDataChangeListener;

import java.util.ArrayList;
import java.util.List;


public class CartFragment extends BaseFragment {
    private RecyclerView cartRecyclerView;
    public static List<Information> goodList=new ArrayList<>();
    private CartRecyclerViewAdapter adapter;
    private TextView totalPriceTV;
    private int totalPrice;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_cart,container,false);
      //  goodList.add(new Information(R.drawable.m1,"s","2"));

        //找提交订单按钮控件对象
        Button confirmBtn=view.findViewById(R.id.confirmBtn);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction("totalPrice");
                intent.putExtra("totalPrice",totalPrice);//让intent携带总金额数据一并发送广播给接收器
                //发送广播
                getActivity().sendBroadcast(intent);
            }
        });

        totalPriceTV = view.findViewById(R.id.totalPriceTV);
         cartRecyclerView=view.findViewById(R.id.cartRecyclerView);
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        adapter = new CartRecyclerViewAdapter(goodList);
        cartRecyclerView.setAdapter(adapter);
        cartRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),LinearLayoutManager.VERTICAL));
        //对适配器进行监听
        adapter.setOnDataChangeListener(new OnDataChangeListener() {


            @Override
            public void add(int num, int price) {
                //当数量发生增加的时候，计算总价格
                totalPrice = totalPrice +num*price;
                totalPriceTV.setText(totalPrice+"");
            }
            @Override
            public void minus(int num, int price) {
                //之前的总价格+增量*单价
                totalPrice = totalPrice -num*price;
                totalPriceTV.setText(totalPrice+"");
            }
            @Override
            public void clear(int num, int price) {
                //当商品被删除时，计算总价格
                //之前的总价格-数量*单价
                totalPrice=totalPrice-num*price;
                totalPriceTV.setText(totalPrice+"");
            }
        });
        return view;
    }

    //当碎片第一次出现在用户面前触发的基类方法
    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        cartRecyclerView.setAdapter(adapter);
    }

    //当碎片非第一次出现在用户面前触发的基类方法
    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        super.onFragmentVisibleChange(isVisible);
        cartRecyclerView.setAdapter(adapter);
    }


}
