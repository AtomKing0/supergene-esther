package com.braze.ui.inappmessage.factories;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.braze.BrazeInternal;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageHtml;
import com.braze.support.BrazeLogger;
import com.braze.ui.R$layout;
import com.braze.ui.inappmessage.IInAppMessageViewFactory;
import com.braze.ui.inappmessage.jsinterface.InAppMessageJavascriptInterface;
import com.braze.ui.inappmessage.listeners.IInAppMessageWebViewClientListener;
import com.braze.ui.inappmessage.utils.InAppMessageWebViewClient;
import com.braze.ui.inappmessage.views.InAppMessageHtmlBaseView;
import com.braze.ui.inappmessage.views.InAppMessageHtmlView;
import com.braze.ui.support.ViewUtils;
import h9.a;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: DefaultInAppMessageHtmlViewFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public class DefaultInAppMessageHtmlViewFactory implements IInAppMessageViewFactory {

    @NotNull
    private final IInAppMessageWebViewClientListener inAppMessageWebViewClientListener;

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.factories.DefaultInAppMessageHtmlViewFactory$createInAppMessageView$1, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultInAppMessageHtmlViewFactory.kt */
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

    public DefaultInAppMessageHtmlViewFactory(@NotNull IInAppMessageWebViewClientListener inAppMessageWebViewClientListener) {
        t.i(inAppMessageWebViewClientListener, "inAppMessageWebViewClientListener");
        this.inAppMessageWebViewClientListener = inAppMessageWebViewClientListener;
    }

    @Override // com.braze.ui.inappmessage.IInAppMessageViewFactory
    @SuppressLint({"AddJavascriptInterface"})
    @Nullable
    public InAppMessageHtmlView createInAppMessageView(@NotNull Activity activity, @NotNull IInAppMessage inAppMessage) {
        t.i(activity, "activity");
        t.i(inAppMessage, "inAppMessage");
        Context context = activity.getApplicationContext();
        View viewInflate = activity.getLayoutInflater().inflate(R$layout.com_braze_inappmessage_html, (ViewGroup) null);
        t.g(viewInflate, "null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageHtmlView");
        InAppMessageHtmlView inAppMessageHtmlView = (InAppMessageHtmlView) viewInflate;
        BrazeInternal brazeInternal = BrazeInternal.INSTANCE;
        t.h(context, "context");
        if (brazeInternal.getConfigurationProvider(context).isTouchModeRequiredForHtmlInAppMessages() && ViewUtils.isDeviceNotInTouchMode(inAppMessageHtmlView)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 6, (Object) null);
            return null;
        }
        InAppMessageHtml inAppMessageHtml = (InAppMessageHtml) inAppMessage;
        InAppMessageJavascriptInterface inAppMessageJavascriptInterface = new InAppMessageJavascriptInterface(context, inAppMessageHtml);
        InAppMessageHtmlBaseView.setWebViewContent$default(inAppMessageHtmlView, inAppMessageHtml.getMessage(), null, 2, null);
        Context applicationContext = activity.getApplicationContext();
        t.h(applicationContext, "activity.applicationContext");
        inAppMessageHtmlView.setInAppMessageWebViewClient(new InAppMessageWebViewClient(applicationContext, inAppMessageHtml, this.inAppMessageWebViewClientListener, null, 8, null));
        WebView messageWebView = inAppMessageHtmlView.getMessageWebView();
        if (messageWebView != null) {
            messageWebView.addJavascriptInterface(inAppMessageJavascriptInterface, "brazeInternalBridge");
        }
        inAppMessageHtmlView.setupDirectionalNavigation();
        return inAppMessageHtmlView;
    }
}
