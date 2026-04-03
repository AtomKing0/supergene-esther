package m2;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: AuxEffectInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f31424b;

    public y(int i10, float f10) {
        this.f31423a = i10;
        this.f31424b = f10;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y.class != obj.getClass()) {
            return false;
        }
        y yVar = (y) obj;
        return this.f31423a == yVar.f31423a && Float.compare(yVar.f31424b, this.f31424b) == 0;
    }

    public int hashCode() {
        return ((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f31423a) * 31) + Float.floatToIntBits(this.f31424b);
    }
}
