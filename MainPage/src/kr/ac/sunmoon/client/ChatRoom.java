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
		this.setWidth(615);
		this.setHeight(400);
		this.setPlain(true);
		this.setCloseAction(this.HIDE);
		
		
		final FormPanel chatroomform = new FormPanel();  
        chatroomform.setFrame(true);
        chatroomform.setTitle("Chatting Page");
        chatroomform.setWidth(600);
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
        Label lb12 = new Label("jaekeunlee ");
		
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
        
        
        //interests panel
        Panel interest_user1 = new Panel();  
        interest_user1.setLayout(new FormLayout());  
        interest_user1.setBorder(false);
//        interest_user1.setMargins(0, 0, 0, 0);
        
        Panel interest_user2 = new Panel();  
        interest_user2.setLayout(new FormLayout());  
        interest_user2.setBorder(false);
        interest_user2.setMargins(0, 100, 0, 0);
        
        
        //interest_user1
        final TextField interest1 = new TextField("Interest1", "data", 75);  
        interest1.setAllowBlank(false);  
        interest1.setValue("kjinteraction"); 
        interest_user1.add(interest1);
        
        final TextField interest2 = new TextField("Interest2", "data", 75);  
        interest2.setAllowBlank(false);  
        interest2.setValue("chatting"); 
        interest_user1.add(interest2);
        
        final TextField interest3 = new TextField("Interest3", "data", 75);  
        interest3.setAllowBlank(false);  
        interest3.setValue("fencing"); 
        interest_user1.add(interest3);

        final TextField interest4 = new TextField("Interest4", "data", 75);  
        interest4.setAllowBlank(false);  
        interest4.setValue("trip"); 
        interest_user1.add(interest4);
        
        final TextField interest5 = new TextField("Interest5", "data", 75);  
        interest5.setAllowBlank(false);  
        interest5.setValue("movie"); 
        interest_user1.add(interest5);
        
        //interest_user2
        final TextField interest_1 = new TextField("Interest1", "data", 75);  
        interest_1.setAllowBlank(false);  
        interest_1.setValue("kjinteraction"); 
        interest_user2.add(interest_1);
        
        final TextField interest_2 = new TextField("Interest2", "data", 75);  
        interest_2.setAllowBlank(false);  
        interest_2.setValue("chatting"); 
        interest_user2.add(interest_2);
        
        final TextField interest_3 = new TextField("Interest3", "data", 75);  
        interest_3.setAllowBlank(false);  
        interest_3.setValue("trip"); 
        interest_user2.add(interest_3);
        
        final TextField interest_4 = new TextField("Interest4", "data", 75);  
        interest_4.setAllowBlank(false);  
        interest_4.setValue("tennis"); 
        interest_user2.add(interest_4);
        
        final TextField interest_5 = new TextField("Interest5", "data", 75);  
        interest_5.setAllowBlank(false);  
        interest_5.setValue("reading"); 
        interest_user2.add(interest_5);
        
        Panel chattingForm = new Panel();
        chattingForm.setLayout(new FormLayout());  
        chattingForm.setBorder(false);
        chattingForm.setBodyStyle("background-color:#EEEEEE");
        chattingForm.setMargins(0, 10, 0, 0);
        
        
        chatroomform.add(interest_user1, new ColumnLayoutData(0.33));
//        chatroomform.add(chattingForm, new ColumnLayoutData(0.33));
        chatroomform.add(interest_user2, new ColumnLayoutData(0.33));
        
        
        this.add(chatroomform);
	}
}
