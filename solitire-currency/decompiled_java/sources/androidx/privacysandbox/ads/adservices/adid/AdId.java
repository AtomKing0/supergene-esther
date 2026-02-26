package androidx.privacysandbox.ads.adservices.adid;

import androidx.compose.foundation.e;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdId.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AdId {

    @NotNull
    private final String adId;
    private final boolean isLimitAdTrackingEnabled;

    public AdId(@NotNull String adId, boolean z10) {
        t.i(adId, "adId");
        this.adId = adId;
        this.isLimitAdTrackingEnabled = z10;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdId)) {
            return false;
        }
        AdId adId = (AdId) obj;
        return t.d(this.adId, adId.adId) && this.isLimitAdTrackingEnabled == adId.isLimitAdTrackingEnabled;
    }

    @NotNull
    public final String getAdId() {
        return this.adId;
    }

    public int hashCode() {
        return (this.adId.hashCode() * 31) + e.a(this.isLimitAdTrackingEnabled);
    }

    public final boolean isLimitAdTrackingEnabled() {
        return this.isLimitAdTrackingEnabled;
    }

    @NotNull
    public String toString() {
        return "AdId: adId=" + this.adId + ", isLimitAdTrackingEnabled=" + this.isLimitAdTrackingEnabled;
    }

    public /* synthetic */ AdId(String str, boolean z10, int i10, k kVar) {
        this(str, (i10 & 2) != 0 ? false : z10);
    }
}
