import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.server.LoaderHandler;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
public class SignUp implements User{
    private OTP otp = new OTP();
    private String UserName ;
    private String Email ;
    private String Address ;
    private String Status ;
    private String Password ;

    public SignUp(){
        while (true) {
            System.out.println("please enter your Username : " ) ;
            Scanner input = new Scanner(System.in) ;
            String str = input.nextLine();
            System.out.println("please enter your Email : " ) ;
            Scanner input2 = new Scanner(System.in) ;
            String str2 = input2.nextLine();
            System.out.println("Sending OTP ");
            String s = otp.sendOTP(str2);
            System.out.println("please enter your OTP : " ) ;
            Scanner ottpp = new Scanner(System.in) ;
            String verify = ottpp.nextLine();
            if(verify.equals(s))
            {
                System.out.println("verified");
                System.out.println("please enter your Address : " ) ;
                Scanner input3 = new Scanner(System.in) ;
                String str3 = input3.nextLine();
                System.out.println("please enter your password : " ) ;
                Scanner input4 = new Scanner(System.in) ;
                String str4 = input4.nextLine();
                if (validation(str)) {
                    if (validation(str2)){
                        if (checkEmail(str2)) {
                            if (checkPass(str4)){
                                try {
                                    FileWriter Writer = new FileWriter("2.txt" , true);
                                    FileWriter Writer2 = new FileWriter("1.txt", true);
                                    Writer.write(str + "\n");
                                    Writer.write(str2 + "\n");
                                    Writer2.write(str2 + "\n");
                                    Writer2.write(str4 + "\n");
                                    Writer.write(str3 + "\n");
                                    Writer.write(str4 + "\n");
                                    Writer.close();
                                    Writer2.close();
                                    System.out.println("Successfully signed up !");
                                }
                                catch (IOException e) {
                                    System.out.println("An error has occurred.");
                                    e.printStackTrace();
                                }
                                Login log = new Login() ;
                                break;
                            }
                        }
                    }
                    else if (!validation(str2)){
                        System.out.println("this email has been taken ! ");
                    }
                }
                else if (!validation(str)){
                    System.out.println("this user has been taken !");
                }

            }


        }

    }
    private boolean validation(String str){
        try {

            File Obj = new File("2.txt");
            Scanner Reader = new Scanner(Obj);

            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                if (data.equals(str)) {
                    return false ;
                }
            }
            Reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        return true ;
    }

    public SignUp(String Username ,String Email ,String Address ,String Status ,String Password ){
        this.UserName = Username ;
        this.Email = Email ;
        this.Address = Address ;
        this.Status = Status ;
        this.Password = Password ;
    }


    private boolean checkEmail(String str){
        return str.contains("@");
    }
    private boolean checkPass(String str){
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        boolean specialCase = false ;
        boolean len = false ;
        char chr ;
        if (str.length() > 8 && str.length() < 14) {
            len = true ;
        }
        for (int x = 0  ; x < str.length();x++) {
            chr = str.charAt(x);
            if (Character.isUpperCase(chr)) {
                capitalFlag = true ;
            }
            else if (Character.isDigit(chr)){
                numberFlag = true ;
            }
            else if (Character.isLowerCase(chr)){
                lowerCaseFlag = true ;
            }
            else if (!Character.isWhitespace(chr) && !Character.isLetter(chr)) {
                specialCase = true ;
            }
        }

        if (capitalFlag && lowerCaseFlag && numberFlag && specialCase && len) {
            return true ;
        }
        else {
            return false  ;
        }
    }

    @Override

    public String getEmail() {
        return Email ;
    }

    @Override
    public boolean ConfrimEmail() {
        return true ;
    }

    @Override
    public String getPass() {
        return Password;
    }

    @Override
    public String getStatus() {
        return Status;
    }

    @Override
    public String getuserName() {
        return UserName;
    }

    @Override
    public String getAddress() {
        return Address;
    }
}
