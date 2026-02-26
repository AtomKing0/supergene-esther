package ba;

import da.r1;
import kotlin.jvm.internal.t;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ContextAware.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b {
    @Nullable
    public static final KClass<?> a(@NotNull SerialDescriptor serialDescriptor) {
        t.i(serialDescriptor, "<this>");
        if (serialDescriptor instanceof c) {
            return ((c) serialDescriptor).f2285b;
        }
        if (serialDescriptor instanceof r1) {
            return a(((r1) serialDescriptor).j());
        }
        return null;
    }

    @Nullable
    public static final SerialDescriptor b(@NotNull fa.c cVar, @NotNull SerialDescriptor descriptor) {
        KSerializer kSerializerC;
        t.i(cVar, "<this>");
        t.i(descriptor, "descriptor");
        KClass<?> kClassA = a(descriptor);
        if (kClassA == null || (kSerializerC = fa.c.c(cVar, kClassA, null, 2, null)) == null) {
            return null;
        }
        return kSerializerC.getDescriptor();
    }

    @NotNull
    public static final SerialDescriptor c(@NotNull SerialDescriptor serialDescriptor, @NotNull KClass<?> context) {
        t.i(serialDescriptor, "<this>");
        t.i(context, "context");
        return new c(serialDescriptor, context);
    }
}
