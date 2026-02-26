package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AndroidAlertDialog.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidAlertDialog_androidKt$AlertDialog$3 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ long $backgroundColor;
    final /* synthetic */ p<Composer, Integer, k0> $buttons;
    final /* synthetic */ long $contentColor;
    final /* synthetic */ Modifier $modifier;
    final /* synthetic */ Shape $shape;
    final /* synthetic */ p<Composer, Integer, k0> $text;
    final /* synthetic */ p<Composer, Integer, k0> $title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AndroidAlertDialog_androidKt$AlertDialog$3(p<? super Composer, ? super Integer, k0> pVar, Modifier modifier, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, Shape shape, long j10, long j11, int i10) {
        super(2);
        this.$buttons = pVar;
        this.$modifier = modifier;
        this.$title = pVar2;
        this.$text = pVar3;
        this.$shape = shape;
        this.$backgroundColor = j10;
        this.$contentColor = j11;
        this.$$dirty = i10;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i10) {
        if ((i10 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        p<Composer, Integer, k0> pVar = this.$buttons;
        Modifier modifier = this.$modifier;
        p<Composer, Integer, k0> pVar2 = this.$title;
        p<Composer, Integer, k0> pVar3 = this.$text;
        Shape shape = this.$shape;
        long j10 = this.$backgroundColor;
        long j11 = this.$contentColor;
        int i11 = this.$$dirty;
        AlertDialogKt.m852AlertDialogContentWMdw5o4(pVar, modifier, pVar2, pVar3, shape, j10, j11, composer, ((i11 >> 3) & 14) | ((i11 >> 3) & 112) | ((i11 >> 3) & 896) | ((i11 >> 3) & 7168) | ((i11 >> 3) & 57344) | ((i11 >> 3) & 458752) | ((i11 >> 3) & 3670016), 0);
    }
}
