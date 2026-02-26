package g2;

/* JADX INFO: compiled from: EventStoreModule_DbNameFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements a2.b<String> {

    /* JADX INFO: compiled from: EventStoreModule_DbNameFactory.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final g f25808a = new g();
    }

    public static g a() {
        return a.f25808a;
    }

    public static String b() {
        return (String) a2.d.c(f.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // u8.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public String get() {
        return b();
    }
}
