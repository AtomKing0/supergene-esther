package androidx.privacysandbox.ads.adservices.common;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdSelectionSignals.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AdSelectionSignals {

    @NotNull
    private final String signals;

    public AdSelectionSignals(@NotNull String signals) {
        t.i(signals, "signals");
        this.signals = signals;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdSelectionSignals) {
            return t.d(this.signals, ((AdSelectionSignals) obj).signals);
        }
        return false;
    }

    @NotNull
    public final String getSignals() {
        return this.signals;
    }

    public int hashCode() {
        return this.signals.hashCode();
    }

    @NotNull
    public String toString() {
        return "AdSelectionSignals: " + this.signals;
    }
}
