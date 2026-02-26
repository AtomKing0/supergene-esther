package androidx.media3.exoplayer.dash.manifest;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.UriUtil;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public final class RangedUri {
    private int hashCode;
    public final long length;
    private final String referenceUri;
    public final long start;

    public RangedUri(@Nullable String str, long j10, long j11) {
        this.referenceUri = str == null ? "" : str;
        this.start = j10;
        this.length = j11;
    }

    @Nullable
    public RangedUri attemptMerge(@Nullable RangedUri rangedUri, String str) {
        String strResolveUriString = resolveUriString(str);
        if (rangedUri != null && strResolveUriString.equals(rangedUri.resolveUriString(str))) {
            long j10 = this.length;
            if (j10 != -1) {
                long j11 = this.start;
                if (j11 + j10 == rangedUri.start) {
                    long j12 = rangedUri.length;
                    return new RangedUri(strResolveUriString, j11, j12 != -1 ? j10 + j12 : -1L);
                }
            }
            long j13 = rangedUri.length;
            if (j13 != -1) {
                long j14 = rangedUri.start;
                if (j14 + j13 == this.start) {
                    return new RangedUri(strResolveUriString, j14, j10 != -1 ? j13 + j10 : -1L);
                }
            }
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || RangedUri.class != obj.getClass()) {
            return false;
        }
        RangedUri rangedUri = (RangedUri) obj;
        return this.start == rangedUri.start && this.length == rangedUri.length && this.referenceUri.equals(rangedUri.referenceUri);
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = ((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + ((int) this.start)) * 31) + ((int) this.length)) * 31) + this.referenceUri.hashCode();
        }
        return this.hashCode;
    }

    public Uri resolveUri(String str) {
        return UriUtil.resolveToUri(str, this.referenceUri);
    }

    public String resolveUriString(String str) {
        return UriUtil.resolve(str, this.referenceUri);
    }

    public String toString() {
        return "RangedUri(referenceUri=" + this.referenceUri + ", start=" + this.start + ", length=" + this.length + ")";
    }
}
