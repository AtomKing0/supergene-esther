package x4;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

/* JADX INFO: compiled from: AbsoluteCornerSize.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f36080a;

    public a(float f10) {
        this.f36080a = f10;
    }

    @Override // x4.c
    public float a(@NonNull RectF rectF) {
        return this.f36080a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f36080a == ((a) obj).f36080a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f36080a)});
    }
}
