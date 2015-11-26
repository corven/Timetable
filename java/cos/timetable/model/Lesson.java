package cos.timetable.model;

public class Lesson {
    private int id;
    private String time;
    private String subject;
    private String cabinet;
    private String teacher;
    private String type;
    private String day;

    public Lesson(int id , String time, String subject, String cabinet, String teacher,
                  String type, String day) {
        this.id = id;
        this.time = time;
        this.subject = subject;
        this.cabinet = cabinet;
        this.teacher = teacher;
        this.type = type;
        this.day = day;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCabinet() {
        return cabinet;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

}
