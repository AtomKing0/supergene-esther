package com.braze.ui.inappmessage.jsinterface;

import android.content.Context;
import android.webkit.JavascriptInterface;
import androidx.annotation.VisibleForTesting;
import com.braze.Braze;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.models.inappmessage.IInAppMessageHtml;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeLogger;
import com.braze.support.PermissionUtils;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import h9.a;
import h9.p;
import java.math.BigDecimal;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.f3;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: InAppMessageJavascriptInterface.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InAppMessageJavascriptInterface {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private final Context context;

    @NotNull
    private final IInAppMessageHtml inAppMessage;

    @NotNull
    private final InAppMessageUserJavascriptInterface user;
    private boolean wasCloseMessageCalled;

    /* JADX INFO: compiled from: InAppMessageJavascriptInterface.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageJavascriptInterface$parseProperties$1, reason: invalid class name */
    /* JADX INFO: compiled from: InAppMessageJavascriptInterface.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        final /* synthetic */ String $propertiesJSON;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str) {
            super(0);
            this.$propertiesJSON = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to parse properties JSON String: " + this.$propertiesJSON;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageJavascriptInterface$requestPushPermission$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InAppMessageJavascriptInterface.kt */
    @f(c = "com.braze.ui.inappmessage.jsinterface.InAppMessageJavascriptInterface$requestPushPermission$1", f = "InAppMessageJavascriptInterface.kt", l = {90}, m = "invokeSuspend")
    static final class C12031 extends l implements h9.l<d<? super k0>, Object> {
        int label;

        /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageJavascriptInterface$requestPushPermission$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: InAppMessageJavascriptInterface.kt */
        @f(c = "com.braze.ui.inappmessage.jsinterface.InAppMessageJavascriptInterface$requestPushPermission$1$1", f = "InAppMessageJavascriptInterface.kt", l = {93}, m = "invokeSuspend")
        static final class C01841 extends l implements p<o0, d<? super k0>, Object> {
            private /* synthetic */ Object L$0;
            int label;

            /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageJavascriptInterface$requestPushPermission$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: InAppMessageJavascriptInterface.kt */
            static final class C01851 extends v implements a<String> {
                public static final C01851 INSTANCE = new C01851();

                C01851() {
                    super(0);
                }

                @Override // h9.a
                @NotNull
                public final String invoke() {
                    return "Waiting for IAM to be fully closed before requesting push prompt";
                }
            }

            C01841(d<? super C01841> dVar) {
                super(2, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                C01841 c01841 = new C01841(dVar);
                c01841.L$0 = obj;
                return c01841;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this.L$0, BrazeLogger.Priority.V, (Throwable) null, false, (a) C01851.INSTANCE, 6, (Object) null);
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                while (BrazeInAppMessageManager.Companion.getInstance().isCurrentlyDisplayingInAppMessage()) {
                    this.label = 1;
                    if (y0.a(25L, this) == objE) {
                        return objE;
                    }
                }
                return k0.f35197a;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
                return ((C01841) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX INFO: renamed from: com.braze.ui.inappmessage.jsinterface.InAppMessageJavascriptInterface$requestPushPermission$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: InAppMessageJavascriptInterface.kt */
        static final class AnonymousClass2 extends v implements a<String> {
            public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

            AnonymousClass2() {
                super(0);
            }

            @Override // h9.a
            @NotNull
            public final String invoke() {
                return "Requesting push prompt from Braze bridge html interface";
            }
        }

        C12031(d<? super C12031> dVar) {
            super(1, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@NotNull d<?> dVar) {
            return InAppMessageJavascriptInterface.this.new C12031(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                if (InAppMessageJavascriptInterface.this.getWasCloseMessageCalled()) {
                    C01841 c01841 = new C01841(null);
                    this.label = 1;
                    if (f3.c(2500L, c01841, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) InAppMessageJavascriptInterface.this, BrazeLogger.Priority.V, (Throwable) null, false, (a) AnonymousClass2.INSTANCE, 6, (Object) null);
            PermissionUtils.requestPushPermissionPrompt(BrazeInAppMessageManager.Companion.getInstance().getActivity());
            return k0.f35197a;
        }

        @Override // h9.l
        @Nullable
        public final Object invoke(@Nullable d<? super k0> dVar) {
            return ((C12031) create(dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public InAppMessageJavascriptInterface(@NotNull Context context, @NotNull IInAppMessageHtml inAppMessage) {
        t.i(context, "context");
        t.i(inAppMessage, "inAppMessage");
        this.context = context;
        this.inAppMessage = inAppMessage;
        this.user = new InAppMessageUserJavascriptInterface(context);
    }

    @JavascriptInterface
    public final void beforeMessageClosed() {
        this.wasCloseMessageCalled = true;
    }

    @JavascriptInterface
    public final void changeUser(@NotNull String userId, @Nullable String str) {
        t.i(userId, "userId");
        Braze.Companion.getInstance(this.context).changeUser(userId, str);
    }

    @JavascriptInterface
    @NotNull
    public final InAppMessageUserJavascriptInterface getUser() {
        return this.user;
    }

    public final boolean getWasCloseMessageCalled() {
        return this.wasCloseMessageCalled;
    }

    @JavascriptInterface
    public final void logButtonClick(@Nullable String str) {
        if (str != null) {
            this.inAppMessage.logButtonClick(str);
        }
    }

    @JavascriptInterface
    public final void logClick() {
        this.inAppMessage.logClick();
    }

    @JavascriptInterface
    public final void logCustomEventWithJSON(@Nullable String str, @Nullable String str2) {
        Braze.Companion.getInstance(this.context).logCustomEvent(str, parseProperties(str2));
    }

    @JavascriptInterface
    public final void logPurchaseWithJSON(@Nullable String str, double d10, @Nullable String str2, int i10, @Nullable String str3) {
        Braze.Companion.getInstance(this.context).logPurchase(str, str2, new BigDecimal(String.valueOf(d10)), i10, parseProperties(str3));
    }

    @VisibleForTesting
    @Nullable
    public final BrazeProperties parseProperties(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            if (t.d(str, "undefined") || t.d(str, "null")) {
                return null;
            }
            return new BrazeProperties(new JSONObject(str));
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) new AnonymousClass1(str), 4, (Object) null);
            return null;
        }
    }

    @JavascriptInterface
    public final void requestImmediateDataFlush() {
        Braze.Companion.getInstance(this.context).requestImmediateDataFlush();
    }

    @JavascriptInterface
    public final void requestPushPermission() {
        BrazeInAppMessageManager.Companion.getInstance().setShouldNextUnregisterBeSkipped(true);
        BrazeCoroutineScope.launchDelayed$default(BrazeCoroutineScope.INSTANCE, 75L, null, new C12031(null), 2, null);
    }
}
