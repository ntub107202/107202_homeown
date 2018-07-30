package ntub107202.hostel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

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
                Integer.parseInt(name_hostel.getText().toString());
                edt.setError("不能為數字");
            } catch (Exception e) {

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
}
