package ntub107202.hostel;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;

import java.util.Calendar;

public class Calenderview_Addcalender extends AppCompatActivity {

    private EditText work_start_time, work_end_time;
    private int mYear, mMonth, mDay, mHour, mMinute;

    EditText edit_work_title;
    EditText edit_work;
    RadioButton rad_work_type_always;
    String rad_work_type_alwaysS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calenderview_addcalender);

        work_start_time = (EditText) findViewById(R.id.work_start_time);
        work_end_time = (EditText) findViewById(R.id.work_end_time);

        work_start_time.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                showTimePickerDialogStart();
            }
        });
        work_end_time.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                showTimePickerDialogEnd();
            }
        });


        edit_work_title = (EditText) findViewById(R.id.edit_work_title);
        edit_work = (EditText) findViewById(R.id.edit_work);
        rad_work_type_always = (RadioButton)findViewById(R.id.rad_work_type_always);
        work_start_time = (EditText) findViewById(R.id.work_start_time);
        work_end_time = (EditText) findViewById(R.id.work_end_time);

        Button button01 = (Button) findViewById(R.id.btn_add_calendar);


        rad_work_type_always.setChecked(true);
//        Log.v("1123",rad_work_type_alwaysS);
        //--------------------------
        //取得伺服器上JSON資料
        //--------------------------
        button01.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rad_work_type_always.isChecked()){
                    rad_work_type_alwaysS="1";
                }else{
                    rad_work_type_alwaysS="0";
                }
                Log.v("1123",rad_work_type_alwaysS);
                getWorksheet.postToCalendar(edit_work_title.getText().toString(), rad_work_type_alwaysS, work_start_time.getText().toString(), work_end_time.getText().toString(), edit_work.getText().toString());
                getWorksheet.getJSON();
                getWorksheet.getjobJSON();
                getWorksheet.getcalendarJSON();
                Intent intent = new Intent(Calenderview_Addcalender.this,NavigationActivity.class);
                intent.putExtra("id",3);
                startActivity(intent);
            }
        });
    }
    public void showTimePickerDialogStart() {
        // 設定初始時間
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // 跳出時間選擇器
        TimePickerDialog tpd = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        // 完成選擇，顯示時間
                        if (minute<10){
                            work_start_time.setText(hourOfDay + ":" + "0"+minute);
                        }else {
                            work_start_time.setText(hourOfDay + ":" + minute);
                        }
                    }
                }, mHour, mMinute, false);
        tpd.show();
    }
    public void showTimePickerDialogEnd() {
        // 設定初始時間
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // 跳出時間選擇器
        TimePickerDialog tpd = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    public void onTimeSet(TimePicker view, int hourOfDay,
                                          int minute) {
                        // 完成選擇，顯示時間
                        if (minute<10){
                            work_end_time.setText(hourOfDay + ":" + "0"+minute);
                        }else {
                            work_end_time.setText(hourOfDay + ":" + minute);
                        }
                    }
                }, mHour, mMinute, false);
        tpd.show();
    }
}
