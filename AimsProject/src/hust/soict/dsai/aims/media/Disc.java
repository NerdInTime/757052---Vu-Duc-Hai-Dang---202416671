package hust.soict.dsai.aims.media;

public class Disc extends Media{
	protected String director;
	protected int length;

	public Disc(String title, String category, String director, int length, float cost) {
		super();
		nbMedias++;
		this.id=nbMedias;
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}

	public Disc() {
		// TODO Auto-generated constructor stub
	}


	public String getDirector() {
		return director;
	}

	public int getLength() {
		return length;
	}

}
