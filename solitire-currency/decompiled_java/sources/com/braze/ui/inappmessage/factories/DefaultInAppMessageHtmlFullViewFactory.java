package com.braze.ui.inappmessage.factories;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageHtmlFull;
import com.braze.support.BrazeLogger;
import com.braze.ui.R$layout;
import com.braze.ui.inappmessage.IInAppMessageViewFactory;
import com.braze.ui.inappmessage.jsinterface.InAppMessageJavascriptInterface;
import com.braze.ui.inappmessage.listeners.IInAppMessageWebViewClientListener;
import com.braze.ui.inappmessage.utils.InAppMessageWebViewClient;
import com.braze.ui.inappmessage.views.InAppMessageHtmlFullView;
import com.braze.ui.support.ViewUtils;
import h9.a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DefaultInAppMessageHtmlFullViewFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public class DefaultInAppMessageHtmlFullViewFactory implements IInAppMessageViewFactory {

    @NotNull
    private final IInAppMessageWebViewClientListener inAppMessageWebViewClientListener;

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.factories.DefaultInAppMessageHtmlFullViewFactory$createInAppMessageView$1, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultInAppMessageHtmlFullViewFactory.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "The device is not currently in touch mode. This message requires user touch interaction to display properly. Please set setIsTouchModeRequiredForHtmlInAppMessages to false to change this behavior.";
        }
    }

    public DefaultInAppMessageHtmlFullViewFactory(@NotNull IInAppMessageWebViewClientListener inAppMessageWebViewClientListener) {
        t.i(inAppMessageWebViewClientListener, "inAppMessageWebViewClientListener");
        this.inAppMessageWebViewClientListener = inAppMessageWebViewClientListener;
    }

    @Override // com.braze.ui.inappmessage.IInAppMessageViewFactory
    @SuppressLint({"AddJavascriptInterface"})
    @Nullable
    public InAppMessageHtmlFullView createInAppMessageView(@NotNull Activity activity, @NotNull IInAppMessage inAppMessage) {
        t.i(activity, "activity");
        t.i(inAppMessage, "inAppMessage");
        View viewInflate = activity.getLayoutInflater().inflate(R$layout.com_braze_inappmessage_html_full, (ViewGroup) null);
        t.g(viewInflate, "null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageHtmlFullView");
        InAppMessageHtmlFullView inAppMessageHtmlFullView = (InAppMessageHtmlFullView) viewInflate;
        Context applicationContext = activity.getApplicationContext();
        t.h(applicationContext, "activity.applicationContext");
        if (new BrazeConfigurationProvider(applicationContext).isTouchModeRequiredForHtmlInAppMessages() && ViewUtils.isDeviceNotInTouchMode(inAppMessageHtmlFullView)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 6, (Object) null);
            return null;
        }
        Context context = activity.getApplicationContext();
        InAppMessageHtmlFull inAppMessageHtmlFull = (InAppMessageHtmlFull) inAppMessage;
        t.h(context, "context");
        InAppMessageJavascriptInterface inAppMessageJavascriptInterface = new InAppMessageJavascriptInterface(context, inAppMessageHtmlFull);
        inAppMessageHtmlFullView.setWebViewContent(inAppMessage.getMessage(), inAppMessageHtmlFull.getLocalAssetsDirectoryUrl());
        inAppMessageHtmlFullView.setInAppMessageWebViewClient(new InAppMessageWebViewClient(context, inAppMessage, this.inAppMessageWebViewClientListener, inAppMessageHtmlFull.getLocalAssetsDirectoryUrl()));
        WebView messageWebView = inAppMessageHtmlFullView.getMessageWebView();
        if (messageWebView != null) {
            messageWebView.addJavascriptInterface(inAppMessageJavascriptInterface, "brazeInternalBridge");
        }
        inAppMessageHtmlFullView.setupDirectionalNavigation();
        return inAppMessageHtmlFullView;
    }
}
