package com.unity3d.scar.adapter.common;

import android.app.Activity;
import android.content.Context;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: ScarAdapterBase.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class k implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected b7.c f24259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Map<String, a7.a> f24260b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected a7.a f24261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected d<m> f24262d;

    /* JADX INFO: compiled from: ScarAdapterBase.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f24263a;

        a(Activity activity) {
            this.f24263a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.f24261c.a(this.f24263a);
        }
    }

    public k(d<m> dVar) {
        this.f24262d = dVar;
    }

    @Override // com.unity3d.scar.adapter.common.f
    public void a(Context context, boolean z10, b7.b bVar) {
        this.f24259a.a(context, z10, bVar);
    }

    @Override // com.unity3d.scar.adapter.common.f
    public void b(Context context, String str, a7.d dVar, b7.b bVar) {
        this.f24259a.b(context, str, dVar, bVar);
    }

    @Override // com.unity3d.scar.adapter.common.f
    public void d(Activity activity, String str, String str2) {
        a7.a aVar = this.f24260b.get(str2);
        if (aVar != null) {
            this.f24261c = aVar;
            l.a(new a(activity));
            return;
        }
        this.f24262d.handleError(b.f(str2, str, "Could not find ad for placement '" + str2 + "'."));
    }
}
