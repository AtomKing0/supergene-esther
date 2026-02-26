package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.node.LayoutNodeEntity;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LayoutNodeEntity.kt */
/* JADX INFO: loaded from: classes.dex */
public class LayoutNodeEntity<T extends LayoutNodeEntity<T, M>, M extends Modifier> {
    private boolean isAttached;

    @NotNull
    private final LayoutNodeWrapper layoutNodeWrapper;

    @NotNull
    private final M modifier;

    @Nullable
    private T next;

    public LayoutNodeEntity(@NotNull LayoutNodeWrapper layoutNodeWrapper, @NotNull M modifier) {
        t.i(layoutNodeWrapper, "layoutNodeWrapper");
        t.i(modifier, "modifier");
        this.layoutNodeWrapper = layoutNodeWrapper;
        this.modifier = modifier;
    }

    @NotNull
    public final LayoutNode getLayoutNode() {
        return this.layoutNodeWrapper.getLayoutNode$ui_release();
    }

    @NotNull
    public final LayoutNodeWrapper getLayoutNodeWrapper() {
        return this.layoutNodeWrapper;
    }

    @NotNull
    public final M getModifier() {
        return this.modifier;
    }

    @Nullable
    public final T getNext() {
        return this.next;
    }

    /* JADX INFO: renamed from: getSize-YbymL2g, reason: not valid java name */
    public final long m3111getSizeYbymL2g() {
        return this.layoutNodeWrapper.mo2989getSizeYbymL2g();
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    public void onAttach() {
        this.isAttached = true;
    }

    public void onDetach() {
        this.isAttached = false;
    }

    public final void setNext(@Nullable T t10) {
        this.next = t10;
    }
}
