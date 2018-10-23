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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URISyntaxException;
import java.util.List;

public class Humansearch_Info extends AppCompatActivity {

    public TextView name, gender,birth,home,school,department,study_state,interest,work_exp,exchange_reason,eatting_habit,start_date,end_date,phone,email;
    public ImageView img_photo,life_photo;
    public Button btn_contact;

    static final int REQUEST_ACTION_PICK = 1;
    public static final String PACKAGE_NAME = "jp.naver.line.android";
    public static final String CLASS_NAME = "jp.naver.line.android.activity.selectchat.SelectChatActivity";
    private List<ApplicationInfo> m_appList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.humansearch_info);

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

        Log.d("Log", "position是沙小???" + position);

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