package kr.ac.sunmoon.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.DateField;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.VType;
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter;
import com.gwtext.client.widgets.layout.FormLayout;

import kr.ac.sunmoon.shared.KJMember;
  
  
public class Register_Membership extends com.gwtext.client.widgets.Window{  
  
	private ListBox[] listinputs;
	private TextBox[] txtinputs;
	private ListBox[] subinputs;
	private TextBox[] interestinput;
	
    public Register_Membership() {  
    	
    	super();
        Panel panel = new Panel();  
        panel.setBorder(false);  
        panel.setPaddings(15);
  
        FormPanel formPanel = new FormPanel();  
        formPanel.setFrame(true); 
        formPanel.setTitle("KJ Membership Page");
        formPanel.setLabelWidth(65);  
        formPanel.setBorder(false);  
        formPanel.setWidth(320);  
    }
//        
//        //TabPanel 선언
//        final TabPanel tabPanel = new TabPanel();  
//        tabPanel.setActiveTab(0);  
//  
//        Panel firstTab = new Panel();  
//        firstTab.setTitle("KJ Membership");  
//        firstTab.setLayout(new FormLayout());  
//        firstTab.setAutoHeight(true);  
//        firstTab.setPaddings(10);  
//  
//        //list store 선언
//        final Store gender = new SimpleStore(new String[] {"genderData","gender"}, Getgender());
//        gender.load();
//        final Store countriesStore = new SimpleStore(new String[]{"country", "countryData"}, countries);  
//        countriesStore.load();  
//        final Store citiesStore = new SimpleStore(new String[]{"cityData", "country", "cityName"}, cities);  
//        citiesStore.load(); 
//        
//        // ID
//        TextField txtID = new TextField("ID", "id", 200);  
//        txtID.setAllowBlank(false);  
////        txtID.setValue("id"); 
//        firstTab.add(txtID);  
//  
//        //Password
//        TextField txtPassword = new TextField("Password", "passwordData", 200);  
////        txtPassword.setValue("password");  
//        firstTab.add(txtPassword);  
//  
//        //CheckPassword
//        TextField txtCheckPassword = new TextField("Check Password", "checkpasswordData", 200);  
////        txtCheckPassword.setValue("checkpassword");
//        firstTab.add(txtCheckPassword);  
//
//        //Name
//        TextField txtName = new TextField("Name", "nameData", 200);
//        txtName.setAllowBlank(false); 
//        txtName.setValue("name"); 
//        firstTab.add(txtName);  
//  
//        //E-Mail
//        TextField txtemail = new TextField("Email", "emailData", 200);  
//        txtemail.setVtype(VType.EMAIL);  
//        firstTab.add(txtemail);  
//  
//        //Gender list
//        ComboBox listgender = new ComboBox();
//        listgender.setAllowBlank(false);
//        listgender.setMinChars(1);
//        listgender.setFieldLabel("Gender");
//        listgender.setStore(gender);
//        listgender.setDisplayField("genderData");
//        listgender.setEmptyText("Select Gender"); 
//        listgender.setTriggerAction(ComboBox.ALL); //? 모르겠다
//        listgender.setTypeAhead(true);  // 이를 채우고 자동 선택한다
//        listgender.setSelectOnFocus(true); //데이터값 수신할 떄 자동채움
//        listgender.setWidth(200);  
//        listgender.setResizable(true); //?
//        firstTab.add(listgender);
//        
//        //Birth
//        DateField dataBirth = new DateField("Date of birth", "BirthData", 200);  
//        dataBirth.setAllowBlank(false);
//        firstTab.add(dataBirth);
//        
//        // country
//        final ComboBox listcountry = new ComboBox();  
//        listcountry.setFieldLabel("Select Country");  
//        listcountry.setStore(countriesStore);  
//        listcountry.setDisplayField("countryData");  
//        listcountry.setMode(ComboBox.LOCAL);  
//    	listcountry.setTriggerAction(ComboBox.ALL);  
//    	listcountry.setForceSelection(true);  
////    	listcountry.setValueField("country");  
//    	listcountry.setReadOnly(true);  
//
//    	// local
//    	final ComboBox listlocal = new ComboBox();  
//    	listlocal.setFieldLabel("Select City");  
//    	listlocal.setStore(citiesStore);  
//    	listlocal.setDisplayField("cityName");  
////    	listlocal.setValueField("local");  
//    	listlocal.setMode(ComboBox.LOCAL);  
//	    listlocal.setTriggerAction(ComboBox.ALL);  
//	    listlocal.setLinked(true);  
//	    listlocal.setForceSelection(true);  
//	    listlocal.setReadOnly(true);  
//
//	    //동작과정
//	    listcountry.addListener(new ComboBoxListenerAdapter() {  
//        public void onSelect(ComboBox comboBox, Record record, int index) {  
//            listlocal.setValue("");  
//            citiesStore.filter("country", comboBox.getValue());  
//        	}  
//	    });  
//	    firstTab.add(listcountry);
//	    firstTab.add(listlocal);
//  
//        tabPanel.add(firstTab);  
//    }
//        //list store 선언
//        final Store preference = new SimpleStore(new String[] {"Text","Preference","data"}, Getpreference());
//        preference.load();
//        final Store a = new SimpleStore(new String[] {"Text","A","data"}, GetA());
//        a.load();
//        final Store b = new SimpleStore(new String[] {"Text","B","data"}, GetB());
//        b.load();
//        final Store c = new SimpleStore(new String[] {"Text","C","data"}, GetC());
//        c.load();
//        
//        // Survey
//        Panel secondTab = new Panel();  
//        secondTab.setTitle("Survey");  
//        secondTab.setLayout(new FormLayout());  
//        secondTab.setAutoHeight(true);  
//        secondTab.setPaddings(10);  
// 
//        // preference
//        ComboBox listpreference = new ComboBox();
//        listpreference.setAllowBlank(false);
//        listpreference.setMinChars(1);
//        listpreference.setFieldLabel("Preference");
//        listpreference.setStore(c);
//        listpreference.setDisplayField("Text");
//        listpreference.setEmptyText("Select Preference"); 
//        listpreference.setTriggerAction(ComboBox.ALL); //? 모르겠다
//        listpreference.setTypeAhead(true);  // 이를 채우고 자동 선택한다
//        listpreference.setSelectOnFocus(true); //데이터값 수신할 떄 자동채움
//        listpreference.setWidth(200);  
//        listpreference.setResizable(true); //?
//        secondTab.add(listpreference);
//
//        //Interest
//        TextField txtinterests = new TextField("Interests", "interests", 200);  
//        txtinterests.setAllowBlank(false);  
////        txtinterests.setValue("interests"); 
//        secondTab.add(txtinterests);
//        
//        //A
//        ComboBox A = new ComboBox();
//        A.setAllowBlank(false);
//        A.setMinChars(1);
//        A.setFieldLabel("Preference");
//        A.setStore(a);
//        A.setDisplayField("Text");
//        A.setEmptyText("Select A"); 
//        A.setTriggerAction(ComboBox.ALL); //? 모르겠다
//        A.setTypeAhead(true);  // 이를 채우고 자동 선택한다
//        A.setSelectOnFocus(true); //데이터값 수신할 떄 자동채움
//        A.setWidth(200);  
//        A.setResizable(true); //?
//        secondTab.add(A);
//        
//        //B
//        ComboBox B = new ComboBox();
//        B.setAllowBlank(false);
//        B.setMinChars(1);
//        B.setFieldLabel("Preference");
//        B.setStore(b);
//        B.setDisplayField("Text");
//        B.setEmptyText("Select B"); 
//        B.setTriggerAction(ComboBox.ALL); //? 모르겠다
//        B.setTypeAhead(true);  // 이를 채우고 자동 선택한다
//        B.setSelectOnFocus(true); //데이터값 수신할 떄 자동채움
//        B.setWidth(200);  
//        B.setResizable(true); //?
//        secondTab.add(B);
//        
//        //C
//        ComboBox C = new ComboBox();
//        C.setAllowBlank(false);
//        C.setMinChars(1);
//        C.setFieldLabel("Preference");
//        C.setStore(c);
//        C.setDisplayField("Text");
//        C.setEmptyText("Select C"); 
//        C.setTriggerAction(ComboBox.ALL); //? 모르겠다
//        C.setTypeAhead(true);  // 이를 채우고 자동 선택한다
//        C.setSelectOnFocus(true); //데이터값 수신할 떄 자동채움
//        C.setWidth(200);  
//        C.setResizable(true); //?
//        secondTab.add(C);
//
//        tabPanel.add(secondTab);
//        
//        Button btnok = new Button("OK");  
//        Button btncancel = new Button("Cancel");  
//  
//        formPanel.addButton(btnok);  
//        formPanel.addButton(btncancel);  
//  
//        formPanel.add(tabPanel);  
//        panel.add(formPanel);  
//  
//        RootPanel.get().add(panel);  
//    }  
    
    // list object
    private Object[][] Getgender()  {
    	return new Object[][] {
    		new Object[] {"Male","gender"},
    		new Object[] {"Female","gender"}
    	};
    }
    
    private Object[][] countries = new Object[][]{  
        new Object[]{"K", "Korean"},  
        new Object[]{"J", "Japanese"},  
    };
    
    private Object[][] cities = new Object[][]{  
        new Object[]{new Integer(001), "K", "Gyeonggi-do"},  
        new Object[]{new Integer(002), "K", "Seoul"},  
        new Object[]{new Integer(003), "K", "Gangwon-do"},  
        new Object[]{new Integer(004), "K", "Chungcheongbuk-do"},  
        new Object[]{new Integer(005), "K", "Chungcheongnam-do"},  
        new Object[]{new Integer(006), "K", "Gyeongsangbuk-do"},  
        new Object[]{new Integer(007), "K", "Gyeongsangnam-do"},  
//        new Object[]{new Integer(008), "K", "Jeollabuk-do"},  
//        new Object[]{new Integer(009), "K", "Jeollanam-do "},  
        new Object[]{new Integer(0010), "J", "Hokkaido"}, 
        new Object[]{new Integer(0011), "J", "Tohoku"},
        new Object[]{new Integer(0012), "J", "Chubu"},
        new Object[]{new Integer(0013), "J", "Kinki"},
        new Object[]{new Integer(0014), "J", "Chugoku"},
        new Object[]{new Integer(0015), "J", "Shikoku"},
        new Object[]{new Integer(0016), "J", "Kyushu"}
    };
    
    private Object[][] Getpreference()  {
    	return new Object[][] {
    		new Object[] {"Very Bad","preference", new Integer(-2)},
    		new Object[] {"Bad","preference", new Integer(-1)},
    		new Object[] {"So So","preference", new Integer(0)},
    		new Object[] {"Good","preference", new Integer(1)},
    		new Object[] {"Very Good","preference", new Integer(2)},
    	};
    }    
    
    private Object[][] GetA()  {
    	return new Object[][] {
    		new Object[] {"Very Bad","a", new Integer(-2)},
    		new Object[] {"Bad","a", new Integer(-1)},
    		new Object[] {"So So","a", new Integer(0)},
    		new Object[] {"Good","a", new Integer(1)},
    		new Object[] {"Very Good","a", new Integer(2)},
    	};
    }
    
    private Object[][] GetB()  {
    	return new Object[][] {
    		new Object[] {"Very Bad","b", new Integer(-2)},
    		new Object[] {"Bad","b", new Integer(-1)},
    		new Object[] {"So So","b", new Integer(0)},
    		new Object[] {"Good","b", new Integer(1)},
    		new Object[] {"Very Good","b", new Integer(2)},
    	};
    }
    
    private Object[][] GetC()  {
    	return new Object[][] {
    		new Object[] {"Very Bad","c", new Integer(-2)},
    		new Object[] {"Bad","c", new Integer(-1)},
    		new Object[] {"So So","c", new Integer(0)},
    		new Object[] {"Good","c", new Integer(1)},
    		new Object[] {"Very Good","c", new Integer(2)},
    	};
    }
    
//private void addButtons(Button btnok, Button btncancel) {
//		
////		아이디 중복확인
//		Button btnIDCheck = new Button();
//		btnIDCheck.addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
//				String[] checks = new String[1];
//				
//				if(txtinputs[0].getText().trim().equals("")) {
//					
//					Window.alert("Please Input your ID");
//					return;
//				}
//				KJMember kjMember = new KJMember();
//				kjMember.setID(txtinputs[0].getText().trim());
//				
//				KJMembershipServiceAsync checkservice = GWT.create(KJMembershipService.class);
//				checkservice.checkID(kjMember, new AsyncCallback<Boolean>() {
//
//					@Override
//					public void onFailure(Throwable caught) {
//						// TODO Auto-generated method stub
//						Window.alert("this ID already exists. ");
////						Register_Membership.this.hide();
//					}
//					@Override
//					public void onSuccess(Boolean result) {
//						// TODO Auto-generated method stub
//						Window.alert("This ID is available");
//					}
//				});
//			}
//		});
//		btnIDCheck.setText("CheckID");
//		
////		OK 버튼
//		Button btnOk = new Button();
//		btnOk.addAttachHandler(handler)
//			
//			@Override
//			public void onAttachOrDetach(AttachEvent event) {
//				// TODO Auto-generated method stub
//				
//			}
//		})
//		btnOk.addClickHandler(new ClickHandler() {
//			
//			@Override
//			public void onClick(ClickEvent event) {
//				// TODO Auto-generated method stub
//				String[] membershipData = new String[4];
//				String [] listData = new String[4];
//				String[] interestData = new String[3];
//				String[] subinputdata = new String[3];
//
//				
//				for(int i=0; i<membershipData.length; i++) {
//					membershipData[i] = txtinputs[i].getText().trim();
//					
//					if(membershipData[i].equals("")) {
//						Window.alert("Please, Input Your ALl Data");
//						return;
//					}
//					if(membershipData[1].equals(membershipData[2])) {
//						Window.alert("Please, check your password");
//						return;
//					}
//				}
//				
//				for(int i=0; i<listData.length; i++) {
//					int index =0;
//					if (listinputs[0].getItemText(index) == "0") {
//						listinputs[0].setItemText(0, male);
//					}
//					else if (listinputs[0].getItemText(index) == "1") {
//						listinputs[0].setItemText(1, female);
//					}
//					else if(listinputs[2].getItemText(index) == "0") {
//						listinputs[2].setItemText(0, korean);
//					}
//					else if(listinputs[2].getItemText(index) == "1") {
//						listinputs[2].setItemText(0, japanese);
//					}
//					else;
//					listinputs[i].getSelectedItemText().trim();
//					if(listData[i].equals("")) {
//						Window.alert("Please, Input Your Interest survey data");
//						return;
//						
////					index= index+1;
//					}
//				}
//				for(int i=0; i<interestData.length; i++) {
//					interestData[i] =  interestinput[i].getText().trim();
//					
//					if(interestData[i].equals("")) {
//						Window.alert("Please, Input Your other survey datas");
//						return;
//					}
//				}
//				for(int i=0; i<subinputdata.length; i++) {
//					subinputdata[i]=Integer.toString(subinputs[i].getSelectedIndex()-2).trim();
//					if(subinputdata[i].equals("")) {
//						Window.alert("Please, Input Your other survey datas");
//						return;
//					}
//				}
//				//kjmembership_dataset
//				KJMember kjMember = new KJMember();
//				kjMember.setID(membershipData[0]);
//				kjMember.setPassword(membershipData[1]);
//				kjMember.setCheckPassword(membershipData[2]);
//				kjMember.setName(membershipData[3]);
////				kjMember.setGender(membershipData[4);
//				kjMember.setGender(listData[0]);
//				kjMember.setYear(listData[1]);
//				kjMember.setDate(listData[2]);
//				kjMember.setCountry(listData[3]);
//				kjMember.setLocal(listData[4]);
//				
//				//survey data set
//				Survey_data surveyData = new Survey_data();
//				surveyData.setID(membershipData[0]);
//				surveyData.setName(membershipData[3]);
//				surveyData.setPreference(subinputdata[0]);
////				surveyData.setInterest(interestData);
//				surveyData.setA(subinputdata[1]);
//				surveyData.setB(subinputdata[2]);
//				surveyData.setC(subinputdata[3]);
////				surveyData.setNumber(`);
//				
//				//Korean survey data Statistic
////				surveyData.setGyeonggi_people(gyeonggi_people);
////				surveyData.setSeoul_people(seoul_people);
////				surveyData.setGangwon_people(gangwon_people);
////				surveyData.setNorth_Chungcheong_people(north_Chungcheong_people);
////				surveyData.setSouth_Chungcheong_people(south_Chungcheong_people);
////				surveyData.setNorth_Gyeongsang_people(north_Gyeongsang_people);
////				surveyData.setSouth_Gyeongsang_people(south_Gyeongsang_people);
////				surveyData.setNorth_Jeolla_people(north_Jeolla_people);
////				surveyData.setSouth_Jeolla_peoples(south_Jeolla_peoples);
//				
//				////Japanese survey data Statistic
////				surveyData.setHokkaido_people(hokkaido_people);
////				surveyData.setTohoku_people(tohoku_people);
////				surveyData.setKanto_people(kanto_people);
////				surveyData.setChubu_people(chubu_people);
////				surveyData.setKinki_people(kinki_people);
////				surveyData.setChugoku_people(chugoku_people);
////				surveyData.setShikokupeople(shikokupeople);
//				
//				//서버통신
//				KJMembershipServiceAsync service = GWT.create(KJMembershipService.class);
//				service.Register_Membership(kjMember, new AsyncCallback<Void>() {
//					
//					@Override
//					public void onSuccess(Void result) {
//						// TODO Auto-generated method stub
//						Window.alert("Welcome to the membership");
//						Register_Membership.this.hide();
//						
//					}
//					@Override
//					public void onFailure(Throwable caught) {
//						// TODO Auto-generated method stub
//						Window.alert("Sorry, Please try agian after few minutes");
//						Register_Membership.this.hide();
//					}
//				});
//			}
//		});
//		btnOk.setText("Register");
//		
//		//취소
//		Button btnCancel = new Button();
//		btnCancel.setText("Cancel");
//		btnCancel.addClickHandler(new ClickHandler() {
//			@Override
//			public void onClick(ClickEvent arg0) {
//				// TODO Auto-generated method stub
//				Register_Membership.this.hide();
//			}
//		});
//	}
}  