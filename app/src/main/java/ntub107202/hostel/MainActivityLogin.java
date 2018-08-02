package ntub107202.hostel;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivityLogin extends AppCompatActivity {
    private Button buttonByPass, buttonRegister;
    private EditText email;
    private EditText password;
    private String valid_email;
    private String valid_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWorksheet.gethumansearchJSON();
        getWorksheet.getjobJSON();
        getWorksheet.getcalendarJSON();
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
    }

    public void openBypass() {
        Intent intent = new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }

    public void openRegister() {
        Intent intent = new Intent(this, MainActivityEntryRegister.class);
        startActivity(intent);
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

}