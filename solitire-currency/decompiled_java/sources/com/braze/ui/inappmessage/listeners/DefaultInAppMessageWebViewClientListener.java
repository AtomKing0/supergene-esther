package com.braze.ui.inappmessage.listeners;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.braze.Braze;
import com.braze.enums.Channel;
import com.braze.enums.inappmessage.MessageType;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageHtml;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.BundleUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.actions.NewsfeedAction;
import com.braze.ui.actions.UriAction;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import h9.a;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;

/* JADX INFO: compiled from: DefaultInAppMessageWebViewClientListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public class DefaultInAppMessageWebViewClientListener implements IInAppMessageWebViewClientListener {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: DefaultInAppMessageWebViewClientListener.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @VisibleForTesting
        public final void logHtmlInAppMessageClick(@NotNull IInAppMessage inAppMessage, @NotNull Bundle queryBundle) {
            t.i(inAppMessage, "inAppMessage");
            t.i(queryBundle, "queryBundle");
            if (!queryBundle.containsKey("abButtonId")) {
                if (inAppMessage.getMessageType() == MessageType.HTML_FULL) {
                    inAppMessage.logClick();
                }
            } else {
                IInAppMessageHtml iInAppMessageHtml = (IInAppMessageHtml) inAppMessage;
                String string = queryBundle.getString("abButtonId");
                if (string != null) {
                    iInAppMessageHtml.logButtonClick(string);
                }
            }
        }

        @VisibleForTesting
        @Nullable
        public final String parseCustomEventNameFromQueryBundle(@NotNull Bundle queryBundle) {
            t.i(queryBundle, "queryBundle");
            return queryBundle.getString("name");
        }

        @VisibleForTesting
        @NotNull
        public final BrazeProperties parsePropertiesFromQueryBundle(@NotNull Bundle queryBundle) {
            t.i(queryBundle, "queryBundle");
            BrazeProperties brazeProperties = new BrazeProperties();
            for (String key : queryBundle.keySet()) {
                if (!t.d(key, "name")) {
                    String string = queryBundle.getString(key, null);
                    if (!(string == null || q.z(string))) {
                        t.h(key, "key");
                        brazeProperties.addProperty(key, string);
                    }
                }
            }
            return brazeProperties;
        }

        @VisibleForTesting
        public final boolean parseUseWebViewFromQueryBundle(@NotNull IInAppMessage inAppMessage, @NotNull Bundle queryBundle) {
            boolean z10;
            boolean z11;
            boolean z12;
            t.i(inAppMessage, "inAppMessage");
            t.i(queryBundle, "queryBundle");
            if (queryBundle.containsKey("abDeepLink")) {
                z10 = Boolean.parseBoolean(queryBundle.getString("abDeepLink"));
                z11 = true;
            } else {
                z10 = false;
                z11 = false;
            }
            if (queryBundle.containsKey("abExternalOpen")) {
                z12 = Boolean.parseBoolean(queryBundle.getString("abExternalOpen"));
                z11 = true;
            } else {
                z12 = false;
            }
            boolean openUriInWebView = inAppMessage.getOpenUriInWebView();
            if (z11) {
                return (z10 || z12) ? false : true;
            }
            return openUriInWebView;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageWebViewClientListener$onCloseAction$1, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultInAppMessageWebViewClientListener.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "IInAppMessageWebViewClientListener.onCloseAction called.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageWebViewClientListener$onCloseAction$2, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultInAppMessageWebViewClientListener.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "IInAppMessageWebViewClientListener.onCloseAction finished.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageWebViewClientListener$onCustomEventAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageWebViewClientListener.kt */
    static final class C12381 extends v implements a<String> {
        public static final C12381 INSTANCE = new C12381();

        C12381() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "IInAppMessageWebViewClientListener.onCustomEventAction called.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageWebViewClientListener$onCustomEventAction$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageWebViewClientListener.kt */
    static final class C12392 extends v implements a<String> {
        public static final C12392 INSTANCE = new C12392();

        C12392() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Can't perform custom event action because the activity is null.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageWebViewClientListener$onNewsfeedAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageWebViewClientListener.kt */
    static final class C12401 extends v implements a<String> {
        public static final C12401 INSTANCE = new C12401();

        C12401() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "IInAppMessageWebViewClientListener.onNewsfeedAction called.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageWebViewClientListener$onNewsfeedAction$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageWebViewClientListener.kt */
    static final class C12412 extends v implements a<String> {
        public static final C12412 INSTANCE = new C12412();

        C12412() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Can't perform news feed action because the cached activity is null.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageWebViewClientListener$onOtherUrlAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageWebViewClientListener.kt */
    static final class C12421 extends v implements a<String> {
        public static final C12421 INSTANCE = new C12421();

        C12421() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "IInAppMessageWebViewClientListener.onOtherUrlAction called.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageWebViewClientListener$onOtherUrlAction$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageWebViewClientListener.kt */
    static final class C12432 extends v implements a<String> {
        final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12432(String str) {
            super(0);
            this.$url = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Can't perform other url action because the cached activity is null. Url: " + this.$url;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageWebViewClientListener$onOtherUrlAction$3, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultInAppMessageWebViewClientListener.kt */
    static final class AnonymousClass3 extends v implements a<String> {
        final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(String str) {
            super(0);
            this.$url = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "HTML message action listener handled url in onOtherUrlAction. Doing nothing further. Url: " + this.$url;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageWebViewClientListener$onOtherUrlAction$4, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultInAppMessageWebViewClientListener.kt */
    static final class AnonymousClass4 extends v implements a<String> {
        final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(String str) {
            super(0);
            this.$url = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "UriAction is null. Not passing any URI to BrazeDeeplinkHandler. Url: " + this.$url;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageWebViewClientListener$onOtherUrlAction$5, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultInAppMessageWebViewClientListener.kt */
    static final class AnonymousClass5 extends v implements a<String> {
        final /* synthetic */ Uri $uri;
        final /* synthetic */ String $url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(Uri uri, String str) {
            super(0);
            this.$uri = uri;
            this.$url = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Not passing local uri to BrazeDeeplinkHandler. Got local uri: " + this.$uri + " for url: " + this.$url;
        }
    }

    private final BrazeInAppMessageManager getInAppMessageManager() {
        return BrazeInAppMessageManager.Companion.getInstance();
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageWebViewClientListener
    public void onCloseAction(@NotNull IInAppMessage inAppMessage, @NotNull String url, @NotNull Bundle queryBundle) {
        t.i(inAppMessage, "inAppMessage");
        t.i(url, "url");
        t.i(queryBundle, "queryBundle");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 7, (Object) null);
        Companion.logHtmlInAppMessageClick(inAppMessage, queryBundle);
        getInAppMessageManager().hideCurrentlyDisplayingInAppMessage(true);
        getInAppMessageManager().getHtmlInAppMessageActionListener().onCloseClicked(inAppMessage, url, queryBundle);
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass2.INSTANCE, 7, (Object) null);
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageWebViewClientListener
    public void onCustomEventAction(@NotNull IInAppMessage inAppMessage, @NotNull String url, @NotNull Bundle queryBundle) {
        t.i(inAppMessage, "inAppMessage");
        t.i(url, "url");
        t.i(queryBundle, "queryBundle");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C12381.INSTANCE, 7, (Object) null);
        if (getInAppMessageManager().getActivity() == null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) C12392.INSTANCE, 6, (Object) null);
            return;
        }
        if (getInAppMessageManager().getHtmlInAppMessageActionListener().onCustomEventFired(inAppMessage, url, queryBundle)) {
            return;
        }
        Companion companion = Companion;
        String customEventNameFromQueryBundle = companion.parseCustomEventNameFromQueryBundle(queryBundle);
        if (customEventNameFromQueryBundle == null || q.z(customEventNameFromQueryBundle)) {
            return;
        }
        BrazeProperties propertiesFromQueryBundle = companion.parsePropertiesFromQueryBundle(queryBundle);
        Activity activity = getInAppMessageManager().getActivity();
        if (activity != null) {
            Braze.Companion.getInstance(activity).logCustomEvent(customEventNameFromQueryBundle, propertiesFromQueryBundle);
        }
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageWebViewClientListener
    public void onNewsfeedAction(@NotNull IInAppMessage inAppMessage, @NotNull String url, @NotNull Bundle queryBundle) {
        t.i(inAppMessage, "inAppMessage");
        t.i(url, "url");
        t.i(queryBundle, "queryBundle");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C12401.INSTANCE, 7, (Object) null);
        if (getInAppMessageManager().getActivity() == null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) C12412.INSTANCE, 6, (Object) null);
            return;
        }
        Companion.logHtmlInAppMessageClick(inAppMessage, queryBundle);
        if (getInAppMessageManager().getHtmlInAppMessageActionListener().onNewsfeedClicked(inAppMessage, url, queryBundle)) {
            return;
        }
        inAppMessage.setAnimateOut(false);
        getInAppMessageManager().hideCurrentlyDisplayingInAppMessage(false);
        NewsfeedAction newsfeedAction = new NewsfeedAction(BundleUtils.toBundle(inAppMessage.getExtras()), Channel.INAPP_MESSAGE);
        Activity activity = getInAppMessageManager().getActivity();
        if (activity != null) {
            BrazeDeeplinkHandler.Companion.getInstance().gotoNewsFeed(activity, newsfeedAction);
        }
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageWebViewClientListener
    public void onOtherUrlAction(@NotNull IInAppMessage inAppMessage, @NotNull String url, @NotNull Bundle queryBundle) {
        t.i(inAppMessage, "inAppMessage");
        t.i(url, "url");
        t.i(queryBundle, "queryBundle");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C12421.INSTANCE, 7, (Object) null);
        if (getInAppMessageManager().getActivity() == null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) new C12432(url), 6, (Object) null);
            return;
        }
        Companion companion = Companion;
        companion.logHtmlInAppMessageClick(inAppMessage, queryBundle);
        if (getInAppMessageManager().getHtmlInAppMessageActionListener().onOtherUrlAction(inAppMessage, url, queryBundle)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new AnonymousClass3(url), 6, (Object) null);
            return;
        }
        boolean useWebViewFromQueryBundle = companion.parseUseWebViewFromQueryBundle(inAppMessage, queryBundle);
        Bundle bundle = BundleUtils.toBundle(inAppMessage.getExtras());
        bundle.putAll(queryBundle);
        BrazeDeeplinkHandler.Companion companion2 = BrazeDeeplinkHandler.Companion;
        UriAction uriActionCreateUriActionFromUrlString = companion2.getInstance().createUriActionFromUrlString(url, bundle, useWebViewFromQueryBundle, Channel.INAPP_MESSAGE);
        if (uriActionCreateUriActionFromUrlString == null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) new AnonymousClass4(url), 6, (Object) null);
            return;
        }
        Uri uri = uriActionCreateUriActionFromUrlString.getUri();
        if (BrazeFileUtils.isLocalUri(uri)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) new AnonymousClass5(uri, url), 6, (Object) null);
            return;
        }
        inAppMessage.setAnimateOut(false);
        getInAppMessageManager().hideCurrentlyDisplayingInAppMessage(false);
        Activity activity = getInAppMessageManager().getActivity();
        if (activity != null) {
            companion2.getInstance().gotoUri(activity, uriActionCreateUriActionFromUrlString);
        }
    }
}
