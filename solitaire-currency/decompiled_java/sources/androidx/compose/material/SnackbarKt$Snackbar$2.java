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
final class SnackbarKt$Snackbar$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ p<Composer, Integer, k0> $action;
    final /* synthetic */ boolean $actionOnNewLine;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ p<Composer, Integer, k0> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ float $elevation;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SnackbarKt$Snackbar$2(Modifier modifier, p<? super Composer, ? super Integer, k0> pVar, boolean z10, Shape shape, long j10, long j11, float f10, p<? super Composer, ? super Integer, k0> pVar2, int i10, int i11) {
        super(2);
        this.$modifier = modifier;
        this.$action = pVar;
        this.$actionOnNewLine = z10;
        this.$shape = shape;
        this.$backgroundColor = j10;
        this.$contentColor = j11;
        this.$elevation = f10;
        this.$content = pVar2;
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
        SnackbarKt.m1129Snackbar7zSek6w(this.$modifier, this.$action, this.$actionOnNewLine, this.$shape, this.$backgroundColor, this.$contentColor, this.$elevation, this.$content, composer, this.$$changed | 1, this.$$default);
    }
}
