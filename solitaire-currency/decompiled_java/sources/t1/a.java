package t1;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.ads.mediation.vungle.VungleMediationAdapter;
import com.google.ads.mediation.vungle.b;
import com.google.ads.mediation.vungle.c;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.vungle.ads.b2;
import com.vungle.ads.n0;
import com.vungle.ads.p0;
import com.vungle.ads.u;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VungleAppOpenAd.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements MediationAppOpenAd, p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final MediationAppOpenAdConfiguration f34024a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> f34025b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final b f34026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private n0 f34027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private MediationAppOpenAdCallback f34028e;

    /* JADX INFO: renamed from: t1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VungleAppOpenAd.kt */
    public static final class C0691a implements c.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f34030b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f34031c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f34032d;

        C0691a(Bundle bundle, Context context, String str) {
            this.f34030b = bundle;
            this.f34031c = context;
            this.f34032d = str;
        }

        @Override // com.google.ads.mediation.vungle.c.a
        public void a(@NotNull AdError error) {
            t.i(error, "error");
            Log.w(VungleMediationAdapter.TAG, error.toString());
            a.this.f34025b.onFailure(error);
        }

        @Override // com.google.ads.mediation.vungle.c.a
        public void onInitializeSuccess() {
            com.vungle.ads.c cVarA = a.this.f34026c.a();
            if (this.f34030b.containsKey("adOrientation")) {
                cVarA.setAdOrientation(this.f34030b.getInt("adOrientation", 2));
            }
            a aVar = a.this;
            aVar.g(cVarA, aVar.f34024a);
            a aVar2 = a.this;
            b bVar = aVar2.f34026c;
            Context context = this.f34031c;
            String str = this.f34032d;
            t.f(str);
            aVar2.f34027d = bVar.c(context, str, cVarA);
            n0 n0Var = a.this.f34027d;
            n0 n0Var2 = null;
            if (n0Var == null) {
                t.A("appOpenAd");
                n0Var = null;
            }
            n0Var.setAdListener(a.this);
            n0 n0Var3 = a.this.f34027d;
            if (n0Var3 == null) {
                t.A("appOpenAd");
            } else {
                n0Var2 = n0Var3;
            }
            a aVar3 = a.this;
            n0Var2.load(aVar3.f(aVar3.f34024a));
        }
    }

    public a(@NotNull MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration, @NotNull MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> mediationAdLoadCallback, @NotNull b vungleFactory) {
        t.i(mediationAppOpenAdConfiguration, "mediationAppOpenAdConfiguration");
        t.i(mediationAdLoadCallback, "mediationAdLoadCallback");
        t.i(vungleFactory, "vungleFactory");
        this.f34024a = mediationAppOpenAdConfiguration;
        this.f34025b = mediationAdLoadCallback;
        this.f34026c = vungleFactory;
    }

    @Nullable
    public abstract String f(@NotNull MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration);

    public abstract void g(@NotNull com.vungle.ads.c cVar, @NotNull MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration);

    public final void h() {
        Bundle mediationExtras = this.f34024a.getMediationExtras();
        t.h(mediationExtras, "mediationAppOpenAdConfiguration.mediationExtras");
        Bundle serverParameters = this.f34024a.getServerParameters();
        t.h(serverParameters, "mediationAppOpenAdConfiguration.serverParameters");
        String string = serverParameters.getString("appid");
        if (string == null || string.length() == 0) {
            AdError adError = new AdError(101, "Failed to load app open ad from Liftoff Monetize. Missing or invalid App ID configured for this ad source instance in the AdMob or Ad Manager UI.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            this.f34025b.onFailure(adError);
            return;
        }
        String string2 = serverParameters.getString("placementID");
        if (string2 == null || string2.length() == 0) {
            AdError adError2 = new AdError(101, "Failed to load app open ad from Liftoff Monetize. Missing or Invalid Placement ID configured for this ad source instance in the AdMob or Ad Manager UI.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError2.toString());
            this.f34025b.onFailure(adError2);
        } else {
            Context context = this.f34024a.getContext();
            t.h(context, "mediationAppOpenAdConfiguration.context");
            c cVarA = c.a();
            t.f(string);
            cVarA.b(string, context, new C0691a(mediationExtras, context, string2));
        }
    }

    @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdClicked(@NotNull u baseAd) {
        t.i(baseAd, "baseAd");
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.f34028e;
        if (mediationAppOpenAdCallback == null || mediationAppOpenAdCallback == null) {
            return;
        }
        mediationAppOpenAdCallback.reportAdClicked();
    }

    @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdEnd(@NotNull u baseAd) {
        t.i(baseAd, "baseAd");
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.f34028e;
        if (mediationAppOpenAdCallback == null || mediationAppOpenAdCallback == null) {
            return;
        }
        mediationAppOpenAdCallback.onAdClosed();
    }

    @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdFailedToLoad(@NotNull u baseAd, @NotNull b2 adError) {
        t.i(baseAd, "baseAd");
        t.i(adError, "adError");
        AdError adError2 = VungleMediationAdapter.getAdError(adError);
        t.h(adError2, "getAdError(adError)");
        Log.w(VungleMediationAdapter.TAG, adError2.toString());
        this.f34025b.onFailure(adError2);
    }

    @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdFailedToPlay(@NotNull u baseAd, @NotNull b2 adError) {
        t.i(baseAd, "baseAd");
        t.i(adError, "adError");
        AdError adError2 = VungleMediationAdapter.getAdError(adError);
        t.h(adError2, "getAdError(adError)");
        Log.w(VungleMediationAdapter.TAG, adError2.toString());
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.f34028e;
        if (mediationAppOpenAdCallback == null || mediationAppOpenAdCallback == null) {
            return;
        }
        mediationAppOpenAdCallback.onAdFailedToShow(adError2);
    }

    @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdImpression(@NotNull u baseAd) {
        t.i(baseAd, "baseAd");
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.f34028e;
        if (mediationAppOpenAdCallback == null || mediationAppOpenAdCallback == null) {
            return;
        }
        mediationAppOpenAdCallback.reportAdImpression();
    }

    @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdLeftApplication(@NotNull u baseAd) {
        t.i(baseAd, "baseAd");
    }

    @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdLoaded(@NotNull u baseAd) {
        t.i(baseAd, "baseAd");
        this.f34028e = this.f34025b.onSuccess(this);
    }

    @Override // com.vungle.ads.p0, com.vungle.ads.k0, com.vungle.ads.v
    public void onAdStart(@NotNull u baseAd) {
        t.i(baseAd, "baseAd");
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.f34028e;
        if (mediationAppOpenAdCallback == null || mediationAppOpenAdCallback == null) {
            return;
        }
        mediationAppOpenAdCallback.onAdOpened();
    }

    @Override // com.google.android.gms.ads.mediation.MediationAppOpenAd
    public void showAd(@NotNull Context context) {
        t.i(context, "context");
        n0 n0Var = this.f34027d;
        n0 n0Var2 = null;
        if (n0Var == null) {
            t.A("appOpenAd");
            n0Var = null;
        }
        if (n0Var.canPlayAd().booleanValue()) {
            n0 n0Var3 = this.f34027d;
            if (n0Var3 == null) {
                t.A("appOpenAd");
            } else {
                n0Var2 = n0Var3;
            }
            n0Var2.play(context);
            return;
        }
        AdError adError = new AdError(107, "Failed to show app open ad from Liftoff Monetize.", VungleMediationAdapter.ERROR_DOMAIN);
        Log.w(VungleMediationAdapter.TAG, adError.toString());
        MediationAppOpenAdCallback mediationAppOpenAdCallback = this.f34028e;
        if (mediationAppOpenAdCallback != null) {
            mediationAppOpenAdCallback.onAdFailedToShow(adError);
        }
    }
}
