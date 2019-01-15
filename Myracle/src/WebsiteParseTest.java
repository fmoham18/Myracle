import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class WebsiteParseTest {
	
	public static void main(String[] args) throws IOException {
		WebsiteParseManager lyricData;
		String lyrics;
		//URL setup
		URL url = new URL("https://www.azlyrics.com/lyrics/daftpunk/getlucky.html");
		
		//Get the input stream from the website
		URLConnection con = url.openConnection();
		InputStream is = con.getInputStream();
		
		//Reader
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		String data = "";
		
		//Read each line
		while(br.ready()) {
			data += br.readLine();
			System.out.println(data);
		}
		
		lyricData = new WebsiteParseManager(data);
		
		lyrics = lyricData.chop();
		
		System.out.println(lyrics);
		
		
	}

}
