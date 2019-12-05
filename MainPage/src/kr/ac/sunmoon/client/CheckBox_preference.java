package kr.ac.sunmoon.client;

import com.google.gwt.dev.shell.SuperDevListener;
import com.google.gwt.user.client.ui.RootPanel;  
import com.gwtext.client.core.EventObject;  
import com.gwtext.client.data.*;  
import com.gwtext.client.widgets.Button;  
import com.gwtext.client.widgets.Panel;  
import com.gwtext.client.widgets.event.ButtonListenerAdapter;  
import com.gwtext.client.widgets.grid.*;  
import com.gwtext.client.widgets.layout.VerticalLayout; 

public class CheckBox_preference extends GridPanel  {
	final Object[][] mostperfer = MostPreference();
	final RecordDef preferRecord = new RecordDef(
			new FieldDef[]{
					new StringFieldDef("Preference List"),
			}
	);
	final CheckboxSelectionModel cbSelectionModel = new CheckboxSelectionModel();
	
	public CheckBox_preference() {
		super();	
		
		// data setting
		MemoryProxy proxy = new MemoryProxy(mostperfer);
		ArrayReader reader = new ArrayReader(preferRecord);
		Store store = new Store(proxy, reader);
		store.load();
		this.setStore(store);
		
		ColumnModel columdataset = new ColumnModel(columns);
		this.setColumnModel(columdataset);
		
		this.setFrame(true);
		this.setStripeRows(true);
		this.setAutoExpandColumn("preference");
		
		this.setSelectionModel(cbSelectionModel);
		this.setWidth(350);
		this.setHeight(200);
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
	final ColumnConfig text = new ColumnConfig("Company", "company", 160);
	
    private BaseColumnConfig[] columns = new BaseColumnConfig[]{  
            new ColumnConfig("Text", "company", 160, true, null, "company"),  
    };
	
}
