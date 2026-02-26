package com.applovin.impl;

import androidx.core.util.Consumer;
import com.applovin.impl.i4;
import com.applovin.impl.q3;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final List f5846e = Arrays.asList("5.0/i", "4.0/ad", "1.0/mediate");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f5847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f5848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final q3 f5849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d f5850d;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f5851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f5852b;

        public long a() {
            return this.f5851a;
        }

        public long b() {
            return this.f5852b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(long j10) {
            this.f5851a = j10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(long j10) {
            this.f5852b = j10;
        }
    }

    private class c implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.applovin.impl.sdk.network.a f5854b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f5855c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Object f5856d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f5857e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final b f5858f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final e f5859g;

        @Override // androidx.core.util.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(q3.d dVar) {
            int i10;
            long jE = dVar.e();
            Object objA = null;
            try {
                try {
                    int iC = dVar.c();
                    try {
                        if (iC <= 0) {
                            m0.this.a(this.f5855c, this.f5853a, iC, jE, (Throwable) null);
                            this.f5859g.a(this.f5853a, iC, null, null);
                            return;
                        }
                        if (iC < 200 || iC >= 400) {
                            this.f5859g.a(this.f5853a, iC, null, null);
                            return;
                        }
                        b bVar = this.f5858f;
                        if (bVar != null) {
                            bVar.a(jE);
                        }
                        m0.this.a(this.f5855c, this.f5853a, iC, jE);
                        byte[] bArrD = dVar.d();
                        if (z6.f(com.applovin.impl.sdk.j.n()) && (!this.f5857e || i4.b(bArrD) != i4.a.V2)) {
                            m0.this.f5847a.r().a(bArrD != null ? new String(dVar.d(), Charset.forName("UTF-8")) : "", this.f5853a, this.f5854b.b() != null ? this.f5854b.b().toString() : "");
                        }
                        if (bArrD == null) {
                            this.f5859g.a(this.f5853a, this.f5856d, iC);
                            return;
                        }
                        String str = new String(dVar.d(), Charset.forName("UTF-8"));
                        b bVar2 = this.f5858f;
                        if (bVar2 != null) {
                            bVar2.b(bArrD.length);
                            if (this.f5854b.r()) {
                                m0.this.f5850d = new d(this.f5854b.f(), bArrD.length, jE);
                            }
                        }
                        if (this.f5857e) {
                            String strB = i4.b(bArrD, m0.this.f5847a.b0(), m0.this.f5847a);
                            if (strB == null) {
                                HashMap map = new HashMap(2);
                                map.put(com.vungle.ads.internal.ui.a.REQUEST_KEY_EXTRA, StringUtils.getHostAndPath(this.f5853a));
                                map.put("response", str);
                                m0.this.f5847a.B().trackEvent("rdf", map);
                            }
                            str = strB;
                        }
                        try {
                            this.f5859g.a(this.f5853a, m0.this.a(str, this.f5856d), iC);
                        } catch (Throwable th) {
                            String str2 = "Unable to parse response from " + StringUtils.getHostAndPath(this.f5853a) + " because of " + th.getClass().getName() + " : " + th.getMessage();
                            com.applovin.impl.sdk.n unused = m0.this.f5848b;
                            if (com.applovin.impl.sdk.n.a()) {
                                m0.this.f5848b.a("ConnectionManager", str2, th);
                            }
                            m0.this.f5847a.E().c(v1.f7564n);
                            m0.this.f5847a.A().a("ConnectionManager", "failedToParseResponse", th, CollectionUtils.hashMap("url", StringUtils.getHostAndPath(this.f5853a)));
                            this.f5859g.a(this.f5853a, AppLovinErrorCodes.INVALID_RESPONSE, str2, null);
                        }
                    } catch (MalformedURLException e10) {
                        e = e10;
                        i10 = iC;
                        if (this.f5856d != null) {
                            m0.this.a(this.f5855c, this.f5853a, i10, jE, e);
                            this.f5859g.a(this.f5853a, -901, e.getMessage(), null);
                        } else {
                            m0.this.a(this.f5855c, this.f5853a, i10, jE);
                            this.f5859g.a(this.f5853a, this.f5856d, -901);
                        }
                    }
                } catch (Throwable th2) {
                    int iB = dVar.b();
                    try {
                        byte[] bArrF = dVar.f();
                        String str3 = new String(bArrF);
                        if (bArrF != null) {
                            if (this.f5857e) {
                                str3 = i4.b(bArrF, m0.this.f5847a.b0(), m0.this.f5847a);
                            }
                            objA = m0.this.a(str3, this.f5856d);
                        }
                    } catch (Throwable unused2) {
                    }
                    m0.this.a(this.f5855c, this.f5853a, iB, jE, th2);
                    this.f5859g.a(this.f5853a, iB, th2.getMessage(), objA);
                }
            } catch (MalformedURLException e11) {
                e = e11;
                i10 = 0;
            }
        }

        private c(String str, com.applovin.impl.sdk.network.a aVar, String str2, Object obj, boolean z10, b bVar, e eVar) {
            this.f5853a = str;
            this.f5854b = aVar;
            this.f5855c = str2;
            this.f5856d = obj;
            this.f5857e = z10;
            this.f5858f = bVar;
            this.f5859g = eVar;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f5861a = System.currentTimeMillis();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f5862b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f5863c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f5864d;

        public d(String str, long j10, long j11) {
            this.f5862b = str;
            this.f5863c = j10;
            this.f5864d = j11;
        }

        protected boolean a(Object obj) {
            return obj instanceof d;
        }

        public long b() {
            return this.f5863c;
        }

        public long c() {
            return this.f5861a;
        }

        public String d() {
            return this.f5862b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (!dVar.a(this) || c() != dVar.c() || b() != dVar.b() || a() != dVar.a()) {
                return false;
            }
            String strD = d();
            String strD2 = dVar.d();
            return strD != null ? strD.equals(strD2) : strD2 == null;
        }

        public int hashCode() {
            long jC = c();
            long jB = b();
            int i10 = ((((int) (jC ^ (jC >>> 32))) + 59) * 59) + ((int) (jB ^ (jB >>> 32)));
            long jA = a();
            String strD = d();
            return (((i10 * 59) + ((int) ((jA >>> 32) ^ jA))) * 59) + (strD == null ? 43 : strD.hashCode());
        }

        public String toString() {
            return "ConnectionManager.RequestMeasurement(timestampMillis=" + c() + ", urlHostAndPathString=" + d() + ", responseSizeBytes=" + b() + ", connectionTimeMillis=" + a() + ")";
        }

        public long a() {
            return this.f5864d;
        }
    }

    public interface e {
        void a(String str, int i10, String str2, Object obj);

        void a(String str, Object obj, int i10);
    }

    public m0(com.applovin.impl.sdk.j jVar) {
        this.f5847a = jVar;
        this.f5848b = jVar.I();
        q3 q3Var = new q3(jVar);
        this.f5849c = q3Var;
        q3Var.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0247 A[Catch: all -> 0x029d, TryCatch #2 {all -> 0x029d, blocks: (B:44:0x0128, B:46:0x0138, B:50:0x0164, B:49:0x0160, B:51:0x0173, B:54:0x0198, B:56:0x01b4, B:60:0x01d5, B:76:0x022d, B:79:0x023c, B:81:0x0247, B:62:0x01d9, B:65:0x01e1, B:71:0x01f9, B:73:0x01ff, B:74:0x0219, B:57:0x01c2, B:82:0x024a, B:84:0x0250, B:85:0x0264, B:67:0x01f2), top: B:107:0x0128, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(com.applovin.impl.sdk.network.a r24, com.applovin.impl.m0.b r25, com.applovin.impl.m0.e r26) {
        /*
            Method dump skipped, instruction units count: 732
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.m0.a(com.applovin.impl.sdk.network.a, com.applovin.impl.m0$b, com.applovin.impl.m0$e):void");
    }

    public d a() {
        return this.f5850d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object a(String str, Object obj) {
        if (obj == null) {
            return str;
        }
        if (str != null && str.length() >= 3) {
            if (obj instanceof JSONObject) {
                return new JSONObject(str);
            }
            if (obj instanceof b8) {
                return c8.a(str, this.f5847a);
            }
            if (obj instanceof String) {
                return str;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f5848b.b("ConnectionManager", "Failed to process response of type '" + obj.getClass().getName() + "'");
            }
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i10, long j10) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f5848b.d("ConnectionManager", "Successful " + str + " returned " + i10 + " in " + (j10 / 1000.0f) + " s over " + n0.g(this.f5847a) + " to " + a(str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2, int i10, long j10, Throwable th) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f5848b.a("ConnectionManager", "Failed " + str + " returned " + i10 + " in " + (j10 / 1000.0f) + " s over " + n0.g(this.f5847a) + " to " + a(str2), th);
        }
    }

    private String a(String str) {
        return "#" + str.hashCode() + " \"" + StringUtils.getHostAndPath(str) + "\"";
    }
}
