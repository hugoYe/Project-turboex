package com.android.launcher.framework;

import android.appwidget.AppWidgetHostView;
import android.appwidget.AppWidgetProviderInfo;
import android.os.Bundle;
import android.os.Parcelable;

public class PendingAddWidgetInfo extends PendingAddItemInfo {
	public int minWidth;
	public int minHeight;
	public int minResizeWidth;
	public int minResizeHeight;
	public int previewImage;
	public int icon;
	public AppWidgetProviderInfo info;
	public AppWidgetHostView boundWidget;
	public Bundle bindOptions = null;

	// Any configuration data that we want to pass to a configuration activity
	// when
	// starting up a widget
	String mimeType;
	Parcelable configurationData;

	public PendingAddWidgetInfo(AppWidgetProviderInfo i, String dataMimeType,
			Parcelable data) {
		itemType = LauncherSettings.Favorites.ITEM_TYPE_APPWIDGET;
		this.info = i;
		componentName = i.provider;
		minWidth = i.minWidth;
		minHeight = i.minHeight;
		minResizeWidth = i.minResizeWidth;
		minResizeHeight = i.minResizeHeight;
		previewImage = i.previewImage;
		icon = i.icon;
		if (dataMimeType != null && data != null) {
			mimeType = dataMimeType;
			configurationData = data;
		}
	}

	// Copy constructor
	public PendingAddWidgetInfo(PendingAddWidgetInfo copy) {
		minWidth = copy.minWidth;
		minHeight = copy.minHeight;
		minResizeWidth = copy.minResizeWidth;
		minResizeHeight = copy.minResizeHeight;
		previewImage = copy.previewImage;
		icon = copy.icon;
		info = copy.info;
		boundWidget = copy.boundWidget;
		mimeType = copy.mimeType;
		configurationData = copy.configurationData;
		componentName = copy.componentName;
		itemType = copy.itemType;
		spanX = copy.spanX;
		spanY = copy.spanY;
		minSpanX = copy.minSpanX;
		minSpanY = copy.minSpanY;
		bindOptions = copy.bindOptions == null ? null
				: (Bundle) copy.bindOptions.clone();
	}

	@Override
	public String toString() {
		return "Widget: " + componentName.toShortString();
	}
}