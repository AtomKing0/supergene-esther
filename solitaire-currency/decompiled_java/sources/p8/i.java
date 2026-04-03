package p8;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BytePacketBuilder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends p {
    /* JADX WARN: Multi-variable type inference failed */
    public i() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // p8.p
    @NotNull
    /* JADX INFO: renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public i append(char c10) {
        p pVarAppend = super.append(c10);
        t.g(pVarAppend, "null cannot be cast to non-null type io.ktor.utils.io.core.BytePacketBuilder");
        return (i) pVarAppend;
    }

    @Override // p8.p
    protected final void R(@NotNull ByteBuffer source, int i10, int i11) {
        t.i(source, "source");
    }

    @Override // p8.p
    @NotNull
    /* JADX INFO: renamed from: R0, reason: merged with bridge method [inline-methods] */
    public i append(@Nullable CharSequence charSequence) {
        p pVarAppend = super.append(charSequence);
        t.g(pVarAppend, "null cannot be cast to non-null type io.ktor.utils.io.core.BytePacketBuilder");
        return (i) pVarAppend;
    }

    @Override // p8.p
    @NotNull
    /* JADX INFO: renamed from: S0, reason: merged with bridge method [inline-methods] */
    public i append(@Nullable CharSequence charSequence, int i10, int i11) {
        p pVarAppend = super.append(charSequence, i10, i11);
        t.g(pVarAppend, "null cannot be cast to non-null type io.ktor.utils.io.core.BytePacketBuilder");
        return (i) pVarAppend;
    }

    @NotNull
    public final j T0() {
        int iU0 = U0();
        q8.a aVarK0 = K0();
        return aVarK0 == null ? j.f32928i.a() : new j(aVarK0, iU0, h0());
    }

    public final int U0() {
        return I0();
    }

    public final boolean V0() {
        return I0() == 0;
    }

    @NotNull
    public String toString() {
        return "BytePacketBuilder[0x" + hashCode() + ']';
    }

    public /* synthetic */ i(s8.g gVar, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? q8.a.f33167j.c() : gVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(@NotNull s8.g<q8.a> pool) {
        super(pool);
        t.i(pool, "pool");
    }

    @Override // p8.p
    protected final void O() {
    }
}
