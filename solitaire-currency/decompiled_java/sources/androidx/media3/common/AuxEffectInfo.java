package androidx.media3.common;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public final class AuxEffectInfo {
    public static final int NO_AUX_EFFECT_ID = 0;
    public final int effectId;
    public final float sendLevel;

    public AuxEffectInfo(int i10, float f10) {
        this.effectId = i10;
        this.sendLevel = f10;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || AuxEffectInfo.class != obj.getClass()) {
            return false;
        }
        AuxEffectInfo auxEffectInfo = (AuxEffectInfo) obj;
        return this.effectId == auxEffectInfo.effectId && Float.compare(auxEffectInfo.sendLevel, this.sendLevel) == 0;
    }

    public int hashCode() {
        return ((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.effectId) * 31) + Float.floatToIntBits(this.sendLevel);
    }
}
