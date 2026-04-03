package androidx.privacysandbox.ads.adservices.common;

import android.net.Uri;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AdData {

    @NotNull
    private final String metadata;

    @NotNull
    private final Uri renderUri;

    public AdData(@NotNull Uri renderUri, @NotNull String metadata) {
        t.i(renderUri, "renderUri");
        t.i(metadata, "metadata");
        this.renderUri = renderUri;
        this.metadata = metadata;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdData)) {
            return false;
        }
        AdData adData = (AdData) obj;
        return t.d(this.renderUri, adData.renderUri) && t.d(this.metadata, adData.metadata);
    }

    @NotNull
    public final String getMetadata() {
        return this.metadata;
    }

    @NotNull
    public final Uri getRenderUri() {
        return this.renderUri;
    }

    public int hashCode() {
        return (this.renderUri.hashCode() * 31) + this.metadata.hashCode();
    }

    @NotNull
    public String toString() {
        return "AdData: renderUri=" + this.renderUri + ", metadata='" + this.metadata + '\'';
    }
}
