package z1;

import android.content.Context;

/* JADX INFO: compiled from: MetadataBackendRegistry_Factory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements a2.b<k> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u8.a<Context> f36998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u8.a<i> f36999b;

    public l(u8.a<Context> aVar, u8.a<i> aVar2) {
        this.f36998a = aVar;
        this.f36999b = aVar2;
    }

    public static l a(u8.a<Context> aVar, u8.a<i> aVar2) {
        return new l(aVar, aVar2);
    }

    public static k c(Context context, Object obj) {
        return new k(context, (i) obj);
    }

    @Override // u8.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k get() {
        return c(this.f36998a.get(), this.f36999b.get());
    }
}
