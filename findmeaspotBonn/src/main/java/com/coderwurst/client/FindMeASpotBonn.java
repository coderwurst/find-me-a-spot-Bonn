package com.coderwurst.client;

import java.util.Map;

import org.gwtbootstrap3.client.ui.FormLabel;

import com.google.gwt.core.client.GWT;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.RequestTimeoutException;
import com.google.gwt.http.client.Response;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.xml.client.DOMException;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.Node;
import com.google.gwt.xml.client.XMLParser;

public class FindMeASpotBonn extends Composite {

	private Map<String, Integer> spaces;
	private static FindMeASpotBonnUiBinder uiBinder = GWT.create(FindMeASpotBonnUiBinder.class);

	@UiField Panel availableSpacesList;
	@UiField FormLabel serverStatus;

	
	public static final int STATUS_CODE_OK = 200;
	private static final String BONN_PARKPLATZ_WEBSITE = "http://www.bcp-bonn.de/stellplatz/bcpinfo.xml";
	private static final String SITE_UP = "https://opendata.bonn.de/api/3/action/site_read";
	
	interface FindMeASpotBonnUiBinder extends UiBinder<Widget, FindMeASpotBonn> {
	}
	
	public FindMeASpotBonn() {
		// TODO checkServer(); with SITE_UP address
		doGet(BONN_PARKPLATZ_WEBSITE);
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void doGet(String url) {
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);
		builder.setHeader("Authorization", "Negotiate");
		try {
			
			Request response = builder.sendRequest(null, new RequestCallback() {
				@Override
				public void onError(Request request, Throwable exception) {
					if (exception instanceof RequestTimeoutException) {
						Window.alert("The request has timed out");
					} else {
						Window.alert(exception.getMessage());
					}
				}

				@Override
				public void onResponseReceived(Request request, Response response) {
					// TODO create list
					serverStatus.setText("server reached");
					if (STATUS_CODE_OK == response.getStatusCode()) {
						parseResponse(response.getText());
					} else {
						serverStatus.setText("service unavailable: " + response.getStatusCode());
					}
				}
			});
		} catch (RequestException e) {
			// TODO Exception Handling
		}
	}
	
	private void parseResponse(String xmlString) {
		Window.alert(xmlString);
		try {
			Document parkhausDom = XMLParser.parse(xmlString);
			
			Node parkhaus = parkhausDom.getElementsByTagName("parkhaus").item(0); 
			String name = parkhausDom.getElementsByTagName("bezeichnung").item(0).getFirstChild().getNodeValue();
			// TODO update screen
			
			String subject = parkhausDom.getElementsByTagName("frei").item(0).getFirstChild().getNodeValue();
			// TODO update screen

		} catch (DOMException e) {
			Window.alert("Could not parse XML document: " + xmlString);
		}
	}
	
}
