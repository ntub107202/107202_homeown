package ntub107202.hostel;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ntub107202.hostel.Schedule.bean.DateEntity;
import ntub107202.hostel.Schedule.view.DataView;

public class Fragment_Calenderview extends Fragment {
    private DataView dataView;
    private TextView info;

    static TextView textView4;
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
    ArrayList<String> myDataset5;
    ArrayList<String> myDataset6;
    ArrayList<String> myDataset7;
    ArrayList<String> myDataset8;
    ArrayList<String> myDataset9;
    ArrayList<String> myDataset10;
    MyAdapter myAdapter;
    static LinearLayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calender_view, container, false);
        textView30 = (TextView) view.findViewById(R.id.text001);
        textView4 = (TextView) view.findViewById(R.id.text4);
        mList = (RecyclerView) view.findViewById(R.id.list_view);

        if (getWorksheet.getRow10(0) != null) {
            textView30.setVisibility(View.INVISIBLE);
        }
        Date date = new Date();
        SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String str = bartDateFormat.format(date);

        info = (TextView) view.findViewById(R.id.info);
        dataView = (DataView) view.findViewById(R.id.week);
        dataView.getData("");

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab_go_to_add_calendar);
        fab.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Calenderview_Addcalender.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            //pause
        } else {
            myDataset = new ArrayList<>();
            myDataset2 = new ArrayList<>();
            myDataset3 = new ArrayList<>();
            myDataset4 = new ArrayList<>();
            myDataset5 = new ArrayList<>();

            myDataset6 = new ArrayList<>();
            myDataset7 = new ArrayList<>();
            myDataset8 = new ArrayList<>();
            myDataset9 = new ArrayList<>();
            myDataset10 = new ArrayList<>();
            myAdapter = new MyAdapter(myDataset);
            textView4.setVisibility(View.VISIBLE);
            for (int i = 0; i < getWorksheet.calendarLength; i++) {
                myDataset.add(getWorksheet.getRow9(i));
                myDataset2.add(getWorksheet.getRow10(i));
                myDataset3.add(getWorksheet.getRow11(i));
                myDataset4.add(getWorksheet.getRow12(i));
                myDataset5.add(getWorksheet.getRow36(i));
                Log.d("get0000", String.valueOf(getWorksheet.calendarLength) + "calendarLength_resume");
            }
            if (myDataset10.size() == 0) {
                textView30.setVisibility(View.GONE);
            }
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
            public TextView TextView0001, TextView0002, TextView0003, TextView0004, TextView0005, TextView33;
            public ImageButton btn_edit,btn_delete;

            public ViewHolder(View v) {
                super(v);
                TextView0001 = (TextView) v.findViewById(R.id.textView0001);
                TextView0002 = (TextView) v.findViewById(R.id.textView0002);
                TextView0003 = (TextView) v.findViewById(R.id.textView0003);
                TextView0004 = (TextView) v.findViewById(R.id.textView0004);
                TextView0005 = (TextView) v.findViewById(R.id.textView0005);
                TextView33 = (TextView) v.findViewById(R.id.textView33);
                btn_edit = (ImageButton) v.findViewById(R.id.btn_edit);

                TextView33.setOnClickListener(new View.OnClickListener() {
                    Boolean flag = true;

                    @Override
                    public void onClick(View v) {
                        if (flag) {
                            flag = false;
                            TextView0002.setMaxLines(5);
                            TextView0002.setEllipsize(null); // 展开
                            TextView33.setText("摺疊內容");
                        } else {
                            flag = true;
                            TextView0002.setLines(1);
                            TextView0002.setEllipsize(TextUtils.TruncateAt.END); // 收缩
                            TextView33.setText("查看更多");
                        }
                    }
                });

                btn_edit.setOnClickListener(new  View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(getActivity(), Calenderview_Editcalender.class);
                        startActivity(intent);
                    }
                });//換頁至編輯工作安排

            }
        }

        public MyAdapter(List<String> data) {
            mData = data;
        }


        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.calenderview_item, parent, false);
            ViewHolder vh = new ViewHolder(v);

            dataView.setOnSelectListener(new DataView.OnSelectListener() {
                @Override
                public void onSelected(DateEntity date) {
                    textView4.setVisibility(View.GONE);
                    myDataset.clear();
                    myDataset2.clear();
                    myDataset3.clear();
                    myDataset4.clear();
                    myDataset5.clear();
                    myDataset6.clear();
                    myDataset7.clear();
                    myDataset8.clear();
                    myDataset9.clear();
                    myDataset10.clear();
                    for (int i = 0; i < getWorksheet.calendarLength; i++) {
                        myDataset.add(getWorksheet.getRow9(i));
                        myDataset2.add(getWorksheet.getRow10(i));
                        myDataset3.add(getWorksheet.getRow11(i));
                        myDataset4.add(getWorksheet.getRow12(i));
                        myDataset5.add(getWorksheet.getRow36(i));
                        Log.v("555", myDataset5.get(i) + "%5");
                    }
                    Log.v("555", date.date + "date999");
                    for (int i = 0; i < getWorksheet.calendarLength; i++) {
                        if (myDataset5.get(i).equals(date.date)) {
                            myDataset6.add(myDataset.get(i));
                            myDataset7.add(myDataset2.get(i));
                            myDataset8.add(myDataset3.get(i));
                            myDataset9.add(myDataset4.get(i));
                            myDataset10.add(myDataset5.get(i));
//                            Log.v("555",myDataset10.get(i)+"%10");
                        }
                    }
                    if (myDataset10.size() == 0) {
                        myDataset.clear();
                        myDataset2.clear();
                        myDataset3.clear();
                        myDataset4.clear();
                        myDataset5.clear();
                        myDataset6.clear();
                        myDataset7.clear();
                        myDataset8.clear();
                        myDataset9.clear();
                        myDataset10.clear();
                        layoutManager = new LinearLayoutManager(getActivity());
                        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        mList.setLayoutManager(layoutManager);
                        mList.setAdapter(myAdapter);
                        textView30.setVisibility(View.VISIBLE);
                    } else {
                        int j = myDataset10.size();
                        Log.v("555", myDataset5.size() + "88");
                        myDataset.clear();
                        myDataset2.clear();
                        myDataset3.clear();
                        myDataset4.clear();
                        myDataset5.clear();
                        Log.v("555", myDataset6.get(0) + "88");
                        for (int i = 0; i < j; i++) {
                            myDataset.add(myDataset6.get(i));
                            myDataset2.add(myDataset7.get(i));
                            myDataset3.add(myDataset8.get(i));
                            myDataset4.add(myDataset9.get(i));
                            myDataset5.add(myDataset10.get(i));
                            Log.v("555", myDataset5.get(i) + "gg");
                        }
                        layoutManager = new LinearLayoutManager(getActivity());
                        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                        mList.setLayoutManager(layoutManager);
                        mList.setAdapter(myAdapter);
                        textView30.setVisibility(View.GONE);

                    }
                }
            });
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.TextView0001.setText(mData.get(position));
            holder.TextView0002.setText(myDataset2.get(position));
            holder.TextView0003.setText(myDataset3.get(position));
            holder.TextView0004.setText(myDataset4.get(position));
            holder.TextView0005.setText(myDataset5.get(position));
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
