package hust.soict.dsai.aims.media;

public abstract class Media {
	protected static int nbMedias=0;
	protected String title;
	protected String category;
	protected float cost;
	protected long id;
	public Media() {
		// TODO Auto-generated constructor stub
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
