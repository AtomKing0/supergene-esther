package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.EntityList;
import androidx.compose.ui.node.LayoutNodeEntity;
import androidx.compose.ui.node.LayoutNodeWrapper;
import androidx.compose.ui.node.Owner;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SemanticsEntity.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SemanticsEntity extends LayoutNodeEntity<SemanticsEntity, SemanticsModifier> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SemanticsEntity(@NotNull LayoutNodeWrapper wrapped, @NotNull SemanticsModifier modifier) {
        super(wrapped, modifier);
        t.i(wrapped, "wrapped");
        t.i(modifier, "modifier");
    }

    private final boolean getUseMinimumTouchTarget() {
        return SemanticsConfigurationKt.getOrNull(getModifier().getSemanticsConfiguration(), SemanticsActions.INSTANCE.getOnClick()) != null;
    }

    @NotNull
    public final SemanticsConfiguration collapsedSemanticsConfiguration() {
        SemanticsEntity next = getNext();
        SemanticsEntity semanticsEntity = null;
        if (next == null) {
            LayoutNodeWrapper wrapped$ui_release = getLayoutNodeWrapper().getWrapped$ui_release();
            if (wrapped$ui_release != null) {
                while (wrapped$ui_release != null && !EntityList.m3075has0OSVbXo(wrapped$ui_release.m3125getEntitiesCHwCgZE(), EntityList.Companion.m3086getSemanticsEntityTypeEEbPh1w())) {
                    wrapped$ui_release = wrapped$ui_release.getWrapped$ui_release();
                }
                if (wrapped$ui_release != null && (next = (SemanticsEntity) EntityList.m3077head0OSVbXo(wrapped$ui_release.m3125getEntitiesCHwCgZE(), EntityList.Companion.m3086getSemanticsEntityTypeEEbPh1w())) != null) {
                    LayoutNodeWrapper layoutNodeWrapper = next.getLayoutNodeWrapper();
                    while (layoutNodeWrapper != null) {
                        if (next != null) {
                            semanticsEntity = next;
                            break;
                        }
                        layoutNodeWrapper = layoutNodeWrapper.getWrapped$ui_release();
                        next = layoutNodeWrapper != null ? (SemanticsEntity) EntityList.m3077head0OSVbXo(layoutNodeWrapper.m3125getEntitiesCHwCgZE(), EntityList.Companion.m3086getSemanticsEntityTypeEEbPh1w()) : null;
                    }
                }
            }
        } else {
            LayoutNodeWrapper layoutNodeWrapper2 = next.getLayoutNodeWrapper();
            while (layoutNodeWrapper2 != null) {
                if (next != null) {
                    semanticsEntity = next;
                    break;
                }
                layoutNodeWrapper2 = layoutNodeWrapper2.getWrapped$ui_release();
                next = layoutNodeWrapper2 != null ? (SemanticsEntity) EntityList.m3077head0OSVbXo(layoutNodeWrapper2.m3125getEntitiesCHwCgZE(), EntityList.Companion.m3086getSemanticsEntityTypeEEbPh1w()) : null;
            }
        }
        if (semanticsEntity == null || getModifier().getSemanticsConfiguration().isClearingSemantics()) {
            return getModifier().getSemanticsConfiguration();
        }
        SemanticsConfiguration semanticsConfigurationCopy = getModifier().getSemanticsConfiguration().copy();
        semanticsConfigurationCopy.collapsePeer$ui_release(semanticsEntity.collapsedSemanticsConfiguration());
        return semanticsConfigurationCopy;
    }

    @Nullable
    public final SemanticsEntity nearestSemantics$ui_release(@NotNull l<? super SemanticsEntity, Boolean> predicate) {
        t.i(predicate, "predicate");
        LayoutNodeWrapper layoutNodeWrapper = getLayoutNodeWrapper();
        SemanticsEntity next = this;
        while (layoutNodeWrapper != null) {
            while (next != null) {
                if (predicate.invoke(next).booleanValue()) {
                    return next;
                }
                next = next.getNext();
            }
            layoutNodeWrapper = layoutNodeWrapper.getWrapped$ui_release();
            next = layoutNodeWrapper != null ? (SemanticsEntity) EntityList.m3077head0OSVbXo(layoutNodeWrapper.m3125getEntitiesCHwCgZE(), EntityList.Companion.m3086getSemanticsEntityTypeEEbPh1w()) : null;
        }
        return null;
    }

    @Override // androidx.compose.ui.node.LayoutNodeEntity
    public void onAttach() {
        super.onAttach();
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onSemanticsChange();
        }
    }

    @Override // androidx.compose.ui.node.LayoutNodeEntity
    public void onDetach() {
        super.onDetach();
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onSemanticsChange();
        }
    }

    @NotNull
    public String toString() {
        return super.toString() + " id: " + getModifier().getId() + " config: " + getModifier().getSemanticsConfiguration();
    }

    @NotNull
    public final Rect touchBoundsInRoot() {
        return !isAttached() ? Rect.Companion.getZero() : !getUseMinimumTouchTarget() ? LayoutCoordinatesKt.boundsInRoot(getLayoutNodeWrapper()) : getLayoutNodeWrapper().touchBoundsInRoot();
    }
}
