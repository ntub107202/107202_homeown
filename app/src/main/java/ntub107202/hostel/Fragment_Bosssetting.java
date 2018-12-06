package ntub107202.hostel;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;


public class Fragment_Bosssetting extends Fragment {
    TextView textView31;
    TextView textView30;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_boss_setting,container,false);
        Button btn_hotelinfo =(Button)view.findViewById(R.id.btn_hotel_info);
        Button button01 = (Button)view.findViewById(R.id.btn_hire_history);
        Button button02 = (Button)view.findViewById(R.id.btn_logout);
        Button btn_notification = (Button)view.findViewById(R.id.btn_notification);
        Button button03 = (Button)view.findViewById(R.id.btn_return);
        Button button04 = (Button)view.findViewById(R.id.btn_about);
        Button button05 = (Button)view.findViewById(R.id.btn_specification);
        Button button07 = (Button)view.findViewById(R.id.btn_login);
        Button button08 = (Button)view.findViewById(R.id.btn_reg);
        textView31 = (TextView)view.findViewById(R.id.textView31);
        textView30 = (TextView)view.findViewById(R.id.textView30);
        textView31.setText(getWorksheet.getRow38(0));
        textView30.setText(MainActivityLogin.getUser());
        LinearLayout lin_login = (LinearLayout)view.findViewById(R.id.lin_login);
        LinearLayout lin_reg = (LinearLayout)view.findViewById(R.id.lin_reg);
        if(MainActivityLogin.getUser()!= null){
            lin_login.setVisibility(View.GONE);
            lin_reg.setVisibility(View.GONE);
        }
        btn_hotelinfo.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Setting_Hotelinfo.class);
                startActivity(intent);
            }
        });
        button01.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Setting_Hirehistory.class);
                startActivity(intent);
            }
        });
        button02.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                NavigationActivity navigationActivity = (NavigationActivity ) getActivity();
                navigationActivity.cleanshit();
                Intent intent = new Intent(getActivity(),MainActivityLogin.class);
                startActivity(intent);
            }
        });
        btn_notification.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Setting_Notification.class);
                startActivity(intent);
            }
        });
        button03.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Setting_Returnproblem.class);
                startActivity(intent);
            }
        });
        button04.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Setting_Aboutme.class);
                startActivity(intent);
            }
        });
        button05.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Setting_Specification.class);
                startActivity(intent);
            }
        });
        button07.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),MainActivityLogin.class);
                startActivity(intent);
            }
        });
        button08.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),MainActivityRegister.class);
                startActivity(intent);
            }
        });


        return view;
    }
}
