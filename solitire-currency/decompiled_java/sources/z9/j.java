package z9;

import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Encoder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: KSerializer.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface j<T> {
    @NotNull
    SerialDescriptor getDescriptor();

    void serialize(@NotNull Encoder encoder, T t10);
}
