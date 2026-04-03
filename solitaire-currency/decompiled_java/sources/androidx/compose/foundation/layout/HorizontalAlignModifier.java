package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: RowColumnImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class HorizontalAlignModifier extends InspectorValueInfo implements ParentDataModifier {

    @NotNull
    private final Alignment.Horizontal horizontal;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalAlignModifier(@NotNull Alignment.Horizontal horizontal, @NotNull h9.l<? super InspectorInfo, k0> inspectorInfo) {
        super(inspectorInfo);
        t.i(horizontal, "horizontal");
        t.i(inspectorInfo, "inspectorInfo");
        this.horizontal = horizontal;
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
        HorizontalAlignModifier horizontalAlignModifier = obj instanceof HorizontalAlignModifier ? (HorizontalAlignModifier) obj : null;
        if (horizontalAlignModifier == null) {
            return false;
        }
        return t.d(this.horizontal, horizontalAlignModifier.horizontal);
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
    public final Alignment.Horizontal getHorizontal() {
        return this.horizontal;
    }

    public int hashCode() {
        return this.horizontal.hashCode();
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return androidx.compose.ui.a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "HorizontalAlignModifier(horizontal=" + this.horizontal + ')';
    }

    @Override // androidx.compose.ui.layout.ParentDataModifier
    @NotNull
    public RowColumnParentData modifyParentData(@NotNull Density density, @Nullable Object obj) {
        t.i(density, "<this>");
        RowColumnParentData rowColumnParentData = obj instanceof RowColumnParentData ? (RowColumnParentData) obj : null;
        if (rowColumnParentData == null) {
            rowColumnParentData = new RowColumnParentData(0.0f, false, null, 7, null);
        }
        rowColumnParentData.setCrossAxisAlignment(CrossAxisAlignment.Companion.horizontal$foundation_layout_release(this.horizontal));
        return rowColumnParentData;
    }
}
