package i2;

/* JADX INFO: compiled from: TimeModule_EventClockFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements a2.b<i2.a> {

    /* JADX INFO: compiled from: TimeModule_EventClockFactory.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f26568a = new c();
    }

    public static c a() {
        return a.f26568a;
    }

    public static i2.a b() {
        return (i2.a) a2.d.c(b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // u8.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public i2.a get() {
        return b();
    }
}
