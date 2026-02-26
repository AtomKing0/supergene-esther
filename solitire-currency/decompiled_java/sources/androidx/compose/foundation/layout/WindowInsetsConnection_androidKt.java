package androidx.compose.foundation.layout;

import android.os.Build;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WindowInsetsConnection.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WindowInsetsConnection_androidKt {
    private static final double DecelMinusOne;
    private static final double DecelerationRate;
    private static final float EndTension = 1.0f;
    private static final float GravityEarth = 9.80665f;
    private static final float InchesPerMeter = 39.37f;
    private static final float Inflection = 0.35f;
    private static final float P1 = 0.175f;
    private static final float P2 = 0.35000002f;
    private static final float PlatformFlingScrollFriction = ViewConfiguration.getScrollFriction();
    private static final float StartTension = 0.5f;

    /* JADX INFO: renamed from: androidx.compose.foundation.layout.WindowInsetsConnection_androidKt$imeNestedScroll$2, reason: invalid class name */
    /* JADX INFO: compiled from: WindowInsetsConnection.android.kt */
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
            composer.startReplaceableGroup(-369978792);
            Modifier modifierNestedScroll$default = NestedScrollModifierKt.nestedScroll$default(composed, WindowInsetsConnection_androidKt.m454rememberWindowInsetsConnectionVRgvIgI(WindowInsetsHolder.Companion.current(composer, 8).getIme(), WindowInsetsSides.Companion.m476getBottomJoeWqyM(), composer, 48), null, 2, null);
            composer.endReplaceableGroup();
            return modifierNestedScroll$default;
        }
    }

    static {
        double dLog = Math.log(0.78d) / Math.log(0.9d);
        DecelerationRate = dLog;
        DecelMinusOne = dLog - 1.0d;
    }

    @ExperimentalLayoutApi
    @NotNull
    public static final Modifier imeNestedScroll(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        if (Build.VERSION.SDK_INT < 30) {
            return modifier;
        }
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsConnection_androidKt$imeNestedScroll$$inlined$debugInspectorInfo$1() : InspectableValueKt.getNoInspectorInfo(), AnonymousClass2.INSTANCE);
    }

    @Composable
    @ExperimentalLayoutApi
    @NotNull
    /* JADX INFO: renamed from: rememberWindowInsetsConnection-VRgvIgI, reason: not valid java name */
    public static final NestedScrollConnection m454rememberWindowInsetsConnectionVRgvIgI(@NotNull AndroidWindowInsets windowInsets, int i10, @Nullable Composer composer, int i11) {
        t.i(windowInsets, "windowInsets");
        composer.startReplaceableGroup(-1011341039);
        if (Build.VERSION.SDK_INT < 30) {
            DoNothingNestedScrollConnection doNothingNestedScrollConnection = DoNothingNestedScrollConnection.INSTANCE;
            composer.endReplaceableGroup();
            return doNothingNestedScrollConnection;
        }
        SideCalculator sideCalculatorM423chooseCalculatorni1skBw = SideCalculator.Companion.m423chooseCalculatorni1skBw(i10, (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection()));
        View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
        Object[] objArr = {windowInsets, view, sideCalculatorM423chooseCalculatorni1skBw, density};
        composer.startReplaceableGroup(-568225417);
        boolean zChanged = false;
        for (int i12 = 0; i12 < 4; i12++) {
            zChanged |= composer.changed(objArr[i12]);
        }
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new WindowInsetsNestedScrollConnection(windowInsets, view, sideCalculatorM423chooseCalculatorni1skBw, density);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        WindowInsetsNestedScrollConnection windowInsetsNestedScrollConnection = (WindowInsetsNestedScrollConnection) objRememberedValue;
        EffectsKt.DisposableEffect(windowInsetsNestedScrollConnection, new WindowInsetsConnection_androidKt$rememberWindowInsetsConnection$1(windowInsetsNestedScrollConnection), composer, 8);
        composer.endReplaceableGroup();
        return windowInsetsNestedScrollConnection;
    }
}
