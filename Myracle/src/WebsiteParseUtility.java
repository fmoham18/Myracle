import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class WebsiteParseUtility {
	
	private static String artist = "", track = "", url = "", lyrics = "";
	
	public WebsiteParseUtility() { }

	public WebsiteParseUtility(String artist, String track) {
		this.artist = artist;
		this.track = track;
		setUrl(artist,track);
	}
	
	public WebsiteParseUtility(String artist, String track, String url) {
		this.artist = artist;
		this.track = track;
		this.url = url;
	}
	
	public void setArtist(String artist){
		this.artist = artist;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public void setTrack(String track) {
		this.track = track;
	}
	
	public String getTrack() {
		return track;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String artist, String track) {
		url = "https://www.azlyrics.com/lyrics/" + artist.trim().toLowerCase().replaceAll(" ", "") + "/" + track.trim().toLowerCase().replaceAll(" ", "") + ".html";
	}
	
	public String findLyrics() {
		WebsiteParseManager lyricData;
		String lyrics = "";
		URLConnection con;
		InputStream is;
		BufferedReader br;
		//URL setup
		URL url;
		try {
			url = new URL(this.url);
			con = url.openConnection();
			is = con.getInputStream();
			
			br = new BufferedReader(new InputStreamReader(is));
			
			String data = "";
			
			//Read each line
			while(br.ready()) {
				data += br.readLine();
			}
			
			lyricData = new WebsiteParseManager(data);
			
			lyrics = lyricData.chop();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lyrics;
		
	}

}
