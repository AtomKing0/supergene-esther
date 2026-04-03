package u1;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.google.ads.mediation.vungle.VungleMediationAdapter;
import com.google.ads.mediation.vungle.c;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.vungle.ads.b2;
import com.vungle.ads.g1;
import com.vungle.ads.u;
import com.vungle.ads.x0;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: VungleRtbNativeAd.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends UnifiedNativeAdMapper implements g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediationNativeAdConfiguration f34471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> f34472b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MediationNativeAdCallback f34473c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private x0 f34474d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.vungle.ads.internal.ui.view.c f34475e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f34476f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.google.ads.mediation.vungle.b f34477g;

    /* JADX INFO: compiled from: VungleRtbNativeAd.java */
    class a implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f34478a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f34479b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f34480c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f34481d;

        a(Context context, String str, int i10, String str2) {
            this.f34478a = context;
            this.f34479b = str;
            this.f34480c = i10;
            this.f34481d = str2;
        }

        @Override // com.google.ads.mediation.vungle.c.a
        public void a(AdError adError) {
            Log.d(VungleMediationAdapter.TAG, adError.toString());
            d.this.f34472b.onFailure(adError);
        }

        @Override // com.google.ads.mediation.vungle.c.a
        public void onInitializeSuccess() {
            d dVar = d.this;
            dVar.f34474d = dVar.f34477g.d(this.f34478a, this.f34479b);
            d.this.f34474d.setAdOptionsPosition(this.f34480c);
            d.this.f34474d.setAdListener(d.this);
            d.this.f34475e = new com.vungle.ads.internal.ui.view.c(this.f34478a);
            if (!TextUtils.isEmpty(this.f34481d)) {
                d.this.f34474d.getAdConfig().setWatermark(this.f34481d);
            }
            d.this.f34474d.load(d.this.f34476f);
        }
    }

    /* JADX INFO: compiled from: VungleRtbNativeAd.java */
    private static class b extends NativeAd.Image {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Uri f34483a;

        public b(Uri uri) {
            this.f34483a = uri;
        }

        @Override // com.google.android.gms.ads.formats.NativeAd.Image
        public Drawable getDrawable() {
            return null;
        }

        @Override // com.google.android.gms.ads.formats.NativeAd.Image
        public double getScale() {
            return 1.0d;
        }

        @Override // com.google.android.gms.ads.formats.NativeAd.Image
        public Uri getUri() {
            return this.f34483a;
        }
    }

    public d(@NonNull MediationNativeAdConfiguration mediationNativeAdConfiguration, @NonNull MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback, com.google.ads.mediation.vungle.b bVar) {
        this.f34471a = mediationNativeAdConfiguration;
        this.f34472b = mediationAdLoadCallback;
        this.f34477g = bVar;
    }

    private void g() {
        setHeadline(this.f34474d.getAdTitle());
        setBody(this.f34474d.getAdBodyText());
        setCallToAction(this.f34474d.getAdCallToActionText());
        Double adStarRating = this.f34474d.getAdStarRating();
        if (adStarRating != null) {
            setStarRating(adStarRating);
        }
        setAdvertiser(this.f34474d.getAdSponsoredText());
        setMediaView(this.f34475e);
        String appIcon = this.f34474d.getAppIcon();
        if (!TextUtils.isEmpty(appIcon) && appIcon.startsWith(com.vungle.ads.internal.model.b.FILE_SCHEME)) {
            setIcon(new b(Uri.parse(appIcon)));
        }
        if (TextUtils.isEmpty(this.f34476f)) {
            setOverrideImpressionRecording(true);
        }
        setOverrideClickHandling(true);
    }

    public void h() {
        int i10;
        int i11;
        Bundle serverParameters = this.f34471a.getServerParameters();
        NativeAdOptions nativeAdOptions = this.f34471a.getNativeAdOptions();
        Context context = this.f34471a.getContext();
        String string = serverParameters.getString("appid");
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(101, "Failed to load bidding native ad from Liftoff Monetize. Missing or invalid app ID configured for this ad source instance in the AdMob or Ad Manager UI.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.d(VungleMediationAdapter.TAG, adError.toString());
            this.f34472b.onFailure(adError);
            return;
        }
        String string2 = serverParameters.getString("placementID");
        if (TextUtils.isEmpty(string2)) {
            AdError adError2 = new AdError(101, "Failed to load bidding native ad from Liftoff Monetize. Missing or Invalid placement ID configured for this ad source instance in the AdMob or Ad Manager UI.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.d(VungleMediationAdapter.TAG, adError2.toString());
            this.f34472b.onFailure(adError2);
            return;
        }
        this.f34476f = this.f34471a.getBidResponse();
        int adChoicesPlacement = nativeAdOptions.getAdChoicesPlacement();
        if (adChoicesPlacement != 0) {
            if (adChoicesPlacement == 2) {
                i11 = 3;
            } else if (adChoicesPlacement != 3) {
                i10 = 1;
            } else {
                i11 = 2;
            }
            com.google.ads.mediation.vungle.c.a().b(string, context, new a(context, string2, i11, this.f34471a.getWatermark()));
        }
        i10 = 0;
        i11 = i10;
        com.google.ads.mediation.vungle.c.a().b(string, context, new a(context, string2, i11, this.f34471a.getWatermark()));
    }

    @Override // com.vungle.ads.g1, com.vungle.ads.v
    public void onAdClicked(@NonNull u uVar) {
        MediationNativeAdCallback mediationNativeAdCallback = this.f34473c;
        if (mediationNativeAdCallback != null) {
            mediationNativeAdCallback.reportAdClicked();
            this.f34473c.onAdOpened();
        }
    }

    @Override // com.vungle.ads.g1, com.vungle.ads.v
    public void onAdFailedToLoad(@NonNull u uVar, @NonNull b2 b2Var) {
        this.f34472b.onFailure(VungleMediationAdapter.getAdError(b2Var));
    }

    @Override // com.vungle.ads.g1, com.vungle.ads.v
    public void onAdFailedToPlay(@NonNull u uVar, @NonNull b2 b2Var) {
        Log.w(VungleMediationAdapter.TAG, VungleMediationAdapter.getAdError(b2Var).toString());
    }

    @Override // com.vungle.ads.g1, com.vungle.ads.v
    public void onAdImpression(@NonNull u uVar) {
        MediationNativeAdCallback mediationNativeAdCallback = this.f34473c;
        if (mediationNativeAdCallback != null) {
            mediationNativeAdCallback.reportAdImpression();
        }
    }

    @Override // com.vungle.ads.g1, com.vungle.ads.v
    public void onAdLeftApplication(@NonNull u uVar) {
        MediationNativeAdCallback mediationNativeAdCallback = this.f34473c;
        if (mediationNativeAdCallback != null) {
            mediationNativeAdCallback.onAdLeftApplication();
        }
    }

    @Override // com.vungle.ads.g1, com.vungle.ads.v
    public void onAdLoaded(@NonNull u uVar) {
        g();
        this.f34473c = this.f34472b.onSuccess(this);
    }

    @Override // com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
    public void trackViews(@NonNull View view, @NonNull Map<String, View> map, @NonNull Map<String, View> map2) {
        super.trackViews(view, map, map2);
        String str = VungleMediationAdapter.TAG;
        Log.d(str, "trackViews()");
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            x0 x0Var = this.f34474d;
            if (x0Var == null || !x0Var.canPlayAd().booleanValue()) {
                return;
            }
            View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            if (!(childAt instanceof FrameLayout)) {
                Log.d(str, "Vungle requires a FrameLayout to render the native ad.");
                return;
            }
            ArrayList arrayList = new ArrayList();
            ImageView imageView = null;
            View value = null;
            for (Map.Entry<String, View> entry : map.entrySet()) {
                arrayList.add(entry.getValue());
                if (entry.getKey().equals("3003")) {
                    value = entry.getValue();
                }
            }
            if (value instanceof ImageView) {
                imageView = (ImageView) value;
            } else {
                Log.d(VungleMediationAdapter.TAG, "The view to display a Vungle native icon image is not a type of ImageView, so it can't be registered for click events.");
            }
            this.f34474d.registerViewForInteraction((FrameLayout) childAt, this.f34475e, imageView, arrayList);
        }
    }

    @Override // com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
    public void untrackView(@NonNull View view) {
        super.untrackView(view);
        Log.d(VungleMediationAdapter.TAG, "untrackView()");
        x0 x0Var = this.f34474d;
        if (x0Var == null) {
            return;
        }
        x0Var.unregisterView();
    }

    @Override // com.vungle.ads.g1, com.vungle.ads.v
    public void onAdEnd(@NonNull u uVar) {
    }

    @Override // com.vungle.ads.g1, com.vungle.ads.v
    public void onAdStart(@NonNull u uVar) {
    }
}
