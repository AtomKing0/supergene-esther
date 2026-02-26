package com.ironsource.mediationsdk;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.gf;
import com.ironsource.m5;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.to;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final n f13722f = new n();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Long> f13723a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Boolean> f13724b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f13725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f13726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13727e;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSource.AD_UNIT f13728a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IronSourceError f13729b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f13730c;

        a(IronSource.AD_UNIT ad_unit, IronSourceError ironSourceError, String str) {
            this.f13728a = ad_unit;
            this.f13729b = ironSourceError;
            this.f13730c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            IronLog.INTERNAL.verbose("onAdLoadFailed - invokeCallback after delaying");
            n.this.a(this.f13728a, this.f13729b);
            n.this.f13724b.put(this.f13730c, Boolean.FALSE);
        }
    }

    private n() {
    }

    private int a(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return this.f13726d;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return this.f13725c;
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return this.f13727e;
        }
        IronLog.INTERNAL.warning("ad unit not supported - " + ad_unit);
        return 0;
    }

    public synchronized void b(IronSource.AD_UNIT ad_unit, IronSourceError ironSourceError) {
        if (b(ad_unit)) {
            return;
        }
        String string = ad_unit.toString();
        if (!this.f13723a.containsKey(string)) {
            a(ad_unit, ironSourceError);
            return;
        }
        long jA = ((long) a(ad_unit)) * 1000;
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f13723a.get(string).longValue();
        if (jCurrentTimeMillis > jA) {
            a(ad_unit, ironSourceError);
            return;
        }
        this.f13724b.put(string, Boolean.TRUE);
        long j10 = jA - jCurrentTimeMillis;
        IronLog.INTERNAL.verbose("delaying callback by " + j10);
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(ad_unit, ironSourceError, string), j10);
    }

    public static synchronized n a() {
        return f13722f;
    }

    public synchronized boolean b(IronSource.AD_UNIT ad_unit) {
        if (!this.f13724b.containsKey(ad_unit.toString())) {
            return false;
        }
        return this.f13724b.get(ad_unit.toString()).booleanValue();
    }

    public void a(IronSource.AD_UNIT ad_unit, int i10) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            this.f13726d = i10;
            return;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            this.f13725c = i10;
            return;
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            this.f13727e = i10;
            return;
        }
        IronLog.INTERNAL.warning("ad unit not supported - " + ad_unit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(IronSource.AD_UNIT ad_unit, IronSourceError ironSourceError) {
        this.f13723a.put(ad_unit.toString(), Long.valueOf(System.currentTimeMillis()));
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            to.a().a(ironSourceError);
            return;
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            gf.a().a(ironSourceError);
            return;
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            m5.a().a(ironSourceError);
            return;
        }
        IronLog.INTERNAL.warning("ad unit not supported - " + ad_unit);
    }
}
