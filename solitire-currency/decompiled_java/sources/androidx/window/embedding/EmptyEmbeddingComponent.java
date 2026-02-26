package androidx.window.embedding;

import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: EmbeddingCompat.kt */
/* JADX INFO: loaded from: classes2.dex */
final class EmptyEmbeddingComponent implements ActivityEmbeddingComponent {
    public void setEmbeddingRules(@NotNull Set<androidx.window.extensions.embedding.EmbeddingRule> splitRules) {
        t.i(splitRules, "splitRules");
    }

    public void setSplitInfoCallback(@NotNull Consumer<List<androidx.window.extensions.embedding.SplitInfo>> consumer) {
        t.i(consumer, "consumer");
    }
}
