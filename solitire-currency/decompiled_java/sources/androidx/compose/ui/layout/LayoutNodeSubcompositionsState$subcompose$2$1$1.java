package androidx.compose.ui.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SubcomposeLayout.kt */
/* JADX INFO: loaded from: classes.dex */
final class LayoutNodeSubcompositionsState$subcompose$2$1$1 extends v implements p<Composer, Integer, k0> {
    final /* synthetic */ p<Composer, Integer, k0> $content;
    final /* synthetic */ LayoutNodeSubcompositionsState.NodeState $nodeState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LayoutNodeSubcompositionsState$subcompose$2$1$1(LayoutNodeSubcompositionsState.NodeState nodeState, p<? super Composer, ? super Integer, k0> pVar) {
        super(2);
        this.$nodeState = nodeState;
        this.$content = pVar;
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
            return;
        }
        boolean active = this.$nodeState.getActive();
        p<Composer, Integer, k0> pVar = this.$content;
        composer.startReusableGroup(207, Boolean.valueOf(active));
        boolean zChanged = composer.changed(active);
        if (active) {
            pVar.mo4invoke(composer, 0);
        } else {
            composer.deactivateToEndGroup(zChanged);
        }
        composer.endReusableGroup();
    }
}
