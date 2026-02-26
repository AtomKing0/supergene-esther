package com.applovin.impl.sdk;

import com.applovin.impl.q2;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f7315a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f7316b = new HashMap(5);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f7317c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f7318d = Collections.synchronizedMap(new HashMap(5));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f7319e = Collections.synchronizedMap(new HashMap(5));

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f7320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f7321b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f7322c;

        public a(String str, String str2, String str3) {
            this.f7320a = str;
            this.f7321b = str2;
            this.f7322c = str3;
        }

        protected boolean a(Object obj) {
            return obj instanceof a;
        }

        public String b() {
            return this.f7320a;
        }

        public String c() {
            return this.f7322c;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.a(this)) {
                return false;
            }
            String strB = b();
            String strB2 = aVar.b();
            if (strB != null ? !strB.equals(strB2) : strB2 != null) {
                return false;
            }
            String strA = a();
            String strA2 = aVar.a();
            if (strA != null ? !strA.equals(strA2) : strA2 != null) {
                return false;
            }
            String strC = c();
            String strC2 = aVar.c();
            return strC != null ? strC.equals(strC2) : strC2 == null;
        }

        public int hashCode() {
            String strB = b();
            int iHashCode = strB == null ? 43 : strB.hashCode();
            String strA = a();
            int iHashCode2 = ((iHashCode + 59) * 59) + (strA == null ? 43 : strA.hashCode());
            String strC = c();
            return (iHashCode2 * 59) + (strC != null ? strC.hashCode() : 43);
        }

        public String toString() {
            return "MediationWaterfallWinnerTracker.WinningAd(bCode=" + b() + ", adapterName=" + a() + ", networkName=" + c() + ")";
        }

        public String a() {
            return this.f7321b;
        }
    }

    o(j jVar) {
        this.f7315a = jVar.I();
    }

    public String a(String str) {
        return (String) this.f7319e.get(str);
    }

    public void b(q2 q2Var) {
        this.f7318d.put(q2Var.getAdUnitId(), q2Var.N());
    }

    public void c(q2 q2Var) {
        synchronized (this.f7317c) {
            if (n.a()) {
                this.f7315a.a("MediationWaterfallWinnerTracker", "Tracking winning ad: " + q2Var);
            }
            this.f7316b.put(q2Var.getAdUnitId(), new a(q2Var.C(), q2Var.c(), q2Var.getNetworkName()));
        }
        this.f7319e.put(q2Var.getAdUnitId(), q2Var.N());
    }

    public void a(q2 q2Var) {
        synchronized (this.f7317c) {
            String adUnitId = q2Var.getAdUnitId();
            a aVar = (a) this.f7316b.get(adUnitId);
            if (aVar == null) {
                if (n.a()) {
                    this.f7315a.a("MediationWaterfallWinnerTracker", "No previous winner to clear.");
                }
                return;
            }
            if (q2Var.C().equals(aVar.b())) {
                if (n.a()) {
                    this.f7315a.a("MediationWaterfallWinnerTracker", "Clearing previous winning ad: " + aVar);
                }
                this.f7316b.remove(adUnitId);
            } else if (n.a()) {
                this.f7315a.a("MediationWaterfallWinnerTracker", "Previous winner not cleared for ad: " + q2Var + " , since it could have already been updated with a new ad: " + aVar);
            }
        }
    }

    public String b(String str) {
        return (String) this.f7318d.get(str);
    }

    public a c(String str) {
        a aVar;
        synchronized (this.f7317c) {
            aVar = (a) this.f7316b.get(str);
        }
        return aVar;
    }
}
