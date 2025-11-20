package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media{
	private ArrayList<String> authors = new ArrayList<String>();
	public Book(String title, String category, ArrayList<String> authors, float cost) {
		super();
		nbMedias++;
		this.id=nbMedias;
		this.title = title;
		this.category = category;
		this.authors = authors;
		this.cost = cost;
	}
	public Book(String title, String category, float cost) {
		super();
		nbMedias++;
		this.id=nbMedias;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public Book(String title) {
		super();
		nbMedias++;
		this.id=nbMedias;
		this.title = title;
	}
	public Book() {
		super();
		nbMedias++;
	}
	public void addAuthor(String authorName) {
		if (authors.contains(authorName)) {
			System.out.println("Buddy. This person's already in the list.");
		}
		else {
		this.authors.add(authorName);
		}
	}
	public void removeAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			System.out.println("Buddy. This person's not even in the list.");
		}
		else {
		this.authors.remove(authorName);
		}
	}
}
