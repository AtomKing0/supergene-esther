package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import h9.p;
import java.time.Duration;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CoroutineLiveDataKt {
    public static final long DEFAULT_TIMEOUT = 5000;

    /* JADX INFO: renamed from: androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2, reason: invalid class name */
    /* JADX INFO: compiled from: CoroutineLiveData.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super EmittedSource>, Object> {
        final /* synthetic */ LiveData<T> $source;
        final /* synthetic */ MediatorLiveData<T> $this_addDisposableSource;
        int label;

        /* JADX INFO: Add missing generic type declarations: [T] */
        /* JADX INFO: renamed from: androidx.lifecycle.CoroutineLiveDataKt$addDisposableSource$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: CoroutineLiveData.kt */
        static final class AnonymousClass1<T> extends v implements h9.l<T, k0> {
            final /* synthetic */ MediatorLiveData<T> $this_addDisposableSource;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(MediatorLiveData<T> mediatorLiveData) {
                super(1);
                this.$this_addDisposableSource = mediatorLiveData;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(Object obj) {
                invoke2(obj);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(T t10) {
                this.$this_addDisposableSource.setValue(t10);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$this_addDisposableSource = mediatorLiveData;
            this.$source = liveData;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new AnonymousClass2(this.$this_addDisposableSource, this.$source, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            MediatorLiveData<T> mediatorLiveData = this.$this_addDisposableSource;
            mediatorLiveData.addSource(this.$source, new CoroutineLiveDataKt$sam$androidx_lifecycle_Observer$0(new AnonymousClass1(mediatorLiveData)));
            return new EmittedSource(this.$source, this.$this_addDisposableSource);
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super EmittedSource> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    @Nullable
    public static final <T> Object addDisposableSource(@NotNull MediatorLiveData<T> mediatorLiveData, @NotNull LiveData<T> liveData, @NotNull z8.d<? super EmittedSource> dVar) {
        return kotlinx.coroutines.i.g(e1.c().getImmediate(), new AnonymousClass2(mediatorLiveData, liveData, null), dVar);
    }

    @NotNull
    public static final <T> LiveData<T> liveData(@NotNull p<? super LiveDataScope<T>, ? super z8.d<? super k0>, ? extends Object> block) {
        t.i(block, "block");
        return liveData$default((z8.g) null, 0L, block, 3, (Object) null);
    }

    public static /* synthetic */ LiveData liveData$default(z8.g gVar, long j10, p pVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = z8.h.f37608a;
        }
        if ((i10 & 2) != 0) {
            j10 = 5000;
        }
        return liveData(gVar, j10, pVar);
    }

    @RequiresApi(26)
    @NotNull
    public static final <T> LiveData<T> liveData(@NotNull Duration timeout, @NotNull p<? super LiveDataScope<T>, ? super z8.d<? super k0>, ? extends Object> block) {
        t.i(timeout, "timeout");
        t.i(block, "block");
        return liveData$default(timeout, (z8.g) null, block, 2, (Object) null);
    }

    @NotNull
    public static final <T> LiveData<T> liveData(@NotNull z8.g context, @NotNull p<? super LiveDataScope<T>, ? super z8.d<? super k0>, ? extends Object> block) {
        t.i(context, "context");
        t.i(block, "block");
        return liveData$default(context, 0L, block, 2, (Object) null);
    }

    public static /* synthetic */ LiveData liveData$default(Duration duration, z8.g gVar, p pVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            gVar = z8.h.f37608a;
        }
        return liveData(duration, gVar, pVar);
    }

    @NotNull
    public static final <T> LiveData<T> liveData(@NotNull z8.g context, long j10, @NotNull p<? super LiveDataScope<T>, ? super z8.d<? super k0>, ? extends Object> block) {
        t.i(context, "context");
        t.i(block, "block");
        return new CoroutineLiveData(context, j10, block);
    }

    @RequiresApi(26)
    @NotNull
    public static final <T> LiveData<T> liveData(@NotNull Duration timeout, @NotNull z8.g context, @NotNull p<? super LiveDataScope<T>, ? super z8.d<? super k0>, ? extends Object> block) {
        t.i(timeout, "timeout");
        t.i(context, "context");
        t.i(block, "block");
        return new CoroutineLiveData(context, Api26Impl.INSTANCE.toMillis(timeout), block);
    }
}
