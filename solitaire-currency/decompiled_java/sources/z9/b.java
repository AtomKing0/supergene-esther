package z9;

import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: KSerializer.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface b<T> {
    T deserialize(@NotNull Decoder decoder);

    @NotNull
    SerialDescriptor getDescriptor();
}
