package v;

/* JADX INFO: compiled from: CachePolicy.kt */
/* JADX INFO: loaded from: classes2.dex */
public enum b {
    ENABLED(true, true),
    READ_ONLY(true, false),
    WRITE_ONLY(false, true),
    DISABLED(false, false);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f34848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f34849b;

    b(boolean z10, boolean z11) {
        this.f34848a = z10;
        this.f34849b = z11;
    }

    public final boolean c() {
        return this.f34848a;
    }

    public final boolean d() {
        return this.f34849b;
    }
}
