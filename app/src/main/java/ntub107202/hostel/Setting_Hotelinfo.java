package ntub107202.hostel;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Setting_Hotelinfo extends AppCompatActivity {

    RecyclerView mList;
    ArrayList<String> myDataset;
    ArrayList<String> myDataset2;
    ArrayList<String> myDataset3;
    ArrayList<String> myDataset4;
    MyAdapter myAdapter;
    static LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_hotelinfo);
        getWorksheet.gethostelinfoJSON();
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab_go_to_add_hotel) ;
        mList = (RecyclerView)findViewById(R.id.list_view);
        setJobview();
        fab.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Setting_Hotelinfo.this,Hotelview_Addhotel.class);
                startActivity(intent);
            }
        });
    }
    public void  setJobview(){
        myDataset = new ArrayList<>();
        myDataset2 = new ArrayList<>();
        myDataset3 = new ArrayList<>();
        myDataset4 = new ArrayList<>();
        myAdapter = new MyAdapter(myDataset);
        for(int i = 0; i < getWorksheet.hostelinfoLength; i++){
//                myDataset.add(i + "");
            myDataset.add(getWorksheet.getRow32(i));
            myDataset2.add(getWorksheet.getRow33(i));
            myDataset3.add(getWorksheet.getRow34(i));
            myDataset4.add(getWorksheet.getRow35(i));
            Log.d("get99999", getWorksheet.getRow32(i));
        }
//            mList = (RecyclerView)view.findViewById(R.id.list_view);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mList.setLayoutManager(layoutManager);
        mList.setAdapter(myAdapter);
    }
    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private List<String> mData;

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView txt_hotel_name ,txt_hotel_address ,txt_hotel_phone;
            public  ImageView img_hotel_photo;

            public ViewHolder(View v) {
                super(v);
                img_hotel_photo = (ImageView) v.findViewById(R.id.img_hotel_photo);
                txt_hotel_name = (TextView) v.findViewById(R.id.txt_hotel_name);
                txt_hotel_address = (TextView) v.findViewById(R.id.txt_hotel_address);
                txt_hotel_phone = (TextView) v.findViewById(R.id.txt_hotel_phone);
            }
        }

        public MyAdapter(List<String> data) {
            mData = data;
        }


        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hotelview_item, parent, false);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
            holder.img_hotel_photo.setImageBitmap(stringToBitmap(mData.get(position)));
            holder.txt_hotel_name.setText(myDataset2.get(position));
            holder.txt_hotel_address.setText(myDataset3.get(position));
            holder.txt_hotel_phone.setText(myDataset4.get(position));
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
