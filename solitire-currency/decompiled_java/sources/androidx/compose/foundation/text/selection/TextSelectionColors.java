package androidx.compose.foundation.text.selection;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TextSelectionColors.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class TextSelectionColors {
    private final long backgroundColor;
    private final long handleColor;

    public /* synthetic */ TextSelectionColors(long j10, long j11, k kVar) {
        this(j10, j11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextSelectionColors)) {
            return false;
        }
        TextSelectionColors textSelectionColors = (TextSelectionColors) obj;
        return Color.m1599equalsimpl0(this.handleColor, textSelectionColors.handleColor) && Color.m1599equalsimpl0(this.backgroundColor, textSelectionColors.backgroundColor);
    }

    /* JADX INFO: renamed from: getBackgroundColor-0d7_KjU, reason: not valid java name */
    public final long m850getBackgroundColor0d7_KjU() {
        return this.backgroundColor;
    }

    /* JADX INFO: renamed from: getHandleColor-0d7_KjU, reason: not valid java name */
    public final long m851getHandleColor0d7_KjU() {
        return this.handleColor;
    }

    public int hashCode() {
        return (Color.m1605hashCodeimpl(this.handleColor) * 31) + Color.m1605hashCodeimpl(this.backgroundColor);
    }

    @NotNull
    public String toString() {
        return "SelectionColors(selectionHandleColor=" + ((Object) Color.m1606toStringimpl(this.handleColor)) + ", selectionBackgroundColor=" + ((Object) Color.m1606toStringimpl(this.backgroundColor)) + ')';
    }

    private TextSelectionColors(long j10, long j11) {
        this.handleColor = j10;
        this.backgroundColor = j11;
    }
}
