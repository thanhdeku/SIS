package src;

import java.lang.String;

public class Course
{
    final private int MONEY_PER_CREDIT = 250000;
    private String courseId;
    private String courseName;
    private int credit;
    //private List<src.Class> class;

    /* Ham khoi dung - Constructor */
    public Course(String courseId, String courseName, int credit)
    {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
    }

    /* Ham get, set - GetSetFunctions */
    public String getCourseId()
    {
        return courseId;
    }
    public String getCourseName()
    {
        return courseName;
    }
    public int getCourseCredit()
    {
        return credit;
    }

    /* Tim hoc phan trong danh sach */
    public static Course getCourseById(String id)
    {
        for (Course x : Database.courseList)
            if(x.courseId.equals(id))
                return x;
        return null;
    }

    /* In thong tin hoc phan */
    public static void getCourseInfo(String courseId)
    {
        Course x = getCourseById(courseId);
        if(x != null)
        {
            System.out.println("_________________________________________________________________\n");
            System.out.println("Ten hoc phan: " + x.courseName + "\tMa hoc phan: " + x.courseId);
            System.out.println("So tin chi: " + x.credit);
            System.out.println("Danh sach giang vien tham gia giang day:");
            for (Class y : Database.classList)
                if(y.getCourseId().equals(courseId))
                    System.out.println("\t- " + y.getLecturer().getFullName());
            System.out.println("_________________________________________________________________\n");
        }
        else
            System.err.println("Khong tim thay hoc phan co ma so " + courseId);
    }

    /* Tinh hoc phi */
    public static int getStudyFee(String courseId)
    {
        Course x = getCourseById(courseId);
        return x.credit * x.MONEY_PER_CREDIT;
    }
}