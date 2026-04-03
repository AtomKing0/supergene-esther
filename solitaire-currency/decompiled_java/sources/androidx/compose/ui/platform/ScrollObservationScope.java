package androidx.compose.ui.platform;

import androidx.compose.ui.node.OwnerScope;
import androidx.compose.ui.semantics.ScrollAxisRange;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidComposeViewAccessibilityDelegateCompat.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ScrollObservationScope implements OwnerScope {

    @NotNull
    private final List<ScrollObservationScope> allScopes;

    @Nullable
    private ScrollAxisRange horizontalScrollAxisRange;

    @Nullable
    private Float oldXValue;

    @Nullable
    private Float oldYValue;
    private final int semanticsNodeId;

    @Nullable
    private ScrollAxisRange verticalScrollAxisRange;

    public ScrollObservationScope(int i10, @NotNull List<ScrollObservationScope> allScopes, @Nullable Float f10, @Nullable Float f11, @Nullable ScrollAxisRange scrollAxisRange, @Nullable ScrollAxisRange scrollAxisRange2) {
        kotlin.jvm.internal.t.i(allScopes, "allScopes");
        this.semanticsNodeId = i10;
        this.allScopes = allScopes;
        this.oldXValue = f10;
        this.oldYValue = f11;
        this.horizontalScrollAxisRange = scrollAxisRange;
        this.verticalScrollAxisRange = scrollAxisRange2;
    }

    @NotNull
    public final List<ScrollObservationScope> getAllScopes() {
        return this.allScopes;
    }

    @Nullable
    public final ScrollAxisRange getHorizontalScrollAxisRange() {
        return this.horizontalScrollAxisRange;
    }

    @Nullable
    public final Float getOldXValue() {
        return this.oldXValue;
    }

    @Nullable
    public final Float getOldYValue() {
        return this.oldYValue;
    }

    public final int getSemanticsNodeId() {
        return this.semanticsNodeId;
    }

    @Nullable
    public final ScrollAxisRange getVerticalScrollAxisRange() {
        return this.verticalScrollAxisRange;
    }

    @Override // androidx.compose.ui.node.OwnerScope
    public boolean isValid() {
        return this.allScopes.contains(this);
    }

    public final void setHorizontalScrollAxisRange(@Nullable ScrollAxisRange scrollAxisRange) {
        this.horizontalScrollAxisRange = scrollAxisRange;
    }

    public final void setOldXValue(@Nullable Float f10) {
        this.oldXValue = f10;
    }

    public final void setOldYValue(@Nullable Float f10) {
        this.oldYValue = f10;
    }

    public final void setVerticalScrollAxisRange(@Nullable ScrollAxisRange scrollAxisRange) {
        this.verticalScrollAxisRange = scrollAxisRange;
    }
}
