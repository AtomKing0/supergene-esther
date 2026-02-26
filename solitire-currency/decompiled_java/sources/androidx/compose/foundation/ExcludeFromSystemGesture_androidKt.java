package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ExcludeFromSystemGesture.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ExcludeFromSystemGesture_androidKt {
    @NotNull
    public static final Modifier excludeFromSystemGesture(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return SystemGestureExclusionKt.systemGestureExclusion(modifier);
    }

    @NotNull
    public static final Modifier excludeFromSystemGesture(@NotNull Modifier modifier, @NotNull h9.l<? super LayoutCoordinates, Rect> exclusion) {
        t.i(modifier, "<this>");
        t.i(exclusion, "exclusion");
        return SystemGestureExclusionKt.systemGestureExclusion(modifier, exclusion);
    }
}
