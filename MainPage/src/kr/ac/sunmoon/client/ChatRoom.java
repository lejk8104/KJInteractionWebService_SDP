package kr.ac.sunmoon.client;

import com.gwtext.client.widgets.Window;

public class ChatRoom extends Window{
	public ChatRoom() {
		super();
		this.setBorder(false);
		this.setPaddings(0);
		this.setClosable(true);
		this.setWidth(1024);
		this.setHeight(700);
		this.setPlain(true);
		this.setCloseAction(this.HIDE);
		
	}
}
