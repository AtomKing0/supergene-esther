package e7;

import a7.d;
import android.content.Context;
import b7.e;
import b7.f;
import b7.g;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.query.QueryInfo;

/* JADX INFO: compiled from: SignalsCollector.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private g<QueryInfo> f25182a;

    /* JADX INFO: compiled from: SignalsCollector.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f25183a;

        static {
            int[] iArr = new int[d.values().length];
            f25183a = iArr;
            try {
                iArr[d.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25183a[d.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25183a[d.REWARDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public b(g<QueryInfo> gVar) {
        this.f25182a = gVar;
    }

    @Override // b7.c
    public void c(Context context, String str, d dVar, com.unity3d.scar.adapter.common.a aVar, f fVar) {
        QueryInfo.generate(context, g(dVar), new AdRequest.Builder().build(), new e7.a(str, new b7.d(aVar, this.f25182a, fVar)));
    }

    @Override // b7.c
    public void d(Context context, d dVar, com.unity3d.scar.adapter.common.a aVar, f fVar) {
        f("GMA v2000 - SCAR signal retrieval without a placementId not relevant", aVar, fVar);
    }

    public AdFormat g(d dVar) {
        int i10 = a.f25183a[dVar.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? AdFormat.BANNER : AdFormat.REWARDED : AdFormat.INTERSTITIAL : AdFormat.BANNER;
    }
}
