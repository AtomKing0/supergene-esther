package androidx.datastore.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SingleProcessDataStore.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1", f = "SingleProcessDataStore.kt", l = {TypedValues.CycleType.TYPE_VISIBILITY}, m = "invokeSuspend")
final class SingleProcessDataStore$transformAndWrite$newData$1<T> extends l implements p<o0, d<? super T>, Object> {
    final /* synthetic */ T $curData;
    final /* synthetic */ p<T, d<? super T>, Object> $transform;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SingleProcessDataStore$transformAndWrite$newData$1(p<? super T, ? super d<? super T>, ? extends Object> pVar, T t10, d<? super SingleProcessDataStore$transformAndWrite$newData$1> dVar) {
        super(2, dVar);
        this.$transform = pVar;
        this.$curData = t10;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        return new SingleProcessDataStore$transformAndWrite$newData$1(this.$transform, this.$curData, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            p<T, d<? super T>, Object> pVar = this.$transform;
            T t10 = this.$curData;
            this.label = 1;
            obj = pVar.mo4invoke(t10, this);
            if (obj == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        return obj;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super T> dVar) {
        return ((SingleProcessDataStore$transformAndWrite$newData$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
