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
		
		Panel loginPanel = new Panel();  
        loginPanel.setBorder(false);  
        loginPanel.setPaddings(15);  
        this.add(loginPanel);
        
        final Window window = new Window();
        window.setTitle("Login Service");
        window.setWidth(350);  
        window.setHeight(170);  
        window.setMinWidth(300);  
        window.setMinHeight(200); 
        
        window.setCloseAction(Window.HIDE);
        window.setPlain(true);
        
        
        final FormPanel loginform = new FormPanel();  
        loginform.setFrame(true);  
        loginform.setWidth(350);  
        loginform.setLabelWidth(55);
        loginform.setButtonAlign(Position.CENTER);
  
        // ID input
        TextField txtID = new TextField("ID", "id", 250);  
        txtID.setAllowBlank(false);  
        loginform.add(txtID);  
  
        // Password input
        TextField txtPassword = new TextField("Password", "password", 250);  
        loginform.add(txtPassword);  
  
        //login btn
        Button btnlogin = new Button("Login", new ButtonListenerAdapter() {
            public void onClick(Button btnlogin, EventObject e) {  
                window.show();      //로그인
            }
        });
        loginform.addButton(btnlogin);  
        
        // Cancel btn
        Button btncancel = new Button("Cancel", new ButtonListenerAdapter() {
        	public void onClick(Button btncancel, EventObject e) {
        		window.hide(); //window 연결
        	}
        });  
        loginform.addButton(btncancel); 
  
        // Regsiter btn
        Button btnregister = new Button("Register our Membership", new ButtonListenerAdapter() {
        	public void onClick(Button btnregister, EventObject e) {
        		window.show(); //window 연결
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
    		window.show(); //window 연결
        }
    });  
        secondPanel.addButton(btnfindid); 
        
        // Findpassword btn
        Button btnfindpassword = new Button("Find Password", new ButtonListenerAdapter() {
        	public void onClick(Button btnfindpassword, EventObject e) {
        		window.show(); //window 연결
            }
        });  
        secondPanel.addButton(btnfindpassword); 
        loginform.add(secondPanel);
        window.add(loginform); 
        
        loginPanel.add(window);

        RootPanel.get().add(loginPanel);  
    }  
}
