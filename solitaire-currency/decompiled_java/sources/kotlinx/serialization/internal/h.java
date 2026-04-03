package kotlinx.serialization.internal;

import da.n1;
import da.u1;
import kotlin.jvm.internal.q0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends n1<Short, short[], u1> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final h f30021c = new h();

    private h() {
        super(aa.a.A(q0.f29837a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(@NotNull short[] sArr) {
        t.i(sArr, "<this>");
        return sArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.n1
    @NotNull
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public short[] r() {
        return new short[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.r, da.a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(@NotNull ca.c decoder, int i10, @NotNull u1 builder, boolean z10) {
        t.i(decoder, "decoder");
        t.i(builder, "builder");
        builder.e(decoder.F(getDescriptor(), i10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public u1 k(@NotNull short[] sArr) {
        t.i(sArr, "<this>");
        return new u1(sArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.n1
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(@NotNull ca.d encoder, @NotNull short[] content, int i10) {
        t.i(encoder, "encoder");
        t.i(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.C(getDescriptor(), i11, content[i11]);
        }
    }
}
