package cos.timetable.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import cos.timetable.database.adapters.DBAdapter;
import cos.timetable.database.utils.LessonContentValuesBuilder;
import cos.timetable.database.utils.ListUtilities;
import cos.timetable.model.Lesson;

import static cos.timetable.database.utils.DBQueryStrings.GET_ALL;
import static cos.timetable.database.utils.DBTableHeaders.KEY_ID;
import static cos.timetable.database.utils.DBTableHeaders.TABLE_NAME;


public class LessonDao {
    private DBAdapter dbAdapter;
    private SQLiteDatabase database;
    private Context context;

    public LessonDao(Context context) {
        dbAdapter = DBAdapter.getInstance();
        this.context = context;
    }

    public void save(Lesson lesson) {
        database = dbAdapter.open(context);
        ContentValues values = LessonContentValuesBuilder.createContentValuesByGroup(lesson);
        database.insert(TABLE_NAME, null, values);
        dbAdapter.close();
    }

    public void update(Lesson lesson) {
        database = dbAdapter.open(context);
        ContentValues values = LessonContentValuesBuilder.createContentValuesByGroup(lesson);
        String where = KEY_ID + "=" + lesson.getId();
        database.update(TABLE_NAME, values, where, null);
        dbAdapter.close();
    }

    public void delete(Lesson lesson) {
        database = dbAdapter.open(context);
        String where = KEY_ID + "=" + lesson.getId();
        database.delete(TABLE_NAME, KEY_ID + "=?", new String[]{String.valueOf(lesson.getId())});
        dbAdapter.close();
    }

    public ArrayList<Lesson> getAllLessons(String day) {
        database = dbAdapter.open(context);
        String query = GET_ALL + " WHERE day = ?";
        Cursor cursor = database.rawQuery(query, new String[] {day});
        ArrayList<Lesson> lessons = ListUtilities.getAllLessons(cursor);
        cursor.close();
        database.close();

        return lessons;
    }

    public int getCount(String day) {
        database = dbAdapter.open(context);
        String query = GET_ALL + " WHERE day = ?";
        Cursor cursor = database.rawQuery(query, new String[] {day});
        int count = cursor.getCount();
        database.close();

        return count;
    }

}
