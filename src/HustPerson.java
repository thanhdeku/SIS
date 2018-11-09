package src;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.String;

public class HustPerson
{
    /** Thuoc tinh ke thua **/
    private SimpleDateFormat check ;
    protected int id;
    protected String fullName;
    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected Date birthdate;
    protected String phone;
    protected String mail;
    protected String address;
    //protected boolean isAdmin;

    /** Phuong thuc ke thua **/
    public HustPerson(int id, String fullName)
    {
        this.id = id;
        nameUpdate(fullName);
    }

    public void nameUpdate(String fullName)
    {
        this.fullName = fullName;
        String[] partition = fullName.split(" ");
        if(partition.length >= 2)
        {
            this.firstName = partition[0];
            this.lastName = partition[partition.length-1];
            this.middleName = "";
            for(int i=1; i <= partition.length-2; i++)
                middleName = middleName.concat(partition[i] + " ");
        }
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.check =  new SimpleDateFormat("dd/MM/yyyy");
        this.check.setLenient(false);
        try {
            this.birthdate = check.parse(birthdate);
        } catch (ParseException e) {
            System.out.println("invalid date");
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }
}