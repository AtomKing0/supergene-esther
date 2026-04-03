package androidx.compose.ui.text;

import androidx.compose.ui.text.style.BaselineShift;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$BaselineShiftSaver$2 extends v implements l<Object, BaselineShift> {
    public static final SaversKt$BaselineShiftSaver$2 INSTANCE = new SaversKt$BaselineShiftSaver$2();

    SaversKt$BaselineShiftSaver$2() {
        super(1);
    }

    @Override // h9.l
    @Nullable
    /* JADX INFO: renamed from: invoke-jTk7eUs, reason: not valid java name and merged with bridge method [inline-methods] */
    public final BaselineShift invoke(@NotNull Object it) {
        t.i(it, "it");
        return BaselineShift.m3542boximpl(BaselineShift.m3543constructorimpl(((Float) it).floatValue()));
    }
}
