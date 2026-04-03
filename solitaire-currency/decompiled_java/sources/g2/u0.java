package g2;

import android.content.Context;

/* JADX INFO: compiled from: SchemaManager_Factory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u0 implements a2.b<t0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u8.a<Context> f25860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u8.a<String> f25861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u8.a<Integer> f25862c;

    public u0(u8.a<Context> aVar, u8.a<String> aVar2, u8.a<Integer> aVar3) {
        this.f25860a = aVar;
        this.f25861b = aVar2;
        this.f25862c = aVar3;
    }

    public static u0 a(u8.a<Context> aVar, u8.a<String> aVar2, u8.a<Integer> aVar3) {
        return new u0(aVar, aVar2, aVar3);
    }

    public static t0 c(Context context, String str, int i10) {
        return new t0(context, str, i10);
    }

    @Override // u8.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public t0 get() {
        return c(this.f25860a.get(), this.f25861b.get(), this.f25862c.get().intValue());
    }
}
