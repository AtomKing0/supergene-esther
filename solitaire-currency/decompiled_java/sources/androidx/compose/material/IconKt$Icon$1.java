package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Icon.kt */
/* JADX INFO: loaded from: classes.dex */
final class IconKt$Icon$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ String $contentDescription;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Painter $painter;
    final /* synthetic */ long $tint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IconKt$Icon$1(Painter painter, String str, Modifier modifier, long j10, int i10, int i11) {
        super(2);
        this.$painter = painter;
        this.$contentDescription = str;
        this.$modifier = modifier;
        this.$tint = j10;
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
        IconKt.m1048Iconww6aTOc(this.$painter, this.$contentDescription, this.$modifier, this.$tint, composer, this.$$changed | 1, this.$$default);
    }
}
