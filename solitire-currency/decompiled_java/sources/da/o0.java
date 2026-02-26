package da;

import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CollectionDescriptors.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class o0 extends w0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(@NotNull SerialDescriptor keyDesc, @NotNull SerialDescriptor valueDesc) {
        super("kotlin.collections.LinkedHashMap", keyDesc, valueDesc, null);
        kotlin.jvm.internal.t.i(keyDesc, "keyDesc");
        kotlin.jvm.internal.t.i(valueDesc, "valueDesc");
    }
}
