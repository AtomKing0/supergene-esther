package androidx.privacysandbox.ads.adservices.adselection;

import android.net.Uri;
import androidx.compose.animation.a;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdSelectionOutcome.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AdSelectionOutcome {
    private final long adSelectionId;

    @NotNull
    private final Uri renderUri;

    public AdSelectionOutcome(long j10, @NotNull Uri renderUri) {
        t.i(renderUri, "renderUri");
        this.adSelectionId = j10;
        this.renderUri = renderUri;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionOutcome)) {
            return false;
        }
        AdSelectionOutcome adSelectionOutcome = (AdSelectionOutcome) obj;
        return this.adSelectionId == adSelectionOutcome.adSelectionId && t.d(this.renderUri, adSelectionOutcome.renderUri);
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    @NotNull
    public final Uri getRenderUri() {
        return this.renderUri;
    }

    public int hashCode() {
        return (a.a(this.adSelectionId) * 31) + this.renderUri.hashCode();
    }

    @NotNull
    public String toString() {
        return "AdSelectionOutcome: adSelectionId=" + this.adSelectionId + ", renderUri=" + this.renderUri;
    }
}
