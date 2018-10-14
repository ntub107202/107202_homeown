package ntub107202.hostel;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.TextView;

public class Humansearch_Info extends AppCompatActivity {

    public TextView name, gender,birth,home,school,department,study_state,interest,work_exp,exchange_reason,eatting_habit,start_date,end_date,phone,email;
    public ImageView img_photo,life_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.humansearch_info);
//
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

        Intent intent = getIntent();
        String row1 = intent.getExtras().getString("row1");
        String row2 = intent.getExtras().getString("row2");
        String row3 = intent.getExtras().getString("row3");
        String row4 = intent.getExtras().getString("row4");
        String row5 = intent.getExtras().getString("row5");
        String row6 = intent.getExtras().getString("row6");
        String row7 = intent.getExtras().getString("row7");
        String row8 = intent.getExtras().getString("row8");
        String row9 = intent.getExtras().getString("row9");
        String row10 = intent.getExtras().getString("row10");
        String row11 = intent.getExtras().getString("row11");
        String row12 = intent.getExtras().getString("row12");
        String row13 = intent.getExtras().getString("row13");
        String row14 = intent.getExtras().getString("row14");
        String row15 = intent.getExtras().getString("row15");
        String row16 = intent.getExtras().getString("row16");
        String row17 = intent.getExtras().getString("row17");
        String row18 = intent.getExtras().getString("row18");
        String row19 = intent.getExtras().getString("row19");

//        Log.d("Log", "position" + row1);

        name.setText(row1);
        school.setText(row2);
        work_exp.setText(row3);
        exchange_reason.setText(row4);
        img_photo.setImageBitmap(stringToBitmap(row5));
        gender.setText(row6);
        birth.setText(row7);
        phone.setText(row8);
        home.setText(row9);
        email.setText(row10);
        life_photo.setImageBitmap(stringToBitmap2(row11));
        study_state.setText(row12);
        interest.setText(row13);
        eatting_habit.setText(row14);
        start_date.setText(row15);
        end_date.setText(row16);
        department.setText(row18);
        //17收藏清單//19庭園整理
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

    public Bitmap stringToBitmap2(String string) {
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
}