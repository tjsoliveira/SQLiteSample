package br.com.android.teste;

import static android.provider.BaseColumns._ID;
import static br.com.android.teste.Constants.*;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PlayerDatabase {

	private static String[] FROM = { _ID, NAME, AGE };
	private static String ORDER_BY = AGE + " DESC";

	private PlayersData pd;
	private ContentValues values;
	private SQLiteDatabase db;

	public PlayerDatabase(Context ctx) {

		this.pd = new PlayersData(ctx);
		this.values = new ContentValues();
	}

	public void insert(String name, int age) {
		values.put(NAME, name);
		values.put(AGE, age);
		db = pd.getWritableDatabase();
		db.insertOrThrow(TABLE_NAME, null, values);
	}

	public int delete(int id){
		db = pd.getWritableDatabase();
		String where = Constants._ID + "=" + id;
		return db.delete(Constants.TABLE_NAME, where, null);
	}
	
	public void update(int id, String name, String age){

		db = pd.getWritableDatabase();
		String where = Constants._ID + "=" + id;

		ContentValues newValues = new ContentValues();
		newValues.put(NAME, name);
		newValues.put(AGE, age);

		db.update(TABLE_NAME, newValues, where, null);
	}
	
	public Player select(int id){
		db = pd.getReadableDatabase();
		String selection = Constants._ID + "=" + id;
		Cursor cursor = db.query(TABLE_NAME, FROM, selection, null, null, null, null);
		cursor.moveToFirst();
		
		return new Player(cursor.getString(1),cursor.getInt(2));
	}
	
	public Cursor getPlayers() {

		db = pd.getReadableDatabase();
		Cursor cursor = db.query(TABLE_NAME, FROM, null, null, null,
				null, ORDER_BY);
		//act.startManagingCursor(cursor);
		return cursor;
	}

	public StringBuilder showPlayers(Cursor cursor) {

		StringBuilder builder = new StringBuilder( 
				"Players:\n");
		while (cursor.moveToNext()) { 

			long id = cursor.getLong(0); 
			String name = cursor.getString(1);
			int age = cursor.getInt(2);
			builder.append(id).append(": "); 
			builder.append(name).append(": ");
			builder.append(age).append("\n");
		}

		return builder;
	}

	public void deleteAll(){
		db = pd.getWritableDatabase();
		db.delete(Constants.TABLE_NAME, null, null);
	}

	public void close(){
		this.db.close();
	}
}
