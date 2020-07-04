package com.example.myshopping.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myshopping.R;
import com.example.myshopping.fragment.MenuFragment;

import java.util.List;

public class LeftRecyclerViewAdapter extends RecyclerView.Adapter<LeftRecyclerViewAdapter.ViewHolder> {
    List<String> leftList;

    public LeftRecyclerViewAdapter(List<String> leftList) {
        this.leftList = leftList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.left_item,viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(itemview);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        String str=leftList.get(i);
        viewHolder.leftNameTV.setText(str);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (i){
                    case 0:
                        MenuFragment.rightRecyclerView.setAdapter(new RightRecyclerViewAdapter(MenuFragment.rightList));
                        break;
                    case 1:
                        MenuFragment.rightRecyclerView.setAdapter(new RightRecyclerViewAdapter(MenuFragment.rightList2));
                        break;
                    case 2:
                        MenuFragment.rightRecyclerView.setAdapter(new RightRecyclerViewAdapter(MenuFragment.rightList3));
                        break;
                    case 3:
                        MenuFragment.rightRecyclerView.setAdapter(new RightRecyclerViewAdapter(MenuFragment.rightList4));
                        break;
                    case 4:
                        MenuFragment.rightRecyclerView.setAdapter(new RightRecyclerViewAdapter(MenuFragment.rightList5));
                        break;
                    case 5:
                        MenuFragment.rightRecyclerView.setAdapter(new RightRecyclerViewAdapter(MenuFragment.rightList6));
                        break;
                    case 6:
                        MenuFragment.rightRecyclerView.setAdapter(new RightRecyclerViewAdapter(MenuFragment.rightList7));
                        break;
                    case 7:
                        MenuFragment.rightRecyclerView.setAdapter(new RightRecyclerViewAdapter(MenuFragment.rightList8));
                        break;
                    case 8:
                        MenuFragment.rightRecyclerView.setAdapter(new RightRecyclerViewAdapter(MenuFragment.rightList9));
                        break;
                    case 9:
                        MenuFragment.rightRecyclerView.setAdapter(new RightRecyclerViewAdapter(MenuFragment.rightList10));
                        break;
                    case 10:
                        MenuFragment.rightRecyclerView.setAdapter(new RightRecyclerViewAdapter(MenuFragment.rightList11));
                        break;
                    case 11:
                        MenuFragment.rightRecyclerView.setAdapter(new RightRecyclerViewAdapter(MenuFragment.rightList12));
                        break;
                    case 12:
                        MenuFragment.rightRecyclerView.setAdapter(new RightRecyclerViewAdapter(MenuFragment.rightList13));
                        default:
                            break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return leftList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView leftNameTV;
        View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView=itemView;  //子项视图对象缓存
            leftNameTV=itemView.findViewById(R.id.name1);
        }
    }
}
