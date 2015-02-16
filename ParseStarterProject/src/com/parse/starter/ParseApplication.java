package com.parse.starter;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseCrashReporting;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class ParseApplication extends Application {


  @Override
  public void onCreate() {
    super.onCreate();


    // Initialize Crash Reporting.
    ParseCrashReporting.enable(this);

    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);

    // Add your initialization code here
    Parse.initialize(this, "vb1B61NgiGqKdeMth07taxs4NaoB7Nhv6tOG7Pka", "osVUvWmScOlYgeKtSsyBDrV9XkEHT3A7LwqWr48T");
      ParseInstallation.getCurrentInstallation().saveInBackground();



      ParsePush.subscribeInBackground("", new SaveCallback() {
          @Override
          public void done(com.parse.ParseException e) {
              if (e == null) {
                  Log.d("com.parse.push", "successfully subscribed to the broadcast channel.");
              } else {
                  Log.e("com.parse.push", "failed to subscribe for push", e);
              }
          }

      });

    ParseUser.enableAutomaticUser();
    ParseACL defaultACL = new ParseACL();
    // Optionally enable public read access.
    // defaultACL.setPublicReadAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);
  }
}
