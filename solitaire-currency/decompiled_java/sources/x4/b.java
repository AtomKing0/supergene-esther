package x4;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

/* JADX INFO: compiled from: AdjustedCornerSize.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f36081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f36082b;

    public b(float f10, @NonNull c cVar) {
        while (cVar instanceof b) {
            cVar = ((b) cVar).f36081a;
            f10 += ((b) cVar).f36082b;
        }
        this.f36081a = cVar;
        this.f36082b = f10;
    }

    @Override // x4.c
    public float a(@NonNull RectF rectF) {
        return Math.max(0.0f, this.f36081a.a(rectF) + this.f36082b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f36081a.equals(bVar.f36081a) && this.f36082b == bVar.f36082b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f36081a, Float.valueOf(this.f36082b)});
    }
}
