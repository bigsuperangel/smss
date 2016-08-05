package com.yulin.smss;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private Uri SMS_INBOX = Uri.parse("content://sms/"); 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView tv = new TextView(this);  
		SmsObserver smsObserver = new SmsObserver(this, smsHandler,tv);
		getContentResolver().registerContentObserver(SMS_INBOX, true,smsObserver);
        ScrollView sv = new ScrollView(this);  
        sv.addView(tv);  
          
        setContentView(sv);  
	}
	
	public Handler smsHandler = new Handler() {
		//这里可以进行回调的操作
		//TODO
		
	};
}
