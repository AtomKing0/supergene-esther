package bo.app;

import android.graphics.Bitmap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bitmap f3977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f3978b;

    public u(Bitmap bitmap, Map map) {
        this.f3977a = bitmap;
        this.f3978b = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return kotlin.jvm.internal.t.d(this.f3977a, uVar.f3977a) && kotlin.jvm.internal.t.d(this.f3978b, uVar.f3978b);
    }

    public final int hashCode() {
        Bitmap bitmap = this.f3977a;
        int iHashCode = (bitmap == null ? 0 : bitmap.hashCode()) * 31;
        Map map = this.f3978b;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public final String toString() {
        return "BitmapAndHeaders(bitmap=" + this.f3977a + ", headers=" + this.f3978b + ')';
    }
}
