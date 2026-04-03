package com.iab.omid.library.vungle.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.vungle.internal.d;
import com.iab.omid.library.vungle.walking.TreeWalker;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class i implements d.a, com.iab.omid.library.vungle.devicevolume.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static i f11083f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f11084a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.vungle.devicevolume.e f11085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.iab.omid.library.vungle.devicevolume.b f11086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.vungle.devicevolume.d f11087d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f11088e;

    public i(com.iab.omid.library.vungle.devicevolume.e eVar, com.iab.omid.library.vungle.devicevolume.b bVar) {
        this.f11085b = eVar;
        this.f11086c = bVar;
    }

    private c a() {
        if (this.f11088e == null) {
            this.f11088e = c.c();
        }
        return this.f11088e;
    }

    public static i c() {
        if (f11083f == null) {
            f11083f = new i(new com.iab.omid.library.vungle.devicevolume.e(), new com.iab.omid.library.vungle.devicevolume.b());
        }
        return f11083f;
    }

    public float b() {
        return this.f11084a;
    }

    public void d() {
        b.g().a(this);
        b.g().e();
        TreeWalker.getInstance().h();
        this.f11087d.c();
    }

    public void e() {
        TreeWalker.getInstance().j();
        b.g().f();
        this.f11087d.d();
    }

    @Override // com.iab.omid.library.vungle.devicevolume.c
    public void a(float f10) {
        this.f11084a = f10;
        Iterator<com.iab.omid.library.vungle.adsession.a> it = a().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(f10);
        }
    }

    public void a(Context context) {
        this.f11087d = this.f11085b.a(new Handler(), context, this.f11086c.a(), this);
    }

    @Override // com.iab.omid.library.vungle.internal.d.a
    public void a(boolean z10) {
        if (z10) {
            TreeWalker.getInstance().h();
        } else {
            TreeWalker.getInstance().g();
        }
    }
}
