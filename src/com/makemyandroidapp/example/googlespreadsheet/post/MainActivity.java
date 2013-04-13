package com.makemyandroidapp.example.googlespreadsheet.post;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
	
	final String myTag = "DocsUpload";
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i(myTag, "OnCreate()");
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				postData();
				
			}
		});
		t.start();
	}

	
	public void postData() {

		String fullUrl = "https://docs.google.com/forms/d/15eWiE2LhJWlyQGb437Ol82wNKmfK1-0vaOgktTuEwyk/formResponse";
		HttpRequest mReq = new HttpRequest();
		String col1 = "Hello";
		String col2 = "World";
		String data = "entry_451758497=" + URLEncoder.encode(col1) + "&" + 
					  "entry_1932654660=" + URLEncoder.encode(col2);
		String response = mReq.sendPost(fullUrl, data);
		Log.i(myTag, response);
	} 

}
