package com.example.myshopping.receiver;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.example.myshopping.R;
import com.example.myshopping.activity.NotificationActivity;

public class MyBroadcastReceiver extends BroadcastReceiver {

    //当接收到广播后触发
    @Override
    public void onReceive(Context context, Intent intent) {
        int money=intent.getIntExtra("totalPrice",0);
        Toast.makeText(context, "已支付"+money+"RMB", Toast.LENGTH_SHORT).show();

        //点击通知后跳转页面
        Intent intent1=new Intent(context, NotificationActivity.class);
        PendingIntent pi=PendingIntent.getActivity(context,0,intent1,0);

        //通知栏弹出通知
        NotificationManager manager=(NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);//获取系统服务--管理通知栏
        //判断手机版本
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            //通知栏适配
            //第一个参数：content
            //第二个参数：channelId
            Notification notification=new NotificationCompat.Builder(context,"1")
                    .setContentTitle("支付APP")
                    .setContentText("已支付"+money+"RMB")
                    .setWhen(System.currentTimeMillis())
                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher))
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setAutoCancel(true)//点击通知后通知栏的消息自动消失
                    .setContentIntent(pi)//点击通知后跳转到指定的组件（Activity）
                    .build();

            //创建NotificationChannel
            //第一个参数：channelId
            //第二个参数：通知名称
            //第三个参数：通知的重要性
            NotificationChannel channel=new NotificationChannel("1","微信支付",NotificationManager.IMPORTANCE_HIGH);
            //创建通知渠道
            manager.createNotificationChannel(channel);
            //弹出通知
            manager.notify(1,notification);
        }else {
            Notification notification=new NotificationCompat.Builder(context).setContentTitle("支付APP")
                    .setContentText("已支付"+money+"RMB")
                    .setWhen(System.currentTimeMillis())
                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher))
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setAutoCancel(true)
                    .setContentIntent(pi)//点击通知后跳转到指定的组件（Activity）
                    .build();
            manager.notify(1,notification);
        }
    }
}
