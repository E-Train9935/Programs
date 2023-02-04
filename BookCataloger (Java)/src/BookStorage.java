import java.util.ArrayList;
import java.util.Hashtable;

public class BookStorage {
	
		public static Hashtable<Integer, String> books = new Hashtable<Integer, String>(); //Author, Name of the book (Genre)
		public static ArrayList<String> sortedByGenre = new ArrayList<String>(); //Author, Book title (Genre)
		public static ArrayList<String> sortedListByGenre = new ArrayList<String>();
		public static ArrayList<String> sortedByTitle = new ArrayList<String>(); //Author, Book title (Genre)
		public static ArrayList<String> sortedByAuthor = new ArrayList<String>(); //Author, Book title (Genre)
		
		public BookStorage() {
			books();
			
		}
		
		public void books() {
			books.put(1, "Sherlock Holmes, How to become a detective (non-fiction)");
			books.put(2, "Amanda Lovelace, The Princess Saves Herself in This One (poetry)");
			books.put(3, "Owen Kuhn, Fundaments of C++ (non-fiction)");
			books.put(4, "Ethian Chiu, Sonic the Hedgehog Issue 1 (comic book)");
			books.put(5, "Alex Michaelides, The Silent Patient (mystery)");
			books.put(6, "Victor Bach, NBA2K is RIGGED!!! (science fiction)");
			books.put(7, "Emily St. John Mandel, The Glass Hotel (mystery)");
			books.put(8, "Conor O'Mahoney, AutoBiography: Being the tallest leprichaun (science fiction)");
			books.put(9, "Bruce Wayne, Batman issue 1 (comic book)");
			books.put(10, "Patty Kraft, Intro to Java (non-fiction)");
			books.put(11, "Russo Brothers, Avengers: Endgame (comic book)");		
			books.put(12, "Steven Lisberger, Tron (science fiction)");
			books.put(13, "DC Comics, Justice League Issue 1 (comic book)");
			books.put(14, "John Milton, The Odyssey (poetry)");
			books.put(15, "Orson Scott Card, Ender's Game (science fiction)");
			books.put(16, "Stephen Hawking, A Brief History of Time (non-fiction)");
			books.put(17, "Madeleine L'Engle, A Wrinkle in Time (science fiction)");
			books.put(18, "Stephen King, If It Bleeds (mystery)");
			books.put(19, "Kahlil Gibran, The Prophet (poetry)");
			books.put(20, "Carolyn Keene, The Secret of the Old Clock (mystery)");
			books.put(21, "William Shakespeare, Romeo and Juliet (non-fiction)");
			books.put(22, "Cole Reed, How I stopped terrorists from hacking the pentagon (comic book)");
			books.put(23, "Conor O'Mahoney, Paradise Lost (poetry)");
			books.put(24, "Agatha Christie, Murder on the Orient Express (mystery)");
			books.put(25, "Edgar Allen Poe, The Raven (poetry)");
			
		}
	
}
