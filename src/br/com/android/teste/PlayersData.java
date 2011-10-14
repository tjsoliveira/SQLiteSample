package br.com.android.teste;

import static br.com.android.teste.Constants.*;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PlayersData extends SQLiteOpenHelper {
   private static final String DATABASE_NAME = "players.db";
   private static final int DATABASE_VERSION = 1;

   private final String SQL = "CREATE TABLE " + TABLE_NAME + " (" 
							  + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
							  + NAME + " TEXT NOT NULL," 
							  + AGE + " INTEGER NOT NULL);";
   
   public PlayersData(Context ctx) { 
      super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
   }

   @Override
   public void onCreate(SQLiteDatabase db) { 
      db.execSQL(SQL);
   }

   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, 
         int newVersion) {
      db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
      onCreate(db);
   }
}