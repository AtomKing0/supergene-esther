package com.iab.omid.library.activision.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.activision.internal.d;
import com.iab.omid.library.activision.walking.TreeWalker;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class i implements d.a, com.iab.omid.library.activision.devicevolume.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static i f10560f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f10561a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.activision.devicevolume.e f10562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.iab.omid.library.activision.devicevolume.b f10563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.activision.devicevolume.d f10564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f10565e;

    public i(com.iab.omid.library.activision.devicevolume.e eVar, com.iab.omid.library.activision.devicevolume.b bVar) {
        this.f10562b = eVar;
        this.f10563c = bVar;
    }

    private c a() {
        if (this.f10565e == null) {
            this.f10565e = c.c();
        }
        return this.f10565e;
    }

    public static i c() {
        if (f10560f == null) {
            f10560f = new i(new com.iab.omid.library.activision.devicevolume.e(), new com.iab.omid.library.activision.devicevolume.b());
        }
        return f10560f;
    }

    public float b() {
        return this.f10561a;
    }

    public void d() {
        b.g().a(this);
        b.g().e();
        TreeWalker.getInstance().h();
        this.f10564d.c();
    }

    public void e() {
        TreeWalker.getInstance().j();
        b.g().f();
        this.f10564d.d();
    }

    @Override // com.iab.omid.library.activision.devicevolume.c
    public void a(float f10) {
        this.f10561a = f10;
        Iterator<com.iab.omid.library.activision.adsession.a> it = a().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(f10);
        }
    }

    public void a(Context context) {
        this.f10564d = this.f10562b.a(new Handler(), context, this.f10563c.a(), this);
    }

    @Override // com.iab.omid.library.activision.internal.d.a
    public void a(boolean z10) {
        if (z10) {
            TreeWalker.getInstance().h();
        } else {
            TreeWalker.getInstance().g();
        }
    }
}
