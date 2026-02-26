package androidx.window.layout;

import androidx.window.sidecar.SidecarDisplayFeature;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SidecarAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
final class SidecarAdapter$translate$checkedFeature$3 extends v implements l<SidecarDisplayFeature, Boolean> {
    public static final SidecarAdapter$translate$checkedFeature$3 INSTANCE = new SidecarAdapter$translate$checkedFeature$3();

    SidecarAdapter$translate$checkedFeature$3() {
        super(1);
    }

    @Override // h9.l
    @NotNull
    public final Boolean invoke(@NotNull SidecarDisplayFeature require) {
        t.i(require, "$this$require");
        boolean z10 = true;
        if (require.getType() == 1 && require.getRect().width() != 0 && require.getRect().height() != 0) {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }
}
