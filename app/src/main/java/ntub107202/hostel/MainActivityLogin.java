package ntub107202.hostel;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

public class MainActivityLogin extends AppCompatActivity {
    private Button buttonByPass, buttonRegister;
    private EditText email;
    private EditText password;
    private String valid_email;
    private String valid_password;
    private static String user ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWorksheet.gethumansearchJSON();
        getWorksheet.getjobJSON();
        getWorksheet.getcalendarJSON();

        user = getSharedPreferences("userpw", MODE_PRIVATE).getString("USER", "");
        String pw = getSharedPreferences("userpw", MODE_PRIVATE).getString("PW", "");
        if(! user.equals("") && ! pw.equals("")){
            postATLogin();
        }
        Log.v("useraa", user);
        Log.v("useraa", pw);


        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        email.addTextChangedListener(textWatcher);
        password.addTextChangedListener(textWatcher1);

        buttonByPass = findViewById(R.id.buttonByPass);
        buttonByPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBypass();
            }
        });
        buttonRegister = findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });

        findViewById(R.id.button).setOnClickListener((v)->
        {
//            generateAllStars();

            postLogin();

        });
    }
    public static String getUser(){return user;}

    public void openHtl(){
        Intent intent =new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
    public void openBypass() {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }

    public void openRegister() {
        Intent intent = new Intent(this, MainActivityEntryRegister.class);
        startActivity(intent);
    }

    public void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivityLogin.this);
        builder.setMessage("帳密輸入錯誤，請重新輸入");

        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
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
                edt.setError("帳號不得為空!");
                valid_email = null;
            } else if (isEmailValid(edt.getText().toString()) == false) {
                edt.setError("無效的帳號格式!");
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

    public class Calendar
    {
        public String row1;
        public String row2;
        public String row3;
        public String row4;
    }

    private List<Calendar> parseGetJSon(String data) throws JSONException
    {
        if (data == null)
            return null;

        List<Calendar> list = new ArrayList<Calendar>();
        JSONObject jsonResponse = new JSONObject(data);
//        String ret = jsonResponse.getString("result");
        JSONArray jsonStars = jsonResponse.getJSONArray("result");
        for (int i = 0; i < jsonStars.length(); i++)
        {
            JSONObject jsonStar = jsonStars.getJSONObject(i);

            Calendar c = new Calendar();
            c.row1 = jsonStar.getString("row1");
            c.row2 = jsonStar.getString("row2");
            c.row3 = jsonStar.getString("row3");
            c.row4 = jsonStar.getString("row4");
            list.add(c);
        }
        return list;
    }


    private void generateAllStars()
    {
        // Service的URL
        String url = "http://140.131.114.153/getCalendar";

        // 建立期望收到JsonObject的request
        // 若new JsonObjectRequest的第二個參數為null則代表是GET，反之若為JSONObject則為POST

        //對應Postman JsonObjectRequest -> content-type=application/json
        JsonObjectRequest request = new JsonObjectRequest(url, null,
                new Response.Listener<JSONObject>()
                {
                    // 若server回傳HTTP status 200或204則會進入onResponse method
                    // 註:根據官網Issue 57527的討論，最新版應該是2xx都算request success
                    @Override
                    public void onResponse(JSONObject response)
                    {
                        Log.i("Log","result:" + response);
                        List<Calendar> list = new ArrayList<Calendar>();
                        try
                        {
                            list = parseGetJSon(response.toString());
                            for(Calendar c : list)
                            {
                                Log.i("Log","Calendar:" + c.row1);
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


    private void postQuestion()
    {
        // Service的URL
        String url = "http://140.131.114.153/postQuestion.php";

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
                param.put("row1", "20181053");
                return param;
            }
        };
        // 將request放到RequestQueue，Volley會以非同步方式送出request
        ApplicationController.getInstance().addToRequestQueue(request);
    }
    private void postLogin()
    {
        // Service的URL
        String url = "http://140.131.114.153/postHomeownLogin.php";

        //對應Postman StringRequest -> content-type=不設置

        StringRequest request = new StringRequest(Request.Method.POST,url,
                new Response.Listener<String>()
                {
                    @Override
                    //respone = php回應的結果
                    public void onResponse(String response)
                    {
                        Log.i("Log","result:" + response);
                        try {
                            String ret = parsePostLoginJSon(response);
                        if(ret.equals("成功"))
                        {

                            String user = email.getText().toString();
                            String pw = password.getText().toString();

                            SharedPreferences pref = getSharedPreferences("userpw", MODE_PRIVATE);
                            pref.edit()
                                    .putString("USER", user)
                                    .putString("PW", pw)
                                    .commit();
                            openHtl();
                        }
                        else {
                            showAlert();
                            Log.i("Log","帳密錯誤");
                        }
                        } catch (JSONException e) {
                            e.printStackTrace();
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
        )
        {
            @Override


            //=postman keyvalue (formdata)
            protected Map<String, String> getParams() {
                Map<String, String> param = new HashMap<>();

                param.put("row1", email.getText().toString());
                param.put("row2", password.getText().toString());

                return param;
            }
        };
        // 將request放到RequestQueue，Volley會以非同步方式送出request
        ApplicationController.getInstance().addToRequestQueue(request);
    }

                //string 轉json
    private String parsePostLoginJSon(String response) throws JSONException
    {
        if (response == null)
            return null;

        JSONObject jsonResponse = new JSONObject(response);
        JSONArray jsonStars = jsonResponse.getJSONArray("result");

        if(jsonStars.length() > 0)
        {
            return "成功";

        }
        return "失敗";
    }
    private void postATLogin()
    {
        // Service的URL
        String url = "http://140.131.114.153/postHomeownLogin.php";

        //對應Postman StringRequest -> content-type=不設置

        StringRequest request = new StringRequest(Request.Method.POST,url,
                new Response.Listener<String>()
                {
                    @Override
                    //respone = php回應的結果
                    public void onResponse(String response)
                    {
                        Log.i("Log","result:" + response);
                        try {
                            String ret = parsePostLoginJSon(response);
                            if(ret.equals("成功"))
                            {
                                openHtl();
                            }
                            else {
                                Log.i("Log","帳密錯誤");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
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
        )
        {
            @Override


            //=postman keyvalue (formdata)
            protected Map<String, String> getParams() {
                Map<String, String> param = new HashMap<>();
                String user = getSharedPreferences("userpw", MODE_PRIVATE).getString("USER", "");
                String pw = getSharedPreferences("userpw", MODE_PRIVATE).getString("PW", "");
                param.put("row1", user);
                param.put("row2", pw);

                return param;
            }
        };
        // 將request放到RequestQueue，Volley會以非同步方式送出request
        ApplicationController.getInstance().addToRequestQueue(request);
    }

}