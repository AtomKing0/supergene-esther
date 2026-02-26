package da;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ValueClasses.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i2 implements KSerializer<v8.h0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final i2 f24583a = new i2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final SerialDescriptor f24584b = j0.a("kotlin.UShort", aa.a.A(kotlin.jvm.internal.q0.f29837a));

    private i2() {
    }

    public short a(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        return v8.h0.c(decoder.q(getDescriptor()).s());
    }

    public void b(@NotNull Encoder encoder, short s10) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        encoder.l(getDescriptor()).q(s10);
    }

    @Override // z9.b
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return v8.h0.a(a(decoder));
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return f24584b;
    }

    @Override // z9.j
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((v8.h0) obj).g());
    }
}
