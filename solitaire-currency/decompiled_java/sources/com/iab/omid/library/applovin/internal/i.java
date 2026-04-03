package com.iab.omid.library.applovin.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.applovin.internal.d;
import com.iab.omid.library.applovin.walking.TreeWalker;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class i implements d.a, com.iab.omid.library.applovin.devicevolume.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static i f10695f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f10696a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.applovin.devicevolume.e f10697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.iab.omid.library.applovin.devicevolume.b f10698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.applovin.devicevolume.d f10699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f10700e;

    public i(com.iab.omid.library.applovin.devicevolume.e eVar, com.iab.omid.library.applovin.devicevolume.b bVar) {
        this.f10697b = eVar;
        this.f10698c = bVar;
    }

    private c a() {
        if (this.f10700e == null) {
            this.f10700e = c.c();
        }
        return this.f10700e;
    }

    public static i c() {
        if (f10695f == null) {
            f10695f = new i(new com.iab.omid.library.applovin.devicevolume.e(), new com.iab.omid.library.applovin.devicevolume.b());
        }
        return f10695f;
    }

    public float b() {
        return this.f10696a;
    }

    public void d() {
        b.g().a(this);
        b.g().e();
        TreeWalker.getInstance().h();
        this.f10699d.c();
    }

    public void e() {
        TreeWalker.getInstance().j();
        b.g().f();
        this.f10699d.d();
    }

    @Override // com.iab.omid.library.applovin.devicevolume.c
    public void a(float f10) {
        this.f10696a = f10;
        Iterator<com.iab.omid.library.applovin.adsession.a> it = a().a().iterator();
        while (it.hasNext()) {
            it.next().d().a(f10);
        }
    }

    public void a(Context context) {
        this.f10699d = this.f10697b.a(new Handler(), context, this.f10698c.a(), this);
    }

    @Override // com.iab.omid.library.applovin.internal.d.a
    public void a(boolean z10) {
        if (z10) {
            TreeWalker.getInstance().h();
        } else {
            TreeWalker.getInstance().g();
        }
    }
}
