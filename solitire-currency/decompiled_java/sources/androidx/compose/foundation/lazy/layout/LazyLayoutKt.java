package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: LazyLayout.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LazyLayoutKt {
    private static final int MaxItemsToRetainForReuse = 7;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutKt$LazyLayout$3, reason: invalid class name */
    /* JADX INFO: compiled from: LazyLayout.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ LazyLayoutItemProvider $itemProvider;
        final /* synthetic */ p<LazyLayoutMeasureScope, Constraints, MeasureResult> $measurePolicy;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ LazyLayoutPrefetchState $prefetchState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(LazyLayoutItemProvider lazyLayoutItemProvider, Modifier modifier, LazyLayoutPrefetchState lazyLayoutPrefetchState, p<? super LazyLayoutMeasureScope, ? super Constraints, ? extends MeasureResult> pVar, int i10, int i11) {
            super(2);
            this.$itemProvider = lazyLayoutItemProvider;
            this.$modifier = modifier;
            this.$prefetchState = lazyLayoutPrefetchState;
            this.$measurePolicy = pVar;
            this.$$changed = i10;
            this.$$default = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            LazyLayoutKt.LazyLayout(this.$itemProvider, this.$modifier, this.$prefetchState, this.$measurePolicy, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.foundation.ExperimentalFoundationApi
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LazyLayout(@org.jetbrains.annotations.NotNull androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider r13, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r14, @org.jetbrains.annotations.Nullable androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState r15, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, ? super androidx.compose.ui.unit.Constraints, ? extends androidx.compose.ui.layout.MeasureResult> r16, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r17, int r18, int r19) {
        /*
            Method dump skipped, instruction units count: 338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyLayoutKt.LazyLayout(androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider, androidx.compose.ui.Modifier, androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState, h9.p, androidx.compose.runtime.Composer, int, int):void");
    }
}
