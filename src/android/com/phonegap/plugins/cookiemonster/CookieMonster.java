package com.phonegap.plugins.cookiemonster;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class CookieMonster extends CordovaPlugin {

  private final String TAG = "CookieMonsterPlugin";
  public static final String ACTION_GET_COOKIE_VALUE = "getCookieValue";

  @Override
  public boolean execute(String action, JSONArray args,
      final CallbackContext callbackContext) throws JSONException {
    try {
      if (ACTION_GET_COOKIE_VALUE.equals(action)) {
        final String url = args.getString(0);
        final String cookieName = args.getString(1);

        cordova.getThreadPool().execute(new Runnable() {
          public void run() {
            try {
              String cookieValue = Utils.getCookie(url, cookieName);
              JSONObject json = null;
              if (cookieValue != null) {
                Log.v(TAG, cookieName + ": " + cookieValue);
                json = new JSONObject("{cookieValue:" + cookieValue + "}");
              }
              if (json != null) {
                PluginResult res = new PluginResult(PluginResult.Status.OK,
                    json);
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
