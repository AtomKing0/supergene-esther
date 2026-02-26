package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f20652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<String> f20653b;

    public o(@NotNull String clickThroughUrl, @NotNull List<String> clickTrackingUrlList) {
        kotlin.jvm.internal.t.i(clickThroughUrl, "clickThroughUrl");
        kotlin.jvm.internal.t.i(clickTrackingUrlList, "clickTrackingUrlList");
        this.f20652a = clickThroughUrl;
        this.f20653b = clickTrackingUrlList;
    }

    @NotNull
    public final String a() {
        return this.f20652a;
    }

    @NotNull
    public final List<String> b() {
        return this.f20653b;
    }
}
