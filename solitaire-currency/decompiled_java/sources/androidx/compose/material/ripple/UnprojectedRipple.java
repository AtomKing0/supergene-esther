package androidx.compose.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Method;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RippleHostView.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class UnprojectedRipple extends RippleDrawable {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static boolean setMaxRadiusFetched;

    @Nullable
    private static Method setMaxRadiusMethod;
    private final boolean bounded;
    private boolean projected;

    @Nullable
    private Color rippleColor;

    @Nullable
    private Integer rippleRadius;

    /* JADX INFO: compiled from: RippleHostView.android.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: RippleHostView.android.kt */
    @RequiresApi(23)
    private static final class MRadiusHelper {

        @NotNull
        public static final MRadiusHelper INSTANCE = new MRadiusHelper();

        private MRadiusHelper() {
        }

        @DoNotInline
        public final void setRadius(@NotNull RippleDrawable ripple, int i10) {
            t.i(ripple, "ripple");
            ripple.setRadius(i10);
        }
    }

    public UnprojectedRipple(boolean z10) {
        super(ColorStateList.valueOf(ViewCompat.MEASURED_STATE_MASK), null, z10 ? new ColorDrawable(-1) : null);
        this.bounded = z10;
    }

    /* JADX INFO: renamed from: calculateRippleColor-5vOe2sY, reason: not valid java name */
    private final long m1241calculateRippleColor5vOe2sY(long j10, float f10) {
        if (Build.VERSION.SDK_INT < 28) {
            f10 *= 2;
        }
        return Color.m1597copywmQWz5c$default(j10, o.i(f10, 1.0f), 0.0f, 0.0f, 0.0f, 14, null);
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.Drawable
    @NotNull
    public Rect getDirtyBounds() {
        if (!this.bounded) {
            this.projected = true;
        }
        Rect dirtyBounds = super.getDirtyBounds();
        t.h(dirtyBounds, "super.getDirtyBounds()");
        this.projected = false;
        return dirtyBounds;
    }

    @Override // android.graphics.drawable.RippleDrawable, android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public boolean isProjected() {
        return this.projected;
    }

    /* JADX INFO: renamed from: setColor-DxMtmZc, reason: not valid java name */
    public final void m1242setColorDxMtmZc(long j10, float f10) {
        long jM1241calculateRippleColor5vOe2sY = m1241calculateRippleColor5vOe2sY(j10, f10);
        Color color = this.rippleColor;
        if (color == null ? false : Color.m1599equalsimpl0(color.m1608unboximpl(), jM1241calculateRippleColor5vOe2sY)) {
            return;
        }
        this.rippleColor = Color.m1588boximpl(jM1241calculateRippleColor5vOe2sY);
        setColor(ColorStateList.valueOf(ColorKt.m1653toArgb8_81llA(jM1241calculateRippleColor5vOe2sY)));
    }

    public final void trySetRadius(int i10) {
        Integer num = this.rippleRadius;
        if (num != null && num.intValue() == i10) {
            return;
        }
        this.rippleRadius = Integer.valueOf(i10);
        MRadiusHelper.INSTANCE.setRadius(this, i10);
    }
}
