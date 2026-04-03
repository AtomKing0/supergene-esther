package v8;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: Lazy.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f35201a = new p("SYNCHRONIZED", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p f35202b = new p("PUBLICATION", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final p f35203c = new p("NONE", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ p[] f35204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ b9.a f35205e;

    static {
        p[] pVarArrA = a();
        f35204d = pVarArrA;
        f35205e = b9.b.a(pVarArrA);
    }

    private p(String str, int i10) {
    }

    private static final /* synthetic */ p[] a() {
        return new p[]{f35201a, f35202b, f35203c};
    }

    public static p valueOf(String str) {
        return (p) Enum.valueOf(p.class, str);
    }

    public static p[] values() {
        return (p[]) f35204d.clone();
    }
}
