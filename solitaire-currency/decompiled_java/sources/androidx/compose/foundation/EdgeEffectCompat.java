package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EdgeEffectCompat.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EdgeEffectCompat {

    @NotNull
    public static final EdgeEffectCompat INSTANCE = new EdgeEffectCompat();

    private EdgeEffectCompat() {
    }

    @NotNull
    public final EdgeEffect create(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        t.i(context, "context");
        return Build.VERSION.SDK_INT >= 31 ? Api31Impl.INSTANCE.create(context, attributeSet) : new EdgeEffect(context);
    }

    public final float getDistanceCompat(@NotNull EdgeEffect edgeEffect) {
        t.i(edgeEffect, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.INSTANCE.getDistance(edgeEffect);
        }
        return 0.0f;
    }

    public final void onAbsorbCompat(@NotNull EdgeEffect edgeEffect, int i10) {
        t.i(edgeEffect, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            edgeEffect.onAbsorb(i10);
        } else if (edgeEffect.isFinished()) {
            edgeEffect.onAbsorb(i10);
        }
    }

    public final float onPullDistanceCompat(@NotNull EdgeEffect edgeEffect, float f10, float f11) {
        t.i(edgeEffect, "<this>");
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.INSTANCE.onPullDistance(edgeEffect, f10, f11);
        }
        edgeEffect.onPull(f10, f11);
        return f10;
    }
}
