import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

public class GeneticAlgorithm {
	private ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
	private ArrayList<String> cities = new ArrayList<String>();
	private  ArrayList<String> orderedCities = new ArrayList<String>();
	private int fitness = 0;
	private int numOfChromosomes, epochs, randomNumber;
	HashMap<ArrayList<Integer>, Integer> paths = new HashMap<ArrayList<Integer>, Integer>();
	HashMap<ArrayList<Integer>, Integer> orderedPaths = new HashMap<ArrayList<Integer>, Integer>();
	Random rand = new Random();
	
	public GeneticAlgorithm(ArrayList<ArrayList<Integer>> listOfLists,  ArrayList<String> matrixLabels, int chromosomes, int generations) {
		matrix = listOfLists;
		cities = matrixLabels;
		numOfChromosomes = chromosomes;
		epochs = generations;
	}
	
	public void genInitPop() {
		ArrayList<Integer> chromosome = new ArrayList<Integer>();
		for (int i = 0; i < numOfChromosomes; i++) {
			for (int j = 0; j < cities.size(); j++) {
				chromosome.add(j);
			}
			Collections.shuffle(chromosome);
			paths.put(chromosome, calcFitness(chromosome));
		}
		sortByFitness(paths);
		shortestPath();
	}
	
	private void shortestPath() {
		crossover();
		
	}
	
	private int calcFitness(ArrayList<Integer> cityOrder) { //I do not know why but this is the only method that has given me problems, sorry to disappoint
		int fitness = 0;
		ArrayList<Integer> cityInfoInMatrix = new ArrayList<Integer>();
		cityInfoInMatrix = matrix.get(cityOrder.get(0));
			for (int j = 0; j < cityOrder.size() - 1; j++) 
				fitness += cityInfoInMatrix.get(cityOrder.get(j));
		cityInfoInMatrix = matrix.get(cityOrder.get(0));
		fitness += cityInfoInMatrix.get(cityOrder.get(cityOrder.size() - 1));
		return fitness;
	}
	
	private int averageFitness() {
		Set<Entry<ArrayList<Integer>, Integer>> freq = paths.entrySet(); 
		List<Entry<ArrayList<Integer>, Integer>> orderedList = new ArrayList(freq);
		int averageFitness = 0;
		for (int i = 0; i < paths.size(); i++) {
			averageFitness += orderedList.get(i).getValue();
		}
		averageFitness = (averageFitness / numOfChromosomes);
		return averageFitness;
	}
	
	private void sortByFitness(HashMap<ArrayList<Integer>, Integer> pathsMap) { //used the same comparator as program 3 
		Set<Entry<ArrayList<Integer>, Integer>> freq = pathsMap.entrySet(); 
		List<Entry<ArrayList<Integer>, Integer>> orderedList = new ArrayList(freq);
		Collections.sort(orderedList, new Comparator<Entry<ArrayList<Integer>,Integer>>(){ 
			public int compare(Entry<ArrayList<Integer>, Integer> value1, Entry<ArrayList<Integer>, Integer> value2) {
				return value1.getValue().compareTo(value2.getValue());
			}
		});
		
		for (int i = 0; i < pathsMap.size(); i++) {
			orderedPaths.put(orderedList.get(i).getKey(), orderedList.get(i).getValue());
		}
	}
	
	private void crossover() {
		Set<Entry<ArrayList<Integer>, Integer>> freq = paths.entrySet(); 
		List<Entry<ArrayList<Integer>, Integer>> orderedList = new ArrayList(freq);
		HashMap<ArrayList<Integer>,Integer> crossoverList = new HashMap<ArrayList<Integer>,Integer>();
		int numOfMutations = 0;
		int halfOfTheChromosomes = (numOfChromosomes/2);
		
		for (int i = 0; i < epochs; i++) {
			System.out.println("Generation " + (i + 1) + ":");
			for (int j = 0; j < paths.size(); j++) {
				int randChance = rand.nextInt(100);
				if (randChance >= 10 ) {
					ArrayList<Integer> Path1 = orderedList.get(0).getKey(); //best path
					ArrayList<Integer> Path2 = orderedList.get(1).getKey(); //second best path
					ArrayList<Integer> mixedPath = Path2;
					int randNodeIndex = rand.nextInt(mixedPath.size());
					int mixedPathNode = mixedPath.get(randNodeIndex);
					int bestPathNode = Path1.get(randNodeIndex);
					for (int k = 0; k < cities.size() - 1; k++) {
						if (mixedPathNode != bestPathNode) {
							int temp = mixedPathNode;
							mixedPath.set(randNodeIndex, mixedPath.indexOf(bestPathNode));
							mixedPath.set(mixedPath.indexOf(bestPathNode), temp);
						}
					}
					if (randChance >= 97) {
						mutate(mixedPath, randNodeIndex, mixedPathNode, bestPathNode);
						numOfMutations++;
					}
					crossoverList.put(mixedPath,calcFitness(mixedPath));
				}
				else {
					ArrayList<Integer> Path1 = orderedList.get(halfOfTheChromosomes).getKey(); //path that is ranked anywhere in the first half
					ArrayList<Integer> Path2 = orderedList.get(halfOfTheChromosomes - 1 + rand.nextInt(halfOfTheChromosomes)).getKey(); //path that is ranked anywhere in the second half
					ArrayList<Integer> mixedPath = Path2;
					
					for (int k = 0; k < cities.size(); k++) {
						int randNodeIndex = rand.nextInt(mixedPath.size());
						int mixedPathNode = mixedPath.get(randNodeIndex);
						int otherPathNode = Path1.get(randNodeIndex);
						if (mixedPathNode != otherPathNode) {
							int temp = mixedPathNode;
							mixedPath.set(randNodeIndex, mixedPath.indexOf(otherPathNode));
							mixedPath.set(mixedPath.indexOf(otherPathNode), temp);
						}
							if (rand.nextInt(10) == 5) {
								mutate(mixedPath, randNodeIndex, mixedPathNode, otherPathNode);
								numOfMutations++;
							}
					crossoverList.put(mixedPath, calcFitness(mixedPath));
					}
				}
			}
			paths = crossoverList;
			sortByFitness(paths);
			
			Set<Entry<ArrayList<Integer>, Integer>> frequency = paths.entrySet(); 
			List<Entry<ArrayList<Integer>, Integer>> orderedListOfPaths = new ArrayList(frequency);
			System.out.println("Best path cost is: ");
			ArrayList<Integer> chromosome = orderedListOfPaths.get(0).getKey();
					for (int j = 0; j < cities.size() - 1; j++) {
						System.out.print(Character.toChars(65 + chromosome.get(i)) + " --> ");
					}
					System.out.print(Character.toChars(65 + chromosome.get(cities.size() - 1)));
			System.out.println("Average fitness: " + averageFitness());
			if(numOfMutations > 0)
				System.out.println(numOfMutations + " Mutations Occured!");
		}
	}
	
	private void mutate(ArrayList<Integer> mutatedList, int randIndex, int mixedPathIndex, int otherPathindex) {
		int temp = mixedPathIndex;
		mutatedList.set(randIndex, mutatedList.indexOf(otherPathindex));
		mutatedList.set(mutatedList.indexOf(otherPathindex), temp);
	}
	
	public void printExample() {
		Set<Entry<ArrayList<Integer>, Integer>> freq = paths.entrySet(); 
		List<Entry<ArrayList<Integer>, Integer>> orderedList = new ArrayList(freq);
		genInitPop();
		sortByFitness(paths);
		for (int i = 0; i < 3; i++) {
		ArrayList<Integer> chromosome = orderedList.get(i).getKey();
		System.out.println("Example path: ");
			for (int j = 0; j < cities.size() - 1; j++) {
				System.out.print(Character.toChars(65 + chromosome.get(i)) + " --> ");
			}
			System.out.print(Character.toChars(65 + chromosome.get(cities.size() - 1)));
		}
		System.out.println("Average Fitness: " + averageFitness());
		paths.clear();
	}
}
