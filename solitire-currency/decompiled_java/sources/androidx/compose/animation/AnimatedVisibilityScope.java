package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AnimatedVisibility.kt */
/* JADX INFO: loaded from: classes.dex */
public interface AnimatedVisibilityScope {

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedVisibilityScope$-CC, reason: invalid class name */
    /* JADX INFO: compiled from: AnimatedVisibility.kt */
    public final /* synthetic */ class CC {
        @ExperimentalAnimationApi
        @NotNull
        public static Modifier a(AnimatedVisibilityScope animatedVisibilityScope, @NotNull Modifier modifier, @NotNull EnterTransition enter, @NotNull ExitTransition exit, @NotNull String label) {
            t.i(modifier, "<this>");
            t.i(enter, "enter");
            t.i(exit, "exit");
            t.i(label, "label");
            return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new AnimatedVisibilityScope$animateEnterExit$$inlined$debugInspectorInfo$1(enter, exit, label) : InspectableValueKt.getNoInspectorInfo(), animatedVisibilityScope.new AnonymousClass2(enter, exit, label));
        }

        public static /* synthetic */ Modifier c(AnimatedVisibilityScope animatedVisibilityScope, Modifier modifier, EnterTransition enterTransition, ExitTransition exitTransition, String str, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateEnterExit");
            }
            if ((i10 & 1) != 0) {
                enterTransition = EnterExitTransitionKt.fadeIn$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.expandIn$default(null, null, false, null, 15, null));
            }
            if ((i10 & 2) != 0) {
                exitTransition = EnterExitTransitionKt.fadeOut$default(null, 0.0f, 3, null).plus(EnterExitTransitionKt.shrinkOut$default(null, null, false, null, 15, null));
            }
            if ((i10 & 4) != 0) {
                str = "animateEnterExit";
            }
            return animatedVisibilityScope.animateEnterExit(modifier, enterTransition, exitTransition, str);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.animation.AnimatedVisibilityScope$animateEnterExit$2, reason: invalid class name */
    /* JADX INFO: compiled from: AnimatedVisibility.kt */
    static final class AnonymousClass2 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ EnterTransition $enter;
        final /* synthetic */ ExitTransition $exit;
        final /* synthetic */ String $label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(EnterTransition enterTransition, ExitTransition exitTransition, String str) {
            super(3);
            this.$enter = enterTransition;
            this.$exit = exitTransition;
            this.$label = str;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(1840112047);
            Modifier modifierThen = composed.then(EnterExitTransitionKt.createModifier(AnimatedVisibilityScope.this.getTransition(), this.$enter, this.$exit, this.$label, composer, 0));
            composer.endReplaceableGroup();
            return modifierThen;
        }
    }

    @ExperimentalAnimationApi
    @NotNull
    Modifier animateEnterExit(@NotNull Modifier modifier, @NotNull EnterTransition enterTransition, @NotNull ExitTransition exitTransition, @NotNull String str);

    @ExperimentalAnimationApi
    @NotNull
    Transition<EnterExitState> getTransition();

    /* JADX INFO: compiled from: AnimatedVisibility.kt */
    public static final class DefaultImpls {
        @ExperimentalAnimationApi
        @Deprecated
        @NotNull
        public static Modifier animateEnterExit(@NotNull AnimatedVisibilityScope animatedVisibilityScope, @NotNull Modifier receiver, @NotNull EnterTransition enter, @NotNull ExitTransition exit, @NotNull String label) {
            t.i(receiver, "receiver");
            t.i(enter, "enter");
            t.i(exit, "exit");
            t.i(label, "label");
            return CC.a(animatedVisibilityScope, receiver, enter, exit, label);
        }

        @ExperimentalAnimationApi
        public static /* synthetic */ void getTransition$annotations() {
        }
    }
}
