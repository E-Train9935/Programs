import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneticDriver {
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> inputMatrix = new ArrayList<ArrayList<Integer>>();
		ArrayList<String> labels = new ArrayList<>();
		int chromosomes = 0;
		int epochs = 0;
		
		try {
			Scanner scan = new Scanner(new File(args[0]));
			while (scan.hasNextLine()) {
				ArrayList<Integer> chromosome = new ArrayList<Integer>();
				String input = scan.nextLine();
				String[] rowArr = input.split(",");
				for (int i = 1; i < rowArr.length; ++i) {
					chromosome.add(Integer.parseInt(rowArr[i].trim()));
//					System.out.println(chromosome.get(i - 1));
				}
				inputMatrix.add(chromosome);
			}
			scan = new Scanner(new File(args[0]));
			while(scan.hasNextLine()) {
				String input = scan.nextLine();
				String[] cities = input.split(",");
				labels.add(cities[0]);
//				System.out.println(cities[0]);
			}
//			System.out.println(inputMatrix.size());
//			System.out.println(labels.size());
			scan = new Scanner(System.in);
			
			System.out.println("Please enter the number of chromosomes you would like to generate");
			chromosomes = scan.nextInt();
			System.out.println("Please enter the number of crossovers you would like");
			epochs = scan.nextInt();
			scan.close();
//			System.out.println(chromosomes);
//			System.out.println(epochs);
			
			GeneticAlgorithm algorithm = new GeneticAlgorithm(inputMatrix, labels, chromosomes, epochs);
			algorithm.printExample();
			algorithm.genInitPop();
			
		}
				
		 catch (FileNotFoundException e) {
			System.out.println("The file was not found please try again.");
		} 
	}
	
}
