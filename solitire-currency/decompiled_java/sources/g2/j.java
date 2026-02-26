package g2;

/* JADX INFO: compiled from: EventStoreModule_StoreConfigFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements a2.b<e> {

    /* JADX INFO: compiled from: EventStoreModule_StoreConfigFactory.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final j f25815a = new j();
    }

    public static j a() {
        return a.f25815a;
    }

    public static e c() {
        return (e) a2.d.c(f.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // u8.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e get() {
        return c();
    }
}
