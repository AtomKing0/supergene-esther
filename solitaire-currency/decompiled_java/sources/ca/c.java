package ca;

import kotlin.jvm.internal.t;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Decoding.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface c {

    /* JADX INFO: compiled from: Decoding.kt */
    public static final class a {
        public static int a(@NotNull c cVar, @NotNull SerialDescriptor descriptor) {
            t.i(descriptor, "descriptor");
            return -1;
        }

        public static boolean b(@NotNull c cVar) {
            return false;
        }

        public static /* synthetic */ Object c(c cVar, SerialDescriptor serialDescriptor, int i10, z9.b bVar, Object obj, int i11, Object obj2) {
            if (obj2 != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeSerializableElement");
            }
            if ((i11 & 8) != 0) {
                obj = null;
            }
            return cVar.y(serialDescriptor, i10, bVar, obj);
        }
    }

    char A(@NotNull SerialDescriptor serialDescriptor, int i10);

    byte B(@NotNull SerialDescriptor serialDescriptor, int i10);

    boolean C(@NotNull SerialDescriptor serialDescriptor, int i10);

    short F(@NotNull SerialDescriptor serialDescriptor, int i10);

    double G(@NotNull SerialDescriptor serialDescriptor, int i10);

    @NotNull
    fa.c a();

    void c(@NotNull SerialDescriptor serialDescriptor);

    long f(@NotNull SerialDescriptor serialDescriptor, int i10);

    int i(@NotNull SerialDescriptor serialDescriptor, int i10);

    @Nullable
    <T> T k(@NotNull SerialDescriptor serialDescriptor, int i10, @NotNull z9.b<T> bVar, @Nullable T t10);

    int l(@NotNull SerialDescriptor serialDescriptor);

    @NotNull
    String n(@NotNull SerialDescriptor serialDescriptor, int i10);

    int o(@NotNull SerialDescriptor serialDescriptor);

    boolean p();

    @NotNull
    Decoder r(@NotNull SerialDescriptor serialDescriptor, int i10);

    float u(@NotNull SerialDescriptor serialDescriptor, int i10);

    <T> T y(@NotNull SerialDescriptor serialDescriptor, int i10, @NotNull z9.b<T> bVar, @Nullable T t10);
}
