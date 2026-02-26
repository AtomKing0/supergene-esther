package androidx.compose.material;

import android.view.View;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.Ref;
import h9.a;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import v8.k0;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes.dex */
final class ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1 extends v implements a<k0> {
    final /* synthetic */ Ref<LayoutCoordinates> $coordinates;
    final /* synthetic */ MutableState<Integer> $menuHeight$delegate;
    final /* synthetic */ int $verticalMarginInPx;
    final /* synthetic */ View $view;

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
    static final class AnonymousClass1 extends v implements l<Integer, k0> {
        final /* synthetic */ MutableState<Integer> $menuHeight$delegate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MutableState<Integer> mutableState) {
            super(1);
            this.$menuHeight$delegate = mutableState;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Integer num) {
            invoke(num.intValue());
            return k0.f35197a;
        }

        public final void invoke(int i10) {
            ExposedDropdownMenuKt.m1026ExposedDropdownMenuBox$lambda5(this.$menuHeight$delegate, i10);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ExposedDropdownMenuKt$ExposedDropdownMenuBox$5$listener$1(View view, Ref<LayoutCoordinates> ref, int i10, MutableState<Integer> mutableState) {
        super(0);
        this.$view = view;
        this.$coordinates = ref;
        this.$verticalMarginInPx = i10;
        this.$menuHeight$delegate = mutableState;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        View rootView = this.$view.getRootView();
        t.h(rootView, "view.rootView");
        ExposedDropdownMenuKt.updateHeight(rootView, this.$coordinates.getValue(), this.$verticalMarginInPx, new AnonymousClass1(this.$menuHeight$delegate));
    }
}
