package kr.ac.sunmoon.client;

import com.google.gwt.user.client.ui.DialogBox;
import com.gwtext.client.widgets.Panel;
import com.gwtext.client.widgets.Window;
import com.gwtext.client.widgets.form.FormPanel;

public class Advertise_KJinteration extends Window{

	private Panel panel = new Panel();
	private FormPanel formpanel = new FormPanel();
	
	public Advertise_KJinteration() {
		// TODO Auto-generated constructor stub
		super();
		this.setTitle("Advertise");
		Panel adverisePanel = new Panel();
		adverisePanel.setBorder(false);
		adverisePanel.setPaddings(15);

		
		FormPanel formPanel = new FormPanel();
		formPanel.setFrame(true);
		formPanel.setTitle("Adbertise");
	    formPanel.setLabelWidth(65);  
	    formPanel.setBorder(false);  
	    formPanel.setWidth(320);
		this.add(adverisePanel);
	    this.add(formPanel);
		
		
		
	}
}
