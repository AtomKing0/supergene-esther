package s1;

import com.google.ads.mediation.unity.a;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

/* JADX INFO: compiled from: UnityInterstitialEventAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final MediationInterstitialListener f33471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final MediationInterstitialAdapter f33472b;

    /* JADX INFO: compiled from: UnityInterstitialEventAdapter.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f33473a;

        static {
            int[] iArr = new int[a.b.values().length];
            f33473a = iArr;
            try {
                iArr[a.b.LOADED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33473a[a.b.OPENED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33473a[a.b.CLICKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33473a[a.b.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33473a[a.b.LEFT_APPLICATION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public b(MediationInterstitialListener mediationInterstitialListener, MediationInterstitialAdapter mediationInterstitialAdapter) {
        this.f33471a = mediationInterstitialListener;
        this.f33472b = mediationInterstitialAdapter;
    }

    public void a(a.b bVar) {
        if (this.f33471a == null) {
            return;
        }
        int i10 = a.f33473a[bVar.ordinal()];
        if (i10 == 1) {
            this.f33471a.onAdLoaded(this.f33472b);
            return;
        }
        if (i10 == 2) {
            this.f33471a.onAdOpened(this.f33472b);
            return;
        }
        if (i10 == 3) {
            this.f33471a.onAdClicked(this.f33472b);
        } else if (i10 == 4) {
            this.f33471a.onAdClosed(this.f33472b);
        } else {
            if (i10 != 5) {
                return;
            }
            this.f33471a.onAdLeftApplication(this.f33472b);
        }
    }
}
