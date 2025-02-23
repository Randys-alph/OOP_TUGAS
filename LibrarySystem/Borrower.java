package LibrarySystem;
import java.util.ArrayList;

public class Borrower {
	String name;

	ArrayList<Book> borrowed = new ArrayList<Book>();	
	
	public Borrower(String name) {
		this.name = name;
	}
	
	public void addBook(Book book) {
		this.borrowed.add(book);
	}
	
	public void returnBook(Book book) {
		this.borrowed.remove(book);
	}

	public void displayBorrowedBooks() {
		System.out.println("Alice's Borrowed Books: ");
		for (Book book : borrowed) {
			System.out.println("Title: " + book.title);
			System.out.println("ISBN: " + book.isbn);
			System.out.println("Author: " + book.author.name);
			System.out.println("Biography: " + book.author.bio);
			System.out.println("---------------------------------");
		}
	}

}
