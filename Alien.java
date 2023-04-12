import java.util.ArrayList;

public class Alien implements Contract {

    public int size;
    public int horizon;
    public int height;
    public boolean insideShip;
    public boolean asleep;
    public boolean airborne;
    public boolean walking;
    public int dashQuality;
    public ArrayList<String> inventory = new ArrayList<String>();
    public ArrayList<String> viableItems = new ArrayList<String>();
    public ArrayList<String> nonViableItems = new ArrayList<String>();

    public Alien() {
        size = 1;
        horizon = 0;
        height = 0;
        insideShip = true;
        asleep = false;
        airborne = false;
        walking = false;
        dashQuality = 100;
        inventory = new ArrayList<String>();
        viableItems = new ArrayList<String>();
        nonViableItems = new ArrayList<String>();

    }

    public void grab(String item) {
        if (asleep == true) {
            throw new RuntimeException("The alien cannot perform any functions while she is still asleep.");
        }
        if (height == 0) {
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
        if (asleep == true) {
            throw new RuntimeException("The alien cannot perform any functions while she is still asleep.");
        }
        if (insideShip == false) {
            throw new RuntimeException("The alien is not on the ship right now. She cannot perform any important functions besides walking.");
        }
        if (nonViableItems.contains(item)) {
            throw new RuntimeException("The " + item + " is not able to be dropped. It has already broken upon impact and is utterly unrecognizable.");
        }
        if (!inventory.contains(item)) {
            throw new RuntimeException("The " + item + " is not currently aboard the mothership.");
        }
        System.out.println("The alien opens up the hatch on the floor of her spaceship and drops the " + item + ".");
        inventory.remove(item);
        if (height >= 50) {
            System.out.println("The " + item + " fell from an incredible height and promptly broke on impact.");
            viableItems.remove(item);
            inventory.remove(item);
            nonViableItems.add(item);
        }
        if (height < 50) {
            System.out.println("The " + item + " fell from the mothership and landed safely on the ground.");
        }
        return item;
    }

    public void examine(String item) {
        if (asleep == true) {
            throw new RuntimeException("The alien cannot perform any functions while she is still asleep.");
        }
        if (insideShip == false) {
            throw new RuntimeException("The alien is not on the ship right now. She cannot perform any important functions besides walking.");
        }
        if (!inventory.contains(item)) {
            throw new RuntimeException("The " + item + " is not currently aboard the mothership. In order to examine the " + item + ", the alien must beam it up.");
        }
        if (inventory.contains(item)) {
            System.out.println("This " + item + " is the peak of quality. The alien could never ask for a better " + item + ". It has never been dropped from an incredible height and therefore is not broken.");
        }
    }

    public void use(String item) {
        if (asleep == true) {
            throw new RuntimeException("The alien cannot perform any functions while she is still asleep.");
        }
        if (insideShip == false) {
            throw new RuntimeException("The alien is not on the ship right now. She cannot perform any important functions besides walking.");
        }
        if (!inventory.contains(item)) {
            throw new RuntimeException("The " + item + " is not currently aboard the mothership. In order to use the " + item + ", the alien must beam it up.");
        }
        if (inventory.contains(item)) {
            System.out.println("The alien picks up the " + item + " and begins to beat it against the dashboard. She was sure this would do something, but all she notices is the metal of the dashboard denting ever so slightly due to impact. The " + item + " seems to not have sustained any damage.");
            dashQuality = dashQuality - 2;
        }
    }

    public boolean walk(String direction) {
        if (insideShip == true) {
            throw new RuntimeException("The alien is on the ship right now. She cannot walk around until she is off her ship.");
        }
        if (insideShip == false) {
            System.out.println("The alien begins to walk due " + direction + ". There is no end to the horizon. She continues on.");
        }
        walking = true;
        return walking;
    }

    public boolean stopWalking() {
        if (insideShip == true) {
            throw new RuntimeException("The alien is on the ship right now. She wasn't walking around.");
        }
        if (walking == false){
            throw new RuntimeException("The alien doesn't need to stop walking. She wasn't walking to begin with.");
        }
        System.out.println("The alien stops walking and eventually returns to the outside of her aircraft.");
        walking = false;
        return walking;
    }

    public boolean fly(int x, int y) {
        if (asleep == true) {
            throw new RuntimeException("The alien cannot perform any functions while she is still asleep.");
        }
        if (insideShip == false) {
            throw new RuntimeException("The alien is not on the ship right now. She cannot perform any important functions besides walking.");
        }
        if (y < 0) {
            throw new RuntimeException("The alien cannot fly her ship into the ground. The navigation system does not permit it.");
        }
        if (x == 1){
            System.out.print("The alien decides to fly the mothership to a location " + x + " mile to the right of her original destination ");
        }
        if (x > 1){
            System.out.print("The alien decides to fly the mothership to a location " + x + " miles to the right of her original destination ");
        }
        if (x < -1) {
            System.out.print("The alien decides to fly the mothership to a location " + x + " miles to the left of her original destination ");
        }
        if (x == -1) {
            System.out.print("The alien decides to fly the mothership to a location " + x + " mile to the left of her original destination ");
        }
        if (y == 1) {
            System.out.println("and " + y + " mile into the air.");
            airborne = true;
        }
        if (y > 1) {
            System.out.println("and " + y + " miles into the air.");
            airborne = true;
        }
        if (y == 0) {
            System.out.println("and then returns to the ground.");
            airborne = false;
        }
        horizon = x;
        height = y;
        return airborne;
    }

    public Number shrink() {
        if (asleep == true) {
            throw new RuntimeException("The alien cannot perform any functions while she is still asleep.");
        }
        if (insideShip == false) {
            throw new RuntimeException("The alien is not on the ship right now. She cannot perform any important functions besides walking.");
        }
        if (this.size <= 1) {
            throw new RuntimeException("The alien mothership is already at its smallest possible size.");
        }
        System.out.println("The alien flips a switch on the dashboard, and the mothership lets out an incredible roar. The sound slowly pitches higher and higher, until the ship is half of it's previous size.");
        this.size = this.size / 2;
        return this.size;
    }

    public Number grow() {
        if (asleep == true) {
            throw new RuntimeException("The alien cannot perform any functions while she is still asleep.");
        }
        if (insideShip == false) {
            throw new RuntimeException("The alien is not on the ship right now. She cannot perform any important functions besides walking.");
        }
        if (this.size >= 128) {
            throw new RuntimeException("The alien mothership is already at its maximum possible size.");
        }
        System.out.println("The alien flips a switch on the dashboard, and the mothership lets out an incredible roar. The sound slowly pitches lower and lower, until the ship is twice it's previous size.");
        this.size = this.size * 2;
        return this.size;
    }

    public boolean disembark() {
        if (asleep == true) {
            throw new RuntimeException("The alien cannot perform any functions while she is still asleep.");
        }
        if (insideShip == false) {
            throw new RuntimeException("The alien has already left the ship.");
        }
        if (!inventory.isEmpty()) {
            throw new RuntimeException("In order to leave the ship, the alien must empty it. She may pick the same items back up later as long as they are not broken.");
        }
        if (height > 0){
            throw new RuntimeException("In order to disembark the aircraft, the alien's ship must be on the ground.");
        }
        insideShip = false;
        System.out.println("The alien presses the button on the dashboard that opens the ship's hatch. She disembarks.");
        return insideShip;
    }

    public boolean embark() {
        if (walking == true) {
            throw new RuntimeException("The alien is on a mission, walking with no end in sight. She must stop walking before she can board her aircraft.");
        }
        if (insideShip == true) {
            throw new RuntimeException("The alien is already on the ship.");
        }
        insideShip = true;
        System.out.println("The alien re-enters the aircraft and closes the hatch.");
        return insideShip;
    }

    public void rest() {
        if (height == 0) {
            System.out.println("Since the aircraft is already on the ground, the alien just turns off the headlights and tucks into her convenient cot next to her control chair.");
        }
        if (height > 0) {
            System.out.println("The alien takes her time in landing the aircraft. Once landed, she tucks into her convenient cot right next to her control chair.");
        }
        height = 0;
        airborne = false;
        System.out.println("HONK... SHOO... MIMIMI...");
        asleep = true;
    }

    public void wakeUp() {
        if (asleep == true) {
            System.out.println("The alien wakes up from her slumber, well-rested and ready to slay the day.");
        }
        if (asleep == false) {
            throw new RuntimeException ("The alien is not currently asleep, so she could not wake up... unless you count her third eye that stays closed half the time.");
        }
        asleep = false;
    }

    public void undo() {
        System.out.println("The alien pulls out her time gun from her handy dandy pouch that everyone from her species has. ");
    }
}
