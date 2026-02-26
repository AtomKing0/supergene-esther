package androidx.privacysandbox.ads.adservices.topics;

import androidx.compose.foundation.e;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: GetTopicsRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GetTopicsRequest {

    @NotNull
    private final String adsSdkName;
    private final boolean shouldRecordObservation;

    /* JADX INFO: compiled from: GetTopicsRequest.kt */
    public static final class Builder {

        @NotNull
        private String adsSdkName = "";
        private boolean shouldRecordObservation = true;

        @NotNull
        public final GetTopicsRequest build() {
            if (this.adsSdkName.length() > 0) {
                return new GetTopicsRequest(this.adsSdkName, this.shouldRecordObservation);
            }
            throw new IllegalStateException("adsSdkName must be set".toString());
        }

        @NotNull
        public final Builder setAdsSdkName(@NotNull String adsSdkName) {
            t.i(adsSdkName, "adsSdkName");
            this.adsSdkName = adsSdkName;
            return this;
        }

        @NotNull
        public final Builder setShouldRecordObservation(boolean z10) {
            this.shouldRecordObservation = z10;
            return this;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GetTopicsRequest() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsRequest)) {
            return false;
        }
        GetTopicsRequest getTopicsRequest = (GetTopicsRequest) obj;
        return t.d(this.adsSdkName, getTopicsRequest.adsSdkName) && this.shouldRecordObservation == getTopicsRequest.shouldRecordObservation;
    }

    @NotNull
    public final String getAdsSdkName() {
        return this.adsSdkName;
    }

    public int hashCode() {
        return (this.adsSdkName.hashCode() * 31) + e.a(this.shouldRecordObservation);
    }

    public final boolean shouldRecordObservation() {
        return this.shouldRecordObservation;
    }

    @NotNull
    public String toString() {
        return "GetTopicsRequest: adsSdkName=" + this.adsSdkName + ", shouldRecordObservation=" + this.shouldRecordObservation;
    }

    public GetTopicsRequest(@NotNull String adsSdkName, boolean z10) {
        t.i(adsSdkName, "adsSdkName");
        this.adsSdkName = adsSdkName;
        this.shouldRecordObservation = z10;
    }

    public /* synthetic */ GetTopicsRequest(String str, boolean z10, int i10, k kVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? false : z10);
    }
}
