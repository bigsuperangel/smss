package com.yulin.model;

public class SmsModel{
//			_id��������ţ���100
//	����thread_id���Ի�����ţ���100����ͬһ���ֻ��Ż����Ķ��ţ����������ͬ��
//	����address�������˵�ַ�����ֻ��ţ���+86138138000
//	����person�������ˣ������������ͨѶ¼����Ϊ����������İ����Ϊnull
//	����date�����ڣ�long�ͣ���1346988516�����Զ�������ʾ��ʽ��������
//	����protocol��Э��0SMS_RPOTO���ţ�1MMS_PROTO����
//	����read���Ƿ��Ķ�0δ����1�Ѷ�
//	����status������״̬-1���գ�0complete,64pending,128failed
//	����type����������1�ǽ��յ��ģ�2���ѷ���
//	����body�����ž�������
//	����service_center�����ŷ������ĺ����ţ���+8613800755500
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
