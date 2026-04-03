package k2;

import android.os.Bundle;
import androidx.annotation.CheckResult;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import k2.h;

/* JADX INFO: compiled from: PlaybackParameters.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q2 implements h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q2 f29419d = new q2(1.0f);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h.a<q2> f29420e = new h.a() { // from class: k2.p2
        @Override // k2.h.a
        public final h fromBundle(Bundle bundle) {
            return q2.d(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f29421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f29422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f29423c;

    public q2(float f10) {
        this(f10, 1.0f);
    }

    private static String c(int i10) {
        return Integer.toString(i10, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ q2 d(Bundle bundle) {
        return new q2(bundle.getFloat(c(0), 1.0f), bundle.getFloat(c(1), 1.0f));
    }

    public long b(long j10) {
        return j10 * ((long) this.f29423c);
    }

    @CheckResult
    public q2 e(@FloatRange(from = 0.0d, fromInclusive = false) float f10) {
        return new q2(f10, this.f29422b);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q2.class != obj.getClass()) {
            return false;
        }
        q2 q2Var = (q2) obj;
        return this.f29421a == q2Var.f29421a && this.f29422b == q2Var.f29422b;
    }

    public int hashCode() {
        return ((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + Float.floatToRawIntBits(this.f29421a)) * 31) + Float.floatToRawIntBits(this.f29422b);
    }

    @Override // k2.h
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putFloat(c(0), this.f29421a);
        bundle.putFloat(c(1), this.f29422b);
        return bundle;
    }

    public String toString() {
        return a4.o0.z("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f29421a), Float.valueOf(this.f29422b));
    }

    public q2(@FloatRange(from = 0.0d, fromInclusive = false) float f10, @FloatRange(from = 0.0d, fromInclusive = false) float f11) {
        a4.a.a(f10 > 0.0f);
        a4.a.a(f11 > 0.0f);
        this.f29421a = f10;
        this.f29422b = f11;
        this.f29423c = Math.round(f10 * 1000.0f);
    }
}
