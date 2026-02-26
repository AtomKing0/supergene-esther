package da;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ValueClasses.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g2 implements KSerializer<v8.e0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g2 f24572a = new g2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final SerialDescriptor f24573b = j0.a("kotlin.ULong", aa.a.z(kotlin.jvm.internal.w.f29848a));

    private g2() {
    }

    public long a(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        return v8.e0.c(decoder.q(getDescriptor()).m());
    }

    public void b(@NotNull Encoder encoder, long j10) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        encoder.l(getDescriptor()).m(j10);
    }

    @Override // z9.b
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return v8.e0.a(a(decoder));
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return f24573b;
    }

    @Override // z9.j
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((v8.e0) obj).g());
    }
}
