package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final List<b> f20707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f20708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f20709c;

    public y(@NotNull List<b> ads, @Nullable String str, @Nullable String str2) {
        kotlin.jvm.internal.t.i(ads, "ads");
        this.f20707a = ads;
        this.f20708b = str;
        this.f20709c = str2;
    }

    @NotNull
    public final List<b> a() {
        return this.f20707a;
    }

    @Nullable
    public final String b() {
        return this.f20708b;
    }
}
