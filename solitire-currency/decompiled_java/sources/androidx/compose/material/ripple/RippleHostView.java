package androidx.compose.material.ripple;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: RippleHostView.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RippleHostView extends View {
    private static final long MinimumRippleStateChangeTime = 5;
    private static final long ResetRippleDelayDuration = 50;

    @Nullable
    private Boolean bounded;

    @Nullable
    private Long lastRippleStateChangeTimeMillis;

    @Nullable
    private h9.a<k0> onInvalidateRipple;

    @Nullable
    private Runnable resetRippleRunnable;

    @Nullable
    private UnprojectedRipple ripple;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final int[] PressedState = {android.R.attr.state_pressed, android.R.attr.state_enabled};

    @NotNull
    private static final int[] RestingState = new int[0];

    /* JADX INFO: compiled from: RippleHostView.android.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RippleHostView(@NotNull Context context) {
        super(context);
        t.i(context, "context");
    }

    private final void createRipple(boolean z10) {
        UnprojectedRipple unprojectedRipple = new UnprojectedRipple(z10);
        setBackground(unprojectedRipple);
        this.ripple = unprojectedRipple;
    }

    private final void setRippleState(boolean z10) {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Runnable runnable = this.resetRippleRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            runnable.run();
        }
        Long l10 = this.lastRippleStateChangeTimeMillis;
        long jLongValue = jCurrentAnimationTimeMillis - (l10 != null ? l10.longValue() : 0L);
        if (z10 || jLongValue >= MinimumRippleStateChangeTime) {
            int[] iArr = z10 ? PressedState : RestingState;
            UnprojectedRipple unprojectedRipple = this.ripple;
            if (unprojectedRipple != null) {
                unprojectedRipple.setState(iArr);
            }
        } else {
            Runnable runnable2 = new Runnable() { // from class: androidx.compose.material.ripple.a
                @Override // java.lang.Runnable
                public final void run() {
                    RippleHostView.m1233setRippleState$lambda2(this.f766a);
                }
            };
            this.resetRippleRunnable = runnable2;
            postDelayed(runnable2, ResetRippleDelayDuration);
        }
        this.lastRippleStateChangeTimeMillis = Long.valueOf(jCurrentAnimationTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setRippleState$lambda-2, reason: not valid java name */
    public static final void m1233setRippleState$lambda2(RippleHostView this$0) {
        t.i(this$0, "this$0");
        UnprojectedRipple unprojectedRipple = this$0.ripple;
        if (unprojectedRipple != null) {
            unprojectedRipple.setState(RestingState);
        }
        this$0.resetRippleRunnable = null;
    }

    /* JADX INFO: renamed from: addRipple-KOepWvA, reason: not valid java name */
    public final void m1234addRippleKOepWvA(@NotNull PressInteraction.Press interaction, boolean z10, long j10, int i10, long j11, float f10, @NotNull h9.a<k0> onInvalidateRipple) {
        t.i(interaction, "interaction");
        t.i(onInvalidateRipple, "onInvalidateRipple");
        if (this.ripple == null || !t.d(Boolean.valueOf(z10), this.bounded)) {
            createRipple(z10);
            this.bounded = Boolean.valueOf(z10);
        }
        UnprojectedRipple unprojectedRipple = this.ripple;
        t.f(unprojectedRipple);
        this.onInvalidateRipple = onInvalidateRipple;
        m1235updateRipplePropertiesbiQXAtU(j10, i10, j11, f10);
        if (z10) {
            unprojectedRipple.setHotspot(Offset.m1367getXimpl(interaction.m322getPressPositionF1C5BW0()), Offset.m1368getYimpl(interaction.m322getPressPositionF1C5BW0()));
        } else {
            unprojectedRipple.setHotspot(unprojectedRipple.getBounds().centerX(), unprojectedRipple.getBounds().centerY());
        }
        setRippleState(true);
    }

    public final void disposeRipple() {
        this.onInvalidateRipple = null;
        Runnable runnable = this.resetRippleRunnable;
        if (runnable != null) {
            removeCallbacks(runnable);
            Runnable runnable2 = this.resetRippleRunnable;
            t.f(runnable2);
            runnable2.run();
        } else {
            UnprojectedRipple unprojectedRipple = this.ripple;
            if (unprojectedRipple != null) {
                unprojectedRipple.setState(RestingState);
            }
        }
        UnprojectedRipple unprojectedRipple2 = this.ripple;
        if (unprojectedRipple2 == null) {
            return;
        }
        unprojectedRipple2.setVisible(false, false);
        unscheduleDrawable(unprojectedRipple2);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NotNull Drawable who) {
        t.i(who, "who");
        h9.a<k0> aVar = this.onInvalidateRipple;
        if (aVar != null) {
            aVar.invoke();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        setMeasuredDimension(0, 0);
    }

    public final void removeRipple() {
        setRippleState(false);
    }

    /* JADX INFO: renamed from: updateRippleProperties-biQXAtU, reason: not valid java name */
    public final void m1235updateRipplePropertiesbiQXAtU(long j10, int i10, long j11, float f10) {
        UnprojectedRipple unprojectedRipple = this.ripple;
        if (unprojectedRipple == null) {
            return;
        }
        unprojectedRipple.trySetRadius(i10);
        unprojectedRipple.m1242setColorDxMtmZc(j11, f10);
        Rect androidRect = RectHelper_androidKt.toAndroidRect(SizeKt.m1457toRectuvyYCjk(j10));
        setLeft(androidRect.left);
        setTop(androidRect.top);
        setRight(androidRect.right);
        setBottom(androidRect.bottom);
        unprojectedRipple.setBounds(androidRect);
    }

    @Override // android.view.View
    public void refreshDrawableState() {
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }
}
