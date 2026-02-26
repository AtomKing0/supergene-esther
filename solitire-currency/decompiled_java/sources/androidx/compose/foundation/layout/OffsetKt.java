package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Offset.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OffsetKt {
    @NotNull
    public static final Modifier absoluteOffset(@NotNull Modifier modifier, @NotNull h9.l<? super Density, IntOffset> offset) {
        t.i(modifier, "<this>");
        t.i(offset, "offset");
        return modifier.then(new OffsetPxModifier(offset, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new OffsetKt$absoluteOffset$$inlined$debugInspectorInfo$1(offset) : InspectableValueKt.getNoInspectorInfo()));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: absoluteOffset-VpY3zN4, reason: not valid java name */
    public static final Modifier m385absoluteOffsetVpY3zN4(@NotNull Modifier absoluteOffset, float f10, float f11) {
        t.i(absoluteOffset, "$this$absoluteOffset");
        return absoluteOffset.then(new OffsetModifier(f10, f11, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new OffsetKt$absoluteOffsetVpY3zN4$$inlined$debugInspectorInfo$1(f10, f11) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: absoluteOffset-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m386absoluteOffsetVpY3zN4$default(Modifier modifier, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 2) != 0) {
            f11 = Dp.m3673constructorimpl(0);
        }
        return m385absoluteOffsetVpY3zN4(modifier, f10, f11);
    }

    @NotNull
    public static final Modifier offset(@NotNull Modifier modifier, @NotNull h9.l<? super Density, IntOffset> offset) {
        t.i(modifier, "<this>");
        t.i(offset, "offset");
        return modifier.then(new OffsetPxModifier(offset, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new OffsetKt$offset$$inlined$debugInspectorInfo$1(offset) : InspectableValueKt.getNoInspectorInfo()));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: offset-VpY3zN4, reason: not valid java name */
    public static final Modifier m387offsetVpY3zN4(@NotNull Modifier offset, float f10, float f11) {
        t.i(offset, "$this$offset");
        return offset.then(new OffsetModifier(f10, f11, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new OffsetKt$offsetVpY3zN4$$inlined$debugInspectorInfo$1(f10, f11) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: offset-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m388offsetVpY3zN4$default(Modifier modifier, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 2) != 0) {
            f11 = Dp.m3673constructorimpl(0);
        }
        return m387offsetVpY3zN4(modifier, f10, f11);
    }
}
