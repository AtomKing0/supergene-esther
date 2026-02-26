package kotlinx.serialization.internal;

import da.h2;
import da.n1;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.h0;
import v8.i0;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class l extends n1<h0, i0, h2> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final l f30025c = new l();

    private l() {
        super(aa.a.G(h0.f35185b));
    }

    @Override // da.a
    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((i0) obj).r());
    }

    @Override // da.a
    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((i0) obj).r());
    }

    @Override // da.n1
    public /* bridge */ /* synthetic */ i0 r() {
        return i0.a(w());
    }

    @Override // da.n1
    public /* bridge */ /* synthetic */ void u(ca.d dVar, i0 i0Var, int i10) {
        z(dVar, i0Var.r(), i10);
    }

    protected int v(@NotNull short[] collectionSize) {
        t.i(collectionSize, "$this$collectionSize");
        return i0.l(collectionSize);
    }

    @NotNull
    protected short[] w() {
        return i0.b(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.r, da.a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(@NotNull ca.c decoder, int i10, @NotNull h2 builder, boolean z10) {
        t.i(decoder, "decoder");
        t.i(builder, "builder");
        builder.e(h0.c(decoder.r(getDescriptor(), i10).s()));
    }

    @NotNull
    protected h2 y(@NotNull short[] toBuilder) {
        t.i(toBuilder, "$this$toBuilder");
        return new h2(toBuilder, null);
    }

    protected void z(@NotNull ca.d encoder, @NotNull short[] content, int i10) {
        t.i(encoder, "encoder");
        t.i(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.e(getDescriptor(), i11).q(i0.j(content, i11));
        }
    }
}
