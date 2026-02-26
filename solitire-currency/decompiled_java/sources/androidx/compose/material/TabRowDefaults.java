package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Dp;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class TabRowDefaults {
    public static final int $stable = 0;
    public static final float DividerOpacity = 0.12f;

    @NotNull
    public static final TabRowDefaults INSTANCE = new TabRowDefaults();
    private static final float DividerThickness = Dp.m3673constructorimpl(1);
    private static final float IndicatorHeight = Dp.m3673constructorimpl(2);
    private static final float ScrollableTabRowPadding = Dp.m3673constructorimpl(52);

    /* JADX INFO: renamed from: androidx.compose.material.TabRowDefaults$tabIndicatorOffset$2, reason: invalid class name */
    /* JADX INFO: compiled from: TabRow.kt */
    static final class AnonymousClass2 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ TabPosition $currentTabPosition;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TabPosition tabPosition) {
            super(3);
            this.$currentTabPosition = tabPosition;
        }

        /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
        private static final float m1180invoke$lambda0(State<Dp> state) {
            return state.getValue().m3687unboximpl();
        }

        /* JADX INFO: renamed from: invoke$lambda-1, reason: not valid java name */
        private static final float m1181invoke$lambda1(State<Dp> state) {
            return state.getValue().m3687unboximpl();
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(-398757863);
            State<Dp> stateM95animateDpAsStateKz89ssw = AnimateAsStateKt.m95animateDpAsStateKz89ssw(this.$currentTabPosition.m1174getWidthD9Ej5fM(), AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, null), null, composer, 0, 4);
            Modifier modifierM445width3ABfNKs = SizeKt.m445width3ABfNKs(OffsetKt.m388offsetVpY3zN4$default(SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(composed, 0.0f, 1, null), Alignment.Companion.getBottomStart(), false, 2, null), m1181invoke$lambda1(AnimateAsStateKt.m95animateDpAsStateKz89ssw(this.$currentTabPosition.m1172getLeftD9Ej5fM(), AnimationSpecKt.tween$default(250, 0, EasingKt.getFastOutSlowInEasing(), 2, null), null, composer, 0, 4)), 0.0f, 2, null), m1180invoke$lambda0(stateM95animateDpAsStateKz89ssw));
            composer.endReplaceableGroup();
            return modifierM445width3ABfNKs;
        }
    }

    private TabRowDefaults() {
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Divider-9IZ8Weo, reason: not valid java name */
    public final void m1175Divider9IZ8Weo(@Nullable Modifier modifier, float f10, long j10, @Nullable Composer composer, int i10, int i11) {
        Modifier modifier2;
        int i12;
        float f11;
        long j11;
        Modifier modifier3;
        float f12;
        long jM1597copywmQWz5c$default;
        float f13;
        Composer composerStartRestartGroup = composer.startRestartGroup(910934799);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 14) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i10 & 112) == 0) {
            if ((i11 & 2) == 0) {
                f11 = f10;
                int i14 = composerStartRestartGroup.changed(f11) ? 32 : 16;
                i12 |= i14;
            } else {
                f11 = f10;
            }
            i12 |= i14;
        } else {
            f11 = f10;
        }
        if ((i10 & 896) == 0) {
            j11 = j10;
            i12 |= ((i11 & 4) == 0 && composerStartRestartGroup.changed(j11)) ? 256 : 128;
        } else {
            j11 = j10;
        }
        if ((i11 & 8) != 0) {
            i12 |= 3072;
        } else if ((i10 & 7168) == 0) {
            i12 |= composerStartRestartGroup.changed(this) ? 2048 : 1024;
        }
        if ((i12 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            f13 = f11;
            jM1597copywmQWz5c$default = j11;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                modifier3 = i13 != 0 ? Modifier.Companion : modifier2;
                if ((i11 & 2) != 0) {
                    f12 = DividerThickness;
                    i12 &= -113;
                } else {
                    f12 = f11;
                }
                if ((i11 & 4) != 0) {
                    jM1597copywmQWz5c$default = Color.m1597copywmQWz5c$default(((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m1608unboximpl(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
                    i12 &= -897;
                }
                composerStartRestartGroup.endDefaults();
                DividerKt.m991DivideroMI9zvI(modifier3, jM1597copywmQWz5c$default, f12, 0.0f, composerStartRestartGroup, (i12 & 14) | ((i12 >> 3) & 112) | ((i12 << 3) & 896), 8);
                f13 = f12;
                modifier2 = modifier3;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i11 & 2) != 0) {
                    i12 &= -113;
                }
                if ((i11 & 4) != 0) {
                    i12 &= -897;
                }
                modifier3 = modifier2;
                f12 = f11;
            }
            jM1597copywmQWz5c$default = j11;
            composerStartRestartGroup.endDefaults();
            DividerKt.m991DivideroMI9zvI(modifier3, jM1597copywmQWz5c$default, f12, 0.0f, composerStartRestartGroup, (i12 & 14) | ((i12 >> 3) & 112) | ((i12 << 3) & 896), 8);
            f13 = f12;
            modifier2 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TabRowDefaults$Divider$1(this, modifier2, f13, jM1597copywmQWz5c$default, i10, i11));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    /* JADX INFO: renamed from: Indicator-9IZ8Weo, reason: not valid java name */
    public final void m1176Indicator9IZ8Weo(@Nullable Modifier modifier, float f10, long j10, @Nullable Composer composer, int i10, int i11) {
        Modifier modifier2;
        int i12;
        float f11;
        long jM1608unboximpl;
        Modifier modifier3;
        float f12;
        float f13;
        long j11;
        Composer composerStartRestartGroup = composer.startRestartGroup(1499002201);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 14) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i10 & 112) == 0) {
            if ((i11 & 2) == 0) {
                f11 = f10;
                int i14 = composerStartRestartGroup.changed(f11) ? 32 : 16;
                i12 |= i14;
            } else {
                f11 = f10;
            }
            i12 |= i14;
        } else {
            f11 = f10;
        }
        if ((i10 & 896) == 0) {
            jM1608unboximpl = j10;
            i12 |= ((i11 & 4) == 0 && composerStartRestartGroup.changed(jM1608unboximpl)) ? 256 : 128;
        } else {
            jM1608unboximpl = j10;
        }
        if ((i11 & 8) != 0) {
            i12 |= 3072;
        } else if ((i10 & 7168) == 0) {
            i12 |= composerStartRestartGroup.changed(this) ? 2048 : 1024;
        }
        if ((i12 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            f13 = f11;
            j11 = jM1608unboximpl;
        } else {
            composerStartRestartGroup.startDefaults();
            if ((i10 & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                modifier3 = i13 != 0 ? Modifier.Companion : modifier2;
                f12 = (i11 & 2) != 0 ? IndicatorHeight : f11;
                if ((i11 & 4) != 0) {
                    jM1608unboximpl = ((Color) composerStartRestartGroup.consume(ContentColorKt.getLocalContentColor())).m1608unboximpl();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                f12 = f11;
            }
            composerStartRestartGroup.endDefaults();
            BoxKt.Box(BackgroundKt.m166backgroundbw27NRU$default(SizeKt.m426height3ABfNKs(SizeKt.fillMaxWidth$default(modifier3, 0.0f, 1, null), f12), jM1608unboximpl, null, 2, null), composerStartRestartGroup, 0);
            f13 = f12;
            j11 = jM1608unboximpl;
            modifier2 = modifier3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new TabRowDefaults$Indicator$1(this, modifier2, f13, j11, i10, i11));
    }

    /* JADX INFO: renamed from: getDividerThickness-D9Ej5fM, reason: not valid java name */
    public final float m1177getDividerThicknessD9Ej5fM() {
        return DividerThickness;
    }

    /* JADX INFO: renamed from: getIndicatorHeight-D9Ej5fM, reason: not valid java name */
    public final float m1178getIndicatorHeightD9Ej5fM() {
        return IndicatorHeight;
    }

    /* JADX INFO: renamed from: getScrollableTabRowPadding-D9Ej5fM, reason: not valid java name */
    public final float m1179getScrollableTabRowPaddingD9Ej5fM() {
        return ScrollableTabRowPadding;
    }

    @NotNull
    public final Modifier tabIndicatorOffset(@NotNull Modifier modifier, @NotNull TabPosition currentTabPosition) {
        t.i(modifier, "<this>");
        t.i(currentTabPosition, "currentTabPosition");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TabRowDefaults$tabIndicatorOffset$$inlined$debugInspectorInfo$1(currentTabPosition) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(currentTabPosition));
    }
}
