package kotlin.collections;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: AbstractIterator.kt */
/* JADX INFO: loaded from: classes5.dex */
final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c1 f29761a = new c1("Ready", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c1 f29762b = new c1("NotReady", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c1 f29763c = new c1("Done", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c1 f29764d = new c1("Failed", 3);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final /* synthetic */ c1[] f29765e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ b9.a f29766f;

    static {
        c1[] c1VarArrA = a();
        f29765e = c1VarArrA;
        f29766f = b9.b.a(c1VarArrA);
    }

    private c1(String str, int i10) {
    }

    private static final /* synthetic */ c1[] a() {
        return new c1[]{f29761a, f29762b, f29763c, f29764d};
    }

    public static c1 valueOf(String str) {
        return (c1) Enum.valueOf(c1.class, str);
    }

    public static c1[] values() {
        return (c1[]) f29765e.clone();
    }
}
