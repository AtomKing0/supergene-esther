package androidx.privacysandbox.ads.adservices.common;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AdTechIdentifier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AdTechIdentifier {

    @NotNull
    private final String identifier;

    public AdTechIdentifier(@NotNull String identifier) {
        t.i(identifier, "identifier");
        this.identifier = identifier;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdTechIdentifier) {
            return t.d(this.identifier, ((AdTechIdentifier) obj).identifier);
        }
        return false;
    }

    @NotNull
    public final String getIdentifier() {
        return this.identifier;
    }

    public int hashCode() {
        return this.identifier.hashCode();
    }

    @NotNull
    public String toString() {
        return String.valueOf(this.identifier);
    }
}
