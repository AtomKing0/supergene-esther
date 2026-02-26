package q7;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PrivacyConsent.kt */
/* JADX INFO: loaded from: classes4.dex */
public enum b {
    OPT_IN("opted_in"),
    OPT_OUT("opted_out");


    @NotNull
    private final String value;

    b(String str) {
        this.value = str;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
