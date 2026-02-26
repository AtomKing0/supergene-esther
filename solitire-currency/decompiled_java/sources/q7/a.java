package q7;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: COPPA.kt */
/* JADX INFO: loaded from: classes4.dex */
public enum a {
    COPPA_ENABLED(Boolean.TRUE),
    COPPA_DISABLED(Boolean.FALSE),
    COPPA_NOTSET(null);


    @Nullable
    private final Boolean value;

    a(Boolean bool) {
        this.value = bool;
    }

    @Nullable
    public final Boolean getValue() {
        return this.value;
    }
}
