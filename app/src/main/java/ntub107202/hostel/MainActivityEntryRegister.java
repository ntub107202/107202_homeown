package ntub107202.hostel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivityEntryRegister extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry_register);
        button = findViewById(R.id.button12);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });
    }

    public void openRegister(){
        Intent intent =new Intent(this, MainActivityRegister.class);
        startActivity(intent);
   }
}
