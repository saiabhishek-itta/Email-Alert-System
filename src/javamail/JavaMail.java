package javamail;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JavaMail {
	public static void main(String srgs[]) throws Exception {
		System.out.println("loading");
		
		String billid="b2";
		
		HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://abishekitta.free.beeceptor.com/oorja/id="+billid))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        String email=response.body().split(",")[1];
        String status=response.body().split(",")[0];
	
        if(status.equals("not paid"))
		JavaMailUtil.sendMail(email,billid);
        
        else
        	System.out.println("Bill Payment was done (Bill Id = "+billid+")");
	}

}
