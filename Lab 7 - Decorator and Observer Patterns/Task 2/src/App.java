import java.util.ArrayList;

interface Observer{
    void updateDoorOpen(Door door);
    void updateDoorClose(Door door);
}

class Door implements Observer{
    private String name;
    
    public Door(String name){
        this.name = name;
    }

    public void open(){
        System.out.println("Door " + name + " opened");
    }

    public void close(){
        System.out.println("Door " + name + " closed");
    }

    public void updateDoorOpen(Door door) {
        door.open();
    }
    
    public void updateDoorClose(Door door) {
        door.close();
    }

}

class ControlCenter{
    private ArrayList<Door> observers = new ArrayList<Door>();
    public void registerObserver(Door door){
        observers.add(door);
    }

    public void removeObserver(Door door) {
        observers.remove(door);
    }

    public void openAllDoors() {
        for (Door door : observers) {
            door.updateDoorOpen(door);
        }
    }
    public void closeAllDoors() {
        for (Door door : observers) {
            door.updateDoorClose(door);
        }
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        // Create Door objects
        Door D1 = new Door("D1");
        Door D2 = new Door("D2");
        Door D3 = new Door("D3");

        // Create a ControlCenter object
        ControlCenter controlCenter = new ControlCenter();

        // Register doors with the control center
        controlCenter.registerObserver(D1);
        controlCenter.registerObserver(D2);
        controlCenter.registerObserver(D3);

        // Manually open and close doors
        D1.open();
        D2.open();
        D1.close();

        // Use the control center to open and close all doors
        controlCenter.openAllDoors();
        controlCenter.closeAllDoors();

        // Add a new door and register it with the control center
        Door D4 = new Door("D4");
        controlCenter.registerObserver(D4);
        controlCenter.openAllDoors();
    }
}
