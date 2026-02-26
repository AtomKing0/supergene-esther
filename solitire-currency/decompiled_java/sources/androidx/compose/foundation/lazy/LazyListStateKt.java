package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LazyListState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyListStateKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazyListStateKt$rememberLazyListState$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazyListState.kt */
    static final class AnonymousClass1 extends v implements h9.a<LazyListState> {
        final /* synthetic */ int $initialFirstVisibleItemIndex;
        final /* synthetic */ int $initialFirstVisibleItemScrollOffset;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i10, int i11) {
            super(0);
            this.$initialFirstVisibleItemIndex = i10;
            this.$initialFirstVisibleItemScrollOffset = i11;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final LazyListState invoke() {
            return new LazyListState(this.$initialFirstVisibleItemIndex, this.$initialFirstVisibleItemScrollOffset);
        }
    }

    @Composable
    @NotNull
    public static final LazyListState rememberLazyListState(int i10, int i11, @Nullable Composer composer, int i12, int i13) {
        composer.startReplaceableGroup(1470655220);
        if ((i13 & 1) != 0) {
            i10 = 0;
        }
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        LazyListState lazyListState = (LazyListState) RememberSaveableKt.m1271rememberSaveable(new Object[0], (Saver) LazyListState.Companion.getSaver(), (String) null, (h9.a) new AnonymousClass1(i10, i11), composer, 72, 4);
        composer.endReplaceableGroup();
        return lazyListState;
    }
}
