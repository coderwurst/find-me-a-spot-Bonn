package com.coderwurst.client;

import java.util.Map;

import org.gwtbootstrap3.client.ui.FormLabel;

import com.coderwurst.service.BonnService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

public class FindMeASpotBonn extends Composite {

	private Map<String, Integer> spaces;
	private static FindMeASpotBonnUiBinder uiBinder = GWT.create(FindMeASpotBonnUiBinder.class);

	@UiField Panel availableSpacesList;
	@UiField FormLabel serverStatus;
	
	public static final int STATUS_CODE_OK = 200;
	private static final String BONN_PARKPLATZ_API = "http://www.bcp-bonn.de/stellplatz/bcpinfo.xml";

	
	interface FindMeASpotBonnUiBinder extends UiBinder<Widget, FindMeASpotBonn> {
	}
	
	public FindMeASpotBonn() {
		initWidget(uiBinder.createAndBindUi(this));
		doGet(BONN_PARKPLATZ_API);
	}

	public void doGet(String url) {
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);

		try {
			Request response = builder.sendRequest(null, new RequestCallback() {
				public void onError(Request request, Throwable exception) {
					// TODO update screen with server not available
				}

				public void onResponseReceived(Request request, Response response) {
					// TODO create list
					serverStatus.setText("server reached");
				}
		});
		} catch (RequestException e) {
			// TODO Exception Handling
		}
  }
	
}
