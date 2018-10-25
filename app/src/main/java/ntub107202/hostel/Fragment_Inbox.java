package ntub107202.hostel;


import android.app.Fragment;
import android.content.Context;
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



public class Fragment_Inbox extends Fragment {
    RecyclerView mList;
    ArrayList<String> myDatasetName;
    ArrayList<String> myDatasetSchool;
    ArrayList<String> myDatasetWorkExp;
    ArrayList<String> myDatasetReason;
    ArrayList<String> myDatasetFace;
    static TextView txtNodata;
    MyAdapter myAdapter;
    static LinearLayoutManager layoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_inbox,container,false);
        TextView txtNodata = (TextView) view.findViewById(R.id.txtNodata);
                mList = (RecyclerView)view.findViewById(R.id.list_view);
        if(getWorksheet.getRow42(0) != null){
            txtNodata.setVisibility(View.INVISIBLE);
        }
        return view;
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(hidden){

            //pause
        }else{

            setResumeview();
            //resume
        }
    }
    public void  setResumeview(){
        myDatasetName = new ArrayList<>();
        myDatasetSchool = new ArrayList<>();
        myDatasetWorkExp = new ArrayList<>();
        myDatasetReason = new ArrayList<>();
        myDatasetFace = new ArrayList<>();

        myAdapter = new MyAdapter(myDatasetName);
        for(int i = 0; i < getWorksheet.resumeLength; i++){
//
            myDatasetName.add(getWorksheet.getRow44(i));
            myDatasetSchool.add(getWorksheet.getRow45(i));
            myDatasetWorkExp.add(getWorksheet.getRow46(i));
            myDatasetReason.add(getWorksheet.getRow47(i));
            myDatasetFace.add(getWorksheet.getRow48(i));

            Log.d("get0000", myDatasetFace.get(i)+"face");
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
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inboxview_item, parent, false);
            MyAdapter.ViewHolder vh = new MyAdapter.ViewHolder(v);

            vh.cardView.setOnClickListener(new View.OnClickListener() {
                int position;
                @Override
                public void onClick(View v) {
////                    Bundle bundle=new Bundle();
//                    bundle.putInt("position", vh.getAdapterPosition());
//                    Intent i=new Intent();
//                    i.putExtras(bundle);
//                    i.setClass(mContext, Humansearch_Info.class);
//                    mContext.startActivity(i);
                }
            });
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.TextView0001.setText(myDatasetName.get(position));
            holder.TextView0002.setText(myDatasetSchool.get(position));
            holder.TextView0003.setText(myDatasetWorkExp.get(position));
            holder.TextView0004.setText(myDatasetReason.get(position));
            holder.Img01.setImageBitmap(stringToBitmap(myDatasetFace.get(position)));
            Log.d("get0000", "position" + myDatasetFace.get(position));
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
