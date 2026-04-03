package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s f19516a;

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @NotNull
    public final c a(@Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s sVar) {
        return new c(sVar);
    }

    @Nullable
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s b() {
        return this.f19516a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && kotlin.jvm.internal.t.d(this.f19516a, ((c) obj).f19516a);
    }

    public int hashCode() {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s sVar = this.f19516a;
        if (sVar == null) {
            return 0;
        }
        return sVar.hashCode();
    }

    @NotNull
    public String toString() {
        return "MraidAdData(dec=" + this.f19516a + ')';
    }

    public c(@Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s sVar) {
        this.f19516a = sVar;
    }

    public /* synthetic */ c(com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.s sVar, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : sVar);
    }
}
