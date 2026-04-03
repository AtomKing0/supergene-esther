package da;

import da.l1;
import java.util.Iterator;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CollectionSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class n1<Element, Array, Builder extends l1<Array>> extends r<Element, Array, Builder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final SerialDescriptor f24602b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n1(@NotNull KSerializer<Element> primitiveSerializer) {
        super(primitiveSerializer, null);
        kotlin.jvm.internal.t.i(primitiveSerializer, "primitiveSerializer");
        this.f24602b = new m1(primitiveSerializer.getDescriptor());
    }

    @Override // da.a
    @NotNull
    protected final Iterator<Element> d(Array array) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead".toString());
    }

    @Override // da.a, z9.b
    public final Array deserialize(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        return f(decoder, null);
    }

    @Override // da.r, kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public final SerialDescriptor getDescriptor() {
        return this.f24602b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    @NotNull
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final Builder a() {
        return k(r());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final int b(@NotNull Builder builder) {
        kotlin.jvm.internal.t.i(builder, "<this>");
        return builder.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final void c(@NotNull Builder builder, int i10) {
        kotlin.jvm.internal.t.i(builder, "<this>");
        builder.b(i10);
    }

    protected abstract Array r();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.r
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public final void n(@NotNull Builder builder, int i10, Element element) {
        kotlin.jvm.internal.t.i(builder, "<this>");
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead".toString());
    }

    @Override // da.r, z9.j
    public final void serialize(@NotNull Encoder encoder, Array array) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        int iE = e(array);
        SerialDescriptor serialDescriptor = this.f24602b;
        ca.d dVarI = encoder.i(serialDescriptor, iE);
        u(dVarI, array, iE);
        dVarI.c(serialDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.a
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public final Array l(@NotNull Builder builder) {
        kotlin.jvm.internal.t.i(builder, "<this>");
        return (Array) builder.a();
    }

    protected abstract void u(@NotNull ca.d dVar, Array array, int i10);
}
