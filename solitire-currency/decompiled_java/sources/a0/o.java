package a0;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ImageLoaderOptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f54a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f55b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f56c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f57d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final m.l f58e;

    public o(boolean z10, boolean z11, boolean z12, int i10, @NotNull m.l lVar) {
        this.f54a = z10;
        this.f55b = z11;
        this.f56c = z12;
        this.f57d = i10;
        this.f58e = lVar;
    }

    public final boolean a() {
        return this.f54a;
    }

    @NotNull
    public final m.l b() {
        return this.f58e;
    }

    public final int c() {
        return this.f57d;
    }

    public final boolean d() {
        return this.f55b;
    }

    public final boolean e() {
        return this.f56c;
    }

    public /* synthetic */ o(boolean z10, boolean z11, boolean z12, int i10, m.l lVar, int i11, kotlin.jvm.internal.k kVar) {
        this((i11 & 1) != 0 ? true : z10, (i11 & 2) != 0 ? true : z11, (i11 & 4) == 0 ? z12 : true, (i11 & 8) != 0 ? 4 : i10, (i11 & 16) != 0 ? m.l.RESPECT_PERFORMANCE : lVar);
    }
}
