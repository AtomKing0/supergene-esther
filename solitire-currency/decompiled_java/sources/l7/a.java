package l7;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;

/* JADX INFO: compiled from: ScarAdBase.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected T f30906a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Context f30907b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected a7.c f30908c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected k7.a f30909d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected b f30910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.unity3d.scar.adapter.common.d f30911f;

    public a(Context context, a7.c cVar, k7.a aVar, com.unity3d.scar.adapter.common.d dVar) {
        this.f30907b = context;
        this.f30908c = cVar;
        this.f30909d = aVar;
        this.f30911f = dVar;
    }

    public void b(a7.b bVar) {
        AdRequest adRequestB = this.f30909d.b(this.f30908c.a());
        if (bVar != null) {
            this.f30910e.a(bVar);
        }
        c(adRequestB, bVar);
    }

    protected abstract void c(AdRequest adRequest, a7.b bVar);

    public void d(T t10) {
        this.f30906a = t10;
    }
}
