package cos.timetable.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cos.timetable.R;
import cos.timetable.activities.AddLessonActivity;
import cos.timetable.adapters.LessonsAdapter;
import cos.timetable.database.dao.LessonDao;
import cos.timetable.model.Lesson;

import static cos.timetable.database.utils.DBTableHeaders.KEY_CABINET;
import static cos.timetable.database.utils.DBTableHeaders.KEY_SUBJECT;
import static cos.timetable.database.utils.DBTableHeaders.KEY_TEACHER;
import static cos.timetable.database.utils.DBTableHeaders.KEY_TIME;
import static cos.timetable.database.utils.DBTableHeaders.KEY_TYPE;

public class FragmentWednesday extends Fragment {

    private static final int ADD = 0;
    private static final String DAY = "Среда";

    ListView lvLessons;
    ArrayAdapter<Lesson> adapter;
    LessonDao lessonDao;

    ArrayList<Lesson> lessons = new ArrayList<>();
    List<Integer> selectPositions = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_day_layout, container, false);

        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.fabDay);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddLessonActivity.class);
                startActivityForResult(intent, ADD);
            }
        });

        lvLessons = (ListView)v.findViewById(R.id.lvLessons);

        final LessonDao lessonDao = new LessonDao(getActivity());
        lessons = lessonDao.getAllLessons(DAY);

        adapter = new LessonsAdapter(getActivity(), lessons);
        lvLessons.setAdapter(adapter);
        lvLessons.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        lvLessons.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                if (checked) {
                    selectPositions.add(position);
                } else {
                    selectPositions.remove(position);
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.menu_context_lesson, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                //Удаление
                if (item.getItemId() == R.id.item_delete_days) {
                    ArrayList<Lesson> cloneLessons = (ArrayList<Lesson>) lessons.clone();
                    for (int position : selectPositions) {
                        Lesson lesson = cloneLessons.get(position);
                        lessonDao.delete(lesson);
                        lessons.remove(lesson);
                    }
                }
                mode.finish();
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                selectPositions.clear();
                mode.finish();
            }
        });

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        lessons.clear();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Добавление
        lessonDao = new LessonDao(getActivity());
        if (data == null) {
            return;
        }
        String time = data.getStringExtra(KEY_TIME);
        String subject = data.getStringExtra(KEY_SUBJECT);
        String cabinet = data.getStringExtra(KEY_CABINET);
        String teacher = data.getStringExtra(KEY_TEACHER);
        String type = data.getStringExtra(KEY_TYPE);
        String day = DAY;

        Lesson lesson = new Lesson(lessonDao.getCount(day), time, subject, cabinet, teacher, type, day);

        lessonDao.save(lesson);
        lessons.add(lesson);
        adapter.notifyDataSetChanged();
    }
}
