import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static void main (String[] args) {

        File file = new File("resources/data.txt"); 
        
        try {
            Scanner scanner = new Scanner(file); 
            while(scanner.hasNext()) {
                String thisLine = scanner.nextLine();
                System.out.println("this is a line");
                String[] thisLineArr = thisLine.split(",")
                System.out.println("The value of the first: " + thisLine[0]);
                System.out.println("The value of the first: " + thisLine[1]);
                System.out.println("We're done with this line.");
                System.out.println("**********");
                
                String description = thisLineArr[0];
                // converting 2nd param to int - constructor has (string, int) need to change 2nd arg to int
                int numOfRoses = Integer.parseInt(thisLineArr[1]);
                // create a new FSO object every time we read the file
                FlowerShopOrder order = new FlowerShopOrder(description, numOfRoses);

            }

            scanner.close();
             
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}