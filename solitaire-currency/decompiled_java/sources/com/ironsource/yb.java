package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class yb {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f16267e = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Runnable f16268a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f16269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private o f16270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private qk f16271d;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            IronLog.INTERNAL.verbose("loaded ads are expired");
            if (yb.this.f16270c != null) {
                yb.this.f16270c.b();
            }
        }
    }

    public yb(int i10, o oVar) {
        this.f16270c = oVar;
        this.f16269b = i10;
    }

    public boolean b() {
        return this.f16269b > 0;
    }

    public void a() {
        if (!b() || this.f16271d == null) {
            return;
        }
        IronLog.INTERNAL.verbose("canceling expiration timer");
        this.f16271d.e();
        this.f16271d = null;
    }

    public void a(long j10) {
        if (b()) {
            long millis = TimeUnit.MINUTES.toMillis(this.f16269b) - Math.max(j10, 0L);
            if (millis <= 0) {
                IronLog.INTERNAL.verbose("no delay - onAdExpired called");
                this.f16270c.b();
                return;
            }
            a();
            this.f16271d = new qk(millis, this.f16268a, true);
            Calendar calendar = Calendar.getInstance();
            calendar.add(14, (int) millis);
            IronLog.INTERNAL.verbose("loaded ads will expire on: " + calendar.getTime() + " in " + String.format(Locale.getDefault(), "%.2f", Double.valueOf((millis / 1000.0d) / 60.0d)) + " minutes");
        }
    }
}
