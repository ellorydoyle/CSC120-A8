import java.util.ArrayList;

public class Alien implements Contract {

    ArrayList<String> inventory = new ArrayList<String>();
    ArrayList<String> viableItems = new ArrayList<String>();
    ArrayList<String> nonViableItems = new ArrayList<String>();

    public Alien() {
        inventory = new ArrayList<String>();
        viableItems = new ArrayList<String>();
        nonViableItems = new ArrayList<String>();

    }

    public void grab(String item) {
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
            throw new RuntimeException(item + " is not currently aboard the mothership.");
        }
        System.out.println("The alien opens up the hatch on the floor of her spaceship and drops the " + item + ".");
        inventory.remove(item);
        System.out.println("The " + item + " fell from the mothership and landed safely on the ground.");
        return item;
    }

    public String drop(String item, int y) {
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

    }

    public Number grow() {

    }

    public void rest() {

    }

    public void undo() {

    }
}
