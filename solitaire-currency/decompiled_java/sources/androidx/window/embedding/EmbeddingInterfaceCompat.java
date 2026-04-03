package androidx.window.embedding;

import androidx.window.core.ExperimentalWindowApi;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EmbeddingInterfaceCompat.kt */
/* JADX INFO: loaded from: classes2.dex */
@ExperimentalWindowApi
public interface EmbeddingInterfaceCompat {

    /* JADX INFO: compiled from: EmbeddingInterfaceCompat.kt */
    public interface EmbeddingCallbackInterface {
        void onSplitInfoChanged(@NotNull List<SplitInfo> list);
    }

    void setEmbeddingCallback(@NotNull EmbeddingCallbackInterface embeddingCallbackInterface);

    void setSplitRules(@NotNull Set<? extends EmbeddingRule> set);
}
