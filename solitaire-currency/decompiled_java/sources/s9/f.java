package s9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes5.dex */
class f<T> extends t9.e<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final h9.p<r9.r<? super T>, z8.d<? super v8.k0>, Object> f33682d;

    public /* synthetic */ f(h9.p pVar, z8.g gVar, int i10, r9.a aVar, int i11, kotlin.jvm.internal.k kVar) {
        this(pVar, (i11 & 2) != 0 ? z8.h.f37608a : gVar, (i11 & 4) != 0 ? -2 : i10, (i11 & 8) != 0 ? r9.a.SUSPEND : aVar);
    }

    static /* synthetic */ <T> Object n(f<T> fVar, r9.r<? super T> rVar, z8.d<? super v8.k0> dVar) {
        Object objMo4invoke = ((f) fVar).f33682d.mo4invoke(rVar, dVar);
        return objMo4invoke == a9.d.e() ? objMo4invoke : v8.k0.f35197a;
    }

    @Override // t9.e
    @Nullable
    protected Object h(@NotNull r9.r<? super T> rVar, @NotNull z8.d<? super v8.k0> dVar) {
        return n(this, rVar, dVar);
    }

    @Override // t9.e
    @NotNull
    protected t9.e<T> i(@NotNull z8.g gVar, int i10, @NotNull r9.a aVar) {
        return new f(this.f33682d, gVar, i10, aVar);
    }

    @Override // t9.e
    @NotNull
    public String toString() {
        return "block[" + this.f33682d + "] -> " + super.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(@NotNull h9.p<? super r9.r<? super T>, ? super z8.d<? super v8.k0>, ? extends Object> pVar, @NotNull z8.g gVar, int i10, @NotNull r9.a aVar) {
        super(gVar, i10, aVar);
        this.f33682d = pVar;
    }
}
