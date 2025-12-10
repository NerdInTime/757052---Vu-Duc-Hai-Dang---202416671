package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track implements Playable{
	private String title;
	private int length;

	public Track(String title,int length) {
		this.title=title;
		this.length=length;
	}
	public String Play() throws PlayerException{
		if (this.getLength() <= 0) {
	        throw new PlayerException("ERROR: Don't think we can listen to a Track thats gone to the negatives, bud.");
	    }
		return ("Playing Track: " + this.getTitle() + "\n" + "Track length: " + this.getLength());
	}
	public boolean equals(Object obj) {
		if (this==obj) return true;
		if (!(obj instanceof Media)) return false;
		Track other = (Track) obj;
		return ((this.title==other.title)&&(this.length==other.length));
	}
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

}
