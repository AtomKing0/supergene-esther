package b7;

import android.content.Context;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SignalsCollectorBase.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class e implements c {

    /* JADX INFO: compiled from: SignalsCollectorBase.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2226a;

        static {
            int[] iArr = new int[a7.d.values().length];
            f2226a = iArr;
            try {
                iArr[a7.d.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2226a[a7.d.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2226a[a7.d.REWARDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: SignalsCollectorBase.java */
    private class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private b7.b f2227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private f f2228b;

        public b(b7.b bVar, f fVar) {
            this.f2227a = bVar;
            this.f2228b = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map<String, String> mapC = this.f2228b.c();
            if (mapC.size() > 0) {
                this.f2227a.onSignalsCollected(new JSONObject(mapC).toString());
            } else if (this.f2228b.b() == null) {
                this.f2227a.onSignalsCollected("");
            } else {
                this.f2227a.onSignalsCollectionFailed(this.f2228b.b());
            }
        }
    }

    @Override // b7.c
    public void a(Context context, boolean z10, b7.b bVar) {
        com.unity3d.scar.adapter.common.a aVar = new com.unity3d.scar.adapter.common.a();
        f fVar = new f();
        aVar.a();
        d(context, a7.d.INTERSTITIAL, aVar, fVar);
        aVar.a();
        d(context, a7.d.REWARDED, aVar, fVar);
        if (z10) {
            aVar.a();
            d(context, a7.d.BANNER, aVar, fVar);
        }
        aVar.c(new b(bVar, fVar));
    }

    @Override // b7.c
    public void b(Context context, String str, a7.d dVar, b7.b bVar) {
        com.unity3d.scar.adapter.common.a aVar = new com.unity3d.scar.adapter.common.a();
        f fVar = new f();
        aVar.a();
        c(context, str, dVar, aVar, fVar);
        aVar.c(new b(bVar, fVar));
    }

    public String e(a7.d dVar) {
        int i10 = a.f2226a[dVar.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? "" : "gmaScarBiddingRewardedSignal" : "gmaScarBiddingInterstitialSignal" : "gmaScarBiddingBannerSignal";
    }

    public void f(String str, com.unity3d.scar.adapter.common.a aVar, f fVar) {
        fVar.d(String.format("Operation Not supported: %s.", str));
        aVar.b();
    }
}
