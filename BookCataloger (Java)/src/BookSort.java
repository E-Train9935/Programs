import java.util.ArrayList;

public interface BookSort {

	public String sortByAuthorsName(String author); 
	public String sortByBookName(String title);
	public ArrayList<String> sortByGenre(String genre);
	
}
