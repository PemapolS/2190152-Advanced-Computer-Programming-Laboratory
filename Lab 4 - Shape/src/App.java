public class App {
    public static void main(String[] args) throws Exception {
        Square square1 = new Square(5.0,"Red");
        Square square2 = new Square(3.0,"Blue");
        Rectangle rect1 = new Rectangle(4.0,6.0,"Green");
        Rectangle rect2 = new Rectangle(2.0,8.0,"Yellow");
        Circle circle1 = new Circle(7.0,"Orange");

        square1.printDetails();
        System.out.println("----------------------");
        square2.printDetails();
        System.out.println("----------------------");
        rect1.printDetails();
        System.out.println("----------------------");
        rect2.printDetails();
        System.out.println("----------------------");
        circle1.printDetails();
        System.out.println("----------------------");
    }
}
