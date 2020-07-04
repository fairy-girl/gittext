package com.example.myshopping.inteface;
//监听列表的数量发生改变
public interface OnDataChangeListener {
    //当数量增加时会发生金额添加
    //第一个参数：增量
    //第二个参数：单价
    void add(int num,int price);
    //当数量减少时会发生金额减少
    //第一个参数：增量
    //第二个参数：单价
    void minus(int num,int price);

    void clear(int num,int price);
}
