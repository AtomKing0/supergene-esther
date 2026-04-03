package s1;

import com.google.ads.mediation.unity.a;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;

/* JADX INFO: compiled from: UnityBannerEventAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final MediationBannerListener f33468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final MediationBannerAdapter f33469b;

    /* JADX INFO: renamed from: s1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: UnityBannerEventAdapter.java */
    static /* synthetic */ class C0668a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f33470a;

        static {
            int[] iArr = new int[a.b.values().length];
            f33470a = iArr;
            try {
                iArr[a.b.LOADED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33470a[a.b.OPENED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33470a[a.b.CLICKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33470a[a.b.CLOSED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f33470a[a.b.LEFT_APPLICATION.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public a(MediationBannerListener mediationBannerListener, MediationBannerAdapter mediationBannerAdapter) {
        this.f33468a = mediationBannerListener;
        this.f33469b = mediationBannerAdapter;
    }

    public void a(a.b bVar) {
        if (this.f33468a == null) {
            return;
        }
        int i10 = C0668a.f33470a[bVar.ordinal()];
        if (i10 == 1) {
            this.f33468a.onAdLoaded(this.f33469b);
            return;
        }
        if (i10 == 2) {
            this.f33468a.onAdOpened(this.f33469b);
            return;
        }
        if (i10 == 3) {
            this.f33468a.onAdClicked(this.f33469b);
        } else if (i10 == 4) {
            this.f33468a.onAdClosed(this.f33469b);
        } else {
            if (i10 != 5) {
                return;
            }
            this.f33468a.onAdLeftApplication(this.f33469b);
        }
    }
}
