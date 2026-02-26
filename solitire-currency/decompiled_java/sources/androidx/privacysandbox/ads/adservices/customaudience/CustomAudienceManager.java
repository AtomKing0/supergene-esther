package androidx.privacysandbox.ads.adservices.customaudience;

import a9.c;
import android.adservices.common.AdData;
import android.adservices.common.AdSelectionSignals;
import android.adservices.common.AdTechIdentifier;
import android.adservices.customaudience.CustomAudience;
import android.adservices.customaudience.JoinCustomAudienceRequest;
import android.adservices.customaudience.LeaveCustomAudienceRequest;
import android.adservices.customaudience.TrustedBiddingData;
import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RequiresPermission;
import androidx.core.os.OutcomeReceiverKt;
import androidx.media3.common.PlaybackException;
import androidx.media3.exoplayer.dash.offline.a;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: CustomAudienceManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class CustomAudienceManager {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: CustomAudienceManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @SuppressLint({"NewApi", "ClassVerificationFailure"})
        @Nullable
        public final CustomAudienceManager obtain(@NotNull Context context) {
            t.i(context, "context");
            if (AdServicesInfo.INSTANCE.version() >= 4) {
                return new Api33Ext4Impl(context);
            }
            return null;
        }
    }

    @SuppressLint({"NewApi", "ClassVerificationFailure"})
    @Nullable
    public static final CustomAudienceManager obtain(@NotNull Context context) {
        return Companion.obtain(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @Nullable
    public abstract Object joinCustomAudience(@NotNull JoinCustomAudienceRequest joinCustomAudienceRequest, @NotNull d<? super k0> dVar);

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
    @Nullable
    public abstract Object leaveCustomAudience(@NotNull LeaveCustomAudienceRequest leaveCustomAudienceRequest, @NotNull d<? super k0> dVar);

    /* JADX INFO: compiled from: CustomAudienceManager.kt */
    @RequiresExtension(extension = PlaybackException.CUSTOM_ERROR_CODE_BASE, version = 4)
    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    private static final class Api33Ext4Impl extends CustomAudienceManager {

        @NotNull
        private final android.adservices.customaudience.CustomAudienceManager customAudienceManager;

        public Api33Ext4Impl(@NotNull android.adservices.customaudience.CustomAudienceManager customAudienceManager) {
            t.i(customAudienceManager, "customAudienceManager");
            this.customAudienceManager = customAudienceManager;
        }

        private final List<AdData> convertAdData(List<androidx.privacysandbox.ads.adservices.common.AdData> list) {
            ArrayList arrayList = new ArrayList();
            for (androidx.privacysandbox.ads.adservices.common.AdData adData : list) {
                AdData adDataBuild = new AdData.Builder().setMetadata(adData.getMetadata()).setRenderUri(adData.getRenderUri()).build();
                t.h(adDataBuild, "Builder()\n              …                 .build()");
                arrayList.add(adDataBuild);
            }
            return arrayList;
        }

        private final AdTechIdentifier convertAdTechIdentifier(androidx.privacysandbox.ads.adservices.common.AdTechIdentifier adTechIdentifier) {
            AdTechIdentifier adTechIdentifierFromString = AdTechIdentifier.fromString(adTechIdentifier.getIdentifier());
            t.h(adTechIdentifierFromString, "fromString(input.identifier)");
            return adTechIdentifierFromString;
        }

        private final AdSelectionSignals convertBiddingSignals(androidx.privacysandbox.ads.adservices.common.AdSelectionSignals adSelectionSignals) {
            if (adSelectionSignals == null) {
                return null;
            }
            return AdSelectionSignals.fromString(adSelectionSignals.getSignals());
        }

        private final android.adservices.customaudience.CustomAudience convertCustomAudience(CustomAudience customAudience) {
            android.adservices.customaudience.CustomAudience customAudienceBuild = new CustomAudience.Builder().setActivationTime(customAudience.getActivationTime()).setAds(convertAdData(customAudience.getAds())).setBiddingLogicUri(customAudience.getBiddingLogicUri()).setBuyer(convertAdTechIdentifier(customAudience.getBuyer())).setDailyUpdateUri(customAudience.getDailyUpdateUri()).setExpirationTime(customAudience.getExpirationTime()).setName(customAudience.getName()).setTrustedBiddingData(convertTrustedSignals(customAudience.getTrustedBiddingSignals())).setUserBiddingSignals(convertBiddingSignals(customAudience.getUserBiddingSignals())).build();
            t.h(customAudienceBuild, "Builder()\n              …\n                .build()");
            return customAudienceBuild;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final android.adservices.customaudience.JoinCustomAudienceRequest convertJoinRequest(JoinCustomAudienceRequest joinCustomAudienceRequest) {
            android.adservices.customaudience.JoinCustomAudienceRequest joinCustomAudienceRequestBuild = new JoinCustomAudienceRequest.Builder().setCustomAudience(convertCustomAudience(joinCustomAudienceRequest.getCustomAudience())).build();
            t.h(joinCustomAudienceRequestBuild, "Builder()\n              …\n                .build()");
            return joinCustomAudienceRequestBuild;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final android.adservices.customaudience.LeaveCustomAudienceRequest convertLeaveRequest(LeaveCustomAudienceRequest leaveCustomAudienceRequest) {
            android.adservices.customaudience.LeaveCustomAudienceRequest leaveCustomAudienceRequestBuild = new LeaveCustomAudienceRequest.Builder().setBuyer(convertAdTechIdentifier(leaveCustomAudienceRequest.getBuyer())).setName(leaveCustomAudienceRequest.getName()).build();
            t.h(leaveCustomAudienceRequestBuild, "Builder()\n              …\n                .build()");
            return leaveCustomAudienceRequestBuild;
        }

        private final android.adservices.customaudience.TrustedBiddingData convertTrustedSignals(TrustedBiddingData trustedBiddingData) {
            if (trustedBiddingData == null) {
                return null;
            }
            return new TrustedBiddingData.Builder().setTrustedBiddingKeys(trustedBiddingData.getTrustedBiddingKeys()).setTrustedBiddingUri(trustedBiddingData.getTrustedBiddingUri()).build();
        }

        @Override // androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        @Nullable
        public Object joinCustomAudience(@NotNull JoinCustomAudienceRequest joinCustomAudienceRequest, @NotNull d<? super k0> dVar) throws Throwable {
            p pVar = new p(c.c(dVar), 1);
            pVar.C();
            this.customAudienceManager.joinCustomAudience(convertJoinRequest(joinCustomAudienceRequest), new a(), OutcomeReceiverKt.asOutcomeReceiver(pVar));
            Object objZ = pVar.z();
            if (objZ == a9.d.e()) {
                h.c(dVar);
            }
            return objZ == a9.d.e() ? objZ : k0.f35197a;
        }

        @Override // androidx.privacysandbox.ads.adservices.customaudience.CustomAudienceManager
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_CUSTOM_AUDIENCE")
        @DoNotInline
        @Nullable
        public Object leaveCustomAudience(@NotNull LeaveCustomAudienceRequest leaveCustomAudienceRequest, @NotNull d<? super k0> dVar) throws Throwable {
            p pVar = new p(c.c(dVar), 1);
            pVar.C();
            this.customAudienceManager.leaveCustomAudience(convertLeaveRequest(leaveCustomAudienceRequest), new a(), OutcomeReceiverKt.asOutcomeReceiver(pVar));
            Object objZ = pVar.z();
            if (objZ == a9.d.e()) {
                h.c(dVar);
            }
            return objZ == a9.d.e() ? objZ : k0.f35197a;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Api33Ext4Impl(@NotNull Context context) {
            t.i(context, "context");
            Object systemService = context.getSystemService((Class<Object>) android.adservices.customaudience.CustomAudienceManager.class);
            t.h(systemService, "context.getSystemService…:class.java\n            )");
            this((android.adservices.customaudience.CustomAudienceManager) systemService);
        }
    }
}
