package CUSTOMERS;

public class Customer {
    String name,mobile,street,area,pin;
    public Customer(String name,String mobile,String street,String area,String pin){
        this.area = area;
        this.mobile = mobile;
        this.name = name;
        this.pin = pin;
        this.street = street;
    }
    public void print(){
        System.out.println("Customer name : "+name + "\t\tCustomer mobile : "+mobile);
    }
}