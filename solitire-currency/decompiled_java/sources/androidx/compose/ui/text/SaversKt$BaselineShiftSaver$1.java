package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.style.BaselineShift;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$BaselineShiftSaver$1 extends v implements p<SaverScope, BaselineShift, Object> {
    public static final SaversKt$BaselineShiftSaver$1 INSTANCE = new SaversKt$BaselineShiftSaver$1();

    SaversKt$BaselineShiftSaver$1() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo4invoke(SaverScope saverScope, BaselineShift baselineShift) {
        return m3290invoke8a2Sb4w(saverScope, baselineShift.m3548unboximpl());
    }

    @Nullable
    /* JADX INFO: renamed from: invoke-8a2Sb4w, reason: not valid java name */
    public final Object m3290invoke8a2Sb4w(@NotNull SaverScope Saver, float f10) {
        t.i(Saver, "$this$Saver");
        return Float.valueOf(f10);
    }
}
