package da;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ValueClasses.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c2 implements KSerializer<v8.a0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c2 f24556a = new c2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final SerialDescriptor f24557b = j0.a("kotlin.UByte", aa.a.u(kotlin.jvm.internal.e.f29816a));

    private c2() {
    }

    public byte a(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        return v8.a0.c(decoder.q(getDescriptor()).H());
    }

    public void b(@NotNull Encoder encoder, byte b10) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        encoder.l(getDescriptor()).g(b10);
    }

    @Override // z9.b
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return v8.a0.a(a(decoder));
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return f24557b;
    }

    @Override // z9.j
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((v8.a0) obj).g());
    }
}
