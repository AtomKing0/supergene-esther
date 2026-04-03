package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeWrapper;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SemanticsSort.kt */
/* JADX INFO: loaded from: classes.dex */
final class NodeLocationHolder$compareTo$child2$1 extends v implements l<LayoutNode, Boolean> {
    final /* synthetic */ Rect $view2Bounds;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    NodeLocationHolder$compareTo$child2$1(Rect rect) {
        super(1);
        this.$view2Bounds = rect;
    }

    @Override // h9.l
    @NotNull
    public final Boolean invoke(@NotNull LayoutNode it) {
        t.i(it, "it");
        LayoutNodeWrapper layoutNodeWrapperFindWrapperToGetBounds = SemanticsSortKt.findWrapperToGetBounds(it);
        return Boolean.valueOf(layoutNodeWrapperFindWrapperToGetBounds.isAttached() && !t.d(this.$view2Bounds, LayoutCoordinatesKt.boundsInRoot(layoutNodeWrapperFindWrapperToGetBounds)));
    }
}
