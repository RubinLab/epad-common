package edu.stanford.epad.common.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.google.gwt.resources.client.ResourceException;

import edu.stanford.epad.common.util.EPADConfig;
import edu.stanford.epad.common.util.EPADLogger;
import edu.stanford.hakan.aim4api.project.epad.Utils;

public class WebAuthFilter implements Filter {

	private static final EPADLogger log = EPADLogger.getInstance();
	private static final String WEBAUTH_HEADER = "X-WEBAUTH-USER";
	private static final String JSESSIONID_COOKIE = "JSESSIONID";
	private static final String LOGGEDINUSER_COOKIE = "ePADLoggedinUser";
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String webAuthUser = httpRequest.getHeader(WEBAUTH_HEADER);
	    if (webAuthUser != null && webAuthUser.length() > 0 && EPADConfig.webAuthPassword != null)
		{
			String sessionID = null;
			Cookie[] cookies = httpRequest.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if ("JSESSIONID".equalsIgnoreCase(cookie.getName())) {
						sessionID = cookie.getValue();
						break;
					}
				}
			}
			if (sessionID == null) {
				try {
					// Note: On the client, this call should be SessionResource.createSession(List<String>() with username, password)
					log.info("WebAuth login request from user:" + webAuthUser  + " host: " + httpRequest.getRemoteHost() +":" + httpRequest.getRemoteAddr());
					sessionID = createSession(webAuthUser, EPADConfig.webAuthPassword);
		            //EPADSessionOperations.setSessionHost(sessionID, httpRequest.getRemoteHost(), httpRequest.getRemoteAddr());
					Cookie userName = new Cookie(LOGGEDINUSER_COOKIE, webAuthUser);
		            userName.setMaxAge(-1);
		            userName.setPath(httpRequest.getContextPath());
		            httpResponse.addCookie(userName);
		            Cookie sessionCookie = new Cookie(JSESSIONID_COOKIE, sessionID);
		            sessionCookie.setMaxAge(-1);
		            sessionCookie.setPath(httpRequest.getContextPath());
		            httpResponse.addCookie(sessionCookie);
		            if (httpRequest.getRequestURL().toString().indexOf("Web_pad") == -1)
		            	httpResponse.sendRedirect("Web_pad.html");
		            return;
				} catch (Exception e) {
					log.warning("Error logging in WebAuth User", e);
				}
			}
		}
	    if (httpRequest.getRequestURL().indexOf("WEB-INF") != -1) {
	    	// How come, this weird jetty allows this?
			PrintWriter pw = httpResponse.getWriter();
			httpResponse.setContentType("text/html");
			pw.append("<html> <head> <meta http-equiv='Content-Type' content='text/html;charset=ISO-8859-1'/>" 
					+ "<title>Error 403 Forbidden</title>"
					+ "</head> <body> <h2>HTTP ERROR: 403 Forbidden</h2>"
					+ "</body></html>");
			httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
			return;
	    }
        filterChain.doFilter(request, response);
		return;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}	

	private String buildAuthorizatonString(String username, String password) {
		String authString = username + ":" + password;
		byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
		String authStringEnc = new String(authEncBytes);
		return authStringEnc;
	}

	public String createSession(String username, String password) throws Exception {


		String result = null;

		String authString = buildAuthorizatonString(username, password);
		String url = EPADConfig.getParamValue("serverProxy") + "/epad/session/";

		// make the call
		DefaultHttpClient client = new DefaultHttpClient();

		HttpPost httppost = new HttpPost(url);

		try {

			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			nameValuePairs.add(new BasicNameValuePair("username", username));
			nameValuePairs.add(new BasicNameValuePair("password", password));
			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

			httppost.setHeader("Authorization", "Basic " + authString);

			// make the call
			HttpResponse response = client.execute(httppost);

			// Header[] headers = response.getAllHeaders();

			// reflect the status line
			StatusLine statusLine = response.getStatusLine();
			//Utils.setStatus("SessionResource", statusLine, this);

			HttpEntity responseEntity = response.getEntity();
			if (responseEntity != null) {
				InputStream instream = responseEntity.getContent();

				BufferedReader rd = new BufferedReader(new InputStreamReader(
						response.getEntity().getContent()));
				String line = "";
				while ((line = rd.readLine()) != null) {
					log.info("read a line " + line);
					result = line;
				}
				instream.close();
			}

		} catch (IOException e) {
			log.info("response exception ");
			log.warning("IOException", e);
		} catch (Exception e) {
			log.info("response exception ");
			log.warning("Exception", e);
		}
		log.info("return result " + result);
		return result;
	}

}
