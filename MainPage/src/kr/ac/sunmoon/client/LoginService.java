package kr.ac.sunmoon.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;  

import kr.ac.sunmoon.shared.KJMember;

public class LoginService extends Window{

private TextBox[] logininputs;
	
	public LoginService()  {
	
		super();
		this.setBorder(false);
		this.setPaddings(0);
		this.setClosable(true);
		this.setWidth(360);
		this.setHeight(170);
		this.setPlain(true);
		this.setCloseAction(this.HIDE);
		
        final FormPanel loginform = new FormPanel();  
        loginform.setFrame(true);
        loginform.setTitle("Login Service");
        loginform.setWidth(350);  
        loginform.setLabelWidth(55);
        loginform.setButtonAlign(Position.CENTER);
  
        // ID input
        TextField txtID = new TextField("ID", "id", 250);  
        txtID.setAllowBlank(false);  
        loginform.add(txtID);  
  
//        txtID.getText()
        // Password input
        TextField txtPassword = new TextField("Password", "password", 250);  
        loginform.add(txtPassword);  
  
        //login btn
        Button btnlogin = new Button("Login", new ButtonListenerAdapter() {
            public void onClick(Button btnlogin, EventObject e) {  
//                this.show();      //로그인
            }
        });
        loginform.addButton(btnlogin);  
        
        // Cancel btn
        Button btncancel = new Button("Cancel", new ButtonListenerAdapter() {
        	public void onClick(Button btncancel, EventObject e) {
//        		
        		//window 연결
        	}
        });  
        loginform.addButton(btncancel); 
  
        // Regsiter btn
        Button btnregister = new Button("Register our Membership", new ButtonListenerAdapter() {
        	public void onClick(Button btnregister, EventObject e) {
        		Register_Membership registerwindow = new Register_Membership();
        		registerwindow.show();
        	}
        });
        loginform.addButton(btnregister);  
  
        //두번째 form
        Panel secondPanel = new Panel();
        secondPanel.setButtonAlign(Position.CENTER);
//        secondPanel.setLayout(new ColumnLayout());
//        secondPanel.setMargins(0, 0, 0, 0);
        
        // Findid btn
        Button btnfindid = new Button("Find ID", new ButtonListenerAdapter() {
        		public void onClick(Button btnfindid, EventObject e) {
        			FindID findidwindow = new FindID();
        			findidwindow.show();
        }
    });  
        secondPanel.addButton(btnfindid); 
        
        // Findpassword btn
        Button btnfindpassword = new Button("Find Password", new ButtonListenerAdapter() {
        	public void onClick(Button btnfindpassword, EventObject e) {
        		FindPassword findpasswordwindow = new FindPassword();
        		findpasswordwindow.show();
            }
        	
        });  
        secondPanel.addButton(btnfindpassword); 
        loginform.add(secondPanel);
        this.add(loginform); 
        
//        loginPanel.add(window);

//        RootPanel.get().add(loginPanel);  
    }  
}
