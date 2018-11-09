package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Enroll
{
    private int studentId;
    private int classId;
    private float midterm;
    private float endterm;
    private float total;
    private String evaluate;
    
    /* Ham khoi dung - Constructor */
    public Enroll(int studentId, int classId)
    {
        this.studentId = studentId;
        this.classId = classId;
    }

    /* Ham get, set - GetSetFunctions */
    public int getStudentId()
    {
        return studentId;
    }
    public int getClassId()
    {
        return classId;
    }

    public void setMidterm(float midterm) {
        this.midterm = midterm;
    }

    public void setEndterm(float endterm) {
        this.endterm = endterm;
    }

    public float getTotal() {
        return total;
    }

    public static List<Enroll> getEnrollbyStudentId(int studentId){
        List<Enroll> enrollList = new ArrayList<>();
        for (Enroll x : Database.enrollList)
            if(x.studentId == studentId)
                enrollList.add(x);
        return enrollList;

    }

    public static List<Enroll> getEnrollbyCourseId(int classId){
        List<Enroll> enrollList = new ArrayList<>();
        for (Enroll x : Database.enrollList)
            if(x.classId == classId)
                enrollList.add(x);
        return enrollList;

    }
    public static Enroll getEnrollbyId(int studentId, int classId){
        for (Enroll x : Enroll.getEnrollbyStudentId(studentId)){
            if (x.classId ==  classId){
                return x;
            }
        }
        return null;
    }
    public void updateResult()
    {
        float midterm = this.midterm;
        float endterm = this.endterm;
        if(midterm >= 0f && midterm <= 10f && endterm >=0f && endterm <= 10f)
        {
            this.midterm = midterm;
            this.endterm = endterm;
            total = Math.round(0.3 * midterm + 0.7 * endterm);
            evaluate = PointTransfer.transfer(total);

        }
        else
            System.out.println("Du lieu khong hop le, nhap lai!");
    }

    /* Dang ky lop hoc */
    public static void enrol(int studentId)
    {
        Scanner Input = new Scanner(System.in);

        System.out.print("Nhap vao ma lop muon dang ky: ");
        int a = Input.nextInt();

        Class x = Class.getClassById(a);
        if(x != null)
        {
            Student y = Student.getStudentById(studentId);
            if(y != null)
            {
                Enroll tmpEnroll = new Enroll(studentId, a);
                Database.enrollList.add(tmpEnroll);       //Them mot ban dang ky
                y.setFee(y.getFee() + Course.getStudyFee(x.getCorrespondingCourse().getCourseId()));       //Tinh hoc phi
                System.out.println("Dang ky thanh cong!");
            }
            else
                System.out.println("Khong tim thay sinh vien co MSSV " + studentId);
        }
        else
            System.err.println("Khong tim thay lop muon dang ky!");
    }
}