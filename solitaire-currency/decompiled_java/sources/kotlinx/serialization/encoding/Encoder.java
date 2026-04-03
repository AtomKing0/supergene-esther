package kotlinx.serialization.encoding;

import ca.d;
import fa.c;
import kotlin.jvm.internal.t;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.j;

/* JADX INFO: compiled from: Encoding.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface Encoder {
    void B(int i10);

    <T> void E(@NotNull j<? super T> jVar, T t10);

    void G(@NotNull String str);

    @NotNull
    c a();

    @NotNull
    d b(@NotNull SerialDescriptor serialDescriptor);

    void f(double d10);

    void g(byte b10);

    @NotNull
    d i(@NotNull SerialDescriptor serialDescriptor, int i10);

    void k(@NotNull SerialDescriptor serialDescriptor, int i10);

    @NotNull
    Encoder l(@NotNull SerialDescriptor serialDescriptor);

    void m(long j10);

    void o();

    void q(short s10);

    void r(boolean z10);

    void t(float f10);

    void u(char c10);

    void v();

    /* JADX INFO: compiled from: Encoding.kt */
    public static final class a {
        @NotNull
        public static d a(@NotNull Encoder encoder, @NotNull SerialDescriptor descriptor, int i10) {
            t.i(descriptor, "descriptor");
            return encoder.b(descriptor);
        }

        public static <T> void c(@NotNull Encoder encoder, @NotNull j<? super T> serializer, @Nullable T t10) {
            t.i(serializer, "serializer");
            if (serializer.getDescriptor().b()) {
                encoder.E(serializer, t10);
            } else if (t10 == null) {
                encoder.o();
            } else {
                encoder.v();
                encoder.E(serializer, t10);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static <T> void d(@NotNull Encoder encoder, @NotNull j<? super T> serializer, T t10) {
            t.i(serializer, "serializer");
            serializer.serialize(encoder, t10);
        }

        public static void b(@NotNull Encoder encoder) {
        }
    }
}
