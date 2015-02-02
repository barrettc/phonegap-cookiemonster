package com.phonegap.plugins.cookiemonster;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import com.phonegap.plugins.cookiemonster.Utils;

@RunWith(RobolectricTestRunner.class)
public class UtilsTest {
  @Test
  public void testGetSession(){
    
    Robolectric.getFakeHttpLayer().interceptHttpRequests(false);
    String session = Utils.getSession("http://localhost:3000");
    Assert.assertNotNull("session should not be null", session);
  }

}
