package ntub107202.hostel;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class Fragment_Jobview extends Fragment {
    static TextView textView0;
    static TextView textView1;
    static TextView textView2;
    static TextView textView3;
    static TextView textView4;
    static String[] row = new String[100];
    static String row5;
    static String row6;
    static String row7;
    static String row8;
    static String row00;
    RecyclerView mList;
    ArrayList<String> myDataset;
    ArrayList<String> myDataset2;
    ArrayList<String> myDataset3;
    ArrayList<String> myDataset4;
    MyAdapter  myAdapter;
    static LinearLayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_job_view,container,false);
        setrow();

//        myDataset = new ArrayList<>();
//        myDataset2 = new ArrayList<>();
//        myDataset3 = new ArrayList<>();
//        myDataset4 = new ArrayList<>();
        Button button01 = (Button)view.findViewById(R.id.btn_go_add_job);
//        myAdapter = new MyAdapter(myDataset);
//        for(int i = 0; i < getWorksheet.jobLength; i++){
//            myDataset.add(i + "");
//            Log.d("get0000", String.valueOf(getWorksheet.jobLength));
//        }
        mList = (RecyclerView)view.findViewById(R.id.list_view);
//        layoutManager = new LinearLayoutManager(getActivity());
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//
//        mList.setLayoutManager(layoutManager);
//        mList.setAdapter(myAdapter);
//        textView0 = (TextView)view.findViewById(R.id.text01);
//        textView1 = (TextView)view.findViewById(R.id.text02);
//        textView2 = (TextView)view.findViewById(R.id.text03);
//        textView3 = (TextView)view.findViewById(R.id.text04);
//        textView4 = (TextView)view.findViewById(R.id.text05);

//        if(textView1.getText() != ""){
//            textView0.setVisibility(View.INVISIBLE);
//        }
        button01.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(),Jobview_Addjob.class);
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
            for(int i = 0; i < getWorksheet.jobLength; i++){
//                myDataset.add(i + "");
                myDataset.add(getWorksheet.getRow5(i));
                myDataset2.add(getWorksheet.getRow6(i));
                myDataset3.add(getWorksheet.getRow7(i));
                myDataset4.add(getWorksheet.getRow8(i));
                Log.d("get0000", String.valueOf(getWorksheet.jobLength)+"resume");
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
    public static void setrow(){
        Log.v("get0000",getWorksheet.jobLength + "");

        for (int i = 0 ; i < getWorksheet.jobLength; i ++ ){
            row[i] = getWorksheet.getRow5(i);

        }
        for (int i = 0 ; i < getWorksheet.jobLength; i ++ ){
            Log.v("get0000",  row[i]+"xxx");
        }
    }
//    public static void setrow5(String row){
//        row5 = row;
////        textView1.setText(row5 );
////
//  }
//    public static void setrow6(String row){
//        row6 = row;
////        textView2.setText(row6);
//    }
//    public static void setrow7(String row){
//        row7 = row;
////        textView3.setText(row7 );
////
//    }
//    public static void setrow8(String row){
//        row8 = row;
////        textView4.setText(row8);
//    }
}
