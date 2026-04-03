package androidx.privacysandbox.ads.adservices.customaudience;

import android.net.Uri;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: TrustedBiddingData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class TrustedBiddingData {

    @NotNull
    private final List<String> trustedBiddingKeys;

    @NotNull
    private final Uri trustedBiddingUri;

    public TrustedBiddingData(@NotNull Uri trustedBiddingUri, @NotNull List<String> trustedBiddingKeys) {
        t.i(trustedBiddingUri, "trustedBiddingUri");
        t.i(trustedBiddingKeys, "trustedBiddingKeys");
        this.trustedBiddingUri = trustedBiddingUri;
        this.trustedBiddingKeys = trustedBiddingKeys;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrustedBiddingData)) {
            return false;
        }
        TrustedBiddingData trustedBiddingData = (TrustedBiddingData) obj;
        return t.d(this.trustedBiddingUri, trustedBiddingData.trustedBiddingUri) && t.d(this.trustedBiddingKeys, trustedBiddingData.trustedBiddingKeys);
    }

    @NotNull
    public final List<String> getTrustedBiddingKeys() {
        return this.trustedBiddingKeys;
    }

    @NotNull
    public final Uri getTrustedBiddingUri() {
        return this.trustedBiddingUri;
    }

    public int hashCode() {
        return (this.trustedBiddingUri.hashCode() * 31) + this.trustedBiddingKeys.hashCode();
    }

    @NotNull
    public String toString() {
        return "TrustedBiddingData: trustedBiddingUri=" + this.trustedBiddingUri + " trustedBiddingKeys=" + this.trustedBiddingKeys;
    }
}
