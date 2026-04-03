package h7;

import android.content.Context;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

/* JADX INFO: compiled from: ScarBannerAd.java */
/* JADX INFO: loaded from: classes4.dex */
public class c extends a<AdView> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RelativeLayout f26477g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f26478h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f26479i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private AdView f26480j;

    public c(Context context, RelativeLayout relativeLayout, g7.a aVar, a7.c cVar, int i10, int i11, com.unity3d.scar.adapter.common.d dVar, com.unity3d.scar.adapter.common.g gVar) {
        super(context, cVar, aVar, dVar);
        this.f26477g = relativeLayout;
        this.f26478h = i10;
        this.f26479i = i11;
        this.f26480j = new AdView(this.f26471b);
        this.f26474e = new d(gVar, this);
    }

    @Override // h7.a
    protected void c(AdRequest adRequest, a7.b bVar) {
        AdView adView;
        RelativeLayout relativeLayout = this.f26477g;
        if (relativeLayout == null || (adView = this.f26480j) == null) {
            return;
        }
        relativeLayout.addView(adView);
        this.f26480j.setAdSize(new AdSize(this.f26478h, this.f26479i));
        this.f26480j.setAdUnitId(this.f26472c.b());
        this.f26480j.setAdListener(((d) this.f26474e).d());
        this.f26480j.loadAd(adRequest);
    }

    public void e() {
        AdView adView;
        RelativeLayout relativeLayout = this.f26477g;
        if (relativeLayout == null || (adView = this.f26480j) == null) {
            return;
        }
        relativeLayout.removeView(adView);
    }
}
