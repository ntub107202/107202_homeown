package ntub107202.hostel;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Fragment_Calenderview extends Fragment {
    static TextView textView30;
    static TextView textView31;
    static TextView textView32;
    static TextView textView33;
    static TextView textView34;
    static String[] row = new String[100];
    static String row9;
    static String row10;
    static String row11;
    static String row12;
    RecyclerView mList;
    ArrayList<String> myDataset;
    ArrayList<String> myDataset2;
    ArrayList<String> myDataset3;
    ArrayList<String> myDataset4;
    MyAdapter myAdapter;
    static LinearLayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_calender_view,container,false);

//        Button button01 = (Button)view.findViewById(R.id.btn_go_add_calendar);

        textView30 = (TextView)view.findViewById(R.id.text001);
//        textView31 = (TextView)view.findViewById(R.id.text002);
//        textView32 = (TextView)view.findViewById(R.id.text003);
//        textView33 = (TextView)view.findViewById(R.id.text004);
//        textView34 = (TextView)view.findViewById(R.id.text005);

        mList = (RecyclerView)view.findViewById(R.id.list_view);

//        button01.setOnClickListener(new Button.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(),Calenderview_Addcalender.class);//              startActivity(intent);
//            }
//        });

        FloatingActionButton fab = (FloatingActionButton)view.findViewById(R.id.fab_go_to_add_calendar) ;
        fab.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Calenderview_Addcalender.class);
                startActivity(intent);
            }
        });

        return view;
    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){
            //pause
        }else{
            myDataset = new ArrayList<>();
            myDataset2 = new ArrayList<>();
            myDataset3 = new ArrayList<>();
            myDataset4 = new ArrayList<>();
            myAdapter = new MyAdapter(myDataset);
            for(int i = 0; i < getWorksheet.calendarLength; i++){
//                myDataset.add(i + "");
                myDataset.add(getWorksheet.getRow9(i));
                myDataset2.add(getWorksheet.getRow10(i));
                myDataset3.add(getWorksheet.getRow11(i));
                myDataset4.add(getWorksheet.getRow12(i));
                Log.d("get0000", String.valueOf(getWorksheet.calendarLength)+"calendarLength_resume");
            }
//            mList = (RecyclerView)view.findViewById(R.id.list_view);
            layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            mList.setLayoutManager(layoutManager);
            mList.setAdapter(myAdapter);
            //resume
        }
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private List<String> mData;

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView TextView0001, TextView0002 ,TextView0003, TextView0004;

            public ViewHolder(View v) {
                super(v);
                TextView0001 = (TextView) v.findViewById(R.id.textView0001);
                TextView0002 = (TextView) v.findViewById(R.id.textView0002);
                TextView0003 = (TextView) v.findViewById(R.id.textView0003);
                TextView0004 = (TextView) v.findViewById(R.id.textView0004);
            }
        }

        public MyAdapter(List<String> data) {
            mData = data;
        }


        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.jobview_item, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.TextView0001.setText(mData.get(position));
            holder.TextView0002.setText(myDataset2.get(position));
            holder.TextView0003.setText(myDataset3.get(position));
            holder.TextView0004.setText(myDataset4.get(position));
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }
//    public static void setrow9(String row){
//        row9 = row;
//        textView31.setText(row9 );
//
//    }
//    public static void setrow10(String row){
//        row10 = row;
//        textView32.setText(row10);
//    }
//    public static void setrow11(String row){
//        row11 = row;
//        textView33.setText(row11 );
//
//    }
//    public static void setrow12(String row){
//        row12 = row;
//        textView34.setText(row12);
//    }
}
