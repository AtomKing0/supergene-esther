package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.b;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyGridItemScopeImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class AnimateItemPlacementModifier extends InspectorValueInfo implements ParentDataModifier {

    @NotNull
    private final FiniteAnimationSpec<IntOffset> animationSpec;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimateItemPlacementModifier(@NotNull FiniteAnimationSpec<IntOffset> animationSpec, @NotNull l<? super InspectorInfo, k0> inspectorInfo) {
        super(inspectorInfo);
        t.i(animationSpec, "animationSpec");
        t.i(inspectorInfo, "inspectorInfo");
        this.animationSpec = animationSpec;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(l lVar) {
        return b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(l lVar) {
        return b.b(this, lVar);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AnimateItemPlacementModifier) {
            return !t.d(this.animationSpec, ((AnimateItemPlacementModifier) obj).animationSpec);
        }
        return false;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return b.d(this, obj, pVar);
    }

    @NotNull
    public final FiniteAnimationSpec<IntOffset> getAnimationSpec() {
        return this.animationSpec;
    }

    public int hashCode() {
        return this.animationSpec.hashCode();
    }

    @Override // androidx.compose.ui.layout.ParentDataModifier
    @NotNull
    public Object modifyParentData(@NotNull Density density, @Nullable Object obj) {
        t.i(density, "<this>");
        return this.animationSpec;
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }
}
