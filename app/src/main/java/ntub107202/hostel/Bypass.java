package ntub107202.hostel;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Bypass extends AppCompatActivity {
    private Button button2;
    private ImageView[] imageViews = null;
    private ImageView imageView = null;
    private ViewPager advPager = null;
    private AtomicInteger what = new AtomicInteger(0);
    private boolean isContinue = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bypass);
        getWorksheet.getJSON();
        getWorksheet.getjobJSON();
        getWorksheet.getcalendarJSON();
        try {
            Thread.sleep(500); //1000為1秒
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 在程式onCreate時就可以調用

        //取得伺服器上JSON資料

        initViewPager();
        button2 = findViewById(R.id.buttonStdEntry);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openStd();
                Bypass.this.finish();
            }
        });

    }

    public void openStd(){
        Intent intent =new Intent(this, NavigationActivity.class);
        startActivity(intent);
    }
    private void initViewPager() {
        advPager = (ViewPager) findViewById(R.id.adv_pager);
        ViewGroup group = (ViewGroup) findViewById(R.id.viewGroup);

        ImageView img1 = new ImageView(this);
        ImageView img2 = new ImageView(this);
        ImageView img3 = new ImageView(this);
        ImageView img4 = new ImageView(this);
        ImageView img5 = new ImageView(this);
        ImageView img6 = new ImageView(this);
        ImageView img7 = new ImageView(this);

//		这里存放的是四张广告背景
        List<View> advPics = new ArrayList<View>();


        InputStream is1 = (InputStream)getResources().openRawResource(R.raw.p1);
        BitmapFactory.Options options1 = new BitmapFactory.Options();
        options1.inJustDecodeBounds = false;
        options1.inPreferredConfig = Bitmap.Config.ALPHA_8;
        options1.inSampleSize = 2;   // width，height設為原來的十分一
        Bitmap btp = BitmapFactory.decodeStream(is1, null, options1);
        img1.setImageBitmap(btp);
        advPics.add(img1);

        InputStream is2 = (InputStream)getResources().openRawResource(R.raw.p2);
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = false;
        options2.inPreferredConfig = Bitmap.Config.ALPHA_8;
//        options.inSampleSize = 10;   // width，height設為原來的十分一
        Bitmap btp2 = BitmapFactory.decodeStream(is2, null, options2);
        img2.setImageBitmap(btp2);
        advPics.add(img2);

        InputStream is3 = (InputStream)getResources().openRawResource(R.raw.p3);
        BitmapFactory.Options options3 = new BitmapFactory.Options();
        options3.inJustDecodeBounds = false;
        options3.inPreferredConfig = Bitmap.Config.ALPHA_8;
//        options.inSampleSize = 10;   // width，height設為原來的十分一
        Bitmap btp3 = BitmapFactory.decodeStream(is3, null, options3);
        img3.setImageBitmap(btp3);
        advPics.add(img3);

        InputStream is4 = (InputStream)getResources().openRawResource(R.raw.p4);
        BitmapFactory.Options options4 = new BitmapFactory.Options();
        options4.inJustDecodeBounds = false;
        options4.inPreferredConfig = Bitmap.Config.ALPHA_8;
//        options.inSampleSize = 10;   // width，height設為原來的十分一
        Bitmap btp4 = BitmapFactory.decodeStream(is4, null, options4);
        img4.setImageBitmap(btp4);
        advPics.add(img4);

        InputStream is5 = (InputStream)getResources().openRawResource(R.raw.p5);
        BitmapFactory.Options options5 = new BitmapFactory.Options();
        options5.inJustDecodeBounds = false;
        options5.inPreferredConfig = Bitmap.Config.ALPHA_8;
//        options.inSampleSize = 10;   // width，height設為原來的十分一
        Bitmap btp5 = BitmapFactory.decodeStream(is5, null, options5);
        img5.setImageBitmap(btp5);
        advPics.add(img5);

//		对imageviews进行填充
        imageViews = new ImageView[advPics.size()];
//小图标
        for (int i = 0; i < advPics.size(); i++) {
            imageView = new ImageView(this);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(20, 20));
            imageView.setPadding(5, 5, 5, 5);
            imageViews[i] = imageView;
            if (i == 0) {
                imageViews[i]
                        .setBackgroundResource(R.drawable.logo1);
            } else {
                imageViews[i]
                        .setBackgroundResource(R.drawable.logo2);
            }
            group.addView(imageViews[i]);
        }

        advPager.setAdapter(new Bypass.AdvAdapter(advPics));
        advPager.setOnPageChangeListener(new Bypass.GuidePageChangeListener());
        advPager.setOffscreenPageLimit(5);
//        advPager.setOnTouchListener(new View.OnTouchListener() {
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                    case MotionEvent.ACTION_MOVE:
//                        isContinue = false;
//                        break;
//                    case MotionEvent.ACTION_UP:
//                        isContinue = true;
//                        break;
//                    default:
//                        isContinue = true;
//                        break;
//                }
//                return false;
//            }
//        });
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    if (isContinue) {
                        viewHandler.sendEmptyMessage(what.get());
                        whatOption();
                    }
                }
            }

        }).start();
    }


    private void whatOption() {
        what.incrementAndGet();
        if (what.get() > imageViews.length - 1) {
            what.getAndAdd(-4);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {

        }
    }

    private final Handler viewHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            advPager.setCurrentItem(msg.what);
            super.handleMessage(msg);
        }

    };

    private final class GuidePageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int arg0) {
            what.getAndSet(arg0);
            for (int i = 0; i < imageViews.length; i++) {
                imageViews[arg0]
                        .setBackgroundResource(R.drawable.logo1);
                if (arg0 != i) {
                    imageViews[i]
                            .setBackgroundResource(R.drawable.logo2);
                }
            }

        }

    }

    private final class AdvAdapter extends PagerAdapter {
        private List<View> views = null;

        public AdvAdapter(List<View> views) {
            this.views = views;
        }

//        @Override
//        public void destroyItem(View arg0, int arg1, Object arg2) {
//            ((ViewPager) arg0).removeView(views.get(arg1));
//        }

        @Override
        public void finishUpdate(View arg0) {

        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            ((ViewPager) arg0).addView(views.get(arg1), 0);
            return views.get(arg1);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {

        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {

        }

    }
       }

