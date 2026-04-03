package s9;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Channels.kt */
/* JADX INFO: loaded from: classes5.dex */
final class e<T> extends t9.e<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f33678f = AtomicIntegerFieldUpdater.newUpdater(e.class, "consumed");
    private volatile int consumed;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final r9.t<T> f33679d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f33680e;

    public /* synthetic */ e(r9.t tVar, boolean z10, z8.g gVar, int i10, r9.a aVar, int i11, kotlin.jvm.internal.k kVar) {
        this(tVar, z10, (i11 & 4) != 0 ? z8.h.f37608a : gVar, (i11 & 8) != 0 ? -3 : i10, (i11 & 16) != 0 ? r9.a.SUSPEND : aVar);
    }

    private final void n() {
        if (this.f33680e) {
            if (!(f33678f.getAndSet(this, 1) == 0)) {
                throw new IllegalStateException("ReceiveChannel.consumeAsFlow can be collected just once".toString());
            }
        }
    }

    @Override // t9.e, s9.h
    @Nullable
    public Object collect(@NotNull i<? super T> iVar, @NotNull z8.d<? super v8.k0> dVar) {
        if (this.f34114b != -3) {
            Object objCollect = super.collect(iVar, dVar);
            return objCollect == a9.d.e() ? objCollect : v8.k0.f35197a;
        }
        n();
        Object objD = l.d(iVar, this.f33679d, this.f33680e, dVar);
        return objD == a9.d.e() ? objD : v8.k0.f35197a;
    }

    @Override // t9.e
    @NotNull
    protected String f() {
        return "channel=" + this.f33679d;
    }

    @Override // t9.e
    @Nullable
    protected Object h(@NotNull r9.r<? super T> rVar, @NotNull z8.d<? super v8.k0> dVar) {
        Object objD = l.d(new t9.w(rVar), this.f33679d, this.f33680e, dVar);
        return objD == a9.d.e() ? objD : v8.k0.f35197a;
    }

    @Override // t9.e
    @NotNull
    protected t9.e<T> i(@NotNull z8.g gVar, int i10, @NotNull r9.a aVar) {
        return new e(this.f33679d, this.f33680e, gVar, i10, aVar);
    }

    @Override // t9.e
    @NotNull
    public h<T> j() {
        return new e(this.f33679d, this.f33680e, null, 0, null, 28, null);
    }

    @Override // t9.e
    @NotNull
    public r9.t<T> m(@NotNull kotlinx.coroutines.o0 o0Var) {
        n();
        return this.f34114b == -3 ? this.f33679d : super.m(o0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull r9.t<? extends T> tVar, boolean z10, @NotNull z8.g gVar, int i10, @NotNull r9.a aVar) {
        super(gVar, i10, aVar);
        this.f33679d = tVar;
        this.f33680e = z10;
        this.consumed = 0;
    }
}
