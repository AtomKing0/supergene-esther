package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class bd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ce f11391a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentHashMap<String, Object> f11392b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f11393c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicBoolean f11394d;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f11395a;

        a(Context context) {
            this.f11395a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                bd.this.e(this.f11395a);
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
            bd.this.f11393c.set(false);
        }
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static volatile bd f11397a = new bd(null);

        private b() {
        }
    }

    private bd() {
        this.f11393c = new AtomicBoolean(false);
        this.f11394d = new AtomicBoolean(false);
        this.f11391a = el.N().f();
        this.f11392b = new ConcurrentHashMap<>();
    }

    static bd a() {
        return b.f11397a;
    }

    private void d(Context context) {
        if (context == null || this.f11394d.getAndSet(true)) {
            return;
        }
        a("auid", this.f11391a.s(context));
        a("model", this.f11391a.e());
        a(ad.f11262r, this.f11391a.g());
        a("os", this.f11391a.l());
        String strO = this.f11391a.o();
        if (strO != null) {
            a(ad.f11278z, strO.replaceAll("[^0-9/.]", ""));
            a(ad.C, strO);
        }
        a(ad.f11218a, String.valueOf(this.f11391a.k()));
        String strJ = this.f11391a.j(context);
        if (!TextUtils.isEmpty(strJ)) {
            a(ad.f11277y0, strJ);
        }
        String strE = v3.e(context);
        if (!TextUtils.isEmpty(strE)) {
            a(ad.f11256o, strE);
        }
        String strI = this.f11391a.i(context);
        if (!TextUtils.isEmpty(strI)) {
            a(ad.f11251l0, strI);
        }
        a(ad.f11233f, context.getPackageName());
        a(ad.f11266t, String.valueOf(this.f11391a.h(context)));
        a(ad.S, ad.Z);
        a(ad.T, Long.valueOf(v3.f(context)));
        a(ad.R, Long.valueOf(v3.d(context)));
        a(ad.f11227d, v3.b(context));
        a(ad.F, Integer.valueOf(r8.f(context)));
        a(ad.P, r8.g(context));
        a("stid", un.c(context));
        a("platform", "android");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Context context) {
        if (context == null) {
            return;
        }
        try {
            String strP = this.f11391a.p(context);
            if (!TextUtils.isEmpty(strP)) {
                a(ad.D0, strP);
            }
            String strA = this.f11391a.a(context);
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            a(ad.f11260q, Boolean.valueOf(Boolean.parseBoolean(strA)));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    private void f(Context context) {
        if (context == null) {
            return;
        }
        a(context);
        String strD = this.f11391a.D(context);
        if (!TextUtils.isEmpty(strD)) {
            a(ad.f11269u0, strD);
        } else if (a(ad.f11269u0)) {
            b(ad.f11269u0);
        }
        String strB = this.f11391a.b(context);
        if (!TextUtils.isEmpty(strB)) {
            a(ad.f11258p, strB.toUpperCase(Locale.getDefault()));
        }
        String strB2 = this.f11391a.b();
        if (!TextUtils.isEmpty(strB2)) {
            a("tz", strB2);
        }
        String strB3 = s8.b(context);
        if (!TextUtils.isEmpty(strB3) && !strB3.equals("none")) {
            a(ad.f11245j, strB3);
        }
        String strD2 = s8.d(context);
        if (!TextUtils.isEmpty(strD2)) {
            a(ad.f11248k, strD2);
        }
        a("vpn", Boolean.valueOf(s8.e(context)));
        String strN = this.f11391a.n(context);
        if (!TextUtils.isEmpty(strN)) {
            a("icc", strN);
        }
        int iY = this.f11391a.y(context);
        if (iY >= 0) {
            a(ad.S0, Integer.valueOf(iY));
        }
        a(ad.T0, this.f11391a.A(context));
        a(ad.U0, this.f11391a.H(context));
        a(ad.X, Float.valueOf(this.f11391a.m(context)));
        a(ad.f11252m, String.valueOf(this.f11391a.n()));
        a(ad.I, Integer.valueOf(this.f11391a.d()));
        a(ad.H, Integer.valueOf(this.f11391a.j()));
        a(ad.G0, String.valueOf(this.f11391a.i()));
        a(ad.P0, String.valueOf(this.f11391a.p()));
        a("mcc", Integer.valueOf(r8.b(context)));
        a("mnc", Integer.valueOf(r8.c(context)));
        a(ad.K, Boolean.valueOf(this.f11391a.c()));
        a(ad.f11236g, Boolean.valueOf(this.f11391a.G(context)));
        a(ad.f11239h, Integer.valueOf(this.f11391a.l(context)));
        a(ad.f11221b, Boolean.valueOf(this.f11391a.c(context)));
        a(ad.D, Boolean.valueOf(this.f11391a.d(context)));
        a("rt", Boolean.valueOf(this.f11391a.f()));
        a(ad.Q, String.valueOf(this.f11391a.h()));
        a(ad.f11230e, Integer.valueOf(this.f11391a.w(context)));
        a(ad.H0, Boolean.valueOf(this.f11391a.q(context)));
        a(ad.f11224c, this.f11391a.f(context));
        a(ad.U, this.f11391a.s());
    }

    protected JSONObject b(Context context) throws JSONException {
        f(context);
        return new JSONObject(dd.a(this.f11392b));
    }

    protected void c(Context context) {
        try {
            d(context);
            f(context);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    /* synthetic */ bd(a aVar) {
        this();
    }

    protected void b(String str) {
        if (str == null) {
            return;
        }
        try {
            this.f11392b.remove(str);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    private void a(Context context) {
        if (this.f11393c.get()) {
            return;
        }
        try {
            this.f11393c.set(true);
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new a(context));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            this.f11393c.set(false);
        }
    }

    protected void b(String str, Object obj) {
        a(str, obj);
    }

    private void a(String str, Object obj) {
        if (str == null || obj == null) {
            return;
        }
        try {
            if (obj instanceof Boolean) {
                obj = Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
            }
            this.f11392b.put(str, obj);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    protected void a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            Object obj = this.f11392b.get(str);
            if (!(obj instanceof JSONObject)) {
                a(str, (Object) jSONObject);
                return;
            }
            JSONObject jSONObject2 = (JSONObject) obj;
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                jSONObject2.putOpt(next, jSONObject.opt(next));
            }
            a(str, (Object) jSONObject2);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    protected void a(Map<String, Object> map) {
        if (map == null) {
            return;
        }
        try {
            for (String str : map.keySet()) {
                if (map.containsKey(str)) {
                    a(str, map.get(str));
                }
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    private boolean a(String str) {
        if (str == null) {
            return false;
        }
        try {
            return this.f11392b.containsKey(str);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
            return false;
        }
    }
}
