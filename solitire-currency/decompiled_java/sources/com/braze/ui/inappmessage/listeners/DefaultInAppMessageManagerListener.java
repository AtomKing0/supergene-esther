package com.braze.ui.inappmessage.listeners;

import android.content.Context;
import android.view.View;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageThemeable;
import com.braze.models.inappmessage.MessageButton;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.InAppMessageCloser;
import com.braze.ui.inappmessage.InAppMessageOperation;
import com.braze.ui.support.ViewUtils;
import kotlin.jvm.internal.t;
import o0.b;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DefaultInAppMessageManagerListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public class DefaultInAppMessageManagerListener implements IInAppMessageManagerListener {
    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public /* synthetic */ void afterInAppMessageViewClosed(IInAppMessage iInAppMessage) {
        b.a(this, iInAppMessage);
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public /* synthetic */ void afterInAppMessageViewOpened(View view, IInAppMessage iInAppMessage) {
        b.b(this, view, iInAppMessage);
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    @NotNull
    public InAppMessageOperation beforeInAppMessageDisplayed(@NotNull IInAppMessage inAppMessage) {
        Context applicationContext;
        t.i(inAppMessage, "inAppMessage");
        if ((inAppMessage instanceof IInAppMessageThemeable) && (applicationContext = BrazeInAppMessageManager.Companion.getInstance().getApplicationContext()) != null && ViewUtils.isDeviceInNightMode(applicationContext)) {
            ((IInAppMessageThemeable) inAppMessage).enableDarkTheme();
        }
        return InAppMessageOperation.DISPLAY_NOW;
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public /* synthetic */ void beforeInAppMessageViewClosed(View view, IInAppMessage iInAppMessage) {
        b.c(this, view, iInAppMessage);
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public /* synthetic */ void beforeInAppMessageViewOpened(View view, IInAppMessage iInAppMessage) {
        b.d(this, view, iInAppMessage);
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public /* synthetic */ boolean onInAppMessageButtonClicked(IInAppMessage iInAppMessage, MessageButton messageButton) {
        return b.e(this, iInAppMessage, messageButton);
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public /* synthetic */ boolean onInAppMessageClicked(IInAppMessage iInAppMessage) {
        return b.g(this, iInAppMessage);
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public /* synthetic */ void onInAppMessageDismissed(IInAppMessage iInAppMessage) {
        b.i(this, iInAppMessage);
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public /* synthetic */ boolean onInAppMessageButtonClicked(IInAppMessage iInAppMessage, MessageButton messageButton, InAppMessageCloser inAppMessageCloser) {
        return b.f(this, iInAppMessage, messageButton, inAppMessageCloser);
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageManagerListener
    public /* synthetic */ boolean onInAppMessageClicked(IInAppMessage iInAppMessage, InAppMessageCloser inAppMessageCloser) {
        return b.h(this, iInAppMessage, inAppMessageCloser);
    }
}
