package com.ironsource;

import android.os.Handler;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ra implements de {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f14665e = 5;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ra f14666f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private qa f14667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f14668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Thread f14669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f14670d;

    private ra(String str, ve veVar, JSONObject jSONObject) {
        this.f14670d = str;
        this.f14667a = new qa(veVar.a());
        this.f14668b = jSONObject;
        IronSourceStorageUtils.deleteFolder(b());
        IronSourceStorageUtils.makeDir(b());
    }

    public static synchronized ra a(String str, ve veVar, JSONObject jSONObject) {
        if (f14666f == null) {
            f14666f = new ra(str, veVar, jSONObject);
        }
        return f14666f;
    }

    private String b() {
        return IronSourceStorageUtils.buildAbsolutePathToDirInCache(this.f14670d, x8.D);
    }

    public boolean c() {
        Thread thread = this.f14669c;
        return thread != null && thread.isAlive();
    }

    public synchronized void d() {
        f14666f = null;
        qa qaVar = this.f14667a;
        if (qaVar != null) {
            qaVar.a();
            this.f14667a = null;
        }
    }

    private Thread b(zf zfVar, String str, int i10, int i11, Handler handler) {
        if (i10 <= 0) {
            i10 = this.f14668b.optInt("connectionTimeout", 5);
        }
        if (i11 <= 0) {
            i11 = this.f14668b.optInt("readTimeout", 5);
        }
        boolean zOptBoolean = this.f14668b.optBoolean(x8.H, false);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return a(new oa(zfVar, str, (int) timeUnit.toMillis(i10), (int) timeUnit.toMillis(i11), zOptBoolean, b()), handler);
    }

    public String a() {
        return this.f14670d;
    }

    private Thread a(oa oaVar, Handler handler) {
        return new Thread(new fs(oaVar, handler));
    }

    @Override // com.ironsource.de
    public void a(hn hnVar) {
        this.f14667a.a(hnVar);
    }

    @Override // com.ironsource.de
    public void a(zf zfVar, String str) {
        int iOptInt = this.f14668b.optInt("connectionTimeout", 5);
        int iOptInt2 = this.f14668b.optInt("readTimeout", 5);
        boolean zOptBoolean = this.f14668b.optBoolean(x8.H, false);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Thread threadA = a(new oa(zfVar, str, (int) timeUnit.toMillis(iOptInt), (int) timeUnit.toMillis(iOptInt2), zOptBoolean, b()), this.f14667a);
        this.f14669c = threadA;
        threadA.start();
    }

    @Override // com.ironsource.de
    public void a(zf zfVar, String str, int i10, int i11) {
        b(zfVar, str, i10, i11, this.f14667a).start();
    }

    @Override // com.ironsource.de
    public void a(zf zfVar, String str, int i10, int i11, Handler handler) {
        b(zfVar, str, i10, i11, handler).start();
    }
}
