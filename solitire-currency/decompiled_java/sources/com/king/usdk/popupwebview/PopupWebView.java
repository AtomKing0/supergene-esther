package com.king.usdk.popupwebview;

import android.app.Activity;
import androidx.annotation.Keep;
import com.king.usdk.popupwebview.internal.PopupFactory;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public final class PopupWebView {
    private PopupWebView() {
    }

    public static IPopupFactory initFactory(Activity activity) {
        return PopupFactory.initFactory(activity);
    }
}
