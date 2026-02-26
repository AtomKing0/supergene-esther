package da;

import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CollectionDescriptors.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class m1 extends s0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f24597c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m1(@NotNull SerialDescriptor primitive) {
        super(primitive, null);
        kotlin.jvm.internal.t.i(primitive, "primitive");
        this.f24597c = primitive.h() + "Array";
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    @NotNull
    public String h() {
        return this.f24597c;
    }
}
