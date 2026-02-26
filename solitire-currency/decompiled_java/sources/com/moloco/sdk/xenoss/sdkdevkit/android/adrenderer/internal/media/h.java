package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f19462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f19463c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f19464d;

    public h(int i10, boolean z10, double d10, int i11) {
        this.f19461a = i10;
        this.f19462b = z10;
        this.f19463c = d10;
        this.f19464d = i11;
    }

    public final int a() {
        return this.f19461a;
    }

    public final int b() {
        return this.f19464d;
    }

    public final double c() {
        return this.f19463c;
    }

    public final boolean d() {
        return this.f19462b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f19461a == hVar.f19461a && this.f19462b == hVar.f19462b && Double.compare(this.f19463c, hVar.f19463c) == 0 && this.f19464d == hVar.f19464d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        int i10 = this.f19461a * 31;
        boolean z10 = this.f19462b;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        return ((((i10 + r12) * 31) + androidx.compose.animation.core.b.a(this.f19463c)) * 31) + this.f19464d;
    }

    @NotNull
    public String toString() {
        return "MediaConfig(chunkSize=" + this.f19461a + ", isStreamingEnabled=" + this.f19462b + ", minStreamingPlayableDurationOnTimeoutSecs=" + this.f19463c + ", mediaCacheDiskCleanUpLimit=" + this.f19464d + ')';
    }
}
