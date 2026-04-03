package androidx.compose.ui.graphics;

import androidx.annotation.RequiresApi;
import androidx.compose.runtime.Immutable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidRenderEffect.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class BlurEffect extends RenderEffect {
    private final int edgeTreatment;
    private final float radiusX;
    private final float radiusY;

    @Nullable
    private final RenderEffect renderEffect;

    public /* synthetic */ BlurEffect(RenderEffect renderEffect, float f10, float f11, int i10, kotlin.jvm.internal.k kVar) {
        this(renderEffect, f10, f11, i10);
    }

    @Override // androidx.compose.ui.graphics.RenderEffect
    @RequiresApi(31)
    @NotNull
    protected android.graphics.RenderEffect createRenderEffect() {
        return RenderEffectVerificationHelper.INSTANCE.m1851createBlurEffect8A3gB4(this.renderEffect, this.radiusX, this.radiusY, this.edgeTreatment);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlurEffect)) {
            return false;
        }
        BlurEffect blurEffect = (BlurEffect) obj;
        if (this.radiusX == blurEffect.radiusX) {
            return ((this.radiusY > blurEffect.radiusY ? 1 : (this.radiusY == blurEffect.radiusY ? 0 : -1)) == 0) && TileMode.m1901equalsimpl0(this.edgeTreatment, blurEffect.edgeTreatment) && kotlin.jvm.internal.t.d(this.renderEffect, blurEffect.renderEffect);
        }
        return false;
    }

    public int hashCode() {
        RenderEffect renderEffect = this.renderEffect;
        return ((((((renderEffect != null ? renderEffect.hashCode() : 0) * 31) + Float.floatToIntBits(this.radiusX)) * 31) + Float.floatToIntBits(this.radiusY)) * 31) + TileMode.m1902hashCodeimpl(this.edgeTreatment);
    }

    @NotNull
    public String toString() {
        return "BlurEffect(renderEffect=" + this.renderEffect + ", radiusX=" + this.radiusX + ", radiusY=" + this.radiusY + ", edgeTreatment=" + ((Object) TileMode.m1903toStringimpl(this.edgeTreatment)) + ')';
    }

    private BlurEffect(RenderEffect renderEffect, float f10, float f11, int i10) {
        super(null);
        this.renderEffect = renderEffect;
        this.radiusX = f10;
        this.radiusY = f11;
        this.edgeTreatment = i10;
    }

    public /* synthetic */ BlurEffect(RenderEffect renderEffect, float f10, float f11, int i10, int i11, kotlin.jvm.internal.k kVar) {
        this(renderEffect, f10, (i11 & 4) != 0 ? f10 : f11, (i11 & 8) != 0 ? TileMode.Companion.m1905getClamp3opZhB0() : i10, null);
    }
}
