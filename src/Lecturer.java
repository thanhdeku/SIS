package src;

import java.util.Scanner;

public class Lecturer extends HustPerson
{
    private String department;

    /* Ham khoi dung - Constructor */
    public Lecturer(int id, String name, String department)
    {
        super(id, name);
        this.department = department;
    }

    /* Tim teacher trong danh sach */
    public static Lecturer getTeacherById(int id)
    {
        for (Lecturer x : Database.lecturerList)
            if(x.id == id)
                return x;
        return null;
    }

    /* In thong tin teacher */
    public static void getLecturerInfo(int id)
    {
        Lecturer x = getTeacherById(id);
        if(x != null)
        {
            System.out.println("_________________________________________________________________\n");
            System.out.println("Ho: " + x.firstName + "\tDem: " + x.middleName + "\tTen: " + x.lastName);
            System.out.println("So dien thoai: " + x.phone + "\tHom thu dien tu: " + x.mail);
            System.out.println("Khoa, Vien: " + x.department);
            
            System.out.println("Danh sach lop giang day:");
            for (Class y : Database.classList)
                if(y.getLecturer().getId() == id)
                    System.out.println("\t- Lop: " + y.getClassId() + 
                            "\tHoc phan: " + Course.getCourseById(y.getCourseId()).getCourseName());

            System.out.println("_________________________________________________________________");
        }
        else
            System.err.println("Khong tim thay giang vien co ma so " + id);
    }

    /* Cap nhat thong tin teacher */
    public void updateLecturerInfo()
    {
        Scanner Input = new Scanner(System.in);

        int select;
        System.out.println("1. Ten.");
        System.out.println("2. Ma so giang vien.");
        System.out.println("3. Ngay sinh.");
        System.out.println("4. So dien thoai.");
        System.out.println("5. Email.");
        System.out.println("6. Dia chi.");
        System.out.println("7. Khoa, Vien.");
        System.out.println("8. Danh sach lop giang day.");
        System.out.println("9. Danh sach sinh vien huong dan.");
        System.out.println("Chon muc muon thay doi: ");
        select = Input.nextInt();
        switch(select)
        {
            case 1:
            {
                break;
            }
        }
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
                Lecturer.getLecturerInfo(this.id);
                break;
            case 3:
                this.updateLecturerInfo();
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

        }
    }
    public void point(Scanner input){
        System.out.println("Nhap MSSV :");
        int studentId = input.nextInt();
        System.out.println("Nhap ma lop hoc ");
        int classId = input.nextInt();
        Enroll enroll = Enroll.getEnrollbyId(studentId,classId);
        System.out.println("Nhap diem giua ky:");
        enroll.setMidterm(input.nextFloat());
        System.out.println("Nhap diem cuoi ky:");
        enroll.setEndterm(input.nextFloat());
        enroll.updateResult();
    }
    public void generate(Scanner input){
        String dangxuat;
        do
        {
            System.out.println("\n\n____________MENU____________\n");
            System.out.println("1. Thong tin nguoi su dung");
            System.out.println("2. Tra cuu");
            System.out.println("3. Nhap diem");
            System.out.println("4. Dang xuat");
            System.out.print("\nChon chuc nang: ");
            switch (input.nextInt()){
                case 1:
                    this.userInfo(input);
                    break;
                case 2:
                    this.search(input);
                    break;
                case 3:
                    this.point(input);
                    break;
                case 4:
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


}