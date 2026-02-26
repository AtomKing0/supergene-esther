package b6;

/* JADX INFO: compiled from: SystemClock.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static b f2222a;

    private b() {
    }

    public static b a() {
        if (f2222a == null) {
            f2222a = new b();
        }
        return f2222a;
    }

    @Override // b6.a
    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
