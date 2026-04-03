package kotlinx.serialization.internal;

import da.b2;
import da.n1;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.a0;
import v8.b0;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends n1<a0, b0, b2> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final i f30022c = new i();

    private i() {
        super(aa.a.D(a0.f35164b));
    }

    @Override // da.a
    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((b0) obj).r());
    }

    @Override // da.a
    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((b0) obj).r());
    }

    @Override // da.n1
    public /* bridge */ /* synthetic */ b0 r() {
        return b0.a(w());
    }

    @Override // da.n1
    public /* bridge */ /* synthetic */ void u(ca.d dVar, b0 b0Var, int i10) {
        z(dVar, b0Var.r(), i10);
    }

    protected int v(@NotNull byte[] collectionSize) {
        t.i(collectionSize, "$this$collectionSize");
        return b0.l(collectionSize);
    }

    @NotNull
    protected byte[] w() {
        return b0.b(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.r, da.a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(@NotNull ca.c decoder, int i10, @NotNull b2 builder, boolean z10) {
        t.i(decoder, "decoder");
        t.i(builder, "builder");
        builder.e(a0.c(decoder.r(getDescriptor(), i10).H()));
    }

    @NotNull
    protected b2 y(@NotNull byte[] toBuilder) {
        t.i(toBuilder, "$this$toBuilder");
        return new b2(toBuilder, null);
    }

    protected void z(@NotNull ca.d encoder, @NotNull byte[] content, int i10) {
        t.i(encoder, "encoder");
        t.i(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.e(getDescriptor(), i11).g(b0.j(content, i11));
        }
    }
}
