package x4;

import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX INFO: compiled from: RelativeCornerSize.java */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f36134a;

    public i(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        this.f36134a = f10;
    }

    private static float b(@NonNull RectF rectF) {
        return Math.min(rectF.width(), rectF.height());
    }

    @Override // x4.c
    public float a(@NonNull RectF rectF) {
        return this.f36134a * b(rectF);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f36134a == ((i) obj).f36134a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f36134a)});
    }
}
