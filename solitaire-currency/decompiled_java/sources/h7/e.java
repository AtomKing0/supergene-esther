package h7;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.interstitial.InterstitialAd;

/* JADX INFO: compiled from: ScarInterstitialAd.java */
/* JADX INFO: loaded from: classes4.dex */
public class e extends a<InterstitialAd> implements a7.a {
    public e(Context context, g7.a aVar, a7.c cVar, com.unity3d.scar.adapter.common.d dVar, com.unity3d.scar.adapter.common.h hVar) {
        super(context, cVar, aVar, dVar);
        this.f26474e = new f(hVar, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a7.a
    public void a(Activity activity) {
        T t10 = this.f26470a;
        if (t10 != 0) {
            ((InterstitialAd) t10).show(activity);
        } else {
            this.f26475f.handleError(com.unity3d.scar.adapter.common.b.a(this.f26472c));
        }
    }

    @Override // h7.a
    protected void c(AdRequest adRequest, a7.b bVar) {
        InterstitialAd.load(this.f26471b, this.f26472c.b(), adRequest, ((f) this.f26474e).e());
    }
}
