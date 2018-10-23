package ntub107202.hostel;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Fragment_Humansearch extends Fragment {
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
    ArrayList<String> myDataset11;
    ArrayList<String> myDataset12;
    ArrayList<String> myDataset13;
    ArrayList<String> myDataset14;
    ArrayList<String> myDataset15;
    ArrayList<String> myDataset16;
    ArrayList<String> myDataset17;
    ArrayList<String> myDataset18;
    ArrayList<String> myDataset19;
    MyAdapter myAdapter;
    static LinearLayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_humansearch,container,false);
        mList = (RecyclerView)view.findViewById(R.id.list_view);
        setJobview();
        return view;
    }
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){

            //pause
        }else{
            setJobview();
            //resume
        }
    }
    public void  setJobview(){
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
        myDataset11 = new ArrayList<>();
        myDataset12 = new ArrayList<>();
        myDataset13 = new ArrayList<>();
        myDataset14 = new ArrayList<>();
        myDataset15 = new ArrayList<>();
        myDataset16 = new ArrayList<>();
        myDataset17 = new ArrayList<>();
        myDataset18 = new ArrayList<>();
        myDataset19 = new ArrayList<>();

        myAdapter = new MyAdapter(myDataset);
        for(int i = 0; i < getWorksheet.humanLength; i++){
//                myDataset.add(i + "");
            myDataset.add(getWorksheet.getRow13(i));
            myDataset2.add(getWorksheet.getRow14(i));
            myDataset3.add(getWorksheet.getRow15(i));
            myDataset4.add(getWorksheet.getRow16(i));
            myDataset5.add(getWorksheet.getRow17(i));
            myDataset6.add(getWorksheet.getRow18(i));
            myDataset7.add(getWorksheet.getRow19(i));
            myDataset8.add(getWorksheet.getRow20(i));
            myDataset9.add(getWorksheet.getRow21(i));
            myDataset10.add(getWorksheet.getRow22(i));
            myDataset11.add(getWorksheet.getRow23(i));
            myDataset12.add(getWorksheet.getRow24(i));
            myDataset13.add(getWorksheet.getRow25(i));
            myDataset14.add(getWorksheet.getRow26(i));
            myDataset15.add(getWorksheet.getRow27(i));
            myDataset16.add(getWorksheet.getRow28(i));
            myDataset17.add(getWorksheet.getRow29(i));
            myDataset18.add(getWorksheet.getRow30(i));
            myDataset19.add(getWorksheet.getRow31(i));

            Log.d("get0000", myDataset5.get(i)+"resume");
        }
//            mList = (RecyclerView)view.findViewById(R.id.list_view);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mList.setLayoutManager(layoutManager);
        mList.setAdapter(myAdapter);
    }
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private List<String> mData;
        private Context mContext;

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView TextView0001, TextView0002 ,TextView0003, TextView0004;
            public ImageView Img01;
            public CardView cardView;

            public ViewHolder(View v) {
                super(v);
                TextView0001 = (TextView) v.findViewById(R.id.textView0001);
                TextView0002 = (TextView) v.findViewById(R.id.textView0002);
                TextView0003 = (TextView) v.findViewById(R.id.textView0003);
                TextView0004 = (TextView) v.findViewById(R.id.textView0004);
                Img01 = (ImageView) v.findViewById(R.id.img01);
                cardView = (CardView) v.findViewById(R.id.card_view);
            }
        }

        public MyAdapter(List<String> data) {
            mData = data;
        }


        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            mContext = parent.getContext();
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.humansearch_item, parent, false);
            MyAdapter.ViewHolder vh = new MyAdapter.ViewHolder(v);

            vh.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i = new Intent(mContext, Humansearch_Info.class);
                    i.putExtra("row1",myDataset.get(vh.getAdapterPosition()));
                    i.putExtra("row2",myDataset2.get(vh.getAdapterPosition()));
                    i.putExtra("row3",myDataset3.get(vh.getAdapterPosition()));
                    i.putExtra("row4",myDataset4.get(vh.getAdapterPosition()));
                    i.putExtra("row5",myDataset5.get(vh.getAdapterPosition()));
                    i.putExtra("row6",myDataset6.get(vh.getAdapterPosition()));
                    i.putExtra("row7",myDataset7.get(vh.getAdapterPosition()));
                    i.putExtra("row8",myDataset8.get(vh.getAdapterPosition()));
                    i.putExtra("row9",myDataset9.get(vh.getAdapterPosition()));
                    i.putExtra("row10",myDataset10.get(vh.getAdapterPosition()));
                    i.putExtra("row11",myDataset11.get(vh.getAdapterPosition()));
                    i.putExtra("row12",myDataset12.get(vh.getAdapterPosition()));
                    i.putExtra("row13",myDataset13.get(vh.getAdapterPosition()));
                    i.putExtra("row14",myDataset14.get(vh.getAdapterPosition()));
                    i.putExtra("row15",myDataset15.get(vh.getAdapterPosition()));
                    i.putExtra("row16",myDataset16.get(vh.getAdapterPosition()));
                    i.putExtra("row17",myDataset17.get(vh.getAdapterPosition()));
                    i.putExtra("row18",myDataset18.get(vh.getAdapterPosition()));
                    i.putExtra("row19",myDataset19.get(vh.getAdapterPosition()));
                    mContext.startActivity(i);

                    Log.d("get0000", "1" + myDataset6);
                    mContext.startActivity(i);
                    Log.d("get0000", "test1"+myDataset);
                    Log.d("get0000", "test2"+myDataset2);
                    Log.d("get0000", "test3"+myDataset3);
                    Log.d("get0000", "test4"+myDataset4);
                    Log.d("get0000", "test5"+myDataset5);
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
            holder.Img01.setImageBitmap(stringToBitmap(myDataset5.get(position)));
            Log.d("get0000", "position" + myDataset5.get(position));
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }
    public Bitmap stringToBitmap(String string) {
        Bitmap bitmap = null;
        try {
            byte[] bitmapArray = Base64.decode(string, Base64.DEFAULT);
            bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0, bitmapArray.length);
            return bitmap;
        } catch (NullPointerException e) {
            e.getMessage();
            return null;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }
}
