package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.graphics.Color;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.e0;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$ColorSaver$1 extends v implements p<SaverScope, Color, Object> {
    public static final SaversKt$ColorSaver$1 INSTANCE = new SaversKt$ColorSaver$1();

    SaversKt$ColorSaver$1() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo4invoke(SaverScope saverScope, Color color) {
        return m3292invoke4WTKRHQ(saverScope, color.m1608unboximpl());
    }

    @Nullable
    /* JADX INFO: renamed from: invoke-4WTKRHQ, reason: not valid java name */
    public final Object m3292invoke4WTKRHQ(@NotNull SaverScope Saver, long j10) {
        t.i(Saver, "$this$Saver");
        return e0.a(j10);
    }
}
