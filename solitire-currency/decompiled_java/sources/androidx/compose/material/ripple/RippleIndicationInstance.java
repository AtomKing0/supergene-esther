package androidx.compose.material.ripple;

import androidx.compose.foundation.IndicationInstance;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Ripple.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class RippleIndicationInstance implements IndicationInstance {

    @NotNull
    private final StateLayer stateLayer;

    public RippleIndicationInstance(boolean z10, @NotNull State<RippleAlpha> rippleAlpha) {
        t.i(rippleAlpha, "rippleAlpha");
        this.stateLayer = new StateLayer(z10, rippleAlpha);
    }

    public abstract void addRipple(@NotNull PressInteraction.Press press, @NotNull o0 o0Var);

    /* JADX INFO: renamed from: drawStateLayer-H2RKhps, reason: not valid java name */
    public final void m1236drawStateLayerH2RKhps(@NotNull DrawScope drawStateLayer, float f10, long j10) {
        t.i(drawStateLayer, "$this$drawStateLayer");
        this.stateLayer.m1240drawStateLayerH2RKhps(drawStateLayer, f10, j10);
    }

    public abstract void removeRipple(@NotNull PressInteraction.Press press);

    public final void updateStateLayer$material_ripple_release(@NotNull Interaction interaction, @NotNull o0 scope) {
        t.i(interaction, "interaction");
        t.i(scope, "scope");
        this.stateLayer.handleInteraction(interaction, scope);
    }
}
