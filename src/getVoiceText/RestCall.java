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
	String jobId = "";
	
	public RestCall(String email/*, String date*/){
		this.email = email;
		/*this.date = date;*/
	}
	
	public void setJobId(String jobId){
		this.jobId = jobId;
	}
	
	public String setVoice(String location){
		StringBuilder sb = new StringBuilder();
		try{
			URL url = new URL("https://api.havenondemand.com/1/api/async/recognizespeech/v1?apikey=8ba77a61-01ec-4e1b-8fac-f963f95a0afe&file=/voice/" + location);
	        
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
		String str = sb.toString().substring(sb.toString().indexOf("\"")+1);
		str = str.substring(str.indexOf("\"")+1);
		str = str.substring(str.indexOf("\"")+1);
		
		str = str.substring(0, str.indexOf("\""));
		
		return str;
	}

	public String getText(String jobIdd) {
		StringBuilder sb = new StringBuilder();
		try{
			URL url = new URL("https://api.havenondemand.com/1/job/result/" + jobIdd + "?apikey=8ba77a61-01ec-4e1b-8fac-f963f95a0afe");
	        
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
