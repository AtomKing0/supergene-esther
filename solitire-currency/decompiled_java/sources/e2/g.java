package e2;

/* JADX INFO: compiled from: SchedulingConfigModule_ConfigFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements a2.b<f2.f> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u8.a<i2.a> f24724a;

    public g(u8.a<i2.a> aVar) {
        this.f24724a = aVar;
    }

    public static f2.f a(i2.a aVar) {
        return (f2.f) a2.d.c(f.a(aVar), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static g b(u8.a<i2.a> aVar) {
        return new g(aVar);
    }

    @Override // u8.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public f2.f get() {
        return a(this.f24724a.get());
    }
}
