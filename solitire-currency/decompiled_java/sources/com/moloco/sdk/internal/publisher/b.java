package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdShowListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class b {
    @NotNull
    public static final h0 a(@Nullable AdShowListener adShowListener, @NotNull com.moloco.sdk.internal.services.m appLifecycleTrackerService, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.core.services.a customUserEventBuilderService, @NotNull h9.a<com.moloco.sdk.internal.ortb.model.q> provideSdkEvents, @NotNull h9.a<r> provideBUrlData, @NotNull com.moloco.sdk.internal.u sdkEventUrlTracker, @NotNull com.moloco.sdk.internal.f bUrlTracker, @NotNull AdFormatType adType) {
        kotlin.jvm.internal.t.i(appLifecycleTrackerService, "appLifecycleTrackerService");
        kotlin.jvm.internal.t.i(customUserEventBuilderService, "customUserEventBuilderService");
        kotlin.jvm.internal.t.i(provideSdkEvents, "provideSdkEvents");
        kotlin.jvm.internal.t.i(provideBUrlData, "provideBUrlData");
        kotlin.jvm.internal.t.i(sdkEventUrlTracker, "sdkEventUrlTracker");
        kotlin.jvm.internal.t.i(bUrlTracker, "bUrlTracker");
        kotlin.jvm.internal.t.i(adType, "adType");
        return new i0(adShowListener, appLifecycleTrackerService, customUserEventBuilderService, provideSdkEvents, provideBUrlData, sdkEventUrlTracker, bUrlTracker, adType);
    }
}
