package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Snackbar.kt */
/* JADX INFO: loaded from: classes.dex */
final class SnackbarKt$Snackbar$4 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $actionColor;
    final /* synthetic */ boolean $actionOnNewLine;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ float $elevation;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ SnackbarData $snackbarData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnackbarKt$Snackbar$4(SnackbarData snackbarData, Modifier modifier, boolean z10, Shape shape, long j10, long j11, long j12, float f10, int i10, int i11) {
        super(2);
        this.$snackbarData = snackbarData;
        this.$modifier = modifier;
        this.$actionOnNewLine = z10;
        this.$shape = shape;
        this.$backgroundColor = j10;
        this.$contentColor = j11;
        this.$actionColor = j12;
        this.$elevation = f10;
        this.$$changed = i10;
        this.$$default = i11;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        SnackbarKt.m1130SnackbarsPrSdHI(this.$snackbarData, this.$modifier, this.$actionOnNewLine, this.$shape, this.$backgroundColor, this.$contentColor, this.$actionColor, this.$elevation, composer, this.$$changed | 1, this.$$default);
    }
}
