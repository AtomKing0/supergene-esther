package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: WindowInsetsPadding.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsPadding_androidKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsPadding_androidKt$windowInsetsPadding$1, reason: invalid class name */
    /* JADX INFO: compiled from: WindowInsetsPadding.android.kt */
    public static final class AnonymousClass1 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ h9.l<WindowInsetsHolder, WindowInsets> $insetsCalculation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(h9.l<? super WindowInsetsHolder, ? extends WindowInsets> lVar) {
            super(3);
            this.$insetsCalculation = lVar;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(359872873);
            WindowInsetsHolder windowInsetsHolderCurrent = WindowInsetsHolder.Companion.current(composer, 8);
            h9.l<WindowInsetsHolder, WindowInsets> lVar = this.$insetsCalculation;
            composer.startReplaceableGroup(1157296644);
            boolean zChanged = composer.changed(windowInsetsHolderCurrent);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new InsetsPaddingModifier(lVar.invoke(windowInsetsHolderCurrent), null, 2, null);
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            InsetsPaddingModifier insetsPaddingModifier = (InsetsPaddingModifier) objRememberedValue;
            composer.endReplaceableGroup();
            return insetsPaddingModifier;
        }
    }

    @NotNull
    public static final Modifier captionBarPadding(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$captionBarPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$captionBarPadding$$inlined$windowInsetsPadding$1());
    }

    @NotNull
    public static final Modifier displayCutoutPadding(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$displayCutoutPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$displayCutoutPadding$$inlined$windowInsetsPadding$1());
    }

    @NotNull
    public static final Modifier imePadding(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$imePadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$imePadding$$inlined$windowInsetsPadding$1());
    }

    @NotNull
    public static final Modifier mandatorySystemGesturesPadding(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$mandatorySystemGesturesPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$mandatorySystemGesturesPadding$$inlined$windowInsetsPadding$1());
    }

    @NotNull
    public static final Modifier navigationBarsPadding(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$navigationBarsPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$navigationBarsPadding$$inlined$windowInsetsPadding$1());
    }

    @NotNull
    public static final Modifier safeContentPadding(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$safeContentPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$safeContentPadding$$inlined$windowInsetsPadding$1());
    }

    @NotNull
    public static final Modifier safeDrawingPadding(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$safeDrawingPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$safeDrawingPadding$$inlined$windowInsetsPadding$1());
    }

    @NotNull
    public static final Modifier safeGesturesPadding(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$safeGesturesPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$safeGesturesPadding$$inlined$windowInsetsPadding$1());
    }

    @NotNull
    public static final Modifier statusBarsPadding(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$statusBarsPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$statusBarsPadding$$inlined$windowInsetsPadding$1());
    }

    @NotNull
    public static final Modifier systemBarsPadding(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$systemBarsPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$systemBarsPadding$$inlined$windowInsetsPadding$1());
    }

    @NotNull
    public static final Modifier systemGesturesPadding(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$systemGesturesPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$systemGesturesPadding$$inlined$windowInsetsPadding$1());
    }

    @NotNull
    public static final Modifier waterfallPadding(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPadding_androidKt$waterfallPadding$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), new WindowInsetsPadding_androidKt$waterfallPadding$$inlined$windowInsetsPadding$1());
    }

    @Stable
    private static final Modifier windowInsetsPadding(Modifier modifier, h9.l<? super InspectorInfo, k0> lVar, h9.l<? super WindowInsetsHolder, ? extends WindowInsets> lVar2) {
        return ComposedModifierKt.composed(modifier, lVar, new AnonymousClass1(lVar2));
    }
}
