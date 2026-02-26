package d7;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.query.QueryInfo;

/* JADX INFO: compiled from: ScarInterstitialAd.java */
/* JADX INFO: loaded from: classes4.dex */
public class e extends a<InterstitialAd> implements a7.a {
    public e(Context context, QueryInfo queryInfo, a7.c cVar, com.unity3d.scar.adapter.common.d dVar, com.unity3d.scar.adapter.common.h hVar) {
        super(context, cVar, queryInfo, dVar);
        this.f24505e = new f(hVar, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a7.a
    public void a(Activity activity) {
        T t10 = this.f24501a;
        if (t10 != 0) {
            ((InterstitialAd) t10).show(activity);
        } else {
            this.f24506f.handleError(com.unity3d.scar.adapter.common.b.a(this.f24503c));
        }
    }

    @Override // d7.a
    protected void c(AdRequest adRequest, a7.b bVar) {
        InterstitialAd.load(this.f24502b, this.f24503c.b(), adRequest, ((f) this.f24505e).e());
    }
}
