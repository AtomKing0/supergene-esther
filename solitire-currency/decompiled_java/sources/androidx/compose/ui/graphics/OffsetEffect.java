package androidx.compose.ui.graphics;

import androidx.annotation.RequiresApi;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Offset;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidRenderEffect.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Immutable
public final class OffsetEffect extends RenderEffect {
    private final long offset;

    @Nullable
    private final RenderEffect renderEffect;

    public /* synthetic */ OffsetEffect(RenderEffect renderEffect, long j10, kotlin.jvm.internal.k kVar) {
        this(renderEffect, j10);
    }

    @Override // androidx.compose.ui.graphics.RenderEffect
    @RequiresApi(31)
    @NotNull
    protected android.graphics.RenderEffect createRenderEffect() {
        return RenderEffectVerificationHelper.INSTANCE.m1852createOffsetEffectUv8p0NA(this.renderEffect, this.offset);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffsetEffect)) {
            return false;
        }
        OffsetEffect offsetEffect = (OffsetEffect) obj;
        return kotlin.jvm.internal.t.d(this.renderEffect, offsetEffect.renderEffect) && Offset.m1364equalsimpl0(this.offset, offsetEffect.offset);
    }

    public int hashCode() {
        RenderEffect renderEffect = this.renderEffect;
        return ((renderEffect != null ? renderEffect.hashCode() : 0) * 31) + Offset.m1369hashCodeimpl(this.offset);
    }

    @NotNull
    public String toString() {
        return "OffsetEffect(renderEffect=" + this.renderEffect + ", offset=" + ((Object) Offset.m1375toStringimpl(this.offset)) + ')';
    }

    private OffsetEffect(RenderEffect renderEffect, long j10) {
        super(null);
        this.renderEffect = renderEffect;
        this.offset = j10;
    }
}
