package kotlinx.serialization.internal;

import da.b0;
import da.n1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e extends n1<Float, float[], b0> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final e f30018c = new e();

    private e() {
        super(aa.a.x(m.f29832a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(@NotNull float[] fArr) {
        t.i(fArr, "<this>");
        return fArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.n1
    @NotNull
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public float[] r() {
        return new float[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.r, da.a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(@NotNull ca.c decoder, int i10, @NotNull b0 builder, boolean z10) {
        t.i(decoder, "decoder");
        t.i(builder, "builder");
        builder.e(decoder.u(getDescriptor(), i10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public b0 k(@NotNull float[] fArr) {
        t.i(fArr, "<this>");
        return new b0(fArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.n1
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(@NotNull ca.d encoder, @NotNull float[] content, int i10) {
        t.i(encoder, "encoder");
        t.i(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.s(getDescriptor(), i11, content[i11]);
        }
    }
}
