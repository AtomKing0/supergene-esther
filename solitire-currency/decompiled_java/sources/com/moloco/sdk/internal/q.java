package com.moloco.sdk.internal;

import com.moloco.sdk.publisher.MolocoAdError;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final MolocoAdError f18349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c f18350b;

    public q(@NotNull MolocoAdError molocoAdError, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c subErrorType) {
        kotlin.jvm.internal.t.i(molocoAdError, "molocoAdError");
        kotlin.jvm.internal.t.i(subErrorType, "subErrorType");
        this.f18349a = molocoAdError;
        this.f18350b = subErrorType;
    }

    @NotNull
    public final MolocoAdError a() {
        return this.f18349a;
    }

    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c b() {
        return this.f18350b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return kotlin.jvm.internal.t.d(this.f18349a, qVar.f18349a) && kotlin.jvm.internal.t.d(this.f18350b, qVar.f18350b);
    }

    public int hashCode() {
        return (this.f18349a.hashCode() * 31) + this.f18350b.hashCode();
    }

    @NotNull
    public String toString() {
        return "MolocoInternalAdError(molocoAdError=" + this.f18349a + ", subErrorType=" + this.f18350b + ')';
    }
}
