package ntub107202.hostel;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import ntub107202.hostel.player.YoutubePlayerView;

public class Humansearch_Info extends AppCompatActivity {

    public TextView name, gender,birth,home,school,department,study_state,interest,work_exp,exchange_reason,eatting_habit,start_date,end_date,phone,email;
    public ImageView img_photo,life_photo;
    public Button btn_contact,btn_hire;
    public String user, str_hostelNo,stud_account;
    public ArrayList<String> ary_hostel, ary_hostelNo;
    public Spinner chooseHostel;
    static final int REQUEST_ACTION_PICK = 1;
    public static final String PACKAGE_NAME = "jp.naver.line.android";
    public static final String CLASS_NAME = "jp.naver.line.android.activity.selectchat.SelectChatActivity";
    private List<ApplicationInfo> m_appList;


    private List<YoutubePlayerView> playerViewList;//一个页面可以播放多个视频，将所有的播放控件收集到这里进行维护，主要是控制离开页面时候的暂停
    //定位到youtube的某个视频有三种方式
    public static final String VideoUrl_normal = "";//这种是最普通的写在地址栏中的视频地址
    public static final String VideoUrl_embed = "https://www.youtube.com/embed/0xtcWek2tcM";//这种是分享嵌入式的视频地址
    public static final String VideoUrl_short = "https://youtu.be/wQ5Gj0UB_R8";//分享到facebook等社交平台的短url
    private View mVideoProgressView;
    private View mCustomView;//全屏显示的View
    private View mVideoFullScreenBack;
    private LinearLayout ll_player_container;
    private int mOriginalSystemUiVisibility;
    private int mOriginalOrientation;
    private WebChromeClient.CustomViewCallback mCustomViewCallback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.humansearch_info);
        chooseHostel = findViewById(R.id.choose_hostel);

        Bundle bundle=getIntent().getExtras();
        int position=bundle.getInt("position");

        String videoUrl = VideoUrl_normal;
        videoUrl=getWorksheet.getRow510(position);
        String videoID = YoutubePlayerView.parseIDfromVideoUrl(videoUrl);
        Log.i("Alex","视频的ID是=="+videoID);
        View youtubeView = LayoutInflater.from(this).inflate(R.layout.layout_youtube_player, null);
        YoutubePlayerView youtubePlayerView = (YoutubePlayerView) youtubeView.findViewById(R.id.youtubePlayerView);
        youtubePlayerView.setAutoPlayerHeight(this);
        youtubePlayerView.initialize(videoID, new YoutubePlayerCallBack(youtubePlayerView), mWebChromeClient);
        mVideoFullScreenBack = findViewById(R.id.detail_video_back);
        if(playerViewList == null){
            playerViewList = new ArrayList<>();
        }
        ll_player_container = (LinearLayout) findViewById(R.id.ll_player_container);
        ll_player_container.addView(youtubeView);
        playerViewList.add(youtubePlayerView);

        ary_hostel = new ArrayList<>();
        ary_hostelNo = new ArrayList<>();
        for(int i = 0 ; i < getWorksheet.hostelinfoLength; i++){
            ary_hostel.add(getWorksheet.getRow33(i));
            ary_hostelNo.add(getWorksheet.getRow39(i));
        }
        ArrayAdapter<String> adptHstChoose = new ArrayAdapter<>(this.getBaseContext(),
                android.R.layout.simple_spinner_dropdown_item,
                ary_hostel);
        chooseHostel.setAdapter(adptHstChoose);

        chooseHostel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int indexofHos = chooseHostel.getSelectedItemPosition();
                str_hostelNo = ary_hostelNo.get(indexofHos);
                Log.d("Log", "str_hostelNo是沙小???" + str_hostelNo);

//                Toast.makeText(getActivity().getBaseContext(), "你選的是" + city + district, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


//
        btn_contact = (Button) findViewById(R.id.btn_contact);
        btn_contact.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
//            Intent intent = new Intent(Intent.ACTION_SEND);
//            intent.setPackage(PACKAGE_NAME);
////            intent.setClassName(PACKAGE_NAME, CLASS_NAME);
//            Uri number = Uri.parse("line://nv/recommendOA/@s920613a");

//            intent.setType("text/plain");
//            intent.putExtra(Intent.EXTRA_TEXT,"//ti/p/%40linedevelopers");
//            startActivity(intent);
                Log.v("話都你在說",getWorksheet.getRow49(position));
                Uri uri = Uri.parse(getWorksheet.getRow49(position));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

//        btn_hire = (Button) findViewById(R.id.btn_contact);
//        btn_hire.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.d("Log", "我要傳???" + user);
//                Log.d("Log", "我要傳???" + str_hostelNo);
//                Log.d("Log", "我要傳???" + stud_account);
//                getWorksheet.postToResume(user,str_hostelNo,stud_account);
//            }
//        });
        btn_hire = (Button) findViewById(R.id.btn_hire);
        btn_hire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Log", "我要傳!!!" + user);
                Log.d("Log", "我要傳!!!" + str_hostelNo);
                Log.d("Log", "我要傳!!!" + stud_account);
                getWorksheet.postToResume(user,str_hostelNo,stud_account);
                showAlert();
            }
        });


        name = (TextView) findViewById(R.id.name);
        gender =  (TextView) findViewById(R.id.gender);
        birth = (TextView) findViewById(R.id.birth);
        home =  (TextView) findViewById(R.id.home);
        school = (TextView) findViewById(R.id.school);
        department =  (TextView) findViewById(R.id.department);
        study_state = (TextView) findViewById(R.id.study_state);
        interest =  (TextView) findViewById(R.id.interest);
        work_exp =  (TextView) findViewById(R.id.work_exp);
        exchange_reason = (TextView) findViewById(R.id.exchange_reason);
        eatting_habit =  (TextView) findViewById(R.id.eatting_habit);
        start_date = (TextView) findViewById(R.id.start_date);
        end_date =  (TextView) findViewById(R.id.end_date);
        interest =  (TextView) findViewById(R.id.interest);
        phone = (TextView) findViewById(R.id.phone);
        email =  (TextView) findViewById(R.id.email);

        img_photo = (ImageView) findViewById(R.id.img_photo);
        life_photo = (ImageView) findViewById(R.id.life_photo);



        name.setText(getWorksheet.getRow13(position));
        school.setText(getWorksheet.getRow14(position));
        work_exp.setText(getWorksheet.getRow15(position));
        exchange_reason.setText(getWorksheet.getRow16(position));
        img_photo.setImageBitmap(stringToBitmap(getWorksheet.getRow17(position)));
        gender.setText(getWorksheet.getRow18(position));
        birth.setText(getWorksheet.getRow19(position));
        phone.setText(getWorksheet.getRow20(position));
        home.setText(getWorksheet.getRow21(position));
        email.setText(getWorksheet.getRow22(position));
        life_photo.setImageBitmap(stringToBitmap(getWorksheet.getRow23(position)));
        study_state.setText(getWorksheet.getRow24(position));
        interest.setText(getWorksheet.getRow25(position));
        eatting_habit.setText(getWorksheet.getRow26(position));
        start_date.setText(getWorksheet.getRow27(position));
        end_date.setText(getWorksheet.getRow28(position));
        department.setText(getWorksheet.getRow30(position));
        stud_account = getWorksheet.getRow40(position);
        user = getSharedPreferences("userpw", MODE_PRIVATE).getString("USER", "");


//        Log.d("Log", "position是沙小???" + ary_hostel);
//        Log.d("Log", "position是沙小???" + user);
//        Log.d("Log", "position是沙小???" + stud_account);

    }

    public Bitmap stringToBitmap(String string) {
        Bitmap bitmap = null;
        try {
            byte[] bitmapArray = Base64.decode(string, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
            return bitmap;
        } catch (NullPointerException e) {
            e.getMessage();
            return null;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }
    public void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Humansearch_Info.this);
        builder.setMessage("您已傳送邀請");

        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
     public void sendTextHandler(View view) {
        String sendText = "s920613a";
        if(checkLineInstalled()){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setClassName(PACKAGE_NAME, CLASS_NAME);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT, sendText);
            startActivity(intent);
        }else{
            Toast toast = Toast.makeText(this, "LINEがインストールされていません", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
    private boolean checkLineInstalled(){
        PackageManager pm = getPackageManager();
        m_appList = pm.getInstalledApplications(0);
        boolean lineInstallFlag = false;
        for (ApplicationInfo ai : m_appList) {
            if(ai.packageName.equals(PACKAGE_NAME)){
                lineInstallFlag = true;
                break;
            }
        }
        return lineInstallFlag;
    }

    protected void onStart() {
        super.onStart();
    }
    private class YoutubePlayerCallBack implements YoutubePlayerView.YouTubeListener {

        private YoutubePlayerView mYoutubeView;

        YoutubePlayerCallBack(YoutubePlayerView view){
            this.mYoutubeView = view;
        }

        @Override
        public void onReady() {
        }

        @Override
        public void onStateChange(YoutubePlayerView.STATE state) {
            if(state == YoutubePlayerView.STATE.PLAYING && mYoutubeView!=null){
                if(playerViewList!=null){
                    for(YoutubePlayerView v : playerViewList){
                        if (v != null && v != mYoutubeView && (v.getPlayerState() == YoutubePlayerView.STATE.PLAYING ||
                                v.getPlayerState() == YoutubePlayerView.STATE.PAUSED)) {
                            v.stop();
                        }
                    }
                }
            }
        }

        @Override
        public void onPlaybackQualityChange(String arg) {
        }

        @Override
        public void onPlaybackRateChange(String arg) {

        }

        @Override
        public void onError(String arg) {
        }

        @Override
        public void onApiChange(String arg) {
        }

        @Override
        public void onCurrentSecond(double second) {
        }

        @Override
        public void onDuration(double duration) {
        }

        @Override
        public void logs(String log) {
        }
    }

    /**
     * 用于全屏显示的代码
     */
    private WebChromeClient mWebChromeClient = new WebChromeClient(){

        @Override
        public View getVideoLoadingProgressView() {
            if (mVideoProgressView == null) {
                LayoutInflater inflater = LayoutInflater.from(Humansearch_Info.this);
                mVideoProgressView = inflater.inflate(R.layout.video_layout_loading, null);
            }
            return mVideoProgressView;
        }

        @Override
        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback callback) {
            // if a view already exists then immediately terminate the new one
            if (mCustomView != null) {
                onHideCustomView();
                return;
            }

            // 1. Stash the current state
            mCustomView = view;
            mOriginalSystemUiVisibility = Humansearch_Info.this.getWindow().getDecorView().getSystemUiVisibility();
            mOriginalOrientation = Humansearch_Info.this.getRequestedOrientation();
            Log.i("Alex","原来的屏幕方向是"+mOriginalOrientation);
            // 2. Stash the custom view callback
            mCustomViewCallback = callback;

            // 3. Add the custom view to the view hierarchy
            FrameLayout decor = (FrameLayout) Humansearch_Info.this.getWindow().getDecorView();
            decor.addView(mCustomView, new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            if(mVideoFullScreenBack!=null){
                mVideoFullScreenBack.setVisibility(View.VISIBLE);
            }

            // 4. Change the state of the window
            Humansearch_Info.this.getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                            View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                            View.SYSTEM_UI_FLAG_FULLSCREEN |
                            View.SYSTEM_UI_FLAG_IMMERSIVE);
            Humansearch_Info.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        @Override
        public void onHideCustomView() {
            // 1. Remove the custom view
            FrameLayout decor = (FrameLayout) Humansearch_Info.this.getWindow().getDecorView();
            decor.removeView(mCustomView);
            mCustomView = null;
            if(mVideoFullScreenBack!=null){
                mVideoFullScreenBack.setVisibility(View.GONE);
            }

            // 2. Restore the state to it's original form
            Humansearch_Info.this.getWindow().getDecorView().setSystemUiVisibility(mOriginalSystemUiVisibility);
            Humansearch_Info.this.setRequestedOrientation(mOriginalOrientation);

            // 3. Call the custom view callback
            if(mCustomViewCallback!=null){
                mCustomViewCallback.onCustomViewHidden();
                mCustomViewCallback = null;
            }

        }
    };

    @Override
    public void onPause() {
        //视频播放器当页面停止的时候所有的视频播放全部暂停
        if(playerViewList!=null){
            for(YoutubePlayerView v : playerViewList){
                if(v.getPlayerState() == YoutubePlayerView.STATE.PLAYING ){
                    v.pause();
                }else if(v.getPlayerState() == YoutubePlayerView.STATE.BUFFERING){
                    v.stop();
                }
            }
        }
        super.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (playerViewList != null) {
            for (YoutubePlayerView v : playerViewList) {
                if (v != null) v.onDestroy();
            }
        }
    }
    public boolean closeFullScreen(){
        if(mCustomView!=null && mCustomViewCallback!=null){
            mWebChromeClient.onHideCustomView();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        Log.i("Alex", "进入onBackPressed方法");
        closeFullScreen();
        super.onBackPressed();
    }

}