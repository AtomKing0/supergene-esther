package com.king.usdk.popupwebview.internal;

import android.app.Activity;
import android.os.Build;
import androidx.annotation.Keep;
import androidx.webkit.WebViewCompat;
import com.king.usdk.popupwebview.IPopup;
import com.king.usdk.popupwebview.IPopupFactory;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public final class PopupFactory implements IPopupFactory {
    private static final int MIN_SDK_VERSION_NEEDED = 19;
    private static volatile PopupFactory popupFactory;
    private static final Object popupFactoryMonitor = new Object();
    private final ActivityWrapper activityWrapper;

    private PopupFactory(Activity activity) {
        this.activityWrapper = new ActivityWrapper(activity);
    }

    public static PopupFactory initFactory(Activity activity) {
        PopupFactory popupFactory2;
        if (!isSupportedByOs(activity)) {
            return null;
        }
        PopupFactory popupFactory3 = popupFactory;
        if (popupFactory3 != null) {
            popupFactory3.activityWrapper.updateActivity(activity);
            return popupFactory3;
        }
        synchronized (popupFactoryMonitor) {
            if (popupFactory == null && activity != null) {
                popupFactory = new PopupFactory(activity);
            }
            popupFactory2 = popupFactory;
        }
        return popupFactory2;
    }

    public static boolean isSupportedByOs(Activity activity) {
        return (Build.MANUFACTURER.equalsIgnoreCase("Amazon") || Build.BRAND.equalsIgnoreCase("Amazon")) || WebViewCompat.getCurrentWebViewPackage(activity.getApplicationContext()) != null;
    }

    NativeController createNativeController(boolean z10) {
        return new NativeController(this.activityWrapper, z10);
    }

    @Override // com.king.usdk.popupwebview.IPopupFactory
    public IPopup createPopup() {
        return new Popup(this.activityWrapper, true);
    }

    @Override // com.king.usdk.popupwebview.IPopupFactory
    public IPopup createPopup(boolean z10) {
        return new Popup(this.activityWrapper, z10);
    }
}
