package da;

import ba.e;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Primitives.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class w1 implements KSerializer<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final w1 f24648a = new w1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final SerialDescriptor f24649b = new o1("kotlin.String", e.i.f2297a);

    private w1() {
    }

    @Override // z9.b
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String deserialize(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        return decoder.z();
    }

    @Override // z9.j
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(@NotNull Encoder encoder, @NotNull String value) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        kotlin.jvm.internal.t.i(value, "value");
        encoder.G(value);
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return f24649b;
    }
}
