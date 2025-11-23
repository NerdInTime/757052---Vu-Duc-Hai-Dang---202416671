package hust.soict.dsai.aims.media;

public class Track implements Playable{
	private String title;
	private int length;

	public Track(String title,int length) {
		this.title=title;
		this.length=length;
	}
	public void Play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
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
