package androidx.compose.material;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.window.PopupProperties;
import h9.a;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AndroidMenu.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidMenu_androidKt$DropdownMenu$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$default;
    final /* synthetic */ q<ColumnScope, Composer, Integer, k0> $content;
    final /* synthetic */ boolean $expanded;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ long $offset;
    final /* synthetic */ a<k0> $onDismissRequest;
    final /* synthetic */ PopupProperties $properties;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AndroidMenu_androidKt$DropdownMenu$2(boolean z10, a<k0> aVar, Modifier modifier, long j10, PopupProperties popupProperties, q<? super ColumnScope, ? super Composer, ? super Integer, k0> qVar, int i10, int i11) {
        super(2);
        this.$expanded = z10;
        this.$onDismissRequest = aVar;
        this.$modifier = modifier;
        this.$offset = j10;
        this.$properties = popupProperties;
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
        AndroidMenu_androidKt.m856DropdownMenuILWXrKs(this.$expanded, this.$onDismissRequest, this.$modifier, this.$offset, this.$properties, this.$content, composer, this.$$changed | 1, this.$$default);
    }
}
