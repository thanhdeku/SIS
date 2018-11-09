package src;

import java.util.Scanner;

public class Admin extends HustPerson
{
    /*
    * Given  : id - admin identify number, fullname - name of admin
    * Return : Init object "src.Admin"
    * */
    public Admin(int id, String fullname)
    {
        super(id, fullname);
    }

    /*
    * Return : src.Admin id number
    * */
    public int getAdminId()
    {
        return id;
    }

    /*
    * Given  : id number
    * Return : src.Admin with id number
    * */
    public static Admin getAdminById(int id)
    {
        for (Admin x : Database.adminList)
            if(x.getAdminId() == id)
                return x;
        return null;
    }

    public void generate(Scanner input){
        int info;
        String dangxuat;
        do
        {
            System.out.println("\n\n____________MENU____________\n");
            System.out.println("1. Bo sung danh sach sinh vien.");
            System.out.println("2. Bo sung danh sach giang vien.");
            System.out.println("3. Bo sung danh sach hoc phan.");
            System.out.println("4. Tim thong tin sinh vien.");
            System.out.println("5. Tim thong tin giang vien.");
            System.out.println("6. Tim thong tin hoc phan.");
            System.out.println("7. Sua thong tin sinh vien.");
            System.out.println("8. Sua thong tin giang vien.");
            System.out.println("9. Dang ky lop hoc");
            System.out.println("10. Dang xuat.");
            System.out.print("\nChon chuc nang: ");

            switch (input.nextInt()) {
                case 1:
                {
                    // Add student
                    Database.addStudentList();
                    break;

                }
                case 2:
                {
                    // Add lecturer
                    Database.addTeacherList();
                    break;

                }
                case 3:
                {
                    // Add course
                    Database.addCourseList();

                    break;
                }
                case 4:
                {
                    /* Show student information */
                    System.out.print("Nhap vao MSSV can in: ");
                    Student.getStudentInfo(input.nextInt());
                    break;
                }
                case 5:
                {
                    /* Show lecturer information */
                    System.out.print("Nhap vao ma giang vien can in: ");
                    Lecturer.getLecturerInfo(input.nextInt());
                    break;
                }
                case 6:
                {
                    /* Show course information */
                    System.out.print("Nhap vao ma hoc phan can in: ");
                    Course.getCourseInfo(input.nextLine());
                    break;
                }
                case 7:
                {
                    /* Sua thong tin sinh vien */
                    System.out.print("Nhap vao MSSV cua sinh vien can sua: ");
                    int studentId = input.nextInt();
                    Student x = Student.getStudentById(studentId);
                    if(x != null)
                        x.updateStudentInfo();
                    else
                        System.err.println("Khong tim thay sinh vien co MSSV " + studentId);

                    break;
                }
                case 8:
                {
                    /* Sua thong tin giang vien */
                    System.out.println("Chuc nang nay chua hoan thien!");
                    break;
                }
                case 9:
                {
                    System.out.println("Nhap vao MSSV cua sinh vien can dang ky: ");
                    int studentId = input.nextInt();
                    Enroll.enrol(studentId);
                    break;
                }
                case 10:
                {
                    /* Dang xuat */
                    Database.userType = 0;
                    break;
                }
                default:
                {
                    System.out.println("Khong tim thay chuc nang yeu cau!");
                    break;
                }
            }
            if(Database.userType == 0)
                break;
            System.out.print("Ban co muon tiep tuc khong? (C/K) ");
            input.nextLine();
            dangxuat = input.nextLine();
        } while (dangxuat.equals("c") || dangxuat.equals("C"));
    }
}