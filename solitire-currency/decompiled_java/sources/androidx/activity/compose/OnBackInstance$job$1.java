package androidx.activity.compose;

import androidx.activity.BackEventCompat;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.i0;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import s9.i;
import s9.j;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: PredictiveBackHandler.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.activity.compose.OnBackInstance$job$1", f = "PredictiveBackHandler.kt", l = {154}, m = "invokeSuspend")
final class OnBackInstance$job$1 extends l implements p<o0, d<? super k0>, Object> {
    final /* synthetic */ p<h<BackEventCompat>, d<? super k0>, Object> $onBack;
    Object L$0;
    int label;
    final /* synthetic */ OnBackInstance this$0;

    /* JADX INFO: renamed from: androidx.activity.compose.OnBackInstance$job$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: PredictiveBackHandler.kt */
    @f(c = "androidx.activity.compose.OnBackInstance$job$1$1", f = "PredictiveBackHandler.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements q<i<? super BackEventCompat>, Throwable, d<? super k0>, Object> {
        final /* synthetic */ i0 $completed;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(i0 i0Var, d<? super AnonymousClass1> dVar) {
            super(3, dVar);
            this.$completed = i0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            this.$completed.f29826a = true;
            return k0.f35197a;
        }

        @Override // h9.q
        @Nullable
        public final Object invoke(@NotNull i<? super BackEventCompat> iVar, @Nullable Throwable th, @Nullable d<? super k0> dVar) {
            return new AnonymousClass1(this.$completed, dVar).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    OnBackInstance$job$1(p<? super h<BackEventCompat>, ? super d<? super k0>, ? extends Object> pVar, OnBackInstance onBackInstance, d<? super OnBackInstance$job$1> dVar) {
        super(2, dVar);
        this.$onBack = pVar;
        this.this$0 = onBackInstance;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        return new OnBackInstance$job$1(this.$onBack, this.this$0, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        i0 i0Var;
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            i0 i0Var2 = new i0();
            p<h<BackEventCompat>, d<? super k0>, Object> pVar = this.$onBack;
            h<BackEventCompat> hVarF = j.F(j.o(this.this$0.getChannel()), new AnonymousClass1(i0Var2, null));
            this.L$0 = i0Var2;
            this.label = 1;
            if (pVar.mo4invoke(hVarF, this) == objE) {
                return objE;
            }
            i0Var = i0Var2;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i0Var = (i0) this.L$0;
            u.b(obj);
        }
        if (i0Var.f29826a) {
            return k0.f35197a;
        }
        throw new IllegalStateException("You must collect the progress flow".toString());
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
        return ((OnBackInstance$job$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
