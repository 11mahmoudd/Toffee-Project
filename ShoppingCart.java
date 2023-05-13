import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ShoppingCart extends Order {
    private int CartID ;
    private Item[] items ;
    private Item[] Cartitems;
    private int[] Quantity ;

    private int counter   ;
    protected int len ;
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
                Double price = Double.parseDouble(data);
                data = Reader.next() ;
                String type = data ;
                data = Reader.next() ;
                Double discount = Double.parseDouble(data) ;
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



    ShoppingCart()  {
        Cartitems = new Item[1000];
        len = 0 ;
        DisplayCart();
    }


    private void DisplayCart()
    {
        while (true){
        System.out.println("this is ur shopping cart list : ");
        if (len == 0) {
            System.out.print("[ ");
            System.out.print(" ]");
            System.out.println();
            System.out.println("if you want to add item to cart press 1");
            Scanner input = new Scanner(System.in) ;
            int num = input.nextInt();
            if (num == 1) {
                displayItems();
                System.out.print("press the number of item that you want to add it ");
                Scanner input2 = new Scanner(System.in) ;
                int num2 = input2.nextInt();
                items[num2-1].Quantity-- ;
                Cartitems[len] = items[num2-1] ;
                len++;
            }
        }
        else {
            System.out.print("[ ");
            for (int x = 0 ;x < len ; x++ ) {
                if (x == len -1) {
                    System.out.print(Cartitems[x].name);
                }
                else {
                    System.out.print(Cartitems[x].name + " , ");
                }
            }
            System.out.print(" ]");
            System.out.println();
                System.out.println("if you want to add item to cart press 1");
                System.out.println("if you want to remove item to cart press 2");
                System.out.println("if you want to order press 3 ");
                Scanner input = new Scanner(System.in) ;
                int num = input.nextInt();
                if (num == 1) {
                    displayItems();
                    System.out.print("press the number of item that you want to add it ");
                    Scanner input2 = new Scanner(System.in) ;
                    int num2 = input2.nextInt();
                    items[num2-1].Quantity-- ;
                    Cartitems[len] = items[num2-1] ;
                    len++;
                }
                else if (num == 2) {
                    System.out.print("[ ");
                    for (int x = 0 ;x < len ; x++ ) {
                        if (x == len -1) {
                            System.out.print( x+1 + "- " +Cartitems[x].name);
                        }
                        else {
                            System.out.print(x+1 + "- " + Cartitems[x].name + " , ");
                        }
                    }
                    System.out.print(" ]");
                    System.out.println();

                    System.out.print("enter the number of item that you want to remove :");
                    Scanner input2 = new Scanner(System.in) ;
                    int num2 = input2.nextInt();
                    Cartitems[num2-1].name = "" ;
                    Cartitems[num2-1].brand = "" ;
                    Cartitems[num2-1].Category = "" ;
                    Cartitems[num2-1].price = 0.0 ;
                    Cartitems[num2-1].Quantity = 0 ;
                    Cartitems[num2-1].discount = 0.0 ;
                    Cartitems[num2-1].Status = "" ;
                    Cartitems[num2-1].description = "" ;
                    len-- ;
                }
                else if (num == 3) {
                    placeOrder(len, Cartitems);
                    break;
                }

            }
        }

    }
        protected void displayItems(){
        ReadItem();
        for (int x = 0 ;x < counter ;x++){
            System.out.print(x+1);
            System.out.print("- [ ");
            System.out.print(items[x].name+ " , ");
            System.out.print(items[x].brand+ " , ");
            System.out.print(items[x].Category+ " , ");
            System.out.print(items[x].description+ " , ");
            System.out.print(items[x].price+ " , ");
            System.out.print(items[x].type+ " , ");
            System.out.print(items[x].discount+ " , ");
            System.out.print(items[x].Status + " , ");
            System.out.print(items[x].Quantity);
            System.out.println("]");
        }
        }

    protected void addItem(String str ){
    for (int x=  0 ; x < counter ;x++) {
        if (items[x].name == str) {
            Cartitems[len] = items[x] ;
        }
    }
    }
}
