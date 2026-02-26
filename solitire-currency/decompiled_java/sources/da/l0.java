package da;

import ba.e;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Primitives.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class l0 implements KSerializer<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l0 f24594a = new l0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final SerialDescriptor f24595b = new o1("kotlin.Int", e.f.f2294a);

    private l0() {
    }

    @Override // z9.b
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer deserialize(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        return Integer.valueOf(decoder.h());
    }

    public void b(@NotNull Encoder encoder, int i10) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        encoder.B(i10);
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return f24595b;
    }

    @Override // z9.j
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Number) obj).intValue());
    }
}
