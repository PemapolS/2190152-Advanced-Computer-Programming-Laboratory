abstract class Shape {
    protected String color;
    public abstract double getArea();
    public abstract void printDetails();
    public Shape(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
}

class Square extends Shape{
    private double length;
    public Square(double length, String color){
        super(color);
        this.length = length;
    }
    public double getArea(){
        return (length*length);
    }
    public void printDetails(){
        System.out.println("Shape: Square");
        System.out.println("Color: " + color);
        System.out.println("Side Length: " + length);
        System.out.println("Area: " + this.getArea());
    }
    public void resize(double factor){
        this.length = length * factor;
    }
}

class Rectangle extends Shape{
    private double width;
    private double height;
    public Rectangle(double width, double height, String color){
        super(color);
        this.width = width;
        this.height = height;
    }
    public double getArea(){
        return width*height;
    }
    public void printDetails(){
        System.out.println("Shape: Rectangle");
        System.out.println("Color: "+color);
        System.out.println("Width: "+width);
        System.out.println("Height: "+height);
        System.out.println("Area: "+this.getArea());
    }
    public void resize(double factor){
        this.width = width * factor;
        this.height = height * factor;
    }
}

class Circle extends Shape{
    private double radius;
    public Circle(double radius,String color){
        super(color);
        this.radius = radius;
    }
    public double getArea(){
        return Math.PI * (radius*radius);
    }
    public void printDetails(){
        System.out.println("Shape: Circle");
        System.out.println("Color: "+color);
        System.out.println("Radius: "+radius);
        System.out.println("Area: "+this.getArea());
    }
    public void resize(double factor){
        this.radius = radius * factor;
    }
}