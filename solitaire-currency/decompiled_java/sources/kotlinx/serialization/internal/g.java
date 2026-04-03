package kotlinx.serialization.internal;

import da.n1;
import da.t0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.w;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g extends n1<Long, long[], t0> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final g f30020c = new g();

    private g() {
        super(aa.a.z(w.f29848a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(@NotNull long[] jArr) {
        t.i(jArr, "<this>");
        return jArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.n1
    @NotNull
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public long[] r() {
        return new long[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.r, da.a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(@NotNull ca.c decoder, int i10, @NotNull t0 builder, boolean z10) {
        t.i(decoder, "decoder");
        t.i(builder, "builder");
        builder.e(decoder.f(getDescriptor(), i10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public t0 k(@NotNull long[] jArr) {
        t.i(jArr, "<this>");
        return new t0(jArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.n1
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(@NotNull ca.d encoder, @NotNull long[] content, int i10) {
        t.i(encoder, "encoder");
        t.i(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.F(getDescriptor(), i11, content[i11]);
        }
    }
}
