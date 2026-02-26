package kotlinx.serialization.encoding;

import fa.c;
import kotlin.jvm.internal.t;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.b;

/* JADX INFO: compiled from: Decoding.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface Decoder {

    /* JADX INFO: compiled from: Decoding.kt */
    public static final class a {
        public static <T> T a(@NotNull Decoder decoder, @NotNull b<T> deserializer) {
            t.i(deserializer, "deserializer");
            return deserializer.deserialize(decoder);
        }
    }

    <T> T D(@NotNull b<T> bVar);

    boolean E();

    byte H();

    @NotNull
    c a();

    @NotNull
    ca.c b(@NotNull SerialDescriptor serialDescriptor);

    int e(@NotNull SerialDescriptor serialDescriptor);

    int h();

    @Nullable
    Void j();

    long m();

    @NotNull
    Decoder q(@NotNull SerialDescriptor serialDescriptor);

    short s();

    float t();

    double v();

    boolean w();

    char x();

    @NotNull
    String z();
}
