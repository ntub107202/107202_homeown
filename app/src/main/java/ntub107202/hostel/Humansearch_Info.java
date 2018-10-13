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

    public TextView name, school_depart, profession_skill, collection;
    public ImageView img_photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.humansearch_info);
//
        name = (TextView) findViewById(R.id.name);
        school_depart = (TextView) findViewById(R.id.school_depart);
        profession_skill = (TextView) findViewById(R.id.profession_skill);
        collection = (TextView) findViewById(R.id.collection);
        img_photo = (ImageView) findViewById(R.id.img_photo);

        Intent intent = getIntent();
        String row1 = intent.getExtras().getString("row1");
        String row2 = intent.getExtras().getString("row2");
        String row3 = intent.getExtras().getString("row3");
        String row4 = intent.getExtras().getString("row4");
        String row5 = intent.getExtras().getString("row5");
//        Log.d("Log", "position" + row1);

        name.setText(row1);
        school_depart.setText(row2);
        profession_skill.setText(row3);
        collection.setText(row4);
        img_photo.setImageBitmap(stringToBitmap(row5));
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
}