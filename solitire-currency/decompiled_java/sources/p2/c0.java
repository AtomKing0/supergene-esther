package p2;

import androidx.annotation.Nullable;
import com.ironsource.v8;

/* JADX INFO: compiled from: SeekPoint.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c0 f32448c = new c0(0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f32449a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f32450b;

    public c0(long j10, long j11) {
        this.f32449a = j10;
        this.f32450b = j11;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c0.class != obj.getClass()) {
            return false;
        }
        c0 c0Var = (c0) obj;
        return this.f32449a == c0Var.f32449a && this.f32450b == c0Var.f32450b;
    }

    public int hashCode() {
        return (((int) this.f32449a) * 31) + ((int) this.f32450b);
    }

    public String toString() {
        return "[timeUs=" + this.f32449a + ", position=" + this.f32450b + v8.i.f15839e;
    }
}
