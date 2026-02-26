package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: SingleProcessDataStore.kt */
/* JADX INFO: loaded from: classes.dex */
@f(c = "androidx.datastore.core.SingleProcessDataStore$actor$3", f = "SingleProcessDataStore.kt", l = {239, 242}, m = "invokeSuspend")
final class SingleProcessDataStore$actor$3<T> extends l implements p<SingleProcessDataStore.Message<T>, d<? super k0>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SingleProcessDataStore<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SingleProcessDataStore$actor$3(SingleProcessDataStore<T> singleProcessDataStore, d<? super SingleProcessDataStore$actor$3> dVar) {
        super(2, dVar);
        this.this$0 = singleProcessDataStore;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
        SingleProcessDataStore$actor$3 singleProcessDataStore$actor$3 = new SingleProcessDataStore$actor$3(this.this$0, dVar);
        singleProcessDataStore$actor$3.L$0 = obj;
        return singleProcessDataStore$actor$3;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull SingleProcessDataStore.Message<T> message, @Nullable d<? super k0> dVar) {
        return ((SingleProcessDataStore$actor$3) create(message, dVar)).invokeSuspend(k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            SingleProcessDataStore.Message message = (SingleProcessDataStore.Message) this.L$0;
            if (message instanceof SingleProcessDataStore.Message.Read) {
                this.label = 1;
                if (this.this$0.handleRead((SingleProcessDataStore.Message.Read) message, this) == objE) {
                    return objE;
                }
            } else if (message instanceof SingleProcessDataStore.Message.Update) {
                this.label = 2;
                if (this.this$0.handleUpdate((SingleProcessDataStore.Message.Update) message, this) == objE) {
                    return objE;
                }
            }
        } else {
            if (i10 != 1 && i10 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
        }
        return k0.f35197a;
    }
}
