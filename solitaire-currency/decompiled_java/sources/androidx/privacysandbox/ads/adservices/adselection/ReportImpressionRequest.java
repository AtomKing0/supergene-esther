package androidx.privacysandbox.ads.adservices.adselection;

import androidx.compose.animation.a;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ReportImpressionRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ReportImpressionRequest {

    @NotNull
    private final AdSelectionConfig adSelectionConfig;
    private final long adSelectionId;

    public ReportImpressionRequest(long j10, @NotNull AdSelectionConfig adSelectionConfig) {
        t.i(adSelectionConfig, "adSelectionConfig");
        this.adSelectionId = j10;
        this.adSelectionConfig = adSelectionConfig;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportImpressionRequest)) {
            return false;
        }
        ReportImpressionRequest reportImpressionRequest = (ReportImpressionRequest) obj;
        return this.adSelectionId == reportImpressionRequest.adSelectionId && t.d(this.adSelectionConfig, reportImpressionRequest.adSelectionConfig);
    }

    @NotNull
    public final AdSelectionConfig getAdSelectionConfig() {
        return this.adSelectionConfig;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public int hashCode() {
        return (a.a(this.adSelectionId) * 31) + this.adSelectionConfig.hashCode();
    }

    @NotNull
    public String toString() {
        return "ReportImpressionRequest: adSelectionId=" + this.adSelectionId + ", adSelectionConfig=" + this.adSelectionConfig;
    }
}
