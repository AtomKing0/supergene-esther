package com.braze.ui.inappmessage.listeners;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.enums.Channel;
import com.braze.enums.inappmessage.ClickAction;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageHtml;
import com.braze.models.inappmessage.IInAppMessageImmersive;
import com.braze.models.inappmessage.MessageButton;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeFunctionNotImplemented;
import com.braze.support.BrazeLogger;
import com.braze.support.BundleUtils;
import com.braze.support.WebContentUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.actions.NewsfeedAction;
import com.braze.ui.actions.UriAction;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.InAppMessageCloser;
import h9.a;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: DefaultInAppMessageViewLifecycleListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public class DefaultInAppMessageViewLifecycleListener implements IInAppMessageViewLifecycleListener {

    /* JADX INFO: compiled from: DefaultInAppMessageViewLifecycleListener.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ClickAction.values().length];
            try {
                iArr[ClickAction.NEWS_FEED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClickAction.URI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ClickAction.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener$afterClosed$1, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultInAppMessageViewLifecycleListener.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "IInAppMessageViewLifecycleListener.afterClosed called.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener$afterOpened$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageViewLifecycleListener.kt */
    static final class C12301 extends v implements a<String> {
        public static final C12301 INSTANCE = new C12301();

        C12301() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "IInAppMessageViewLifecycleListener.afterOpened called.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener$beforeClosed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageViewLifecycleListener.kt */
    static final class C12311 extends v implements a<String> {
        public static final C12311 INSTANCE = new C12311();

        C12311() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "IInAppMessageViewLifecycleListener.beforeClosed called.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener$beforeOpened$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageViewLifecycleListener.kt */
    static final class C12321 extends v implements a<String> {
        public static final C12321 INSTANCE = new C12321();

        C12321() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "IInAppMessageViewLifecycleListener.beforeOpened called.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener$onButtonClicked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageViewLifecycleListener.kt */
    static final class C12331 extends v implements a<String> {
        public static final C12331 INSTANCE = new C12331();

        C12331() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "IInAppMessageViewLifecycleListener.onButtonClicked called.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener$onClicked$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageViewLifecycleListener.kt */
    static final class C12341 extends v implements a<String> {
        public static final C12341 INSTANCE = new C12341();

        C12341() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "IInAppMessageViewLifecycleListener.onClicked called.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener$onDismissed$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageViewLifecycleListener.kt */
    static final class C12351 extends v implements a<String> {
        public static final C12351 INSTANCE = new C12351();

        C12351() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "IInAppMessageViewLifecycleListener.onDismissed called.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener$performClickAction$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageViewLifecycleListener.kt */
    static final class C12361 extends v implements a<String> {
        public static final C12361 INSTANCE = new C12361();

        C12361() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Can't perform click action because the cached activity is null.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener$performClickAction$2, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultInAppMessageViewLifecycleListener.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "clickUri is null, not performing click action";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener$performClickAction$3, reason: invalid class name */
    /* JADX INFO: compiled from: DefaultInAppMessageViewLifecycleListener.kt */
    static final class AnonymousClass3 extends v implements a<String> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        AnonymousClass3() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "appContext is null, not performing click action";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener$startClearHtmlInAppMessageAssetsThread$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DefaultInAppMessageViewLifecycleListener.kt */
    @f(c = "com.braze.ui.inappmessage.listeners.DefaultInAppMessageViewLifecycleListener$startClearHtmlInAppMessageAssetsThread$1", f = "DefaultInAppMessageViewLifecycleListener.kt", l = {}, m = "invokeSuspend")
    static final class C12371 extends l implements p<o0, d<? super k0>, Object> {
        int label;

        C12371(d<? super C12371> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new C12371(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            Activity activity = BrazeInAppMessageManager.Companion.getInstance().getActivity();
            if (activity != null) {
                BrazeFileUtils.deleteFileOrDirectory(WebContentUtils.getHtmlInAppMessageAssetCacheDirectory(activity));
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C12371) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    private final BrazeInAppMessageManager getInAppMessageManager() {
        return BrazeInAppMessageManager.Companion.getInstance();
    }

    private final void performClickAction(ClickAction clickAction, IInAppMessage iInAppMessage, InAppMessageCloser inAppMessageCloser, Uri uri, boolean z10) {
        Activity activity = getInAppMessageManager().getActivity();
        if (activity == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (a) C12361.INSTANCE, 6, (Object) null);
            return;
        }
        int i10 = WhenMappings.$EnumSwitchMapping$0[clickAction.ordinal()];
        if (i10 == 1) {
            inAppMessageCloser.close(false);
            BrazeDeeplinkHandler.Companion.getInstance().gotoNewsFeed(activity, new NewsfeedAction(BundleUtils.toBundle(iInAppMessage.getExtras()), Channel.INAPP_MESSAGE));
            return;
        }
        if (i10 != 2) {
            if (i10 != 3) {
                inAppMessageCloser.close(false);
                return;
            } else {
                inAppMessageCloser.close(iInAppMessage.getAnimateOut());
                return;
            }
        }
        inAppMessageCloser.close(false);
        if (uri == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass2.INSTANCE, 7, (Object) null);
            return;
        }
        BrazeDeeplinkHandler.Companion companion = BrazeDeeplinkHandler.Companion;
        UriAction uriActionCreateUriActionFromUri = companion.getInstance().createUriActionFromUri(uri, BundleUtils.toBundle(iInAppMessage.getExtras()), z10, Channel.INAPP_MESSAGE);
        Context applicationContext = getInAppMessageManager().getApplicationContext();
        if (applicationContext == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass3.INSTANCE, 7, (Object) null);
        } else {
            companion.getInstance().gotoUri(applicationContext, uriActionCreateUriActionFromUri);
        }
    }

    private final void performInAppMessageButtonClicked(MessageButton messageButton, IInAppMessage iInAppMessage, InAppMessageCloser inAppMessageCloser) {
        performClickAction(messageButton.getClickAction(), iInAppMessage, inAppMessageCloser, messageButton.getUri(), messageButton.getOpenUriInWebview());
    }

    private final void performInAppMessageClicked(IInAppMessage iInAppMessage, InAppMessageCloser inAppMessageCloser) {
        performClickAction(iInAppMessage.getClickAction(), iInAppMessage, inAppMessageCloser, iInAppMessage.getUri(), iInAppMessage.getOpenUriInWebView());
    }

    private final void startClearHtmlInAppMessageAssetsThread() {
        k.d(BrazeCoroutineScope.INSTANCE, null, null, new C12371(null), 3, null);
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener
    public void afterClosed(@NotNull IInAppMessage inAppMessage) {
        t.i(inAppMessage, "inAppMessage");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 7, (Object) null);
        getInAppMessageManager().resetAfterInAppMessageClose();
        if (inAppMessage instanceof IInAppMessageHtml) {
            startClearHtmlInAppMessageAssetsThread();
        }
        inAppMessage.onAfterClosed();
        getInAppMessageManager().getInAppMessageManagerListener().afterInAppMessageViewClosed(inAppMessage);
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener
    public void afterOpened(@NotNull View inAppMessageView, @NotNull IInAppMessage inAppMessage) {
        t.i(inAppMessageView, "inAppMessageView");
        t.i(inAppMessage, "inAppMessage");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C12301.INSTANCE, 7, (Object) null);
        getInAppMessageManager().getInAppMessageManagerListener().afterInAppMessageViewOpened(inAppMessageView, inAppMessage);
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener
    public void beforeClosed(@NotNull View inAppMessageView, @NotNull IInAppMessage inAppMessage) {
        t.i(inAppMessageView, "inAppMessageView");
        t.i(inAppMessage, "inAppMessage");
        getInAppMessageManager().getInAppMessageManagerListener().beforeInAppMessageViewClosed(inAppMessageView, inAppMessage);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C12311.INSTANCE, 7, (Object) null);
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener
    public void beforeOpened(@NotNull View inAppMessageView, @NotNull IInAppMessage inAppMessage) {
        t.i(inAppMessageView, "inAppMessageView");
        t.i(inAppMessage, "inAppMessage");
        getInAppMessageManager().getInAppMessageManagerListener().beforeInAppMessageViewOpened(inAppMessageView, inAppMessage);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C12321.INSTANCE, 7, (Object) null);
        inAppMessage.logImpression();
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener
    public void onButtonClicked(@NotNull InAppMessageCloser inAppMessageCloser, @NotNull MessageButton messageButton, @NotNull IInAppMessageImmersive inAppMessageImmersive) {
        boolean zOnInAppMessageButtonClicked;
        t.i(inAppMessageCloser, "inAppMessageCloser");
        t.i(messageButton, "messageButton");
        t.i(inAppMessageImmersive, "inAppMessageImmersive");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C12331.INSTANCE, 7, (Object) null);
        inAppMessageImmersive.logButtonClick(messageButton);
        try {
            zOnInAppMessageButtonClicked = getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageButtonClicked(inAppMessageImmersive, messageButton, inAppMessageCloser);
        } catch (BrazeFunctionNotImplemented unused) {
            zOnInAppMessageButtonClicked = getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageButtonClicked(inAppMessageImmersive, messageButton);
        }
        if (zOnInAppMessageButtonClicked) {
            return;
        }
        performInAppMessageButtonClicked(messageButton, inAppMessageImmersive, inAppMessageCloser);
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener
    public void onClicked(@NotNull InAppMessageCloser inAppMessageCloser, @NotNull View inAppMessageView, @NotNull IInAppMessage inAppMessage) {
        boolean zOnInAppMessageClicked;
        t.i(inAppMessageCloser, "inAppMessageCloser");
        t.i(inAppMessageView, "inAppMessageView");
        t.i(inAppMessage, "inAppMessage");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C12341.INSTANCE, 7, (Object) null);
        inAppMessage.logClick();
        try {
            zOnInAppMessageClicked = getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageClicked(inAppMessage, inAppMessageCloser);
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) DefaultInAppMessageViewLifecycleListener$onClicked$wasHandled$1.INSTANCE, 7, (Object) null);
        } catch (BrazeFunctionNotImplemented unused) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) DefaultInAppMessageViewLifecycleListener$onClicked$wasHandled$2.INSTANCE, 7, (Object) null);
            zOnInAppMessageClicked = getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageClicked(inAppMessage);
        }
        if (zOnInAppMessageClicked) {
            return;
        }
        performInAppMessageClicked(inAppMessage, inAppMessageCloser);
    }

    @Override // com.braze.ui.inappmessage.listeners.IInAppMessageViewLifecycleListener
    public void onDismissed(@NotNull View inAppMessageView, @NotNull IInAppMessage inAppMessage) {
        t.i(inAppMessageView, "inAppMessageView");
        t.i(inAppMessage, "inAppMessage");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) C12351.INSTANCE, 7, (Object) null);
        getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageDismissed(inAppMessage);
    }
}
