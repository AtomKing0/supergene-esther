package kotlinx.serialization.json;

import ba.e;
import ea.a0;
import kotlin.jvm.internal.o0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JsonElementSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class t implements KSerializer<JsonPrimitive> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final t f30088a = new t();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final SerialDescriptor f30089b = ba.h.d("kotlinx.serialization.json.JsonPrimitive", e.i.f2297a, new SerialDescriptor[0], null, 8, null);

    private t() {
    }

    @Override // z9.b
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JsonPrimitive deserialize(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        JsonElement jsonElementG = j.d(decoder).g();
        if (jsonElementG instanceof JsonPrimitive) {
            return (JsonPrimitive) jsonElementG;
        }
        throw a0.f(-1, "Unexpected JSON element, expected JsonPrimitive, had " + o0.b(jsonElementG.getClass()), jsonElementG.toString());
    }

    @Override // z9.j
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(@NotNull Encoder encoder, @NotNull JsonPrimitive value) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        kotlin.jvm.internal.t.i(value, "value");
        j.h(encoder);
        if (value instanceof JsonNull) {
            encoder.E(q.f30080a, JsonNull.f30027a);
        } else {
            encoder.E(o.f30078a, (n) value);
        }
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return f30089b;
    }
}
