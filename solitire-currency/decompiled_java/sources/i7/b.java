package i7;

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
    private g7.a f26630a;

    /* JADX INFO: compiled from: SignalsCollector.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26631a;

        static {
            int[] iArr = new int[d.values().length];
            f26631a = iArr;
            try {
                iArr[d.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26631a[d.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26631a[d.REWARDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public b(g7.a aVar) {
        this.f26630a = aVar;
    }

    @Override // b7.c
    public void c(Context context, String str, d dVar, com.unity3d.scar.adapter.common.a aVar, f fVar) {
        QueryInfo.generate(context, g(dVar), this.f26630a.a(), new i7.a(str, new b7.d(aVar, fVar)));
    }

    @Override // b7.c
    public void d(Context context, d dVar, com.unity3d.scar.adapter.common.a aVar, f fVar) {
        c(context, e(dVar), dVar, aVar, fVar);
    }

    public AdFormat g(d dVar) {
        int i10 = a.f26631a[dVar.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? AdFormat.UNKNOWN : AdFormat.REWARDED : AdFormat.INTERSTITIAL : AdFormat.BANNER;
    }
}
