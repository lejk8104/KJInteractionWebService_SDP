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
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

import kr.ac.sunmoon.shared.KJMember;

public class Register_Membership extends DialogBox {

	
	private static final TextBox String = null;           //?
	private ListBox[] listinputs;
	private TextBox[] txtinputs;
	private TextBox[] subinputs;
	private TextBox[] interestinput;

	
	public Register_Membership(){
		
		super(false, true);
		this.setText("Register_Membership");
		
		Grid grid = new Grid(15,5);
		this.setWidget(grid);
	
		Grid textgrid = new Grid(1,2);
		grid.setWidget(0, 1, textgrid);
		
		addInputList(grid,textgrid);
		addSurveyList(grid);
		addButtons(grid,textgrid);
	}
		
	private void addButtons(Grid grid, Grid textgrid) {
		
//		아이디 중복확인
		Grid btngrid = new Grid(1,2);
		grid.setWidget(14, 1, btngrid);
		
		Button btnIDCheck = new Button();
		grid.setWidget(0, 4, btnIDCheck);
		btnIDCheck.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String[] checks = new String[1];
				
				if(txtinputs[0].getText().trim().equals("")) {
					
					Window.alert("Please Input your ID");
					return;
				}
				KJMember kjMember = new KJMember();
				kjMember.setID(txtinputs[0].getText().trim());
				
				KJMembershipServiceAsync checkservice = GWT.create(KJMembershipService.class);
				checkservice.checkID(kjMember, new AsyncCallback<Boolean>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("this ID already exists. ");
//						Register_Membership.this.hide();
					}
					@Override
					public void onSuccess(Boolean result) {
						// TODO Auto-generated method stub
						Window.alert("This ID is available");
					}
				});
			}
		});
		btnIDCheck.setText("CheckID");
		textgrid.setWidget(0, 1, btnIDCheck);
		
//		OK 버튼
		Button btnOk = new Button();
		btnOk.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				String[] membershipDatas = new String[3];
				String[] listdata = new String[4];
				String[] interestinput = new String[3];
				String[] subinputs = new String[3];
				
				for(int i=0; i<membershipDatas.length; i++) {
					membershipDatas[i] = txtinputs[i].getText().trim();
					
					if(membershipDatas[i].equals("")) {
						Window.alert("Please, Input Your ALl Data");
						return;
					}
					if(membershipDatas[1].equals(membershipDatas[2])) {
						Window.alert("Please, check your password");
						return;
					}
				}
				for(int i=0; i<interestinput.length; i++) {
					membershipDatas[i] = txtinputs[i].getText().trim();
					
					if(membershipDatas[i].equals("")) {
						Window.alert("Please, Input Your Interest survey data");
						return;
					}
				}
				for(int i=0; i<subinputs.length; i++) {
					subinputs[i] = txtinputs[i].getText().trim();
					
					if(subinputs[i].equals("")) {
						Window.alert("Please, Input Your other survey datas");
						return;
					}
				}
				KJMember kjMember = new KJMember();
				kjMember.setID(membershipDatas[0]);
				kjMember.setPassword(membershipDatas[1]);
				kjMember.setCheckPassword(membershipDatas[2]);
				kjMember.setName(membershipDatas[3]);
				kjMember.setGender(membershipDatas[4]);
				kjMember.setYear(membershipDatas[5]);
				kjMember.setDate(membershipDatas[6]);
				kjMember.setCountry(membershipDatas[7]);
				kjMember.setLocal(membershipDatas[8]);
				
				//서버통신
				KJMembershipServiceAsync service = GWT.create(KJMembershipService.class);
				service.Register_Membership(kjMember, new AsyncCallback<Void>() {
					
					@Override
					public void onSuccess(Void result) {
						// TODO Auto-generated method stub
						Window.alert("Welcome to the membership");
						Register_Membership.this.hide();
						
					}
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						Window.alert("Sorry, Please try agian after few minutes");
						Register_Membership.this.hide();
					}
				});
			}
		});
		btnOk.setText("Register");
		btngrid.setWidget(0,0, btnOk);
		
		//취소
		Button btnCancel = new Button();
		btnCancel.setText("Cancel");
		btnCancel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent arg0) {
				// TODO Auto-generated method stub
				Register_Membership.this.hide();
			}
		});
		btngrid.setWidget(0, 1, btnCancel);
	}
	
	private void addInputList(Grid grid, Grid textgrid) {
		
		txtinputs = new TextBox[3];
		listinputs = new ListBox[4];
		
		//아이디
		Label lblID = new Label("ID");
		grid.setWidget(0, 0, lblID);
		txtinputs[0] = new TextBox();
		textgrid.setWidget(0, 0, txtinputs[0]);
		
		//패스워드
		Label lblPassword = new Label("Password");
		grid.setWidget(1, 0, lblPassword);
		txtinputs[1] = new TextBox();
		grid.setWidget(1, 1, txtinputs[1]);
		
		//패스워드확인
		Label lblCheckPassword = new Label("Check Password");
		grid.setWidget(2, 0, lblCheckPassword);
		txtinputs[2] = new TextBox();
		grid.setWidget(2, 1, txtinputs[2]);
		
		//이름
		Label lblName = new Label("Name");
		grid.setWidget(3, 0, lblName);
		txtinputs[3] = new TextBox();
		grid.setWidget(3, 1, txtinputs[3]);
		
		//성별
		Label lblGender = new Label("Gender");
		grid.setWidget(4, 0, lblGender);
		listinputs[0] = new ListBox();
//		lboxGender.getSelectedItemText();
		listinputs[0].addItem("Male");
		listinputs[0].addItem("Female");
		grid.setWidget(4, 1, listinputs[0]);
	
		//생년
		Label lblYear = new Label("Year");
		grid.setWidget(5, 0, lblYear);
		ListBox lboxYear = new ListBox();
		lboxYear.addItem("1970");
		lboxYear.addItem("1971");
		lboxYear.addItem("1972");
		lboxYear.addItem("1973");
		lboxYear.addItem("1974");
		lboxYear.addItem("1975");
		lboxYear.addItem("1976");
		lboxYear.addItem("1977");
		lboxYear.addItem("1978");
		lboxYear.addItem("1979");
		
		lboxYear.addItem("1980");
		lboxYear.addItem("1981");
		lboxYear.addItem("1982");
		lboxYear.addItem("1983");
		lboxYear.addItem("1984");
		lboxYear.addItem("1985");
		lboxYear.addItem("1986");
		lboxYear.addItem("1987");
		lboxYear.addItem("1988");
		lboxYear.addItem("1989");
		
		lboxYear.addItem("1990");
		lboxYear.addItem("1991");
		lboxYear.addItem("1992");
		lboxYear.addItem("1993");
		lboxYear.addItem("1994");
		lboxYear.addItem("1995");
		lboxYear.addItem("1996");
		lboxYear.addItem("1997");
		lboxYear.addItem("1998");
		lboxYear.addItem("1999");
		
		lboxYear.addItem("2000");
		lboxYear.addItem("2001");
		lboxYear.addItem("2002");
		lboxYear.addItem("2003");
		lboxYear.addItem("2004");
		lboxYear.addItem("2005");
		lboxYear.addItem("2006");
		lboxYear.addItem("2007");
		lboxYear.addItem("2008");
		lboxYear.addItem("2009");
		
		lboxYear.addItem("2010");
		lboxYear.addItem("2011");
		lboxYear.addItem("2012");
		lboxYear.addItem("2013");
		lboxYear.addItem("2014");
		lboxYear.addItem("2015");
		lboxYear.addItem("2016");
		lboxYear.addItem("2017");
		lboxYear.addItem("2018");
		lboxYear.addItem("2019");
		
		grid.setWidget(5, 1, lboxYear);
		
//		//월일/ 달력표시
//		Label lblDate = new Label("Date");
//		grid.setWidget(5, 2, lblDate);
//		
////		txtinputs[6];
//		grid.setWidget(5, 3, txtinputs[6]);
//		
		// 나라선택
		Label lblCountry = new Label("Country");
		grid.setWidget(6, 0, lblCountry);
		ListBox lboxCountry = new ListBox();
		lboxCountry.addItem("Korean");
		lboxCountry.addItem("Japanese");
		grid.setWidget(6, 1, lboxCountry);		
//		
		//지역표시
		Label lblLocal = new Label("Local");
		grid.setWidget(7, 0, lblLocal);
		ListBox lboxLocal = new ListBox();
		
		lboxLocal.addItem("Seoul");
		lboxLocal.addItem("경기도");
		lboxLocal.addItem("강원도");
		lboxLocal.addItem("충청북도");
		lboxLocal.addItem("충첨남도");
		lboxLocal.addItem("경상북도");
		lboxLocal.addItem("경상남도");
		lboxLocal.addItem("전라북도");
		lboxLocal.addItem("전라남도");
		lboxLocal.addItem("훗카이도");
		lboxLocal.addItem("도호쿠");
		lboxLocal.addItem("간토");
		lboxLocal.addItem("주부");
		lboxLocal.addItem("긴키");
		lboxLocal.addItem("주고쿠");
		lboxLocal.addItem("시코쿠");
//		txtinputs[8] = new TextBox();  //?
		grid.setWidget(7, 1, lboxLocal);	
		}
	
	private void addSurveyList(Grid grid) {
		
		interestinput = new TextBox[4];
		subinputs = new TextBox[3];
		
		Label title = new Label("Survey");
		grid.setWidget(8, 0, title);
		
		//지역별 선호도
		Label lblPreference = new Label("Preference");
		grid.setWidget(9, 0, lblPreference);
		ListBox lboxpreference = new ListBox();
		
		lboxpreference.addItem("Very Bad");
		lboxpreference.addItem("그렇지 않다");
		lboxpreference.addItem("보통이다");
		lboxpreference.addItem("그렇다");
		lboxpreference.addItem("매우 그렇다");
		grid.setWidget(9, 1, lboxpreference);
		
		//관심사
		Label lblInterests = new Label("Plase Input your interests.");
		grid.setWidget(10, 0, lblInterests);
		Grid interestgrid = new Grid(2,2);
		
		interestinput[0] = new TextBox();
		interestinput[1] = new TextBox();
		interestinput[2] = new TextBox();
		interestinput[3] = new TextBox();
//		interestinput[4] = new TextBox();
		
		interestgrid.setWidget(0, 0, interestinput[0]);
		interestgrid.setWidget(0, 1, interestinput[1]);
//		interestgrid.setWidget(0, 2, interestinput[2]);
		interestgrid.setWidget(1, 0, interestinput[2]);
		interestgrid.setWidget(1, 1, interestinput[3]);

		grid.setWidget(10, 1, interestgrid);
		
		//A
		Label A = new Label("A");
		grid.setWidget(11, 0, A);
		subinputs[1] = new TextBox();
		grid.setWidget(11, 1, subinputs[1]);
	
		//B
		Label B = new Label("B");
		grid.setWidget(12, 0, B);
		subinputs[2] = new TextBox();
		grid.setWidget(12, 1, subinputs[2]);
		
		//C
		Label C = new Label("C");
		grid.setWidget(13, 0, C);
		subinputs[3] = new TextBox();
		grid.setWidget(13, 1, subinputs[3]);
	}
}
