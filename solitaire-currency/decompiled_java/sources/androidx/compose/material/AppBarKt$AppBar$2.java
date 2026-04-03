package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
final class AppBarKt$AppBar$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ q<RowScope, Composer, Integer, k0> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ float $elevation;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AppBarKt$AppBar$2(long j10, long j11, float f10, PaddingValues paddingValues, Shape shape, Modifier modifier, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar, int i10, int i11) {
        super(2);
        this.$backgroundColor = j10;
        this.$contentColor = j11;
        this.$elevation = f10;
        this.$contentPadding = paddingValues;
        this.$shape = shape;
        this.$modifier = modifier;
        this.$content = qVar;
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
        AppBarKt.m859AppBarcelAv9A(this.$backgroundColor, this.$contentColor, this.$elevation, this.$contentPadding, this.$shape, this.$modifier, this.$content, composer, this.$$changed | 1, this.$$default);
    }
}
