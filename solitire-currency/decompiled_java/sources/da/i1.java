package da;

import java.util.ArrayList;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PluginExceptions.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i1 {
    public static final void a(int i10, int i11, @NotNull SerialDescriptor descriptor) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        ArrayList arrayList = new ArrayList();
        int i12 = (~i10) & i11;
        for (int i13 = 0; i13 < 32; i13++) {
            if ((i12 & 1) != 0) {
                arrayList.add(descriptor.e(i13));
            }
            i12 >>>= 1;
        }
        throw new z9.c(arrayList, descriptor.h());
    }
}
