package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends HustPerson
{
    private String studentGroup;
    private String program;
    private String status;
    private int fee;

    /* Ham khoi dung - Constructor */
    public Student(int id, String fullName)
    {
        super(id, fullName);
        fee = 0;
    }

    /* Ham get, set - GetSetFunctions */

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }


    /* Tim sinh vien trong danh sach */
    public static Student getStudentById(int id)
    {
        for (Student x : Database.studentList)
            if(x.id == id)
                return x;
        return null;
    }

    /* In thong tin sinh vien */
    public static void getStudentInfo(int id)
    {

        Student x = getStudentById(id);
        if(x != null)
        {
            System.out.println("_____________________________________________________________");
            System.out.println(" ");
            System.out.println("        Name         : " + x.getFullName());
            System.out.println("        Id           : " + x.getId());
            System.out.println("        Birthday     : " + x.getBirthdate());
            System.out.println("        Major        : " + x.getProgram());
            System.out.println("        Lop          : " + x.studentGroup );
            System.out.println("        Chuong trinh : " + x.program);
            System.out.println(" ");
            System.out.println("_____________________________________________________________");
        }
        else
            System.err.println("Khong tim thay sinh vien co MSSV " + id);
    }



    /* Cap nhat thong tin sinh vien */
    public void updateStudentInfo()
    {
        Scanner input = new Scanner(System.in);

        int select;
        System.out.println("1. Ten.");
        System.out.println("2. Ngay sinh.");
        System.out.println("3. So dien thoai.");
        System.out.println("4. Email.");
        System.out.println("5. Dia chi.");
        System.out.println("6. Khoi lop.");
//        System.out.println("7. Chuong trinh.");
//        System.out.println("8. Trang thai.");
        System.out.println("Chon muc muon thay doi: ");
        select = input.nextInt();
        switch(select)
        {
            case 1:
                System.out.print("Nhap ten sinh vien : ");
                this.nameUpdate(input.nextLine());
                break;
            case 2:
                System.out.print("Nhap ngay sinh : ");
                this.nameUpdate(input.nextLine());
                break;

            case 3:
            {
                System.out.print("Nhap ngay sinh moi (DD/mm/yyyy): ");
                this.setBirthdate(input.nextLine());
                break;
            }
            case 4:
            {
                System.out.print("Nhap so dien thoai moi: ");
                this.phone = input.nextLine();
                break;
            }
            case 5:
            {
                System.out.print("Nhap email moi: ");
                this.mail = input.nextLine();
                break;
            }
            case 6:
            {
                System.out.print("Nhap dia chi moi: ");
                this.address = input.nextLine();
                break;
            }
            default:
                System.out.println("Khong tim thay thong tin!");
        }
    }

    public void generate(Scanner input){
        String dangxuat;
        do
        {
            System.out.println("\n\n____________MENU____________\n");
            System.out.println("1. Thong tin nguoi su dung");
            System.out.println("2. Tra cuu");
            System.out.println("3. Dang ky hoc tap");
            System.out.println("4. Ket qua hoc tap");
            System.out.println("5. Dang xuat");
            System.out.print("\nChon chuc nang: ");


            switch (input.nextInt()){
                case 1:
                    this.userInfo(input);
                    break;
                case 2:
                    this.search(input);
                    break;
                case 3:
                    this.studyEnroll(input);
                    break;
                case 4:
                    this.studyResult();
                    break;
                case 5:
                    Database.userType = 0;
                    break;
            }
            if(Database.userType == 0)
                break;
            System.out.print("Ban co muon tiep tuc khong? (C/K) ");
            input.nextLine();
            dangxuat = input.nextLine();
        } while (dangxuat.equals("c") || dangxuat.equals("C"));
    }

    public void userInfo(Scanner input){
        System.out.println("\n\n____________THONG TIN NGUOI DUNG____________\n");
        System.out.println("1. Doi mat khau");
        System.out.println("2. Thong tin ca nhan ");
        System.out.println("3. Cap nhat thong tin ca nhan");
        switch (input.nextInt()){
            case 1:
                changePassword(input);
                break;
            case 2:
                Student.getStudentInfo(this.id);
                break;
            case 3:
                this.updateStudentInfo();
                break;
        }
    }

    public void changePassword(Scanner input){
        Login login = Login.getLoginById(this.getId());
        Login.updatePassword(login,input);
    }

    public void search(Scanner input){
        System.out.println("\n\n____________TRA CUU____________\n");
        System.out.println("1. Tra cuu thong tin sinh vien");
        System.out.println("2. Tra cuu thong tin giang vien ");
        System.out.println("3. Tra cuu thong tin hoc phan");
        System.out.println("4. Tra cuu hoc phi sinh vien");
        switch (input.nextInt()){
            case 1:
            {
                /* Show student information */
                System.out.print("Nhap vao MSSV can in: ");
                Student.getStudentInfo(input.nextInt());
                break;
            }
            case 2:
            {
                /* Show lecturer information */
                System.out.print("Nhap vao ma giang vien can in: ");
                Lecturer.getLecturerInfo(input.nextInt());
                break;
            }
            case 3:
            {
                /* Show course information */
                System.out.print("Nhap vao ma hoc phan can in: ");
                Course.getCourseInfo(input.nextLine());
                break;
            }
            case 4:
                System.out.println("Chuc nang nay chua co");
                break;

        }
    }

    public void studyEnroll(Scanner input){
        Enroll.enrol(input.nextInt());
    }

    public void studyResult(){
        List<Enroll> enrollList = Enroll.getEnrollbyStudentId(this.getId());
        float CPA = 0f;
        int totalCredit = 0;
        if(enrollList.size() != 0) {
            for (Enroll x : enrollList) {
                System.out.println("Ma lop hoc - " + x.getClassId() + " : " + x.getTotal());
                int credit = Class.getClassById(x.getClassId()).getCorrespondingCourse().getCourseCredit();
                CPA += x.getTotal() * credit;
            }
            CPA /= totalCredit;
        }
        System.out.println("CPA : "+ CPA);

    }

}