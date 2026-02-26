package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.media3.extractor.ts.TsExtractor;
import h9.p;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class BlockRunner<T> {

    @NotNull
    private final p<LiveDataScope<T>, z8.d<? super k0>, Object> block;

    @Nullable
    private b2 cancellationJob;

    @NotNull
    private final CoroutineLiveData<T> liveData;

    @NotNull
    private final h9.a<k0> onDone;

    @Nullable
    private b2 runningJob;

    @NotNull
    private final o0 scope;
    private final long timeoutInMs;

    /* JADX INFO: renamed from: androidx.lifecycle.BlockRunner$cancel$1, reason: invalid class name */
    /* JADX INFO: compiled from: CoroutineLiveData.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.lifecycle.BlockRunner$cancel$1", f = "CoroutineLiveData.kt", l = {TsExtractor.TS_PACKET_SIZE}, m = "invokeSuspend")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {
        int label;
        final /* synthetic */ BlockRunner<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BlockRunner<T> blockRunner, z8.d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.this$0 = blockRunner;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new AnonymousClass1(this.this$0, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                long j10 = ((BlockRunner) this.this$0).timeoutInMs;
                this.label = 1;
                if (y0.a(j10, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            if (!((BlockRunner) this.this$0).liveData.hasActiveObservers()) {
                b2 b2Var = ((BlockRunner) this.this$0).runningJob;
                if (b2Var != null) {
                    b2.a.a(b2Var, null, 1, null);
                }
                ((BlockRunner) this.this$0).runningJob = null;
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.BlockRunner$maybeRun$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: CoroutineLiveData.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.lifecycle.BlockRunner$maybeRun$1", f = "CoroutineLiveData.kt", l = {177}, m = "invokeSuspend")
    static final class C10411 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ BlockRunner<T> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10411(BlockRunner<T> blockRunner, z8.d<? super C10411> dVar) {
            super(2, dVar);
            this.this$0 = blockRunner;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C10411 c10411 = new C10411(this.this$0, dVar);
            c10411.L$0 = obj;
            return c10411;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                LiveDataScopeImpl liveDataScopeImpl = new LiveDataScopeImpl(((BlockRunner) this.this$0).liveData, ((o0) this.L$0).getCoroutineContext());
                p pVar = ((BlockRunner) this.this$0).block;
                this.label = 1;
                if (pVar.mo4invoke(liveDataScopeImpl, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            ((BlockRunner) this.this$0).onDone.invoke();
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((C10411) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BlockRunner(@NotNull CoroutineLiveData<T> liveData, @NotNull p<? super LiveDataScope<T>, ? super z8.d<? super k0>, ? extends Object> block, long j10, @NotNull o0 scope, @NotNull h9.a<k0> onDone) {
        t.i(liveData, "liveData");
        t.i(block, "block");
        t.i(scope, "scope");
        t.i(onDone, "onDone");
        this.liveData = liveData;
        this.block = block;
        this.timeoutInMs = j10;
        this.scope = scope;
        this.onDone = onDone;
    }

    @MainThread
    public final void cancel() {
        if (this.cancellationJob != null) {
            throw new IllegalStateException("Cancel call cannot happen without a maybeRun".toString());
        }
        this.cancellationJob = kotlinx.coroutines.k.d(this.scope, e1.c().getImmediate(), null, new AnonymousClass1(this, null), 2, null);
    }

    @MainThread
    public final void maybeRun() {
        b2 b2Var = this.cancellationJob;
        if (b2Var != null) {
            b2.a.a(b2Var, null, 1, null);
        }
        this.cancellationJob = null;
        if (this.runningJob != null) {
            return;
        }
        this.runningJob = kotlinx.coroutines.k.d(this.scope, null, null, new C10411(this, null), 3, null);
    }
}
