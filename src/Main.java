package src;

import java.util.Scanner;
import java.lang.String;

public class Main
{
    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);

        Database.demoDatabase();

        do
        {
            /* Log in */
            int userId = Login.login();
            switch (Database.userType) {
                case 1:
                    Student student = Student.getStudentById(userId);
                    student.generate(input);
                    break;
                case 2:
                    Lecturer lecturer = Lecturer.getTeacherById(userId);
                    lecturer.generate(input);
                    break;
                case 3:
                    Admin admin = Admin.getAdminById(userId);
                    admin.generate(input);
                    break;
            }


        } while (true);
    }
}