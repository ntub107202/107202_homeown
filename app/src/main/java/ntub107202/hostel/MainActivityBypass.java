package ntub107202.hostel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivityBypass extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bypass);
        //取得伺服器上JSON資料
        getWorksheet.getJSON();
        getWorksheet.getjobJSON();
        getWorksheet.getcalendarJSON();

        button = findViewById(R.id.buttonHtlEntry);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHtl();
            }
        });
    }

    public void openHtl(){
        Intent intent =new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
}
