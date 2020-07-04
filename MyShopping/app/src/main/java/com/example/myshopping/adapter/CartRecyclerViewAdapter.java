package com.example.myshopping.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myshopping.R;
import com.example.myshopping.bean.Information;
import com.example.myshopping.inteface.OnDataChangeListener;

import java.util.List;

public class CartRecyclerViewAdapter extends RecyclerView.Adapter<CartRecyclerViewAdapter.ViewHolder> {

    List<Information> cartList;
    private int newCount;

    //定义接口变量
    private OnDataChangeListener dataChangeListener;

    //获取接口对象
    public void setOnDataChangeListener(OnDataChangeListener mDataChangListener){
        this.dataChangeListener=mDataChangListener;

    }

    public CartRecyclerViewAdapter(List<Information> cartList) {
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_item,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(itemview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {

        final Information good=cartList.get(i);
        viewHolder.img.setImageResource(good.getImageViewID());
        viewHolder.goodNameTV.setText(good.getName());
        viewHolder.goodPriceTV.setText(good.getPrice());
        viewHolder.countTV.setText(good.getCount()+"");
        //对+的按钮设置点击事件
        viewHolder.addTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取之前的数量
               int oldCount=good.getCount();
               //在修改前的基础上+1
                newCount = oldCount+1;
                good.setCount(newCount);
               //重新设置文本内容
                viewHolder.countTV.setText(newCount +"");
                //如果监听对象不为空，代表数据发生改变
                if (dataChangeListener!=null){
                    dataChangeListener.add(newCount-oldCount,Integer.parseInt(viewHolder.goodPriceTV.getText().toString()));
                }

            }
        });

        //对—的按钮设置点击事件
        viewHolder.minTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取之前的数量
                int oldCount=good.getCount();
                if (oldCount==0){
                    Toast.makeText(view.getContext(),"该商品数量已经为0！",Toast.LENGTH_SHORT).show();
                    return;
                }
                //在修改前的基础上-1
                 newCount=oldCount-1;
                good.setCount(newCount);
                //重新设置文本内容
                viewHolder.countTV.setText(newCount+"");
                //如果监听对象不为空，代表数据发生改变
                if (dataChangeListener!=null){
                    dataChangeListener.minus(oldCount-newCount,Integer.parseInt(viewHolder.goodPriceTV.getText().toString()));
                }

            }
        });

        viewHolder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartList.remove(i);
                notifyDataSetChanged();

                if (dataChangeListener!=null){
                    dataChangeListener.clear(good.getCount(),Integer.parseInt(viewHolder.goodPriceTV.getText().toString()));
                    good.setCount(0);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

     public class ViewHolder extends RecyclerView.ViewHolder{
        TextView goodNameTV,goodPriceTV,minTV,countTV,addTV;
        ImageView img;
        Button deleteBtn;


        public ViewHolder(View itemView) {
            super(itemView);
            goodNameTV=itemView.findViewById(R.id.goodNameTV);
            goodPriceTV=itemView.findViewById(R.id.goodPriceTV);
            img=itemView.findViewById(R.id.img);
            minTV=itemView.findViewById(R.id.minTV);
            countTV=itemView.findViewById(R.id.countTV);
            addTV=itemView.findViewById(R.id.addTV);
            deleteBtn=itemView.findViewById(R.id.deleteBtn);
        }
    }
}
