package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Dp;
import h9.p;
import kotlin.collections.d0;
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

/* JADX INFO: compiled from: FloatingActionButton.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
final class DefaultFloatingActionButtonElevation implements FloatingActionButtonElevation {
    private final float defaultElevation;
    private final float focusedElevation;
    private final float hoveredElevation;
    private final float pressedElevation;

    /* JADX INFO: renamed from: androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$1, reason: invalid class name */
    /* JADX INFO: compiled from: FloatingActionButton.kt */
    @f(c = "androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$1", f = "FloatingActionButton.kt", l = {273}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ SnapshotStateList<Interaction> $interactions;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(InteractionSource interactionSource, SnapshotStateList<Interaction> snapshotStateList, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$interactionSource = interactionSource;
            this.$interactions = snapshotStateList;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass1(this.$interactionSource, this.$interactions, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                h<Interaction> interactions = this.$interactionSource.getInteractions();
                final SnapshotStateList<Interaction> snapshotStateList = this.$interactions;
                i<Interaction> iVar = new i<Interaction>() { // from class: androidx.compose.material.DefaultFloatingActionButtonElevation.elevation.1.1
                    @Override // s9.i
                    public /* bridge */ /* synthetic */ Object emit(Interaction interaction, d dVar) {
                        return emit2(interaction, (d<? super k0>) dVar);
                    }

                    @Nullable
                    /* JADX INFO: renamed from: emit, reason: avoid collision after fix types in other method */
                    public final Object emit2(@NotNull Interaction interaction, @NotNull d<? super k0> dVar) {
                        if (interaction instanceof HoverInteraction.Enter) {
                            snapshotStateList.add(interaction);
                        } else if (interaction instanceof HoverInteraction.Exit) {
                            snapshotStateList.remove(((HoverInteraction.Exit) interaction).getEnter());
                        } else if (interaction instanceof FocusInteraction.Focus) {
                            snapshotStateList.add(interaction);
                        } else if (interaction instanceof FocusInteraction.Unfocus) {
                            snapshotStateList.remove(((FocusInteraction.Unfocus) interaction).getFocus());
                        } else if (interaction instanceof PressInteraction.Press) {
                            snapshotStateList.add(interaction);
                        } else if (interaction instanceof PressInteraction.Release) {
                            snapshotStateList.remove(((PressInteraction.Release) interaction).getPress());
                        } else if (interaction instanceof PressInteraction.Cancel) {
                            snapshotStateList.remove(((PressInteraction.Cancel) interaction).getPress());
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

    /* JADX INFO: renamed from: androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2, reason: invalid class name */
    /* JADX INFO: compiled from: FloatingActionButton.kt */
    @f(c = "androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2", f = "FloatingActionButton.kt", l = {318}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ Animatable<Dp, AnimationVector1D> $animatable;
        final /* synthetic */ Interaction $interaction;
        final /* synthetic */ float $target;
        int label;
        final /* synthetic */ DefaultFloatingActionButtonElevation this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Animatable<Dp, AnimationVector1D> animatable, DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation, float f10, Interaction interaction, d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$animatable = animatable;
            this.this$0 = defaultFloatingActionButtonElevation;
            this.$target = f10;
            this.$interaction = interaction;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass2(this.$animatable, this.this$0, this.$target, this.$interaction, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                float fM3687unboximpl = this.$animatable.getTargetValue().m3687unboximpl();
                Interaction focus = null;
                if (Dp.m3678equalsimpl0(fM3687unboximpl, this.this$0.pressedElevation)) {
                    focus = new PressInteraction.Press(Offset.Companion.m1383getZeroF1C5BW0(), null);
                } else if (Dp.m3678equalsimpl0(fM3687unboximpl, this.this$0.hoveredElevation)) {
                    focus = new HoverInteraction.Enter();
                } else if (Dp.m3678equalsimpl0(fM3687unboximpl, this.this$0.focusedElevation)) {
                    focus = new FocusInteraction.Focus();
                }
                Animatable<Dp, AnimationVector1D> animatable = this.$animatable;
                float f10 = this.$target;
                Interaction interaction = this.$interaction;
                this.label = 1;
                if (ElevationKt.m1016animateElevationrAjV9yQ(animatable, f10, focus, interaction, this) == objE) {
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
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public /* synthetic */ DefaultFloatingActionButtonElevation(float f10, float f11, float f12, float f13, k kVar) {
        this(f10, f11, f12, f13);
    }

    @Override // androidx.compose.material.FloatingActionButtonElevation
    @Composable
    @NotNull
    public State<Dp> elevation(@NotNull InteractionSource interactionSource, @Nullable Composer composer, int i10) {
        t.i(interactionSource, "interactionSource");
        composer.startReplaceableGroup(-478475335);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        Composer.Companion companion = Composer.Companion;
        if (objRememberedValue == companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt.mutableStateListOf();
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
        EffectsKt.LaunchedEffect(interactionSource, new AnonymousClass1(interactionSource, snapshotStateList, null), composer, i10 & 14);
        Interaction interaction = (Interaction) d0.u0(snapshotStateList);
        float f10 = interaction instanceof PressInteraction.Press ? this.pressedElevation : interaction instanceof HoverInteraction.Enter ? this.hoveredElevation : interaction instanceof FocusInteraction.Focus ? this.focusedElevation : this.defaultElevation;
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == companion.getEmpty()) {
            objRememberedValue2 = new Animatable(Dp.m3671boximpl(f10), VectorConvertersKt.getVectorConverter(Dp.Companion), null, 4, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        Animatable animatable = (Animatable) objRememberedValue2;
        EffectsKt.LaunchedEffect(Dp.m3671boximpl(f10), new AnonymousClass2(animatable, this, f10, interaction, null), composer, 0);
        State<Dp> stateAsState = animatable.asState();
        composer.endReplaceableGroup();
        return stateAsState;
    }

    private DefaultFloatingActionButtonElevation(float f10, float f11, float f12, float f13) {
        this.defaultElevation = f10;
        this.pressedElevation = f11;
        this.hoveredElevation = f12;
        this.focusedElevation = f13;
    }
}
