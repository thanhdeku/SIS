package src;

import java.util.Scanner;
import java.lang.String;

public class Login
{
    private int id;     //username = id (MSSV or ma so giang vien)
    private String password;        //password mac dinh la MSSV or ma so giang vien

    /* Ham khoi dung - Constructor */
    public Login(Integer id)
    {
        this.id = id;
        this.password = id.toString();
    }

    /* Ham get, set - GetSetFunctions */
    public String getPassword()
    {
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public static void updatePassword(Login login,Scanner input){
        System.out.println("Nhap mat khau hien tai : ");
        if(login.getPassword().equals(input.nextLine())){
            String str1, str2;
            do{
                System.out.println("Nhap mat khau ban muon thay doi : ");
                str1 = input.nextLine();
                System.out.println("Nhap lai mat khau muon thay doi : ");
                str2 = input.nextLine();
            }while (str1 != str2);
            login.setPassword(str1);

        }
    }
    /* Tim login trong danh sach */
    public static Login getLoginById(int id)
    {
        for (Login x : Database.loginList)
            if(x.id == id)
                return x;
        return null;
    }

    /* Giao dien login */
    public static int login()
    {
        Scanner Input = new Scanner(System.in);

        int username;
        String stmp;
        boolean check;

        System.out.println("\n\n_______________YEU CAU DANG NHAP_______________\n");
        System.out.println("1. Danh cho sinh vien");
        System.out.println("2. Danh cho giang vien");
        System.out.println("3. Danh cho quan tri vien");
        System.out.println("Chon chuc nang :");
        Database.userType = Input.nextInt();         //Xac dinh danh tinh
        do
        {
            check = false;
            System.out.print("Nhap vao so hieu cua ban: ");
            username = Input.nextInt();
            if((Database.userType == 1 && Student.getStudentById(username) == null) ||
                        (Database.userType == 2 && Lecturer.getTeacherById(username) == null) ||
                        (Database.userType == 3 && Admin.getAdminById(username) == null))
            {
                System.err.println("Ban nhap sai, vui long nhap lai!");
                check = true;
            }
        } while (check);
        Login x = Login.getLoginById(username);
        Input.nextLine();
        do
        {
            System.out.print("Nhap mat khau cua ban: ");
            stmp = Input.nextLine();
            if(!x.password.equals(stmp))
                System.out.println("Sai password! Nhap lai!");
        } while (!x.password.equals(stmp));
        System.out.println("Dang nhap thanh cong!\n");
        return username;
    }
}