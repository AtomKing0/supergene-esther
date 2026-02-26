package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes5.dex */
class w2 extends a<v8.k0> {
    public w2(@NotNull z8.g gVar, boolean z10) {
        super(gVar, true, z10);
    }

    @Override // kotlinx.coroutines.j2
    protected boolean g0(@NotNull Throwable th) {
        m0.a(getContext(), th);
        return true;
    }
}
