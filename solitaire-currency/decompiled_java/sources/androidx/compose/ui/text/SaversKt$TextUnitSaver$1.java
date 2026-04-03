package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$TextUnitSaver$1 extends v implements p<SaverScope, TextUnit, Object> {
    public static final SaversKt$TextUnitSaver$1 INSTANCE = new SaversKt$TextUnitSaver$1();

    SaversKt$TextUnitSaver$1() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo4invoke(SaverScope saverScope, TextUnit textUnit) {
        return m3298invokempE4wyQ(saverScope, textUnit.m3863unboximpl());
    }

    @Nullable
    /* JADX INFO: renamed from: invoke-mpE4wyQ, reason: not valid java name */
    public final Object m3298invokempE4wyQ(@NotNull SaverScope Saver, long j10) {
        t.i(Saver, "$this$Saver");
        return kotlin.collections.v.f(SaversKt.save(Float.valueOf(TextUnit.m3854getValueimpl(j10))), SaversKt.save(TextUnitType.m3879boximpl(TextUnit.m3853getTypeUIouoOA(j10))));
    }
}
