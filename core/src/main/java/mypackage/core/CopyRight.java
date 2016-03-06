package mypackage.core;

import com.adobe.cq.sightly.WCMUse;

public class CopyRight extends WCMUse{

	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub
		if(getCurrentPage()!=null){
			//String template = (String)getCurrentPage().getProperties();
		}
		
		getCurrentPage().getTemplate().getTitle();
		message = "This is copyright property";
	}

	
}
