package getVoiceText;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class RestCall {
	
	String email = "";
	String date = "";
	
	public RestCall(String email/*, String date*/){
		this.email = email;
		/*this.date = date;*/
	}
	
	public String setVoice(String location){
		StringBuilder sb = new StringBuilder();
		try{
			URL url = new URL("https://api.havenondemand.com/1/api/async/recognizespeech/v1?apikey=8ba77a61-01ec-4e1b-8fac-f963f95a0afe&file=" + location);
	        
	        //make connection
	        URLConnection urlc = url.openConnection();

	        //use post mode
	        urlc.setDoOutput(true);
	        urlc.setAllowUserInteraction(false);

	        //get result
	        BufferedReader br = new BufferedReader(new InputStreamReader(urlc
	            .getInputStream()));
	        String l = null;
	        while ((l=br.readLine())!=null) {
	        	sb.append(l);
	        }
	        br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return sb.toString();
	}

	public String getText() {
		StringBuilder sb = new StringBuilder();
		try{
			URL url = new URL("https://api.havenondemand.com/1/job/result/usw3p_4bbe5035-6776-47b1-ae99-acd6fca1d51f?apikey=bcfd480a-4c39-4f36-88b7-0989ad6c703c");
	        
	        //make connection
	        URLConnection urlc = url.openConnection();

	        //use post mode
	        urlc.setDoOutput(true);
	        urlc.setAllowUserInteraction(false);

	        //get result
	        BufferedReader br = new BufferedReader(new InputStreamReader(urlc
	            .getInputStream()));
	        String l = null;
	        while ((l=br.readLine())!=null) {
	        	sb.append(l);
	        }
	        br.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return sb.toString();
	}
}
