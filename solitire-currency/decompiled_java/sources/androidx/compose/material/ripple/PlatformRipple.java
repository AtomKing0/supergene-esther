package androidx.compose.material.ripple;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Ripple.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public final class PlatformRipple extends Ripple {
    public /* synthetic */ PlatformRipple(boolean z10, float f10, State state, k kVar) {
        this(z10, f10, state);
    }

    @Composable
    private final ViewGroup findNearestViewGroup(Composer composer, int i10) {
        composer.startReplaceableGroup(-1737891121);
        Object objConsume = composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        while (!(objConsume instanceof ViewGroup)) {
            ViewParent parent = ((View) objConsume).getParent();
            if (!(parent instanceof View)) {
                throw new IllegalArgumentException(("Couldn't find a valid parent for " + objConsume + ". Are you overriding LocalView and providing a View that is not attached to the view hierarchy?").toString());
            }
            t.h(parent, "parent");
            objConsume = parent;
        }
        ViewGroup viewGroup = (ViewGroup) objConsume;
        composer.endReplaceableGroup();
        return viewGroup;
    }

    @Override // androidx.compose.material.ripple.Ripple
    @Composable
    @NotNull
    /* JADX INFO: renamed from: rememberUpdatedRippleInstance-942rkJo */
    public RippleIndicationInstance mo1228rememberUpdatedRippleInstance942rkJo(@NotNull InteractionSource interactionSource, boolean z10, float f10, @NotNull State<Color> color, @NotNull State<RippleAlpha> rippleAlpha, @Nullable Composer composer, int i10) {
        View rippleContainer;
        t.i(interactionSource, "interactionSource");
        t.i(color, "color");
        t.i(rippleAlpha, "rippleAlpha");
        composer.startReplaceableGroup(331259447);
        ViewGroup viewGroupFindNearestViewGroup = findNearestViewGroup(composer, (i10 >> 15) & 14);
        composer.startReplaceableGroup(1643267286);
        if (viewGroupFindNearestViewGroup.isInEditMode()) {
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
            composer.endReplaceableGroup();
            return commonRippleIndicationInstance;
        }
        composer.endReplaceableGroup();
        int childCount = viewGroupFindNearestViewGroup.getChildCount();
        int i11 = 0;
        while (true) {
            if (i11 >= childCount) {
                rippleContainer = null;
                break;
            }
            rippleContainer = viewGroupFindNearestViewGroup.getChildAt(i11);
            if (rippleContainer instanceof RippleContainer) {
                break;
            }
            i11++;
        }
        if (rippleContainer == null) {
            Context context = viewGroupFindNearestViewGroup.getContext();
            t.h(context, "view.context");
            rippleContainer = new RippleContainer(context);
            viewGroupFindNearestViewGroup.addView(rippleContainer);
        }
        composer.startReplaceableGroup(-3686095);
        boolean zChanged2 = composer.changed(interactionSource) | composer.changed(this) | composer.changed(rippleContainer);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.Companion.getEmpty()) {
            objRememberedValue2 = new AndroidRippleIndicationInstance(z10, f10, color, rippleAlpha, (RippleContainer) rippleContainer, null);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        AndroidRippleIndicationInstance androidRippleIndicationInstance = (AndroidRippleIndicationInstance) objRememberedValue2;
        composer.endReplaceableGroup();
        return androidRippleIndicationInstance;
    }

    private PlatformRipple(boolean z10, float f10, State<Color> state) {
        super(z10, f10, state, null);
    }
}
