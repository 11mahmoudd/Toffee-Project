import jdk.jfr.Category;

public class Item {
    protected String name ;
    protected String Category ;
    protected String description ;
    protected String brand ;
    protected Double price ;
    protected String type ;
    protected double discount ;
   protected String Status ;
    protected int Quantity ;

    public Item(String name ,String brand ,String Category ,String description ,Double price ,String type ,double discount , String Status , int Quantity){

        this.name = name ;
        this.Category = Category ;
        this.description = description ;
        this.brand = brand ;
        this.price = price ;
        this.type = type ;
        this.discount = discount ;
        this.Status = Status ;
        this.Quantity = Quantity ;
         }




    public String getname(){
        return name ;
    }
    public String getCategory(){
        return Category ;
    }
    public String getDescription(){
        return description ;
    }
    public String getBrand(){
        return brand ;
    }
    public Double getPrice(){
        return price ;
    }
    public String getType(){
        return type ;
    }
    public double getDiscount(){
        return discount ;
    }
    public String getStatus(){return Status ;}
    public int getQuantity(){
        return Quantity ;
    }
}
