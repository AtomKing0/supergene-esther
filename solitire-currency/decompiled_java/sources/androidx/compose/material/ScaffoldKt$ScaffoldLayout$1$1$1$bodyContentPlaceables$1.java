package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import h9.p;
import h9.q;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Scaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ int $$dirty;
    final /* synthetic */ int $bottomBarHeight;
    final /* synthetic */ q<PaddingValues, Composer, Integer, k0> $content;
    final /* synthetic */ SubcomposeMeasureScope $this_SubcomposeLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ScaffoldKt$ScaffoldLayout$1$1$1$bodyContentPlaceables$1(SubcomposeMeasureScope subcomposeMeasureScope, int i10, q<? super PaddingValues, ? super Composer, ? super Integer, k0> qVar, int i11) {
        super(2);
        this.$this_SubcomposeLayout = subcomposeMeasureScope;
        this.$bottomBarHeight = i10;
        this.$content = qVar;
        this.$$dirty = i11;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return k0.f35197a;
    }

    @Composable
    public final void invoke(@Nullable Composer composer, int i10) {
        if ((i10 & 11) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
        } else {
            this.$content.invoke(PaddingKt.m396PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, this.$this_SubcomposeLayout.mo293toDpu2uoSUM(this.$bottomBarHeight), 7, null), composer, Integer.valueOf((this.$$dirty >> 6) & 112));
        }
    }
}
