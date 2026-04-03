package da;

import ba.e;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BuiltInSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class x implements KSerializer<q9.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final x f24650a = new x();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final SerialDescriptor f24651b = new o1("kotlin.time.Duration", e.i.f2297a);

    private x() {
    }

    public long a(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        return q9.b.f33177b.d(decoder.z());
    }

    public void b(@NotNull Encoder encoder, long j10) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        encoder.G(q9.b.G(j10));
    }

    @Override // z9.b
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return q9.b.g(a(decoder));
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return f24651b;
    }

    @Override // z9.j
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((q9.b) obj).K());
    }
}
