package com.example.penguin.sqlitetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    protected static  int MAX = 8;
    protected SQLiteDatabase db;
    protected Cursor cur;
    protected SimpleCursorAdapter adapter;
    protected String[] FROM = new String[] {"name","phone","email"};
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

    }
    private View.OnClickListener ClsBtn = new View.OnClickListener(){
        public void onClick(View v){
            MainActivity.this.onDestroy();
        }
    };

    private  void onDestory(){
        super.onDestroy();
        System.exit(0);
    }

    public void onInsertUpdate(View v){
        String nameStr=etName.getText().toString().trim();
        String phoneStr=etPrice.getText().toString().trim();
        ///phoneStr = "NT."+phoneStr;
        String emailStr=etText.getText().toString().trim();
        if(nameStr.length()==0 || /* 任一欄位的內容為空即返回 */
                phoneStr.length()==0)
            return;

        if(v.getId()==R.id.btUpdate) {
            /* 按更新鈕 */
            update(nameStr, phoneStr, emailStr, cur.getInt(0));
        } else {
            /* 按新增鈕 */
            addData(nameStr, phoneStr, emailStr);
        }
        requery(); /* 更新 Cursor 內容 */
    }
    private void update(String name, String phone, String email, int id) {
        ContentValues cv=new ContentValues(3);
        cv.put( FROM[0], name);
        cv.put( FROM[1], phone);
        cv.put( FROM[2], email);
        /* 更新 id 所指的欄位 */
        db.execSQL("INSERT INTO mytable(name, phone, email)VALUES(?,?,?)",F);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
