package kr.ac.sunmoon.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.TextBox;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.grid.GridPanel;

import kr.ac.sunmoon.shared.KJMember;

public class LoginService extends Window{

String[] logindata = new String[2];
Window popup = new Window();

	public LoginService()  {
	
		super();
		this.setBorder(false);
		this.setPaddings(0);
		this.setClosable(true);
		this.setWidth(360);
		this.setHeight(170);
		this.setPlain(true);
		this.setCloseAction(this.HIDE);
		
		final Panel eodsl = new Panel();
		
		final FormPanel loginform = new FormPanel();  
        loginform.setFrame(true);
        loginform.setTitle("Login Service");
        loginform.setWidth(350);  
        loginform.setLabelWidth(55);
        loginform.setButtonAlign(Position.CENTER);
  
        // ID input
        final TextField loginID = new TextField("ID", "id", 250);  
        loginID.setAllowBlank(false);  
        loginform.add(loginID);  
  
//        txtID.getText()
        // Password input
        final TextField loginPassword = new TextField("Password", "password", 250);  
        loginform.add(loginPassword);  
  
        //login btn
        final Button btnlogin = new Button("Login", new ButtonListenerAdapter() {
            public void onClick(Button btnlogin, EventObject e) {  
            	
            	// login data list
            	logindata[0] = loginID.getText().trim();
            	logindata[1] = loginPassword.getText().trim();
            	
        		for(int i=0; i<logindata.length; i++) { 
        			if(logindata[i].equals("")) {
        				popup.setTitle("Please, input your membership data");
        				popup.show();
        				return;
        			}
        		}
        		KJMember loginmember = new KJMember();
        		loginmember.setID(logindata[0]);
        		loginmember.setPassword(logindata[1]);
        		
        		//서버통신
        		KJMembershipServiceAsync service = GWT.create(KJMembershipService.class);
        		service.LoginService(loginmember, new AsyncCallback<Boolean>() {

					public void onSuccess(Boolean result) {
						// TODO Auto-generated method stub
						popup.setTitle("Login is Complete!");
						popup.show();
						LoginService.this.hide();
						
					}
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						popup.setTitle("Sorry, please try again after few minutes.");
						popup.show();
						LoginService.this.hide();
					}
				});
			}
		});
        loginform.addButton(btnlogin);  
        
        // Cancel btn
        Button btncancel = new Button("Cancel", new ButtonListenerAdapter() {
        	public void onClick(Button btncancel, EventObject e) {
        		LoginService.this.hide();
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
        
        GridPanel ch = new GridPanel();
//        final CheckBox_preference ch = new CheckBox_preference();
//        eodsl.add(loginform);
        eodsl.add(ch);
        
        
        this.add(eodsl);
//        this.add(loginform); 
//        this.add(ch);
        
//        loginPanel.add(window);

//        RootPanel.get().add(loginPanel);  
    }  
}
