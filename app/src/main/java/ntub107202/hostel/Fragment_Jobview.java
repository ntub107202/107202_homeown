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

public class Fragment_Jobview extends Fragment {
    static TextView textView0;
    static TextView textView1;
    static TextView textView2;
    static TextView textView3;
    static TextView textView4;
    static String row5;
    static String row6;
    static String row7;
    static String row8;
    static String row00;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_job_view,container,false);
        Button button01 = (Button)view.findViewById(R.id.btn_go_add_job);
        textView0 = (TextView)view.findViewById(R.id.text01);
        textView1 = (TextView)view.findViewById(R.id.text02);
        textView2 = (TextView)view.findViewById(R.id.text03);
        textView3 = (TextView)view.findViewById(R.id.text04);
        textView4 = (TextView)view.findViewById(R.id.text05);
        if(textView1.getText() != ""){
            textView0.setVisibility(View.INVISIBLE);
        }
        button01.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Jobview_Addjob.class);
                startActivity(intent);
            }
        });
        return view;
    }
    //    @Override
//    public void onResume() {
//        if(textView1.getText() != ""){
//            textView0.setVisibility(View.INVISIBLE);
//        }
//        super.onResume();
//    }
    public static void setrow5(String row){
        row5 = row;
        textView1.setText(row5 );

    }
    public static void setrow6(String row){
        row6 = row;
        textView2.setText(row6);
    }
    public static void setrow7(String row){
        row7 = row;
        textView3.setText(row7 );

    }
    public static void setrow8(String row){
        row8 = row;
        textView4.setText(row8);
    }
}
