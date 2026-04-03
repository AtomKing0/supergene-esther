package da;

import java.util.Arrays;
import java.util.Iterator;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PluginGeneratedSerialDescriptor.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class j1 {
    public static final int a(@NotNull SerialDescriptor serialDescriptor, @NotNull SerialDescriptor[] typeParams) {
        kotlin.jvm.internal.t.i(serialDescriptor, "<this>");
        kotlin.jvm.internal.t.i(typeParams, "typeParams");
        int iHashCode = (serialDescriptor.h().hashCode() * 31) + Arrays.hashCode(typeParams);
        Iterable<SerialDescriptor> iterableA = ba.g.a(serialDescriptor);
        Iterator<SerialDescriptor> it = iterableA.iterator();
        int iHashCode2 = 1;
        int i10 = 1;
        while (true) {
            int iHashCode3 = 0;
            if (!it.hasNext()) {
                break;
            }
            int i11 = i10 * 31;
            String strH = it.next().h();
            if (strH != null) {
                iHashCode3 = strH.hashCode();
            }
            i10 = i11 + iHashCode3;
        }
        Iterator<SerialDescriptor> it2 = iterableA.iterator();
        while (it2.hasNext()) {
            int i12 = iHashCode2 * 31;
            ba.i kind = it2.next().getKind();
            iHashCode2 = i12 + (kind != null ? kind.hashCode() : 0);
        }
        return (((iHashCode * 31) + i10) * 31) + iHashCode2;
    }
}
