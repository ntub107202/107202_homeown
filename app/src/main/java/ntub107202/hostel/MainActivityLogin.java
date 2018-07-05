package ntub107202.hostel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivityLogin extends AppCompatActivity {
    private Button buttonByPass,buttonRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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
    public void openBypass(){
        Intent intent =new Intent(this, MainActivityBypass.class);
        startActivity(intent);
    }
    public void openRegister(){
        Intent intent =new Intent(this, MainActivityEntryRegister.class);
        startActivity(intent);
    }
}
