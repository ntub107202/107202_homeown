package ntub107202.hostel;

import android.util.Log;

import ntub107202.hostel.Common.Common;
import ntub107202.hostel.MyAsyncTask.getAsyncTask;
import ntub107202.hostel.MyAsyncTask.postUpdateAsyncTask;
import ntub107202.hostel.MyAsyncTask.postUpdateAsyncTask2;

import org.json.JSONArray;
import org.json.JSONObject;


public class getWorksheet {

    private static String[] row1= new String[100];
    private static String[] row2= new String[100];
    private static String[] row3= new String[100];
    private static String[] row4= new String[100];
    public static String[] row5= new String[100];
    private static String[] row6= new String[100];
    private static String[] row7= new String[100];
    private static String[] row8= new String[100];
    private static String[] row9= new String[100];
    private static String[] row10= new String[100];
    private static String[] row11= new String[100];
    private static String[] row12= new String[100];
    private static String[] row13= new String[100];

    private static int worksheetLength ;
    public static int jobLength;

    public static void getJSON() {

        getAsyncTask myAsyncTask = new getAsyncTask(new getAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
                try {
                    JSONObject object = new JSONObject(result);

                    JSONArray jsonArray = object.getJSONArray("result");
                    worksheetLength = jsonArray.length();

                    int j=0;

                    for (int i = 0 ; i<getWorksheetLength() ; i++){
                        row1[i] = jsonArray.getJSONObject(i).getString("row1");
                        row2[i] = jsonArray.getJSONObject(i).getString("row2");
                        row3[i] = jsonArray.getJSONObject(i).getString("row3");
                        row4[i] = jsonArray.getJSONObject(i).getString("row4");
                        Log.v("Row1", row1[i]);
                    }
                } catch (Exception e) {
                    Log.v("ABC", Log.getStackTraceString(e));
                }
            }
        });
        myAsyncTask.execute(Common.getUrl);
    }

    public static void getjobJSON() {

        getAsyncTask myAsyncTask = new getAsyncTask(new getAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
                try {
                    JSONObject object = new JSONObject(result);

                    JSONArray jsonArray = object.getJSONArray("result");
                    worksheetLength = jsonArray.length();
                    jobLength =worksheetLength;
                    int j=0;
                    Log.v("get0000",jobLength + "ergegje");
                    for (int i = 0 ; i<jobLength ; i++){
                        row5[i] = jsonArray.getJSONObject(i).getString("row1");
                        row6[i] = jsonArray.getJSONObject(i).getString("row2");
                        row7[i] = jsonArray.getJSONObject(i).getString("row3");
                        row8[i] = jsonArray.getJSONObject(i).getString("row4");
                        Log.v("Row5", row5[i]);

                    }
                } catch (Exception e) {
                    Log.v("ABC", Log.getStackTraceString(e));
                }
            }
        });
        myAsyncTask.execute(Common.getjob);
    }
    public static void getcalendarJSON() {

        getAsyncTask myAsyncTask = new getAsyncTask(new getAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
                try {
                    JSONObject object = new JSONObject(result);

                    JSONArray jsonArray = object.getJSONArray("result");
                    worksheetLength = jsonArray.length();

                    int j=0;

                    for (int i = 0 ; i<getWorksheetLength() ; i++){
                        row9[i] = jsonArray.getJSONObject(i).getString("row1");
                        row10[i] = jsonArray.getJSONObject(i).getString("row2");
                        row11[i] = jsonArray.getJSONObject(i).getString("row3");
                        row12[i] = jsonArray.getJSONObject(i).getString("row4");
//                        Log.v("Row5", row5[i]);
                    }
                } catch (Exception e) {
                    Log.v("ABC", Log.getStackTraceString(e));
                }
            }
        });
        myAsyncTask.execute(Common.getCalendar);
    }

    public static void postToPHP(String row1, String row2, String row3) {
        postUpdateAsyncTask myAsyncTask = new postUpdateAsyncTask(new postUpdateAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
            }
        });
        if(!myAsyncTask.isCancelled()) {
            //執行上傳動作
            myAsyncTask.execute(Common.postUrl ,row1,row2,row3);
        }
    }
    public static void postToJob(String row1, String row2, String row3, String row4, String row5, String row6, String row7, String row8, String row9, String row10, String row11, String row12, String row13) {
        postUpdateAsyncTask myAsyncTask = new postUpdateAsyncTask(new postUpdateAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
            }
        });
        if(!myAsyncTask.isCancelled()) {
            //執行上傳動作
            myAsyncTask.execute(Common.postJob ,row1,row2,row3,row4,row5,row6,row7,row8,row9,row10,row11,row12,row13);
        }
    }
    public static void postToCalendar(String row1, String row2, String row3, String row4, String row5) {
        postUpdateAsyncTask2 myAsyncTask = new postUpdateAsyncTask2(new postUpdateAsyncTask2.TaskListener() {
            @Override
            public void onFinished(String result) {
            }
        });
        if(!myAsyncTask.isCancelled()) {
            //執行上傳動作
            myAsyncTask.execute(Common.postCalendar ,row1,row2,row3,row4,row5);
        }
    }

    public static int getWorksheetLength(){
        return worksheetLength;
    }

    //        public static String[] getRow1(){
//            return row1;
//        }
//        public static String[] getRow2(){
//            return row2;
//        }
//        public static String[] getRow3(){
//        return row3;
//    }
//    public static String[] getRow4(){
//        return row4;
//    }
    public static String getRow5(int i){
        return row5[i];
    }
    public static String getRow6(int i){
        return row6[i];
    }
    public static String getRow7(int i){
        return row7[i];
    }
    public static String getRow8(int i){
        return row8[i];
    }
    public static String getRow9(int i){
        return row9[i];
    }
    public static String getRow10(int i){
        return row10[i];
    }
    public static String getRow11(int i){
        return row11[i];
    }
    public static String getRow12(int i){
        return row12[i];
    }

}
