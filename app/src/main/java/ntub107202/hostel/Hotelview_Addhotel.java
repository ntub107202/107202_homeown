package ntub107202.hostel;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Hotelview_Addhotel extends AppCompatActivity {
    EditText edit_hotel_name;
    Spinner spin_address;
    Spinner spin_area;
    EditText edit_hotel_address;
    EditText edit_hotel_phone;
    EditText edit_hotel_info;
    Button btn_add_hotel;

    private ImageView startCameraButton = null;
    private ImageView choiceFromAlbumButton = null;
    private ImageView choiceFromAlbumButton2 = null;
    private ImageView pictureImageView = null;

    private static final int TAKE_PHOTO_PERMISSION_REQUEST_CODE = 0; // 拍照的权限处理返回码
    private static final int WRITE_SDCARD_PERMISSION_REQUEST_CODE = 1; // 读储存卡内容的权限处理返回码

    private static final int TAKE_PHOTO_REQUEST_CODE = 3; // 拍照返回的 requestCode
    private static final int CHOICE_FROM_ALBUM_REQUEST_CODE = 4; // 相册选取返回的 requestCode
    private static final int CROP_PHOTO_REQUEST_CODE = 5; // 裁剪图片返回的 requestCode
    private static final int CROP_PHOTO_REQUEST_CODE2 = 6; // 裁剪图片返回的 requestCode

    private Uri photoUri = null;
    private Uri photoOutputUri = null; // 图片最终的输出文件的 Uri
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotelview_addhotel);
        edit_hotel_name = (EditText) findViewById(R.id.edit_hotel_name);
        spin_address = (Spinner) findViewById(R.id.spin_address);
        spin_area = (Spinner) findViewById(R.id.spin_area);
        edit_hotel_address = (EditText) findViewById(R.id.edit_hotel_address);
        edit_hotel_phone=(EditText) findViewById(R.id.edit_hotel_phone);
        edit_hotel_info=(EditText) findViewById(R.id.edit_hotel_info);

//        startCameraButton = (ImageView) findViewById(null);
//        startCameraButton.setOnClickListener(clickListener);
        choiceFromAlbumButton = (ImageView) findViewById(R.id.img_license);
        choiceFromAlbumButton.setOnClickListener(clickListener);
        choiceFromAlbumButton2 = (ImageView) findViewById(R.id.img_pic);
        choiceFromAlbumButton2.setOnClickListener(clickListener);

        Button button01 = (Button) findViewById(R.id.btn_add_hotel);

        //--------------------------
        //取得伺服器上JSON資料
        //--------------------------
        button01.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("8888888", spin_address.getSelectedItem().toString());
                Log.v("8888888", spin_area.getSelectedItem().toString());
                getWorksheet.postToHotel(edit_hotel_name.getText().toString(), spin_address.getSelectedItem().toString(), spin_area.getSelectedItem().toString() , edit_hotel_address.getText().toString() , edit_hotel_phone.getText().toString(), edit_hotel_info.getText().toString());
                Log.d("get0000", String.valueOf(getWorksheet.jobLength) + "post");
                getWorksheet.getJSON();
                getWorksheet.getjobJSON();
                Log.d("get0000", String.valueOf(getWorksheet.jobLength) + "get");
                getWorksheet.getcalendarJSON();
                Intent intent = new Intent(Hotelview_Addhotel.this,Setting_Hotelinfo.class);
                intent.putExtra("id",2);
                startActivity(intent);
            }
        });

        if(ContextCompat.checkSelfPermission(Hotelview_Addhotel.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // 申请读写内存卡内容的权限
            ActivityCompat.requestPermissions(Hotelview_Addhotel.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_SDCARD_PERMISSION_REQUEST_CODE);
        }
        final Spinner spin_address = (Spinner)findViewById(R.id.spin_address);
        final Spinner spin_area = (Spinner)findViewById(R.id.spin_area);
        final String[] Keelung = {"仁愛區","中正區","信義區","中山區","安樂區","暖暖區","七堵區"};
        final String[] Taipei = {"中正區","大同區","中山區","松山區","大安區","萬華區","信義區","士林區","北投區","內湖區","南港區","文山區"};
        final String[] NewTaipei = {"板橋區","新莊區","中和區","永和區","土城區","樹林區","三峽區","鶯歌區","三重區","蘆洲區","五股區","泰山區","林口區","八里區","淡水區","三芝區","石門區","金山區","萬里區","汐止區","瑞芳區","貢寮區","平溪區","雙溪區","新店區","深坑區","石碇區","坪林","烏來區"};
        final String[] Taoyuan = {"桃園區","中壢區","平鎮區","八德區","楊梅區","蘆竹區","大溪區","龍潭區","龜山區","大園區","觀音區","新屋區","復興區"};
        final String[] Hsinchu = {"東區","北區","香山區"};
        final String[] Hsinchu2 = {"竹北市","竹東鎮","新埔鎮","關西鎮","湖口鄉","新豐鄉","峨眉鄉","寶山鄉","北埔鄉","芎林鄉","橫山鄉","尖石鄉","五峰鄉"};
        final String[] Miaoli = {"苗栗市","頭份市","竹南鎮","後龍鎮","通霄鎮","苑裡鎮","卓蘭鎮","造橋鄉","西湖鄉","頭屋鄉","公館鄉","銅鑼鄉","三義鄉","大湖鄉","獅潭鄉","三灣鄉","南庄鄉","泰安鄉"};
        final String[] Taichung = {"中區","東區","南區","西區","北區","北屯區","西屯區","南屯區","太平區","大里區","霧峰區","烏日區","豐原區","后里區","石岡區","東勢區","新社區","潭子區","大雅區","神岡區","大肚區","沙鹿區","龍井區","梧棲區","清水區","大甲區","外埔區","大安區","和平區"};
        final String[] Nantou = {"南投市","埔里鎮","草屯鎮","竹山鎮","集集鎮","名間鄉","鹿谷鄉","中寮鄉","魚池鄉","國姓鄉","水里鄉","信義鄉","仁愛鄉"};
        final String[] Changhua = {"彰化市","員林市","和美鎮","鹿港鎮","溪湖鎮","二林鎮","田中鎮","北斗鎮","花壇鄉","芬園鄉","大村鄉","永靖鄉","伸港鄉","線西鄉","福興鄉","秀水鄉","埔心鄉","埔鹽鄉","大城鄉","芳苑鄉","竹塘鄉","社頭鄉","二水鄉","田尾鄉","埤頭鄉","溪州鄉"};
        final String[] Yunlin = {"斗六市","斗南鎮","虎尾鎮","西螺鎮","土庫鎮","北港鎮","林內鄉","古坑鄉","大埤鄉","莿桐鄉","褒忠鄉","二崙鄉","崙背鄉","麥寮鄉","臺西鄉","東勢鄉","元長鄉","四湖鄉","口湖鄉","水林鄉"};
        final String[] Chiayi = {"東區","西區"};
        final String[] Chiayi2 = {"太保市","朴子市","布袋鎮","大林鎮","民雄鄉","溪口鄉","新港鄉","六腳鄉","東石鄉","義竹鄉","鹿草鄉","水上鄉","中埔鄉","竹崎鄉","梅山鄉","番路鄉","大埔鄉","阿里山鄉"};
        final String[] Tainan = {"中西區","東區","南區","北區","安平區","安南區","永康區","歸仁區","新化區","左鎮區","玉井區","楠西區","南化區","仁德區","關廟區","龍崎區","官田區","麻豆區","佳里區","西港區","七股區","將軍區","學甲區","北門區","新營區","後壁區","白河區","東山區","六甲區","下營區","柳營區","鹽水區","善化區","大內區","山上區","新市區","安定區"};
        final String[] Kaohsiung = {"楠梓區","左營區","鼓山區","三民區","鹽埕區","前金區","新興區","苓雅區","前鎮區","旗津區","小港區","鳳山區","大寮區","鳥松區","林園區","仁武區","大樹區","大社區","岡山區","路竹區","橋頭區","梓官區","彌陀區","永安區","燕巢區","田寮區","阿蓮區","茄萣區","湖內區","旗山區","美濃區","內門區","杉林區","甲仙區","六龜區","茂林區","桃源區","那瑪夏區"};
        final String[] Pingtung = {"屏東市","潮州鎮","東港鎮","恆春鎮","萬丹鄉","長治鄉","麟洛鄉","九如鄉","里港鄉","鹽埔鄉","高樹鄉","萬巒鄉","內埔鄉","竹田鄉","新埤鄉","枋寮鄉","新園鄉","崁頂鄉","林邊鄉","南州鄉","佳冬鄉","琉球鄉","車城鄉","滿州鄉","枋山鄉","霧臺鄉","瑪家鄉","泰武鄉","來義鄉","春日鄉","獅子鄉","牡丹鄉","三地門鄉"};
        final String[] Yilan = {"宜蘭市","頭城鎮","羅東鎮","蘇澳鎮","礁溪鄉","壯圍鄉","員山鄉","冬山鄉","五結鄉","三星鄉","大同鄉","南澳鄉"};
        final String[] Hualien  = {"花蓮市","鳳林鎮","玉里鎮","新城鄉","吉安鄉","壽豐鄉","光復鄉","豐濱鄉","瑞穗鄉","富里鄉","秀林鄉","萬榮鄉","卓溪鄉"};
        final String[] Taitung = {"臺東市","成功鎮","關山鎮","長濱鄉","池上鄉","東河鄉","鹿野鄉","卑南鄉","大武鄉","綠島鄉","太麻里鄉","海端鄉","延平鄉","金峰鄉","達仁鄉","蘭嶼鄉"};
        final String[] Penghu = {"馬公市","湖西鄉","白沙鄉","西嶼鄉","望安鄉","七美鄉"};
        final String[] Kinmen = {"金城鎮","金湖鎮","金沙鎮","金寧鄉","烈嶼鄉","烏坵鄉"};
        final String[] Lienchiang = {"南竿鄉","北竿鄉","莒光鄉","東引鄉"};

        spin_address.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Hotelview_Addhotel.this, "你選的是" + spin_address.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                switch (spin_address.getSelectedItem().toString()) {
                    case "基隆市":
                        ArrayAdapter<String> KeelungList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Keelung);
                        spin_area.setAdapter(KeelungList);
                        break;
                    case "台北市":
                        ArrayAdapter<String> TaipeiList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Taipei);
                        spin_area.setAdapter(TaipeiList);
                        break;
                    case "新北市":
                        ArrayAdapter<String> NewTaipeiList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                NewTaipei);
                        spin_area.setAdapter(NewTaipeiList);
                        break;
                    case "桃園市":
                        ArrayAdapter<String> TaoyuanList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Taoyuan);
                        spin_area.setAdapter(TaoyuanList);
                        break;
                    case "新竹市":
                        ArrayAdapter<String> HsinchuList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Hsinchu);
                        spin_area.setAdapter(HsinchuList);
                        break;
                    case "新竹縣":
                        ArrayAdapter<String> Hsinchu2List = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Hsinchu2);
                        spin_area.setAdapter(Hsinchu2List);
                        break;
                    case "苗栗縣":
                        ArrayAdapter<String> MiaoliList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Miaoli);
                        spin_area.setAdapter(MiaoliList);
                        break;
                    case "台中市":
                        ArrayAdapter<String> TaichungList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Taichung);
                        spin_area.setAdapter(TaichungList);
                        break;
                    case "南投縣":
                        ArrayAdapter<String> NantouList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Nantou);
                        spin_area.setAdapter(NantouList);
                        break;
                    case "彰化縣":
                        ArrayAdapter<String> ChanghuaList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Changhua);
                        spin_area.setAdapter(ChanghuaList);
                        break;
                    case "雲林縣":
                        ArrayAdapter<String> YunlinList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Yunlin);
                        spin_area.setAdapter(YunlinList);
                        break;
                    case "嘉義市":
                        ArrayAdapter<String> ChiayiList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Chiayi);
                        spin_area.setAdapter(ChiayiList);
                        break;
                    case "嘉義縣":
                        ArrayAdapter<String> Chiayi2List = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Chiayi2);
                        spin_area.setAdapter(Chiayi2List);
                        break;
                    case "台南市":
                        ArrayAdapter<String> TainanList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Tainan);
                        spin_area.setAdapter(TainanList);
                        break;
                    case "高雄市":
                        ArrayAdapter<String> KaohsiungList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Kaohsiung);
                        spin_area.setAdapter(KaohsiungList);
                        break;
                    case "屏東縣":
                        ArrayAdapter<String> PingtungList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Pingtung);
                        spin_area.setAdapter(PingtungList);
                        break;
                    case "宜蘭縣":
                        ArrayAdapter<String> YilanList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Yilan);
                        spin_area.setAdapter(YilanList);
                        break;
                    case "花蓮縣":
                        ArrayAdapter<String> HualienList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Hualien);
                        spin_area.setAdapter(HualienList);
                        break;
                    case "台東縣":
                        ArrayAdapter<String> TaitungList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Taitung);
                        spin_area.setAdapter(TaitungList);
                        break;
                    case "澎湖縣":
                        ArrayAdapter<String> PenghuList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Penghu);
                        spin_area.setAdapter(PenghuList);
                        break;
                    case "金門縣":
                        ArrayAdapter<String> KinmenList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Kinmen);
                        spin_area.setAdapter(KinmenList);
                        break;
                    case "連江縣":
                        ArrayAdapter<String> LienchiangList = new ArrayAdapter<>(Hotelview_Addhotel.this,
                                android.R.layout.simple_spinner_dropdown_item,
                                Lienchiang);
                        spin_area.setAdapter(LienchiangList);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // 调用相机拍照
            if(v == startCameraButton) {
                // 同上面的权限申请逻辑
                if(ContextCompat.checkSelfPermission(Hotelview_Addhotel.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    /*
                     * 下面是对调用相机拍照权限进行申请
                     */
                    ActivityCompat.requestPermissions(Hotelview_Addhotel.this,
                            new String[]{Manifest.permission.CAMERA,}, TAKE_PHOTO_PERMISSION_REQUEST_CODE);
                } else {
//                    startCamera();
                }
                // 从相册获取
            } else if(v == choiceFromAlbumButton) {
                choiceFromAlbum();
            }
            else if(v == choiceFromAlbumButton2) {
                choiceFromAlbum2();
            }
        }
    };

    /**
     * 拍照
     */
//    private void startCamera() {
//        /**
//         * 设置拍照得到的照片的储存目录，因为我们访问应用的缓存路径并不需要读写内存卡的申请权限，
//         * 因此，这里为了方便，将拍照得到的照片存在这个缓存目录中
//         */
//        File file = new File(getExternalCacheDir(), "image.jpg");
//        try {
//            if(file.exists()) {
//                file.delete();
//            }
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        /**
//         * 因 Android 7.0 开始，不能使用 file:// 类型的 Uri 访问跨应用文件，否则报异常，
//         * 因此我们这里需要使用内容提供器，FileProvider 是 ContentProvider 的一个子类，
//         * 我们可以轻松的使用 FileProvider 来在不同程序之间分享数据(相对于 ContentProvider 来说)
//         */
//        if(Build.VERSION.SDK_INT >= 24) {
//            photoUri = FileProvider.getUriForFile(this, "com.zhi_dian.provider", file);
//        } else {
//            photoUri = Uri.fromFile(file); // Android 7.0 以前使用原来的方法来获取文件的 Uri
//        }
//        // 打开系统相机的 Action，等同于："android.media.action.IMAGE_CAPTURE"
//        Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        // 设置拍照所得照片的输出目录
//        takePhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
//        startActivityForResult(takePhotoIntent, TAKE_PHOTO_REQUEST_CODE);
//    }

    /**
     * 从相册选取
     */
    private void choiceFromAlbum() {
        // 打开系统图库的 Action，等同于: "android.intent.action.GET_CONTENT"
        Intent choiceFromAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
        // 设置数据类型为图片类型
        choiceFromAlbumIntent.setType("image/*");
        startActivityForResult(choiceFromAlbumIntent, CHOICE_FROM_ALBUM_REQUEST_CODE);
    }
    private void choiceFromAlbum2() {
        // 打开系统图库的 Action，等同于: "android.intent.action.GET_CONTENT"
        Intent choiceFromAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
        // 设置数据类型为图片类型
        choiceFromAlbumIntent.setType("image/*");
        startActivityForResult(choiceFromAlbumIntent, 6);
    }


    /**
     * 裁剪图片
     */
    private void cropPhoto(Uri inputUri) {
        // 调用系统裁剪图片的 Action
        Intent cropPhotoIntent = new Intent("com.android.camera.action.CROP");
        // 设置数据Uri 和类型
        cropPhotoIntent.setDataAndType(inputUri, "image/*");
        // 授权应用读取 Uri，这一步要有，不然裁剪程序会崩溃
        cropPhotoIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        // 设置图片的最终输出目录
        cropPhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                photoOutputUri = Uri.parse("file:////sdcard/image_output.jpg"));
        startActivityForResult(cropPhotoIntent, CROP_PHOTO_REQUEST_CODE);
    }
    private void cropPhoto2(Uri inputUri) {
        // 调用系统裁剪图片的 Action
        Intent cropPhotoIntent = new Intent("com.android.camera.action.CROP");
        // 设置数据Uri 和类型
        cropPhotoIntent.setDataAndType(inputUri, "image/*");
        // 授权应用读取 Uri，这一步要有，不然裁剪程序会崩溃
        cropPhotoIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        // 设置图片的最终输出目录
        cropPhotoIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                photoOutputUri = Uri.parse("file:////sdcard/image_output.jpg"));
        startActivityForResult(cropPhotoIntent, 7);
    }

    /**
     * 在这里进行用户权限授予结果处理
     * @param requestCode 权限要求码，即我们申请权限时传入的常量
     * @param permissions 保存权限名称的 String 数组，可以同时申请一个以上的权限
     * @param grantResults 每一个申请的权限的用户处理结果数组(是否授权)
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            // 调用相机拍照：
            case TAKE_PHOTO_PERMISSION_REQUEST_CODE:
                // 如果用户授予权限，那么打开相机拍照
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    startCamera();
                } else {
                    Toast.makeText(this, "拍照权限被拒绝", Toast.LENGTH_SHORT).show();
                }
                break;
            // 打开相册选取：
            case WRITE_SDCARD_PERMISSION_REQUEST_CODE:
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    Toast.makeText(this, "读写内存卡内容权限被拒绝", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    /**
     * 通过这个 activity 启动的其他 Activity 返回的结果在这个方法进行处理
     * 我们在这里对拍照、相册选择图片、裁剪图片的返回结果进行处理
     * @param requestCode 返回码，用于确定是哪个 Activity 返回的数据
     * @param resultCode 返回结果，一般如果操作成功返回的是 RESULT_OK
     * @param data 返回对应 activity 返回的数据
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            // 通过返回码判断是哪个应用返回的数据
            switch (requestCode) {
                // 拍照
                case TAKE_PHOTO_REQUEST_CODE:
                    cropPhoto(photoUri);
                    break;
                // 相册选择
                case CHOICE_FROM_ALBUM_REQUEST_CODE:
                    cropPhoto(data.getData());
                    break;
                // 裁剪图片
                case CROP_PHOTO_REQUEST_CODE:
                    File file = new File(photoOutputUri.getPath());
                    if(file.exists()) {
                        Bitmap bitmap = BitmapFactory.decodeFile(photoOutputUri.getPath());
                        choiceFromAlbumButton.setImageBitmap(bitmap);
//                        file.delete(); // 选取完后删除照片
                    } else {
                        Toast.makeText(this, "找不到照片", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case 6:
                    cropPhoto2(data.getData());
                    break;
                // 裁剪图片
                case 7:
                    File file2 = new File(photoOutputUri.getPath());
                    if(file2.exists()) {
                        Bitmap bitmap = BitmapFactory.decodeFile(photoOutputUri.getPath());
                        choiceFromAlbumButton2.setImageBitmap(bitmap);
//                        file.delete(); // 选取完后删除照片
                    } else {
                        Toast.makeText(this, "找不到照片", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    }
}
