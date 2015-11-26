package cos.timetable.database.utils;

import android.content.ContentValues;

import cos.timetable.model.Lesson;
import static cos.timetable.database.utils.DBTableHeaders.*;

public class LessonContentValuesBuilder {
    public static ContentValues createContentValuesByGroup(Lesson lesson) {
        ContentValues values = new ContentValues();

        values.put(KEY_TIME, lesson.getTime());
        values.put(KEY_SUBJECT, lesson.getSubject());
        values.put(KEY_CABINET, lesson.getCabinet());
        values.put(KEY_TEACHER, lesson.getTeacher());
        values.put(KEY_TYPE, lesson.getType());
        values.put(KEY_DAY, lesson.getDay());

        return values;
    }
}
