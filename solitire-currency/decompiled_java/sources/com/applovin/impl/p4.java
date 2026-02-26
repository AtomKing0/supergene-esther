package com.applovin.impl;

import android.os.SystemClock;
import com.applovin.mediation.MaxAdFormat;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class p4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f6545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f6546b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f6547c = new Object();

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f6548a;

        static {
            int[] iArr = new int[b.values().length];
            f6548a = iArr;
            try {
                iArr[b.AD_FORMAT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6548a[b.AD_UNIT_ID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6548a[b.ALL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum b {
        AD_FORMAT,
        AD_UNIT_ID,
        ALL
    }

    private static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q4 f6553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f6554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f6555c;

        /* synthetic */ c(q4 q4Var, long j10, a aVar) {
            this(q4Var, j10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean d() {
            return SystemClock.elapsedRealtime() - this.f6555c > this.f6554b;
        }

        protected boolean a(Object obj) {
            return obj instanceof c;
        }

        public q4 c() {
            return this.f6553a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!cVar.a((Object) this) || b() != cVar.b() || a() != cVar.a()) {
                return false;
            }
            q4 q4VarC = c();
            q4 q4VarC2 = cVar.c();
            return q4VarC != null ? q4VarC.equals(q4VarC2) : q4VarC2 == null;
        }

        public int hashCode() {
            long jB = b();
            long jA = a();
            q4 q4VarC = c();
            return ((((((int) (jB ^ (jB >>> 32))) + 59) * 59) + ((int) ((jA >>> 32) ^ jA))) * 59) + (q4VarC == null ? 43 : q4VarC.hashCode());
        }

        public String toString() {
            return "SignalCacheManager.SignalWrapper(signal=" + c() + ", expirationTimeMillis=" + b() + ", cacheTimestampMillis=" + a() + ")";
        }

        private c(q4 q4Var, long j10) {
            this.f6553a = q4Var;
            this.f6554b = j10;
            this.f6555c = SystemClock.elapsedRealtime();
        }

        public long b() {
            return this.f6554b;
        }

        public long a() {
            return this.f6555c;
        }
    }

    public p4(com.applovin.impl.sdk.j jVar) {
        this.f6545a = jVar;
    }

    public void a(q4 q4Var, r4 r4Var, String str, MaxAdFormat maxAdFormat) {
        if (q4Var == null) {
            return;
        }
        long jU = r4Var.u();
        if (jU <= 0) {
            return;
        }
        this.f6545a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f6545a.I().a("SignalCacheManager", "Caching signal for: " + r4Var);
        }
        String strA = a(r4Var, str, maxAdFormat);
        c cVar = new c(q4Var, jU, null);
        synchronized (this.f6547c) {
            this.f6546b.put(strA, cVar);
        }
    }

    public q4 b(r4 r4Var, String str, MaxAdFormat maxAdFormat) {
        String strA = a(r4Var, str, maxAdFormat);
        synchronized (this.f6547c) {
            c cVar = (c) this.f6546b.get(strA);
            if (cVar == null) {
                return null;
            }
            if (cVar.d()) {
                this.f6546b.remove(strA);
                return null;
            }
            this.f6545a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f6545a.I().a("SignalCacheManager", "Returning cached signal for: " + r4Var);
            }
            return cVar.f6553a;
        }
    }

    private String a(r4 r4Var, String str, MaxAdFormat maxAdFormat) {
        String strC = r4Var.c();
        int i10 = a.f6548a[r4Var.t().ordinal()];
        if (i10 == 1) {
            return strC + "_" + maxAdFormat.getLabel();
        }
        if (i10 != 2) {
            return strC;
        }
        return strC + "_" + str;
    }
}
