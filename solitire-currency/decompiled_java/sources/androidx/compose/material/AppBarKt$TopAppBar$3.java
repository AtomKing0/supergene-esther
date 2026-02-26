package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AppBar.kt */
/* JADX INFO: loaded from: classes.dex */
final class AppBarKt$TopAppBar$3 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ q<RowScope, Composer, Integer, k0> $content;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ float $elevation;
    final /* synthetic */ Modifier $modifier;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AppBarKt$TopAppBar$3(Modifier modifier, long j10, long j11, float f10, PaddingValues paddingValues, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar, int i10, int i11) {
        super(2);
        this.$modifier = modifier;
        this.$backgroundColor = j10;
        this.$contentColor = j11;
        this.$elevation = f10;
        this.$contentPadding = paddingValues;
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
        AppBarKt.m861TopAppBarHsRjFd4(this.$modifier, this.$backgroundColor, this.$contentColor, this.$elevation, this.$contentPadding, this.$content, composer, this.$$changed | 1, this.$$default);
    }
}
