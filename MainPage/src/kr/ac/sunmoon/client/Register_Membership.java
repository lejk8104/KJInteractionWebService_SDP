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
import kr.ac.sunmoon.shared.Survey_data;

public class Register_Membership extends DialogBox {

	
	private static final TextBox String = null;           //?
	private ListBox[] listinputs;
	private TextBox[] txtinputs;
	private ListBox[] subinputs;
	private TextBox[] interestinput;

	
	public Register_Membership(){
		
		super(false, true);
		this.setText("Register_Membership");
		
		Grid grid = new Grid(16,5);
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
		grid.setWidget(15, 1, btngrid);
		
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
				String[] membershipData = new String[4];
				String [] listData = new String[4];
				String[] interestData = new String[3];
				String[] subinputdata = new String[3];
				String male = "Male";
				String female = "Female";				
				String korean = "Korean";
				String japanese = "Japanese";
				
				for(int i=0; i<membershipData.length; i++) {
					membershipData[i] = txtinputs[i].getText().trim();
					
					if(membershipData[i].equals("")) {
						Window.alert("Please, Input Your ALl Data");
						return;
					}
					if(membershipData[1].equals(membershipData[2])) {
						Window.alert("Please, check your password");
						return;
					}
				}
				
				for(int i=0; i<listData.length; i++) {
					int index =0;
					if (listinputs[0].getItemText(index) == "0") {
						listinputs[0].setItemText(0, male);
					}
					else if (listinputs[0].getItemText(index) == "1") {
						listinputs[0].setItemText(1, female);
					}
					else if(listinputs[2].getItemText(index) == "0") {
						listinputs[2].setItemText(0, korean);
					}
					else if(listinputs[2].getItemText(index) == "1") {
						listinputs[2].setItemText(0, japanese);
					}
					else;
					listinputs[i].getSelectedItemText().trim();
					if(listData[i].equals("")) {
						Window.alert("Please, Input Your Interest survey data");
						return;
						
//					index= index+1;
					}
				}
				for(int i=0; i<interestData.length; i++) {
					interestData[i] =  interestinput[i].getText().trim();
					
					if(interestData[i].equals("")) {
						Window.alert("Please, Input Your other survey datas");
						return;
					}
				}
				for(int i=0; i<subinputdata.length; i++) {
					subinputdata[i]=Integer.toString(subinputs[i].getSelectedIndex()-2).trim();
					if(subinputdata[i].equals("")) {
						Window.alert("Please, Input Your other survey datas");
						return;
					}
				}
				//kjmembership_dataset
				KJMember kjMember = new KJMember();
				kjMember.setID(membershipData[0]);
				kjMember.setPassword(membershipData[1]);
				kjMember.setCheckPassword(membershipData[2]);
				kjMember.setName(membershipData[3]);
//				kjMember.setGender(membershipData[4);
				kjMember.setGender(listData[0]);
				kjMember.setYear(listData[1]);
				kjMember.setDate(listData[2]);
				kjMember.setCountry(listData[3]);
				kjMember.setLocal(listData[4]);
				
				//survey data set
				Survey_data surveyData = new Survey_data();
				surveyData.setID(membershipData[0]);
				surveyData.setName(membershipData[3]);
				surveyData.setPreference(subinputdata[0]);
//				surveyData.setInterest(interestData);
				surveyData.setA(subinputdata[1]);
				surveyData.setB(subinputdata[2]);
				surveyData.setC(subinputdata[3]);
//				surveyData.setNumber(`);
				
				//Korean survey data Statistic
//				surveyData.setGyeonggi_people(gyeonggi_people);
//				surveyData.setSeoul_people(seoul_people);
//				surveyData.setGangwon_people(gangwon_people);
//				surveyData.setNorth_Chungcheong_people(north_Chungcheong_people);
//				surveyData.setSouth_Chungcheong_people(south_Chungcheong_people);
//				surveyData.setNorth_Gyeongsang_people(north_Gyeongsang_people);
//				surveyData.setSouth_Gyeongsang_people(south_Gyeongsang_people);
//				surveyData.setNorth_Jeolla_people(north_Jeolla_people);
//				surveyData.setSouth_Jeolla_peoples(south_Jeolla_peoples);
				
				////Japanese survey data Statistic
//				surveyData.setHokkaido_people(hokkaido_people);
//				surveyData.setTohoku_people(tohoku_people);
//				surveyData.setKanto_people(kanto_people);
//				surveyData.setChubu_people(chubu_people);
//				surveyData.setKinki_people(kinki_people);
//				surveyData.setChugoku_people(chugoku_people);
//				surveyData.setShikokupeople(shikokupeople);
				
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
		
		//이메일
		Label lblEmail = new Label("E-mail");
		grid.setWidget(4, 0, lblEmail);
		txtinputs[4] = new TextBox();
		grid.setWidget(4, 1, txtinputs[4]);
		
		//성별
		Label lblGender = new Label("Gender");
		grid.setWidget(5, 0, lblGender);
		listinputs[0] = new ListBox();
//		lboxGender.getSelectedItemText();
		listinputs[0].addItem("Male");
		listinputs[0].addItem("Female");
		grid.setWidget(5, 1, listinputs[0]);
	
		//생년
		Label lblYear = new Label("Year");
		grid.setWidget(6, 0, lblYear);
		listinputs[1] = new ListBox();
		listinputs[1].addItem("1970");
		listinputs[1].addItem("1971");
		listinputs[1].addItem("1972");
		listinputs[1].addItem("1973");
		listinputs[1].addItem("1974");
		listinputs[1].addItem("1975");
		listinputs[1].addItem("1976");
		listinputs[1].addItem("1977");
		listinputs[1].addItem("1978");
		listinputs[1].addItem("1979");
		
		listinputs[1].addItem("1980");
		listinputs[1].addItem("1981");
		listinputs[1].addItem("1982");
		listinputs[1].addItem("1983");
		listinputs[1].addItem("1984");
		listinputs[1].addItem("1985");
		listinputs[1].addItem("1986");
		listinputs[1].addItem("1987");
		listinputs[1].addItem("1988");
		listinputs[1].addItem("1989");
		
		listinputs[1].addItem("1990");
		listinputs[1].addItem("1991");
		listinputs[1].addItem("1992");
		listinputs[1].addItem("1993");
		listinputs[1].addItem("1994");
		listinputs[1].addItem("1995");
		listinputs[1].addItem("1996");
		listinputs[1].addItem("1997");
		listinputs[1].addItem("1998");
		listinputs[1].addItem("1999");
		
		listinputs[1].addItem("2000");
		listinputs[1].addItem("2001");
		listinputs[1].addItem("2002");
		listinputs[1].addItem("2003");
		listinputs[1].addItem("2004");
		listinputs[1].addItem("2005");
		listinputs[1].addItem("2006");
		listinputs[1].addItem("2007");
		listinputs[1].addItem("2008");
		listinputs[1].addItem("2009");
		
		listinputs[1].addItem("2010");
		listinputs[1].addItem("2011");
		listinputs[1].addItem("2012");
		listinputs[1].addItem("2013");
		listinputs[1].addItem("2014");
		listinputs[1].addItem("2015");
		listinputs[1].addItem("2016");
		listinputs[1].addItem("2017");
		listinputs[1].addItem("2018");
		listinputs[1].addItem("2019");
		
		grid.setWidget(6, 1, listinputs[1]);
		
//		//월일/ 달력표시
//		Label lblDate = new Label("Date");
//		grid.setWidget(5, 2, lblDate);
//		
////		txtinputs[6];
//		grid.setWidget(5, 3, txtinputs[6]);
//		
		// 나라선택
		Label lblCountry = new Label("Country");
		grid.setWidget(7, 0, lblCountry);
		listinputs[2] = new ListBox();
		listinputs[2].addItem("Korean");
		listinputs[2].addItem("Japanese");
		grid.setWidget(7, 1, listinputs[2]);		
//		
		//지역표시
		Label lblLocal = new Label("Local");
		grid.setWidget(8, 0, lblLocal);
		listinputs[3] = new ListBox();
		
		listinputs[3].addItem("Gyeonggi-do");
		listinputs[3].addItem("Seoul");
		listinputs[3].addItem("Gangwon-do");
		listinputs[3].addItem("Chungcheongbuk-do");
		listinputs[3].addItem("Chungcheongnam-do");
		listinputs[3].addItem("Gyeongsangbuk-do");
		listinputs[3].addItem("Gyeongsangnam-do");
		listinputs[3].addItem("Jeollabuk-do");
		listinputs[3].addItem("Jeollanam-do ");
		listinputs[3].addItem("Hokkaido");
		listinputs[3].addItem("Tohoku");
		listinputs[3].addItem("Kanto");
		listinputs[3].addItem("Chubu");
		listinputs[3].addItem("Kinki");
		listinputs[3].addItem("Chugoku");
		listinputs[3].addItem("Shikoku");
//		txtinputs[8] = new TextBox();  //?
		grid.setWidget(8, 1, listinputs[3]);	
		}
	
	private void addSurveyList(Grid grid) {
		
		interestinput = new TextBox[4];
		subinputs = new ListBox[3];
		
		Label title = new Label("Survey");
		grid.setWidget(9, 0, title);
		
		//관심사
		Label lblInterests = new Label("Plase Input your interests.");
		grid.setWidget(11, 0, lblInterests);
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

		grid.setWidget(11, 1, interestgrid);
		
		//지역별 선호도
		Label lblPreference = new Label("Preference");
		grid.setWidget(10, 0, lblPreference);
		subinputs[0] = new ListBox();
		
		subinputs[0].addItem("Very Bad");
		subinputs[0].addItem("그렇지 않다");
		subinputs[0].addItem("보통이다");
		subinputs[0].addItem("그렇다");
		subinputs[0].addItem("매우 그렇다");
		grid.setWidget(10, 1, subinputs[0]);
	
		//A
		Label A = new Label("A");
		grid.setWidget(12, 0, A);
		subinputs[1] = new ListBox();
		grid.setWidget(12, 1, subinputs[1]);
	
		//B
		Label B = new Label("B");
		grid.setWidget(13, 0, B);
		subinputs[2] = new ListBox();
		grid.setWidget(13, 1, subinputs[2]);
		
		//C
		Label C = new Label("C");
		grid.setWidget(14, 0, C);
		subinputs[3] = new ListBox();
		grid.setWidget(14, 1, subinputs[3]);
	}
}
