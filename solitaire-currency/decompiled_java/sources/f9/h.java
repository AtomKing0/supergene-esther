package f9;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: FileTreeWalk.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f25759a = new h("TOP_DOWN", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f25760b = new h("BOTTOM_UP", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ h[] f25761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ b9.a f25762d;

    static {
        h[] hVarArrA = a();
        f25761c = hVarArrA;
        f25762d = b9.b.a(hVarArrA);
    }

    private h(String str, int i10) {
    }

    private static final /* synthetic */ h[] a() {
        return new h[]{f25759a, f25760b};
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f25761c.clone();
    }
}
