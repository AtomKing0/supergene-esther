package com.braze.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.enums.Channel;
import com.braze.support.BrazeLogger;
import com.braze.ui.actions.NewsfeedAction;
import com.braze.ui.actions.UriAction;
import h9.a;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;

/* JADX INFO: compiled from: BrazeDeeplinkHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public class BrazeDeeplinkHandler implements IBrazeDeeplinkHandler {

    @Nullable
    private static volatile IBrazeDeeplinkHandler customHandler;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final IBrazeDeeplinkHandler defaultHandler = new BrazeDeeplinkHandler();

    /* JADX INFO: compiled from: BrazeDeeplinkHandler.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final IBrazeDeeplinkHandler getInstance() {
            IBrazeDeeplinkHandler iBrazeDeeplinkHandler = BrazeDeeplinkHandler.customHandler;
            return iBrazeDeeplinkHandler == null ? BrazeDeeplinkHandler.defaultHandler : iBrazeDeeplinkHandler;
        }
    }

    /* JADX INFO: compiled from: BrazeDeeplinkHandler.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IBrazeDeeplinkHandler.IntentFlagPurpose.values().length];
            try {
                iArr[IBrazeDeeplinkHandler.IntentFlagPurpose.NOTIFICATION_ACTION_WITH_DEEPLINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IBrazeDeeplinkHandler.IntentFlagPurpose.NOTIFICATION_PUSH_STORY_PAGE_CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_OPEN_WITH_WEBVIEW_ACTIVITY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_OPEN_WITH_ACTION_VIEW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[IBrazeDeeplinkHandler.IntentFlagPurpose.URI_UTILS_GET_MAIN_ACTIVITY_INTENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_BACK_STACK_GET_ROOT_INTENT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_BACK_STACK_ONLY_GET_TARGET_INTENT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.BrazeDeeplinkHandler$createUriActionFromUrlString$1, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeDeeplinkHandler.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "createUriActionFromUrlString url was null. Returning null.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.BrazeDeeplinkHandler$createUriActionFromUrlString$2, reason: invalid class name */
    /* JADX INFO: compiled from: BrazeDeeplinkHandler.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "createUriActionFromUrlString failed. Returning null.";
        }
    }

    @Override // com.braze.IBrazeDeeplinkHandler
    @NotNull
    public UriAction createUriActionFromUri(@NotNull Uri uri, @Nullable Bundle bundle, boolean z10, @NotNull Channel channel) {
        t.i(uri, "uri");
        t.i(channel, "channel");
        return new UriAction(uri, bundle, z10, channel);
    }

    @Override // com.braze.IBrazeDeeplinkHandler
    @Nullable
    public UriAction createUriActionFromUrlString(@NotNull String url, @Nullable Bundle bundle, boolean z10, @NotNull Channel channel) {
        t.i(url, "url");
        t.i(channel, "channel");
        UriAction uriActionCreateUriActionFromUri = null;
        try {
            if (!q.z(url)) {
                Uri uri = Uri.parse(url);
                t.h(uri, "uri");
                uriActionCreateUriActionFromUri = createUriActionFromUri(uri, bundle, z10, channel);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) null, false, (a) AnonymousClass1.INSTANCE, 6, (Object) null);
            }
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) AnonymousClass2.INSTANCE, 4, (Object) null);
        }
        return uriActionCreateUriActionFromUri;
    }

    @Override // com.braze.IBrazeDeeplinkHandler
    public int getIntentFlags(@NotNull IBrazeDeeplinkHandler.IntentFlagPurpose intentFlagPurpose) {
        t.i(intentFlagPurpose, "intentFlagPurpose");
        switch (WhenMappings.$EnumSwitchMapping$0[intentFlagPurpose.ordinal()]) {
            case 1:
            case 2:
                return 1073741824;
            case 3:
            case 4:
            case 5:
                return 872415232;
            case 6:
            case 7:
                return 268435456;
            default:
                throw new v8.q();
        }
    }

    @Override // com.braze.IBrazeDeeplinkHandler
    public void gotoNewsFeed(@NotNull Context context, @NotNull NewsfeedAction newsfeedAction) {
        t.i(context, "context");
        t.i(newsfeedAction, "newsfeedAction");
        newsfeedAction.execute(context);
    }

    @Override // com.braze.IBrazeDeeplinkHandler
    public void gotoUri(@NotNull Context context, @NotNull UriAction uriAction) {
        t.i(context, "context");
        t.i(uriAction, "uriAction");
        uriAction.execute(context);
    }
}
