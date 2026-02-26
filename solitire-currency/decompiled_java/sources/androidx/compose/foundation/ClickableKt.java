package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.key.KeyInputModifierKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Clickable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ClickableKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.ClickableKt$PressedInteractionSourceDisposableEffect$2, reason: invalid class name */
    /* JADX INFO: compiled from: Clickable.kt */
    static final class AnonymousClass2 extends v implements h9.p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ MutableInteractionSource $interactionSource;
        final /* synthetic */ MutableState<PressInteraction.Press> $pressedInteraction;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState, int i10) {
            super(2);
            this.$interactionSource = mutableInteractionSource;
            this.$pressedInteraction = mutableState;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            ClickableKt.PressedInteractionSourceDisposableEffect(this.$interactionSource, this.$pressedInteraction, composer, this.$$changed | 1);
        }
    }

    @Composable
    public static final void PressedInteractionSourceDisposableEffect(@NotNull MutableInteractionSource interactionSource, @NotNull MutableState<PressInteraction.Press> pressedInteraction, @Nullable Composer composer, int i10) {
        int i11;
        t.i(interactionSource, "interactionSource");
        t.i(pressedInteraction, "pressedInteraction");
        Composer composerStartRestartGroup = composer.startRestartGroup(1761107222);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(interactionSource) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i10 & 112) == 0) {
            i11 |= composerStartRestartGroup.changed(pressedInteraction) ? 32 : 16;
        }
        if ((i11 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged = composerStartRestartGroup.changed(pressedInteraction) | composerStartRestartGroup.changed(interactionSource);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new ClickableKt$PressedInteractionSourceDisposableEffect$1$1(pressedInteraction, interactionSource);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(interactionSource, (h9.l<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composerStartRestartGroup, i11 & 14);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(interactionSource, pressedInteraction, i10));
    }

    @NotNull
    /* JADX INFO: renamed from: clickable-O2vRcR0, reason: not valid java name */
    public static final Modifier m182clickableO2vRcR0(@NotNull Modifier clickable, @NotNull MutableInteractionSource interactionSource, @Nullable Indication indication, boolean z10, @Nullable String str, @Nullable Role role, @NotNull h9.a<k0> onClick) {
        t.i(clickable, "$this$clickable");
        t.i(interactionSource, "interactionSource");
        t.i(onClick, "onClick");
        return ComposedModifierKt.composed(clickable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$clickableO2vRcR0$$inlined$debugInspectorInfo$1(z10, str, role, onClick, indication, interactionSource) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$clickable$4(onClick, z10, interactionSource, indication, str, role));
    }

    /* JADX INFO: renamed from: clickable-O2vRcR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m183clickableO2vRcR0$default(Modifier modifier, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z10, String str, Role role, h9.a aVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        return m182clickableO2vRcR0(modifier, mutableInteractionSource, indication, z10, (i10 & 8) != 0 ? null : str, (i10 & 16) != 0 ? null : role, aVar);
    }

    @NotNull
    /* JADX INFO: renamed from: clickable-XHw0xAI, reason: not valid java name */
    public static final Modifier m184clickableXHw0xAI(@NotNull Modifier clickable, boolean z10, @Nullable String str, @Nullable Role role, @NotNull h9.a<k0> onClick) {
        t.i(clickable, "$this$clickable");
        t.i(onClick, "onClick");
        return ComposedModifierKt.composed(clickable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$clickableXHw0xAI$$inlined$debugInspectorInfo$1(z10, str, role, onClick) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$clickable$2(z10, str, role, onClick));
    }

    /* JADX INFO: renamed from: clickable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m185clickableXHw0xAI$default(Modifier modifier, boolean z10, String str, Role role, h9.a aVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        if ((i10 & 4) != 0) {
            role = null;
        }
        return m184clickableXHw0xAI(modifier, z10, str, role, aVar);
    }

    @ExperimentalFoundationApi
    @NotNull
    /* JADX INFO: renamed from: combinedClickable-XVZzFYc, reason: not valid java name */
    public static final Modifier m186combinedClickableXVZzFYc(@NotNull Modifier combinedClickable, @NotNull MutableInteractionSource interactionSource, @Nullable Indication indication, boolean z10, @Nullable String str, @Nullable Role role, @Nullable String str2, @Nullable h9.a<k0> aVar, @Nullable h9.a<k0> aVar2, @NotNull h9.a<k0> onClick) {
        t.i(combinedClickable, "$this$combinedClickable");
        t.i(interactionSource, "interactionSource");
        t.i(onClick, "onClick");
        return ComposedModifierKt.composed(combinedClickable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$combinedClickableXVZzFYc$$inlined$debugInspectorInfo$1(z10, str, role, onClick, aVar2, aVar, str2, indication, interactionSource) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$combinedClickable$4(onClick, aVar, aVar2, z10, interactionSource, indication, str, role, str2));
    }

    @ExperimentalFoundationApi
    @NotNull
    /* JADX INFO: renamed from: combinedClickable-cJG_KMw, reason: not valid java name */
    public static final Modifier m188combinedClickablecJG_KMw(@NotNull Modifier combinedClickable, boolean z10, @Nullable String str, @Nullable Role role, @Nullable String str2, @Nullable h9.a<k0> aVar, @Nullable h9.a<k0> aVar2, @NotNull h9.a<k0> onClick) {
        t.i(combinedClickable, "$this$combinedClickable");
        t.i(onClick, "onClick");
        return ComposedModifierKt.composed(combinedClickable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ClickableKt$combinedClickablecJG_KMw$$inlined$debugInspectorInfo$1(z10, str, role, onClick, aVar2, aVar, str2) : InspectableValueKt.getNoInspectorInfo(), new ClickableKt$combinedClickable$2(z10, str, role, str2, aVar, aVar2, onClick));
    }

    @NotNull
    /* JADX INFO: renamed from: genericClickableWithoutGesture-BI-LeDI, reason: not valid java name */
    public static final Modifier m190genericClickableWithoutGestureBILeDI(@NotNull Modifier genericClickableWithoutGesture, @NotNull Modifier gestureModifiers, @NotNull MutableInteractionSource interactionSource, @Nullable Indication indication, boolean z10, @Nullable String str, @Nullable Role role, @Nullable String str2, @Nullable h9.a<k0> aVar, @NotNull h9.a<k0> onClick) {
        t.i(genericClickableWithoutGesture, "$this$genericClickableWithoutGesture");
        t.i(gestureModifiers, "gestureModifiers");
        t.i(interactionSource, "interactionSource");
        t.i(onClick, "onClick");
        return FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(genericClickableWithoutGesture_BI_LeDI$detectClickFromKey(genericClickableWithoutGesture_BI_LeDI$clickSemantics(genericClickableWithoutGesture, role, str, aVar, str2, z10, onClick), z10, onClick), interactionSource, indication), interactionSource, z10), z10, interactionSource).then(gestureModifiers);
    }

    private static final Modifier genericClickableWithoutGesture_BI_LeDI$clickSemantics(Modifier modifier, Role role, String str, h9.a<k0> aVar, String str2, boolean z10, h9.a<k0> aVar2) {
        return SemanticsModifierKt.semantics(modifier, true, new ClickableKt$genericClickableWithoutGesture$clickSemantics$1(role, str, aVar, str2, z10, aVar2));
    }

    private static final Modifier genericClickableWithoutGesture_BI_LeDI$detectClickFromKey(Modifier modifier, boolean z10, h9.a<k0> aVar) {
        return KeyInputModifierKt.onKeyEvent(modifier, new ClickableKt$genericClickableWithoutGesture$detectClickFromKey$1(z10, aVar));
    }

    @Nullable
    /* JADX INFO: renamed from: handlePressInteraction-EPk0efs, reason: not valid java name */
    public static final Object m192handlePressInteractionEPk0efs(@NotNull PressGestureScope pressGestureScope, long j10, @NotNull MutableInteractionSource mutableInteractionSource, @NotNull MutableState<PressInteraction.Press> mutableState, @NotNull State<? extends h9.a<Boolean>> state, @NotNull z8.d<? super k0> dVar) {
        Object objF = p0.f(new ClickableKt$handlePressInteraction$2(pressGestureScope, j10, mutableInteractionSource, mutableState, state, null), dVar);
        return objF == a9.d.e() ? objF : k0.f35197a;
    }
}
