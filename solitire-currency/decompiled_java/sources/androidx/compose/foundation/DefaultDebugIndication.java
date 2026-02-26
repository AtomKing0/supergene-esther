package androidx.compose.foundation;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.HoverInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteractionKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Indication.kt */
/* JADX INFO: loaded from: classes.dex */
final class DefaultDebugIndication implements Indication {

    @NotNull
    public static final DefaultDebugIndication INSTANCE = new DefaultDebugIndication();

    /* JADX INFO: compiled from: Indication.kt */
    private static final class DefaultDebugIndicationInstance implements IndicationInstance {

        @NotNull
        private final State<Boolean> isFocused;

        @NotNull
        private final State<Boolean> isHovered;

        @NotNull
        private final State<Boolean> isPressed;

        public DefaultDebugIndicationInstance(@NotNull State<Boolean> isPressed, @NotNull State<Boolean> isHovered, @NotNull State<Boolean> isFocused) {
            t.i(isPressed, "isPressed");
            t.i(isHovered, "isHovered");
            t.i(isFocused, "isFocused");
            this.isPressed = isPressed;
            this.isHovered = isHovered;
            this.isFocused = isFocused;
        }

        @Override // androidx.compose.foundation.IndicationInstance
        public void drawIndication(@NotNull ContentDrawScope contentDrawScope) {
            t.i(contentDrawScope, "<this>");
            contentDrawScope.drawContent();
            if (this.isPressed.getValue().booleanValue()) {
                androidx.compose.ui.graphics.drawscope.b.K(contentDrawScope, Color.m1597copywmQWz5c$default(Color.Companion.m1624getBlack0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), 0L, contentDrawScope.mo1996getSizeNHjbRc(), 0.0f, null, null, 0, 122, null);
            } else if (this.isHovered.getValue().booleanValue() || this.isFocused.getValue().booleanValue()) {
                androidx.compose.ui.graphics.drawscope.b.K(contentDrawScope, Color.m1597copywmQWz5c$default(Color.Companion.m1624getBlack0d7_KjU(), 0.1f, 0.0f, 0.0f, 0.0f, 14, null), 0L, contentDrawScope.mo1996getSizeNHjbRc(), 0.0f, null, null, 0, 122, null);
            }
        }
    }

    private DefaultDebugIndication() {
    }

    @Override // androidx.compose.foundation.Indication
    @Composable
    @NotNull
    public IndicationInstance rememberUpdatedInstance(@NotNull InteractionSource interactionSource, @Nullable Composer composer, int i10) {
        t.i(interactionSource, "interactionSource");
        composer.startReplaceableGroup(1683566979);
        int i11 = i10 & 14;
        State<Boolean> stateCollectIsPressedAsState = PressInteractionKt.collectIsPressedAsState(interactionSource, composer, i11);
        State<Boolean> stateCollectIsHoveredAsState = HoverInteractionKt.collectIsHoveredAsState(interactionSource, composer, i11);
        State<Boolean> stateCollectIsFocusedAsState = FocusInteractionKt.collectIsFocusedAsState(interactionSource, composer, i11);
        composer.startReplaceableGroup(1157296644);
        boolean zChanged = composer.changed(interactionSource);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new DefaultDebugIndicationInstance(stateCollectIsPressedAsState, stateCollectIsHoveredAsState, stateCollectIsFocusedAsState);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DefaultDebugIndicationInstance defaultDebugIndicationInstance = (DefaultDebugIndicationInstance) objRememberedValue;
        composer.endReplaceableGroup();
        return defaultDebugIndicationInstance;
    }
}
