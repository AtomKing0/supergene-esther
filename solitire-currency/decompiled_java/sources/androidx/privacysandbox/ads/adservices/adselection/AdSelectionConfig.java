package androidx.privacysandbox.ads.adservices.adselection;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdSelectionConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AdSelectionConfig {

    @NotNull
    private final AdSelectionSignals adSelectionSignals;

    @NotNull
    private final List<AdTechIdentifier> customAudienceBuyers;

    @NotNull
    private final Uri decisionLogicUri;

    @NotNull
    private final Map<AdTechIdentifier, AdSelectionSignals> perBuyerSignals;

    @NotNull
    private final AdTechIdentifier seller;

    @NotNull
    private final AdSelectionSignals sellerSignals;

    @NotNull
    private final Uri trustedScoringSignalsUri;

    public AdSelectionConfig(@NotNull AdTechIdentifier seller, @NotNull Uri decisionLogicUri, @NotNull List<AdTechIdentifier> customAudienceBuyers, @NotNull AdSelectionSignals adSelectionSignals, @NotNull AdSelectionSignals sellerSignals, @NotNull Map<AdTechIdentifier, AdSelectionSignals> perBuyerSignals, @NotNull Uri trustedScoringSignalsUri) {
        t.i(seller, "seller");
        t.i(decisionLogicUri, "decisionLogicUri");
        t.i(customAudienceBuyers, "customAudienceBuyers");
        t.i(adSelectionSignals, "adSelectionSignals");
        t.i(sellerSignals, "sellerSignals");
        t.i(perBuyerSignals, "perBuyerSignals");
        t.i(trustedScoringSignalsUri, "trustedScoringSignalsUri");
        this.seller = seller;
        this.decisionLogicUri = decisionLogicUri;
        this.customAudienceBuyers = customAudienceBuyers;
        this.adSelectionSignals = adSelectionSignals;
        this.sellerSignals = sellerSignals;
        this.perBuyerSignals = perBuyerSignals;
        this.trustedScoringSignalsUri = trustedScoringSignalsUri;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionConfig)) {
            return false;
        }
        AdSelectionConfig adSelectionConfig = (AdSelectionConfig) obj;
        return t.d(this.seller, adSelectionConfig.seller) && t.d(this.decisionLogicUri, adSelectionConfig.decisionLogicUri) && t.d(this.customAudienceBuyers, adSelectionConfig.customAudienceBuyers) && t.d(this.adSelectionSignals, adSelectionConfig.adSelectionSignals) && t.d(this.sellerSignals, adSelectionConfig.sellerSignals) && t.d(this.perBuyerSignals, adSelectionConfig.perBuyerSignals) && t.d(this.trustedScoringSignalsUri, adSelectionConfig.trustedScoringSignalsUri);
    }

    @NotNull
    public final AdSelectionSignals getAdSelectionSignals() {
        return this.adSelectionSignals;
    }

    @NotNull
    public final List<AdTechIdentifier> getCustomAudienceBuyers() {
        return this.customAudienceBuyers;
    }

    @NotNull
    public final Uri getDecisionLogicUri() {
        return this.decisionLogicUri;
    }

    @NotNull
    public final Map<AdTechIdentifier, AdSelectionSignals> getPerBuyerSignals() {
        return this.perBuyerSignals;
    }

    @NotNull
    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    @NotNull
    public final AdSelectionSignals getSellerSignals() {
        return this.sellerSignals;
    }

    @NotNull
    public final Uri getTrustedScoringSignalsUri() {
        return this.trustedScoringSignalsUri;
    }

    public int hashCode() {
        return (((((((((((this.seller.hashCode() * 31) + this.decisionLogicUri.hashCode()) * 31) + this.customAudienceBuyers.hashCode()) * 31) + this.adSelectionSignals.hashCode()) * 31) + this.sellerSignals.hashCode()) * 31) + this.perBuyerSignals.hashCode()) * 31) + this.trustedScoringSignalsUri.hashCode();
    }

    @NotNull
    public String toString() {
        return "AdSelectionConfig: seller=" + this.seller + ", decisionLogicUri='" + this.decisionLogicUri + "', customAudienceBuyers=" + this.customAudienceBuyers + ", adSelectionSignals=" + this.adSelectionSignals + ", sellerSignals=" + this.sellerSignals + ", perBuyerSignals=" + this.perBuyerSignals + ", trustedScoringSignalsUri=" + this.trustedScoringSignalsUri;
    }
}
