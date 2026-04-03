package com.iab.omid.library.unity3d.internal;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.unity3d.internal.d;
import com.iab.omid.library.unity3d.walking.TreeWalker;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class h implements d.a, com.iab.omid.library.unity3d.devicevolume.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static h f10954f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f10955a = 0.0f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.iab.omid.library.unity3d.devicevolume.e f10956b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.iab.omid.library.unity3d.devicevolume.b f10957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.iab.omid.library.unity3d.devicevolume.d f10958d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f10959e;

    public h(com.iab.omid.library.unity3d.devicevolume.e eVar, com.iab.omid.library.unity3d.devicevolume.b bVar) {
        this.f10956b = eVar;
        this.f10957c = bVar;
    }

    private c a() {
        if (this.f10959e == null) {
            this.f10959e = c.c();
        }
        return this.f10959e;
    }

    public static h c() {
        if (f10954f == null) {
            f10954f = new h(new com.iab.omid.library.unity3d.devicevolume.e(), new com.iab.omid.library.unity3d.devicevolume.b());
        }
        return f10954f;
    }

    public float b() {
        return this.f10955a;
    }

    public void d() {
        b.g().a(this);
        b.g().e();
        TreeWalker.getInstance().h();
        this.f10958d.c();
    }

    public void e() {
        TreeWalker.getInstance().j();
        b.g().f();
        this.f10958d.d();
    }

    @Override // com.iab.omid.library.unity3d.devicevolume.c
    public void a(float f10) {
        this.f10955a = f10;
        Iterator<com.iab.omid.library.unity3d.adsession.a> it = a().a().iterator();
        while (it.hasNext()) {
            it.next().getAdSessionStatePublisher().a(f10);
        }
    }

    public void a(Context context) {
        this.f10958d = this.f10956b.a(new Handler(), context, this.f10957c.a(), this);
    }

    @Override // com.iab.omid.library.unity3d.internal.d.a
    public void a(boolean z10) {
        if (z10) {
            TreeWalker.getInstance().h();
        } else {
            TreeWalker.getInstance().g();
        }
    }
}
