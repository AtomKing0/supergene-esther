package ea;

import java.util.Set;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: StreamingJsonEncoder.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Set<SerialDescriptor> f25497a = kotlin.collections.z0.h(aa.a.E(v8.c0.f35170b).getDescriptor(), aa.a.F(v8.e0.f35179b).getDescriptor(), aa.a.D(v8.a0.f35164b).getDescriptor(), aa.a.G(v8.h0.f35185b).getDescriptor());

    public static final boolean a(@NotNull SerialDescriptor serialDescriptor) {
        kotlin.jvm.internal.t.i(serialDescriptor, "<this>");
        return serialDescriptor.isInline() && f25497a.contains(serialDescriptor);
    }
}
