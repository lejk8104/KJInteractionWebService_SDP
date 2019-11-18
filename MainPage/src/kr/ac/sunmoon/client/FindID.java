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

import kr.ac.sunmoon.shared.KJMember;

public class FindID extends DialogBox{

private TextBox[] membershipdata;	

	public FindID() {
		
		super(false,true);
		this.setText("Find ID Page");
		
		Grid grid = new Grid(3,2);
		this.setWidget(grid);
		
		addinputList(grid);
		clickHandler(grid);	
		}
	private void addinputList(Grid grid) {
		membershipdata = new TextBox[1];
		
		//ID
		Label lblfindID = new Label("ID");
		grid.setWidget(0, 0, lblfindID);
		membershipdata[0] = new TextBox();
		grid.setWidget(0, 1, membershipdata[0]);
		//Password
		Label lblfindName = new Label("Name");
		grid.setWidget(1, 0, lblfindName);
		membershipdata[0] = new TextBox();
		grid.setWidget(1, 1, membershipdata[0]);
	}
	private void clickHandler(Grid grid) {
	
		Grid btngrid = new Grid(1,2);
		grid.setWidget(2, 1, btngrid);
		
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
				findPassword.findKJmember(ID, Name, new AsyncCallback<KJMember>() { //? 서버쪽 좀더 생각해보자

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("Sorry, please try again after few minutes.");	
					}
					@Override
					public void onSuccess(KJMember User) {
						// TODO Auto-generated method stub
						String id = User.getID();
						Window.alert(id);
					}
				});
			}
		});
		btnok.setText("Find ID");
		btngrid.setWidget(0, 0, btnok);
//		
		//Cancel
		Button btnCancel = new Button();
		btnCancel.setText("Cancel");
		btnCancel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				// TODO Auto-generated method stub
				FindID.this.hide();
			}
		});
		btngrid.setWidget(0, 1, btnCancel);			
	}		
}
