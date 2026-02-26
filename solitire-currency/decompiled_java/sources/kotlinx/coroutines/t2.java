package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes5.dex */
final class t2<T> extends i2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final p<T> f29983e;

    /* JADX WARN: Multi-variable type inference failed */
    public t2(@NotNull p<? super T> pVar) {
        this.f29983e = pVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ v8.k0 invoke(Throwable th) {
        q(th);
        return v8.k0.f35197a;
    }

    @Override // kotlinx.coroutines.e0
    public void q(@Nullable Throwable th) {
        Object objF0 = r().f0();
        if (objF0 instanceof c0) {
            p<T> pVar = this.f29983e;
            t.a aVar = v8.t.f35208b;
            pVar.resumeWith(v8.t.b(v8.u.a(((c0) objF0).f29865a)));
        } else {
            p<T> pVar2 = this.f29983e;
            t.a aVar2 = v8.t.f35208b;
            pVar2.resumeWith(v8.t.b(k2.h(objF0)));
        }
    }
}
