package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.m0;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class z5 extends w4 implements m0.e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.applovin.impl.sdk.network.a f7899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final m0.e f7900h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private r5.b f7901i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private l4 f7902j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private l4 f7903k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected m0.b f7904l;

    public z5(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
        this(aVar, jVar, false);
    }

    public abstract void a(String str, int i10, String str2, Object obj);

    public abstract void a(String str, Object obj, int i10);

    @Override // java.lang.Runnable
    public void run() {
        m0 m0VarU = b().u();
        if (!b().x0() && !b().u0()) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "AppLovin SDK is disabled");
            a(this.f7899g.f(), -22, null, null);
        } else if (!StringUtils.isValidString(this.f7899g.f()) || this.f7899g.f().length() < 4) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.b(this.f7678b, "Task has an invalid or null request endpoint.");
            }
            a(this.f7899g.f(), AppLovinErrorCodes.INVALID_URL, null, null);
        } else {
            if (TextUtils.isEmpty(this.f7899g.h())) {
                this.f7899g.b(this.f7899g.b() != null ? "POST" : "GET");
            }
            m0VarU.a(this.f7899g, this.f7904l, this.f7900h);
        }
    }

    class a implements m0.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.j f7905a;

        a(com.applovin.impl.sdk.j jVar) {
            this.f7905a = jVar;
        }

        @Override // com.applovin.impl.m0.e
        public void a(String str, Object obj, int i10) {
            z5.this.f7899g.a(0);
            z5.this.a(str, obj, i10);
        }

        @Override // com.applovin.impl.m0.e
        public void a(String str, int i10, String str2, Object obj) {
            long millis;
            boolean z10 = false;
            boolean z11 = i10 < 200 || i10 >= 500;
            boolean z12 = i10 == 429;
            boolean z13 = i10 != -1009 || z5.this.f7899g.q();
            boolean z14 = (i10 == -900 || i10 == -1000) ? false : true;
            if (z13 && z14 && (z11 || z12 || z5.this.f7899g.p())) {
                String strA = z5.this.f7899g.a();
                if (z5.this.f7899g.j() <= 0) {
                    if (strA != null && strA.equals(z5.this.f7899g.f())) {
                        z5 z5Var = z5.this;
                        z5Var.a(z5Var.f7903k);
                    } else {
                        z5 z5Var2 = z5.this;
                        z5Var2.a(z5Var2.f7902j);
                    }
                    z5 z5Var3 = z5.this;
                    z5Var3.a(z5Var3.f7899g.f(), i10, str2, obj);
                    return;
                }
                com.applovin.impl.sdk.n nVar = z5.this.f7679c;
                if (com.applovin.impl.sdk.n.a()) {
                    z5 z5Var4 = z5.this;
                    z5Var4.f7679c.k(z5Var4.f7678b, "Unable to send request due to server failure (code " + i10 + "). " + z5.this.f7899g.j() + " attempts left, retrying in " + TimeUnit.MILLISECONDS.toSeconds(z5.this.f7899g.k()) + " seconds...");
                }
                int iJ = z5.this.f7899g.j() - 1;
                z5.this.f7899g.a(iJ);
                if (iJ == 0) {
                    z5 z5Var5 = z5.this;
                    z5Var5.a(z5Var5.f7902j);
                    if (StringUtils.isValidString(strA) && strA.length() >= 4) {
                        com.applovin.impl.sdk.n nVar2 = z5.this.f7679c;
                        if (com.applovin.impl.sdk.n.a()) {
                            z5 z5Var6 = z5.this;
                            z5Var6.f7679c.d(z5Var6.f7678b, "Switching to backup endpoint " + strA);
                        }
                        z5.this.f7899g.a(strA);
                        z10 = true;
                    }
                }
                if (((Boolean) this.f7905a.a(l4.T2)).booleanValue() && z10) {
                    millis = 0;
                } else {
                    millis = z5.this.f7899g.n() ? TimeUnit.SECONDS.toMillis((long) Math.pow(2.0d, z5.this.f7899g.c())) : z5.this.f7899g.k();
                }
                r5 r5VarJ0 = this.f7905a.j0();
                z5 z5Var7 = z5.this;
                r5VarJ0.a(z5Var7, z5Var7.f7901i, millis);
                return;
            }
            z5 z5Var8 = z5.this;
            z5Var8.a(z5Var8.f7899g.f(), i10, str2, obj);
        }
    }

    public z5(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar, boolean z10) {
        super("TaskRepeatRequest", jVar, z10);
        this.f7901i = r5.b.OTHER;
        this.f7902j = null;
        this.f7903k = null;
        if (aVar == null) {
            throw new IllegalArgumentException("No request specified");
        }
        a(aVar.f());
        this.f7899g = aVar;
        this.f7904l = new m0.b();
        this.f7900h = new a(jVar);
    }

    public void b(l4 l4Var) {
        this.f7903k = l4Var;
    }

    public void c(l4 l4Var) {
        this.f7902j = l4Var;
    }

    public void a(r5.b bVar) {
        this.f7901i = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l4 l4Var) {
        if (l4Var != null) {
            b().h0().a(l4Var, l4Var.a());
        }
    }
}
