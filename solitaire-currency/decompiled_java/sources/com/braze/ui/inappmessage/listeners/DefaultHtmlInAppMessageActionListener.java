package com.braze.ui.inappmessage.listeners;

import android.os.Bundle;
import com.braze.models.inappmessage.IInAppMessage;
import o0.a;

/* JADX INFO: compiled from: DefaultHtmlInAppMessageActionListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public class DefaultHtmlInAppMessageActionListener implements IHtmlInAppMessageActionListener {
    @Override // com.braze.ui.inappmessage.listeners.IHtmlInAppMessageActionListener
    public /* synthetic */ void onCloseClicked(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        a.a(this, iInAppMessage, str, bundle);
    }

    @Override // com.braze.ui.inappmessage.listeners.IHtmlInAppMessageActionListener
    public /* synthetic */ boolean onCustomEventFired(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        return a.b(this, iInAppMessage, str, bundle);
    }

    @Override // com.braze.ui.inappmessage.listeners.IHtmlInAppMessageActionListener
    public /* synthetic */ boolean onNewsfeedClicked(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        return a.c(this, iInAppMessage, str, bundle);
    }

    @Override // com.braze.ui.inappmessage.listeners.IHtmlInAppMessageActionListener
    public /* synthetic */ boolean onOtherUrlAction(IInAppMessage iInAppMessage, String str, Bundle bundle) {
        return a.d(this, iInAppMessage, str, bundle);
    }
}
