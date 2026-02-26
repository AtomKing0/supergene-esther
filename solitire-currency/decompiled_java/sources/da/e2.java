package da;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ValueClasses.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e2 implements KSerializer<v8.c0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e2 f24564a = new e2();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final SerialDescriptor f24565b = j0.a("kotlin.UInt", aa.a.y(kotlin.jvm.internal.s.f29839a));

    private e2() {
    }

    public int a(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        return v8.c0.c(decoder.q(getDescriptor()).h());
    }

    public void b(@NotNull Encoder encoder, int i10) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        encoder.l(getDescriptor()).B(i10);
    }

    @Override // z9.b
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return v8.c0.a(a(decoder));
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return f24565b;
    }

    @Override // z9.j
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((v8.c0) obj).g());
    }
}
