package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AndroidAlertDialog.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidAlertDialog_androidKt$AlertDialog$1$1$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ p<Composer, Integer, k0> $confirmButton;
    final /* synthetic */ p<Composer, Integer, k0> $dismissButton;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    AndroidAlertDialog_androidKt$AlertDialog$1$1$1(p<? super Composer, ? super Integer, k0> pVar, int i10, p<? super Composer, ? super Integer, k0> pVar2) {
        super(2);
        this.$dismissButton = pVar;
        this.$$dirty = i10;
        this.$confirmButton = pVar2;
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
        p<Composer, Integer, k0> pVar = this.$dismissButton;
        composer.startReplaceableGroup(-1046483318);
        if (pVar != null) {
            pVar.mo4invoke(composer, Integer.valueOf((this.$$dirty >> 9) & 14));
            k0 k0Var = k0.f35197a;
        }
        composer.endReplaceableGroup();
        this.$confirmButton.mo4invoke(composer, Integer.valueOf((this.$$dirty >> 3) & 14));
    }
}
