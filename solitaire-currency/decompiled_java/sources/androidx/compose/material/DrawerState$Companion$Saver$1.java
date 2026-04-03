package androidx.compose.material;

import androidx.compose.runtime.saveable.SaverScope;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Drawer.kt */
/* JADX INFO: loaded from: classes.dex */
final class DrawerState$Companion$Saver$1 extends v implements p<SaverScope, DrawerState, DrawerValue> {
    public static final DrawerState$Companion$Saver$1 INSTANCE = new DrawerState$Companion$Saver$1();

    DrawerState$Companion$Saver$1() {
        super(2);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final DrawerValue mo4invoke(@NotNull SaverScope Saver, @NotNull DrawerState it) {
        t.i(Saver, "$this$Saver");
        t.i(it, "it");
        return it.getCurrentValue();
    }
}
