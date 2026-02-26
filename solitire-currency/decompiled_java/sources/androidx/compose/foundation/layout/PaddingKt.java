package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Padding.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PaddingKt {
    @Stable
    @NotNull
    /* JADX INFO: renamed from: PaddingValues-0680j_4, reason: not valid java name */
    public static final PaddingValues m392PaddingValues0680j_4(float f10) {
        return new PaddingValuesImpl(f10, f10, f10, f10, null);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: PaddingValues-YgX7TsA, reason: not valid java name */
    public static final PaddingValues m393PaddingValuesYgX7TsA(float f10, float f11) {
        return new PaddingValuesImpl(f10, f11, f10, f11, null);
    }

    /* JADX INFO: renamed from: PaddingValues-YgX7TsA$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m394PaddingValuesYgX7TsA$default(float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 2) != 0) {
            f11 = Dp.m3673constructorimpl(0);
        }
        return m393PaddingValuesYgX7TsA(f10, f11);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: PaddingValues-a9UjIt4, reason: not valid java name */
    public static final PaddingValues m395PaddingValuesa9UjIt4(float f10, float f11, float f12, float f13) {
        return new PaddingValuesImpl(f10, f11, f12, f13, null);
    }

    /* JADX INFO: renamed from: PaddingValues-a9UjIt4$default, reason: not valid java name */
    public static /* synthetic */ PaddingValues m396PaddingValuesa9UjIt4$default(float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 2) != 0) {
            f11 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 4) != 0) {
            f12 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 8) != 0) {
            f13 = Dp.m3673constructorimpl(0);
        }
        return m395PaddingValuesa9UjIt4(f10, f11, f12, f13);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: absolutePadding-qDBjuR0, reason: not valid java name */
    public static final Modifier m397absolutePaddingqDBjuR0(@NotNull Modifier absolutePadding, float f10, float f11, float f12, float f13) {
        t.i(absolutePadding, "$this$absolutePadding");
        return absolutePadding.then(new PaddingModifier(f10, f11, f12, f13, false, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PaddingKt$absolutePaddingqDBjuR0$$inlined$debugInspectorInfo$1(f10, f11, f12, f13) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: absolutePadding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m398absolutePaddingqDBjuR0$default(Modifier modifier, float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 2) != 0) {
            f11 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 4) != 0) {
            f12 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 8) != 0) {
            f13 = Dp.m3673constructorimpl(0);
        }
        return m397absolutePaddingqDBjuR0(modifier, f10, f11, f12, f13);
    }

    @Stable
    public static final float calculateEndPadding(@NotNull PaddingValues paddingValues, @NotNull LayoutDirection layoutDirection) {
        t.i(paddingValues, "<this>");
        t.i(layoutDirection, "layoutDirection");
        return layoutDirection == LayoutDirection.Ltr ? paddingValues.mo381calculateRightPaddingu2uoSUM(layoutDirection) : paddingValues.mo380calculateLeftPaddingu2uoSUM(layoutDirection);
    }

    @Stable
    public static final float calculateStartPadding(@NotNull PaddingValues paddingValues, @NotNull LayoutDirection layoutDirection) {
        t.i(paddingValues, "<this>");
        t.i(layoutDirection, "layoutDirection");
        return layoutDirection == LayoutDirection.Ltr ? paddingValues.mo380calculateLeftPaddingu2uoSUM(layoutDirection) : paddingValues.mo381calculateRightPaddingu2uoSUM(layoutDirection);
    }

    @Stable
    @NotNull
    public static final Modifier padding(@NotNull Modifier modifier, @NotNull PaddingValues paddingValues) {
        t.i(modifier, "<this>");
        t.i(paddingValues, "paddingValues");
        return modifier.then(new PaddingValuesModifier(paddingValues, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PaddingKt$padding$$inlined$debugInspectorInfo$1(paddingValues) : InspectableValueKt.getNoInspectorInfo()));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: padding-3ABfNKs, reason: not valid java name */
    public static final Modifier m399padding3ABfNKs(@NotNull Modifier padding, float f10) {
        t.i(padding, "$this$padding");
        return padding.then(new PaddingModifier(f10, f10, f10, f10, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PaddingKt$padding3ABfNKs$$inlined$debugInspectorInfo$1(f10) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: padding-VpY3zN4, reason: not valid java name */
    public static final Modifier m400paddingVpY3zN4(@NotNull Modifier padding, float f10, float f11) {
        t.i(padding, "$this$padding");
        return padding.then(new PaddingModifier(f10, f11, f10, f11, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PaddingKt$paddingVpY3zN4$$inlined$debugInspectorInfo$1(f10, f11) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: padding-VpY3zN4$default, reason: not valid java name */
    public static /* synthetic */ Modifier m401paddingVpY3zN4$default(Modifier modifier, float f10, float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 2) != 0) {
            f11 = Dp.m3673constructorimpl(0);
        }
        return m400paddingVpY3zN4(modifier, f10, f11);
    }

    @Stable
    @NotNull
    /* JADX INFO: renamed from: padding-qDBjuR0, reason: not valid java name */
    public static final Modifier m402paddingqDBjuR0(@NotNull Modifier padding, float f10, float f11, float f12, float f13) {
        t.i(padding, "$this$padding");
        return padding.then(new PaddingModifier(f10, f11, f12, f13, true, InspectableValueKt.isDebugInspectorInfoEnabled() ? new PaddingKt$paddingqDBjuR0$$inlined$debugInspectorInfo$1(f10, f11, f12, f13) : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* JADX INFO: renamed from: padding-qDBjuR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m403paddingqDBjuR0$default(Modifier modifier, float f10, float f11, float f12, float f13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            f10 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 2) != 0) {
            f11 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 4) != 0) {
            f12 = Dp.m3673constructorimpl(0);
        }
        if ((i10 & 8) != 0) {
            f13 = Dp.m3673constructorimpl(0);
        }
        return m402paddingqDBjuR0(modifier, f10, f11, f12, f13);
    }
}
