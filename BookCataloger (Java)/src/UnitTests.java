
public class UnitTests {
	
	public static void donateBookTest() {
		BookCataloger library = new BookCataloger();
		BookStorage books = new BookStorage();
		String title = "Ethian Chiu, Testing (science fiction)";
		library.donateBook(title);
		Sorting sort = new Sorting();
		sort.sortByGenre("science fiction");
		if (books.sortedByGenre.contains(title)) {
			System.out.println("SUCCESS ON DONATING BOOK");
		} else
			System.out.println("FAILED TO DONATE BOOK");	
	}
	public static void searchABookFromGenreTest() {
		BookCataloger library = new BookCataloger();
		BookStorage books = new BookStorage();
		Sorting sort = new Sorting();
		String genre = "non-fiction";
		sort.sortByGenre(genre);
		if (BookStorage.sortedListByGenre.remove(2).equals("Patty Kraft, Intro to Java (non-fiction)")) {
			System.out.println("SUCCESS SEARCHING A BOOK FROM GENRE");
		} else
			System.out.println("FAILED TO SEARCH A BOOK FROM GENRE");
	}
	public static void searchABookFromTitleTest() {
		BookCataloger library = new BookCataloger();
		BookStorage books = new BookStorage();
		Sorting sort = new Sorting();
		String bookTitle = "Intro to Java";
		if (sort.sortByBookName(bookTitle).contains(bookTitle)) {
			System.out.println("SUCCESS SEARCHING A BOOK FROM TITLE");
		} else
			System.out.println("FAILED TO SEARCH A BOOK FROM TITLE");
	}
	public static void searchABookFromAuthorTest() {
		BookCataloger library = new BookCataloger();
		BookStorage books = new BookStorage();
		Sorting sort = new Sorting();
		String author = "Patty Kraft";
		if (sort.sortByAuthorsName(author).equals("Patty Kraft, Intro to Java (non-fiction)")) {
			System.out.println("SUCCESS SEARCHING A BOOK FROM AUTHOR");
		} else
			System.out.println("FAILED TO SEARCH A BOOK FROM AUTHOR");
	}
	public static void main(String[] args) {
		searchABookFromGenreTest();
		searchABookFromTitleTest();
		searchABookFromAuthorTest();
		donateBookTest();
	}

}
