package f2;

import android.app.job.JobInfo;
import androidx.annotation.RequiresApi;
import com.google.auto.value.AutoValue;
import f2.c;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: SchedulerConfig.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class f {

    /* JADX INFO: compiled from: SchedulerConfig.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private i2.a f25599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Map<w1.e, b> f25600b = new HashMap();

        public a a(w1.e eVar, b bVar) {
            this.f25600b.put(eVar, bVar);
            return this;
        }

        public f b() {
            if (this.f25599a == null) {
                throw new NullPointerException("missing required property: clock");
            }
            if (this.f25600b.keySet().size() < w1.e.values().length) {
                throw new IllegalStateException("Not all priorities have been configured");
            }
            Map<w1.e, b> map = this.f25600b;
            this.f25600b = new HashMap();
            return f.d(this.f25599a, map);
        }

        public a c(i2.a aVar) {
            this.f25599a = aVar;
            return this;
        }
    }

    /* JADX INFO: compiled from: SchedulerConfig.java */
    @AutoValue
    public static abstract class b {

        /* JADX INFO: compiled from: SchedulerConfig.java */
        @AutoValue.Builder
        public static abstract class a {
            public abstract b a();

            public abstract a b(long j10);

            public abstract a c(Set<c> set);

            public abstract a d(long j10);
        }

        public static a a() {
            return new c.b().c(Collections.emptySet());
        }

        abstract long b();

        abstract Set<c> c();

        abstract long d();
    }

    /* JADX INFO: compiled from: SchedulerConfig.java */
    public enum c {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    private long a(int i10, long j10) {
        return (long) (Math.pow(3.0d, i10 - 1) * j10 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j10 > 1 ? j10 : 2L) * ((long) r7))));
    }

    public static a b() {
        return new a();
    }

    static f d(i2.a aVar, Map<w1.e, b> map) {
        return new f2.b(aVar, map);
    }

    public static f f(i2.a aVar) {
        return b().a(w1.e.DEFAULT, b.a().b(30000L).d(com.vungle.ads.internal.signals.b.TWENTY_FOUR_HOURS_MILLIS).a()).a(w1.e.HIGHEST, b.a().b(1000L).d(com.vungle.ads.internal.signals.b.TWENTY_FOUR_HOURS_MILLIS).a()).a(w1.e.VERY_LOW, b.a().b(com.vungle.ads.internal.signals.b.TWENTY_FOUR_HOURS_MILLIS).d(com.vungle.ads.internal.signals.b.TWENTY_FOUR_HOURS_MILLIS).c(i(c.DEVICE_IDLE)).a()).c(aVar).b();
    }

    private static <T> Set<T> i(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }

    @RequiresApi(api = 21)
    private void j(JobInfo.Builder builder, Set<c> set) {
        if (set.contains(c.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(c.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(c.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    @RequiresApi(api = 21)
    public JobInfo.Builder c(JobInfo.Builder builder, w1.e eVar, long j10, int i10) {
        builder.setMinimumLatency(g(eVar, j10, i10));
        j(builder, h().get(eVar).c());
        return builder;
    }

    abstract i2.a e();

    public long g(w1.e eVar, long j10, int i10) {
        long jA = j10 - e().a();
        b bVar = h().get(eVar);
        return Math.min(Math.max(a(i10, bVar.b()), jA), bVar.d());
    }

    abstract Map<w1.e, b> h();
}
