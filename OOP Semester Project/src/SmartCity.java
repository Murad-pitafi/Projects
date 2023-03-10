import java.io.*;
import java.util.Scanner;
interface Administration
{

     void setName(String name);
     void setId(int id);
    String getName();
    int getId();
}
interface access extends Administration{

    public void login();
    public void register();
}

class EmployeeAuthentication  implements access
{
    private String empName;
    private int empId;
    static boolean t = false;
    Scanner sc = new Scanner(System.in);
    @Override
    public void setName(String name) {
        this.empName = name;
    }
    @Override
    public void setId(int id) {
        this.empId = id;
    }
    @Override
    public String getName() {
        return empName;
    }
    @Override
    public int getId() {
        return empId;
    }

    public void register() {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter User Name: ");
            String Uname = sc.nextLine();
            System.out.println(Uname);

            System.out.println("Enter Password: ");
            String Pass = sc.nextLine();
            System.out.println(Pass);

            System.out.println("Confirm Password: ");
            String ConPass = sc.nextLine();
            System.out.println(ConPass);
            Uname = Uname.trim();
            Pass = Pass.trim();
            ConPass = ConPass.trim();


            String x = Uname + " " + Pass;
            if (Pass.equals(ConPass)) {

                File f = new File("Registration.txt");
                Scanner content = new Scanner(f);


                int flag = 0;
                while (content.hasNextLine()) {
                    String data = content.nextLine();
                    if (data.equals(x)) {
                        System.out.println("Already Registered");
                        flag = 1;
                        System.out.println("1. Registration. ");
                        System.out.println("2. Login. ");

                        System.out.println("Enter your Choice");
                        int choice = sc.nextInt();
                        if (choice == 1) {
                            this.register();
                        } else if (choice == 2) {
                            this.login();
                        } else {
                            System.out.println("Choose Proper Option");
                        }
                        break;
                    }
                    content.close();
                }
                if (flag == 0) {
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter("Registration.txt", true));
                        out.write(Uname + " " + Pass + "\n");
                        out.close();
                    } catch (IOException e) {
                        System.out.println("exception occoured" + e);
                    }

                    System.out.println("Successfully Registered");
                    System.out.println("Please login");
                    this.login();
                }


            } else {
                System.out.println("Recheck");
                System.out.println("1. Registration. ");
                System.out.println("2. Login. ");

                System.out.println("Enter your Choice");
                int choice = sc.nextInt();
                if (choice == 1) {
                    this.register();
                } else if (choice == 2) {
                    this.login();
                } else {
                    System.out.println("Choose Proper Option");
                }
            }
            sc.close();
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void login()
    {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter User Name: ");
        String Uname=sc.nextLine();
        System.out.println(Uname);

        System.out.println("Enter Password: ");
        String Pass=sc.nextLine();
        System.out.println(Pass);
        Uname=Uname.trim();
        Pass=Pass.trim();
        String x= Uname+" "+Pass;


        try {

            File f = new File("Registration.txt");
            Scanner content = new Scanner(f);
            int flag=0;
            while (content.hasNextLine()) {
                String data = content.nextLine();
                if(data.equals(x))
                {
                    System.out.println("Login Successful");
                    System.out.println("Welcome to the Application.");
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                System.out.println("Login Failed");
                System.out.println("1. Registration. ");
                System.out.println("2. Login. ");

                System.out.println("Enter your Choice");
                int choice=sc.nextInt();
                if(choice==1)
                {
                    this.register();
                }
                else if(choice==2)
                {
                    this.login();
                }
                else
                {
                    System.out.println("Choose Proper Option");
                }
            }

            content.close();
        }
        catch (FileNotFoundException e) {


            System.out.println("Error.");
            e.printStackTrace();
        }

        sc.close();
    }

}
class UserAuthentication implements access {
    static boolean t = false;
    private String userName;
    private int userId;
    Scanner sc = new Scanner(System.in);


    @Override
    public void setName(String name) {
        this.userName = name;
    }

    @Override
    public void setId(int id) {
        this.userId = id;
    }

    @Override
    public String getName() {
        return userName;
    }

    @Override
    public int getId() {
        return userId;
    }

    public void register() {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter User Name: ");
            String Uname = sc.nextLine();
            System.out.println(Uname);

            System.out.println("Enter Password: ");
            String Pass = sc.nextLine();
            System.out.println(Pass);

            System.out.println("Confirm Password: ");
            String ConPass = sc.nextLine();
            System.out.println(ConPass);
            Uname = Uname.trim();
            Pass = Pass.trim();
            ConPass = ConPass.trim();


            String x = Uname + " " + Pass;
            if (Pass.equals(ConPass)) {

                File f = new File("URegistration.txt");
                Scanner content = new Scanner(f);


                int flag = 0;
                while (content.hasNextLine()) {
                    String data = content.nextLine();
                    if (data.equals(x)) {
                        System.out.println("Already Registered");
                        flag = 1;
                        System.out.println("1. Registration. ");
                        System.out.println("2. Login. ");

                        System.out.println("Enter your Choice");
                        int choice = sc.nextInt();
                        if (choice == 1) {
                            this.register();
                        } else if (choice == 2) {
                            this.login();
                        } else {
                            System.out.println("Choose Proper Option");
                        }
                        break;
                    }
                    content.close();
                }
                if (flag == 0) {
                    try {
                        BufferedWriter out = new BufferedWriter(new FileWriter("URegistration.txt", true));
                        out.write(Uname + " " + Pass + "\n");
                        out.close();
                    } catch (IOException e) {
                        System.out.println("exception occoured" + e);
                    }

                    System.out.println("Successfully Registered");
                    System.out.println("Please login");
                    this.login();
                }


            } else {
                System.out.println("Recheck");
                System.out.println("1. Registration. ");
                System.out.println("2. Login. ");

                System.out.println("Enter your Choice");
                int choice = sc.nextInt();
                if (choice == 1) {
                    this.register();
                } else if (choice == 2) {
                    this.login();
                } else {
                    System.out.println("Choose Proper Option");
                }
            }
            sc.close();
        }catch(FileNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("File not find");
        }
    }
    public void login()
    {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter User Name: ");
        String Uname=sc.nextLine();
        System.out.println(Uname);

        System.out.println("Enter Password: ");
        String Pass=sc.nextLine();
        System.out.println(Pass);
        Uname=Uname.trim();
        Pass=Pass.trim();
        String x= Uname+" "+Pass;


        try {

            File f = new File("URegistration.txt");
            Scanner content = new Scanner(f);
            int flag=0;
            while (content.hasNextLine()) {
                String data = content.nextLine();
                if(data.equals(x))
                {
                    System.out.println("Login Successful");
                    System.out.println("Welcome to the Application.");
                    flag=1;
                    t = true;
                    break;
                }
            }
            if(flag==0)
            {
                System.out.println("Login Failed");
                System.out.println("1. Registration. ");
                System.out.println("2. Login. ");

                System.out.println("Enter your Choice");
                int choice=sc.nextInt();
                if(choice==1)
                {
                    this.register();
                }
                else if(choice==2)
                {
                    this.login();
                }
                else
                {
                    System.out.println("Choose Proper Option");
                }
            }

            content.close();
        }
        catch (FileNotFoundException e) {


            System.out.println("Error.");
            e.printStackTrace();
        }

        sc.close();
    }
}
 abstract class smart_city {
    abstract void setPlace(String placeName);
    abstract String getPlace();
    abstract void setAddress(String address);
    abstract String getAddress();
    abstract void setContact(int contact);
    abstract int getContact();
    abstract void fillDetails();
    abstract void getDetails();
}
class tourism  extends smart_city {                          //class tourism
    private String Tplacename;
    private String Taddress;
    private int Tcontact;
    @Override
    public void setPlace(String placeName) {
        this.Tplacename = placeName;
    }
    @Override
    public String getPlace() {
     return    Tplacename;
    }
    @Override
    public void setAddress(String address) {
        this.Taddress = address;
    }
    @Override
    public String getAddress() {
        return Taddress;
    }
    @Override
    public void setContact(int contact) {
            this.Tcontact = contact;
    }
    @Override
    public int getContact() {
        return Tcontact;
    }
    Scanner sc = new Scanner(System.in);
    public void fillDetails()
    {
        System.out.println("enter place name");
        setPlace(sc.next());
        System.out.println("enter address");
        setAddress(sc.nextLine());
        System.out.println("enter contact");
        setContact(sc.nextInt());
    }
    public void getDetails()
    {
        System.out.println("Place name  " + getPlace());
        System.out.println("address " + getAddress());
        System.out.println("contact " + getContact());
    }
}
class jobseekers extends smart_city {           //class jobseekers
    private String JplaceName;
    private String Jaddress;
    private int Jcontact;
    @Override
    public void setPlace(String placeName) {
        this.JplaceName = placeName;
    }
    @Override
    public String getPlace() {
        return JplaceName;
    }
    @Override
    public void setAddress(String address) {
        this.Jaddress = address;
    }
    @Override
    public String getAddress() {
        return Jaddress;
    }

    @Override
    public void setContact(int contact) {
        this.Jcontact = contact;
    }

    @Override
    public int getContact() {
        return Jcontact;
    }
    Scanner sc = new Scanner(System.in);
    public void fillDetails()
    {
        System.out.println("enter place name");
        setPlace(sc.next());
        System.out.println("enter address");
        setAddress(sc.nextLine());
        System.out.println("enter contact");
        setContact(sc.nextInt());
    }
    public void getDetails()
    {
        System.out.println("Place name  " + getPlace());
        System.out.println("address " + getAddress());
        System.out.println("contact " + getContact());
    }
}
class business extends smart_city {              //class business

    private String Bplacename;
    private String Baddress;
    private int Bcontact;
    @Override
    public void setPlace(String placeName) {
        this.Bplacename = placeName;
    }

    @Override
    public String getPlace() {
        return Bplacename;
    }

    @Override
    public void setAddress(String address) {
        this.Baddress = address;
    }

    @Override
    public String getAddress() {
        return Baddress;
    }

    @Override
    public void setContact(int contact) {
        this.Bcontact = contact;
    }

    @Override
    public int getContact() {
        return Bcontact;
    }
    Scanner sc = new Scanner(System.in);
    public void fillDetails()
    {
        System.out.println("enter place name");
        setPlace(sc.next());
        System.out.println("enter address");
        setAddress(sc.nextLine());
        System.out.println("enter contact");
        setContact(sc.nextInt());
    }
    public void getDetails()
    {
        System.out.println("Place name  " + getPlace());
        System.out.println("address " + getAddress());
        System.out.println("contact " + getContact());
    }
}

class Education extends smart_city {         //class student

    private String SplaceName;
    private String Saddress;
    private int Scontact;
    @Override
    public void setPlace(String placeName) {
        this.SplaceName = placeName;
    }

    @Override
    public String getPlace() {
        return SplaceName;
    }

    @Override
    public void setAddress(String address) {
        this.Saddress = address;
    }

    @Override
    public String getAddress() {
        return Saddress;
    }

    @Override
    public void setContact(int contact) {
        this.Scontact = contact;
    }

    @Override
    public int getContact() {
        return Scontact;
    }

    Scanner sc = new Scanner(System.in);
    public void fillDetails()
    {
        System.out.println("enter place name");
        setPlace(sc.next());
        System.out.println("enter address");
        setAddress(sc.next());
        System.out.println("enter contact");
        setContact(sc.nextInt());
    }
    public void getDetails()
    {
        System.out.println("Place name  " + getPlace());
        System.out.println("address " + getAddress());
        System.out.println("contact " + getContact());
    }
}
public class SmartCity {
        public static void home()
        {
            Scanner sc = new Scanner(System.in);
            int opt;
            int domain;
            tourism tr = new tourism();
            Education ed = new Education();
            jobseekers job = new jobseekers();
            business bus = new business();
            do {
                System.out.println("Welcome to SMART CITY ");
                System.out.println("1 Administration\n 2 Vistor ");
                System.out.println("3 Exit");

                opt = sc.nextInt();
                switch (opt) {
                    case 1 -> {
                        EmployeeAuthentication emp = new EmployeeAuthentication();
                        int b;
                        do
                        {
                            System.out.println(" 1-> Signup");
                            System.out.println(" 2-> Login");
                            System.out.println(" 3-> back");
                            b = sc.nextInt();
                            switch (b) {
                                case 1 -> {
                                    System.out.println(" Employee Registration");
                                    emp.register();
                                }
                                case 2 -> {
                                    System.out.println(" Employee Login");
                                    emp.login();
                                }


                            }



                            if (EmployeeAuthentication.t == true) {
                                do {
                                    System.out.println("see details");
                                    System.out.println("please select your domain ");
                                    System.out.println("1-> business");
                                    System.out.println("2-> Jobs");
                                    System.out.println("3-> Tourism");
                                    System.out.println("4-> Education");
                                    System.out.println("5-> back");
                                    domain = sc.nextInt();
                                    switch (domain) {
                                        case 1 -> {
                                            System.out.println("places for business ");
                                            bus.fillDetails();
                                        }
                                        case 2 -> {
                                            System.out.println("places for jobs ");
                                            job.fillDetails();
                                        }
                                        case 3 -> {
                                            System.out.println("places for tourism ");
                                            tr.fillDetails();
                                        }
                                        case 4 -> {
                                            System.out.println("places for Education ");
                                            ed.fillDetails();
                                        }
                                    }


                                }while(domain != 5);

                            }

                        }while(b != 3);
                    }
                    case 2 -> {
                         UserAuthentication obj = new UserAuthentication();
                        int b;
                        do
                        {
                            System.out.println(" 1-> Signup");
                            System.out.println(" 2-> Login");
                            System.out.println(" 3-> back");
                            b = sc.nextInt();
                            switch (b) {

                                case 1 -> {
                                    System.out.println("user register ");
                                    obj.register();
                                }
                                case 2 -> {
                                    System.out.println("user login"); obj.login();}


                            }
                            if (UserAuthentication.t == true) {
                                do {
                                    System.out.println("see details");
                                    System.out.println("please select your domain ");
                                    System.out.println("1-> business");
                                    System.out.println("2-> Jobs");
                                    System.out.println("3-> Tourism");
                                    System.out.println("4-> Education");
                                    System.out.println("5-> back");
                                    domain = sc.nextInt();
                                    switch (domain) {
                                        case 1 -> {
                                            System.out.println("places for business ");
                                            // bus.getDetails();
                                            File file = new File("Business.txt");
                                            try {
                                                Scanner f = new Scanner(file);
                                                while(f.hasNext())
                                                {
                                                    String data = f.nextLine();
                                                    System.out.println(data);
                                                }
                                            }catch(IOException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                        case 2 -> {
                                            System.out.println("places for jobs ");
                                            job.getDetails();
                                        }
                                        case 3 -> {
                                            System.out.println("places for tourism ");
                                            tr.getDetails();
                                        }
                                        case 4 -> {
                                            System.out.println("places for Education ");

                                        }
                                    }


                                }while(domain != 5);
                            }

                        }while(b != 3);


                    }
                }
            }
            while (opt != 3) ;
        }
    public static void main(String[] args) {

        try {

            File obj = new File("Registration.txt");
            File obj2 = new File("URegistration.txt");
            File obj3 = new File("Business.txt");
            File obj4 = new File("Jobseekers.txt");
            File obj5 = new File("Education.txt");
            File obj6 = new File("Tourism.txt");
            if (obj.createNewFile())
            {
                System.out.println(" Employee File is created");
            }
            if (obj2.createNewFile())
            {
                System.out.println("user file created");
            }
            if (obj3.createNewFile())
            {
                System.out.println(" Business File is created");
            }
            if (obj4.createNewFile())
            {
                System.out.println("Jobseeker file created");
            }
            if (obj5.createNewFile())
            {
                System.out.println(" Education File is created");
            }
            if (obj6.createNewFile())
            {
                System.out.println("Tourism file created");
            }

        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }
        home();
        }
    }