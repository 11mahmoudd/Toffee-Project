import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Login{

    private String Email ;
    private String Password ;
    private boolean check;
    public Login(){
        while (true) {
            System.out.println("please enter your Email : " ) ;
            Scanner input = new Scanner(System.in) ;
            String str = input.nextLine();
            System.out.println("please enter your Password : " ) ;
            Scanner input2 = new Scanner(System.in) ;
            String str2 = input2.nextLine();
           check = checkLogin(str , str2);
           if (check) {
               break;
           }
        }
    }
    public Login(String Email ,String Password ){

        this.Email = Email ;
        this.Password = Password ;
    }
    private boolean checkLogin(String str , String str2){
        try {
            File Obj = new File("1.txt");
            Scanner Reader = new Scanner(Obj);
            int counter = 0 ;
            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                if (counter == 0 || counter % 2 == 0) {
                    if (data.equals(str)) {
                        String data2 = Reader.nextLine();
                        if (data2.equals(str2)){
                            System.out.println("log in successfully !");
                            ShoppingCart shoppingCart = new ShoppingCart();
                            return true ;
                        }

                    }
                }
            }

            Reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
        System.out.println("invalid email or password ");
        return false ;
    }


    public String getEmail() {
        return Email ;
    }

    public String getPass() {
        return Password;
    }


}


