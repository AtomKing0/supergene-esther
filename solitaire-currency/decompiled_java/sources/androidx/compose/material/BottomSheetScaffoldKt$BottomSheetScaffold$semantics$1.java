package androidx.compose.material;

import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import h9.a;
import h9.l;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: BottomSheetScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class BottomSheetScaffoldKt$BottomSheetScaffold$semantics$1 extends v implements l<SemanticsPropertyReceiver, k0> {
    final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
    final /* synthetic */ o0 $scope;

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$semantics$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    static final class AnonymousClass1 extends v implements a<Boolean> {
        final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
        final /* synthetic */ o0 $scope;

        /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$semantics$1$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BottomSheetScaffold.kt */
        @f(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$semantics$1$1$1", f = "BottomSheetScaffold.kt", l = {301}, m = "invokeSuspend")
        static final class C00861 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
            final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00861(BottomSheetScaffoldState bottomSheetScaffoldState, d<? super C00861> dVar) {
                super(2, dVar);
                this.$scaffoldState = bottomSheetScaffoldState;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                return new C00861(this.$scaffoldState, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    BottomSheetState bottomSheetState = this.$scaffoldState.getBottomSheetState();
                    this.label = 1;
                    if (bottomSheetState.expand(this) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                return k0.f35197a;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
                return ((C00861) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BottomSheetScaffoldState bottomSheetScaffoldState, o0 o0Var) {
            super(0);
            this.$scaffoldState = bottomSheetScaffoldState;
            this.$scope = o0Var;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            if (this.$scaffoldState.getBottomSheetState().getConfirmStateChange$material_release().invoke(BottomSheetValue.Expanded).booleanValue()) {
                k.d(this.$scope, null, null, new C00861(this.$scaffoldState, null), 3, null);
            }
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$semantics$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: BottomSheetScaffold.kt */
    static final class AnonymousClass2 extends v implements a<Boolean> {
        final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
        final /* synthetic */ o0 $scope;

        /* JADX INFO: renamed from: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$semantics$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: BottomSheetScaffold.kt */
        @f(c = "androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$semantics$1$2$1", f = "BottomSheetScaffold.kt", l = {308}, m = "invokeSuspend")
        static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
            final /* synthetic */ BottomSheetScaffoldState $scaffoldState;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(BottomSheetScaffoldState bottomSheetScaffoldState, d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$scaffoldState = bottomSheetScaffoldState;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                return new AnonymousClass1(this.$scaffoldState, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    BottomSheetState bottomSheetState = this.$scaffoldState.getBottomSheetState();
                    this.label = 1;
                    if (bottomSheetState.collapse(this) == objE) {
                        return objE;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                }
                return k0.f35197a;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
                return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(BottomSheetScaffoldState bottomSheetScaffoldState, o0 o0Var) {
            super(0);
            this.$scaffoldState = bottomSheetScaffoldState;
            this.$scope = o0Var;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final Boolean invoke() {
            if (this.$scaffoldState.getBottomSheetState().getConfirmStateChange$material_release().invoke(BottomSheetValue.Collapsed).booleanValue()) {
                k.d(this.$scope, null, null, new AnonymousClass1(this.$scaffoldState, null), 3, null);
            }
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BottomSheetScaffoldKt$BottomSheetScaffold$semantics$1(BottomSheetScaffoldState bottomSheetScaffoldState, o0 o0Var) {
        super(1);
        this.$scaffoldState = bottomSheetScaffoldState;
        this.$scope = o0Var;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        invoke2(semanticsPropertyReceiver);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
        t.i(semantics, "$this$semantics");
        if (this.$scaffoldState.getBottomSheetState().isCollapsed()) {
            SemanticsPropertiesKt.expand$default(semantics, null, new AnonymousClass1(this.$scaffoldState, this.$scope), 1, null);
        } else {
            SemanticsPropertiesKt.collapse$default(semantics, null, new AnonymousClass2(this.$scaffoldState, this.$scope), 1, null);
        }
    }
}
