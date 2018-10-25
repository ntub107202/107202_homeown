package ntub107202.hostel;

import android.app.FragmentTransaction;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Fragment_Humansearch Fragment1HumanSearch;
    private Fragment_Jobview Fragment2JobView;
    private Fragment_Inbox Fragment3Inbox;
    private Fragment_Calenderview Fragment4CalenderView;
    private Fragment_Bosssetting Fragment5BossSetting;
    BottomNavigationView navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Log.v("text", "abc");

            switch (item.getItemId()) {
                case R.id.navigation_people:
                    getWorksheet.gethumansearchJSON();
                    mTextMessage.setText("");
                    showNav(R.id.navigation_people);
                    return true;
                case R.id.navigation_publish:
                    getWorksheet.getjobJSON();
                    mTextMessage.setText("");
                    showNav(R.id.navigation_publish);
                    return true;
                case R.id.navigation_inbox:
                    getWorksheet.getjobJSON();
                    mTextMessage.setText("");
                    showNav(R.id.navigation_inbox);
                    return true;
                case R.id.navigation_work:
                    getWorksheet.getjobJSON();
                    mTextMessage.setText("");
                    showNav(R.id.navigation_work);
                    return true;
                case R.id.navigation_page:
                    mTextMessage.setText("");
                    showNav(R.id.navigation_page);
                    return true;
            }
            return false;
        }

    };

    @Override
    public void onBackPressed() {
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        init();
        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        String user = getSharedPreferences("userpw", MODE_PRIVATE).getString("USER", "");
        String pw = getSharedPreferences("userpw", MODE_PRIVATE).getString("PW", "");
        Log.v("useraa", user);
        Log.v("useraa", pw);
//        final int notifyID = 1; // 通知的識別號碼
//        final NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE); // 取得系統的通知服務
//        final Notification notification = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.logo1).setContentTitle("我是凱偉").setContentText("我想吃小寶屌").build(); // 建立通知
//        notificationManager.notify(notifyID, notification); // 發送通知
//        Intent notifyIntent = new Intent(NavigationActivity.this, NavigationActivity.class);
//        notifyIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        PendingIntent appIntent
//                = PendingIntent.getActivity(NavigationActivity.this, 0, notifyIntent, 0);
        NotificationManager mNotificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        //Step2. 設定當按下這個通知之後要執行的activity
        Intent notifyIntent = new Intent(NavigationActivity.this, NavigationActivity.class);
        notifyIntent.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK);
        PendingIntent appIntent = PendingIntent.getActivity(NavigationActivity.this, 0, notifyIntent, 0);
        Notification notification
                = new Notification.Builder(NavigationActivity.this)
                .setContentIntent(appIntent)
                .setSmallIcon(R.drawable.logo1) // 設置狀態列裡面的圖示（小圖示）　　
                .setLargeIcon(BitmapFactory.decodeResource(NavigationActivity.this.getResources(), R.drawable.logo2)) // 下拉下拉清單裡面的圖示（大圖示）
                .setTicker("notification on status bar.") // 設置狀態列的顯示的資訊
                .setWhen(System.currentTimeMillis())// 設置時間發生時間
                .setAutoCancel(false) // 設置通知被使用者點擊後是否清除  //notification.flags = Notification.FLAG_AUTO_CANCEL;
                .setContentTitle("Notification Title") // 設置下拉清單裡的標題
                .setContentText("Notification Content")// 設置上下文內容
                .setOngoing(true)      //true使notification变为ongoing，用户不能手动清除  // notification.flags = Notification.FLAG_ONGOING_EVENT; notification.flags = Notification.FLAG_NO_CLEAR;

                .setDefaults(Notification.DEFAULT_ALL) //使用所有默認值，比如聲音，震動，閃屏等等
                 .setDefaults(Notification.DEFAULT_VIBRATE) //使用默認手機震動提示
                 .setDefaults(Notification.DEFAULT_SOUND) //使用默認聲音提示
                 .setDefaults(Notification.DEFAULT_LIGHTS) //使用默認閃光提示
                 .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND) //使用默認閃光提示 與 默認聲音提示

//                 .setVibrate(vibrate) //自訂震動長度
//                 .setSound(uri) //自訂鈴聲
                 .setLights(0xff00ff00, 300, 1000) //自訂燈光閃爍 (ledARGB, ledOnMS, ledOffMS)
                                .build();

//把指定ID的通知持久的發送到狀態條上
        notification.flags = Notification.FLAG_ONGOING_EVENT;

        // 表明在點擊了通知欄中的"清除通知"後，此通知不清除，
        // 經常與FLAG_ONGOING_EVENT一起使用
        notification.flags = Notification.FLAG_NO_CLEAR;

        //閃爍燈光
        notification.flags = Notification.FLAG_SHOW_LIGHTS;

        // 重複的聲響,直到用戶響應。
        notification.flags = Notification.FLAG_INSISTENT;


        // 把指定ID的通知持久的發送到狀態條上.
        mNotificationManager.notify(0, notification);

        // 取消以前顯示的一個指定ID的通知.假如是一個短暫的通知，
        // 試圖將之隱藏，假如是一個持久的通知，將之從狀態列中移走.
//              mNotificationManager.cancel(0);

        //取消以前顯示的所有通知.
//              mNotificationManager.cancelAll();
    }

    @Override
    public void onResume() {
        getWorksheet.gethumansearchJSON();
        getWorksheet.getjobJSON();
        getWorksheet.getcalendarJSON();
        getWorksheet.gethostelinfoJSON();
        getWorksheet.getResumeJSON();
        int id = getIntent().getIntExtra("id", 0);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        switch (id) {
            case 1:
                beginTransaction.hide(Fragment2JobView).hide(Fragment3Inbox).hide(Fragment4CalenderView).hide(Fragment5BossSetting);
                beginTransaction.show(Fragment1HumanSearch);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                navigation.getMenu().getItem(0).setChecked(true);
                break;
            case 2:
                beginTransaction.hide(Fragment1HumanSearch).hide(Fragment3Inbox).hide(Fragment4CalenderView).hide(Fragment5BossSetting);
                beginTransaction.show(Fragment2JobView);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                navigation.getMenu().getItem(1).setChecked(true);
                break;
            case 3:
                beginTransaction.hide(Fragment2JobView).hide(Fragment1HumanSearch).hide(Fragment5BossSetting).hide(Fragment4CalenderView);
                beginTransaction.show(Fragment3Inbox);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                navigation.getMenu().getItem(2).setChecked(true);
                break;
            case 4:
                beginTransaction.hide(Fragment2JobView).hide(Fragment3Inbox).hide(Fragment1HumanSearch).hide(Fragment5BossSetting);
                beginTransaction.show(Fragment4CalenderView);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                navigation.getMenu().getItem(2).setChecked(true);
                break;
            case 5:
                beginTransaction.hide(Fragment1HumanSearch).hide(Fragment2JobView).hide(Fragment3Inbox).hide(Fragment4CalenderView);
                beginTransaction.show(Fragment5BossSetting);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                mTextMessage.setText("");
                showNav(R.id.navigation_page);
                navigation.getMenu().getItem(3).setChecked(true);
                break;
        }

        super.onResume();
    }

    //    @Override
//    protected void onStart() {
//        super.onStart();
//        getWorksheet.getjobJSON();
//        // The activity is about to become visible.
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        getWorksheet.getjobJSON();
//        // The activity has become visible (it is now "resumed").
//    }
    //init（）用来初始化组件
    private void init() {
        Fragment1HumanSearch = new Fragment_Humansearch();
        Fragment2JobView = new Fragment_Jobview();
        Fragment3Inbox = new Fragment_Inbox();
        Fragment4CalenderView = new Fragment_Calenderview();
        Fragment5BossSetting = new Fragment_Bosssetting();
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.add(R.id.content, Fragment1HumanSearch).add(R.id.content, Fragment2JobView).add(R.id.content, Fragment3Inbox).add(R.id.content, Fragment4CalenderView).add(R.id.content, Fragment5BossSetting);//开启一个事务将fragment动态加载到组件
        beginTransaction.hide(Fragment1HumanSearch).hide(Fragment2JobView).hide(Fragment3Inbox).hide(Fragment4CalenderView).hide(Fragment5BossSetting);//隐藏fragment
        beginTransaction.addToBackStack(null);//返回到上一个显示的fragment
        beginTransaction.commit();//每一个事务最后操作必须是commit（），否则看不见效果
        showNav(R.id.navigation_people);

    }

    private void showNav(int navid) {
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        switch (navid) {
            case R.id.navigation_people:
                beginTransaction.hide(Fragment2JobView).hide(Fragment3Inbox).hide(Fragment4CalenderView).hide(Fragment5BossSetting);
                beginTransaction.show(Fragment1HumanSearch);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.navigation_publish:
                beginTransaction.hide(Fragment1HumanSearch).hide(Fragment3Inbox).hide(Fragment4CalenderView).hide(Fragment5BossSetting);
                beginTransaction.show(Fragment2JobView);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.navigation_inbox:
                beginTransaction.hide(Fragment1HumanSearch).hide(Fragment2JobView).hide(Fragment4CalenderView).hide(Fragment5BossSetting);
                beginTransaction.show(Fragment3Inbox);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.navigation_work:
                beginTransaction.hide(Fragment2JobView).hide(Fragment3Inbox).hide(Fragment1HumanSearch).hide(Fragment5BossSetting);
                beginTransaction.show(Fragment4CalenderView);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.navigation_page:
                beginTransaction.hide(Fragment1HumanSearch).hide(Fragment2JobView).hide(Fragment3Inbox).hide(Fragment4CalenderView);
                beginTransaction.show(Fragment5BossSetting);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
        }
    }
}
