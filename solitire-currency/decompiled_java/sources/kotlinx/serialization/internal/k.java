package kotlinx.serialization.internal;

import da.f2;
import da.n1;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.e0;
import v8.f0;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class k extends n1<e0, f0, f2> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final k f30024c = new k();

    private k() {
        super(aa.a.F(e0.f35179b));
    }

    @Override // da.a
    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((f0) obj).r());
    }

    @Override // da.a
    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((f0) obj).r());
    }

    @Override // da.n1
    public /* bridge */ /* synthetic */ f0 r() {
        return f0.a(w());
    }

    @Override // da.n1
    public /* bridge */ /* synthetic */ void u(ca.d dVar, f0 f0Var, int i10) {
        z(dVar, f0Var.r(), i10);
    }

    protected int v(@NotNull long[] collectionSize) {
        t.i(collectionSize, "$this$collectionSize");
        return f0.l(collectionSize);
    }

    @NotNull
    protected long[] w() {
        return f0.b(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.r, da.a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(@NotNull ca.c decoder, int i10, @NotNull f2 builder, boolean z10) {
        t.i(decoder, "decoder");
        t.i(builder, "builder");
        builder.e(e0.c(decoder.r(getDescriptor(), i10).m()));
    }

    @NotNull
    protected f2 y(@NotNull long[] toBuilder) {
        t.i(toBuilder, "$this$toBuilder");
        return new f2(toBuilder, null);
    }

    protected void z(@NotNull ca.d encoder, @NotNull long[] content, int i10) {
        t.i(encoder, "encoder");
        t.i(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.e(getDescriptor(), i11).m(f0.j(content, i11));
        }
    }
}
