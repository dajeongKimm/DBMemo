package com.dajeong.android.memo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DBNAME = " memo.db";
    public static final int DBVERSION = 1;


    //SQLite 데이터베이스를 생성 - 없으면 생성, 있으면 연결
   // public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
        //name - 파일명 예) test.db ==> 이름은 잘 바뀌지 않으니까 상수처리함.
        //CursorFactory - 대용량 처리 보통 null
        //version - 데이타 베이스 버전
    }

    //최초에 SQLite를 생성했을 때 테이블을 만들어주는 영역
    @Override
    public void onCreate(SQLiteDatabase db) {
        //쿼리를 실행해서 앞으로 사용할 테이블을 만들어 준다.
        String createQuery = "create table memo("+
                " id integer not null primary key autoincrement" +
                " ,title text"+
                " ,memo text"+
                " ,author text"+
                " ,date integer)";

        db.execSQL(createQuery);

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //테이블 변경내역 쿼리를 실행


    }
}
