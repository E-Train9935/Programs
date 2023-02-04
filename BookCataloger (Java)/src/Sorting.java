import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Sorting extends SearchingMethods implements BookSort  {
	
	Iterator<String> it = BookStorage.sortedByAuthor.iterator();
	int firstElement = 0;
	int lastElement = 0;
	
	public String searchTitle(String title, ArrayList<String> sortedByTitle) {
		for (int i = 0; i < sortedByTitle.size(); i++) {
			if ((sortedByTitle.get(i)).contains(title)) {
				
				return sortedByTitle.get(i);
			}
		}
		return "Book title not found";
	}
	
	public String binarySearchAuthor(String author, int firstElement, int lastElement, ArrayList<String> sortedByAuthor) {
		
		if (lastElement < firstElement) {
			return "Author not found";
		}
		
//		start by calc middle
//		check if middle value is true
//		check if right is greater than right
//		less than check left
		
		int middle = (firstElement + lastElement) / 2;
		
		while (firstElement <= lastElement) {
			
			middle = (firstElement + lastElement) / 2;
			
			int i = sortedByAuthor.get(middle).indexOf(',');
			
			if(i == 0) {
				return null;
			}
			String temp = sortedByAuthor.get(middle).substring(0,i);
			
			int match = author.compareToIgnoreCase(temp);

			if(match == 0) {
				return sortedByAuthor.get(middle);
			}
			if (match < 0)
				return binarySearchAuthor(author, firstElement, middle-1, BookStorage.sortedByAuthor);
			
			else
				return binarySearchAuthor(author, middle+1, lastElement, BookStorage.sortedByAuthor);
		}
		return "Authors not found";
}

	public void bubbleSortAuthor(ArrayList<String> sortedByAuthor, String author) {
			// for the for loop: search the i index string[i] then inside that search until the ',' 
			// once found, take the substring from 0 until the comma
			// search how to bubble sort
			String[] firstAuthor;
			String[] nextAuthor;
			String first;
			String next;	
				for (int i = 0; i < sortedByAuthor.size(); i++) {
					for (int j = 0; j < sortedByAuthor.size()-1; j++) {					
							firstAuthor = sortedByAuthor.get(j).split(", ");
							nextAuthor = sortedByAuthor.get(j+1).split(", ");
							first = firstAuthor[0];
							next = nextAuthor[0];
							if (first.compareTo(next) > 0) {
								String temp = sortedByAuthor.get(j);
								sortedByAuthor.set(j, sortedByAuthor.get(j+1));
								sortedByAuthor.set(j+1, temp);
							}
					}
				}
	}
	
	public void bubbleSortTitle(ArrayList<String> sortedByTitle) {
		for (int i = 0; i < sortedByTitle.size(); i++) {
			for (int j = 0; j < sortedByTitle.size()-1; j++) {
				String first = sortedByTitle.get(j);
				String next = sortedByTitle.get(j+1);
				String[] firstAuthor = first.split(", ");
				String[] nextAuthor = next.split(", ");
				
				firstAuthor[0] = firstAuthor[1];
				nextAuthor[0] = nextAuthor[1];
				first = firstAuthor[0];
				next = nextAuthor[0];
				
					if (first.compareTo(next) < 0) {
						String temp = sortedByTitle.get(j);
						sortedByTitle.set(j, sortedByTitle.get(j+1));
						sortedByTitle.set(j+1, temp);
					}
				}
			}
	}
		
		
	
	public ArrayList<String> bubbleSortGenre(ArrayList<String> sortedByGenre, String genreChoosen) {
		String genre;		
		for (int i = 0; i < sortedByGenre.size(); i++) {
				genre = sortedByGenre.get(i);
				if (genre.contains(genreChoosen)) {
					BookStorage.sortedListByGenre.add(sortedByGenre.get(i));
				}
		}
		return BookStorage.sortedListByGenre;
}

	public String sortByBookName(String title) {
		BookStorage.sortedByTitle.addAll(BookStorage.books.values());
		bubbleSortTitle(BookStorage.sortedByTitle);
		return searchTitle(title, BookStorage.sortedByTitle);
	}

	@Override
	public ArrayList<String> sortByGenre(String genre) {
		BookStorage.sortedByGenre.addAll(BookStorage.books.values());
		return bubbleSortGenre(BookStorage.sortedByGenre, genre);
	}
	
	public String sortByAuthorsName(String author) {
		BookStorage.sortedByAuthor.addAll(BookStorage.books.values());
		bubbleSortAuthor(BookStorage.sortedByAuthor, author);
		return binarySearchAuthor(author, 0, BookStorage.sortedByAuthor.size()-1, BookStorage.sortedByAuthor);			
	}
}