package com.coderwurst.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class FindMeASpot implements EntryPoint {

	
	public void onModuleLoad() {
		RootPanel.get().add(new FindMeASpotBonn());
	}
}
