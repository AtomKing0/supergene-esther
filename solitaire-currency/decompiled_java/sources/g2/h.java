package g2;

import android.content.Context;

/* JADX INFO: compiled from: EventStoreModule_PackageNameFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements a2.b<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u8.a<Context> f25810a;

    public h(u8.a<Context> aVar) {
        this.f25810a = aVar;
    }

    public static h a(u8.a<Context> aVar) {
        return new h(aVar);
    }

    public static String c(Context context) {
        return (String) a2.d.c(f.b(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // u8.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get() {
        return c(this.f25810a.get());
    }
}
