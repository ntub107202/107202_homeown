package ntub107202.hostel;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.humansearch_info);
        chooseHostel = findViewById(R.id.choose_hostel);

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
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setPackage(PACKAGE_NAME);
//            intent.setClassName(PACKAGE_NAME, CLASS_NAME);
            Uri number = Uri.parse("line://nv/recommendOA/@s920613a");

            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_TEXT,"//ti/p/%40linedevelopers");
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

        Bundle bundle=getIntent().getExtras();
        int position=bundle.getInt("position");

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
}