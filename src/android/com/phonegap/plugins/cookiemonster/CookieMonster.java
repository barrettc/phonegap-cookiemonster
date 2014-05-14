package com.phonegap.plugins.cookiemonster;
 
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.cookie.Cookie;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.util.List;

public class CookieMonster extends CordovaPlugin {

  private final String TAG = "CookieMonsterPlugin";
  public static final String ACTION_GET_COOKIE_VALUE = "getCookieValue";
  
  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    try {
      if (ACTION_GET_COOKIE_VALUE.equals(action)) {
        final String url = args.getString(0);
        final String cookieName = args.getString(1);
        
        cordova.getThreadPool().execute(new Runnable() {
          public void run() {
            try {
              DefaultHttpClient client = new DefaultHttpClient();
              HttpGet request = new HttpGet(url);
              HttpResponse response = client.execute(request);
              
              CookieStore cookieStore = client.getCookieStore();
              List<Cookie> cookies = cookieStore.getCookies();
              
              JSONObject json = null;
              for (Cookie cookie : cookies) {
                if (cookie.getName().equals(cookieName)) {
                  String value = cookie.getValue();
                  Log.v(TAG, cookieName + ": " + value);
                  json = new JSONObject("{cookieValue:" + value + "}");
                }
              }
              if (json != null) {
                PluginResult res = new PluginResult(PluginResult.Status.OK, json);
                callbackContext.sendPluginResult(res);        
              } else {
                callbackContext.error("Cookie not found!");
              }
            } catch (Exception e) {
              Log.e(TAG, "Exception: " + e.getMessage());
              callbackContext.error(e.getMessage());
            }        
          }
        });
        return true;      
      }
      callbackContext.error("Invalid action");
      return false;
    } catch (Exception e) {
      Log.e(TAG, "Exception: " + e.getMessage());
      callbackContext.error(e.getMessage());
      return false;
    }
  }
}
