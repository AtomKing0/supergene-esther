package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes.dex */
final class ListItemKt$OffsetToBaselineOrCenter$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ p<Composer, Integer, k0> $content;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ float $offset;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ListItemKt$OffsetToBaselineOrCenter$2(float f10, Modifier modifier, p<? super Composer, ? super Integer, k0> pVar, int i10, int i11) {
        super(2);
        this.$offset = f10;
        this.$modifier = modifier;
        this.$content = pVar;
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
        ListItemKt.m1051OffsetToBaselineOrCenterKz89ssw(this.$offset, this.$modifier, this.$content, composer, this.$$changed | 1, this.$$default);
    }
}
