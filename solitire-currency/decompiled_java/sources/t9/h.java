package t9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ChannelFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h<T> extends g<T, T> {
    public /* synthetic */ h(s9.h hVar, z8.g gVar, int i10, r9.a aVar, int i11, kotlin.jvm.internal.k kVar) {
        this(hVar, (i11 & 2) != 0 ? z8.h.f37608a : gVar, (i11 & 4) != 0 ? -3 : i10, (i11 & 8) != 0 ? r9.a.SUSPEND : aVar);
    }

    @Override // t9.e
    @NotNull
    protected e<T> i(@NotNull z8.g gVar, int i10, @NotNull r9.a aVar) {
        return new h(this.f34123d, gVar, i10, aVar);
    }

    @Override // t9.e
    @NotNull
    public s9.h<T> j() {
        return (s9.h<T>) this.f34123d;
    }

    @Override // t9.g
    @Nullable
    protected Object q(@NotNull s9.i<? super T> iVar, @NotNull z8.d<? super k0> dVar) {
        Object objCollect = this.f34123d.collect(iVar, dVar);
        return objCollect == a9.d.e() ? objCollect : k0.f35197a;
    }

    public h(@NotNull s9.h<? extends T> hVar, @NotNull z8.g gVar, int i10, @NotNull r9.a aVar) {
        super(hVar, gVar, i10, aVar);
    }
}
