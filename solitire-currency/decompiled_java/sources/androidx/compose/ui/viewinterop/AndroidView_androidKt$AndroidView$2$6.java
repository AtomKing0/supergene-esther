package androidx.compose.ui.viewinterop;

import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.Ref;
import androidx.compose.ui.unit.LayoutDirection;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;
import v8.q;

/* JADX INFO: compiled from: AndroidView.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidView_androidKt$AndroidView$2$6 extends v implements p<LayoutNode, LayoutDirection, k0> {
    final /* synthetic */ Ref<ViewFactoryHolder<T>> $viewFactoryHolderRef;

    /* JADX INFO: compiled from: AndroidView.android.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidView_androidKt$AndroidView$2$6(Ref<ViewFactoryHolder<T>> ref) {
        super(2);
        this.$viewFactoryHolderRef = ref;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ k0 mo4invoke(LayoutNode layoutNode, LayoutDirection layoutDirection) {
        invoke2(layoutNode, layoutDirection);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull LayoutNode set, @NotNull LayoutDirection it) {
        t.i(set, "$this$set");
        t.i(it, "it");
        Object value = this.$viewFactoryHolderRef.getValue();
        t.f(value);
        ViewFactoryHolder viewFactoryHolder = (ViewFactoryHolder) value;
        int i10 = WhenMappings.$EnumSwitchMapping$0[it.ordinal()];
        int i11 = 1;
        if (i10 == 1) {
            i11 = 0;
        } else if (i10 != 2) {
            throw new q();
        }
        viewFactoryHolder.setLayoutDirection(i11);
    }
}
