package da;

import da.d0;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InlineClassDescriptor.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class j0 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: InlineClassDescriptor.kt */
    public static final class a<T> implements d0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ KSerializer<T> f24587a;

        a(KSerializer<T> kSerializer) {
            this.f24587a = kSerializer;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // da.d0
        @NotNull
        public KSerializer<?>[] childSerializers() {
            return new KSerializer[]{this.f24587a};
        }

        @Override // z9.b
        public T deserialize(@NotNull Decoder decoder) {
            kotlin.jvm.internal.t.i(decoder, "decoder");
            throw new IllegalStateException("unsupported".toString());
        }

        @Override // kotlinx.serialization.KSerializer, z9.j, z9.b
        @NotNull
        public SerialDescriptor getDescriptor() {
            throw new IllegalStateException("unsupported".toString());
        }

        @Override // z9.j
        public void serialize(@NotNull Encoder encoder, T t10) {
            kotlin.jvm.internal.t.i(encoder, "encoder");
            throw new IllegalStateException("unsupported".toString());
        }

        @Override // da.d0
        @NotNull
        public KSerializer<?>[] typeParametersSerializers() {
            return d0.a.a(this);
        }
    }

    @NotNull
    public static final <T> SerialDescriptor a(@NotNull String name, @NotNull KSerializer<T> primitiveSerializer) {
        kotlin.jvm.internal.t.i(name, "name");
        kotlin.jvm.internal.t.i(primitiveSerializer, "primitiveSerializer");
        return new i0(name, new a(primitiveSerializer));
    }
}
