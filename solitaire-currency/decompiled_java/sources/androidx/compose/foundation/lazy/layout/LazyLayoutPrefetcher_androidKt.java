package androidx.compose.foundation.lazy.layout;

import android.view.View;
import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyLayoutPrefetcher.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutPrefetcher_androidKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutPrefetcher_androidKt$LazyLayoutPrefetcher$2, reason: invalid class name */
    /* JADX INFO: compiled from: LazyLayoutPrefetcher.android.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ LazyLayoutItemContentFactory $itemContentFactory;
        final /* synthetic */ LazyLayoutPrefetchState $prefetchState;
        final /* synthetic */ SubcomposeLayoutState $subcomposeLayoutState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(LazyLayoutPrefetchState lazyLayoutPrefetchState, LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeLayoutState subcomposeLayoutState, int i10) {
            super(2);
            this.$prefetchState = lazyLayoutPrefetchState;
            this.$itemContentFactory = lazyLayoutItemContentFactory;
            this.$subcomposeLayoutState = subcomposeLayoutState;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            LazyLayoutPrefetcher_androidKt.LazyLayoutPrefetcher(this.$prefetchState, this.$itemContentFactory, this.$subcomposeLayoutState, composer, this.$$changed | 1);
        }
    }

    @Composable
    @ExperimentalFoundationApi
    public static final void LazyLayoutPrefetcher(@NotNull LazyLayoutPrefetchState prefetchState, @NotNull LazyLayoutItemContentFactory itemContentFactory, @NotNull SubcomposeLayoutState subcomposeLayoutState, @Nullable Composer composer, int i10) {
        t.i(prefetchState, "prefetchState");
        t.i(itemContentFactory, "itemContentFactory");
        t.i(subcomposeLayoutState, "subcomposeLayoutState");
        Composer composerStartRestartGroup = composer.startRestartGroup(1113453182);
        View view = (View) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalView());
        int i11 = SubcomposeLayoutState.$stable;
        composerStartRestartGroup.startReplaceableGroup(1618982084);
        boolean zChanged = composerStartRestartGroup.changed(subcomposeLayoutState) | composerStartRestartGroup.changed(prefetchState) | composerStartRestartGroup.changed(view);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
            composerStartRestartGroup.updateRememberedValue(new LazyLayoutPrefetcher(prefetchState, subcomposeLayoutState, itemContentFactory, view));
        }
        composerStartRestartGroup.endReplaceableGroup();
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(prefetchState, itemContentFactory, subcomposeLayoutState, i10));
    }
}
