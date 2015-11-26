package cos.timetable.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import cos.timetable.R;

import static cos.timetable.database.utils.DBTableHeaders.*;

public class AddLessonActivity extends AppCompatActivity {

    TextView timeFrom, timeTo, subject, cabinet, teacher, type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lesson);

        timeFrom = (TextView)findViewById(R.id.edTimeFrom);
        timeTo = (TextView)findViewById(R.id.edTimeTo);
        subject = (TextView)findViewById(R.id.edSubject);
        cabinet = (TextView)findViewById(R.id.edCabinet);
        teacher = (TextView)findViewById(R.id.edTeacher);
        type = (TextView)findViewById(R.id.edType);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!timeFrom.getText().toString().isEmpty() && !timeTo.getText().toString().isEmpty()) {
                    Intent intent = new Intent();
                    intent.putExtra(KEY_TIME, timeFrom.getText() + " - " + timeTo.getText());
                    intent.putExtra(KEY_SUBJECT, subject.getText().toString());
                    intent.putExtra(KEY_CABINET, cabinet.getText().toString());
                    intent.putExtra(KEY_TEACHER, teacher.getText().toString());
                    intent.putExtra(KEY_TYPE, type.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();

                    Toast.makeText(getApplicationContext(), "Запись добавлена",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Не заполнены обязательные параметры",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
