package com.iab.omid.library.ironsrc.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.ironsrc.internal.d;
import com.iab.omid.library.ironsrc.walking.TreeWalker;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class h implements d.a, com.iab.omid.library.ironsrc.devicevolume.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static h f10828f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f10829a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.ironsrc.devicevolume.e f10830b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.iab.omid.library.ironsrc.devicevolume.b f10831c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.ironsrc.devicevolume.d f10832d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f10833e;

    public h(com.iab.omid.library.ironsrc.devicevolume.e eVar, com.iab.omid.library.ironsrc.devicevolume.b bVar) {
        this.f10830b = eVar;
        this.f10831c = bVar;
    }

    private c a() {
        if (this.f10833e == null) {
            this.f10833e = c.c();
        }
        return this.f10833e;
    }

    public static h c() {
        if (f10828f == null) {
            f10828f = new h(new com.iab.omid.library.ironsrc.devicevolume.e(), new com.iab.omid.library.ironsrc.devicevolume.b());
        }
        return f10828f;
    }

    public float b() {
        return this.f10829a;
    }

    public void d() {
        b.g().a(this);
        b.g().e();
        TreeWalker.getInstance().h();
        this.f10832d.c();
    }

    public void e() {
        TreeWalker.getInstance().j();
        b.g().f();
        this.f10832d.d();
    }

    @Override // com.iab.omid.library.ironsrc.devicevolume.c
    public void a(float f10) {
        this.f10829a = f10;
        Iterator<com.iab.omid.library.ironsrc.adsession.a> it = a().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(f10);
        }
    }

    public void a(Context context) {
        this.f10832d = this.f10830b.a(new Handler(), context, this.f10831c.a(), this);
    }

    @Override // com.iab.omid.library.ironsrc.internal.d.a
    public void a(boolean z10) {
        if (z10) {
            TreeWalker.getInstance().h();
        } else {
            TreeWalker.getInstance().g();
        }
    }
}
