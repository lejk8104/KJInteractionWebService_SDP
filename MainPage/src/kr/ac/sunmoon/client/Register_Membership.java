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
  
  
public class Register_Membership extends Window{  
  
	private ArrayList inputlList = new ArrayList();
	
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
  
        Panel firstTab = new Panel();  
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
        TextField txtID = new TextField("ID", "id", 200);  
        txtID.setAllowBlank(false);  
//        txtID.setValue("id"); 
        firstTab.add(txtID);  
  
        //Password
        TextField txtPassword = new TextField("Password", "passwordData", 200);  
//        txtPassword.setValue("password");  
        firstTab.add(txtPassword);  
  
        //CheckPassword
        TextField txtCheckPassword = new TextField("Check Password", "checkpasswordData", 200);  
//        txtCheckPassword.setValue("checkpassword");
        firstTab.add(txtCheckPassword);  

        //Name
        TextField txtName = new TextField("Name", "nameData", 200);
        txtName.setAllowBlank(false); 
        txtName.setValue("name"); 
        firstTab.add(txtName);  
  
        //E-Mail
        TextField txtemail = new TextField("Email", "emailData", 200);  
        txtemail.setVtype(VType.EMAIL);  
        firstTab.add(txtemail);  
  
        //Gender list
        ComboBox listgender = new ComboBox();
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
        DateField dataBirth = new DateField("Date of birth", "BirthData", 200);  
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
    	final ComboBox listlocal = new ComboBox();  
    	listlocal.setFieldLabel("Select City");  
    	listlocal.setStore(citiesStore);  
    	listlocal.setDisplayField("cityName");  
//    	listlocal.setValueField("local");  
    	listlocal.setMode(ComboBox.LOCAL);  
	    listlocal.setTriggerAction(ComboBox.ALL);  
	    listlocal.setLinked(true);  
	    listlocal.setForceSelection(true);  
	    listlocal.setReadOnly(true);  

	    //동작과정
	    listcountry.addListener(new ComboBoxListenerAdapter() {  
        public void onSelect(ComboBox comboBox, Record record, int index) {  
            listlocal.setValue("");  
            citiesStore.filter("country", comboBox.getValue());  
        	}  
	    });  
	    firstTab.add(listcountry);
	    firstTab.add(listlocal);
  
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
        Panel secondTab = new Panel();  
        secondTab.setTitle("Survey");  
        secondTab.setLayout(new FormLayout());  
        secondTab.setAutoHeight(true);  
        secondTab.setPaddings(10);  
 
        // preference
        ComboBox listpreference = new ComboBox();
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
        TextField txtinterests = new TextField("Interests", "interests", 200);  
        txtinterests.setAllowBlank(false);  
//        txtinterests.setValue("interests"); 
        secondTab.add(txtinterests);
        
        //A
        ComboBox A = new ComboBox();
        A.setAllowBlank(false);
        A.setMinChars(1);
        A.setFieldLabel("Preference");
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
        ComboBox B = new ComboBox();
        B.setAllowBlank(false);
        B.setMinChars(1);
        B.setFieldLabel("Preference");
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
        ComboBox C = new ComboBox();
        C.setAllowBlank(false);
        C.setMinChars(1);
        C.setFieldLabel("Preference");
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
        
        Button btnok = new Button("OK", new ButtonListenerAdapter() {
        	
        	public void onClick(Button btnok, EventObject e) {
//        		for (int)
//        		inputlList.add(index, element);
        	}
        });  
        Button btncancel = new Button("Cancel");  
  
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
    
