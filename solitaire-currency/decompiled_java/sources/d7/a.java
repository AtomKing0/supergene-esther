package d7;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.query.QueryInfo;

/* JADX INFO: compiled from: ScarAdBase.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected T f24501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Context f24502b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected a7.c f24503c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected QueryInfo f24504d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected b f24505e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected com.unity3d.scar.adapter.common.d f24506f;

    public a(Context context, a7.c cVar, QueryInfo queryInfo, com.unity3d.scar.adapter.common.d dVar) {
        this.f24502b = context;
        this.f24503c = cVar;
        this.f24504d = queryInfo;
        this.f24506f = dVar;
    }

    public void b(a7.b bVar) {
        if (this.f24504d == null) {
            this.f24506f.handleError(com.unity3d.scar.adapter.common.b.g(this.f24503c));
            return;
        }
        AdRequest adRequestBuild = new AdRequest.Builder().setAdInfo(new AdInfo(this.f24504d, this.f24503c.a())).build();
        if (bVar != null) {
            this.f24505e.a(bVar);
        }
        c(adRequestBuild, bVar);
    }

    protected abstract void c(AdRequest adRequest, a7.b bVar);

    public void d(T t10) {
        this.f24501a = t10;
    }
}
