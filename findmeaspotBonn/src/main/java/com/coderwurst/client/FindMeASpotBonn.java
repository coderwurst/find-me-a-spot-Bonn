package com.coderwurst.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class FindMeASpotBonn extends Composite {

	private static FindMeASpotBonnUiBinder uiBinder = GWT.create(FindMeASpotBonnUiBinder.class);

	interface FindMeASpotBonnUiBinder extends UiBinder<Widget, FindMeASpotBonn> {
	}
	
	public FindMeASpotBonn() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
}
