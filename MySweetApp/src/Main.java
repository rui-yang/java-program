import java.util.*;

public class Main {
    public static void main(String[] args) {

        LinkedList<String> cars = new LinkedList<String>();
        cars.push("Volvo");
        cars.push("BMW");
        cars.push("Ford");
        cars.push("Mazda");

        ListIterator<String> it = cars.listIterator();
        it.next();
        it.next();
        it.add("Honda");
//        while(it.hasNext()) {
//            System.out.println(it.next());
//        }

        for(String car : cars) {
            System.out.println(car);
        }
    }
}
