package androidx.window.embedding;

import android.app.Activity;
import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.core.ExperimentalWindowApi;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.d0;
import kotlin.collections.z0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SplitController.kt */
/* JADX INFO: loaded from: classes2.dex */
@ExperimentalWindowApi
public final class SplitController {

    @Nullable
    private static volatile SplitController globalInstance = null;
    public static final boolean sDebug = false;

    @NotNull
    private final EmbeddingBackend embeddingBackend;

    @NotNull
    private Set<? extends EmbeddingRule> staticSplitRules;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final ReentrantLock globalLock = new ReentrantLock();

    /* JADX INFO: compiled from: SplitController.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final SplitController getInstance() {
            if (SplitController.globalInstance == null) {
                ReentrantLock reentrantLock = SplitController.globalLock;
                reentrantLock.lock();
                try {
                    if (SplitController.globalInstance == null) {
                        SplitController.globalInstance = new SplitController(null);
                    }
                    k0 k0Var = k0.f35197a;
                } finally {
                    reentrantLock.unlock();
                }
            }
            SplitController splitController = SplitController.globalInstance;
            t.f(splitController);
            return splitController;
        }

        public final void initialize(@NotNull Context context, int i10) {
            t.i(context, "context");
            Set<EmbeddingRule> splitRules$window_release = new SplitRuleParser().parseSplitRules$window_release(context, i10);
            SplitController companion = getInstance();
            if (splitRules$window_release == null) {
                splitRules$window_release = z0.e();
            }
            companion.setStaticSplitRules(splitRules$window_release);
        }
    }

    public /* synthetic */ SplitController(k kVar) {
        this();
    }

    @NotNull
    public static final SplitController getInstance() {
        return Companion.getInstance();
    }

    public static final void initialize(@NotNull Context context, int i10) {
        Companion.initialize(context, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setStaticSplitRules(Set<? extends EmbeddingRule> set) {
        this.staticSplitRules = set;
        this.embeddingBackend.setSplitRules(set);
    }

    public final void addSplitListener(@NotNull Activity activity, @NotNull Executor executor, @NotNull Consumer<List<SplitInfo>> consumer) {
        t.i(activity, "activity");
        t.i(executor, "executor");
        t.i(consumer, "consumer");
        this.embeddingBackend.registerSplitListenerForActivity(activity, executor, consumer);
    }

    public final void clearRegisteredRules() {
        this.embeddingBackend.setSplitRules(this.staticSplitRules);
    }

    @NotNull
    public final Set<EmbeddingRule> getSplitRules() {
        return d0.T0(this.embeddingBackend.getSplitRules());
    }

    public final boolean isSplitSupported() {
        return this.embeddingBackend.isSplitSupported();
    }

    public final void registerRule(@NotNull EmbeddingRule rule) {
        t.i(rule, "rule");
        this.embeddingBackend.registerRule(rule);
    }

    public final void removeSplitListener(@NotNull Consumer<List<SplitInfo>> consumer) {
        t.i(consumer, "consumer");
        this.embeddingBackend.unregisterSplitListenerForActivity(consumer);
    }

    public final void unregisterRule(@NotNull EmbeddingRule rule) {
        t.i(rule, "rule");
        this.embeddingBackend.unregisterRule(rule);
    }

    private SplitController() {
        this.embeddingBackend = ExtensionEmbeddingBackend.Companion.getInstance();
        this.staticSplitRules = z0.e();
    }
}
