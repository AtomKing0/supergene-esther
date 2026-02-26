package androidx.compose.material;

import androidx.compose.runtime.Composer;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AlertDialog.kt */
/* JADX INFO: loaded from: classes.dex */
final class AlertDialogKt$AlertDialogFlowRow$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ p<Composer, Integer, k0> $content;
    final /* synthetic */ float $crossAxisSpacing;
    final /* synthetic */ float $mainAxisSpacing;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AlertDialogKt$AlertDialogFlowRow$2(float f10, float f11, p<? super Composer, ? super Integer, k0> pVar, int i10) {
        super(2);
        this.$mainAxisSpacing = f10;
        this.$crossAxisSpacing = f11;
        this.$content = pVar;
        this.$$changed = i10;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    public final void invoke(@Nullable Composer composer, int i10) {
        AlertDialogKt.m853AlertDialogFlowRowixp7dh8(this.$mainAxisSpacing, this.$crossAxisSpacing, this.$content, composer, this.$$changed | 1);
    }
}
