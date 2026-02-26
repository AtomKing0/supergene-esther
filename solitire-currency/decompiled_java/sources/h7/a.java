package h7;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;

/* JADX INFO: compiled from: ScarAdBase.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected T f26470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Context f26471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected a7.c f26472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected g7.a f26473d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected b f26474e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.unity3d.scar.adapter.common.d f26475f;

    public a(Context context, a7.c cVar, g7.a aVar, com.unity3d.scar.adapter.common.d dVar) {
        this.f26471b = context;
        this.f26472c = cVar;
        this.f26473d = aVar;
        this.f26475f = dVar;
    }

    public void b(a7.b bVar) {
        AdRequest adRequestB = this.f26473d.b(this.f26472c.a());
        if (bVar != null) {
            this.f26474e.a(bVar);
        }
        c(adRequestB, bVar);
    }

    protected abstract void c(AdRequest adRequest, a7.b bVar);

    public void d(T t10) {
        this.f26470a = t10;
    }
}
