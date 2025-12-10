package hust.soict.dsai.aims.media;
import java.util.ArrayList;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
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
	@Override
	public String Play() throws PlayerException {
	    if (this.length <= 0) {
	        throw new PlayerException("ERROR: Don't think we can listen to a CD thats gone to the negatives, bud.");
	    }

	    String playing = "";
	    playing += (this.title + " - " + this.category + " - " + this.director + " - " + this.length + " - " + this.artist);


	    for (Track i : tracks) {
	        playing += "\n";
	        try {
	            playing += i.Play();   
	        } catch (PlayerException e) {
	            System.err.println("Track error: " + e.getMessage());
	            playing += "ERROR: Track " + i.getTitle() + " is completely wasted.";
	            
	        }
	    }

	    return playing;
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
