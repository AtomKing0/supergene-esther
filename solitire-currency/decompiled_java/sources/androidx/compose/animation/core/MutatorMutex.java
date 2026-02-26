package androidx.compose.animation.core;

import androidx.compose.runtime.Stable;
import h9.p;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.g;

/* JADX INFO: compiled from: InternalMutatorMutex.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
public final class MutatorMutex {

    @NotNull
    private final AtomicReference<Mutator> currentMutator = new AtomicReference<>(null);

    @NotNull
    private final y9.a mutex = y9.c.b(false, 1, null);

    /* JADX INFO: compiled from: InternalMutatorMutex.kt */
    private static final class Mutator {

        @NotNull
        private final b2 job;

        @NotNull
        private final MutatePriority priority;

        public Mutator(@NotNull MutatePriority priority, @NotNull b2 job) {
            t.i(priority, "priority");
            t.i(job, "job");
            this.priority = priority;
            this.job = job;
        }

        public final boolean canInterrupt(@NotNull Mutator other) {
            t.i(other, "other");
            return this.priority.compareTo(other.priority) >= 0;
        }

        public final void cancel() {
            b2.a.a(this.job, null, 1, null);
        }

        @NotNull
        public final b2 getJob() {
            return this.job;
        }

        @NotNull
        public final MutatePriority getPriority() {
            return this.priority;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.MutatorMutex$mutate$2, reason: invalid class name */
    /* JADX INFO: compiled from: InternalMutatorMutex.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.animation.core.MutatorMutex$mutate$2", f = "InternalMutatorMutex.kt", l = {171, 119}, m = "invokeSuspend")
    static final class AnonymousClass2<R> extends l implements p<o0, z8.d<? super R>, Object> {
        final /* synthetic */ h9.l<z8.d<? super R>, Object> $block;
        final /* synthetic */ MutatePriority $priority;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        final /* synthetic */ MutatorMutex this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(MutatePriority mutatePriority, MutatorMutex mutatorMutex, h9.l<? super z8.d<? super R>, ? extends Object> lVar, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$priority = mutatePriority;
            this.this$0 = mutatorMutex;
            this.$block = lVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$priority, this.this$0, this.$block, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [int, y9.a] */
        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            y9.a aVar;
            h9.l<z8.d<? super R>, Object> lVar;
            Mutator mutator;
            MutatorMutex mutatorMutex;
            Mutator mutator2;
            Throwable th;
            MutatorMutex mutatorMutex2;
            y9.a aVar2;
            Object objE = a9.d.e();
            ?? r12 = this.label;
            try {
                try {
                    if (r12 == 0) {
                        u.b(obj);
                        o0 o0Var = (o0) this.L$0;
                        MutatePriority mutatePriority = this.$priority;
                        g.b bVar = o0Var.getCoroutineContext().get(b2.O7);
                        t.f(bVar);
                        Mutator mutator3 = new Mutator(mutatePriority, (b2) bVar);
                        this.this$0.tryMutateOrCancel(mutator3);
                        aVar = this.this$0.mutex;
                        h9.l<z8.d<? super R>, Object> lVar2 = this.$block;
                        MutatorMutex mutatorMutex3 = this.this$0;
                        this.L$0 = mutator3;
                        this.L$1 = aVar;
                        this.L$2 = lVar2;
                        this.L$3 = mutatorMutex3;
                        this.label = 1;
                        if (aVar.e(null, this) == objE) {
                            return objE;
                        }
                        lVar = lVar2;
                        mutator = mutator3;
                        mutatorMutex = mutatorMutex3;
                    } else {
                        if (r12 != 1) {
                            if (r12 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutatorMutex2 = (MutatorMutex) this.L$2;
                            aVar2 = (y9.a) this.L$1;
                            mutator2 = (Mutator) this.L$0;
                            try {
                                u.b(obj);
                                d.a(mutatorMutex2.currentMutator, mutator2, null);
                                aVar2.g(null);
                                return obj;
                            } catch (Throwable th2) {
                                th = th2;
                                d.a(mutatorMutex2.currentMutator, mutator2, null);
                                throw th;
                            }
                        }
                        mutatorMutex = (MutatorMutex) this.L$3;
                        lVar = (h9.l) this.L$2;
                        y9.a aVar3 = (y9.a) this.L$1;
                        mutator = (Mutator) this.L$0;
                        u.b(obj);
                        aVar = aVar3;
                    }
                    this.L$0 = mutator;
                    this.L$1 = aVar;
                    this.L$2 = mutatorMutex;
                    this.L$3 = null;
                    this.label = 2;
                    Object objInvoke = lVar.invoke(this);
                    if (objInvoke == objE) {
                        return objE;
                    }
                    mutatorMutex2 = mutatorMutex;
                    aVar2 = aVar;
                    obj = objInvoke;
                    mutator2 = mutator;
                    d.a(mutatorMutex2.currentMutator, mutator2, null);
                    aVar2.g(null);
                    return obj;
                } catch (Throwable th3) {
                    mutator2 = mutator;
                    th = th3;
                    mutatorMutex2 = mutatorMutex;
                    d.a(mutatorMutex2.currentMutator, mutator2, null);
                    throw th;
                }
            } catch (Throwable th4) {
                r12.g(null);
                throw th4;
            }
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super R> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.compose.animation.core.MutatorMutex$mutateWith$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: InternalMutatorMutex.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.animation.core.MutatorMutex$mutateWith$2", f = "InternalMutatorMutex.kt", l = {171, 158}, m = "invokeSuspend")
    static final class C08072<R> extends l implements p<o0, z8.d<? super R>, Object> {
        final /* synthetic */ p<T, z8.d<? super R>, Object> $block;
        final /* synthetic */ MutatePriority $priority;
        final /* synthetic */ T $receiver;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ MutatorMutex this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08072(MutatePriority mutatePriority, MutatorMutex mutatorMutex, p<? super T, ? super z8.d<? super R>, ? extends Object> pVar, T t10, z8.d<? super C08072> dVar) {
            super(2, dVar);
            this.$priority = mutatePriority;
            this.this$0 = mutatorMutex;
            this.$block = pVar;
            this.$receiver = t10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C08072 c08072 = new C08072(this.$priority, this.this$0, this.$block, this.$receiver, dVar);
            c08072.L$0 = obj;
            return c08072;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [int, y9.a] */
        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            y9.a aVar;
            p pVar;
            Object obj2;
            Mutator mutator;
            MutatorMutex mutatorMutex;
            Mutator mutator2;
            Throwable th;
            MutatorMutex mutatorMutex2;
            y9.a aVar2;
            Object objE = a9.d.e();
            ?? r12 = this.label;
            try {
                try {
                    if (r12 == 0) {
                        u.b(obj);
                        o0 o0Var = (o0) this.L$0;
                        MutatePriority mutatePriority = this.$priority;
                        g.b bVar = o0Var.getCoroutineContext().get(b2.O7);
                        t.f(bVar);
                        Mutator mutator3 = new Mutator(mutatePriority, (b2) bVar);
                        this.this$0.tryMutateOrCancel(mutator3);
                        aVar = this.this$0.mutex;
                        pVar = this.$block;
                        Object obj3 = this.$receiver;
                        MutatorMutex mutatorMutex3 = this.this$0;
                        this.L$0 = mutator3;
                        this.L$1 = aVar;
                        this.L$2 = pVar;
                        this.L$3 = obj3;
                        this.L$4 = mutatorMutex3;
                        this.label = 1;
                        if (aVar.e(null, this) == objE) {
                            return objE;
                        }
                        obj2 = obj3;
                        mutator = mutator3;
                        mutatorMutex = mutatorMutex3;
                    } else {
                        if (r12 != 1) {
                            if (r12 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutatorMutex2 = (MutatorMutex) this.L$2;
                            aVar2 = (y9.a) this.L$1;
                            mutator2 = (Mutator) this.L$0;
                            try {
                                u.b(obj);
                                d.a(mutatorMutex2.currentMutator, mutator2, null);
                                aVar2.g(null);
                                return obj;
                            } catch (Throwable th2) {
                                th = th2;
                                d.a(mutatorMutex2.currentMutator, mutator2, null);
                                throw th;
                            }
                        }
                        mutatorMutex = (MutatorMutex) this.L$4;
                        obj2 = this.L$3;
                        pVar = (p) this.L$2;
                        y9.a aVar3 = (y9.a) this.L$1;
                        mutator = (Mutator) this.L$0;
                        u.b(obj);
                        aVar = aVar3;
                    }
                    this.L$0 = mutator;
                    this.L$1 = aVar;
                    this.L$2 = mutatorMutex;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.label = 2;
                    Object objMo4invoke = pVar.mo4invoke(obj2, this);
                    if (objMo4invoke == objE) {
                        return objE;
                    }
                    mutatorMutex2 = mutatorMutex;
                    aVar2 = aVar;
                    obj = objMo4invoke;
                    mutator2 = mutator;
                    d.a(mutatorMutex2.currentMutator, mutator2, null);
                    aVar2.g(null);
                    return obj;
                } catch (Throwable th3) {
                    mutator2 = mutator;
                    th = th3;
                    mutatorMutex2 = mutatorMutex;
                    d.a(mutatorMutex2.currentMutator, mutator2, null);
                    throw th;
                }
            } catch (Throwable th4) {
                r12.g(null);
                throw th4;
            }
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super R> dVar) {
            return ((C08072) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public static /* synthetic */ Object mutate$default(MutatorMutex mutatorMutex, MutatePriority mutatePriority, h9.l lVar, z8.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return mutatorMutex.mutate(mutatePriority, lVar, dVar);
    }

    public static /* synthetic */ Object mutateWith$default(MutatorMutex mutatorMutex, Object obj, MutatePriority mutatePriority, p pVar, z8.d dVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            mutatePriority = MutatePriority.Default;
        }
        return mutatorMutex.mutateWith(obj, mutatePriority, pVar, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void tryMutateOrCancel(Mutator mutator) {
        Mutator mutator2;
        do {
            mutator2 = this.currentMutator.get();
            if (mutator2 != null && !mutator.canInterrupt(mutator2)) {
                throw new CancellationException("Current mutation had a higher priority");
            }
        } while (!d.a(this.currentMutator, mutator2, mutator));
        if (mutator2 != null) {
            mutator2.cancel();
        }
    }

    @Nullable
    public final <R> Object mutate(@NotNull MutatePriority mutatePriority, @NotNull h9.l<? super z8.d<? super R>, ? extends Object> lVar, @NotNull z8.d<? super R> dVar) {
        return p0.f(new AnonymousClass2(mutatePriority, this, lVar, null), dVar);
    }

    @Nullable
    public final <T, R> Object mutateWith(T t10, @NotNull MutatePriority mutatePriority, @NotNull p<? super T, ? super z8.d<? super R>, ? extends Object> pVar, @NotNull z8.d<? super R> dVar) {
        return p0.f(new C08072(mutatePriority, this, pVar, t10, null), dVar);
    }
}
