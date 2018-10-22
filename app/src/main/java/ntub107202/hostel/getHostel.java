package ntub107202.hostel;

import android.content.Intent;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import ntub107202.hostel.Common.Common;
import ntub107202.hostel.MyAsyncTask.NavigationAsyncTask;
import ntub107202.hostel.MainActivityLogin;

public class getHostel {
        public static String row1 ;
        public static String row2 ;
        public static String row3 ;
        public static String row4 ;
        public static void getHostel(){
        //---------------------------上傳使用者的裝置ID及新增15筆record的紀錄
        NavigationAsyncTask myNavigationAsyncTask = new NavigationAsyncTask(new NavigationAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
                try{
                    JSONObject object = new JSONObject(result);
                    JSONArray jsonArray = object.getJSONArray("result");

                    for (int i = 0 ; i < jsonArray.length(); i++){
                        row1 = jsonArray.getJSONObject(i).getString("row1");
                        row2 = jsonArray.getJSONObject(i).getString("row2");
                        row3 = jsonArray.getJSONObject(i).getString("row3");
                        row4 = jsonArray.getJSONObject(i).getString("row4");
                        Log.v("tttttt",row1);
                    }
                    //-----------------------------------------取得目前版本----------------------------------
                }catch(Exception e){

                }
            }
        });
        myNavigationAsyncTask.execute(Common.getjob, MainActivityLogin.getUser()); //第一個參數是Common的網址,第二個是要上傳的值
    }
    }
