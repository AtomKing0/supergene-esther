package com.ironsource.sdk.controller;

import com.ironsource.i9;
import com.ironsource.nb;
import com.ironsource.ra;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.sf;
import com.ironsource.v8;
import com.ironsource.vp;
import com.ironsource.xf;
import com.ironsource.zf;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
class d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final String f14901h = "controllerSourceData";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f14902i = "next_";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String f14903j = "fallback_";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String f14904k = "controllerSourceCode";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f14905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f14906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f14907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EnumC0266d f14908d = EnumC0266d.NONE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14909e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14910f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ra f14911g;

    class a extends JSONObject {
        a() throws JSONException {
            putOpt(v8.a.f15682i, Integer.valueOf(d.this.f14906b));
            putOpt(d.f14904k, Integer.valueOf(d.this.f14908d.a()));
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f14913a;

        static {
            int[] iArr = new int[c.values().length];
            f14913a = iArr;
            try {
                iArr[c.FETCH_FROM_SERVER_NO_FALLBACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14913a[c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14913a[c.FETCH_FOR_NEXT_SESSION_LOAD_FROM_LOCAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum c {
        FETCH_FROM_SERVER_NO_FALLBACK,
        FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK,
        FETCH_FOR_NEXT_SESSION_LOAD_FROM_LOCAL
    }

    /* JADX INFO: renamed from: com.ironsource.sdk.controller.d$d, reason: collision with other inner class name */
    public enum EnumC0266d {
        NONE(0),
        PREPARED_CONTROLLER_LOADED(1),
        CONTROLLER_FROM_SERVER(2),
        MISSING_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER(3),
        FAILED_RENAME_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER(4),
        FALLBACK_CONTROLLER_RECOVERY(5);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f14925a;

        EnumC0266d(int i10) {
            this.f14925a = i10;
        }

        public int a() {
            return this.f14925a;
        }
    }

    d(JSONObject jSONObject, String str, String str2, ra raVar) {
        int iOptInt = jSONObject.optInt(v8.a.f15682i, -1);
        this.f14906b = iOptInt;
        this.f14907c = a(iOptInt);
        this.f14909e = str;
        this.f14910f = str2;
        this.f14911g = raVar;
    }

    private void c() {
        try {
            zf zfVarG = g();
            if (zfVarG.exists()) {
                zf zfVarH = h();
                if (zfVarH.exists()) {
                    zfVarH.delete();
                }
                IronSourceStorageUtils.renameFile(zfVarG.getPath(), zfVarH.getPath());
            }
        } catch (Exception e10) {
            i9.d().a(e10);
        }
    }

    private void d() {
        IronSourceStorageUtils.deleteFile(h());
    }

    private void e() {
        IronSourceStorageUtils.deleteFile(g());
    }

    private zf h() {
        return new zf(this.f14909e, "fallback_mobileController.html");
    }

    private zf i() {
        return new zf(this.f14909e, "next_mobileController.html");
    }

    private boolean j() {
        return h().exists();
    }

    private void l() {
        sf sfVarA = new sf().a(nb.f14127y, Integer.valueOf(this.f14906b));
        if (this.f14905a > 0) {
            sfVarA.a(nb.B, Long.valueOf(System.currentTimeMillis() - this.f14905a));
        }
        xf.a(vp.f15956x, sfVarA.a());
    }

    JSONObject f() throws JSONException {
        return new a();
    }

    zf g() {
        return new zf(this.f14909e, v8.f15655f);
    }

    boolean k() {
        zf zfVar;
        int i10 = b.f14913a[this.f14907c.ordinal()];
        if (i10 == 1) {
            e();
            zfVar = new zf(this.f14909e, SDKUtils.getFileName(this.f14910f));
        } else {
            if (i10 != 2) {
                if (i10 == 3) {
                    try {
                        zf zfVarG = g();
                        zf zfVarI = i();
                        if (!zfVarI.exists() && !zfVarG.exists()) {
                            a(new zf(this.f14909e, SDKUtils.getFileName(this.f14910f)));
                            return false;
                        }
                        if (!zfVarI.exists() && zfVarG.exists()) {
                            EnumC0266d enumC0266d = EnumC0266d.MISSING_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER;
                            this.f14908d = enumC0266d;
                            a(enumC0266d);
                            a(new zf(this.f14909e, zfVarI.getName()));
                            return true;
                        }
                        c();
                        if (b()) {
                            EnumC0266d enumC0266d2 = EnumC0266d.PREPARED_CONTROLLER_LOADED;
                            this.f14908d = enumC0266d2;
                            a(enumC0266d2);
                            d();
                            a(new zf(this.f14909e, zfVarI.getName()));
                            return true;
                        }
                        if (!a()) {
                            a(new zf(this.f14909e, SDKUtils.getFileName(this.f14910f)));
                            return false;
                        }
                        EnumC0266d enumC0266d3 = EnumC0266d.FAILED_RENAME_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER;
                        this.f14908d = enumC0266d3;
                        a(enumC0266d3);
                        a(new zf(this.f14909e, zfVarI.getName()));
                        return true;
                    } catch (Exception e10) {
                        i9.d().a(e10);
                    }
                }
                return false;
            }
            c();
            zfVar = new zf(this.f14909e, SDKUtils.getFileName(this.f14910f));
        }
        a(zfVar);
        return false;
    }

    boolean m() {
        return this.f14908d != EnumC0266d.NONE;
    }

    private c a(int i10) {
        return i10 != 1 ? i10 != 2 ? c.FETCH_FROM_SERVER_NO_FALLBACK : c.FETCH_FOR_NEXT_SESSION_LOAD_FROM_LOCAL : c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK;
    }

    private boolean b() throws Exception {
        return IronSourceStorageUtils.renameFile(i().getPath(), g().getPath());
    }

    private void a(EnumC0266d enumC0266d) {
        sf sfVarA = new sf().a(nb.f14127y, Integer.valueOf(this.f14906b)).a(nb.f14128z, Integer.valueOf(enumC0266d.a()));
        if (this.f14905a > 0) {
            sfVarA.a(nb.B, Long.valueOf(System.currentTimeMillis() - this.f14905a));
        }
        xf.a(vp.f15955w, sfVarA.a());
    }

    void a(sf sfVar) {
        sfVar.a(nb.f14127y, Integer.valueOf(this.f14906b));
        xf.a(vp.f15954v, sfVar.a());
        this.f14905a = System.currentTimeMillis();
    }

    private void a(zf zfVar) {
        if (this.f14911g.c()) {
            return;
        }
        this.f14911g.a(zfVar, this.f14910f);
    }

    void a(Runnable runnable) {
        if (m()) {
            return;
        }
        if (this.f14907c == c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK) {
            d();
        }
        EnumC0266d enumC0266d = EnumC0266d.CONTROLLER_FROM_SERVER;
        this.f14908d = enumC0266d;
        a(enumC0266d);
        runnable.run();
    }

    void a(Runnable runnable, Runnable runnable2) {
        if (m()) {
            return;
        }
        if (this.f14907c != c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK || !a()) {
            l();
            runnable2.run();
        } else {
            EnumC0266d enumC0266d = EnumC0266d.FALLBACK_CONTROLLER_RECOVERY;
            this.f14908d = enumC0266d;
            a(enumC0266d);
            runnable.run();
        }
    }

    private boolean a() {
        try {
            if (j()) {
                return IronSourceStorageUtils.renameFile(h().getPath(), g().getPath());
            }
            return false;
        } catch (Exception e10) {
            i9.d().a(e10);
            return false;
        }
    }
}
