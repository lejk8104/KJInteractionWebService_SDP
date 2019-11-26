package kr.ac.sunmoon.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtext.client.widgets.Window;
import javafx.scene.control.Alert;

public class ChatService extends Window {
	public ChatService() {
		
		super();
		this.setBorder(false);
		this.setPaddings(0);
		this.setClosable(true);
		this.setWidth(1024);
		this.setHeight(700);
		this.setPlain(true);
		this.setCloseAction(this.HIDE);
		
		KJMembershipServiceAsync service = GWT.create(KJMembershipService.class);
		service.findLCS("a", new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				com.google.gwt.user.client.Window.alert(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				com.google.gwt.user.client.Window.alert("failed with matching");
			}
		});
	}
}
