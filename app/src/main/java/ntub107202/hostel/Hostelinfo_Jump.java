package ntub107202.hostel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Hostelinfo_Jump extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hostelinfo_jump);
        getWorksheet.gethostelinfoJSON();

        finish();
    }
}
