class Vehicle{
    String type;
    public void decription(){
        System.out.println(type + " of Vehicle");
    }
}

class Car extends Vehicle{
    int wheels;
    public void carWheels(){
        System.out.println("Car has "+wheels + "wheels");
    }
}

public class Inheritance {
    public static void main(String[] args) {
        System.out.println("hello word");
        Car BMW = new Car();
        BMW.type = "SUV";
        BMW.wheels = 4;

        BMW.decription();
        BMW.carWheels();
    }
}


