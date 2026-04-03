package da;

import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CollectionDescriptors.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g0 extends s0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(@NotNull SerialDescriptor elementDesc) {
        super(elementDesc, null);
        kotlin.jvm.internal.t.i(elementDesc, "elementDesc");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String h() {
        return "kotlin.collections.HashSet";
    }
}
