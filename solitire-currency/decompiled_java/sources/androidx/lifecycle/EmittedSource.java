package androidx.lifecycle;

import androidx.annotation.MainThread;
import h9.p;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: CoroutineLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class EmittedSource implements g1 {
    private boolean disposed;

    @NotNull
    private final MediatorLiveData<?> mediator;

    @NotNull
    private final LiveData<?> source;

    /* JADX INFO: renamed from: androidx.lifecycle.EmittedSource$dispose$1, reason: invalid class name */
    /* JADX INFO: compiled from: CoroutineLiveData.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.lifecycle.EmittedSource$dispose$1", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {
        int label;

        AnonymousClass1(z8.d<? super AnonymousClass1> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return EmittedSource.this.new AnonymousClass1(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            EmittedSource.this.removeSource();
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.EmittedSource$disposeNow$2, reason: invalid class name */
    /* JADX INFO: compiled from: CoroutineLiveData.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.lifecycle.EmittedSource$disposeNow$2", f = "CoroutineLiveData.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {
        int label;

        AnonymousClass2(z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return EmittedSource.this.new AnonymousClass2(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a9.d.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            EmittedSource.this.removeSource();
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public EmittedSource(@NotNull LiveData<?> source, @NotNull MediatorLiveData<?> mediator) {
        t.i(source, "source");
        t.i(mediator, "mediator");
        this.source = source;
        this.mediator = mediator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public final void removeSource() {
        if (this.disposed) {
            return;
        }
        this.mediator.removeSource(this.source);
        this.disposed = true;
    }

    @Override // kotlinx.coroutines.g1
    public void dispose() {
        kotlinx.coroutines.k.d(p0.a(e1.c().getImmediate()), null, null, new AnonymousClass1(null), 3, null);
    }

    @Nullable
    public final Object disposeNow(@NotNull z8.d<? super k0> dVar) {
        Object objG = kotlinx.coroutines.i.g(e1.c().getImmediate(), new AnonymousClass2(null), dVar);
        return objG == a9.d.e() ? objG : k0.f35197a;
    }
}
