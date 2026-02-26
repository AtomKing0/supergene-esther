package da;

import java.util.Arrays;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: InlineClassDescriptor.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i0 extends PluginGeneratedSerialDescriptor {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f24582m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(@NotNull String name, @NotNull d0<?> generatedSerializer) {
        super(name, generatedSerializer, 1);
        kotlin.jvm.internal.t.i(name, "name");
        kotlin.jvm.internal.t.i(generatedSerializer, "generatedSerializer");
        this.f24582m = true;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i0) {
            SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
            if (kotlin.jvm.internal.t.d(h(), serialDescriptor.h())) {
                i0 i0Var = (i0) obj;
                if ((i0Var.isInline() && Arrays.equals(o(), i0Var.o())) && d() == serialDescriptor.d()) {
                    int iD = d();
                    for (int i10 = 0; i10 < iD; i10++) {
                        if (kotlin.jvm.internal.t.d(g(i10).h(), serialDescriptor.g(i10).h()) && kotlin.jvm.internal.t.d(g(i10).getKind(), serialDescriptor.g(i10).getKind())) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return this.f24582m;
    }
}
