package com.braze.ui.actions;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.braze.BrazeInternal;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.Channel;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.BrazeWebViewActivity;
import com.braze.ui.actions.brazeactions.BrazeActionParser;
import com.braze.ui.support.UriUtils;
import h9.a;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.q;

/* JADX INFO: compiled from: UriAction.kt */
/* JADX INFO: loaded from: classes2.dex */
public class UriAction implements IAction {

    @NotNull
    private final Channel channel;

    @Nullable
    private final Bundle extras;

    @NotNull
    private Uri uri;
    private boolean useWebView;

    /* JADX INFO: renamed from: com.braze.ui.actions.UriAction$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: UriAction.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        AnonymousClass1() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Not executing local Uri: " + UriAction.this.getUri();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.UriAction$execute$2, reason: invalid class name */
    /* JADX INFO: compiled from: UriAction.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        AnonymousClass2() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Executing BrazeActions uri:\n'" + UriAction.this.getUri() + '\'';
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.UriAction$execute$3, reason: invalid class name */
    /* JADX INFO: compiled from: UriAction.kt */
    static final class AnonymousClass3 extends v implements a<String> {
        AnonymousClass3() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Executing Uri action from channel " + UriAction.this.getChannel() + ": " + UriAction.this.getUri() + ". UseWebView: " + UriAction.this.getUseWebView() + ". Extras: " + UriAction.this.getExtras();
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.UriAction$getActionViewIntent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UriAction.kt */
    static final class C11421 extends v implements a<String> {
        final /* synthetic */ ResolveInfo $resolveInfo;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11421(ResolveInfo resolveInfo) {
            super(0);
            this.$resolveInfo = resolveInfo;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Setting deep link intent package to " + this.$resolveInfo.activityInfo.packageName + '.';
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.UriAction$getIntentArrayWithConfiguredBackStack$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UriAction.kt */
    static final class C11431 extends v implements a<String> {
        public static final C11431 INSTANCE = new C11431();

        C11431() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Adding main activity intent to back stack while opening uri from push";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.UriAction$getIntentArrayWithConfiguredBackStack$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UriAction.kt */
    static final class C11442 extends v implements a<String> {
        final /* synthetic */ String $activityClass;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11442(String str) {
            super(0);
            this.$activityClass = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Adding custom back stack activity while opening uri from push: " + this.$activityClass;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.UriAction$getIntentArrayWithConfiguredBackStack$4, reason: invalid class name */
    /* JADX INFO: compiled from: UriAction.kt */
    static final class AnonymousClass4 extends v implements a<String> {
        final /* synthetic */ String $activityClass;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(String str) {
            super(0);
            this.$activityClass = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Not adding unregistered activity to the back stack while opening uri from push: " + this.$activityClass;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.UriAction$getIntentArrayWithConfiguredBackStack$5, reason: invalid class name */
    /* JADX INFO: compiled from: UriAction.kt */
    static final class AnonymousClass5 extends v implements a<String> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        AnonymousClass5() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Not adding back stack activity while opening uri from push due to disabled configuration setting.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.UriAction$openUriWithActionView$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UriAction.kt */
    static final class C11451 extends v implements a<String> {
        final /* synthetic */ Bundle $extras;
        final /* synthetic */ Uri $uri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11451(Uri uri, Bundle bundle) {
            super(0);
            this.$uri = uri;
            this.$extras = bundle;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to handle uri " + this.$uri + " with extras: " + this.$extras;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.UriAction$openUriWithActionViewFromPush$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UriAction.kt */
    static final class C11461 extends v implements a<String> {
        final /* synthetic */ Uri $uri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C11461(Uri uri) {
            super(0);
            this.$uri = uri;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Could not find appropriate activity to open for deep link " + this.$uri;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.UriAction$openUriWithWebViewActivity$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UriAction.kt */
    static final class C11471 extends v implements a<String> {
        public static final C11471 INSTANCE = new C11471();

        C11471() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "BrazeWebViewActivity not opened successfully.";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.actions.UriAction$openUriWithWebViewActivityFromPush$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UriAction.kt */
    static final class C11481 extends v implements a<String> {
        public static final C11481 INSTANCE = new C11481();

        C11481() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Braze WebView Activity not opened successfully.";
        }
    }

    public UriAction(@NotNull Uri uri, @Nullable Bundle bundle, boolean z10, @NotNull Channel channel) {
        t.i(uri, "uri");
        t.i(channel, "channel");
        this.uri = uri;
        this.extras = bundle;
        this.useWebView = z10;
        this.channel = channel;
    }

    @Override // com.braze.ui.actions.IAction
    public void execute(@NotNull Context context) {
        t.i(context, "context");
        if (BrazeFileUtils.isLocalUri(this.uri)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass1(), 7, (Object) null);
            return;
        }
        BrazeActionParser brazeActionParser = BrazeActionParser.INSTANCE;
        if (brazeActionParser.isBrazeActionUri(this.uri)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (a) new AnonymousClass2(), 6, (Object) null);
            brazeActionParser.execute(context, this.uri, getChannel());
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new AnonymousClass3(), 7, (Object) null);
        if (this.useWebView && d0.b0(BrazeFileUtils.REMOTE_SCHEMES, this.uri.getScheme())) {
            if (getChannel() == Channel.PUSH) {
                openUriWithWebViewActivityFromPush(context, this.uri, this.extras);
                return;
            } else {
                openUriWithWebViewActivity(context, this.uri, this.extras);
                return;
            }
        }
        if (getChannel() == Channel.PUSH) {
            openUriWithActionViewFromPush(context, this.uri, this.extras);
        } else {
            openUriWithActionView(context, this.uri, this.extras);
        }
    }

    @SuppressLint({"QueryPermissionsNeeded"})
    @NotNull
    protected final Intent getActionViewIntent(@NotNull Context context, @NotNull Uri uri, @Nullable Bundle bundle) {
        t.i(context, "context");
        t.i(uri, "uri");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        List<ResolveInfo> listQueryIntentActivities = Build.VERSION.SDK_INT >= 33 ? context.getPackageManager().queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(0L)) : context.getPackageManager().queryIntentActivities(intent, 0);
        t.h(listQueryIntentActivities, "if (Build.VERSION.SDK_IN…ties(intent, 0)\n        }");
        if (listQueryIntentActivities.size() > 1) {
            Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ResolveInfo next = it.next();
                if (t.d(next.activityInfo.packageName, context.getPackageName())) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new C11421(next), 7, (Object) null);
                    intent.setPackage(next.activityInfo.packageName);
                    break;
                }
            }
        }
        return intent;
    }

    @NotNull
    public Channel getChannel() {
        return this.channel;
    }

    @Nullable
    public final Bundle getExtras() {
        return this.extras;
    }

    @VisibleForTesting
    @NotNull
    public final Intent[] getIntentArrayWithConfiguredBackStack(@NotNull Context context, @Nullable Bundle bundle, @NotNull Intent targetIntent, @NotNull BrazeConfigurationProvider configurationProvider) {
        t.i(context, "context");
        t.i(targetIntent, "targetIntent");
        t.i(configurationProvider, "configurationProvider");
        Intent intentPutExtras = null;
        if (configurationProvider.isPushDeepLinkBackStackActivityEnabled()) {
            String pushDeepLinkBackStackActivityClassName = configurationProvider.getPushDeepLinkBackStackActivityClassName();
            if (pushDeepLinkBackStackActivityClassName == null || q.z(pushDeepLinkBackStackActivityClassName)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) C11431.INSTANCE, 6, (Object) null);
                intentPutExtras = UriUtils.getMainActivityIntent(context, bundle);
            } else if (UriUtils.isActivityRegisteredInManifest(context, pushDeepLinkBackStackActivityClassName)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) new C11442(pushDeepLinkBackStackActivityClassName), 6, (Object) null);
                if (bundle != null) {
                    intentPutExtras = new Intent().setClassName(context, pushDeepLinkBackStackActivityClassName).setFlags(BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_BACK_STACK_GET_ROOT_INTENT)).putExtras(bundle);
                }
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) new AnonymousClass4(pushDeepLinkBackStackActivityClassName), 6, (Object) null);
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (a) AnonymousClass5.INSTANCE, 6, (Object) null);
        }
        if (intentPutExtras != null) {
            return new Intent[]{intentPutExtras, targetIntent};
        }
        targetIntent.setFlags(BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_BACK_STACK_ONLY_GET_TARGET_INTENT));
        return new Intent[]{targetIntent};
    }

    @NotNull
    public final Uri getUri() {
        return this.uri;
    }

    public final boolean getUseWebView() {
        return this.useWebView;
    }

    @NotNull
    protected final Intent getWebViewActivityIntent(@NotNull Context context, @NotNull Uri uri, @Nullable Bundle bundle) {
        Intent intent;
        t.i(context, "context");
        t.i(uri, "uri");
        String customHtmlWebViewActivityClassName = BrazeInternal.INSTANCE.getConfigurationProvider(context).getCustomHtmlWebViewActivityClassName();
        if ((customHtmlWebViewActivityClassName == null || q.z(customHtmlWebViewActivityClassName)) || !UriUtils.isActivityRegisteredInManifest(context, customHtmlWebViewActivityClassName)) {
            intent = new Intent(context, (Class<?>) BrazeWebViewActivity.class);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (a) new UriAction$getWebViewActivityIntent$webViewActivityIntent$1(customHtmlWebViewActivityClassName), 7, (Object) null);
            intent = new Intent().setClassName(context, customHtmlWebViewActivityClassName);
            t.h(intent, "customWebViewActivityCla…ivityClassName)\n        }");
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("url", uri.toString());
        return intent;
    }

    protected void openUriWithActionView(@NotNull Context context, @NotNull Uri uri, @Nullable Bundle bundle) {
        t.i(context, "context");
        t.i(uri, "uri");
        Intent actionViewIntent = getActionViewIntent(context, uri, bundle);
        actionViewIntent.setFlags(BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_OPEN_WITH_ACTION_VIEW));
        try {
            context.startActivity(actionViewIntent);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) new C11451(uri, bundle), 4, (Object) null);
        }
    }

    protected final void openUriWithActionViewFromPush(@NotNull Context context, @NotNull Uri uri, @Nullable Bundle bundle) {
        t.i(context, "context");
        t.i(uri, "uri");
        try {
            context.startActivities(getIntentArrayWithConfiguredBackStack(context, bundle, getActionViewIntent(context, uri, bundle), BrazeInternal.INSTANCE.getConfigurationProvider(context)));
        } catch (ActivityNotFoundException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e10, false, (a) new C11461(uri), 4, (Object) null);
        }
    }

    protected final void openUriWithWebViewActivity(@NotNull Context context, @NotNull Uri uri, @Nullable Bundle bundle) {
        t.i(context, "context");
        t.i(uri, "uri");
        Intent webViewActivityIntent = getWebViewActivityIntent(context, uri, bundle);
        webViewActivityIntent.setFlags(BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_OPEN_WITH_WEBVIEW_ACTIVITY));
        try {
            context.startActivity(webViewActivityIntent);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) C11471.INSTANCE, 4, (Object) null);
        }
    }

    protected final void openUriWithWebViewActivityFromPush(@NotNull Context context, @NotNull Uri uri, @Nullable Bundle bundle) {
        t.i(context, "context");
        t.i(uri, "uri");
        try {
            context.startActivities(getIntentArrayWithConfiguredBackStack(context, bundle, getWebViewActivityIntent(context, uri, bundle), BrazeInternal.INSTANCE.getConfigurationProvider(context)));
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) C11481.INSTANCE, 4, (Object) null);
        }
    }
}
