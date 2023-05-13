import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Catalog {
    private Item[] items ;
    private String str ;
    private int car ;
    Catalog(){
        ReadItem();
        menu();
    }

    private int counter ;
    private void ReadItem() {
        items = new Item[1000];
        counter = 0;
        try {
            File Obj = new File("3.txt");
            Scanner Reader = new Scanner(Obj);
            while (Reader.hasNext()) {
                String data = Reader.next();
                String name = data ;
                data = Reader.next() ;
                String brand = data ;
                data = Reader.next() ;
                String Category = data ;
                data = Reader.next() ;
                String description = data ;
                data = Reader.next() ;
                double price = Double.parseDouble(data);
                data = Reader.next() ;
                String type = data ;
                data = Reader.next() ;
                double discount = Double.parseDouble(data) ;
                data = Reader.next() ;
                String Status = data ;
                data = Reader.next() ;
                int Quantity = Integer.parseInt(data) ;
                Item item = new Item(name , brand , Category , description , price , type , discount , Status , Quantity) ;
                items[counter] = item ;
                counter++;
            }

            Reader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }
    }
    public void searchItembyname(String name) {

        for (int x = 0 ; x < counter ; x++) {
            str = items[x].getname();
            if (str.equals(name)) {
                car = x ;
                break;
            }
        }
        Print(items[car]);
    }
    public void searchItembybrand(String brand) {
        for (int x = 0 ; x < counter ; x++) {
            str = items[x].getBrand();
            if (str.equals(brand)) {
                car = x ;
                break;
            }
        }
        Print(items[car]);
    }
    private void Print(Item obj ) {
        System.out.print("[ ");
        System.out.print(obj.name+ " , ");
        System.out.print(obj.brand+ " , ");
        System.out.print(obj.Category+ " , ");
        System.out.print(obj.price+ " , ");
        System.out.print(obj.description+ " , ");
        System.out.print(obj.discount+ " , ");
        System.out.print(obj.Quantity+ " , ");
        System.out.print(obj.type+ " , ");
        System.out.print(obj.Status);
        System.out.println("]");
    }

    public void ShowAll(){
    for (int  x = 0 ; x < counter ;x++) {
        System.out.print("[ ");
        System.out.print(items[x].name + " , ");
        System.out.print(items[x].brand + " , ");
        System.out.print(items[x].Category + " , ");
        System.out.print(items[x].price + " , ");
        System.out.print(items[x].description + " , ");
        System.out.print(items[x].discount + " , ");
        System.out.print(items[x].Quantity + " , ");
        System.out.print(items[x].type + " , ");
        System.out.print(items[x].Status );
        System.out.println("]");
    }
    }
    private void Register(){
        System.out.println("if you have an account press 1 to log in and if you dont press 2 to sign up! ");
        Scanner input = new Scanner(System.in) ;
        int num = input.nextInt();
        if (num == 1 ){
            Login log = new Login();
        }
        else if (num == 2) {
            SignUp sign = new SignUp() ;
        }

    }
    public void menu(){
        System.out.println("if you want to show all items press 1 ");
        System.out.println("if you want to search items by name press 2 ");
        System.out.println("if you want to search items by brand press 3 ");
        Scanner input = new Scanner(System.in) ;
        int carry = input.nextInt();
        if (carry == 1) {
           ShowAll();
           System.out.println("if you want to buy press 1 ");
            Scanner input2 = new Scanner(System.in) ;
            int num = input2.nextInt() ;
            if (num == 1) {
            Register();
            }
        }
        else if (carry == 2 ) {
            System.out.print("enter item name : ");
            Scanner input2 = new Scanner(System.in) ;
            String sttr = input2.nextLine();
            searchItembyname(sttr);
            System.out.println("if you want to buy press 1 ");
            Scanner input3 = new Scanner(System.in) ;
            int num = input3.nextInt() ;
            if (num == 1) {
                Register();
            }
        }
        else if (carry == 3) {
            System.out.print("enter item brand  : ");
            Scanner input2 = new Scanner(System.in) ;
            String stttr = input2.nextLine();
            searchItembybrand(stttr);
            System.out.println("if you want to buy press 1 ");
            Scanner input3 = new Scanner(System.in) ;
            int num = input3.nextInt() ;
            if (num == 1) {
                Register();
            }
        }

    }

}
