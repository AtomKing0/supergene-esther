package z1;

import android.content.Context;

/* JADX INFO: compiled from: CreationContextFactory_Factory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j implements a2.b<i> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u8.a<Context> f36990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u8.a<i2.a> f36991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u8.a<i2.a> f36992c;

    public j(u8.a<Context> aVar, u8.a<i2.a> aVar2, u8.a<i2.a> aVar3) {
        this.f36990a = aVar;
        this.f36991b = aVar2;
        this.f36992c = aVar3;
    }

    public static j a(u8.a<Context> aVar, u8.a<i2.a> aVar2, u8.a<i2.a> aVar3) {
        return new j(aVar, aVar2, aVar3);
    }

    public static i c(Context context, i2.a aVar, i2.a aVar2) {
        return new i(context, aVar, aVar2);
    }

    @Override // u8.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c(this.f36990a.get(), this.f36991b.get(), this.f36992c.get());
    }
}
