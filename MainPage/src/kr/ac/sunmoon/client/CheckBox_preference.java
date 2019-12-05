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
	Object[][] mostperfer = MostPreference();
	
	public CheckBox_preference() {
		super();
		MemoryProxy porxy = new MemoryProxy(mostperfer);
		Store store = new Store(proxy, reader);
		
		this.setStore(store);
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
