package br.com.android.teste;

import android.provider.BaseColumns;

public interface Constants extends BaseColumns{

	public static final String TABLE_NAME = "players";
	
	//Declare columns in the players table
	public static final String NAME = "name";
	public static final String AGE = "age";
	
	//Declare index of each column of the table
	public static final int NAME_INDEX = 1;
	public static final int AGE_INDEX = 2;
}
