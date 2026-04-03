package ka;

import v8.k0;

/* JADX INFO: compiled from: TaskQueue.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f29720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ boolean f29721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ h9.a<k0> f29722g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, boolean z10, h9.a<k0> aVar) {
        super(str, z10);
        this.f29720e = str;
        this.f29721f = z10;
        this.f29722g = aVar;
    }

    @Override // ka.a
    public long f() {
        this.f29722g.invoke();
        return -1L;
    }
}
