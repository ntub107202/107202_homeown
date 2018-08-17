package ntub107202.hostel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.Button;



public class Setting_Job extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_job_view);
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab_go_to_add_job) ;
        fab.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Setting_Job.this,Jobview_Addjob.class);
                startActivity(intent);
            }
        });

    }
}
