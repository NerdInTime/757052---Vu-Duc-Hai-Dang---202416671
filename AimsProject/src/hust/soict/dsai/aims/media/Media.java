package hust.soict.dsai.aims.media;

import java.util.Comparator;
import hust.soict.dsai.aims.cart.*;

public abstract class Media {
	protected static int nbMedias=0;
	protected String title;
	protected String category;
	protected float cost;
	protected long id;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();

    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
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
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;                   
	    if (obj == null) return false;                  
	    if (!(obj instanceof Media)) return false;     

	    Media other = (Media) obj;


	    if (this.title == null || other.title == null) {
	        return false;
	    }

	    return this.title.equalsIgnoreCase(other.getTitle()); 
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
