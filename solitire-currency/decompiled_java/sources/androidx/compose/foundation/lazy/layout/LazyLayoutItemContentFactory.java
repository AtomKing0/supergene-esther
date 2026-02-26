package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import h9.p;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyLayoutItemContentFactory.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public final class LazyLayoutItemContentFactory {
    private long constraintsOfCachedLambdas;

    @NotNull
    private Density densityOfCachedLambdas;

    @NotNull
    private final h9.a<LazyLayoutItemProvider> itemProvider;

    @NotNull
    private final Map<Object, CachedItemContent> lambdasCache;

    @NotNull
    private final SaveableStateHolder saveableStateHolder;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: LazyLayoutItemContentFactory.kt */
    final class CachedItemContent {

        @Nullable
        private p<? super Composer, ? super Integer, k0> _content;

        @NotNull
        private final Object key;

        @NotNull
        private final MutableState lastKnownIndex$delegate;
        final /* synthetic */ LazyLayoutItemContentFactory this$0;

        @Nullable
        private final Object type;

        public CachedItemContent(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, @NotNull int i10, @Nullable Object key, Object obj) {
            t.i(key, "key");
            this.this$0 = lazyLayoutItemContentFactory;
            this.key = key;
            this.type = obj;
            this.lastKnownIndex$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Integer.valueOf(i10), null, 2, null);
        }

        private final p<Composer, Integer, k0> createContentLambda() {
            return ComposableLambdaKt.composableLambdaInstance(1403994769, true, new LazyLayoutItemContentFactory$CachedItemContent$createContentLambda$1(this.this$0, this));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setLastKnownIndex(int i10) {
            this.lastKnownIndex$delegate.setValue(Integer.valueOf(i10));
        }

        @NotNull
        public final p<Composer, Integer, k0> getContent() {
            p pVar = this._content;
            if (pVar != null) {
                return pVar;
            }
            p<Composer, Integer, k0> pVarCreateContentLambda = createContentLambda();
            this._content = pVarCreateContentLambda;
            return pVarCreateContentLambda;
        }

        @NotNull
        public final Object getKey() {
            return this.key;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final int getLastKnownIndex() {
            return ((Number) this.lastKnownIndex$delegate.getValue()).intValue();
        }

        @Nullable
        public final Object getType() {
            return this.type;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LazyLayoutItemContentFactory(@NotNull SaveableStateHolder saveableStateHolder, @NotNull h9.a<? extends LazyLayoutItemProvider> itemProvider) {
        t.i(saveableStateHolder, "saveableStateHolder");
        t.i(itemProvider, "itemProvider");
        this.saveableStateHolder = saveableStateHolder;
        this.itemProvider = itemProvider;
        this.lambdasCache = new LinkedHashMap();
        this.densityOfCachedLambdas = DensityKt.Density(0.0f, 0.0f);
        this.constraintsOfCachedLambdas = ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null);
    }

    @NotNull
    public final p<Composer, Integer, k0> getContent(int i10, @NotNull Object key) {
        t.i(key, "key");
        CachedItemContent cachedItemContent = this.lambdasCache.get(key);
        Object contentType = this.itemProvider.invoke().getContentType(i10);
        if (cachedItemContent != null && cachedItemContent.getLastKnownIndex() == i10 && t.d(cachedItemContent.getType(), contentType)) {
            return cachedItemContent.getContent();
        }
        CachedItemContent cachedItemContent2 = new CachedItemContent(this, i10, key, contentType);
        this.lambdasCache.put(key, cachedItemContent2);
        return cachedItemContent2.getContent();
    }

    @Nullable
    public final Object getContentType(@Nullable Object obj) {
        CachedItemContent cachedItemContent = this.lambdasCache.get(obj);
        if (cachedItemContent != null) {
            return cachedItemContent.getType();
        }
        LazyLayoutItemProvider lazyLayoutItemProviderInvoke = this.itemProvider.invoke();
        Integer num = lazyLayoutItemProviderInvoke.getKeyToIndexMap().get(obj);
        if (num != null) {
            return lazyLayoutItemProviderInvoke.getContentType(num.intValue());
        }
        return null;
    }

    @NotNull
    public final h9.a<LazyLayoutItemProvider> getItemProvider() {
        return this.itemProvider;
    }

    /* JADX INFO: renamed from: onBeforeMeasure-0kLqBqw, reason: not valid java name */
    public final void m606onBeforeMeasure0kLqBqw(@NotNull Density density, long j10) {
        t.i(density, "density");
        if (t.d(density, this.densityOfCachedLambdas) && Constraints.m3634equalsimpl0(j10, this.constraintsOfCachedLambdas)) {
            return;
        }
        this.densityOfCachedLambdas = density;
        this.constraintsOfCachedLambdas = j10;
        this.lambdasCache.clear();
    }
}
