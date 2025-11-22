package hust.soict.dsai.aims.media;
import java.util.ArrayList;

public class CompactDisc extends Disc{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	public CompactDisc(String title, String category, String director, int length, float cost, String artist, ArrayList<Track> tracks) {
		super(title,category,director,length,cost);
		this.artist=artist;
		this.tracks=tracks;
	}
	public void addTrack(Track trackObj) {
		if (tracks.contains(trackObj)) {
			System.out.println("Buddy. This track's already in the list.");
		}
		else {
		this.tracks.add(trackObj);
		}
	}
	public void removeTrack(Track trackObj) {
		if (!tracks.contains(trackObj)) {
			System.out.println("Buddy. This track's not even in the list.");
		}
		else {
		this.tracks.remove(trackObj);
		}
	}
	public int getLength() {
		int sum=0;
		for (Track i:tracks) {
			sum+=i.getLength();
		}
		System.out.println(sum);
		return sum;
	}
	
}
