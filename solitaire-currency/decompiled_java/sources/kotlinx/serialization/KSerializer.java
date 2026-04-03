package kotlinx.serialization;

import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import z9.b;
import z9.j;

/* JADX INFO: compiled from: KSerializer.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface KSerializer<T> extends j<T>, b<T> {
    @Override // z9.j, z9.b
    @NotNull
    SerialDescriptor getDescriptor();
}
