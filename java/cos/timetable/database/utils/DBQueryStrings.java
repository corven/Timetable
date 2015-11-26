package cos.timetable.database.utils;

import static cos.timetable.database.utils.DBTableHeaders.*;

public class DBQueryStrings {
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + KEY_ID +
            " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_TIME + " TEXT, " + KEY_SUBJECT + " TEXT, " +
            KEY_CABINET + " TEXT, " + KEY_TEACHER + " TEXT, " + KEY_TYPE + " TEXT, " + KEY_DAY + " TEXT)";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    public static final String GET_ALL = "SELECT * FROM " + TABLE_NAME;
}
