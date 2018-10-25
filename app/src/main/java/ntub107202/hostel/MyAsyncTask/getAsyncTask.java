package ntub107202.hostel.MyAsyncTask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class getAsyncTask extends AsyncTask<String, Integer, String> {

    //----------------------------------------
    // 宣告一個接收回傳結果的程式必須實作的介面
    //----------------------------------------
    public interface TaskListener {
        void onFinished(String result);
    }

    private TaskListener taskListener;

    //-----------------------------------------------------------
    // 建構元, 傳入(1)context, (2)取回資料後執行的程式
    //-----------------------------------------------------------
    public getAsyncTask(TaskListener taskListener) {
        this.taskListener = taskListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    //========================================
    // 由主程式呼叫.execute()方法時啟動,
    // 由主程式傳入:(1)主機網址
    //========================================
    @Override
    protected String doInBackground(String... params) {
        String data=null;
        InputStream inputStream = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        try {
            URL url = new URL(params[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            //conn.setDoInput(true);
            //conn.setDoOutput(true);

            int statusCode = conn.getResponseCode();

            Log.v("Test2","statuus:"+statusCode);

            conn.connect();
            inputStream = conn.getInputStream();



            if (statusCode >= 200 && statusCode < 400) {
                // Create an InputStream in order to extract the response object
                inputStream = conn.getInputStream();
            }
            else {
                inputStream = conn.getErrorStream();
            }


            BufferedReader bufferedReader=new BufferedReader(
                    new InputStreamReader(inputStream, "utf-8"));

            data=bufferedReader.readLine();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    //------------------------------------------------------------------
    // 完成資料取回後, 由主程式的taskListener.onFinished()處理取回資料
    //------------------------------------------------------------------
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        taskListener.onFinished(result);
        Log.d("Tag onPostExecute", String.valueOf(Thread.currentThread().getId()));
    }

    @Override
    protected void onCancelled(String result) {
        super.onCancelled(result);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}
