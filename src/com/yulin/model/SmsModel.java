package com.yulin.model;

public class SmsModel{
//			_id：短信序号，如100
//	　　thread_id：对话的序号，如100，与同一个手机号互发的短信，其序号是相同的
//	　　address：发件人地址，即手机号，如+86138138000
//	　　person：发件人，如果发件人在通讯录中则为具体姓名，陌生人为null
//	　　date：日期，long型，如1346988516，可以对日期显示格式进行设置
//	　　protocol：协议0SMS_RPOTO短信，1MMS_PROTO彩信
//	　　read：是否阅读0未读，1已读
//	　　status：短信状态-1接收，0complete,64pending,128failed
//	　　type：短信类型1是接收到的，2是已发出
//	　　body：短信具体内容
//	　　service_center：短信服务中心号码编号，如+8613800755500
	private String address;
	private String date;
	private String body;
	private long personalMobile;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public long getPersonalMobile() {
		return personalMobile;
	}
	public void setPersonalMobile(long personalMobile) {
		this.personalMobile = personalMobile;
	}
	
	
}
