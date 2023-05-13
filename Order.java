


import java.util.Scanner;
import java.time.LocalDate;
import java.util.Random;

public class Order {
    private Item item;
    private int OrderID;
    private int ShippingId;
    private String CustmomerName;
    private LocalDate DateOfCreation ;
    private LocalDate DateOfShipped ;
    private String addres ;


    public int getOrderID() {
        return OrderID;
    }

    public int getShippingId() {
        return ShippingId;
    }

    public String getCustmomerName() {
        return CustmomerName;
    }

    public LocalDate getDateOfCreation() {
        return DateOfCreation;
    }

    public LocalDate getDateOfShipped() {
        return DateOfShipped;
    }

    public String getAddres() {
        return addres;
    }

    public void setOrderID() {
        Random random = new Random();
        int orderID = random.nextInt(100 + 1) + 1;
        OrderID = orderID;
    }

    public void setCustmomerName() {
        Scanner obj=new Scanner(System.in);
        String custmomerName=obj.nextLine();
        CustmomerName = custmomerName;
    }

    public void setShippingId() {
        Random random = new Random();
        int shippingId = random.nextInt(100 + 1) + 1;
        ShippingId = shippingId;
    }

    public void setDateOfCreation() {
        LocalDate myObj = LocalDate.now();
        DateOfCreation = myObj;
    }

    public void setDateOfShipped() {
        LocalDate myObj = LocalDate.now();
        DateOfShipped = myObj.plusDays(5);
    }

    public void setAddres() {
        Scanner obj=new Scanner(System.in);
        String addres=obj.nextLine();
        this.addres = addres;
    }

    public void placeOrder(int length , Item[] items){
        double price = 0 ;
        price = CountOrder(length , items) ;
        payment(price);

    }
    public double CountOrder(int length ,Item [] items)
    {
        double sum=0;
        for (int x = 0 ; x < length ; x++)
        {
            sum = sum + (items[x].price * items[x].discount);
        }
        return sum;
    }

    public void payment(double sum)
    {
        boolean choose=true;
        Scanner myObj = new Scanner(System.in);

        System.out.println("1-pay by E-Wallet\n2-pay On delivery");
        while(choose)
        {
            int paymentMethod = myObj.nextInt();
            if(paymentMethod==1)
            {
                System.out.print("Your checkout is: ");
                System.out.println(sum);
                System.out.println("Enter your E-wallet number");
                int Ewallet = myObj.nextInt();
                System.out.println("Your order will arrive after 5 days <3");
                choose=false;
            }
            else if(paymentMethod==2)
            {
                System.out.print("Your checkout is: ");
                System.out.println(sum);
                System.out.println("be claimd on delivery");
                System.out.println("Your order will arrive after 5 days <3");
                choose=false;
            }
            else
            {
                System.out.println("Please check your choice");
                System.out.println("1-pay by E-Wallet\n2-pay On delivery");
            }
        }
    }


}