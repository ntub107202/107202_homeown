package ntub107202.hostel;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Fragment_Humansearch Fragment1HumanSearch;
    private Fragment_Jobview Fragment2JobView;
    private Fragment_Calenderview Fragment3CalenderView;
    private Fragment_Bosssetting Fragment4BossSetting;
    BottomNavigationView navigation;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Log.v("text", "abc");

            switch (item.getItemId()) {
                case R.id.navigation_people:
                    getWorksheet.gethumansearchJSON();
                    mTextMessage.setText("");
                    showNav(R.id.navigation_people);
                    return true;
                case R.id.navigation_publish:
                    getWorksheet.getjobJSON();
//                    Fragment2JobView.setrow5(getWorksheet.getRow5(0));
//                    Fragment2JobView.setrow6(getWorksheet.getRow6(0));
//                    Fragment2JobView.setrow7(getWorksheet.getRow7(0));
//                    Fragment2JobView.setrow8(getWorksheet.getRow8(0));
//                    if(Fragment2JobView.textView1.getText() != ""){
//                        Fragment2JobView.textView0.setVisibility(View.GONE);
//                    }
                    mTextMessage.setText("");
                    showNav(R.id.navigation_publish);
                    return true;
                case R.id.navigation_work:
                    getWorksheet.getjobJSON();
//                    Fragment3CalenderView.setrow9(getWorksheet.getRow9(0));
//                    Fragment3CalenderView.setrow10(getWorksheet.getRow10(0));
//                    Fragment3CalenderView.setrow11(getWorksheet.getRow11(0));
//                    Fragment3CalenderView.setrow12(getWorksheet.getRow12(0));
//                    if(Fragment3CalenderView.textView31.getText() != ""){
//                        Fragment3CalenderView.textView30.setVisibility(View.GONE);
//                    }
//                    mTextMessage.setText("");
                    mTextMessage.setText("");
                    showNav(R.id.navigation_work);
                    return true;
                case R.id.navigation_page:
                    mTextMessage.setText("");
                    showNav(R.id.navigation_page);
                    return true;
            }
            return false;
        }

    };

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        init();

        mTextMessage = (TextView) findViewById(R.id.message);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


    }

    @Override
    public void onResume() {
        getWorksheet.getjobJSON();
        int id = getIntent().getIntExtra("id", 0);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        switch (id) {
            case 1:
                beginTransaction.hide(Fragment2JobView).hide(Fragment3CalenderView).hide(Fragment4BossSetting);
                beginTransaction.show(Fragment1HumanSearch);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                navigation.getMenu().getItem(0).setChecked(true);
                break;
            case 2:
                beginTransaction.hide(Fragment1HumanSearch).hide(Fragment3CalenderView).hide(Fragment4BossSetting);
                beginTransaction.show(Fragment2JobView);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                navigation.getMenu().getItem(1).setChecked(true);
                break;
            case 3:
                beginTransaction.hide(Fragment2JobView).hide(Fragment1HumanSearch).hide(Fragment4BossSetting);
                beginTransaction.show(Fragment3CalenderView);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                navigation.getMenu().getItem(2).setChecked(true);
                break;
            case 4:
                beginTransaction.hide(Fragment1HumanSearch).hide(Fragment2JobView).hide(Fragment3CalenderView);
                beginTransaction.show(Fragment4BossSetting);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                mTextMessage.setText("");
                showNav(R.id.navigation_page);
                navigation.getMenu().getItem(3).setChecked(true);
                break;
        }

        super.onResume();
    }

    //    @Override
//    protected void onStart() {
//        super.onStart();
//        getWorksheet.getjobJSON();
//        // The activity is about to become visible.
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        getWorksheet.getjobJSON();
//        // The activity has become visible (it is now "resumed").
//    }
    //init（）用来初始化组件
    private void init() {
        Fragment1HumanSearch = new Fragment_Humansearch();
        Fragment2JobView = new Fragment_Jobview();
        Fragment3CalenderView = new Fragment_Calenderview();
        Fragment4BossSetting = new Fragment_Bosssetting();
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.add(R.id.content, Fragment1HumanSearch).add(R.id.content, Fragment2JobView).add(R.id.content, Fragment3CalenderView).add(R.id.content, Fragment4BossSetting);//开启一个事务将fragment动态加载到组件
        beginTransaction.hide(Fragment1HumanSearch).hide(Fragment2JobView).hide(Fragment3CalenderView).hide(Fragment4BossSetting);//隐藏fragment
        beginTransaction.addToBackStack(null);//返回到上一个显示的fragment
        beginTransaction.commit();//每一个事务最后操作必须是commit（），否则看不见效果
        showNav(R.id.navigation_people);

    }

    private void showNav(int navid) {
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        switch (navid) {
            case R.id.navigation_people:
                beginTransaction.hide(Fragment2JobView).hide(Fragment3CalenderView).hide(Fragment4BossSetting);
                beginTransaction.show(Fragment1HumanSearch);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.navigation_publish:
                beginTransaction.hide(Fragment1HumanSearch).hide(Fragment3CalenderView).hide(Fragment4BossSetting);
                beginTransaction.show(Fragment2JobView);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.navigation_work:
                beginTransaction.hide(Fragment2JobView).hide(Fragment1HumanSearch).hide(Fragment4BossSetting);
                beginTransaction.show(Fragment3CalenderView);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
            case R.id.navigation_page:
                beginTransaction.hide(Fragment1HumanSearch).hide(Fragment2JobView).hide(Fragment3CalenderView);
                beginTransaction.show(Fragment4BossSetting);
                beginTransaction.addToBackStack(null);
                beginTransaction.commit();
                break;
        }
    }
}
