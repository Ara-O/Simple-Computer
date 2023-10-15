import java.io.File;
import java.util.Scanner;
import java.util.Random;
import java.io.FileNotFoundException;
 public class test{
//	 public static void displayFile(String name) {
//		 
//		 File file  = new File(name);
//		 Scanner inputFile;
//		try {
//			inputFile = new Scanner(file);
//			while(inputFile.hasNext()) {
//				System.out.println(inputFile.nextLine());
//			}
//		} catch (FileNotFoundException e) {
//			System.out.println("error is + "+e.getMessage());
//		}
//	 }
	 public static void main(String[] arg ) {
//		 displayFile("test.txt");
		 for(int i = 0; i < 10; i++) {
			int rando = (int) (3+(Math.random() * 18));
			System.out.println(rando);
		 }
	 }
 }
 