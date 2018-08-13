package ntub107202.hostel;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Setting_Hotelinfo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_hotelinfo);
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab_go_to_add_hotel) ;
        fab.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Setting_Hotelinfo.this,Hotelview_Addhotel.class);
                startActivity(intent);
            }
        });
    }

}
