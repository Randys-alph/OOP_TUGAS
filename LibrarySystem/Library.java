package LibrarySystem;
import java.util.ArrayList;

public class Library {
	ArrayList<Book> books = new ArrayList<Book>();

	public void addBook(Book book) {
		this.books.add(book);
		System.out.println("Book added to library: " + book.title);
	}

	public void borrowBook(Borrower borrower, Book book) {
		borrower.addBook(book);
		this.books.remove(book);
		System.out.println(borrower.name + " borrowed: " + book.title);
	}

	public void returnBook(Borrower borrower, Book book) {
		borrower.returnBook(book);
		this.books.add(book);
		System.out.println(borrower.name + " returned: " + book.title);
	}

	public void displayLibraryBooks() {
		System.out.println("Books in Library: ");
		for (Book book : books) {
			System.out.println("Title: " + book.title);
			System.out.println("ISBN: " + book.isbn);
			System.out.println("Author: " + book.author.name);
			System.out.println("Biography: " + book.author.bio);
			System.out.println("---------------------------------");
		}
	}

}
