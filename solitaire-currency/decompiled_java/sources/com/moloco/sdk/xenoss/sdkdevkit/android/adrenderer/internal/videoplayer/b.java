package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f21457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f21458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f21459c;

    public b(boolean z10, boolean z11, boolean z12) {
        this.f21457a = z10;
        this.f21458b = z11;
        this.f21459c = z12;
    }

    public final boolean a() {
        return this.f21459c;
    }

    public final boolean b() {
        return this.f21457a;
    }

    public final boolean c() {
        return this.f21458b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f21457a == bVar.f21457a && this.f21458b == bVar.f21458b && this.f21459c == bVar.f21459c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    public int hashCode() {
        boolean z10 = this.f21457a;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        boolean z11 = this.f21458b;
        ?? r22 = z11;
        if (z11) {
            r22 = 1;
        }
        int i11 = (i10 + r22) * 31;
        boolean z12 = this.f21459c;
        return i11 + (z12 ? 1 : z12);
    }

    @NotNull
    public String toString() {
        return "PlayingState(isPlaying=" + this.f21457a + ", isVisible=" + this.f21458b + ", hasMore=" + this.f21459c + ')';
    }

    public /* synthetic */ b(boolean z10, boolean z11, boolean z12, int i10, k kVar) {
        this(z10, (i10 & 2) != 0 ? true : z11, (i10 & 4) != 0 ? true : z12);
    }
}
