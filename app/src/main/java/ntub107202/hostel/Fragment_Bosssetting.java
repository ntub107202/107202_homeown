package ntub107202.hostel;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment_Bosssetting extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_boss_setting,container,false);
        Button btn_hotelinfo =(Button)view.findViewById(R.id.btn_hotel_info);
        Button button01 = (Button)view.findViewById(R.id.btn_hire_history);
        Button button02 = (Button)view.findViewById(R.id.btn_contact_history);
        Button btn_notification = (Button)view.findViewById(R.id.btn_notification);
        Button button03 = (Button)view.findViewById(R.id.btn_return);
        Button button04 = (Button)view.findViewById(R.id.btn_about);
        Button button05 = (Button)view.findViewById(R.id.btn_specification);
        Button button06 = (Button)view.findViewById(R.id.btn_change);
        Button button07 = (Button)view.findViewById(R.id.btn_login);
        Button button08 = (Button)view.findViewById(R.id.btn_reg);


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

                Intent intent = new Intent(getActivity(),Setting_Contacthistory.class);
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
        button06.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),MainActivityBypass.class);
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
