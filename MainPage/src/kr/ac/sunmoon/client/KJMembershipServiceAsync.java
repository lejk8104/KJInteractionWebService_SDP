package kr.ac.sunmoon.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import kr.ac.sunmoon.shared.KJMember;

public interface KJMembershipServiceAsync {

	void findKJmember(String keyword, int option, AsyncCallback<KJMember[]> callback);
	void Register_Membership(KJMember kjMember, AsyncCallback<Void> callback);
	
	void checkID(KJMember kjMember, AsyncCallback<Boolean> asyncCallback);
	void LoginService(KJMember crKJmember, AsyncCallback<Boolean> asyncCallback);
	
}
