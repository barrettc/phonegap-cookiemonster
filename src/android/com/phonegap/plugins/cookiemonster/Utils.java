package com.phonegap.plugins.cookiemonster;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

public class Utils {

  protected static AbstractHttpClient client;

  public static String getCookie(final String url, final String cookieName) {
    client = getClient();
    HttpGet request = new HttpGet(url);
    try {
      client.execute(request);
    } catch (ClientProtocolException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    CookieStore cookieStore = client.getCookieStore();
    List<Cookie> cookies = cookieStore.getCookies();

    String cookieValue = null;
    for (Cookie cookie : cookies) {
      if (cookie.getName().equals(cookieName)) {
        cookieValue = cookie.getValue();
      }
    }
    return cookieValue;
  }

  private static AbstractHttpClient getClient() {
    if(client== null){
      client = new DefaultHttpClient();
    }
    return client;
  }

  public static String getSession(String url) {
    String encoded = getCookie(url, "connect.sid");
    try {
      String decoded = URLDecoder.decode(encoded, "UTF-8");
      return decoded.replaceFirst("s:([^\\.]*).*", "$1");
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException(e);
    }
  }
  
}
