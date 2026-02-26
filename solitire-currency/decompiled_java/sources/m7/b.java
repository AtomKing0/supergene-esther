package m7;

import a7.d;
import android.content.Context;
import b7.e;
import b7.f;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfo;

/* JADX INFO: compiled from: SignalsCollector.java */
/* JADX INFO: loaded from: classes4.dex */
public class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private k7.a f31470a;

    /* JADX INFO: compiled from: SignalsCollector.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f31471a;

        static {
            int[] iArr = new int[d.values().length];
            f31471a = iArr;
            try {
                iArr[d.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31471a[d.REWARDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(k7.a aVar) {
        this.f31470a = aVar;
    }

    @Override // b7.c
    public void c(Context context, String str, d dVar, com.unity3d.scar.adapter.common.a aVar, f fVar) {
        QueryInfo.generate(context, g(dVar), this.f31470a.a(), new m7.a(str, new b7.d(aVar, fVar)));
    }

    @Override // b7.c
    public void d(Context context, d dVar, com.unity3d.scar.adapter.common.a aVar, f fVar) {
        c(context, e(dVar), dVar, aVar, fVar);
    }

    public AdFormat g(d dVar) {
        int i10 = a.f31471a[dVar.ordinal()];
        return i10 != 1 ? i10 != 2 ? AdFormat.INTERSTITIAL : AdFormat.REWARDED : AdFormat.BANNER;
    }
}
