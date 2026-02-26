package l7;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.unity3d.scar.adapter.common.i;

/* JADX INFO: compiled from: ScarRewardedAd.java */
/* JADX INFO: loaded from: classes4.dex */
public class g extends a<RewardedAd> implements a7.a {
    public g(Context context, k7.a aVar, a7.c cVar, com.unity3d.scar.adapter.common.d dVar, i iVar) {
        super(context, cVar, aVar, dVar);
        this.f30910e = new h(iVar, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a7.a
    public void a(Activity activity) {
        T t10 = this.f30906a;
        if (t10 != 0) {
            ((RewardedAd) t10).show(activity, ((h) this.f30910e).f());
        } else {
            this.f30911f.handleError(com.unity3d.scar.adapter.common.b.a(this.f30908c));
        }
    }

    @Override // l7.a
    protected void c(AdRequest adRequest, a7.b bVar) {
        RewardedAd.load(this.f30907b, this.f30908c.b(), adRequest, ((h) this.f30910e).e());
    }
}
