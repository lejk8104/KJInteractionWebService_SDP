package kr.ac.sunmoon.client;

import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;

import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.SimpleStore;
import com.gwtext.client.data.Store;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.TabPanel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.ComboBox;
import com.gwtext.client.widgets.form.DateField;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.form.VType;
import com.gwtext.client.widgets.form.event.ComboBoxListenerAdapter;
import com.gwtext.client.widgets.layout.FormLayout;
import com.sun.java.swing.plaf.windows.resources.windows;

import kr.ac.sunmoon.shared.KJMember;
  
  
public class Register_Membership extends Window{  
  
	private ArrayList<String> inputlList = new ArrayList<String>();
	String[] membershipdata = new String[9];
	String[] surveydata =  new String[4];
	
    public Register_Membership() {  

    	super();
		this.setBorder(false);
		this.setPaddings(0);
		this.setClosable(true);
		this.setWidth(335);
		this.setHeight(415);
		this.setPlain(true);
		this.setCloseAction(this.HIDE);
    	
		
        FormPanel formPanel = new FormPanel();  
        formPanel.setFrame(true); 
        formPanel.setTitle("KJ Membership Page");
        formPanel.setLabelWidth(65);  
        formPanel.setBorder(false);  
        formPanel.setWidth(320);  
        
        //TabPanel 선언
        final TabPanel tabPanel = new TabPanel();  
        tabPanel.setActiveTab(0);  
  
        final Panel firstTab = new Panel();  
        firstTab.setTitle("KJ Membership");  
        firstTab.setLayout(new FormLayout());  
        firstTab.setAutoHeight(true);  
        firstTab.setPaddings(10);  
  
        //list store 선언
        final Store gender = new SimpleStore(new String[] {"genderData","gender"}, Getgender());
        gender.load();
        final Store countriesStore = new SimpleStore(new String[]{"country", "countryData"}, countries);  
        countriesStore.load();  
        final Store citiesStore = new SimpleStore(new String[]{"cityData", "country", "cityName"}, cities);  
        citiesStore.load(); 
        
        // ID
        final TextField txtID = new TextField("ID", "id", 200);  
        txtID.setAllowBlank(false);  
//        txtID.setValue("id"); 
        firstTab.add(txtID);  
  
        //Password
        final TextField txtPassword = new TextField("Password", "passwordData", 200);  
//        txtPassword.setValue("password");  
        firstTab.add(txtPassword);  
  
        //CheckPassword
        final TextField txtCheckPassword = new TextField("Check Password", "checkpasswordData", 200);  
//        txtCheckPassword.setValue("checkpassword");
        firstTab.add(txtCheckPassword);  

        //Name
        final TextField txtName = new TextField("Name", "nameData", 200);
        txtName.setAllowBlank(false); 
        txtName.setValue("name"); 
        firstTab.add(txtName);  
  
        //E-Mail
        final TextField txtemail = new TextField("Email", "emailData", 200);  
        txtemail.setVtype(VType.EMAIL);  
        firstTab.add(txtemail);  
  
        //Gender list
        final ComboBox listgender = new ComboBox();
        listgender.setAllowBlank(false);
        listgender.setMinChars(1);
        listgender.setFieldLabel("Gender");
        listgender.setStore(gender);
        listgender.setDisplayField("genderData");
        listgender.setEmptyText("Select Gender"); 
        listgender.setTriggerAction(ComboBox.ALL); //? 모르겠다
        listgender.setTypeAhead(true);  // 이를 채우고 자동 선택한다
        listgender.setSelectOnFocus(true); //데이터값 수신할 떄 자동채움
        listgender.setWidth(200);  
        listgender.setResizable(true); //?
        firstTab.add(listgender);
        
        //Birth
        final DateField dataBirth = new DateField("Date of birth", "BirthData", 200);  
        dataBirth.setAllowBlank(false);
        firstTab.add(dataBirth);
        
        // country
        final ComboBox listcountry = new ComboBox();  
        listcountry.setFieldLabel("Select Country");  
        listcountry.setStore(countriesStore);  
        listcountry.setDisplayField("countryData");  
        listcountry.setMode(ComboBox.LOCAL);  
    	listcountry.setTriggerAction(ComboBox.ALL);  
    	listcountry.setForceSelection(true);  
//    	listcountry.setValueField("country");  
    	listcountry.setReadOnly(true);  

    	// local
    	final ComboBox listcity = new ComboBox();  
    	listcity.setFieldLabel("Select City");  
    	listcity.setStore(citiesStore);  
    	listcity.setDisplayField("cityName");  
//    	listlocal.setValueField("local");  
    	listcity.setMode(ComboBox.LOCAL);  
	    listcity.setTriggerAction(ComboBox.ALL);  
	    listcity.setLinked(true);  
	    listcity.setForceSelection(true);  
	    listcity.setReadOnly(true);  

	    //동작과정
	    listcountry.addListener(new ComboBoxListenerAdapter() {  
        public void onSelect(ComboBox comboBox, Record record, int index) {  
            listcity.setValue("");  
            citiesStore.filter("country", comboBox.getValue());  
        	}  
	    });  
	    firstTab.add(listcountry);
	    firstTab.add(listcity);
  
        tabPanel.add(firstTab);  
        
        //list store 선언
        final Store preference = new SimpleStore(new String[] {"Text","Preference","data"}, Getpreference());
        preference.load();
        final Store a = new SimpleStore(new String[] {"Text","A","data"}, GetA());
        a.load();
        final Store b = new SimpleStore(new String[] {"Text","B","data"}, GetB());
        b.load();
        final Store c = new SimpleStore(new String[] {"Text","C","data"}, GetC());
        c.load();
        
        // Survey
        final Panel secondTab = new Panel();  
        secondTab.setTitle("Survey");  
        secondTab.setLayout(new FormLayout());  
        secondTab.setAutoHeight(true);  
        secondTab.setPaddings(10);  
 
        // preference
        final ComboBox listpreference = new ComboBox();
        listpreference.setAllowBlank(false);
        listpreference.setMinChars(1);
        listpreference.setFieldLabel("Preference");
        listpreference.setStore(c);
        listpreference.setDisplayField("Text");
        listpreference.setEmptyText("Select Preference"); 
        listpreference.setTriggerAction(ComboBox.ALL); //? 모르겠다
        listpreference.setTypeAhead(true);  // 이를 채우고 자동 선택한다
        listpreference.setSelectOnFocus(true); //데이터값 수신할 떄 자동채움
        listpreference.setWidth(200);  
        listpreference.setResizable(true); //?
        secondTab.add(listpreference);

        //Interest
        final TextField txtinterests = new TextField("Interests", "interests", 200);  
        txtinterests.setAllowBlank(false);  
//        txtinterests.setValue("interests"); 
        secondTab.add(txtinterests);
        
        //A
        final ComboBox A = new ComboBox();
        A.setAllowBlank(false);
        A.setMinChars(1);
        A.setFieldLabel("A");
        A.setStore(a);
        A.setDisplayField("Text");
        A.setEmptyText("Select A"); 
        A.setTriggerAction(ComboBox.ALL); //? 모르겠다
        A.setTypeAhead(true);  // 이를 채우고 자동 선택한다
        A.setSelectOnFocus(true); //데이터값 수신할 떄 자동채움
        A.setWidth(200);  
        A.setResizable(true); //?
        secondTab.add(A);
        
        //B
        final ComboBox B = new ComboBox();
        B.setAllowBlank(false);
        B.setMinChars(1);
        B.setFieldLabel("B");
        B.setStore(b);
        B.setDisplayField("Text");
        B.setEmptyText("Select B"); 
        B.setTriggerAction(ComboBox.ALL); //? 모르겠다
        B.setTypeAhead(true);  // 이를 채우고 자동 선택한다
        B.setSelectOnFocus(true); //데이터값 수신할 떄 자동채움
        B.setWidth(200);  
        B.setResizable(true); //?
        secondTab.add(B);
        
        //C
        final ComboBox C = new ComboBox();
        C.setAllowBlank(false);
        C.setMinChars(1);
        C.setFieldLabel("C");
        C.setStore(c);
        C.setDisplayField("Text");
        C.setEmptyText("Select C"); 
        C.setTriggerAction(ComboBox.ALL); //? 모르겠다
        C.setTypeAhead(true);  // 이를 채우고 자동 선택한다
        C.setSelectOnFocus(true); //데이터값 수신할 떄 자동채움
        C.setWidth(200);  
        C.setResizable(true); //?
        secondTab.add(C);

        tabPanel.add(secondTab);
        
        final Button btnok = new Button("OK", new ButtonListenerAdapter() {
        	
        	public void onClick(Button btnok, EventObject e) {
        		// membershipdata list 선언
        		membershipdata[0] = txtID.getText().trim();
        		membershipdata[1] = txtPassword.getText().trim();
        		membershipdata[2] = txtCheckPassword.getText().trim();
        		membershipdata[3] = txtName.getText().trim();
        		membershipdata[4] = listgender.getText().trim();
        		membershipdata[5] = txtemail.getText().trim();
        		membershipdata[6] = dataBirth.getText().trim();
        		membershipdata[7] = listcountry.getText().trim();
        		membershipdata[8] = listcity.getText().trim();
        		// survey data list 선언
        		surveydata[0] = listpreference.getText().trim();
        		surveydata[1] = A.getText().trim();
        		surveydata[2] = B.getText().trim();
        		surveydata[3] = C.getText().trim();
        		for(int i=0; i<membershipdata.length; i++) {
        			if(membershipdata[i].equals("")) {
        				Window popup = new Window();
        				return;
        			}
        		}
        		for(int i=0; i<surveydata.length; i++) {
        			if(surveydata[i].equals("")) {
        				Window popup = new Window();
        				popup.setTitle("Please, input your survey data");
        				return;
        			}
        		}
        		//kjmembership_dataset
        		KJMember kjMember = new KJMember();
				kjMember.setID(membershipdata[0]);
				kjMember.setPassword(membershipdata[1]);
				kjMember.setCheckPassword(membershipdata[2]);
				kjMember.setName(membershipdata[3]);
				kjMember.setGender(membershipdata[4]);
				kjMember.setEmail(membershipdata[5]);
//				kjMember.setBirth(membershipdata[6]);
				kjMember.setCountry(membershipdata[7]);
				kjMember.setLocal(membershipdata[7]);
        	}
        });  
        final Button btncancel = new Button("Cancel",new ButtonListenerAdapter() {
            public void onClick(Button btncancel, EventObject e) {  
                Register_Membership.this.hide();
            }
        });    
        formPanel.addButton(btnok);  
        formPanel.addButton(btncancel);  
  
        formPanel.add(tabPanel);  
        this.add(formPanel);  
  
        RootPanel.get().add(this);  
    }  
//    public Object[] txtinputs(Object txtCheckPassword, Object listlocal) {
//		return new Object[] {
//				new Object[] {txtID, txtPassword, txtCheckPassword, txtName, listgender, txtemail,listcountry,dataBirth,listlocal}
//				
//	};
//}
    
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
}
    
