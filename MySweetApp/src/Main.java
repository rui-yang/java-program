import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File("src/test.txt"));
        List<String> texts = new ArrayList<String>();

        while(in.hasNextLine()) {
            texts.add(in.nextLine());
        }

        for(int i = 0; i < texts.size(); i++) {
            System.out.println("Line #" + i + ": "+ texts.get(i));
        }
        
        in.close();

    }
}
