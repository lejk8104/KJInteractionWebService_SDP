package kr.ac.sunmoon.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.Label;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.ColumnLayoutData;

import javafx.scene.control.Alert;

public class ChatService extends Window {
	private Label lb2;

	public ChatService() {
		
		super();
		this.setBorder(false);
		this.setPaddings(0);
		this.setClosable(true);
		this.setWidth(1024);
		this.setHeight(700);
		this.setPlain(true);
		this.setCloseAction(this.HIDE);
		
		final FormPanel chatform = new FormPanel();  
        chatform.setFrame(true);
        chatform.setTitle("Chatting Service");
        chatform.setWidth(1024);
        chatform.setLabelWidth(55);
        chatform.setButtonAlign(Position.CENTER);
        
        Label lb1 = new Label("seiya.u77 ");
        chatform.add(lb1, new AnchorLayoutData("200%"));
        
        Image imglogo1 = new Image();
		imglogo1.setUrl("image/login.png");
        chatform.add(imglogo1, new AnchorLayoutData("30%"));
        
        Label lb0 = new Label("Succeeded in matching!");
        chatform.add(lb0);
        
        Image imglogo2 = new Image();
		imglogo2.setUrl("image/login.png");
        chatform.add(imglogo2, new AnchorLayoutData("30%"));
        
		lb2 = new Label();
		chatform.add(lb2, new AnchorLayoutData("200%"));
        
		KJMembershipServiceAsync service = GWT.create(KJMembershipService.class);
		service.findLCS("seiya.u77", new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				lb2.setText(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				com.google.gwt.user.client.Window.alert("failed with matching");
			}
		});

        this.add(chatform);
	}
}
