package kotlinx.serialization.json;

import ea.x0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JsonTransformingSerializer.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class v<T> implements KSerializer<T> {

    @NotNull
    private final KSerializer<T> tSerializer;

    public v(@NotNull KSerializer<T> tSerializer) {
        kotlin.jvm.internal.t.i(tSerializer, "tSerializer");
        this.tSerializer = tSerializer;
    }

    @Override // z9.b
    @NotNull
    public final T deserialize(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        f fVarD = j.d(decoder);
        return (T) fVarD.d().d(this.tSerializer, transformDeserialize(fVarD.g()));
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.tSerializer.getDescriptor();
    }

    @Override // z9.j
    public final void serialize(@NotNull Encoder encoder, @NotNull T value) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        kotlin.jvm.internal.t.i(value, "value");
        k kVarE = j.e(encoder);
        kVarE.A(transformSerialize(x0.c(kVarE.d(), value, this.tSerializer)));
    }

    @NotNull
    protected JsonElement transformDeserialize(@NotNull JsonElement element) {
        kotlin.jvm.internal.t.i(element, "element");
        return element;
    }

    @NotNull
    protected JsonElement transformSerialize(@NotNull JsonElement element) {
        kotlin.jvm.internal.t.i(element, "element");
        return element;
    }
}
