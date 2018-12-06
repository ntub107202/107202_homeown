package ntub107202.hostel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;
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
    CheckBox chk_salary;
    EditText edit_contact;
    EditText edit_email;
    EditText edit_phone;
    Spinner spinner;


    private String valid_edit_salary;
    private String valid_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.jobview_addjob);
        start_date = (EditText) findViewById(R.id.start_date);
        start_time = (EditText) findViewById(R.id.start_time);
        end_date = (EditText) findViewById(R.id.end_date);
        end_time = (EditText) findViewById(R.id.end_time);
        chk_salary=(CheckBox) findViewById(R.id.chk_salary);
        final Spinner choose_hostel = (Spinner)findViewById(R.id.spin_hotel);
        final ArrayList<String> myList2 = new ArrayList<String>();
        for(int i = 0; i < getWorksheet.hostelnameLength; i++) {
            myList2.add(getWorksheet.getRow38(i));
//            Log.v("88989898",getWorksheet.getRow36(i));
//            Log.v("88989898",myList2.get(i));
        }
        ArrayAdapter<String> myList = new ArrayAdapter<String>(Jobview_Addjob.this,
                android.R.layout.simple_spinner_dropdown_item,
                myList2);

        choose_hostel.setAdapter(myList);


        chk_salary.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(chk_salary.isChecked()){
                    edit_salary.setFocusable(false);
                    edit_salary.setText("0");
                }else {
                    edit_salary.setFocusable(true);
                    edit_salary.setFocusableInTouchMode(true);
                    edit_salary.requestFocus();
                    edit_salary.requestFocusFromTouch();
                    edit_salary.setText("");
                }
                return;
            }
        });

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
        edit_contact= (EditText) findViewById(R.id.edit_contact);
        edit_email= (EditText) findViewById(R.id.edit_email);
        edit_phone= (EditText) findViewById(R.id.edit_phone);

        Button button01 = (Button) findViewById(R.id.btn_add_job);

        edit_salary.addTextChangedListener(textWatcher);
        edit_number_people.addTextChangedListener(textWatcher1);
        edit_contact.addTextChangedListener(textWatcher2);
        edit_email.addTextChangedListener(textWatcher3);
        edit_phone.addTextChangedListener(textWatcher4);
        end_date.addTextChangedListener(textWatcher5);
        start_date.addTextChangedListener(textWatcher6);
        end_time.addTextChangedListener(textWatcher7);
        start_time.addTextChangedListener(textWatcher8);




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
                String user = getSharedPreferences("userpw", MODE_PRIVATE).getString("USER", "");
                getWorksheet.postToJob(edit_job_title.getText().toString(), edit_salary.getText().toString(), chk_stayS, chk_foodS, chk_fishS, chk_snorkelS, chk_motoS, start_date.getText().toString(), start_time.getText().toString(), end_date.getText().toString(), end_time.getText().toString(), edit_number_people.getText().toString(), edit_work.getText().toString(),user,getWorksheet.getRow3866(choose_hostel.getSelectedItemPosition()));
                Log.d("get0000", String.valueOf(getWorksheet.jobLength) + "post");
                Log.d("你喜歡我", getWorksheet.getRow3866(choose_hostel.getSelectedItemPosition()));
                getWorksheet.getJSON();
                getWorksheet.getjobJSON();
                try {
                    Thread.sleep(500); //1000為1秒
                } catch (InterruptedException e) {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
                Log.d("get0000", String.valueOf(getWorksheet.jobLength) + "get");
                getWorksheet.getcalendarJSON();
                Intent intent = new Intent(Jobview_Addjob.this,NavigationActivity.class);
                intent.putExtra("id",2);
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

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            Log.d("TAG", "afterTextChanged--------------->");

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
            Is_Valid_Email(edit_salary);

        }
        public void Is_Valid_Email(EditText edt) {
            if(edit_salary.isFocusable()) {
                if (edt.getText().toString().matches("0")) {
                    edt.setError("數字不得為0開頭!");
                    edt.setText("");
                }
            }else {

            }
        }


        boolean isEmailValid(CharSequence email) {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                    .matches();
        } // end of TextWatcher (email)
    };

    private TextWatcher textWatcher1 = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            Log.d("TAG", "afterTextChanged--------------->");

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
            Is_Valid_Email(edit_number_people);
        }
        public void Is_Valid_Email(EditText edt) {
            if (edt.getText().toString().matches("0")) {
                edt.setError("數字不得為0開頭!");
                edt.setText("");
            }
        }
    };

    private TextWatcher textWatcher3 = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            Log.d("TAG", "afterTextChanged--------------->");
            Is_Valid_Email(edit_email);
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
            if (edt.getText().toString().equals("")) {
                edt.setError("電子郵件不得為空!");
                valid_email = null;
            } else if (isEmailValid(edt.getText().toString()) == false) {
                edt.setError("無效的電子郵件格式!");
                valid_email = null;
            } else {
                valid_email = edt.getText().toString();
            }
        }

        boolean isEmailValid(CharSequence email) {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                    .matches();
        } // end of TextWatcher (email)
    };

    private TextWatcher textWatcher2 = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            Log.d("TAG", "afterTextChanged--------------->");
            Is_Valid_Email(edit_contact);
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
                //if ((heighText.getText().toString())!=null)
                if(isInteger(edt.getText().toString()) ==true)
                    edt.setError("不能為數字");
            } catch (Exception e) {

            }
        }
        boolean isNumber(String value) {
            return isInteger(value) || isDouble(value);
        } // end of TextWatcher (email)
        /**
         * 判断字符串是否是整数
         */
        boolean isInteger(String value) {
            try {
                Integer.parseInt(value);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }

        /**
         * 判断字符串是否是浮点数
         */
        boolean isDouble(String value) {
            try {
                Double.parseDouble(value);
                if (value.contains("."))
                    return true;
                return false;
            } catch (NumberFormatException e) {
                return false;
            }
        }
    };

    private TextWatcher textWatcher4 = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            Log.d("TAG", "afterTextChanged--------------->");
            if (edit_phone.length()<2){
                edit_phone.setError("長度不為10碼");
            }else if (s.length() != 10) {
                edit_phone.setError("長度不為10碼");
            }else if(!(edit_phone.getText().toString().substring(0,2).equals("09"))) {
                edit_phone.setError("手機格式不符合");
                Log.d("TAGGGGGGGGGGG", edit_phone.getText().toString().substring(0,2) );
            }else{

            }
//
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
    };

    private TextWatcher textWatcher5 = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            Log.d("TAG", "afterTextChanged--------------->");
            Is_Valid_Email(end_date);
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
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = sdf.parse(start_date.getText().toString());
                Date d2 = sdf.parse(end_date.getText().toString());
                long result = d1.getTime()-d2.getTime();
                Log.d("dateeee", String.valueOf(d1.getTime()-d2.getTime()));
                if (result<=0){
                    end_date.setError(null);
//                }else if (result == 0) {
//                    end_date.setError("結束日期等於初始日期");
                }else if(result>0){
                    end_date.setError("結束日期小於初始日期");
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
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date d1 = sdf.parse(start_date.getText().toString());
                Date d2 = sdf.parse(end_date.getText().toString());
                long result = d1.getTime()-d2.getTime();
                Log.d("dateeee", String.valueOf(d1.getTime()-d2.getTime()));
                if (result<=0){
                    end_date.setError(null);
//                }else if (result == 0) {
//                    end_date.setError("結束日期等於初始日期");
                }else if(result>0){
                    end_date.setError("結束日期小於初始日期");
                }
            } catch (Exception e) {

            }
        }
    };

    private TextWatcher textWatcher7 = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            Log.d("TAG", "afterTextChanged--------------->");
            Is_Valid_Email(end_time);
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
                Date d1 = sdf.parse(start_time.getText().toString());
                Date d2 = sdf.parse(end_time.getText().toString());
                long result = d1.getTime()-d2.getTime();
                Log.d("timeeee", String.valueOf(d1.getTime()-d2.getTime()));
                if (result<0){
                    end_time.setError(null);
                }else if (result == 0) {
                    end_time.setError("結束時間等於開始時間");
                }else if(result>0){
                    end_time.setError("結束時間小於開始時間");
                }

            } catch (Exception e) {

            }
        }
    };

    private TextWatcher textWatcher8 = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            Log.d("TAG", "afterTextChanged--------------->");
            Is_Valid_Email(start_time);
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
                Date d1 = sdf.parse(start_time.getText().toString());
                Date d2 = sdf.parse(end_time.getText().toString());
                long result = d1.getTime()-d2.getTime();
                Log.d("timeeee", String.valueOf(d1.getTime()-d2.getTime()));
                if (result<0){
                    end_time.setError(null);
                }else if (result == 0) {
                    end_time.setError("結束時間等於開始時間");
                }else if(result>0){
                    end_time.setError("結束時間小於開始時間");
                }

            } catch (Exception e) {

            }
        }
    };
}
