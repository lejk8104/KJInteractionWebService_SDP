package kr.ac.sunmoon.client;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;
import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.Label;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.layout.AnchorLayoutData;
import com.gwtext.client.widgets.layout.ColumnLayout;
import com.gwtext.client.widgets.layout.ColumnLayoutData;
import com.gwtext.client.widgets.layout.FormLayout;

public class ChatRoom extends Window{
	public ChatRoom() {
		super();
		this.setBorder(false);
		this.setPaddings(0);
		this.setClosable(true);
		this.setWidth(512);
		this.setHeight(400);
		this.setPlain(true);
		this.setCloseAction(this.HIDE);
		
		
		final FormPanel chatroomform = new FormPanel();  
        chatroomform.setFrame(true);
        chatroomform.setTitle("Let's Chatting!");
        chatroomform.setWidth(500);
        chatroomform.setLabelWidth(55);
        chatroomform.setButtonAlign(Position.CENTER);
        chatroomform.setMargins(0, 15, 0, 0);
        chatroomform.setLayout(new ColumnLayout());
        
        //user
        Panel imgPanel_c1 = new Panel();
        imgPanel_c1.setLayout(new FormLayout());  
        imgPanel_c1.setBorder(false);
        
        Image imglogo1 = new Image();
		imglogo1.setUrl("image/login.png");
		imgPanel_c1.add(imglogo1, new AnchorLayoutData("97%"));
		
        chatroomform.add(imgPanel_c1, new ColumnLayoutData(0.2));  
        
        Panel text_Panel_c3 = new Panel();  
        text_Panel_c3.setLayout(new FormLayout());
        text_Panel_c3.setWidth(100);
        text_Panel_c3.setBorder(false);
        
        TextBox txtinput = new TextBox();
        txtinput.setHeight("100");
        
        text_Panel_c3.add(txtinput, new AnchorLayoutData("97%"));
        chatroomform.add(text_Panel_c3, new ColumnLayoutData(0.6));  
        
        Panel imgPanel_c2 = new Panel();
        imgPanel_c2.setLayout(new FormLayout());  
        imgPanel_c2.setBorder(false);
        
        Image imglogo2 = new Image();
		imglogo2.setUrl("image/login.png");
		imgPanel_c2.add(imglogo2, new AnchorLayoutData("97%"));
		
        chatroomform.add(imgPanel_c2, new ColumnLayoutData(0.2));
        
        Label lb1 = new Label("seiya.u77 ");
        Label lb12 = new Label("jungkim ");
		
        Panel first_Column = new Panel();  
        first_Column.setLayout(new FormLayout());  
        first_Column.setBorder(false);
        first_Column.setMargins(0, 20, 0, 0);
        
        Panel second_Column = new Panel();  
        second_Column.setLayout(new FormLayout());  
        second_Column.setBorder(false); 
        
        first_Column.add(lb1, new AnchorLayoutData("200%"));
        second_Column.add(lb12, new AnchorLayoutData("200%"));
        
        chatroomform.add(first_Column, new ColumnLayoutData(0.85));
        chatroomform.add(second_Column, new ColumnLayoutData(0.1));
        
        this.add(chatroomform);
	}
}
