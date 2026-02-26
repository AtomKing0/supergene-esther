package da;

import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Tagged.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class y0 extends x1<String> {
    @NotNull
    protected abstract String Z(@NotNull String str, @NotNull String str2);

    @NotNull
    protected String a0(@NotNull SerialDescriptor desc, int i10) {
        kotlin.jvm.internal.t.i(desc, "desc");
        return desc.e(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // da.x1
    @NotNull
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public final String V(@NotNull SerialDescriptor serialDescriptor, int i10) {
        kotlin.jvm.internal.t.i(serialDescriptor, "<this>");
        return c0(a0(serialDescriptor, i10));
    }

    @NotNull
    protected final String c0(@NotNull String nestedName) {
        kotlin.jvm.internal.t.i(nestedName, "nestedName");
        String strU = U();
        if (strU == null) {
            strU = "";
        }
        return Z(strU, nestedName);
    }
}
