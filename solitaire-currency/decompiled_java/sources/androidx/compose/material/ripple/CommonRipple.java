package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CommonRipple.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public final class CommonRipple extends Ripple {
    public /* synthetic */ CommonRipple(boolean z10, float f10, State state, k kVar) {
        this(z10, f10, state);
    }

    @Override // androidx.compose.material.ripple.Ripple
    @Composable
    @NotNull
    /* JADX INFO: renamed from: rememberUpdatedRippleInstance-942rkJo, reason: not valid java name */
    public RippleIndicationInstance mo1228rememberUpdatedRippleInstance942rkJo(@NotNull InteractionSource interactionSource, boolean z10, float f10, @NotNull State<Color> color, @NotNull State<RippleAlpha> rippleAlpha, @Nullable Composer composer, int i10) {
        t.i(interactionSource, "interactionSource");
        t.i(color, "color");
        t.i(rippleAlpha, "rippleAlpha");
        composer.startReplaceableGroup(-1768051227);
        composer.startReplaceableGroup(-3686552);
        boolean zChanged = composer.changed(interactionSource) | composer.changed(this);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new CommonRippleIndicationInstance(z10, f10, color, rippleAlpha, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        CommonRippleIndicationInstance commonRippleIndicationInstance = (CommonRippleIndicationInstance) objRememberedValue;
        composer.endReplaceableGroup();
        return commonRippleIndicationInstance;
    }

    private CommonRipple(boolean z10, float f10, State<Color> state) {
        super(z10, f10, state, null);
    }
}
