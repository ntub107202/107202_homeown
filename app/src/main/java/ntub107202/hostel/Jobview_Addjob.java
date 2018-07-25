package ntub107202.hostel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class Jobview_Addjob extends AppCompatActivity {

    private EditText start_date, start_time, end_date, end_time;
    private int mYear, mMonth, mDay, mHour, mMinute;

    EditText edit_job_title;
    EditText edit_salary;
    CheckBox chk_stay;
    String chk_stayS;
    CheckBox chk_food;
    String chk_foodS;
    CheckBox chk_fish;
    String chk_fishS;
    CheckBox chk_snorkel;
    String chk_snorkelS;
    CheckBox chk_moto;
    String chk_motoS;
    EditText edit_number_people;
    EditText edit_work;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jobview_addjob);
        start_date = (EditText) findViewById(R.id.start_date);
        start_time = (EditText) findViewById(R.id.start_time);
        end_date = (EditText) findViewById(R.id.end_date);
        end_time = (EditText) findViewById(R.id.end_time);

        start_date.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                showDatePickerDialogStart();
            }
        });
        start_time.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                showTimePickerDialogStart();
            }
        });
        end_date.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                showDatePickerDialogEnd();
            }
        });
        end_time.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                showTimePickerDialogEnd();
            }
        });


        edit_job_title = (EditText) findViewById(R.id.edit_job_title);
        edit_salary = (EditText) findViewById(R.id.edit_salary);
        chk_stay = (CheckBox) findViewById(R.id.chk_stay);
        chk_food = (CheckBox) findViewById(R.id.chk_food);
        chk_fish = (CheckBox) findViewById(R.id.chk_fish);
        chk_snorkel = (CheckBox) findViewById(R.id.chk_snorkel);
        chk_moto = (CheckBox) findViewById(R.id.chk_moto);
        edit_number_people = (EditText) findViewById(R.id.edit_number_people);
        edit_work = (EditText) findViewById(R.id.edit_work);
        Button button01 = (Button) findViewById(R.id.btn_add_job);


        //--------------------------
        //取得伺服器上JSON資料
        //--------------------------
        button01.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chk_stay.isChecked()){
                    chk_stayS = "1";
                }else {
                    chk_stayS = "0";
                }
                if (chk_food.isChecked()){
                    chk_foodS = "1";
                }else {
                    chk_foodS = "0";
                }
                if (chk_fish.isChecked()){
                    chk_fishS = "1";
                }else {
                    chk_fishS = "0";
                }
                if (chk_snorkel.isChecked()){
                    chk_snorkelS = "1";
                }else {
                    chk_snorkelS = "0";
                }
                if (chk_moto.isChecked()){
                    chk_motoS = "1";
                }else {
                    chk_motoS = "0";
                }
                Log.v("chk_stay", start_date.getText().toString());
                getWorksheet.postToJob(edit_job_title.getText().toString(), edit_salary.getText().toString(), chk_stayS, chk_foodS, chk_fishS, chk_snorkelS, chk_motoS, start_date.getText().toString(), start_time.getText().toString(), end_date.getText().toString(), end_time.getText().toString(), edit_number_people.getText().toString(), edit_work.getText().toString());
                Log.d("get0000", String.valueOf(getWorksheet.jobLength) + "post");
                getWorksheet.getJSON();
                getWorksheet.getjobJSON();
                Log.d("get0000", String.valueOf(getWorksheet.jobLength) + "get");
                getWorksheet.getcalendarJSON();
                Intent intent = new Intent(Jobview_Addjob.this,NavigationActivity.class);
                startActivity(intent);
            }
        });
    }



    public void showDatePickerDialogStart() {
        // 設定初始日期
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // 跳出日期選擇器
        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // 完成選擇，顯示日期
                        start_date.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                    }
                }, mYear, mMonth, mDay);
        dpd.show();
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
                            start_time.setText(hourOfDay + ":" + "0"+minute);
                        }else {
                            start_time.setText(hourOfDay + ":" + minute);
                        }
                    }
                }, mHour, mMinute, false);
        tpd.show();
    }
    public void showDatePickerDialogEnd() {
        // 設定初始日期
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);

        // 跳出日期選擇器
        DatePickerDialog dpd = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // 完成選擇，顯示日期
                        end_date.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

                    }
                }, mYear, mMonth, mDay);
        dpd.show();
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
                            end_time.setText(hourOfDay + ":" + "0"+minute);
                        }else {
                            end_time.setText(hourOfDay + ":" + minute);
                        }
                    }
                }, mHour, mMinute, false);
        tpd.show();
    }
}
