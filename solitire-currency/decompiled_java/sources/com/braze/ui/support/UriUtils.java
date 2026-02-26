package com.braze.ui.support;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.support.BrazeLogger;
import com.braze.ui.BrazeDeeplinkHandler;
import h9.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.r0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UriUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UriUtils {

    @NotNull
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("UriUtils");

    /* JADX INFO: renamed from: com.braze.ui.support.UriUtils$getQueryParameters$1, reason: invalid class name */
    /* JADX INFO: compiled from: UriUtils.kt */
    static final class AnonymousClass1 extends v implements a<String> {
        final /* synthetic */ n0<Uri> $uri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(n0<Uri> n0Var) {
            super(0);
            this.$uri = n0Var;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Encoded query is null for Uri: " + this.$uri.f29834a + " Returning empty map for query parameters";
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.support.UriUtils$getQueryParameters$2, reason: invalid class name */
    /* JADX INFO: compiled from: UriUtils.kt */
    static final class AnonymousClass2 extends v implements a<String> {
        final /* synthetic */ n0<Uri> $uri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(n0<Uri> n0Var) {
            super(0);
            this.$uri = n0Var;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Failed to map the query parameters of Uri: " + this.$uri.f29834a;
        }
    }

    /* JADX INFO: renamed from: com.braze.ui.support.UriUtils$isActivityRegisteredInManifest$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: UriUtils.kt */
    static final class C12661 extends v implements a<String> {
        final /* synthetic */ String $className;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C12661(String str) {
            super(0);
            this.$className = str;
        }

        @Override // h9.a
        @NotNull
        public final String invoke() {
            return "Could not find activity info for class with name: " + this.$className;
        }
    }

    @Nullable
    public static final Intent getMainActivityIntent(@NotNull Context context, @Nullable Bundle bundle) {
        t.i(context, "context");
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.URI_UTILS_GET_MAIN_ACTIVITY_INTENT));
        }
        if (bundle != null && launchIntentForPackage != null) {
            launchIntentForPackage.putExtras(bundle);
        }
        return launchIntentForPackage;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10, types: [T, android.net.Uri, java.lang.Object] */
    @NotNull
    public static final Map<String, String> getQueryParameters(@NotNull Uri uri) {
        ArrayList<String> arrayList;
        Iterator<T> it;
        t.i(uri, "<this>");
        n0 n0Var = new n0();
        n0Var.f29834a = uri;
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.V, (Throwable) null, false, (a) new AnonymousClass1(n0Var), 12, (Object) null);
            return r0.g();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            if (((Uri) n0Var.f29834a).isOpaque()) {
                ?? Build = Uri.parse("://").buildUpon().encodedQuery(encodedQuery).build();
                t.h(Build, "parse(\"://\")\n           …\n                .build()");
                n0Var.f29834a = Build;
            }
            Set<String> queryParameterNames = ((Uri) n0Var.f29834a).getQueryParameterNames();
            t.h(queryParameterNames, "uri.queryParameterNames");
            arrayList = new ArrayList();
            it = queryParameterNames.iterator();
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.E, (Throwable) e10, false, (a) new AnonymousClass2(n0Var), 8, (Object) null);
        }
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str = (String) next;
            if (!(str == null || str.length() == 0)) {
                arrayList.add(next);
            }
            return linkedHashMap;
        }
        for (String queryParameterKey : arrayList) {
            String queryParameter = ((Uri) n0Var.f29834a).getQueryParameter(queryParameterKey);
            if (!(queryParameter == null || queryParameter.length() == 0)) {
                t.h(queryParameterKey, "queryParameterKey");
                linkedHashMap.put(queryParameterKey, queryParameter);
            }
        }
        return linkedHashMap;
    }

    public static final boolean isActivityRegisteredInManifest(@NotNull Context context, @NotNull String className) {
        t.i(context, "context");
        t.i(className, "className");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.getPackageManager().getActivityInfo(new ComponentName(context, className), PackageManager.ComponentInfoFlags.of(0L));
            } else {
                context.getPackageManager().getActivityInfo(new ComponentName(context, className), 0);
            }
            return true;
        } catch (PackageManager.NameNotFoundException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.W, (Throwable) e10, false, (a) new C12661(className), 8, (Object) null);
            return false;
        }
    }
}
