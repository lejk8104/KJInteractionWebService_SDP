package kr.ac.sunmoon.client;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.TextBox;

public class FindPassword extends DialogBox {

private TextBox[] membershipdata;

		public FindPassword() {
			
			super(false,true);
			this.setText("Find Password Page");
			
			Grid grid = new Grid(2,2);
			this.setWidget(grid);
			
			Grid test = new Grid(1,2);
			this.setWidget(test);
		}
}