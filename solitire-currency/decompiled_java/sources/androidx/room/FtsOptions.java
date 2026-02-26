package androidx.room;

import androidx.annotation.RequiresApi;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: FtsOptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FtsOptions {

    @NotNull
    public static final FtsOptions INSTANCE = new FtsOptions();

    @NotNull
    public static final String TOKENIZER_ICU = "icu";

    @NotNull
    public static final String TOKENIZER_PORTER = "porter";

    @NotNull
    public static final String TOKENIZER_SIMPLE = "simple";

    @RequiresApi(21)
    @NotNull
    public static final String TOKENIZER_UNICODE61 = "unicode61";

    /* JADX INFO: compiled from: FtsOptions.kt */
    public enum MatchInfo {
        FTS3,
        FTS4
    }

    /* JADX INFO: compiled from: FtsOptions.kt */
    public enum Order {
        ASC,
        DESC
    }

    private FtsOptions() {
    }
}
