package bo.app;

import android.content.SharedPreferences;
import com.braze.support.DateTimeUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class rd0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3773a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SharedPreferences f3775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public double f3777e;

    public rd0(int i10, int i11, SharedPreferences storage) {
        kotlin.jvm.internal.t.i(storage, "storage");
        this.f3773a = i10;
        this.f3774b = i11;
        this.f3775c = storage;
        this.f3776d = storage.getLong("last_call_at_ms", 0L);
        this.f3777e = storage.getFloat("current_token_count", (float) a());
    }

    public final double a(long j10) {
        return Math.min((((j10 - this.f3776d) / ((double) n9.o.e(this.f3774b, 1))) / ((double) 1000)) + this.f3777e, n9.o.e(this.f3773a, 1));
    }

    public final void b() {
        long jNowInMilliseconds = DateTimeUtils.nowInMilliseconds();
        this.f3777e = a(jNowInMilliseconds);
        this.f3776d = jNowInMilliseconds;
        this.f3775c.edit().putLong("last_call_at_ms", this.f3776d).putFloat("current_token_count", (float) this.f3777e).apply();
        double d10 = this.f3777e;
        if (d10 < 1.0d) {
            return;
        }
        this.f3777e = d10 - ((double) 1);
    }

    public final long c() {
        this.f3777e = a(DateTimeUtils.nowInMilliseconds());
        this.f3775c.edit().putLong("last_call_at_ms", this.f3776d).putFloat("current_token_count", (float) this.f3777e).apply();
        double d10 = this.f3777e;
        if (d10 >= 1.0d) {
            return 0L;
        }
        return Math.max(0L, (long) ((((double) 1) - d10) * ((double) n9.o.e(this.f3774b, 1)) * ((double) 1000)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("(capacity=");
        sb.append(n9.o.e(this.f3773a, 1));
        sb.append(", refillRate=");
        sb.append(n9.o.e(this.f3774b, 1));
        sb.append(", lastCallAt='");
        sb.append(DateTimeUtils.formatDateFromMillis$default(this.f3776d, null, null, 3, null));
        sb.append("', currentTokenCount=");
        sb.append(a(DateTimeUtils.nowInMilliseconds()));
        sb.append(')');
        return sb.toString();
    }

    public final double a() {
        return n9.o.e(this.f3773a, 1);
    }
}
