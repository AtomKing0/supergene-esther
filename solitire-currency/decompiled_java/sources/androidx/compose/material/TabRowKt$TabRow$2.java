package androidx.compose.material;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import h9.p;
import h9.q;
import java.util.List;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
final class TabRowKt$TabRow$2 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ p<Composer, Integer, k0> $divider;
    final /* synthetic */ q<List<TabPosition>, Composer, Integer, k0> $indicator;
    final /* synthetic */ p<Composer, Integer, k0> $tabs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TabRowKt$TabRow$2(p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, q<? super List<TabPosition>, ? super Composer, ? super Integer, k0> qVar, int i10) {
        super(2);
        this.$tabs = pVar;
        this.$divider = pVar2;
        this.$indicator = qVar;
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
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, null);
        p<Composer, Integer, k0> pVar = this.$tabs;
        p<Composer, Integer, k0> pVar2 = this.$divider;
        q<List<TabPosition>, Composer, Integer, k0> qVar = this.$indicator;
        int i11 = this.$$dirty;
        composer.startReplaceableGroup(1618982084);
        boolean zChanged = composer.changed(pVar) | composer.changed(pVar2) | composer.changed(qVar);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new TabRowKt$TabRow$2$1$1(pVar, pVar2, qVar, i11);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        SubcomposeLayoutKt.SubcomposeLayout(modifierFillMaxWidth$default, (p) objRememberedValue, composer, 6, 0);
    }
}
