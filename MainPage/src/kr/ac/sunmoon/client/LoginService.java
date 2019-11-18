package kr.ac.sunmoon.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.sun.java.swing.plaf.windows.resources.windows;

import kr.ac.sunmoon.shared.KJMember;

public class LoginService extends DialogBox{

private final String Null = null;
private TextBox[] logininputs;
	
	public LoginService()  {
	
		super(false, true);
		this.setText("Login Page");
		
		Grid grid = new Grid(5,2);
		this.setWidget(grid);
		
		addinputList(grid);
		addButton(grid);
		Button btnlogin = new Button();
		btnlogin.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String[] logindatas = new String[1];
				
				for (int i =0; i<logindatas.length; i++) {
					
					logindatas[i] = logininputs[i].getText().trim();
					if(logininputs[i].equals("")) {
			
						Window.alert("Plase input your Login Data");
						return;
					}
				}
				KJMember crKJmember = new KJMember();
				crKJmember.setID(logindatas[0]);
				crKJmember.setPassword(logindatas[1]);
				crKJmember.setCheckPassword(Null);
				crKJmember.setName(Null);
				crKJmember.setGender(Null);
				crKJmember.setYear(Null);
				crKJmember.setDate(Null);
				crKJmember.setCountry(Null);
				crKJmember.setLocal(Null);
				
				//서버 연결
				KJMembershipServiceAsync logservice = GWT.create(KJMembershipService.class);
				logservice.LoginService(crKJmember, new AsyncCallback<Boolean>() {

					public void onSuccess(Boolean result) {
						// TODO Auto-generated method stub
						Window.alert("Login is Complete!");
						LoginService.this.hide();
						
					}
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("Sorry, please try again after few minutes.");
						LoginService.this.hide();
					}
				});
			}
		});
		btnlogin.setText("Login");
		grid.setWidget(4, 0, btnlogin);
		
	}
		public void addButton(Grid grid) {

			//아이디 찾기 연결
			Button findIDBtn = new Button();
			findIDBtn.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					FindID dialog_id = new FindID();
					dialog_id.setPopupPosition(Window.getClientWidth()/2-150,100);
					dialog_id.show();
				}
			});
			findIDBtn.setText("Find ID");
			grid.setWidget(3, 0, findIDBtn);
			
			//비밀번호 찾기 연결
			Button findPasswordBtn = new Button();
			findPasswordBtn.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					FindPassword dialog_password = new FindPassword();
					dialog_password.setPopupPosition(Window.getClientWidth()/2-150, 100);
					dialog_password.show();
				}
			});
			findPasswordBtn.setText("Find Password");
			grid.setWidget(3, 1, findPasswordBtn);
			
			//회원가입 페이지 연결
			Button registerBtn = new Button();
			registerBtn.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					Register_Membership dialog_RE = new Register_Membership();
					dialog_RE.setPopupPosition(Window.getClientWidth()/2-150,100);
					dialog_RE.show();
				}
			});
			registerBtn .setText("Register our Membership");
			grid.setWidget(4, 1, registerBtn);
	}
	private void addinputList(Grid grid) {
		
		logininputs = new TextBox[1];
		
		//아이디 입력칸
		Label lbllogID = new Label("ID");
		grid.setWidget(0, 0, lbllogID);
		logininputs[0] = new TextBox();
		grid.setWidget(0, 1, logininputs[0]);
		
		//비밀번호 입력란
		Label lbllogPassword = new Label("Password");
		grid.setWidget(1, 0, lbllogPassword);
		logininputs[1] = new TextBox();
		grid.setWidget(1, 1, logininputs[1]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
