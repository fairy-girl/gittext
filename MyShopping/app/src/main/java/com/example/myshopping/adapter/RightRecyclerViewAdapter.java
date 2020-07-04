package com.example.myshopping.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myshopping.bean.Information;
import com.example.myshopping.R;
import com.example.myshopping.fragment.CartFragment;

import java.util.ArrayList;
import java.util.List;

public class RightRecyclerViewAdapter extends RecyclerView.Adapter<RightRecyclerViewAdapter.ViewHolder> {
    List<Information>rightList;

    public RightRecyclerViewAdapter(List<Information> rightList) {
        this.rightList = rightList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.right_item,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(itemview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        Information information=rightList.get(i);
        viewHolder.NameTV.setText(information.getName());
        viewHolder.ImageView.setImageResource(information.getImageViewID());
        viewHolder.PriceTV.setText(String.valueOf(information.getPrice()));
        //右列表子项的按钮点击事件
        viewHolder.imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取当前子项的商品信息（商品的实体类对象）
               Information goodInformation= rightList.get(i);
               //创建一个临时集合存储商品，通过遍历临时集合，如果发生同一个对象的去重操作
                List<Information> list=new ArrayList<>();
                list.add(goodInformation);
                for (int i=0;i<list.size();i++){
                    Information information=list.get(i);  //遍历过程中把每一个集合对象获取到
                    //如果购物车列表的数据源集合不包含商品对象
                    if (!CartFragment.goodList.contains(information)){
                        //把获取到的选中子项商品添加购物车页面的列表的数据源中
                        CartFragment.goodList.add(goodInformation);
                    }
                }
                Toast.makeText(view.getContext(), goodInformation.getName()+"已加入购物车", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return rightList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView NameTV,PriceTV;
        ImageView ImageView;
        ImageView imageView3;
        public ViewHolder(View itemView) {
            super(itemView);
            NameTV=itemView.findViewById(R.id.nameTV);
            PriceTV=itemView.findViewById(R.id.priceTV);
            ImageView=itemView.findViewById(R.id.imageView);
            imageView3=itemView.findViewById(R.id.imageView3);
        }
    }
}
