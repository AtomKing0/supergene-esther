package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f20629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final List<String> f20630b;

    public h(@NotNull String clickThroughUrl, @NotNull List<String> clickTrackingUrls) {
        kotlin.jvm.internal.t.i(clickThroughUrl, "clickThroughUrl");
        kotlin.jvm.internal.t.i(clickTrackingUrls, "clickTrackingUrls");
        this.f20629a = clickThroughUrl;
        this.f20630b = clickTrackingUrls;
    }

    @NotNull
    public final String a() {
        return this.f20629a;
    }

    @NotNull
    public final List<String> b() {
        return this.f20630b;
    }
}
