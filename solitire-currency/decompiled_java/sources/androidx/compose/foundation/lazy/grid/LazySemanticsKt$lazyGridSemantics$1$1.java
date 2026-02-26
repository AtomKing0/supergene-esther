package androidx.compose.foundation.lazy.grid;

import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: LazySemantics.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazySemanticsKt$lazyGridSemantics$1$1 extends v implements l<SemanticsPropertyReceiver, k0> {
    final /* synthetic */ ScrollAxisRange $accessibilityScrollState;
    final /* synthetic */ CollectionInfo $collectionInfo;
    final /* synthetic */ l<Object, Integer> $indexForKeyMapping;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ p<Float, Float, Boolean> $scrollByAction;
    final /* synthetic */ l<Integer, Boolean> $scrollToIndexAction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    LazySemanticsKt$lazyGridSemantics$1$1(l<Object, Integer> lVar, boolean z10, ScrollAxisRange scrollAxisRange, p<? super Float, ? super Float, Boolean> pVar, l<? super Integer, Boolean> lVar2, CollectionInfo collectionInfo) {
        super(1);
        this.$indexForKeyMapping = lVar;
        this.$isVertical = z10;
        this.$accessibilityScrollState = scrollAxisRange;
        this.$scrollByAction = pVar;
        this.$scrollToIndexAction = lVar2;
        this.$collectionInfo = collectionInfo;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        invoke2(semanticsPropertyReceiver);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
        t.i(semantics, "$this$semantics");
        SemanticsPropertiesKt.indexForKey(semantics, this.$indexForKeyMapping);
        if (this.$isVertical) {
            SemanticsPropertiesKt.setVerticalScrollAxisRange(semantics, this.$accessibilityScrollState);
        } else {
            SemanticsPropertiesKt.setHorizontalScrollAxisRange(semantics, this.$accessibilityScrollState);
        }
        p<Float, Float, Boolean> pVar = this.$scrollByAction;
        if (pVar != null) {
            SemanticsPropertiesKt.scrollBy$default(semantics, null, pVar, 1, null);
        }
        l<Integer, Boolean> lVar = this.$scrollToIndexAction;
        if (lVar != null) {
            SemanticsPropertiesKt.scrollToIndex$default(semantics, null, lVar, 1, null);
        }
        SemanticsPropertiesKt.setCollectionInfo(semantics, this.$collectionInfo);
    }
}
