package l7;

import android.content.Context;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/* JADX INFO: compiled from: ScarBannerAd.java */
/* JADX INFO: loaded from: classes4.dex */
public class c extends a<AdView> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RelativeLayout f30913g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f30914h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f30915i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AdView f30916j;

    public c(Context context, RelativeLayout relativeLayout, k7.a aVar, a7.c cVar, int i10, int i11, com.unity3d.scar.adapter.common.d dVar, com.unity3d.scar.adapter.common.g gVar) {
        super(context, cVar, aVar, dVar);
        this.f30913g = relativeLayout;
        this.f30914h = i10;
        this.f30915i = i11;
        this.f30916j = new AdView(this.f30907b);
        this.f30910e = new d(gVar, this);
    }

    @Override // l7.a
    protected void c(AdRequest adRequest, a7.b bVar) {
        AdView adView;
        RelativeLayout relativeLayout = this.f30913g;
        if (relativeLayout == null || (adView = this.f30916j) == null) {
            return;
        }
        relativeLayout.addView(adView);
        this.f30916j.setAdSize(new AdSize(this.f30914h, this.f30915i));
        this.f30916j.setAdUnitId(this.f30908c.b());
        this.f30916j.setAdListener(((d) this.f30910e).d());
        this.f30916j.loadAd(adRequest);
    }

    public void e() {
        AdView adView;
        RelativeLayout relativeLayout = this.f30913g;
        if (relativeLayout == null || (adView = this.f30916j) == null) {
            return;
        }
        relativeLayout.removeView(adView);
    }
}
