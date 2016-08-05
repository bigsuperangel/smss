package com.yulin.smss;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.yulin.model.SmsModel;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

public class SmsObserver extends ContentObserver {
	private final String TAG = "logshow";
	private Activity activity = null;
	private TextView tv = null;
	private Uri SMS_INBOX = Uri.parse("content://sms/"); 
    final String SMS_URI_ALL = "content://sms/";  
    final String SMS_URI_INBOX = "content://sms/inbox";  
    final String SMS_URI_SEND = "content://sms/sent";  
    final String SMS_URI_DRAFT = "content://sms/draft";  
    final String SMS_URI_OUTBOX = "content://sms/outbox";  
    final String SMS_URI_FAILED = "content://sms/failed";  
    final String SMS_URI_QUEUED = "content://sms/queued";  

	public SmsObserver(Activity activity, Handler handler, TextView tv) {
		super(handler);
		this.activity = activity;
		this.tv = tv;
	}

	@Override
	public void onChange(boolean selfChange) {
		// 每当有新短信到来时，使用我们获取短消息的方法
		tv.setText(getSmsFromPhone());
		super.onChange(selfChange);
	}
	
	 public String getSmsFromPhone() {  
	        StringBuilder smsBuilder = new StringBuilder();  
	        try {  
	        	ContentResolver cr = activity.getContentResolver();
	            String[] projection = new String[] { "_id", "address", "person", "body", "date", "type","read" };  
	    		String where = "type=1 and read=0";
	    		Cursor cur = cr.query(SMS_INBOX, projection, where, null, null);
	    		
	           if (cur.moveToFirst()) {  
	                int index_Address = cur.getColumnIndex("address");  
	                int index_Person = cur.getColumnIndex("person");  
	                int index_Body = cur.getColumnIndex("body");  
	                int index_Date = cur.getColumnIndex("date");  
	                int index_Type = cur.getColumnIndex("type");  
	                int index_Read = cur.getColumnIndex("read");
	                
	                do {  
	                    String strAddress = cur.getString(index_Address);  
	                    int intPerson = cur.getInt(index_Person);  
	                    String strbody = cur.getString(index_Body);  
	                    String body = "";
	                    Log.d(TAG, strbody);
	                    if(strbody.contains("https")){
	                    	body = strbody.split("=")[1];
	                    	Log.d(TAG,body);
	                    }
	                    long longDate = cur.getLong(index_Date);  
	                    int intType = cur.getInt(index_Type);  
	  
	                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");  
	                    Date d = new Date(longDate);  
	                    String strDate = dateFormat.format(d);  
	                    
	                    int read = cur.getInt(index_Read);
	                    Log.d(TAG,read+"");
	  
	                    SmsModel sms = new SmsModel();
	                    sms.setAddress(strAddress);
	                    sms.setDate(strDate);
	                    sms.setBody(body);
	                    
	                    
	                    smsBuilder.append("[ ");  
	                    smsBuilder.append(strAddress + ", ");  
	                    smsBuilder.append(intPerson + ", ");  
	                    smsBuilder.append(strbody + ", ");  
	                    smsBuilder.append(strDate );  
	                    smsBuilder.append(" ]\n\n");  
	                } while (cur.moveToNext());  
	  
	                if (!cur.isClosed()) {  
	                    cur.close();  
	                    cur = null;  
	                }  
	            } else {  
	                smsBuilder.append("no result!\n");  
	            }// end if  
	  
	            smsBuilder.append("getSmsInPhone has executed!");  
	  
	        } catch (SQLiteException ex) {  
	            Log.d("SQLiteException in getSmsInPhone", ex.getMessage());  
	        }  
	  
	        return smsBuilder.toString();  
	    }  

}
