package com.dajeong.android.memo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button btnPost;
    Adapter adapter;
    List<Memo> data = new ArrayList<>();

    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase(); // 목록이라 읽기만 하면 됨.

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new Adapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String insertQuery = "select * from memo";
        Cursor cursor = db.rawQuery(insertQuery,null);
        if(cursor != null){
            while(cursor.moveToNext()){

                Memo memo = new Memo();

                int index = cursor.getColumnIndex("id"); //컬럼의 번호 가져오기
                memo.id = cursor.getInt(index);              //컬럼번호로 실제 값 가져오기
                index = cursor.getColumnIndex("title");
                memo.title = cursor.getString(index);
                index = cursor.getColumnIndex("memo");
                memo.memo = cursor.getString(index);
                index = cursor.getColumnIndex("author");
                memo.author = cursor.getString(index);
                index = cursor.getColumnIndex("date");
                memo.date = cursor.getLong(index);

                data.add(memo);
            }
        }
        //아답터에 데이터 넣어줌.
        adapter.setData(data);

        btnPost = findViewById(R.id.btnPost);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
