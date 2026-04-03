package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import h9.p;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyListItemProviderImpl.kt */
/* JADX INFO: loaded from: classes.dex */
@ExperimentalFoundationApi
public final class LazyListItemProviderImpl implements LazyListItemProvider {

    @NotNull
    private final LazyItemScopeImpl itemScope;

    @NotNull
    private final State<LazyListItemsSnapshot> itemsSnapshot;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListItemProviderImpl$Item$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyListItemProviderImpl.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $index;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i10, int i11) {
            super(2);
            this.$index = i10;
            this.$$changed = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            LazyListItemProviderImpl.this.Item(this.$index, composer, this.$$changed | 1);
        }
    }

    public LazyListItemProviderImpl(@NotNull State<LazyListItemsSnapshot> itemsSnapshot) {
        t.i(itemsSnapshot, "itemsSnapshot");
        this.itemsSnapshot = itemsSnapshot;
        this.itemScope = new LazyItemScopeImpl();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    @Composable
    public void Item(int i10, @Nullable Composer composer, int i11) {
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(1704733014);
        if ((i11 & 14) == 0) {
            i12 = (composerStartRestartGroup.changed(i10) ? 4 : 2) | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            i12 |= composerStartRestartGroup.changed(this) ? 32 : 16;
        }
        if ((i12 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            this.itemsSnapshot.getValue().Item(getItemScope(), i10, composerStartRestartGroup, ((i12 << 3) & 112) | 512);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(i10, i11));
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    @Nullable
    public Object getContentType(int i10) {
        return this.itemsSnapshot.getValue().getContentType(i10);
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    @NotNull
    public List<Integer> getHeaderIndexes() {
        return this.itemsSnapshot.getValue().getHeaderIndexes();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    public int getItemCount() {
        return this.itemsSnapshot.getValue().getItemsCount();
    }

    @Override // androidx.compose.foundation.lazy.LazyListItemProvider
    @NotNull
    public LazyItemScopeImpl getItemScope() {
        return this.itemScope;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    @NotNull
    public Object getKey(int i10) {
        return this.itemsSnapshot.getValue().getKey(i10);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
    @NotNull
    public Map<Object, Integer> getKeyToIndexMap() {
        return this.itemsSnapshot.getValue().getKeyToIndexMap();
    }
}
