package newissue

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.commons.codec.binary.Base64

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

class GithubService {

	def createIssue(String title, String description) {
		def username = CH.config.grails.github.username
		def passwrd = CH.config.grails.github.passwrd
		def url = CH.config.grails.github.url

		def userPassEncoded = Base64.encodeBase64String("${username}:${passwrd}".getBytes())
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(url);

		// set header for authentication..
		post.setHeader("Authorization", "Basic " + userPassEncoded)

		// set body
		// TODO: Should escape characters like ' and "!
		post.setEntity(new StringEntity("""{ "title": "${title}", "body": "${description}" }"""));
		// execute request
		HttpResponse response = client.execute(post);
		// get response.
		def rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		log.debug(rd.getText())
		// normally requests under 400 are ok ;D So the submission was complete
		return response.getStatusLine().getStatusCode() < 400
	}

    def serviceMethod() {

    }
}
