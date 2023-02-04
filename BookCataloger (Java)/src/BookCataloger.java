import java.util.Scanner;

public class BookCataloger {
		static Scanner scan = new Scanner(System.in);
		
		public static void main(String[] args) {
			
			int choice = -5;
			System.out.println("Welcome to Ethian's Library");
			BookCataloger app = new BookCataloger();
			BookStorage books = new BookStorage();
			Sorting sort = new Sorting();
			
			while (true) {
				app.printMainMenu();
				
				while (choice < 0 || choice > 5) {
					   System.out.println("Enter a relevant option: ");
					   choice = scan.nextInt();
				}
				switch (choice) {
					case 0: System.out.println("Thanks for using our application");
					   		return;
					case 1: System.out.println("Please type in the name of the author");
							String s = scan.nextLine();
							String author = (scan.nextLine()).toLowerCase();
							System.out.println("You checked out: " + sort.sortByAuthorsName(author));
							break;
					case 2: app.printGenres();
							String input = scan.nextLine();
							String genre = (scan.nextLine()).toLowerCase();
							sort.sortByGenre(genre);
							System.out.println(BookStorage.sortedListByGenre);
							System.out.println("Please input which book you would like: (if you want the first book type 0, the second 1, etc)");
							int bookChoosen = scan.nextInt();
							String test = BookStorage.sortedListByGenre.remove(bookChoosen);
							System.out.println("You have checked out: " + test);	
							break;
					case 3: System.out.println("Please type in the name of the book");
							String nothing = scan.nextLine();
							String bookTitle = scan.nextLine(); 
							System.out.println("You checked out: " + sort.sortByBookName(bookTitle));
							break;
					case 4: System.out.println("Please input the information of the book as follows:");
							System.out.println("Author's name(first name and surname), title (genre)");
							String ooof = scan.nextLine();
							String title = scan.nextLine();
							app.donateBook(title);
							if(!title.isEmpty()) {
								System.out.println("Thank you for donating: " + title);
							} 
							break;
				}
				choice = -1;
			}
		}

		private void printGenres() {
			System.out.println("Type which genre you are looking for:");
			System.out.println("Comic book");
			System.out.println("Mystery");
			System.out.println("Poetry");
			System.out.println("Science fiction");
			System.out.println("Non-fiction");
		}

		public void printMainMenu() {
			System.out.println();
			System.out.println("1. Search by author's name");
			System.out.println("2. Search by genre");
			System.out.println("3. Search by book title");
			System.out.println("4. Donate book(s)");
			System.out.println("0. Exit");
			System.out.println();
		}
		
		public void donateBook(String title) {
			int i = BookStorage.books.size() + 1;
			BookStorage.books.put(i, title);
		}
}
