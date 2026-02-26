package kotlinx.serialization.internal;

import da.n;
import da.n1;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends n1<Character, char[], n> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final c f30016c = new c();

    private c() {
        super(aa.a.v(kotlin.jvm.internal.g.f29818a));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public int e(@NotNull char[] cArr) {
        t.i(cArr, "<this>");
        return cArr.length;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.n1
    @NotNull
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public char[] r() {
        return new char[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.r, da.a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void h(@NotNull ca.c decoder, int i10, @NotNull n builder, boolean z10) {
        t.i(decoder, "decoder");
        t.i(builder, "builder");
        builder.e(decoder.A(getDescriptor(), i10));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public n k(@NotNull char[] cArr) {
        t.i(cArr, "<this>");
        return new n(cArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.n1
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void u(@NotNull ca.d encoder, @NotNull char[] content, int i10) {
        t.i(encoder, "encoder");
        t.i(content, "content");
        for (int i11 = 0; i11 < i10; i11++) {
            encoder.n(getDescriptor(), i11, content[i11]);
        }
    }
}
