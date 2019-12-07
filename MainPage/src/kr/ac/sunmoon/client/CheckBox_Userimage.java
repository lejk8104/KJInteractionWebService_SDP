package kr.ac.sunmoon.client;

import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.ArrayReader;
import com.gwtext.client.data.FieldDef;
import com.gwtext.client.data.MemoryProxy;
import com.gwtext.client.data.Record;
import com.gwtext.client.data.RecordDef;
import com.gwtext.client.data.Store;
import com.gwtext.client.data.StringFieldDef;
import com.gwtext.client.widgets.Button;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.grid.BaseColumnConfig;
import com.gwtext.client.widgets.grid.CheckboxColumnConfig;
import com.gwtext.client.widgets.grid.CheckboxSelectionModel;
import com.gwtext.client.widgets.grid.ColumnConfig;
import com.gwtext.client.widgets.grid.ColumnModel;
import com.gwtext.client.widgets.grid.GridPanel;
import com.gwtext.client.widgets.layout.VerticalLayout;

public class CheckBox_Userimage extends GridPanel {

	// Main method
	public CheckBox_Userimage() {
		super();
		this.setBorder(false);
		this.setPaddings(5);
		this.setButtonAlign(Position.CENTER);
//		this.setLayout(new VerticalLayout(25));
		
		//Gird panel 선언
		// data setting 1: store 선언
        Store loginStore = new Store(proxy, reader);  
        loginStore.load();  
        this.setStore(loginStore);  
  
        // data setting 2 : grid에 들어갈 colunm 선언
        ColumnModel columnModel = new ColumnModel(columns);  
        this.setColumnModel(columnModel);  
  
        this.setFrame(true);  
        this.setStripeRows(true);  
        this.setAutoExpandColumn("image");  
  
        this.setSelectionModel(CheckboxUser);
        this.setWidth(350);  
        this.setHeight(250);  
        this.setFrame(true);  
        this.setIconCls("grid-icon");  
  
	}
	// 체크박스 만들기
	final CheckboxSelectionModel CheckboxUser = new CheckboxSelectionModel();  

	//Userimage object
    private Object[][] UserImageList() {  
        return new Object[][]{ 
        	new Object[]{new Image("UserImage/Nomal.png"),"UserImage/Nomal.png"},
                new Object[]{new Image("UserImage/JapaneseFemale.png"),"UserImage/JapaneseFemale.png"},  
                new Object[]{new Image("UserImage/JapaneseFemale2.png"),"UserImage/JapaneseFemale2.png"},  
                new Object[]{new Image("UserImage/JapaneseMale.png"),"UserImage/JapaneseMale.png"},  
                new Object[]{new Image("UserImage/JapaneseMale2.png"),"UserImage/JapaneseMale2.png"},  
                new Object[]{new Image("UserImage/KoreanFemale.png"),"UserImage/KoreanFemale.png"},
                new Object[]{new Image("UserImage/KoreanFemale2.png"),"UserImage/KoreanFemale2.png"},
                new Object[]{new Image("UserImage/KoreanMale.png"),"UserImage/KoreanMale.png"},
                new Object[]{new Image("UserImage/KoreanMale2.png"),"UserImage/KoreanMale2.png"}
        };  
    }
    // userimage list read
    RecordDef recordDef = new RecordDef(  
            new FieldDef[]{  
                    new StringFieldDef("image")
            }  
    );
    final Object[][] imagelist = UserImageList();
    
    final MemoryProxy proxy = new MemoryProxy(imagelist);
    final ArrayReader reader = new ArrayReader(recordDef); 
    
    //input grid columns
    final BaseColumnConfig[] columns = new BaseColumnConfig[]{  
            new CheckboxColumnConfig(CheckboxUser),  
            //column ID is company which is later used in setAutoExpandColumn  
            new ColumnConfig("Please, Check to only One Image ", "image", 160, true, null, "image"),  
    };  
}
