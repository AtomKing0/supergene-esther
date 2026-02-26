package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$OffsetSaver$1 extends v implements p<SaverScope, Offset, Object> {
    public static final SaversKt$OffsetSaver$1 INSTANCE = new SaversKt$OffsetSaver$1();

    SaversKt$OffsetSaver$1() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo4invoke(SaverScope saverScope, Offset offset) {
        return m3294invokeUv8p0NA(saverScope, offset.m1377unboximpl());
    }

    @Nullable
    /* JADX INFO: renamed from: invoke-Uv8p0NA, reason: not valid java name */
    public final Object m3294invokeUv8p0NA(@NotNull SaverScope Saver, long j10) {
        t.i(Saver, "$this$Saver");
        return Offset.m1364equalsimpl0(j10, Offset.Companion.m1382getUnspecifiedF1C5BW0()) ? Boolean.FALSE : kotlin.collections.v.f((Float) SaversKt.save(Float.valueOf(Offset.m1367getXimpl(j10))), (Float) SaversKt.save(Float.valueOf(Offset.m1368getYimpl(j10))));
    }
}
