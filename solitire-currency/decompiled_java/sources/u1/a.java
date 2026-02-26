package u1;

import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VungleRtbAppOpenAd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends t1.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration, @NotNull MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> mediationAdLoadCallback, @NotNull com.google.ads.mediation.vungle.b vungleFactory) {
        super(mediationAppOpenAdConfiguration, mediationAdLoadCallback, vungleFactory);
        t.i(mediationAppOpenAdConfiguration, "mediationAppOpenAdConfiguration");
        t.i(mediationAdLoadCallback, "mediationAdLoadCallback");
        t.i(vungleFactory, "vungleFactory");
    }

    @Override // t1.a
    @NotNull
    public String f(@NotNull MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration) {
        t.i(mediationAppOpenAdConfiguration, "mediationAppOpenAdConfiguration");
        String bidResponse = mediationAppOpenAdConfiguration.getBidResponse();
        t.h(bidResponse, "mediationAppOpenAdConfiguration.bidResponse");
        return bidResponse;
    }

    @Override // t1.a
    public void g(@NotNull com.vungle.ads.c adConfig, @NotNull MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration) {
        t.i(adConfig, "adConfig");
        t.i(mediationAppOpenAdConfiguration, "mediationAppOpenAdConfiguration");
        String watermark = mediationAppOpenAdConfiguration.getWatermark();
        t.h(watermark, "mediationAppOpenAdConfiguration.watermark");
        if (watermark.length() > 0) {
            adConfig.setWatermark(watermark);
        }
    }
}
