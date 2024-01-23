abstract class Shape{
    abstract void draw();
    void displayArea(){
        System.out.println("Area!!!");
    }
}

class Circle extends Shape{
    int r;
    Circle(int r){
        this.r=r;
    }
    void draw(){
        System.out.println("drawing a cirlce");
    }

    void displayArea(){
        double ans = 3.14*r*r;
        System.out.println("Area of circle is " + ans);
    }
}
class Square extends Shape{
    int side;
    Square(int side){
        this.side = side;
    }
    void draw() {
        System.out.println("drawing a Square");
    }
    void displayArea(){
        double a = side*side;
        System.out.println("Area of square is " +a);
    }
    
}


public class Abstraction {
    public static void main(String[] args) {
        Circle myCircle = new Circle(10);
        Square mySquare = new Square(5);
        
        myCircle.draw();
        myCircle.displayArea();

        mySquare.draw();
        mySquare.displayArea();
    }
}
