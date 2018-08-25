package ntub107202.hostel;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ntub107202.hostel.Common.ApplicationController;

public class MainActivityRegister extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private EditText password1;
    private EditText name_hostel;
    private EditText phone_hostel;

    private String valid_email;
    private String valid_password;
    private String valid_password1;
    private String valid_name_hostel;
    private String valid_phone_hostel;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        password1 = (EditText)findViewById(R.id.password1);
        name_hostel=(EditText)findViewById(R.id.name_hostel);
        phone_hostel=(EditText)findViewById(R.id.phone_hostel);

        email.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher1);
        password1.addTextChangedListener(textWatcher2);
        name_hostel.addTextChangedListener(textWatcher3);
        phone_hostel.addTextChangedListener(textWatcher4);

        findViewById(R.id.button13).setOnClickListener((v)->
        {
            postRegister();
            openLogin();
        });

    }
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            Log.d("TAG", "afterTextChanged--------------->");
            Is_Valid_Email(email);
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

    private TextWatcher textWatcher1 = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            Log.d("TAG", "afterTextChanged--------------->");
            Is_Valid_Password(password);
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

        public void Is_Valid_Password(EditText edt) {
            if (edt.getText().toString().equals("")) {
                edt.setError("密碼不得為空!");
                valid_password = null;
            }else {
                valid_password = edt.getText().toString();
            }
        }
    };

    private TextWatcher textWatcher2 = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            Log.d("TAG", "afterTextChanged--------------->");
            Is_Valid_Password(password1);
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
        public void Is_Valid_Password(EditText edt) {
            if (edt.getText().toString().equals("")) {
                edt.setError("密碼不得為空!");
                valid_password1 = null;
            } else if (!(password1.getText().toString().equals(password.getText().toString()))) {
                Log.v("password",password.getText().toString());
                Log.v("password1",password1.getText().toString());
                edt.setError("密碼不相同!");

            }
            else {
                valid_password1 = edt.getText().toString();
            }
        }
    };

    private TextWatcher textWatcher3 = new TextWatcher() {
        @Override
        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            Log.d("TAG", "afterTextChanged--------------->");
            Is_Valid_Email(name_hostel);
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
            if (phone_hostel.length()<2){
                phone_hostel.setError("長度不為10碼");
            }else if (s.length() != 10) {
                phone_hostel.setError("長度不為10碼");
            }else if(!(phone_hostel.getText().toString().substring(0,2).equals("09"))) {
                phone_hostel.setError("手機格式不符合");
                Log.d("TAGGGGGGGGGGG", phone_hostel.getText().toString().substring(0,2) );
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

    public class Register
    {
        public String row1;
        public String row2;
        public String row3;
        public String row4;
    }

    private List<MainActivityRegister.Register> parseGetJSon(String data) throws JSONException
    {
        if (data == null)
            return null;

        List<MainActivityRegister.Register> list = new ArrayList<MainActivityRegister.Register>();
        JSONObject jsonResponse = new JSONObject(data);
//        String ret = jsonResponse.getString("result");
        JSONArray jsonStars = jsonResponse.getJSONArray("result");
        for (int i = 0; i < jsonStars.length(); i++)
        {
            JSONObject jsonStar = jsonStars.getJSONObject(i);

            MainActivityRegister.Register r = new MainActivityRegister.Register();
            r.row1 = jsonStar.getString("row1");
            r.row2 = jsonStar.getString("row2");
            r.row3 = jsonStar.getString("row3");
            r.row4 = jsonStar.getString("row4");
            list.add(r);
        }
        return list;
    }


    private void generateAllStars()
    {
        // Service的URL
        String url = "http://140.131.114.153/getRegister";

        // 建立期望收到JsonObject的request
        // 若new JsonObjectRequest的第二個參數為null則代表是GET，反之若為JSONObject則為POST
        JsonObjectRequest request = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>()
                {
                    // 若server回傳HTTP status 200或204則會進入onResponse method
                    // 註:根據官網Issue 57527的討論，最新版應該是2xx都算request success
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        Log.i("Log","result:" + response);
                        List<MainActivityRegister.Register> list = new ArrayList<MainActivityRegister.Register>();
                        try
                        {
                            list = parseGetJSon(response.toString());
                            for(MainActivityRegister.Register r : list)
                            {
                                Log.i("Log","Register:" + r.row1);
                            }
                        }
                        catch(Exception e)
                        {
                            Log.i("Log", "Exception: " + e.toString());
                        }
                    }
                },
                new Response.ErrorListener()
                {
                    // Request失敗處理
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        );
        // 將request放到RequestQueue，Volley會以非同步方式送出request
        ApplicationController.getInstance().addToRequestQueue(request);
    }

    public void openLogin(){
        Intent intent =new Intent(this, MainActivityLogin.class);
        startActivity(intent);
    }

    private void postRegister()
    {
        // Service的URL
        String url = "http://140.131.114.153/postRegister.php";

        // 建立期望收到JsonObject的request
        // 若new JsonObjectRequest的第二個參數為null則代表是GET，反之若為JSONObject則為POST
        StringRequest request = new StringRequest(Request.Method.POST,url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                        Log.i("Log","result:" + response);
                    }
                },
                new Response.ErrorListener()
                {
                    // Request失敗處理
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        )
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> param = new HashMap<>();

                param.put("row1", email.getText().toString());
                param.put("row2", password.getText().toString());
                param.put("row3", name_hostel.getText().toString());
                param.put("row4", phone_hostel.getText().toString());
                return param;
            }
        };
        // 將request放到RequestQueue，Volley會以非同步方式送出request
        ApplicationController.getInstance().addToRequestQueue(request);
    }
}
