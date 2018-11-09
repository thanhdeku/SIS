package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.String;

public class Database
{
    public static List<Student> studentList = new ArrayList<>();
    public static List<Lecturer> lecturerList = new ArrayList<>();
    public static List<Admin> adminList = new ArrayList<>();
    public static List<Course> courseList = new ArrayList<>();
    public static List<Class> classList = new ArrayList<>();
    public static List<Enroll> enrollList = new ArrayList<>();
    public static List<Login> loginList = new ArrayList<>();
    public static int userType;      //1.src.Student  2.src.Lecturer  3.src.Admin

    /* Bo sung danh sach sinh vien */
    public static void addStudentList()
    {
        Scanner Input = new Scanner(System.in);

        int tmp1;
        String stmp;

        System.out.println("\n\n--- BO SUNG DANH SACH SINH VIEN ---\n");
        do
        {
            System.out.print("Nhap vao MSSV: ");
            tmp1 = Input.nextInt();
            System.out.print("Nhap vao ten sinh vien: ");
            Input.nextLine();
            stmp = Input.nextLine();
            Student studentTmp = new Student(tmp1, stmp);
            studentList.add(studentTmp);
            loginList.add(new Login(studentTmp.getId()));

            System.out.print("Ban muon nhap tiep khong? (C/K) ");
            stmp = Input.nextLine();
        } while(stmp.equals("c") || stmp.equals("C"));
    }

    /* Bo sung danh sach giang vien */
    public static void addTeacherList()
    {
        Scanner Input = new Scanner(System.in);

        int tmp1;
        String stmp1, stmp2;

        System.out.println("\n\n--- BO SUNG DANH SACH GIANG VIEN ---\n");
        do
        {
            System.out.println("Nhap vao ma giang vien: ");
            tmp1 = Input.nextInt();
            System.out.println("Nhap vao ten giang vien: ");
            Input.nextLine();
            stmp1 = Input.nextLine();
            System.out.println("Nhap vao Khoa hoac Vien: ");
            Input.nextLine();
            stmp2 = Input.nextLine();
            Lecturer lecturerTmp = new Lecturer(tmp1, stmp1, stmp2);
            lecturerList.add(lecturerTmp);        //Them 1 giang vien
            loginList.add(new Login(lecturerTmp.getId()));        //Them 1 ban kiem tra dang nhap

            System.out.print("Ban muon nhap tiep khong? (C/K) ");
            stmp1 = Input.nextLine();
        } while(stmp1.equals("c") || stmp1.equals("C"));
    }

    /* Bo sung danh sach hoc phan */
    public static void addCourseList()
    {
        Scanner Input = new Scanner(System.in);

        int tmp;
        String stmp1, stmp2;

        System.out.println("\n\n--- BO SUNG DANH SACH HOC PHAN ---\n");
        do
        {
            System.out.print("Nhap vao ma hoc phan: ");
            stmp1 = Input.nextLine();
            System.out.print("Nhap vao ten hoc phan: ");
            Input.nextLine();
            stmp2 = Input.nextLine();
            System.out.print("Nhap vao so tin chi: ");
            tmp = Input.nextInt();
            Course courseTmp = new Course(stmp1, stmp2, tmp);
            courseList.add(courseTmp);

            System.out.print("Ban muon nhap tiep khong? (C/K) ");
            Input.nextLine();
            stmp1 = Input.nextLine();
        } while(stmp1.equals("c") || stmp1.equals("C"));
    }

    public static void demoDatabase()
    {
        /* Khoi tao demo 50 sinh vien */
        Student[] demoStudent = new Student[50];
        demoStudent[0] = new Student(20164767, "Nguyen Dinh Tuan Anh");
        demoStudent[1] = new Student(20164977, "Nguyen Tu Xuan Cong");
        demoStudent[2] = new Student(20164765, "Hoang Viet Cuong");
        demoStudent[3] = new Student(20164820, "Nguyen Hung Cuong");
        demoStudent[4] = new Student(20160447, "Nguyen Thanh Chung");
        demoStudent[5] = new Student(20164773, "Dau Trung Dung");
        demoStudent[6] = new Student(20160656, "Le Duc Dung");
        demoStudent[7] = new Student(20164844, "Le Anh Duc");
        demoStudent[8] = new Student(20164764, "Le Ba Truong Giang");
        demoStudent[9] = new Student(20164835, "Le Kha Hai");
        demoStudent[10] = new Student(20161599, "Vuong Trung Hieu");
        demoStudent[11] = new Student(20164850, "Nguyen Nhu Hoang");
        demoStudent[12] = new Student(20164778, "Tran Quang Huy");
        demoStudent[13] = new Student(20162031, "Nguyen Tuan Hung");
        demoStudent[14] = new Student(20162573, "Nguyen Dinh Lich");
        demoStudent[15] = new Student(20162567, "Nguyen Dai Loi");
        demoStudent[16] = new Student(20164851, "Tran Duc Manh");
        demoStudent[17] = new Student(20164776, "Phan Minh Nghia");
        demoStudent[18] = new Student(20164836, "Chu Trong Nhan");
        demoStudent[19] = new Student(20163206, "Nguyen Huu Phung");
        demoStudent[20] = new Student(20164811, "Le Minh Quang");
        demoStudent[21] = new Student(20164837, "Nguyen Tien Tai");
        demoStudent[22] = new Student(20164861, "Ho Anh Tien");
        demoStudent[23] = new Student(20164843, "Nguyen Anh Tu");
        demoStudent[24] = new Student(20164770, "Nguyen Doan Thanh Tung");
        demoStudent[25] = new Student(20164812, "Tran Thanh Tung");
        demoStudent[26] = new Student(20164834, "Le Cong Thanh");
        demoStudent[27] = new Student(20164842, "Vo Hai Thien");
        demoStudent[28] = new Student(20164197, "Nguyen Huu Trang");
        demoStudent[29] = new Student(20164768, "Luong Quoc Trung");
        for(int i=0; i<30; i++)
        {
            studentList.add(demoStudent[i]);
            loginList.add(new Login(demoStudent[i].getId()));
        }

        /* Khoi tao demo 10 course */
        Course[] demoCourse = new Course[10];
        demoCourse[0] = new Course("IT3010", "Cau truc du lieu va giai thuat", 3);
        demoCourse[1] = new Course("IT3020", "Toan roi rac", 3);
        demoCourse[2] = new Course("IT3030", "Kien truc may tinh", 3);
        demoCourse[3] = new Course("IT3040", "Ky thuat lap trinh", 3);
        demoCourse[4] = new Course("PH1120", "Vat ly dai cuong 2", 0);
        demoCourse[5] = new Course("PH1110", "Vat ly dai cuong 1", 3);
        demoCourse[6] = new Course("SSH1110", "Nhung NLCB cua CNML 1", 2);
        demoCourse[7] = new Course("EM1010", "Quan tri hoc dai cuong", 2);
        demoCourse[8] = new Course("MI1120", "Giai tich 2", 3);
        demoCourse[9] = new Course("MI1130", "Giai tich 3", 3);
        for(int i=0; i<10; i++)
            courseList.add(demoCourse[i]);

        /* Khoi tao demo 10 teacher */
        Lecturer[] demoLecturer = new Lecturer[10];
        demoLecturer[0] = new Lecturer(1111, "Nguyen Duc Nghia", "Vien CNTT & TT");
        demoLecturer[1] = new Lecturer(1112, "Huynh Thi Thanh Binh", "Vien CNTT & TT");
        demoLecturer[2] = new Lecturer(1113, "Nguyen Kim Khanh", "Vien CNTT & TT");
        demoLecturer[3] = new Lecturer(1114, "Huynh Quyet Thang", "Vien CNTT & TT");
        demoLecturer[4] = new Lecturer(1115, "Pho Thi Nguyet Hang", "Vien VLKT");
        demoLecturer[5] = new Lecturer(1116, "Nguyen Thi Thuy", "Vien KT & QL");
        demoLecturer[6] = new Lecturer(1117, "Nguyen Xuan Thao", "Vien Toan Tin va Ung Dung");
        demoLecturer[7] = new Lecturer(1118, "Nguyen Xuan Dieu", "Vien Toan Tin va Ung Dung");
        demoLecturer[8] = new Lecturer(1119, "Nguyen Thanh Xuan", "Khoa Chinh Tri");
        demoLecturer[9] = new Lecturer(1120, "Nguyen Thanh Hung", "Vien Cong nghe thong tin - Truyen thong");
        for(int i=0; i<=9; i++)
        {
            lecturerList.add(demoLecturer[i]);
            loginList.add(new Login(demoLecturer[i].getId()));
        }

        /* Khoi tao demo 15 class */
        Class[] demoClass = new Class[15];
        demoClass[0] = new Class(111111, "IT3010", 1111);
        demoClass[1] = new Class(111112, "IT3020", 1112);
        demoClass[2] = new Class(111113, "IT3030", 1113);
        demoClass[3] = new Class(111114, "IT3040", 1114);
        demoClass[4] = new Class(111115, "PH1120", 1115);
        demoClass[5] = new Class(111116, "PH1110", 1116);
        demoClass[6] = new Class(111117, "SSH1110", 1117);
        demoClass[7] = new Class(111118, "EM1010", 1118);
        demoClass[8] = new Class(111119, "MI1120", 1119);
        demoClass[9] = new Class(111120, "MI1120", 1120);
        for(int i=0; i<10; i++)
            classList.add(demoClass[i]);

        /* Khoi tao demo 5 admin */
        Admin[] demoAdmin = new Admin[5];
        demoAdmin[0] = new Admin(111, "Hoang Minh Son");
        demoAdmin[1] = new Admin(112, "Bui Trong Tung");
        demoAdmin[2] = new Admin(113, "Cao Duc Dung");
        demoAdmin[3] = new Admin(114, "Le Thi Hoa");
        demoAdmin[4] = new Admin(115, "Ngo Minh Thang");
        for(int i=0; i<=4; i++)
        {
            adminList.add(demoAdmin[i]);
            loginList.add(new Login(demoAdmin[i].getAdminId()));
        }
    }
}