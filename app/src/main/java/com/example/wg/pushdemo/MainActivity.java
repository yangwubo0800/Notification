package com.example.wg.pushdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.wg.utils.NotificationUtils;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Button sendNotification = (Button)findViewById(R.id.send_notification);
        Button jpush = (Button)findViewById(R.id.jump_jpush);
        Button clearNotification = (Button)findViewById(R.id.clear_notification);
        Button sendMultiNotification = (Button)findViewById(R.id.send_multi_notification);
        Button sendCustomNotification = (Button)findViewById(R.id.send_custom_notification);
        sendNotification.setOnClickListener(myListener);
        jpush.setOnClickListener(myListener);
        clearNotification.setOnClickListener(myListener);
        sendMultiNotification.setOnClickListener(myListener);
        sendCustomNotification.setOnClickListener(myListener);

    }

    private View.OnClickListener myListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.send_notification:
                    new Handler().post(new Runnable() {
                        @Override
                        public void run() {
                            NotificationUtils.getInstance(MainActivity.this).setNotificationTitle("notification title");
                            NotificationUtils.getInstance(MainActivity.this).setNotificationContent("notification content");
                            NotificationUtils.getInstance(MainActivity.this).sendNotification(null, 1);
                        }
                    });
                    break;
                case R.id.jump_jpush:
                    Intent it = new Intent(MainActivity.this,
                            com.example.jpushdemo.MainActivity.class);
                    startActivity(it);
                    break;
                case R.id.clear_notification:
                    NotificationUtils.getInstance(MainActivity.this).clearNotification();
                    break;
                case R.id.send_multi_notification:
                    for(int i=0; i<3; i++) {
                        NotificationUtils.getInstance(MainActivity.this).setNotificationTitle("notification title " + i);
                        NotificationUtils.getInstance(MainActivity.this).setNotificationContent("notification content " + i);
                        NotificationUtils.getInstance(MainActivity.this).sendNotification(null, i+1000);
                    }
                    break;
                case R.id.send_custom_notification:
                    NotificationUtils.getInstance(MainActivity.this).sendCustomNotification();
                    break;
                default:
                    break;
            }
        }
    };
}
