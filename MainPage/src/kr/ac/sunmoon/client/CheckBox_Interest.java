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

public class CheckBox_Interest extends GridPanel  {
	// 체크박스 만들기
	final CheckboxSelectionModel CheckboxInterest = new CheckboxSelectionModel();  
	
	// 가져온 체크박스
	private Object[][] InterestList(){  
        return new Object[][]{  
                new Object[]{"lst"},  
                new Object[]{"2nd"},  
                new Object[]{"3rd"},  
                new Object[]{"4rd"},  
                new Object[]{"5rd"},    
        };  
    }  
	
	// prefer list read
    RecordDef recordDef = new RecordDef(  
            new FieldDef[]{  
                    new StringFieldDef("interest"),  
            }  
    );
    
    //Db를 통해 갖고온 preferlist object 선언
    final Object[][] interestlist = InterestList();
    
    final MemoryProxy proxy = new MemoryProxy(interestlist);
    final ArrayReader reader = new ArrayReader(recordDef); 
    
    //input grid columns
    final BaseColumnConfig[] columns = new BaseColumnConfig[]{  
            new CheckboxColumnConfig(CheckboxInterest),  
            //column ID is company which is later used in setAutoExpandColumn  
            new ColumnConfig("Warning :We need your preference Priority ", "interest", 160, true, null, "interest"),  
    };  
    
	public CheckBox_Interest() {
		super();	
		
		// data setting 1: store 선언
        final Store interestStore = new Store(proxy, reader);  
        interestStore.load(); 
		this.setStore(interestStore);
		
		ColumnModel columnModel = new ColumnModel(columns);
		this.setColumnModel(columnModel);
		
		this.setFrame(true);
		this.setStripeRows(true);
		this.setAutoExpandColumn("interest");  
		
		this.setSelectionModel(CheckboxInterest);
		this.setWidth(350);
		this.setHeight(250);
        this.setFrame(true);  
        this.setTitle("Input your Interest data");  
        this.setIconCls("grid-icon");
	}
}