package da;

import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NullableSerializer.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b1<T> implements KSerializer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final KSerializer<T> f24544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final SerialDescriptor f24545b;

    public b1(@NotNull KSerializer<T> serializer) {
        kotlin.jvm.internal.t.i(serializer, "serializer");
        this.f24544a = serializer;
        this.f24545b = new r1(serializer.getDescriptor());
    }

    @Override // z9.b
    @Nullable
    public T deserialize(@NotNull Decoder decoder) {
        kotlin.jvm.internal.t.i(decoder, "decoder");
        return decoder.E() ? (T) decoder.D(this.f24544a) : (T) decoder.j();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && kotlin.jvm.internal.t.d(kotlin.jvm.internal.o0.b(b1.class), kotlin.jvm.internal.o0.b(obj.getClass())) && kotlin.jvm.internal.t.d(this.f24544a, ((b1) obj).f24544a);
    }

    @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
    @NotNull
    public SerialDescriptor getDescriptor() {
        return this.f24545b;
    }

    public int hashCode() {
        return this.f24544a.hashCode();
    }

    @Override // z9.j
    public void serialize(@NotNull Encoder encoder, @Nullable T t10) {
        kotlin.jvm.internal.t.i(encoder, "encoder");
        if (t10 == null) {
            encoder.o();
        } else {
            encoder.v();
            encoder.E(this.f24544a, t10);
        }
    }
}
