package ea;

import ba.i;
import ba.j;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WriteMode.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class z0 {
    @NotNull
    public static final SerialDescriptor a(@NotNull SerialDescriptor serialDescriptor, @NotNull fa.c module) {
        SerialDescriptor serialDescriptorA;
        kotlin.jvm.internal.t.i(serialDescriptor, "<this>");
        kotlin.jvm.internal.t.i(module, "module");
        if (!kotlin.jvm.internal.t.d(serialDescriptor.getKind(), i.a.f2319a)) {
            return serialDescriptor.isInline() ? a(serialDescriptor.g(0), module) : serialDescriptor;
        }
        SerialDescriptor serialDescriptorB = ba.b.b(module, serialDescriptor);
        return (serialDescriptorB == null || (serialDescriptorA = a(serialDescriptorB, module)) == null) ? serialDescriptor : serialDescriptorA;
    }

    @NotNull
    public static final y0 b(@NotNull kotlinx.serialization.json.a aVar, @NotNull SerialDescriptor desc) {
        kotlin.jvm.internal.t.i(aVar, "<this>");
        kotlin.jvm.internal.t.i(desc, "desc");
        ba.i kind = desc.getKind();
        if (kind instanceof ba.d) {
            return y0.POLY_OBJ;
        }
        if (kotlin.jvm.internal.t.d(kind, j.b.f2322a)) {
            return y0.LIST;
        }
        if (!kotlin.jvm.internal.t.d(kind, j.c.f2323a)) {
            return y0.OBJ;
        }
        SerialDescriptor serialDescriptorA = a(desc.g(0), aVar.a());
        ba.i kind2 = serialDescriptorA.getKind();
        if ((kind2 instanceof ba.e) || kotlin.jvm.internal.t.d(kind2, i.b.f2320a)) {
            return y0.MAP;
        }
        if (aVar.e().b()) {
            return y0.LIST;
        }
        throw a0.d(serialDescriptorA);
    }
}
