package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextFieldTransitionScope {

    @NotNull
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    /* JADX INFO: compiled from: TextFieldImpl.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPhase.values().length];
            iArr[InputPhase.Focused.ordinal()] = 1;
            iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    /* JADX INFO: renamed from: Transition_DTcfvLk$lambda-1, reason: not valid java name */
    private static final float m1212Transition_DTcfvLk$lambda1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: renamed from: Transition_DTcfvLk$lambda-3, reason: not valid java name */
    private static final float m1213Transition_DTcfvLk$lambda3(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: renamed from: Transition_DTcfvLk$lambda-5, reason: not valid java name */
    private static final long m1214Transition_DTcfvLk$lambda5(State<Color> state) {
        return state.getValue().m1608unboximpl();
    }

    /* JADX INFO: renamed from: Transition_DTcfvLk$lambda-6, reason: not valid java name */
    private static final long m1215Transition_DTcfvLk$lambda6(State<Color> state) {
        return state.getValue().m1608unboximpl();
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01f9  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[0[0][0]]")
    /* JADX INFO: renamed from: Transition-DTcfvLk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m1216TransitionDTcfvLk(@org.jetbrains.annotations.NotNull androidx.compose.material.InputPhase r28, long r29, long r31, @org.jetbrains.annotations.NotNull h9.q<? super androidx.compose.material.InputPhase, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, androidx.compose.ui.graphics.Color> r33, boolean r34, @org.jetbrains.annotations.NotNull h9.t<? super java.lang.Float, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.ui.graphics.Color, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r35, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r36, int r37) {
        /*
            Method dump skipped, instruction units count: 924
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldTransitionScope.m1216TransitionDTcfvLk(androidx.compose.material.InputPhase, long, long, h9.q, boolean, h9.t, androidx.compose.runtime.Composer, int):void");
    }
}
