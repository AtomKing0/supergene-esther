package v1;

import com.google.ads.mediation.vungle.b;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdCallback;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.vungle.ads.c;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VungleWaterfallAppOpenAd.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends t1.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration, @NotNull MediationAdLoadCallback<MediationAppOpenAd, MediationAppOpenAdCallback> mediationAdLoadCallback, @NotNull b vungleFactory) {
        super(mediationAppOpenAdConfiguration, mediationAdLoadCallback, vungleFactory);
        t.i(mediationAppOpenAdConfiguration, "mediationAppOpenAdConfiguration");
        t.i(mediationAdLoadCallback, "mediationAdLoadCallback");
        t.i(vungleFactory, "vungleFactory");
    }

    @Override // t1.a
    @Nullable
    public String f(@NotNull MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration) {
        t.i(mediationAppOpenAdConfiguration, "mediationAppOpenAdConfiguration");
        return null;
    }

    @Override // t1.a
    public void g(@NotNull c adConfig, @NotNull MediationAppOpenAdConfiguration mediationAppOpenAdConfiguration) {
        t.i(adConfig, "adConfig");
        t.i(mediationAppOpenAdConfiguration, "mediationAppOpenAdConfiguration");
    }
}
