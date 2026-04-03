package androidx.window.embedding;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Consumer;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.embedding.EmbeddingCompat;
import androidx.window.embedding.EmbeddingInterfaceCompat;
import androidx.window.embedding.ExtensionEmbeddingBackend;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ExtensionEmbeddingBackend.kt */
/* JADX INFO: loaded from: classes2.dex */
@ExperimentalWindowApi
public final class ExtensionEmbeddingBackend implements EmbeddingBackend {

    @NotNull
    private static final String TAG = "EmbeddingBackend";

    @Nullable
    private static volatile ExtensionEmbeddingBackend globalInstance;

    @GuardedBy("globalLock")
    @VisibleForTesting
    @Nullable
    private EmbeddingInterfaceCompat embeddingExtension;

    @NotNull
    private final CopyOnWriteArrayList<SplitListenerWrapper> splitChangeCallbacks;

    @NotNull
    private final EmbeddingCallbackImpl splitInfoEmbeddingCallback;

    @NotNull
    private final CopyOnWriteArraySet<EmbeddingRule> splitRules;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final ReentrantLock globalLock = new ReentrantLock();

    /* JADX INFO: compiled from: ExtensionEmbeddingBackend.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        private final EmbeddingInterfaceCompat initAndVerifyEmbeddingExtension() {
            EmbeddingCompat embeddingCompat = null;
            try {
                EmbeddingCompat.Companion companion = EmbeddingCompat.Companion;
                if (isExtensionVersionSupported(companion.getExtensionApiLevel()) && companion.isEmbeddingAvailable()) {
                    embeddingCompat = new EmbeddingCompat();
                }
            } catch (Throwable th) {
                Log.d(ExtensionEmbeddingBackend.TAG, t.r("Failed to load embedding extension: ", th));
            }
            if (embeddingCompat == null) {
                Log.d(ExtensionEmbeddingBackend.TAG, "No supported embedding extension found");
            }
            return embeddingCompat;
        }

        @NotNull
        public final ExtensionEmbeddingBackend getInstance() {
            if (ExtensionEmbeddingBackend.globalInstance == null) {
                ReentrantLock reentrantLock = ExtensionEmbeddingBackend.globalLock;
                reentrantLock.lock();
                try {
                    if (ExtensionEmbeddingBackend.globalInstance == null) {
                        ExtensionEmbeddingBackend.globalInstance = new ExtensionEmbeddingBackend(ExtensionEmbeddingBackend.Companion.initAndVerifyEmbeddingExtension());
                    }
                    k0 k0Var = k0.f35197a;
                } finally {
                    reentrantLock.unlock();
                }
            }
            ExtensionEmbeddingBackend extensionEmbeddingBackend = ExtensionEmbeddingBackend.globalInstance;
            t.f(extensionEmbeddingBackend);
            return extensionEmbeddingBackend;
        }

        @VisibleForTesting
        public final boolean isExtensionVersionSupported(@Nullable Integer num) {
            return num != null && num.intValue() >= 1;
        }
    }

    /* JADX INFO: compiled from: ExtensionEmbeddingBackend.kt */
    public final class EmbeddingCallbackImpl implements EmbeddingInterfaceCompat.EmbeddingCallbackInterface {

        @Nullable
        private List<SplitInfo> lastInfo;
        final /* synthetic */ ExtensionEmbeddingBackend this$0;

        public EmbeddingCallbackImpl(ExtensionEmbeddingBackend this$0) {
            t.i(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Nullable
        public final List<SplitInfo> getLastInfo() {
            return this.lastInfo;
        }

        @Override // androidx.window.embedding.EmbeddingInterfaceCompat.EmbeddingCallbackInterface
        public void onSplitInfoChanged(@NotNull List<SplitInfo> splitInfo) {
            t.i(splitInfo, "splitInfo");
            this.lastInfo = splitInfo;
            Iterator<SplitListenerWrapper> it = this.this$0.getSplitChangeCallbacks().iterator();
            while (it.hasNext()) {
                it.next().accept(splitInfo);
            }
        }

        public final void setLastInfo(@Nullable List<SplitInfo> list) {
            this.lastInfo = list;
        }
    }

    /* JADX INFO: compiled from: ExtensionEmbeddingBackend.kt */
    public static final class SplitListenerWrapper {

        @NotNull
        private final Activity activity;

        @NotNull
        private final Consumer<List<SplitInfo>> callback;

        @NotNull
        private final Executor executor;

        @Nullable
        private List<SplitInfo> lastValue;

        public SplitListenerWrapper(@NotNull Activity activity, @NotNull Executor executor, @NotNull Consumer<List<SplitInfo>> callback) {
            t.i(activity, "activity");
            t.i(executor, "executor");
            t.i(callback, "callback");
            this.activity = activity;
            this.executor = executor;
            this.callback = callback;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: accept$lambda-1, reason: not valid java name */
        public static final void m3942accept$lambda1(SplitListenerWrapper this$0, List splitsWithActivity) {
            t.i(this$0, "this$0");
            t.i(splitsWithActivity, "$splitsWithActivity");
            this$0.callback.accept(splitsWithActivity);
        }

        public final void accept(@NotNull List<SplitInfo> splitInfoList) {
            t.i(splitInfoList, "splitInfoList");
            final ArrayList arrayList = new ArrayList();
            for (Object obj : splitInfoList) {
                if (((SplitInfo) obj).contains(this.activity)) {
                    arrayList.add(obj);
                }
            }
            if (t.d(arrayList, this.lastValue)) {
                return;
            }
            this.lastValue = arrayList;
            this.executor.execute(new Runnable() { // from class: androidx.window.embedding.f
                @Override // java.lang.Runnable
                public final void run() {
                    ExtensionEmbeddingBackend.SplitListenerWrapper.m3942accept$lambda1(this.f1750a, arrayList);
                }
            });
        }

        @NotNull
        public final Consumer<List<SplitInfo>> getCallback() {
            return this.callback;
        }
    }

    @VisibleForTesting
    public ExtensionEmbeddingBackend(@Nullable EmbeddingInterfaceCompat embeddingInterfaceCompat) {
        this.embeddingExtension = embeddingInterfaceCompat;
        EmbeddingCallbackImpl embeddingCallbackImpl = new EmbeddingCallbackImpl(this);
        this.splitInfoEmbeddingCallback = embeddingCallbackImpl;
        this.splitChangeCallbacks = new CopyOnWriteArrayList<>();
        EmbeddingInterfaceCompat embeddingInterfaceCompat2 = this.embeddingExtension;
        if (embeddingInterfaceCompat2 != null) {
            embeddingInterfaceCompat2.setEmbeddingCallback(embeddingCallbackImpl);
        }
        this.splitRules = new CopyOnWriteArraySet<>();
    }

    @Nullable
    public final EmbeddingInterfaceCompat getEmbeddingExtension() {
        return this.embeddingExtension;
    }

    @NotNull
    public final CopyOnWriteArrayList<SplitListenerWrapper> getSplitChangeCallbacks() {
        return this.splitChangeCallbacks;
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    @NotNull
    public Set<EmbeddingRule> getSplitRules() {
        return this.splitRules;
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    public boolean isSplitSupported() {
        return this.embeddingExtension != null;
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    public void registerRule(@NotNull EmbeddingRule rule) {
        t.i(rule, "rule");
        if (this.splitRules.contains(rule)) {
            return;
        }
        this.splitRules.add(rule);
        EmbeddingInterfaceCompat embeddingInterfaceCompat = this.embeddingExtension;
        if (embeddingInterfaceCompat == null) {
            return;
        }
        embeddingInterfaceCompat.setSplitRules(this.splitRules);
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    public void registerSplitListenerForActivity(@NotNull Activity activity, @NotNull Executor executor, @NotNull Consumer<List<SplitInfo>> callback) {
        t.i(activity, "activity");
        t.i(executor, "executor");
        t.i(callback, "callback");
        ReentrantLock reentrantLock = globalLock;
        reentrantLock.lock();
        try {
            if (getEmbeddingExtension() == null) {
                Log.v(TAG, "Extension not loaded, skipping callback registration.");
                callback.accept(v.l());
                return;
            }
            SplitListenerWrapper splitListenerWrapper = new SplitListenerWrapper(activity, executor, callback);
            getSplitChangeCallbacks().add(splitListenerWrapper);
            if (this.splitInfoEmbeddingCallback.getLastInfo() != null) {
                List<SplitInfo> lastInfo = this.splitInfoEmbeddingCallback.getLastInfo();
                t.f(lastInfo);
                splitListenerWrapper.accept(lastInfo);
            } else {
                splitListenerWrapper.accept(v.l());
            }
            k0 k0Var = k0.f35197a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void setEmbeddingExtension(@Nullable EmbeddingInterfaceCompat embeddingInterfaceCompat) {
        this.embeddingExtension = embeddingInterfaceCompat;
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    public void setSplitRules(@NotNull Set<? extends EmbeddingRule> rules) {
        t.i(rules, "rules");
        this.splitRules.clear();
        this.splitRules.addAll(rules);
        EmbeddingInterfaceCompat embeddingInterfaceCompat = this.embeddingExtension;
        if (embeddingInterfaceCompat == null) {
            return;
        }
        embeddingInterfaceCompat.setSplitRules(this.splitRules);
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    public void unregisterRule(@NotNull EmbeddingRule rule) {
        t.i(rule, "rule");
        if (this.splitRules.contains(rule)) {
            this.splitRules.remove(rule);
            EmbeddingInterfaceCompat embeddingInterfaceCompat = this.embeddingExtension;
            if (embeddingInterfaceCompat == null) {
                return;
            }
            embeddingInterfaceCompat.setSplitRules(this.splitRules);
        }
    }

    @Override // androidx.window.embedding.EmbeddingBackend
    public void unregisterSplitListenerForActivity(@NotNull Consumer<List<SplitInfo>> consumer) {
        t.i(consumer, "consumer");
        ReentrantLock reentrantLock = globalLock;
        reentrantLock.lock();
        try {
            Iterator<SplitListenerWrapper> it = getSplitChangeCallbacks().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SplitListenerWrapper next = it.next();
                if (t.d(next.getCallback(), consumer)) {
                    getSplitChangeCallbacks().remove(next);
                    break;
                }
            }
            k0 k0Var = k0.f35197a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getSplitChangeCallbacks$annotations() {
    }
}
