import java.util.ArrayList;

public class Alien implements Contract {

    public int size;
    public int x;
    public int y;
    public boolean insideShip;
    public ArrayList<String> inventory = new ArrayList<String>();
    public ArrayList<String> viableItems = new ArrayList<String>();
    public ArrayList<String> nonViableItems = new ArrayList<String>();

    public Alien() {
        size = 1;
        x = 0;
        y = 0;
        insideShip = true;
        inventory = new ArrayList<String>();
        viableItems = new ArrayList<String>();
        nonViableItems = new ArrayList<String>();

    }

    public void grab(String item) {
        if (y == 0) {
            throw new RuntimeException("The alien is so small that she has to be in her ship and off the ground in order to grab an item.");
        }
        if (insideShip == false) {
            throw new RuntimeException("The alien is so small that she has to be in her ship and off the ground in order to grab an item.");
        }
        if (nonViableItems.contains(item)) {
            throw new RuntimeException("The " + item + " is not able to be beamed up. It has already broken upon impact.");
        }
        if (!viableItems.contains(item)) {
            viableItems.add(item);
        }
        if (inventory.contains(item)) {
            throw new RuntimeException("The " + item + " has already been brought aboard the mothership.");
        }
        System.out.println("The alien turns on her spaceship's beam and picks up the " + item + ".");
        inventory.add(item);
        System.out.println("The " + item + " has been successfully brought aboard the mothership.");
    }

    public String drop(String item) {
        if (nonViableItems.contains(item)) {
            throw new RuntimeException("The " + item + " is not able to be dropped. It has already broken upon impact.");
        }
        if (!inventory.contains(item)) {
            throw new RuntimeException("The " + item + " is not currently aboard the mothership.");
        }
        System.out.println("The alien opens up the hatch on the floor of her spaceship and drops the " + item + ".");
        inventory.remove(item);
        if (y >= 50) {
            System.out.println("The " + item + " fell from an incredible height and promptly broke on impact.");
            viableItems.remove(item);
            nonViableItems.add(item);
        }
        if (y < 50) {
            System.out.println("The " + item + " fell from the mothership and landed safely on the ground.");
        }
        return item;
    }

    public void examine(String item) {
        if (!inventory.contains(item)) {
            if (nonViableItems.contains(item)) {
                System.out.println("This " + item + " is broken beyond recognition.");
            }
            throw new RuntimeException("The " + item + " is not currently aboard the mothership. In order to examine the " + item + ", the alien must beam it up.");
        }
        if (inventory.contains(item)) {
            if (viableItems.contains(item)) {
                System.out.println("This " + item + " is the peak of quality. The alien could never ask for a better " + item + ". It has never been dropped from an incredible height and therefore is not broken.");
            }
            System.out.println("Somehow, this is not a viable item. The alien is not sure what is wrong.");
        }
    }

    public void use(String item) {

    }

    public boolean walk(String direction) {

    }

    public boolean fly(int x, int y) {

    }

    public Number shrink() {
        if (this.size <= 1) {
            throw new RuntimeException("The alien mothership is already at its smallest possible size.");
        }
        System.out.println("The alien flips a switch on the dashboard, and the mothership lets out an incredible roar. The sound slowly pitches higher and higher, until the ship is half of it's previous size.");
        this.size = this.size / 2;
        return this.size;
    }

    public Number grow() {
        if (this.size >= 128) {
            throw new RuntimeException("The alien mothership is already at its maximum possible size.");
        }
        System.out.println("The alien flips a switch on the dashboard, and the mothership lets out an incredible roar. The sound slowly pitches lower and lower, until the ship is twice it's previous size.");
        this.size = this.size * 2;
        return this.size;
    }

    public boolean disembark() {
        if (insideShip == false) {
            throw new RuntimeException("The alien has already left the ship.");
        }
        if (!inventory.isEmpty()) {
            throw new RuntimeException("In order to leave the ship, you must empty it. You may pick the same items back up later as long as they are not broken.");
        }
        if (y > 0){
            throw new RuntimeException("In order to disembark the aircraft, the alien's ship must be on the ground.");
        }
        insideShip = false;
        System.out.println("The alien presses the button on the dashboard that opens the ship's hatch. She disembarks.");
        return insideShip;
    }

    public boolean embark() {
        if (insideShip == true) {
            throw new RuntimeException("The alien is already on the ship.");
        }
        insideShip = true;
        System.out.println("The alien re-enters the aircraft and closes the hatch.");
        return insideShip;
    }

    public void rest() {

    }

    public void undo() {

    }
}
