package androidx.compose.material;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class TabPosition {
    private final float left;
    private final float width;

    public /* synthetic */ TabPosition(float f10, float f11, k kVar) {
        this(f10, f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TabPosition)) {
            return false;
        }
        TabPosition tabPosition = (TabPosition) obj;
        return Dp.m3678equalsimpl0(this.left, tabPosition.left) && Dp.m3678equalsimpl0(this.width, tabPosition.width);
    }

    /* JADX INFO: renamed from: getLeft-D9Ej5fM, reason: not valid java name */
    public final float m1172getLeftD9Ej5fM() {
        return this.left;
    }

    /* JADX INFO: renamed from: getRight-D9Ej5fM, reason: not valid java name */
    public final float m1173getRightD9Ej5fM() {
        return Dp.m3673constructorimpl(this.left + this.width);
    }

    /* JADX INFO: renamed from: getWidth-D9Ej5fM, reason: not valid java name */
    public final float m1174getWidthD9Ej5fM() {
        return this.width;
    }

    public int hashCode() {
        return (Dp.m3679hashCodeimpl(this.left) * 31) + Dp.m3679hashCodeimpl(this.width);
    }

    @NotNull
    public String toString() {
        return "TabPosition(left=" + ((Object) Dp.m3684toStringimpl(this.left)) + ", right=" + ((Object) Dp.m3684toStringimpl(m1173getRightD9Ej5fM())) + ", width=" + ((Object) Dp.m3684toStringimpl(this.width)) + ')';
    }

    private TabPosition(float f10, float f11) {
        this.left = f10;
        this.width = f11;
    }
}
