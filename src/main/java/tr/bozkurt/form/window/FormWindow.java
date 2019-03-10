package tr.bozkurt.form.window;

import tr.bozkurt.form.response.FormResponse;

public abstract class FormWindow{

	protected boolean closed = false;

	public abstract String getJSONData();

	public abstract FormResponse getResponse();

	public abstract void setResponse(String data);

	public boolean wasClosed(){
		return closed;
	}

}
