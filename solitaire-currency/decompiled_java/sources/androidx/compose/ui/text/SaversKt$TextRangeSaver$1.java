package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$TextRangeSaver$1 extends v implements p<SaverScope, TextRange, Object> {
    public static final SaversKt$TextRangeSaver$1 INSTANCE = new SaversKt$TextRangeSaver$1();

    SaversKt$TextRangeSaver$1() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo4invoke(SaverScope saverScope, TextRange textRange) {
        return m3296invokeFDrldGo(saverScope, textRange.m3339unboximpl());
    }

    @Nullable
    /* JADX INFO: renamed from: invoke-FDrldGo, reason: not valid java name */
    public final Object m3296invokeFDrldGo(@NotNull SaverScope Saver, long j10) {
        t.i(Saver, "$this$Saver");
        return kotlin.collections.v.f((Integer) SaversKt.save(Integer.valueOf(TextRange.m3335getStartimpl(j10))), (Integer) SaversKt.save(Integer.valueOf(TextRange.m3330getEndimpl(j10))));
    }
}
