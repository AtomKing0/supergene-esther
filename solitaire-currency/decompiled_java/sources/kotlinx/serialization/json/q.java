package kotlinx.serialization.json;

import ba.i;
import ea.w;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JsonElementSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class q implements KSerializer<JsonNull> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q f30080a = new q();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final SerialDescriptor f30081b = ba.h.d("kotlinx.serialization.json.JsonNull", i.b.f2320a, new SerialDescriptor[0], null, 8, null);

    private q() {
    }

    @Override // z9.b
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JsonNull deserialize(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        j.g(decoder);
        if (decoder.E()) {
            throw new w("Expected 'null' literal");
        }
        decoder.j();
        return JsonNull.f30027a;
    }

    @Override // z9.j
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(@NotNull Encoder encoder, @NotNull JsonNull value) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        kotlin.jvm.internal.t.i(value, "value");
        j.h(encoder);
        encoder.o();
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return f30081b;
    }
}
