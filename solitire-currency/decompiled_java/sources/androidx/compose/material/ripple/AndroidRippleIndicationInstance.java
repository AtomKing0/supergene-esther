package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import j9.c;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Ripple.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidRippleIndicationInstance extends RippleIndicationInstance implements RememberObserver {
    private final boolean bounded;

    @NotNull
    private final State<Color> color;

    @NotNull
    private final MutableState invalidateTick$delegate;

    @NotNull
    private final h9.a<k0> onInvalidateRipple;
    private final float radius;

    @NotNull
    private final State<RippleAlpha> rippleAlpha;

    @NotNull
    private final RippleContainer rippleContainer;

    @NotNull
    private final MutableState rippleHostView$delegate;
    private int rippleRadius;
    private long rippleSize;

    public /* synthetic */ AndroidRippleIndicationInstance(boolean z10, float f10, State state, State state2, RippleContainer rippleContainer, k kVar) {
        this(z10, f10, state, state2, rippleContainer);
    }

    private final void dispose() {
        this.rippleContainer.disposeRippleIfNeeded(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getInvalidateTick() {
        return ((Boolean) this.invalidateTick$delegate.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final RippleHostView getRippleHostView() {
        return (RippleHostView) this.rippleHostView$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setInvalidateTick(boolean z10) {
        this.invalidateTick$delegate.setValue(Boolean.valueOf(z10));
    }

    private final void setRippleHostView(RippleHostView rippleHostView) {
        this.rippleHostView$delegate.setValue(rippleHostView);
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void addRipple(@NotNull PressInteraction.Press interaction, @NotNull o0 scope) {
        t.i(interaction, "interaction");
        t.i(scope, "scope");
        RippleHostView rippleHostView = this.rippleContainer.getRippleHostView(this);
        rippleHostView.m1234addRippleKOepWvA(interaction, this.bounded, this.rippleSize, this.rippleRadius, this.color.getValue().m1608unboximpl(), this.rippleAlpha.getValue().getPressedAlpha(), this.onInvalidateRipple);
        setRippleHostView(rippleHostView);
    }

    @Override // androidx.compose.foundation.IndicationInstance
    public void drawIndication(@NotNull ContentDrawScope contentDrawScope) {
        t.i(contentDrawScope, "<this>");
        this.rippleSize = contentDrawScope.mo1996getSizeNHjbRc();
        this.rippleRadius = Float.isNaN(this.radius) ? c.c(RippleAnimationKt.m1231getRippleEndRadiuscSwnlzA(contentDrawScope, this.bounded, contentDrawScope.mo1996getSizeNHjbRc())) : contentDrawScope.mo290roundToPx0680j_4(this.radius);
        long jM1608unboximpl = this.color.getValue().m1608unboximpl();
        float pressedAlpha = this.rippleAlpha.getValue().getPressedAlpha();
        contentDrawScope.drawContent();
        m1236drawStateLayerH2RKhps(contentDrawScope, this.radius, jM1608unboximpl);
        Canvas canvas = contentDrawScope.getDrawContext().getCanvas();
        getInvalidateTick();
        RippleHostView rippleHostView = getRippleHostView();
        if (rippleHostView != null) {
            rippleHostView.m1235updateRipplePropertiesbiQXAtU(contentDrawScope.mo1996getSizeNHjbRc(), this.rippleRadius, jM1608unboximpl, pressedAlpha);
            rippleHostView.draw(AndroidCanvas_androidKt.getNativeCanvas(canvas));
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        dispose();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        dispose();
    }

    @Override // androidx.compose.material.ripple.RippleIndicationInstance
    public void removeRipple(@NotNull PressInteraction.Press interaction) {
        t.i(interaction, "interaction");
        RippleHostView rippleHostView = getRippleHostView();
        if (rippleHostView != null) {
            rippleHostView.removeRipple();
        }
    }

    public final void resetHostView() {
        setRippleHostView(null);
    }

    private AndroidRippleIndicationInstance(boolean z10, float f10, State<Color> state, State<RippleAlpha> state2, RippleContainer rippleContainer) {
        super(z10, state2);
        this.bounded = z10;
        this.radius = f10;
        this.color = state;
        this.rippleAlpha = state2;
        this.rippleContainer = rippleContainer;
        this.rippleHostView$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.invalidateTick$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.rippleSize = Size.Companion.m1445getZeroNHjbRc();
        this.rippleRadius = -1;
        this.onInvalidateRipple = new AndroidRippleIndicationInstance$onInvalidateRipple$1(this);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
    }
}
