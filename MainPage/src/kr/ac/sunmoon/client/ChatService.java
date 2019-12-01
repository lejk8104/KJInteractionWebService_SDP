package kr.ac.sunmoon.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Image;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.Label;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.ColumnLayoutData;

import javafx.scene.control.Alert;

public class ChatService extends Panel {
	private Label lb2;

	public ChatService() {
		
		super();
		this.setBorder(false);
		this.setPaddings(0);
		this.setClosable(true);
		this.setWidth(700);
//		this.setBodyStyle("background-color:#CDEB8B");  
		this.setHeight(600);
		this.setMargins(20, 70, 50, 20);
//		this.setPlain(true);
//		this.setCloseAction(this.HIDE);
		
		final FormPanel chatform = new FormPanel();  
        chatform.setFrame(true);
        chatform.setTitle("Chatting Service");
        chatform.setWidth(550);
        chatform.setHeight(250);
        chatform.setLabelWidth(55);
        chatform.setButtonAlign(Position.CENTER);
        chatform.setMargins(0, 0, 0, 0);
        
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
				com.google.gwt.user.client.Window.alert(result);
				lb2.setText(result);
			}
			
			@Override
			public void onFailure(Throwable caught) {
				com.google.gwt.user.client.Window.alert("failed with matching");
			}
		});
		
		Button startBtn = new Button("chatting start", new ButtonListenerAdapter() {
			public void onClick(Button startBtn, EventObject e) {
				ChatRoom chatRoom = new ChatRoom();
				chatRoom.show();
			}
		});
		chatform.addButton(startBtn);
		
		Button againBtn = new Button("matching again");
		chatform.addButton(againBtn);
		
		Button cancelBtn = new Button("cancel");
		chatform.addButton(cancelBtn);
		
        this.add(chatform);
	}
}
