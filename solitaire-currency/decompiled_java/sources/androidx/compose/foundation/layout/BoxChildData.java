package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Box.kt */
/* JADX INFO: loaded from: classes.dex */
final class BoxChildData extends InspectorValueInfo implements ParentDataModifier {

    @NotNull
    private Alignment alignment;
    private boolean matchParentSize;

    public /* synthetic */ BoxChildData(Alignment alignment, boolean z10, h9.l lVar, int i10, kotlin.jvm.internal.k kVar) {
        this(alignment, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? InspectableValueKt.getNoInspectorInfo() : lVar);
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
        BoxChildData boxChildData = obj instanceof BoxChildData ? (BoxChildData) obj : null;
        if (boxChildData == null) {
            return false;
        }
        return t.d(this.alignment, boxChildData.alignment) && this.matchParentSize == boxChildData.matchParentSize;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return androidx.compose.ui.b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return androidx.compose.ui.b.d(this, obj, pVar);
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final boolean getMatchParentSize() {
        return this.matchParentSize;
    }

    public int hashCode() {
        return (this.alignment.hashCode() * 31) + androidx.compose.foundation.e.a(this.matchParentSize);
    }

    @Override // androidx.compose.ui.layout.ParentDataModifier
    @NotNull
    public BoxChildData modifyParentData(@NotNull Density density, @Nullable Object obj) {
        t.i(density, "<this>");
        return this;
    }

    public final void setAlignment(@NotNull Alignment alignment) {
        t.i(alignment, "<set-?>");
        this.alignment = alignment;
    }

    public final void setMatchParentSize(boolean z10) {
        this.matchParentSize = z10;
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "BoxChildData(alignment=" + this.alignment + ", matchParentSize=" + this.matchParentSize + ')';
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxChildData(@NotNull Alignment alignment, boolean z10, @NotNull h9.l<? super InspectorInfo, k0> inspectorInfo) {
        super(inspectorInfo);
        t.i(alignment, "alignment");
        t.i(inspectorInfo, "inspectorInfo");
        this.alignment = alignment;
        this.matchParentSize = z10;
    }
}
