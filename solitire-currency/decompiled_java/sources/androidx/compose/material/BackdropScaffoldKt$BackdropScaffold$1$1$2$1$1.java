package androidx.compose.material;

import h9.a;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: BackdropScaffold.kt */
/* JADX INFO: loaded from: classes.dex */
final class BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1 extends v implements a<k0> {
    final /* synthetic */ boolean $gesturesEnabled;
    final /* synthetic */ BackdropScaffoldState $scaffoldState;
    final /* synthetic */ o0 $scope;

    /* JADX INFO: renamed from: androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: BackdropScaffold.kt */
    @f(c = "androidx.compose.material.BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1$1", f = "BackdropScaffold.kt", l = {358}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ BackdropScaffoldState $scaffoldState;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BackdropScaffoldState backdropScaffoldState, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$scaffoldState = backdropScaffoldState;
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
                BackdropScaffoldState backdropScaffoldState = this.$scaffoldState;
                this.label = 1;
                if (backdropScaffoldState.conceal(this) == objE) {
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
    BackdropScaffoldKt$BackdropScaffold$1$1$2$1$1(boolean z10, BackdropScaffoldState backdropScaffoldState, o0 o0Var) {
        super(0);
        this.$gesturesEnabled = z10;
        this.$scaffoldState = backdropScaffoldState;
        this.$scope = o0Var;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ k0 invoke() {
        invoke2();
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$gesturesEnabled && this.$scaffoldState.getConfirmStateChange$material_release().invoke(BackdropValue.Concealed).booleanValue()) {
            k.d(this.$scope, null, null, new AnonymousClass1(this.$scaffoldState, null), 3, null);
        }
    }
}
