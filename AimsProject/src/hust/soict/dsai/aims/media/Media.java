package hust.soict.dsai.aims.media;

public abstract class Media {
	protected static int nbMedias=0;
	protected String title;
	protected String category;
	protected float cost;
	protected long id;
	public Media(String title, String category, String director, int length, float cost) {
		super();
		nbMedias++;
		this.id=nbMedias;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public Media() {
		// TODO Auto-generated constructor stub
	}
	public abstract void displayInfo();
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
	public float getCost() {
		return cost;
	}
	public long getId() {
		return id;
	}

}
