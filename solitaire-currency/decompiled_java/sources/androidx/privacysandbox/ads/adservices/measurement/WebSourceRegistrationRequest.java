package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import android.view.InputEvent;
import androidx.annotation.RequiresApi;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WebSourceRegistrationRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(33)
public final class WebSourceRegistrationRequest {

    @Nullable
    private final Uri appDestination;

    @Nullable
    private final InputEvent inputEvent;

    @NotNull
    private final Uri topOriginUri;

    @Nullable
    private final Uri verifiedDestination;

    @Nullable
    private final Uri webDestination;

    @NotNull
    private final List<WebSourceParams> webSourceParams;

    /* JADX INFO: compiled from: WebSourceRegistrationRequest.kt */
    public static final class Builder {

        @Nullable
        private Uri appDestination;

        @Nullable
        private InputEvent inputEvent;

        @NotNull
        private final Uri topOriginUri;

        @Nullable
        private Uri verifiedDestination;

        @Nullable
        private Uri webDestination;

        @NotNull
        private final List<WebSourceParams> webSourceParams;

        public Builder(@NotNull List<WebSourceParams> webSourceParams, @NotNull Uri topOriginUri) {
            t.i(webSourceParams, "webSourceParams");
            t.i(topOriginUri, "topOriginUri");
            this.webSourceParams = webSourceParams;
            this.topOriginUri = topOriginUri;
        }

        @NotNull
        public final WebSourceRegistrationRequest build() {
            return new WebSourceRegistrationRequest(this.webSourceParams, this.topOriginUri, this.inputEvent, this.appDestination, this.webDestination, this.verifiedDestination);
        }

        @NotNull
        public final Builder setAppDestination(@Nullable Uri uri) {
            this.appDestination = uri;
            return this;
        }

        @NotNull
        public final Builder setInputEvent(@NotNull InputEvent inputEvent) {
            t.i(inputEvent, "inputEvent");
            this.inputEvent = inputEvent;
            return this;
        }

        @NotNull
        public final Builder setVerifiedDestination(@Nullable Uri uri) {
            this.verifiedDestination = uri;
            return this;
        }

        @NotNull
        public final Builder setWebDestination(@Nullable Uri uri) {
            this.webDestination = uri;
            return this;
        }
    }

    public WebSourceRegistrationRequest(@NotNull List<WebSourceParams> webSourceParams, @NotNull Uri topOriginUri, @Nullable InputEvent inputEvent, @Nullable Uri uri, @Nullable Uri uri2, @Nullable Uri uri3) {
        t.i(webSourceParams, "webSourceParams");
        t.i(topOriginUri, "topOriginUri");
        this.webSourceParams = webSourceParams;
        this.topOriginUri = topOriginUri;
        this.inputEvent = inputEvent;
        this.appDestination = uri;
        this.webDestination = uri2;
        this.verifiedDestination = uri3;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSourceRegistrationRequest)) {
            return false;
        }
        WebSourceRegistrationRequest webSourceRegistrationRequest = (WebSourceRegistrationRequest) obj;
        return t.d(this.webSourceParams, webSourceRegistrationRequest.webSourceParams) && t.d(this.webDestination, webSourceRegistrationRequest.webDestination) && t.d(this.appDestination, webSourceRegistrationRequest.appDestination) && t.d(this.topOriginUri, webSourceRegistrationRequest.topOriginUri) && t.d(this.inputEvent, webSourceRegistrationRequest.inputEvent) && t.d(this.verifiedDestination, webSourceRegistrationRequest.verifiedDestination);
    }

    @Nullable
    public final Uri getAppDestination() {
        return this.appDestination;
    }

    @Nullable
    public final InputEvent getInputEvent() {
        return this.inputEvent;
    }

    @NotNull
    public final Uri getTopOriginUri() {
        return this.topOriginUri;
    }

    @Nullable
    public final Uri getVerifiedDestination() {
        return this.verifiedDestination;
    }

    @Nullable
    public final Uri getWebDestination() {
        return this.webDestination;
    }

    @NotNull
    public final List<WebSourceParams> getWebSourceParams() {
        return this.webSourceParams;
    }

    public int hashCode() {
        int iHashCode = (this.webSourceParams.hashCode() * 31) + this.topOriginUri.hashCode();
        InputEvent inputEvent = this.inputEvent;
        if (inputEvent != null) {
            iHashCode = (iHashCode * 31) + inputEvent.hashCode();
        }
        Uri uri = this.appDestination;
        if (uri != null) {
            iHashCode = (iHashCode * 31) + uri.hashCode();
        }
        Uri uri2 = this.webDestination;
        if (uri2 != null) {
            iHashCode = (iHashCode * 31) + uri2.hashCode();
        }
        int iHashCode2 = (iHashCode * 31) + this.topOriginUri.hashCode();
        InputEvent inputEvent2 = this.inputEvent;
        if (inputEvent2 != null) {
            iHashCode2 = (iHashCode2 * 31) + inputEvent2.hashCode();
        }
        Uri uri3 = this.verifiedDestination;
        return uri3 != null ? (iHashCode2 * 31) + uri3.hashCode() : iHashCode2;
    }

    @NotNull
    public String toString() {
        return "WebSourceRegistrationRequest { " + ("WebSourceParams=[" + this.webSourceParams + "], TopOriginUri=" + this.topOriginUri + ", InputEvent=" + this.inputEvent + ", AppDestination=" + this.appDestination + ", WebDestination=" + this.webDestination + ", VerifiedDestination=" + this.verifiedDestination) + " }";
    }

    public /* synthetic */ WebSourceRegistrationRequest(List list, Uri uri, InputEvent inputEvent, Uri uri2, Uri uri3, Uri uri4, int i10, k kVar) {
        this(list, uri, (i10 & 4) != 0 ? null : inputEvent, (i10 & 8) != 0 ? null : uri2, (i10 & 16) != 0 ? null : uri3, (i10 & 32) != 0 ? null : uri4);
    }
}
