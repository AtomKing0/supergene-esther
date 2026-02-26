package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.n2;
import kotlinx.coroutines.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;
import v8.u;

/* JADX INFO: compiled from: WithLifecycleState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WithLifecycleStateKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: androidx.lifecycle.WithLifecycleStateKt$withStateAtLeastUnchecked$2, reason: invalid class name */
    /* JADX INFO: compiled from: WithLifecycleState.kt */
    public static final class AnonymousClass2<R> extends v implements h9.a<R> {
        final /* synthetic */ h9.a<R> $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(h9.a<? extends R> aVar) {
            super(0);
            this.$block = aVar;
        }

        @Override // h9.a
        public final R invoke() {
            return this.$block.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.lifecycle.LifecycleObserver, androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1] */
    @Nullable
    public static final <R> Object suspendWithStateAtLeastUnchecked(@NotNull final Lifecycle lifecycle, @NotNull final Lifecycle.State state, boolean z10, @NotNull k0 k0Var, @NotNull final h9.a<? extends R> aVar, @NotNull z8.d<? super R> dVar) throws Throwable {
        final p pVar = new p(a9.c.c(dVar), 1);
        pVar.C();
        final ?? r12 = new LifecycleEventObserver() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
                Object objB;
                if (event != Lifecycle.Event.Companion.upTo(state)) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        lifecycle.removeObserver(this);
                        z8.d dVar2 = pVar;
                        t.a aVar2 = t.f35208b;
                        dVar2.resumeWith(t.b(u.a(new LifecycleDestroyedException())));
                        return;
                    }
                    return;
                }
                lifecycle.removeObserver(this);
                z8.d dVar3 = pVar;
                h9.a<R> aVar3 = aVar;
                try {
                    t.a aVar4 = t.f35208b;
                    objB = t.b(aVar3.invoke());
                } catch (Throwable th) {
                    t.a aVar5 = t.f35208b;
                    objB = t.b(u.a(th));
                }
                dVar3.resumeWith(objB);
            }
        };
        if (z10) {
            k0Var.dispatch(z8.h.f37608a, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1
                @Override // java.lang.Runnable
                public final void run() {
                    lifecycle.addObserver(r12);
                }
            });
        } else {
            lifecycle.addObserver(r12);
        }
        pVar.m(new WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2(k0Var, lifecycle, r12));
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ;
    }

    @Nullable
    public static final <R> Object withCreated(@NotNull Lifecycle lifecycle, @NotNull h9.a<? extends R> aVar, @NotNull z8.d<? super R> dVar) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        n2 immediate = e1.c().getImmediate();
        boolean zIsDispatchNeeded = immediate.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, immediate, new AnonymousClass2(aVar), dVar);
    }

    private static final <R> Object withCreated$$forInline(Lifecycle lifecycle, h9.a<? extends R> aVar, z8.d<? super R> dVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        e1.c().getImmediate();
        r.c(3);
        throw null;
    }

    @Nullable
    public static final <R> Object withResumed(@NotNull Lifecycle lifecycle, @NotNull h9.a<? extends R> aVar, @NotNull z8.d<? super R> dVar) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        n2 immediate = e1.c().getImmediate();
        boolean zIsDispatchNeeded = immediate.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, immediate, new AnonymousClass2(aVar), dVar);
    }

    private static final <R> Object withResumed$$forInline(Lifecycle lifecycle, h9.a<? extends R> aVar, z8.d<? super R> dVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        e1.c().getImmediate();
        r.c(3);
        throw null;
    }

    @Nullable
    public static final <R> Object withStarted(@NotNull Lifecycle lifecycle, @NotNull h9.a<? extends R> aVar, @NotNull z8.d<? super R> dVar) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        n2 immediate = e1.c().getImmediate();
        boolean zIsDispatchNeeded = immediate.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, immediate, new AnonymousClass2(aVar), dVar);
    }

    private static final <R> Object withStarted$$forInline(Lifecycle lifecycle, h9.a<? extends R> aVar, z8.d<? super R> dVar) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        e1.c().getImmediate();
        r.c(3);
        throw null;
    }

    @Nullable
    public static final <R> Object withStateAtLeast(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull h9.a<? extends R> aVar, @NotNull z8.d<? super R> dVar) {
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        n2 immediate = e1.c().getImmediate();
        boolean zIsDispatchNeeded = immediate.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, immediate, new AnonymousClass2(aVar), dVar);
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, h9.a<? extends R> aVar, z8.d<? super R> dVar) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            e1.c().getImmediate();
            r.c(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    @Nullable
    public static final <R> Object withStateAtLeastUnchecked(@NotNull Lifecycle lifecycle, @NotNull Lifecycle.State state, @NotNull h9.a<? extends R> aVar, @NotNull z8.d<? super R> dVar) {
        n2 immediate = e1.c().getImmediate();
        boolean zIsDispatchNeeded = immediate.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return aVar.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, immediate, new AnonymousClass2(aVar), dVar);
    }

    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, h9.a<? extends R> aVar, z8.d<? super R> dVar) {
        e1.c().getImmediate();
        r.c(3);
        throw null;
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner lifecycleOwner, h9.a<? extends R> aVar, z8.d<? super R> dVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        e1.c().getImmediate();
        r.c(3);
        throw null;
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner lifecycleOwner, h9.a<? extends R> aVar, z8.d<? super R> dVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        e1.c().getImmediate();
        r.c(3);
        throw null;
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner lifecycleOwner, h9.a<? extends R> aVar, z8.d<? super R> dVar) {
        lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        e1.c().getImmediate();
        r.c(3);
        throw null;
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, h9.a<? extends R> aVar, z8.d<? super R> dVar) {
        lifecycleOwner.getLifecycle();
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        e1.c().getImmediate();
        r.c(3);
        throw null;
    }

    @Nullable
    public static final <R> Object withCreated(@NotNull LifecycleOwner lifecycleOwner, @NotNull h9.a<? extends R> aVar, @NotNull z8.d<? super R> dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.CREATED;
        n2 immediate = e1.c().getImmediate();
        boolean zIsDispatchNeeded = immediate.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, immediate, new AnonymousClass2(aVar), dVar);
    }

    @Nullable
    public static final <R> Object withResumed(@NotNull LifecycleOwner lifecycleOwner, @NotNull h9.a<? extends R> aVar, @NotNull z8.d<? super R> dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.RESUMED;
        n2 immediate = e1.c().getImmediate();
        boolean zIsDispatchNeeded = immediate.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, immediate, new AnonymousClass2(aVar), dVar);
    }

    @Nullable
    public static final <R> Object withStarted(@NotNull LifecycleOwner lifecycleOwner, @NotNull h9.a<? extends R> aVar, @NotNull z8.d<? super R> dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Lifecycle.State state = Lifecycle.State.STARTED;
        n2 immediate = e1.c().getImmediate();
        boolean zIsDispatchNeeded = immediate.isDispatchNeeded(dVar.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return aVar.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, immediate, new AnonymousClass2(aVar), dVar);
    }

    @Nullable
    public static final <R> Object withStateAtLeast(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.State state, @NotNull h9.a<? extends R> aVar, @NotNull z8.d<? super R> dVar) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            n2 immediate = e1.c().getImmediate();
            boolean zIsDispatchNeeded = immediate.isDispatchNeeded(dVar.getContext());
            if (!zIsDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return aVar.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, immediate, new AnonymousClass2(aVar), dVar);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }
}
