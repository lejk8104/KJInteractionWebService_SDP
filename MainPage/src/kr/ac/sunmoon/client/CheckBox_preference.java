package kr.ac.sunmoon.client;

import com.google.gwt.user.client.ui.RootPanel;  
import com.gwtext.client.core.EventObject;
import com.gwtext.client.core.Position;
import com.gwtext.client.data.*;  
import com.gwtext.client.widgets.Button;  
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.event.ButtonListenerAdapter;
import com.gwtext.client.widgets.form.FormPanel;
import com.gwtext.client.widgets.form.TextField;
import com.gwtext.client.widgets.grid.*;  
import com.gwtext.client.widgets.layout.VerticalLayout; 

public class CheckBox_preference extends GridPanel  {
	// 체크박스 만들기
	final CheckboxSelectionModel CheckboxPreference = new CheckboxSelectionModel();  
	
	// 가져온 체크박스
    private Object[][] PerferList() {  
        return new Object[][]{  
                new Object[]{"A"},  
                new Object[]{"B"},  
                new Object[]{"C"},  
                new Object[]{"D"},  
                new Object[]{"E"},  
        };  
    }  
	
	// prefer list read
    RecordDef recordDef = new RecordDef(  
            new FieldDef[]{  
                    new StringFieldDef("prefer"),  
            }  
    );
    
    //Db를 통해 갖고온 preferlist object 선언
    final Object[][] perferlist = PerferList();
    
    final MemoryProxy proxy = new MemoryProxy(perferlist);
    final ArrayReader reader = new ArrayReader(recordDef); 
    
    //input grid columns
    final BaseColumnConfig[] columns = new BaseColumnConfig[]{  
            new CheckboxColumnConfig(CheckboxPreference),  
            //column ID is company which is later used in setAutoExpandColumn  
            new ColumnConfig("Warning :We need your preference Priority ", "prefer", 160, true, null, "prefer"),  
    };  
    
	public CheckBox_preference() {
		super();	
		
		// data setting 1: store 선언
        final Store preferStore = new Store(proxy, reader);  
        preferStore.load(); 
		this.setStore(preferStore);
		
		ColumnModel columnModel = new ColumnModel(columns);
		this.setColumnModel(columnModel);
		
		this.setFrame(true);
		this.setStripeRows(true);
		this.setAutoExpandColumn("prefer");  
		
		this.setSelectionModel(CheckboxPreference);
		this.setWidth(350);
		this.setHeight(250);
        this.setFrame(true);  
        this.setTitle("Input your Preference data");  
        this.setIconCls("grid-icon");
	}
	private Object[][] MostPreference() {  
        return new Object[][]{  
                new Object[]{"lst"},  
                new Object[]{"2nd"},  
                new Object[]{"3rd"},  
                new Object[]{"4rd"},  
                new Object[]{"5rd"},  
        };  
    }
}
