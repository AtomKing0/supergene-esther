package androidx.compose.material.ripple;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.e;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import s9.i;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: Ripple.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public abstract class Ripple implements Indication {
    private final boolean bounded;

    @NotNull
    private final State<Color> color;
    private final float radius;

    /* JADX INFO: renamed from: androidx.compose.material.ripple.Ripple$rememberUpdatedInstance$1, reason: invalid class name */
    /* JADX INFO: compiled from: Ripple.kt */
    @f(c = "androidx.compose.material.ripple.Ripple$rememberUpdatedInstance$1", f = "Ripple.kt", l = {356}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ RippleIndicationInstance $instance;
        final /* synthetic */ InteractionSource $interactionSource;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(InteractionSource interactionSource, RippleIndicationInstance rippleIndicationInstance, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$interactionSource = interactionSource;
            this.$instance = rippleIndicationInstance;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$interactionSource, this.$instance, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                final o0 o0Var = (o0) this.L$0;
                h<Interaction> interactions = this.$interactionSource.getInteractions();
                final RippleIndicationInstance rippleIndicationInstance = this.$instance;
                i<Interaction> iVar = new i<Interaction>() { // from class: androidx.compose.material.ripple.Ripple$rememberUpdatedInstance$1$invokeSuspend$$inlined$collect$1
                    @Override // s9.i
                    @Nullable
                    public Object emit(Interaction interaction, @NotNull d<? super k0> dVar) {
                        Interaction interaction2 = interaction;
                        if (interaction2 instanceof PressInteraction.Press) {
                            rippleIndicationInstance.addRipple((PressInteraction.Press) interaction2, o0Var);
                        } else if (interaction2 instanceof PressInteraction.Release) {
                            rippleIndicationInstance.removeRipple(((PressInteraction.Release) interaction2).getPress());
                        } else if (interaction2 instanceof PressInteraction.Cancel) {
                            rippleIndicationInstance.removeRipple(((PressInteraction.Cancel) interaction2).getPress());
                        } else {
                            rippleIndicationInstance.updateStateLayer$material_ripple_release(interaction2, o0Var);
                        }
                        return k0.f35197a;
                    }
                };
                this.label = 1;
                if (interactions.collect(iVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public /* synthetic */ Ripple(boolean z10, float f10, State state, k kVar) {
        this(z10, f10, state);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ripple)) {
            return false;
        }
        Ripple ripple = (Ripple) obj;
        return this.bounded == ripple.bounded && Dp.m3678equalsimpl0(this.radius, ripple.radius) && t.d(this.color, ripple.color);
    }

    public int hashCode() {
        return (((e.a(this.bounded) * 31) + Dp.m3679hashCodeimpl(this.radius)) * 31) + this.color.hashCode();
    }

    @Override // androidx.compose.foundation.Indication
    @Composable
    @NotNull
    public final IndicationInstance rememberUpdatedInstance(@NotNull InteractionSource interactionSource, @Nullable Composer composer, int i10) {
        t.i(interactionSource, "interactionSource");
        composer.startReplaceableGroup(988743187);
        RippleTheme rippleTheme = (RippleTheme) composer.consume(RippleThemeKt.getLocalRippleTheme());
        composer.startReplaceableGroup(-1524341038);
        long jM1608unboximpl = (this.color.getValue().m1608unboximpl() > Color.Companion.m1634getUnspecified0d7_KjU() ? 1 : (this.color.getValue().m1608unboximpl() == Color.Companion.m1634getUnspecified0d7_KjU() ? 0 : -1)) != 0 ? this.color.getValue().m1608unboximpl() : rippleTheme.mo1053defaultColorWaAFU9c(composer, 0);
        composer.endReplaceableGroup();
        RippleIndicationInstance rippleIndicationInstanceMo1228rememberUpdatedRippleInstance942rkJo = mo1228rememberUpdatedRippleInstance942rkJo(interactionSource, this.bounded, this.radius, SnapshotStateKt.rememberUpdatedState(Color.m1588boximpl(jM1608unboximpl), composer, 0), SnapshotStateKt.rememberUpdatedState(rippleTheme.rippleAlpha(composer, 0), composer, 0), composer, (i10 & 14) | ((i10 << 12) & 458752));
        EffectsKt.LaunchedEffect(rippleIndicationInstanceMo1228rememberUpdatedRippleInstance942rkJo, interactionSource, new AnonymousClass1(interactionSource, rippleIndicationInstanceMo1228rememberUpdatedRippleInstance942rkJo, null), composer, ((i10 << 3) & 112) | 8);
        composer.endReplaceableGroup();
        return rippleIndicationInstanceMo1228rememberUpdatedRippleInstance942rkJo;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: rememberUpdatedRippleInstance-942rkJo */
    public abstract RippleIndicationInstance mo1228rememberUpdatedRippleInstance942rkJo(@NotNull InteractionSource interactionSource, boolean z10, float f10, @NotNull State<Color> state, @NotNull State<RippleAlpha> state2, @Nullable Composer composer, int i10);

    private Ripple(boolean z10, float f10, State<Color> state) {
        this.bounded = z10;
        this.radius = f10;
        this.color = state;
    }
}
