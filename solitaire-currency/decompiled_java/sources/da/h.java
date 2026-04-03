package da;

import ba.e;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Primitives.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h implements KSerializer<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f24574a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final SerialDescriptor f24575b = new o1("kotlin.Boolean", e.a.f2289a);

    private h() {
    }

    @Override // z9.b
    @NotNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean deserialize(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        return Boolean.valueOf(decoder.w());
    }

    public void b(@NotNull Encoder encoder, boolean z10) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        encoder.r(z10);
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return f24575b;
    }

    @Override // z9.j
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        b(encoder, ((Boolean) obj).booleanValue());
    }
}
