package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc{
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		nbMedias++;
		this.id=nbMedias;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		nbMedias++;
		this.id=nbMedias;
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		nbMedias++;
		this.id=nbMedias;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title) {
		super();
		nbMedias++;
		this.id=nbMedias;
		this.title = title;
	}
	public void displayInfo() {
		System.out.println(this.title + " - " + this.category + " - " + this.director + " - " + this.length + " - " + + this.cost + "$");
	}
	public boolean isMatch(String keyword) {
		String normalized = this.title.toLowerCase();
		String[] words = normalized.split(" ");
		for (String i: words) {
			if (i.equals(keyword)) {
				return true;
			}
		}
		return false;
	}
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public long getId() {
		return id;
	}

}
