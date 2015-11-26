package cos.timetable.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cos.timetable.R;
import cos.timetable.model.Lesson;

public class LessonsAdapter extends ArrayAdapter<Lesson> {

    List<Lesson> lessons;

    public LessonsAdapter(Context context, List<Lesson> lessons) {
        super(context, R.layout.item_lesson, lessons);
        this.lessons = lessons;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_lesson, parent, false);
        }

        Lesson currentLesson = lessons.get(position);

        TextView time = (TextView) view.findViewById(R.id.tvTime);
        TextView subject = (TextView) view.findViewById(R.id.tvSubject);
        TextView cabinet = (TextView) view.findViewById(R.id.tvCabinet);
        TextView teacher = (TextView) view.findViewById(R.id.tvTeacher);
        TextView type = (TextView) view.findViewById(R.id.tvType);

        time.setText(currentLesson.getTime());
        subject.setText(currentLesson.getSubject());
        cabinet.setText(currentLesson.getCabinet());
        teacher.setText(currentLesson.getTeacher());
        type.setText(currentLesson.getType());

        return view;
    }
}
