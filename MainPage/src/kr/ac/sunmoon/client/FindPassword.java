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

public class FindPassword extends DialogBox {

private TextBox[] membershipdata;

		public FindPassword() {
			
			super(false,true);
			this.setText("Find Password Page");
			
			Grid grid = new Grid(3,2);
			this.setWidget(grid);
			
			Grid btngrid = new Grid(1,2);
			grid.setWidget(0, 1, btngrid);
			
			addinputList(grid,btngrid);
			clickHandler(grid,btngrid);			
		}
		
		private void addinputList(Grid grid, Grid btnGrid) {			
			membershipdata = new TextBox[1];			
			//ID
			Label lblfindID = new Label("ID");
			grid.setWidget(0, 0, lblfindID);
			membershipdata[0] = new TextBox();
			btnGrid.setWidget(0, 0, membershipdata[0]);
			//Password
			Label lblfindName = new Label("Name");
			grid.setWidget(1, 0, lblfindName);
			membershipdata[0] = new TextBox();
			grid.setWidget(1, 1, membershipdata[0]);
		}
		
		private void clickHandler(Grid grid, Grid btnGrid) {
			
			//비밀번호 찾기 실행
			Button btnok = new Button();
			btnok.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					String[] membershipdata = new String[1];
					for (int i =0; i<membershipdata.length; i++) {
						if(membershipdata[i].equals("")){
							Window.alert("Please input your all data");
							return;
						}
					}
					String ID = membershipdata[0];
					String Name = membershipdata[1];
					//서버연결
					KJMembershipServiceAsync findPassword = GWT.create(KJMembershipService.class);
					findPassword.findKJmember(ID, Name, new AsyncCallback<KJMember>() {

						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							Window.alert("Sorry, please try again after few minutes.");	
						}
						@Override
						public void onSuccess(KJMember User) {
							// TODO Auto-generated method stub
							String password = User.getPassword();
							Window.alert(password);
						}
					});
				}
			});
			//아이디 찾기연결
			btnok.setText("Find");
			grid.setWidget(2, 1, btnok);

			Button findID = new Button();
			findID.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					FindID dialog_id = new FindID();
					dialog_id.setPopupPosition(Window.getClientWidth()/2-150,100);
					dialog_id.show();
				}
			});			
			findID.setText("Find iD");
			btnGrid.setWidget(0, 1, findID);
			
			//Cancel
			Button btnCancel = new Button();
			btnCancel.setText("Cancel");
			btnCancel.addClickHandler(new ClickHandler() {
				@Override
				public void onClick(ClickEvent arg0) {
					// TODO Auto-generated method stub
					FindPassword.this.hide();
				}
			});
			grid.setWidget(2, 0, btnCancel);			
		}		
}