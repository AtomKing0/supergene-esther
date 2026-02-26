package g7;

import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdRequest;

/* JADX INFO: compiled from: AdRequestFactory.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private z6.a f25885a;

    public a(z6.a aVar) {
        this.f25885a = aVar;
    }

    public AdRequest a() {
        return c().build();
    }

    public AdRequest b(String str) {
        return c().setAdString(str).build();
    }

    public AdRequest.Builder c() {
        return new AdRequest.Builder().setRequestAgent(this.f25885a.b()).addNetworkExtrasBundle(AdMobAdapter.class, this.f25885a.a());
    }
}
