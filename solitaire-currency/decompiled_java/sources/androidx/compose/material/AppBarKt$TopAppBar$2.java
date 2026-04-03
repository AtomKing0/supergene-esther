package androidx.compose.material;

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
final class AppBarKt$TopAppBar$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ q<RowScope, Composer, Integer, k0> $actions;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ float $elevation;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ p<Composer, Integer, k0> $navigationIcon;
    final /* synthetic */ p<Composer, Integer, k0> $title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AppBarKt$TopAppBar$2(p<? super Composer, ? super Integer, k0> pVar, Modifier modifier, p<? super Composer, ? super Integer, k0> pVar2, q<? super RowScope, ? super Composer, ? super Integer, k0> qVar, long j10, long j11, float f10, int i10, int i11) {
        super(2);
        this.$title = pVar;
        this.$modifier = modifier;
        this.$navigationIcon = pVar2;
        this.$actions = qVar;
        this.$backgroundColor = j10;
        this.$contentColor = j11;
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
        AppBarKt.m862TopAppBarxWeB9s(this.$title, this.$modifier, this.$navigationIcon, this.$actions, this.$backgroundColor, this.$contentColor, this.$elevation, composer, this.$$changed | 1, this.$$default);
    }
}
