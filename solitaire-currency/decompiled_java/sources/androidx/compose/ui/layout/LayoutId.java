package androidx.compose.ui.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LayoutId.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
final class LayoutId extends InspectorValueInfo implements ParentDataModifier, LayoutIdParentData {

    @NotNull
    private final Object layoutId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LayoutId(@NotNull Object layoutId, @NotNull h9.l<? super InspectorInfo, k0> inspectorInfo) {
        super(inspectorInfo);
        t.i(layoutId, "layoutId");
        t.i(inspectorInfo, "inspectorInfo");
        this.layoutId = layoutId;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(h9.l lVar) {
        return androidx.compose.ui.b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(h9.l lVar) {
        return androidx.compose.ui.b.b(this, lVar);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        LayoutId layoutId = obj instanceof LayoutId ? (LayoutId) obj : null;
        if (layoutId == null) {
            return false;
        }
        return t.d(getLayoutId(), layoutId.getLayoutId());
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    @Override // androidx.compose.ui.layout.LayoutIdParentData
    @NotNull
    public Object getLayoutId() {
        return this.layoutId;
    }

    public int hashCode() {
        return getLayoutId().hashCode();
    }

    @Override // androidx.compose.ui.layout.ParentDataModifier
    @Nullable
    public Object modifyParentData(@NotNull Density density, @Nullable Object obj) {
        t.i(density, "<this>");
        return this;
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "LayoutId(id=" + getLayoutId() + ')';
    }
}
