package ntub107202.hostel;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Fragment_Calenderview extends Fragment {
    static TextView textView30;
    static TextView textView31;
    static TextView textView32;
    static TextView textView33;
    static TextView textView34;
    static String row9;
    static String row10;
    static String row11;
    static String row12;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_calender_view,container,false);
        Button button01 = (Button)view.findViewById(R.id.btn_go_add_calendar);
        textView30 = (TextView)view.findViewById(R.id.text001);
        textView31 = (TextView)view.findViewById(R.id.text002);
        textView32 = (TextView)view.findViewById(R.id.text003);
        textView33 = (TextView)view.findViewById(R.id.text004);
        textView34 = (TextView)view.findViewById(R.id.text005);
        button01.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Calenderview_Addcalender.class);
                startActivity(intent);
            }
        });
        return view;
    }
    public static void setrow9(String row){
        row9 = row;
        textView31.setText(row9 );

    }
    public static void setrow10(String row){
        row10 = row;
        textView32.setText(row10);
    }
    public static void setrow11(String row){
        row11 = row;
        textView33.setText(row11 );

    }
    public static void setrow12(String row){
        row12 = row;
        textView34.setText(row12);
    }
}
