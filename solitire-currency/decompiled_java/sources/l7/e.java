package l7;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.interstitial.InterstitialAd;

/* JADX INFO: compiled from: ScarInterstitialAd.java */
/* JADX INFO: loaded from: classes4.dex */
public class e extends a<InterstitialAd> implements a7.a {
    public e(Context context, k7.a aVar, a7.c cVar, com.unity3d.scar.adapter.common.d dVar, com.unity3d.scar.adapter.common.h hVar) {
        super(context, cVar, aVar, dVar);
        this.f30910e = new f(hVar, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a7.a
    public void a(Activity activity) {
        T t10 = this.f30906a;
        if (t10 != 0) {
            ((InterstitialAd) t10).show(activity);
        } else {
            this.f30911f.handleError(com.unity3d.scar.adapter.common.b.a(this.f30908c));
        }
    }

    @Override // l7.a
    protected void c(AdRequest adRequest, a7.b bVar) {
        InterstitialAd.load(this.f30907b, this.f30908c.b(), adRequest, ((f) this.f30910e).e());
    }
}
