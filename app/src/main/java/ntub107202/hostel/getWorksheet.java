package ntub107202.hostel;

import android.util.Log;

import ntub107202.hostel.Common.Common;
import ntub107202.hostel.MyAsyncTask.NavigationAsyncTask;
import ntub107202.hostel.MyAsyncTask.getAsyncTask;
import ntub107202.hostel.MyAsyncTask.postUpdateAsyncTask;
import ntub107202.hostel.MyAsyncTask.postUpdateAsyncTask2;
import ntub107202.hostel.MyAsyncTask.postUpdateAsyncTask3;
import ntub107202.hostel.MyAsyncTask.postUpdateAsyncTask4;
import ntub107202.hostel.MyAsyncTask.postUpdateAsyncTask5;

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
    private static String[] row14= new String[100];
    private static String[] row15= new String[100];
    private static String[] row16= new String[100];
    private static String[] row17= new String[100];
    private static String[] row18= new String[100];
    private static String[] row19= new String[100];
    private static String[] row20= new String[100];
    private static String[] row21= new String[100];
    private static String[] row22= new String[100];
    private static String[] row23= new String[100];
    private static String[] row24= new String[100];
    private static String[] row25= new String[100];
    private static String[] row26= new String[100];
    private static String[] row27= new String[100];
    private static String[] row28= new String[100];
    private static String[] row29= new String[100];
    private static String[] row30= new String[100];
    private static String[] row31= new String[100];
    private static String[] row32= new String[100];
    private static String[] row33= new String[100];
    private static String[] row34= new String[100];
    private static String[] row35= new String[100];
    private static String[] row36= new String[100];
    private static String[] row37= new String[100];

    private static String[] row38= new String[100];
    private static String[] row39= new String[100];
    private static String[] row40= new String[100];

    private static String[] row41= new String[100];
    private static String[] row42= new String[100];
    private static String[] row43= new String[100];
    private static String[] row44= new String[100];
    private static String[] row45= new String[100];
    private static String[] row46= new String[100];
    private static String[] row47= new String[100];
    private static String[] row48= new String[100];
    private static String[] row49= new String[100];

    private static String[] row111= new String[100];
    private static String[] row112= new String[100];
    private static String[] row113= new String[100];
    private static String[] row114= new String[100];
    private static String[] row115= new String[100];



    private static String[] row999= new String[100];

    private static int worksheetLength ;
    public static int humanLength;
    public static int jobLength;
    public static int calendarLength;
    public static int hostelinfoLength;
    public static int hostelnameLength;
    public static int resumeLength;

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

    public static void getuidJSON() {

        getAsyncTask myAsyncTask = new getAsyncTask(new getAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
                try {
                    JSONObject object = new JSONObject(result);

                    JSONArray jsonArray = object.getJSONArray("result");
                    int j=0;
                    Log.v("get0000",jobLength + "ergegje");
                    for (int i = 0 ; i<jobLength ; i++){
                        row999[i] = jsonArray.getJSONObject(i).getString("row1");
                        Log.v("Row5", row5[i]);

                    }
                } catch (Exception e) {
                    Log.v("ABC", Log.getStackTraceString(e));
                }
            }
        });
        myAsyncTask.execute(Common.getuid);
    }

    public static void gethumansearchJSON() {

        getAsyncTask myAsyncTask = new getAsyncTask(new getAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
                try {
                    JSONObject object = new JSONObject(result);

                    JSONArray jsonArray = object.getJSONArray("result");
                    worksheetLength = jsonArray.length();
                    humanLength = worksheetLength;
                    int j=0;
                    Log.v("get0000",humanLength + "human");
                    for (int i = 0 ; i<humanLength ; i++){
                        row13[i] = jsonArray.getJSONObject(i).getString("name");
                        row14[i] = jsonArray.getJSONObject(i).getString("school");
                        row15[i] = jsonArray.getJSONObject(i).getString("jobExp");
                        row16[i] = jsonArray.getJSONObject(i).getString("exchangeReason");
                        row17[i] = jsonArray.getJSONObject(i).getString("face");
                        row18[i] = jsonArray.getJSONObject(i).getString("gender");
                        row19[i] = jsonArray.getJSONObject(i).getString("birth");
                        row20[i] = jsonArray.getJSONObject(i).getString("cellphone");
                        row21[i] = jsonArray.getJSONObject(i).getString("address");
                        row22[i] = jsonArray.getJSONObject(i).getString("email");
                        row23[i] = jsonArray.getJSONObject(i).getString("lifePhoto");
                        row24[i] = jsonArray.getJSONObject(i).getString("studyState");
                        row25[i] = jsonArray.getJSONObject(i).getString("interest");
                        row26[i] = jsonArray.getJSONObject(i).getString("eatingHabit");
                        row27[i] = jsonArray.getJSONObject(i).getString("startingDate");
                        row28[i] = jsonArray.getJSONObject(i).getString("endingDate");
                        row29[i] = jsonArray.getJSONObject(i).getString("collectionList");
                        row30[i] = jsonArray.getJSONObject(i).getString("department");
                        row31[i] = jsonArray.getJSONObject(i).getString("gardening");
                        row40[i] = jsonArray.getJSONObject(i).getString("studentAccount");
                        row49[i] = jsonArray.getJSONObject(i).getString("lineId");

                        Log.v("Row17", row17[i]);
                        Log.v("Rowline", row49[i]);

                    }
                } catch (Exception e) {
                    Log.v("ABC", Log.getStackTraceString(e));
                }
            }
        });
        myAsyncTask.execute(Common.getHumanSearch);
    }

    public static void getjobJSON() {

            NavigationAsyncTask myNavigationAsyncTask = new NavigationAsyncTask(new NavigationAsyncTask.TaskListener() {
                @Override
                public void onFinished(String result) {
                    try{
                        JSONObject object = new JSONObject(result);
                        JSONArray jsonArray = object.getJSONArray("result");

                        worksheetLength = jsonArray.length();
                        jobLength = worksheetLength;

                        for (int i = 0 ; i < jsonArray.length(); i++){
                            row111[i] = jsonArray.getJSONObject(i).getString("row1");
                            row112[i] = jsonArray.getJSONObject(i).getString("row2");
                            row113[i] = jsonArray.getJSONObject(i).getString("row3");
                            row114[i] = jsonArray.getJSONObject(i).getString("row4");
                        }
                        JSONArray jsonArray2 = object.getJSONArray("result2");

                        for(int i = 0 ; i< jsonArray2.length();i++){
                            row115[i] = jsonArray2.getJSONObject(i).getString("row6");
                            Log.v("uuuu",row115[i]);
                        }

                        //-----------------------------------------取得目前版本----------------------------------
                    }catch(Exception e){

                    }
                }
            });
            myNavigationAsyncTask.execute(Common.getjob, MainActivityLogin.getUser()); //第一個參數是Common的網址,第二個是要上傳的值
        /*
        getAsyncTask myAsyncTask = new getAsyncTask(new getAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
                try {
                    JSONObject object = new JSONObject(result);

                    JSONArray jsonArray = object.getJSONArray("result");
                    worksheetLength = jsonArray.length();
                    jobLength = worksheetLength;
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
        */
    }
    public static void gethostelnameJSON() {

        getAsyncTask myAsyncTask = new getAsyncTask(new getAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
                try {
                    JSONObject object = new JSONObject(result);

                    JSONArray jsonArray = object.getJSONArray("result");
                    worksheetLength = jsonArray.length();
                    hostelnameLength = worksheetLength;
                    int j=0;

                    for (int i = 0 ; i<getWorksheetLength() ; i++){
                        row38[i] = jsonArray.getJSONObject(i).getString("row1");

                        Log.v("66668", getWorksheet.row38[i]);
//                        Log.v("66668", getWorksheet.row35[i]);

                    }
                } catch (Exception e) {
                    Log.v("ABC", Log.getStackTraceString(e));
                }
            }
        });
        myAsyncTask.execute(Common.getHostelname);
    }
    public static void getcalendarJSON() {

        getAsyncTask myAsyncTask = new getAsyncTask(new getAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
                try {
                    JSONObject object = new JSONObject(result);

                    JSONArray jsonArray = object.getJSONArray("result");
                    worksheetLength = jsonArray.length();
                    calendarLength = worksheetLength;
                    int j=0;

                    for (int i = 0 ; i<getWorksheetLength() ; i++){
                        row9[i] = jsonArray.getJSONObject(i).getString("row1");
                        row10[i] = jsonArray.getJSONObject(i).getString("row2");
                        row11[i] = jsonArray.getJSONObject(i).getString("row3");
                        row12[i] = jsonArray.getJSONObject(i).getString("row4");
                        row36[i] = jsonArray.getJSONObject(i).getString("row5");
                        Log.v("Row5", row36[i]);
                    }
                } catch (Exception e) {
                    Log.v("ABC", Log.getStackTraceString(e));
                }
            }
        });
        myAsyncTask.execute(Common.getCalendar);
    }
    public static void gethostelinfoJSON() {

        NavigationAsyncTask myNavigationAsyncTask = new NavigationAsyncTask(new NavigationAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
                try {
                    JSONObject object = new JSONObject(result);
                    JSONArray jsonArray = object.getJSONArray("result");
                    worksheetLength = jsonArray.length();
                    hostelinfoLength = worksheetLength;
                    int j=0;
                    Log.v("0000000",hostelinfoLength + "66666666");
                    for (int i = 0 ; i<hostelinfoLength ; i++){
                        row32[i] = jsonArray.getJSONObject(i).getString("row1");
                        row33[i] = jsonArray.getJSONObject(i).getString("row2");
                        row34[i] = jsonArray.getJSONObject(i).getString("row3");
                        row35[i] = jsonArray.getJSONObject(i).getString("row4");
                        row39[i] = jsonArray.getJSONObject(i).getString("row5");
                        Log.v("row39", row33[i]);
                        Log.v("row39", row39[i]);

                    }
                    Setting_Hotelinfo.start_sethostelname = true;
                } catch (Exception e) {
//                    Log.v("ABC", Log.getStackTraceString(e));
                }
            }
        });
        myNavigationAsyncTask.execute(Common.getHostelinfo, MainActivityLogin.getUser());
    }
    public static void getResumeJSON() {

        NavigationAsyncTask myNavigationAsyncTask = new NavigationAsyncTask(new NavigationAsyncTask.TaskListener() {
            @Override
            public void onFinished(String result) {
                try {
                    JSONObject object = new JSONObject(result);
                    JSONArray jsonArray = object.getJSONArray("result");
                    worksheetLength = jsonArray.length();
                    resumeLength = worksheetLength;
                    int j=0;
                    Log.v("0000000",resumeLength + "66666666");
                    for (int i = 0 ; i<resumeLength ; i++){
                        row41[i] = jsonArray.getJSONObject(i).getString("row1");
                        row42[i] = jsonArray.getJSONObject(i).getString("row2");
                        row43[i] = jsonArray.getJSONObject(i).getString("row3");
                        row44[i] = jsonArray.getJSONObject(i).getString("row4");
                        row45[i] = jsonArray.getJSONObject(i).getString("row5");
                        row46[i] = jsonArray.getJSONObject(i).getString("row6");
                        row47[i] = jsonArray.getJSONObject(i).getString("row7");
                        row48[i] = jsonArray.getJSONObject(i).getString("row8");
                        Log.v("row41", row41[i]);//履歷編號
                        Log.v("row42", row42[i]);//學生帳號
                        Log.v("row43", row43[i]);//民宿編號
                        Log.v("row44", row44[i]);//學生姓名
                        Log.v("row45", row45[i]);//就讀學校
                        Log.v("row46", row46[i]);//工作經驗
                        Log.v("row47", row47[i]);//換宿原因
                        Log.v("row48", row48[i]);//學生的臉
                    }
                    //Setting_Hotelinfo.start_sethostelname = true;
                } catch (Exception e) {
//                    Log.v("ABC", Log.getStackTraceString(e));
                }
            }
        });
        myNavigationAsyncTask.execute(Common.getResumeH, MainActivityLogin.getUser());
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
    public static void postToCalendar(String row1, String row2, String row3, String row4, String row5,String row6) {
        postUpdateAsyncTask2 myAsyncTask = new postUpdateAsyncTask2(new postUpdateAsyncTask2.TaskListener() {
            @Override
            public void onFinished(String result) {
            }
        });
        if(!myAsyncTask.isCancelled()) {
            //執行上傳動作
            myAsyncTask.execute(Common.postCalendar ,row1,row2,row3,row4,row5,row6);
        }
    }
    public static void postToQuestion(String row1 , String row2) {
        postUpdateAsyncTask3 myAsyncTask = new postUpdateAsyncTask3(new postUpdateAsyncTask3.TaskListener() {
            @Override
            public void onFinished(String result) {
            }
        });
        if(!myAsyncTask.isCancelled()) {
            //執行上傳動作
            myAsyncTask.execute(Common.postQuestionH ,row1,row2);
        }
    }
    public static void postToResume(String row1 , String row2, String row3) {
        postUpdateAsyncTask5 myAsyncTask = new postUpdateAsyncTask5(new postUpdateAsyncTask5.TaskListener() {
            @Override
            public void onFinished(String result) {
            }
        });
        if(!myAsyncTask.isCancelled()) {
            //執行上傳動作
            myAsyncTask.execute(Common.postResumeHostel2Student ,row1,row2,row3);
        }
    }
    public static void postToHotel(String row1, String row2, String row3, String row4, String row5, String row6, String row7, String row8 , String row9) {
        postUpdateAsyncTask4 myAsyncTask = new postUpdateAsyncTask4(new postUpdateAsyncTask4.TaskListener() {
            @Override
            public void onFinished(String result) {
            }
        });
        if(!myAsyncTask.isCancelled()) {
            //執行上傳動作
            myAsyncTask.execute(Common.postHotel ,row1,row2,row3,row4,row5,row6,row7,row8,row9);
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
    public static String getRow13(int i){
        return row13[i];
    }
    public static String getRow14(int i){
        return row14[i];
    }
    public static String getRow15(int i){
        return row15[i];
    }
    public static String getRow16(int i){
        return row16[i];
    }

    public static String getRow17(int i){
        return row17[i];
    }
    public static String getRow18(int i){
        return row18[i];
    }
    public static String getRow19(int i){
        return row19[i];
    }
    public static String getRow20(int i){
        return row20[i];
    }
    public static String getRow21(int i){
        return row21[i];
    }
    public static String getRow22(int i){
        return row22[i];
    }
    public static String getRow23(int i){
        return row23[i];
    }
    public static String getRow24(int i){
        return row24[i];
    }
    public static String getRow25(int i){
        return row25[i];
    }
    public static String getRow26(int i){
        return row26[i];
    }
    public static String getRow27(int i){
        return row27[i];
    }
    public static String getRow28(int i){
        return row28[i];
    }
    public static String getRow29(int i){
        return row29[i];
    }
    public static String getRow30(int i){
        return row30[i];
    }
    public static String getRow31(int i){
        return row31[i];
    }
    public static String getRow32(int i){
        return row32[i];
    }
    public static String getRow33(int i){
        return row33[i];
    }
    public static String getRow34(int i){
        return row34[i];
    }
    public static String getRow35(int i){
        return row35[i];
    }

    public static String getRow36(int i){
        return row36[i];
    }
    public static String getRow37(int i){
        return row37[i];
    }

    public static String getRow38(int i){
        return row38[i];
    }
    public static String getRow39(int i){
        return row39[i];
    }
    public static String getRow40(int i){
        return row40[i];
    }

    public static String getRow41(int i){
        return row41[i];
    }
    public static String getRow42(int i){
        return row42[i];
    }
    public static String getRow43(int i){
        return row43[i];
    }
    public static String getRow44(int i){
        return row44[i];
    }
    public static String getRow45(int i){
        return row45[i];
    }
    public static String getRow46(int i){
        return row46[i];
    }
    public static String getRow47(int i){
        return row47[i];
    }
    public static String getRow48(int i){
        return row48[i];
    }
    public static String getRow49(int i){
        return row49[i];
    }

    public static String getRow111(int i){
        return row111[i];
    }
    public static String getRow112(int i){
        return row112[i];
    }
    public static String getRow113(int i){
        return row113[i];
    }
    public static String getRow114(int i){
        return row114[i];
    }
    public static String getRow115(int i){
        return row115[i];
    }
}
