package androidx.window.embedding;

import android.util.Log;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.embedding.EmbeddingInterfaceCompat;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.embedding.ActivityEmbeddingComponent;
import java.util.Set;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: EmbeddingCompat.kt */
/* JADX INFO: loaded from: classes2.dex */
@ExperimentalWindowApi
public final class EmbeddingCompat implements EmbeddingInterfaceCompat {

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final boolean DEBUG = true;

    @NotNull
    private static final String TAG = "EmbeddingCompat";

    @NotNull
    private final EmbeddingAdapter adapter;

    @NotNull
    private final ActivityEmbeddingComponent embeddingExtension;

    /* JADX INFO: compiled from: EmbeddingCompat.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final ActivityEmbeddingComponent embeddingComponent() {
            if (!isEmbeddingAvailable()) {
                return new EmptyEmbeddingComponent();
            }
            ActivityEmbeddingComponent activityEmbeddingComponent = WindowExtensionsProvider.getWindowExtensions().getActivityEmbeddingComponent();
            return activityEmbeddingComponent == null ? new EmptyEmbeddingComponent() : activityEmbeddingComponent;
        }

        @Nullable
        public final Integer getExtensionApiLevel() {
            try {
                return Integer.valueOf(WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel());
            } catch (NoClassDefFoundError unused) {
                Log.d(EmbeddingCompat.TAG, "Embedding extension version not found");
                return null;
            } catch (UnsupportedOperationException unused2) {
                Log.d(EmbeddingCompat.TAG, "Stub Extension");
                return null;
            }
        }

        public final boolean isEmbeddingAvailable() {
            try {
                return WindowExtensionsProvider.getWindowExtensions().getActivityEmbeddingComponent() != null;
            } catch (NoClassDefFoundError unused) {
                Log.d(EmbeddingCompat.TAG, "Embedding extension version not found");
                return false;
            } catch (UnsupportedOperationException unused2) {
                Log.d(EmbeddingCompat.TAG, "Stub Extension");
                return false;
            }
        }
    }

    public EmbeddingCompat(@NotNull ActivityEmbeddingComponent embeddingExtension, @NotNull EmbeddingAdapter adapter) {
        t.i(embeddingExtension, "embeddingExtension");
        t.i(adapter, "adapter");
        this.embeddingExtension = embeddingExtension;
        this.adapter = adapter;
    }

    @Override // androidx.window.embedding.EmbeddingInterfaceCompat
    public void setEmbeddingCallback(@NotNull EmbeddingInterfaceCompat.EmbeddingCallbackInterface embeddingCallback) {
        t.i(embeddingCallback, "embeddingCallback");
        this.embeddingExtension.setSplitInfoCallback(new EmbeddingTranslatingCallback(embeddingCallback, this.adapter));
    }

    @Override // androidx.window.embedding.EmbeddingInterfaceCompat
    public void setSplitRules(@NotNull Set<? extends EmbeddingRule> rules) {
        t.i(rules, "rules");
        this.embeddingExtension.setEmbeddingRules(this.adapter.translate(rules));
    }

    public EmbeddingCompat() {
        this(Companion.embeddingComponent(), new EmbeddingAdapter());
    }
}
