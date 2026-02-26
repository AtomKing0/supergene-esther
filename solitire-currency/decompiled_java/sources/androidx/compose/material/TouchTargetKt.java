package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.ViewConfiguration;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TouchTarget.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TouchTargetKt {

    @NotNull
    private static final ProvidableCompositionLocal<Boolean> LocalMinimumTouchTargetEnforcement = CompositionLocalKt.staticCompositionLocalOf(TouchTargetKt$LocalMinimumTouchTargetEnforcement$1.INSTANCE);

    /* JADX INFO: renamed from: androidx.compose.material.TouchTargetKt$minimumTouchTargetSize$2, reason: invalid class name */
    /* JADX INFO: compiled from: TouchTarget.kt */
    static final class AnonymousClass2 extends v implements q<Modifier, Composer, Integer, Modifier> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(3);
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(1220403677);
            Modifier minimumTouchTargetModifier = ((Boolean) composer.consume(TouchTargetKt.getLocalMinimumTouchTargetEnforcement())).booleanValue() ? new MinimumTouchTargetModifier(((ViewConfiguration) composer.consume(CompositionLocalsKt.getLocalViewConfiguration())).mo3104getMinimumTouchTargetSizeMYxV2XQ(), null) : Modifier.Companion;
            composer.endReplaceableGroup();
            return minimumTouchTargetModifier;
        }
    }

    @ExperimentalMaterialApi
    @NotNull
    public static final ProvidableCompositionLocal<Boolean> getLocalMinimumTouchTargetEnforcement() {
        return LocalMinimumTouchTargetEnforcement;
    }

    @NotNull
    public static final Modifier minimumTouchTargetSize(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new TouchTargetKt$minimumTouchTargetSize$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), AnonymousClass2.INSTANCE);
    }

    @ExperimentalMaterialApi
    public static /* synthetic */ void getLocalMinimumTouchTargetEnforcement$annotations() {
    }
}
