package da;

import ba.e;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Primitives.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class u0 implements KSerializer<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u0 f24629a = new u0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final SerialDescriptor f24630b = new o1("kotlin.Long", e.g.f2295a);

    private u0() {
    }

    @Override // z9.b
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Long deserialize(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        return Long.valueOf(decoder.m());
    }

    public void b(@NotNull Encoder encoder, long j10) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        encoder.m(j10);
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return f24630b;
    }

    @Override // z9.j
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Number) obj).longValue());
    }
}
