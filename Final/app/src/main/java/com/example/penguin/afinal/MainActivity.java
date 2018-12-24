package com.example.penguin.afinal;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    protected static final String DB_NAME = "HotlineDB";
    protected static final String TB_NAME = "hotlist";
    protected static final int MAX = 8;
    protected static final String[] FROM = new String[] {"name","phone","email"};
    protected SQLiteDatabase db;
    protected Cursor cur;
    protected SimpleCursorAdapter adapter;
    protected EditText etName, etPrice, etText;
    protected Button btInsert, btUpdate, btDelete, btCal, btClear, clsbtnobj;
    protected ListView lv;
    protected TextView total, money;
    protected String str;
    protected int cost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Func();
    }


    private View.OnClickListener ClsBtn = new View.OnClickListener(){
        public void onClick(View v){
            AlertDialog.Builder bdr = new AlertDialog.Builder(MainActivity.this);
                    bdr.setTitle("Accounting_Manager (Beta)");
                    bdr.setIcon(R.mipmap.ic_launcher);
                    bdr.setCancelable(false);
                    bdr.setMessage("您即將離開程式");
                    bdr.setPositiveButton("確定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            MainActivity.this.onDestory();
                        }
                    });
                    bdr.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    bdr.show();
        }
    };

    private void onDestory() {
        super.onDestroy();
        System.exit(0);
    }


    public void onInsertUpdate(View v){
        String nameStr=etName.getText().toString().trim();
        String phoneStr=etPrice.getText().toString().trim();
        ///phoneStr = "NT."+phoneStr;
        String textStr=etText.getText().toString().trim();
        if(nameStr.length()==0 || /* 任一欄位的內容為空即返回 */
                phoneStr.length()==0)
            return;

        if(v.getId()==R.id.btUpdate) {
            /* 按更新鈕 */
            update(nameStr, phoneStr, textStr, cur.getInt(0));
            Toast.makeText(getApplicationContext(),"更新了一筆資料",Toast.LENGTH_SHORT).show();
        } else {
            /* 按新增鈕 */
            addData(nameStr, phoneStr, textStr);
            Toast.makeText(getApplicationContext(),"新增了一筆資料",Toast.LENGTH_SHORT).show();
        }
        requery(); /* 更新 Cursor 內容 */
    }
    private void update(String name, String phone, String email, int id) {
        ContentValues cv=new ContentValues(3);
        cv.put( FROM[0], name);
        cv.put( FROM[1], phone);
        cv.put( FROM[2], email);
        /* 更新 id 所指的欄位 */
        db.update(TB_NAME, cv, "_id="+id, null);
    }

    /* 重新查詢的自訂方法 */
    private void requery() {
        cur=db.rawQuery("SELECT * FROM "+TB_NAME, null);
        /* 更改 Adapter 的 Cursor */
        adapter.changeCursor(cur);
        /* 已達上限, 停用新增鈕 */
        if(cur.getCount() == MAX) {
            btInsert.setEnabled(false);
        } else {
            btInsert.setEnabled(true);
        }
        /* 停用更新鈕 */
        btUpdate.setEnabled(false);
        /* 停用刪除鈕 */
        btDelete.setEnabled(false);
    }

    private void addData(String name, String phone, String email) {
        /* 建立含 3 個欄位的 ContentValues 物件 */
        ContentValues cv = new ContentValues(3);
        cv.put( FROM[0], name);
        cv.put( FROM[1], phone);
        cv.put( FROM[2], email);
        /* 新增1筆記錄 */
        db.insert(TB_NAME, null, cv);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        /* 移動 Cursor 至使用者選取的項目 */
        cur.moveToPosition(position);
        /* 讀出姓名,電話,Email資料並顯示 */
        etName.setText(cur.getString(
                cur.getColumnIndex(FROM[0])));
        etPrice.setText(cur.getString(
                cur.getColumnIndex(FROM[1])));
        etText.setText(cur.getString(
                cur.getColumnIndex(FROM[2])));

        btUpdate.setEnabled(true); /* 啟用更新鈕 */
        btDelete.setEnabled(true); /* 啟用刪除鈕 */
    }

    protected void Func() {

        clsbtnobj = findViewById(R.id.clsbtn);
        clsbtnobj.setOnClickListener(ClsBtn);

        etName = (EditText)findViewById(R.id.etName);
        etPrice = (EditText)findViewById(R.id.etPrice);
        etText = (EditText)findViewById(R.id.etText);
        btInsert = (Button)findViewById(R.id.btInsert);
        btUpdate = (Button)findViewById(R.id.btUpdate);
        btDelete = (Button)findViewById(R.id.btDelete);
        btCal = (Button)findViewById(R.id.btCal);
        btClear = (Button)findViewById(R.id.btn_Clear);
        total = (TextView)findViewById(R.id.total);
        money = (TextView)findViewById(R.id.money);

        /* 開啟或建立資料庫 */
        db = openOrCreateDatabase(DB_NAME,  Context.MODE_PRIVATE, null);

        /* 建立資料表 */
        String createTable = "CREATE TABLE IF NOT EXISTS " + TB_NAME +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, " + /* 索引欄位 */
                "name VARCHAR(32), " +
                "phone VARCHAR(16), " +
                "email VARCHAR(64))";
        db.execSQL(createTable);

        cur = db.rawQuery("SELECT * FROM "+ TB_NAME, null); /* 查詢資料 */

        /* 若查詢結果是空的則寫入測試資料 */
        if(cur.getCount() == 0){
            addData("早餐","100","蛋餅");
            addData("交通","100","加油");
            addData("雜支","200","會費");
            addData("娛樂","300","電影");

            AlertDialog.Builder bdr = new AlertDialog.Builder(this);
            bdr.setTitle("Accounting_Manager (Beta)");
            bdr.setMessage("由於Database內部無資料\n"+"將自動匯入預設資料\n" + "請按任意鍵返回程式");
            bdr.setIcon(R.mipmap.ic_launcher);
            bdr.setCancelable(true);
            bdr.show();
        }

        adapter = new SimpleCursorAdapter(this,
                R.layout.table, cur,
                FROM,
                new int[] {R.id.name,R.id.price,R.id.Text}, 0);

        lv = (ListView)findViewById(R.id.lv);
        lv.setAdapter(adapter); /* 設定 Adapter */
        lv.setOnItemClickListener(this); /* 設定按下事件的監聽器 */
        requery(); /* 呼叫自訂方法, 重新查詢及設定按鈕狀態 */

        btUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onInsertUpdate(v);
                    }
                }
        );

        btDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        /* 刪除鈕的 On Click 事件方法 */
                        db.delete( TB_NAME, "_id=" + cur.getInt(0),null);
                        requery();
                        Toast.makeText(getApplicationContext(),"刪除了一筆資料",Toast.LENGTH_SHORT).show();

                    }
                }
        );

        btInsert.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onInsertUpdate(v);
                    }
                }
        );

        btCal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cur.moveToFirst()) {
                            total.setText("總共有" + cur.getCount() + "筆資料");
                            do {
                                str = cur.getString(
                                        cur.getColumnIndex(FROM[1]));
                                cost +=Integer.parseInt(str);
                            }while (cur.moveToNext());
                        }money.setText("共"+ cost + "元");
                        AlertDialog.Builder bdr = new AlertDialog.Builder(MainActivity.this);
                        bdr.setTitle("總共有" + cur.getCount() + "筆資料");
                        bdr.setCancelable(true);
                        bdr.setMessage("共"+ cost + "元");
                        bdr.show();

                        cost = 0;
                    }

                }
        );

        btClear.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (cur.getCount() != 0) {
                            if (cur.moveToFirst()) {
                                do {
                                    /* 刪除鈕的 On Click 事件方法 */
                                    db.delete(TB_NAME, "_id=" + cur.getInt(0), null);
                                    requery();
                                } while (cur.moveToLast());


                                total.setText("已清除資料");
                                money.setText("已清除資料");
                                cost = 0;

                                Toast.makeText(getApplicationContext(),"資料已全部清除",Toast.LENGTH_SHORT).show();

                            }
                        }
                    }
                }
        );


}
}
