package ntub107202.hostel;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Calenderview_Editcalender extends AppCompatActivity {

    private EditText work_start_time, work_end_time,start_date;
    private int mYear, mMonth, mDay, mHour, mMinute;

    EditText edit_work_title;
    EditText edit_work;
    RadioButton rad_work_type_always;
    String rad_work_type_alwaysS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calenderview_editcalender);
        start_date = (EditText) findViewById(R.id.start_date);
        work_start_time = (EditText) findViewById(R.id.work_start_time);
        work_end_time = (EditText) findViewById(R.id.work_end_time);

        start_date.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                showDatePickerDialogStart();
            }
        });

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

        work_start_time.addTextChangedListener(textWatcher1);
        work_end_time.addTextChangedListener(textWatcher2);

        rad_work_type_always.setChecked(true);

        start_date.addTextChangedListener(textWatcher6);
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
                Log.v("edit_work_title", edit_work_title.getText().toString());
                Log.v("rad_work_type_alwaysS",rad_work_type_alwaysS);
                Log.v("work_start_time",work_start_time.getText().toString());
                Log.v("work_end_time",work_end_time.getText().toString());
                Log.v("edit_work",edit_work.getText().toString());
                getWorksheet.postToCalendar(edit_work_title.getText().toString(), rad_work_type_alwaysS, work_start_time.getText().toString(), work_end_time.getText().toString(), edit_work.getText().toString(), start_date.getText().toString());
                getWorksheet.getJSON();
                getWorksheet.getjobJSON();
                getWorksheet.getcalendarJSON();
                Intent intent = new Intent(Calenderview_Editcalender.this,NavigationActivity.class);
                intent.putExtra("id",4);
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
    private TextWatcher textWatcher1 = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            Log.d("TAG", "afterTextChanged--------------->");
            Is_Valid_Email(work_start_time);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub
            Log.d("TAG", "beforeTextChanged--------------->");
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            Log.d("TAG", "onTextChanged--------------->");

        }
        public void Is_Valid_Email(EditText edt) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                Date d1 = sdf.parse(work_start_time.getText().toString());
                Date d2 = sdf.parse(work_end_time.getText().toString());
                long result = d1.getTime()-d2.getTime();
                Log.d("timeeee", String.valueOf(d1.getTime()-d2.getTime()));
                if (result<0){
                    work_end_time.setError(null);
                }else if (result == 0) {
                    work_end_time.setError("結束時間等於開始時間");
                }else if(result>0){
                    work_end_time.setError("結束時間小於開始時間");
                }

            } catch (Exception e) {

            }
        }
    };

    private TextWatcher textWatcher2 = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            Log.d("TAG", "afterTextChanged--------------->");
            Is_Valid_Email(work_end_time);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub
            Log.d("TAG", "beforeTextChanged--------------->");
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            Log.d("TAG", "onTextChanged--------------->");

        }
        public void Is_Valid_Email(EditText edt) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                Date d1 = sdf.parse(work_start_time.getText().toString());
                Date d2 = sdf.parse(work_end_time.getText().toString());
                long result = d1.getTime()-d2.getTime();
                Log.d("timeeee", String.valueOf(d1.getTime()-d2.getTime()));
                if (result<0){
                    work_end_time.setError(null);
                }else if (result == 0) {
                    work_end_time.setError("結束時間等於開始時間");
                }else if(result>0){
                    work_end_time.setError("結束時間小於開始時間");
                }

            } catch (Exception e) {

            }
        }
    };
    private TextWatcher textWatcher6 = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            Log.d("TAG", "afterTextChanged--------------->");
            Is_Valid_Email(start_date);
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            // TODO Auto-generated method stub
            Log.d("TAG", "beforeTextChanged--------------->");
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            Log.d("TAG", "onTextChanged--------------->");

        }
        public void Is_Valid_Email(EditText edt) {

        }
    };
}
