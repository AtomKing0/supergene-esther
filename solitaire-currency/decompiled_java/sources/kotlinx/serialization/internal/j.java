package kotlinx.serialization.internal;

import da.d2;
import da.n1;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.c0;
import v8.d0;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class j extends n1<c0, d0, d2> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final j f30023c = new j();

    private j() {
        super(aa.a.E(c0.f35170b));
    }

    @Override // da.a
    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((d0) obj).r());
    }

    @Override // da.a
    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((d0) obj).r());
    }

    @Override // da.n1
    public /* bridge */ /* synthetic */ d0 r() {
        return d0.a(w());
    }

    @Override // da.n1
    public /* bridge */ /* synthetic */ void u(ca.d dVar, d0 d0Var, int i10) {
        z(dVar, d0Var.r(), i10);
    }

    protected int v(@NotNull int[] collectionSize) {
        t.i(collectionSize, "$this$collectionSize");
        return d0.l(collectionSize);
    }

    @NotNull
    protected int[] w() {
        return d0.b(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.r, da.a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(@NotNull ca.c decoder, int i10, @NotNull d2 builder, boolean z10) {
        t.i(decoder, "decoder");
        t.i(builder, "builder");
        builder.e(c0.c(decoder.r(getDescriptor(), i10).h()));
    }

    @NotNull
    protected d2 y(@NotNull int[] toBuilder) {
        t.i(toBuilder, "$this$toBuilder");
        return new d2(toBuilder, null);
    }

    protected void z(@NotNull ca.d encoder, @NotNull int[] content, int i10) {
        t.i(encoder, "encoder");
        t.i(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.e(getDescriptor(), i11).B(d0.j(content, i11));
        }
    }
}
