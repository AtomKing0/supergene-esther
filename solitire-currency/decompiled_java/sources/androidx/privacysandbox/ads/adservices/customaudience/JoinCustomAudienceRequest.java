package androidx.privacysandbox.ads.adservices.customaudience;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JoinCustomAudienceRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class JoinCustomAudienceRequest {

    @NotNull
    private final CustomAudience customAudience;

    public JoinCustomAudienceRequest(@NotNull CustomAudience customAudience) {
        t.i(customAudience, "customAudience");
        this.customAudience = customAudience;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JoinCustomAudienceRequest) {
            return t.d(this.customAudience, ((JoinCustomAudienceRequest) obj).customAudience);
        }
        return false;
    }

    @NotNull
    public final CustomAudience getCustomAudience() {
        return this.customAudience;
    }

    public int hashCode() {
        return this.customAudience.hashCode();
    }

    @NotNull
    public String toString() {
        return "JoinCustomAudience: customAudience=" + this.customAudience;
    }
}
