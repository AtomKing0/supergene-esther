package da;

import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Tagged.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class z0 extends y1<String> {
    @NotNull
    protected abstract String a0(@NotNull String str, @NotNull String str2);

    @NotNull
    protected String b0(@NotNull SerialDescriptor descriptor, int i10) {
        kotlin.jvm.internal.t.i(descriptor, "descriptor");
        return descriptor.e(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.y1
    @NotNull
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public final String X(@NotNull SerialDescriptor serialDescriptor, int i10) {
        kotlin.jvm.internal.t.i(serialDescriptor, "<this>");
        return d0(b0(serialDescriptor, i10));
    }

    @NotNull
    protected final String d0(@NotNull String nestedName) {
        kotlin.jvm.internal.t.i(nestedName, "nestedName");
        String strW = W();
        if (strW == null) {
            strW = "";
        }
        return a0(strW, nestedName);
    }
}
