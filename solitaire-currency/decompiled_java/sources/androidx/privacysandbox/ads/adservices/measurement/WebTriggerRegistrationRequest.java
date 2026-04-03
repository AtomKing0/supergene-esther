package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import androidx.annotation.RequiresApi;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WebTriggerRegistrationRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(33)
public final class WebTriggerRegistrationRequest {

    @NotNull
    private final Uri destination;

    @NotNull
    private final List<WebTriggerParams> webTriggerParams;

    public WebTriggerRegistrationRequest(@NotNull List<WebTriggerParams> webTriggerParams, @NotNull Uri destination) {
        t.i(webTriggerParams, "webTriggerParams");
        t.i(destination, "destination");
        this.webTriggerParams = webTriggerParams;
        this.destination = destination;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebTriggerRegistrationRequest)) {
            return false;
        }
        WebTriggerRegistrationRequest webTriggerRegistrationRequest = (WebTriggerRegistrationRequest) obj;
        return t.d(this.webTriggerParams, webTriggerRegistrationRequest.webTriggerParams) && t.d(this.destination, webTriggerRegistrationRequest.destination);
    }

    @NotNull
    public final Uri getDestination() {
        return this.destination;
    }

    @NotNull
    public final List<WebTriggerParams> getWebTriggerParams() {
        return this.webTriggerParams;
    }

    public int hashCode() {
        return (this.webTriggerParams.hashCode() * 31) + this.destination.hashCode();
    }

    @NotNull
    public String toString() {
        return "WebTriggerRegistrationRequest { WebTriggerParams=" + this.webTriggerParams + ", Destination=" + this.destination;
    }
}
