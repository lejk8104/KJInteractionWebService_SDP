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
import com.gwtext.client.widgets.layout.HorizontalLayout;
import com.gwtext.client.widgets.layout.VerticalLayout;

public class ChatRoom extends Window{
	public ChatRoom() {
		super();
		this.setBorder(false);
		this.setPaddings(0);
		this.setClosable(true);
		this.setWidth(700);
		this.setHeight(400);
		this.setPlain(true);
		this.setCloseAction(this.HIDE);
		
		
		final FormPanel chatroomform = new FormPanel();  
        chatroomform.setFrame(true);
        chatroomform.setTitle("Chatting Page");
        chatroomform.setWidth(700);
        chatroomform.setLabelWidth(55);
        chatroomform.setButtonAlign(Position.CENTER);
        chatroomform.setMargins(0, 15, 0, 0);
        chatroomform.setLayout(new ColumnLayout());
        
        Panel overallPanel = new Panel();
        overallPanel.setBorder(false);
//        overallPanel.setPaddings(15);
        overallPanel.setLayout(new HorizontalLayout(15));
        chatroomform.add(overallPanel);
          
        
        //user1
        Panel user1Panel = new Panel();
        user1Panel.setLayout(new VerticalLayout(15));  
        user1Panel.setBorder(false);
        
        Image imglogo1 = new Image();
		imglogo1.setUrl("image/login.png");
		user1Panel.add(imglogo1, new AnchorLayoutData("97%"));
		
		overallPanel.add(user1Panel);  
		Label lb1 = new Label("seiya.u77 ");
		lb1.setPosition(30, 10);
		user1Panel.add(lb1, new AnchorLayoutData("97%"));
		
		// 채팅룸
        Panel chatroomPanel = new Panel();  
        chatroomPanel.setLayout(new VerticalLayout(15));
        chatroomform.setMargins(30, 0, 0, 0);
        chatroomPanel.setBorder(false);
        
        //메세지 막스
        TextField messagebox = new TextField();
        messagebox.setWidth("300");
        
        chatroomPanel.setHtml("<p>Send your message</p>");
        
        chatroomPanel.add(messagebox, new AnchorLayoutData("97%"));
        overallPanel.add(chatroomPanel);
        
        //user1
        Panel user1Panel2 = new Panel();
        user1Panel2.setLayout(new VerticalLayout(15));  
        user1Panel2.setBorder(false);
        
        Image imglogo2 = new Image();
		imglogo2.setUrl("image/login.png");
		user1Panel2.add(imglogo2, new AnchorLayoutData("97%"));
		Label lb12 = new Label("jaekeunlee ");
		user1Panel2.add(lb12, new AnchorLayoutData("97%"));
		
        chatroomform.add(user1Panel2);
        
        //interests panel
        Panel interest_user1 = new Panel();  
        interest_user1.setLayout(new FormLayout()); 
        interest_user1.setBorder(false);
        
        Panel interest_user2 = new Panel();  
        interest_user2.setLayout(new FormLayout());  
        interest_user2.setBorder(false);
        
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
        
        user1Panel.add(interest_user1);
        
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
        
        user1Panel2.add(interest_user2);
        
        //채팅 창
//        Panel chattingForm = new Panel();
//        chattingForm.setLayout(new FormLayout());  
//        chattingForm.setBorder(false);
//        chattingForm.setBodyStyle("background-color:#EEEEEE");
//        chattingForm.setMargins(0, 10, 0, 0);
//        
        
//        chatroomform.add(interest_user1, new ColumnLayoutData(0.33));
//        chatroomform.add(chattingForm, new ColumnLayoutData(0.33));
//        chatroomform.add(interest_user2, new ColumnLayoutData(0.33));
        
        
        this.add(chatroomform);
	}
}
