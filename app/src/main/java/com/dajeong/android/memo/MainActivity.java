package com.dajeong.android.memo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editTitle, editAuthor, editMemo;
    Button btnPost;

    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //데이터베이스 초기화하고
        dbHelper = new DBHelper(this);
        //쓰기 가능상태로 연결
        db = dbHelper.getWritableDatabase();

        editTitle = findViewById(R.id.editTitle);
        editAuthor = findViewById(R.id.editAuthor);
        editMemo = findViewById(R.id.editMemo);
        btnPost = findViewById(R.id.btnPost);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = editTitle.getText().toString();
                String author = editAuthor.getText().toString();
                String memo = editMemo.getText().toString();
                long date = System.currentTimeMillis(); //현재시간 넣기

                String insertQuery = "insert into memo(title, memo, author, date)" +
                        " values('"+title+"', '"+memo+"', '"+author+"', "+date+")";

                db.execSQL(insertQuery); //데이터가 들어감.

                //새로운 엑티비티 호출
                Intent intent = new Intent(getBaseContext(), ListActivity.class);
                startActivity(intent);
                //현재 엑티비티 종료
                finish();
            }
        });
    }
}
