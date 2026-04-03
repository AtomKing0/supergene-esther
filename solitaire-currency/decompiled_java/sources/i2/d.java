package i2;

/* JADX INFO: compiled from: TimeModule_UptimeClockFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements a2.b<i2.a> {

    /* JADX INFO: compiled from: TimeModule_UptimeClockFactory.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f26569a = new d();
    }

    public static d a() {
        return a.f26569a;
    }

    public static i2.a c() {
        return (i2.a) a2.d.c(b.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // u8.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i2.a get() {
        return c();
    }
}
