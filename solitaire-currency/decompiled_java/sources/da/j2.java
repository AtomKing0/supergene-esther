package da;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Primitives.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class j2 implements KSerializer<v8.k0> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public static final j2 f24588b = new j2();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ c1<v8.k0> f24589a = new c1<>("kotlin.Unit", v8.k0.f35197a);

    private j2() {
    }

    public void a(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        this.f24589a.deserialize(decoder);
    }

    @Override // z9.j
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(@NotNull Encoder encoder, @NotNull v8.k0 value) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        kotlin.jvm.internal.t.i(value, "value");
        this.f24589a.serialize(encoder, value);
    }

    @Override // z9.b
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        a(decoder);
        return v8.k0.f35197a;
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.f24589a.getDescriptor();
    }
}
