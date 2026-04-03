package a6;

import androidx.annotation.GuardedBy;
import com.google.firebase.installations.i;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: RequestLimiter.java */
/* JADX INFO: loaded from: classes3.dex */
class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f315d = TimeUnit.HOURS.toMillis(24);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f316e = TimeUnit.MINUTES.toMillis(30);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f317a = i.c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy("this")
    private long f318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy("this")
    private int f319c;

    e() {
    }

    private synchronized long a(int i10) {
        if (c(i10)) {
            return (long) Math.min(Math.pow(2.0d, this.f319c) + this.f317a.e(), f316e);
        }
        return f315d;
    }

    private static boolean c(int i10) {
        return i10 == 429 || (i10 >= 500 && i10 < 600);
    }

    private static boolean d(int i10) {
        return (i10 >= 200 && i10 < 300) || i10 == 401 || i10 == 404;
    }

    private synchronized void e() {
        this.f319c = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean b() {
        /*
            r4 = this;
            monitor-enter(r4)
            int r0 = r4.f319c     // Catch: java.lang.Throwable -> L17
            if (r0 == 0) goto L14
            com.google.firebase.installations.i r0 = r4.f317a     // Catch: java.lang.Throwable -> L17
            long r0 = r0.a()     // Catch: java.lang.Throwable -> L17
            long r2 = r4.f318b     // Catch: java.lang.Throwable -> L17
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L12
            goto L14
        L12:
            r0 = 0
            goto L15
        L14:
            r0 = 1
        L15:
            monitor-exit(r4)
            return r0
        L17:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.e.b():boolean");
    }

    public synchronized void f(int i10) {
        if (d(i10)) {
            e();
            return;
        }
        this.f319c++;
        this.f318b = this.f317a.a() + a(i10);
    }
}
