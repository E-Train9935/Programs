import java.util.ArrayList;

public abstract class SearchingMethods { 
	
		public abstract ArrayList<String> bubbleSortGenre(ArrayList<String> sortedByGenre, String genreChoosen);
		
		public abstract void bubbleSortAuthor(ArrayList<String> sortedByAuthor, String author);
		
		public abstract void bubbleSortTitle(ArrayList<String> sortedByTitle);
	
		public abstract String searchTitle(String title, ArrayList<String> sortedByTitle); //Linear search
		
		public abstract String binarySearchAuthor(String author, int firstElement, int lastElement, ArrayList<String> sortedByAuthor);
		
		public abstract String sortByBookName(String title);
		
		public abstract ArrayList<String> sortByGenre(String genre) ;
		
		public abstract String sortByAuthorsName(String author) ;
	
}
