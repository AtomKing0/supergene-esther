package androidx.compose.foundation.interaction;

import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import h9.p;
import java.util.ArrayList;
import kotlin.coroutines.jvm.internal.b;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import s9.i;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: PressInteraction.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PressInteractionKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.interaction.PressInteractionKt$collectIsPressedAsState$1, reason: invalid class name */
    /* JADX INFO: compiled from: PressInteraction.kt */
    @f(c = "androidx.compose.foundation.interaction.PressInteractionKt$collectIsPressedAsState$1", f = "PressInteraction.kt", l = {85}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ MutableState<Boolean> $isPressed;
        final /* synthetic */ InteractionSource $this_collectIsPressedAsState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(InteractionSource interactionSource, MutableState<Boolean> mutableState, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$this_collectIsPressedAsState = interactionSource;
            this.$isPressed = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass1(this.$this_collectIsPressedAsState, this.$isPressed, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                final ArrayList arrayList = new ArrayList();
                h<Interaction> interactions = this.$this_collectIsPressedAsState.getInteractions();
                final MutableState<Boolean> mutableState = this.$isPressed;
                i<Interaction> iVar = new i<Interaction>() { // from class: androidx.compose.foundation.interaction.PressInteractionKt.collectIsPressedAsState.1.1
                    @Override // s9.i
                    public /* bridge */ /* synthetic */ Object emit(Interaction interaction, d dVar) {
                        return emit2(interaction, (d<? super k0>) dVar);
                    }

                    @Nullable
                    /* JADX INFO: renamed from: emit, reason: avoid collision after fix types in other method */
                    public final Object emit2(@NotNull Interaction interaction, @NotNull d<? super k0> dVar) {
                        if (interaction instanceof PressInteraction.Press) {
                            arrayList.add(interaction);
                        } else if (interaction instanceof PressInteraction.Release) {
                            arrayList.remove(((PressInteraction.Release) interaction).getPress());
                        } else if (interaction instanceof PressInteraction.Cancel) {
                            arrayList.remove(((PressInteraction.Cancel) interaction).getPress());
                        }
                        mutableState.setValue(b.a(!arrayList.isEmpty()));
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

    @Composable
    @NotNull
    public static final State<Boolean> collectIsPressedAsState(@NotNull InteractionSource interactionSource, @Nullable Composer composer, int i10) {
        t.i(interactionSource, "<this>");
        composer.startReplaceableGroup(-1692965168);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) objRememberedValue;
        EffectsKt.LaunchedEffect(interactionSource, new AnonymousClass1(interactionSource, mutableState, null), composer, i10 & 14);
        composer.endReplaceableGroup();
        return mutableState;
    }
}
