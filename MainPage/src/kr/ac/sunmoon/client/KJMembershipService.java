package kr.ac.sunmoon.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import kr.ac.sunmoon.shared.KJMember;

@RemoteServiceRelativePath("KJmembershipService")
public interface KJMembershipService extends RemoteService {
	
	KJMember findKJmember(String iD, String name);
	void Register_Membership(KJMember kjMember);
	boolean checkID(KJMember kjMember);
	boolean LoginService(KJMember crKJmember);


}
