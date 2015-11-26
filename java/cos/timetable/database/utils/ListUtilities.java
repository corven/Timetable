package cos.timetable.database.utils;

import android.database.Cursor;

import java.util.ArrayList;

import cos.timetable.model.Lesson;

import static cos.timetable.database.utils.DBTableHeaders.KEY_CABINET;
import static cos.timetable.database.utils.DBTableHeaders.KEY_DAY;
import static cos.timetable.database.utils.DBTableHeaders.KEY_ID;
import static cos.timetable.database.utils.DBTableHeaders.KEY_SUBJECT;
import static cos.timetable.database.utils.DBTableHeaders.KEY_TEACHER;
import static cos.timetable.database.utils.DBTableHeaders.KEY_TIME;
import static cos.timetable.database.utils.DBTableHeaders.KEY_TYPE;

public class ListUtilities {
    public static ArrayList<Lesson> getAllLessons(Cursor c) {
        ArrayList<Lesson> lessons = new ArrayList<>();

        if (c.moveToFirst()) {
            do {
                Lesson lesson = createLessonBy(c);
                lessons.add(lesson);
            }while (c.moveToNext());
        }

        return lessons;
    }

    private static Lesson createLessonBy(Cursor c) {
        int id = c.getInt(c.getColumnIndex(KEY_ID));
        String time = c.getString(c.getColumnIndex(KEY_TIME));
        String subject = c.getString(c.getColumnIndex(KEY_SUBJECT));
        String cabinet = c.getString(c.getColumnIndex(KEY_CABINET));
        String teacher = c.getString(c.getColumnIndex(KEY_TEACHER));
        String type = c.getString(c.getColumnIndex(KEY_TYPE));
        String day = c.getString(c.getColumnIndex(KEY_DAY));

        return new Lesson(id, time, subject, cabinet, teacher, type, day);
    }
}
