package d7;

import android.content.Context;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.query.QueryInfo;

/* JADX INFO: compiled from: ScarBannerAd.java */
/* JADX INFO: loaded from: classes4.dex */
public class c extends a<AdView> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RelativeLayout f24508g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f24509h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f24510i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AdView f24511j;

    public c(Context context, QueryInfo queryInfo, RelativeLayout relativeLayout, a7.c cVar, int i10, int i11, com.unity3d.scar.adapter.common.d dVar, com.unity3d.scar.adapter.common.g gVar) {
        super(context, cVar, queryInfo, dVar);
        this.f24508g = relativeLayout;
        this.f24509h = i10;
        this.f24510i = i11;
        this.f24511j = new AdView(this.f24502b);
        this.f24505e = new d(gVar, this);
    }

    @Override // d7.a
    protected void c(AdRequest adRequest, a7.b bVar) {
        AdView adView;
        RelativeLayout relativeLayout = this.f24508g;
        if (relativeLayout == null || (adView = this.f24511j) == null) {
            return;
        }
        relativeLayout.addView(adView);
        this.f24511j.setAdSize(new AdSize(this.f24509h, this.f24510i));
        this.f24511j.setAdUnitId(this.f24503c.b());
        this.f24511j.setAdListener(((d) this.f24505e).d());
        this.f24511j.loadAd(adRequest);
    }

    public void e() {
        AdView adView;
        RelativeLayout relativeLayout = this.f24508g;
        if (relativeLayout == null || (adView = this.f24511j) == null) {
            return;
        }
        relativeLayout.removeView(adView);
    }
}
