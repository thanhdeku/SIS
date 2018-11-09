package src;

import java.util.List;
import java.util.Date;

public class Class
{
    private int classId;
    private String courseId;
    private Lecturer lecturer;
    private List<Student> student;
    private int classroom;
    private Date date;

    /*
    * Given  :
    *   classId   : id number of class
    *   courseId  : id number of course of class
    *   teacherId : id number of lecturer of class
    * Return : Init object "class"
    * */
    public Class(int classId, String courseId, int teacherId)
    {
        this.classId = classId;
        this.courseId = courseId;
        this.lecturer = Lecturer.getTeacherById(teacherId);
    }

    /*
    * Get - Set Function
    * */
    public String getCourseId()
    {
        return courseId;
    }
    public Lecturer getLecturer()
    {
        return lecturer;
    }
    public int getClassId()
    {
        return classId;
    }

    /*
    * Given  : id number of class
    * Return : class
    * */
    public static Class getClassById(int classId)
    {
        for (Class x : Database.classList)
            if(x.classId == classId)
                return x;
        return null;
    }

    /*
    * Return : course of this class
    * */
    public Course getCorrespondingCourse()
    {
        return Course.getCourseById(courseId);
    }
}