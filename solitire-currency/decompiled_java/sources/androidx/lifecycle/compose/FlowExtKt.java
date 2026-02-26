package androidx.lifecycle.compose;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ProduceStateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.RepeatOnLifecycleKt;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import s9.i;
import s9.m0;
import v8.k0;
import v8.u;
import z8.d;
import z8.g;

/* JADX INFO: compiled from: FlowExt.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FlowExtKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1, reason: invalid class name */
    /* JADX INFO: compiled from: FlowExt.kt */
    @f(c = "androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1", f = "FlowExt.kt", l = {171}, m = "invokeSuspend")
    static final class AnonymousClass1<T> extends l implements p<ProduceStateScope<T>, d<? super k0>, Object> {
        final /* synthetic */ g $context;
        final /* synthetic */ Lifecycle $lifecycle;
        final /* synthetic */ Lifecycle.State $minActiveState;
        final /* synthetic */ h<T> $this_collectAsStateWithLifecycle;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: FlowExt.kt */
        @f(c = "androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1$1", f = "FlowExt.kt", l = {173, 174}, m = "invokeSuspend")
        static final class C01341 extends l implements p<o0, d<? super k0>, Object> {
            final /* synthetic */ ProduceStateScope<T> $$this$produceState;
            final /* synthetic */ g $context;
            final /* synthetic */ h<T> $this_collectAsStateWithLifecycle;
            int label;

            /* JADX INFO: renamed from: androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: FlowExt.kt */
            @f(c = "androidx.lifecycle.compose.FlowExtKt$collectAsStateWithLifecycle$1$1$2", f = "FlowExt.kt", l = {175}, m = "invokeSuspend")
            static final class AnonymousClass2 extends l implements p<o0, d<? super k0>, Object> {
                final /* synthetic */ ProduceStateScope<T> $$this$produceState;
                final /* synthetic */ h<T> $this_collectAsStateWithLifecycle;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                AnonymousClass2(h<? extends T> hVar, ProduceStateScope<T> produceStateScope, d<? super AnonymousClass2> dVar) {
                    super(2, dVar);
                    this.$this_collectAsStateWithLifecycle = hVar;
                    this.$$this$produceState = produceStateScope;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                    return new AnonymousClass2(this.$this_collectAsStateWithLifecycle, this.$$this$produceState, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    Object objE = a9.d.e();
                    int i10 = this.label;
                    if (i10 == 0) {
                        u.b(obj);
                        h<T> hVar = this.$this_collectAsStateWithLifecycle;
                        final ProduceStateScope<T> produceStateScope = this.$$this$produceState;
                        i<? super T> iVar = new i() { // from class: androidx.lifecycle.compose.FlowExtKt.collectAsStateWithLifecycle.1.1.2.1
                            @Override // s9.i
                            @Nullable
                            public final Object emit(T t10, @NotNull d<? super k0> dVar) {
                                produceStateScope.setValue(t10);
                                return k0.f35197a;
                            }
                        };
                        this.label = 1;
                        if (hVar.collect(iVar, this) == objE) {
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
                    return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C01341(g gVar, h<? extends T> hVar, ProduceStateScope<T> produceStateScope, d<? super C01341> dVar) {
                super(2, dVar);
                this.$context = gVar;
                this.$this_collectAsStateWithLifecycle = hVar;
                this.$$this$produceState = produceStateScope;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
                return new C01341(this.$context, this.$this_collectAsStateWithLifecycle, this.$$this$produceState, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                if (i10 == 0) {
                    u.b(obj);
                    if (t.d(this.$context, z8.h.f37608a)) {
                        h<T> hVar = this.$this_collectAsStateWithLifecycle;
                        final ProduceStateScope<T> produceStateScope = this.$$this$produceState;
                        i<? super T> iVar = new i() { // from class: androidx.lifecycle.compose.FlowExtKt.collectAsStateWithLifecycle.1.1.1
                            @Override // s9.i
                            @Nullable
                            public final Object emit(T t10, @NotNull d<? super k0> dVar) {
                                produceStateScope.setValue(t10);
                                return k0.f35197a;
                            }
                        };
                        this.label = 1;
                        if (hVar.collect(iVar, this) == objE) {
                            return objE;
                        }
                    } else {
                        g gVar = this.$context;
                        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_collectAsStateWithLifecycle, this.$$this$produceState, null);
                        this.label = 2;
                        if (kotlinx.coroutines.i.g(gVar, anonymousClass2, this) == objE) {
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

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
                return ((C01341) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, g gVar, h<? extends T> hVar, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$lifecycle = lifecycle;
            this.$minActiveState = state;
            this.$context = gVar;
            this.$this_collectAsStateWithLifecycle = hVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$lifecycle, this.$minActiveState, this.$context, this.$this_collectAsStateWithLifecycle, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull ProduceStateScope<T> produceStateScope, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass1) create(produceStateScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                ProduceStateScope produceStateScope = (ProduceStateScope) this.L$0;
                Lifecycle lifecycle = this.$lifecycle;
                Lifecycle.State state = this.$minActiveState;
                C01341 c01341 = new C01341(this.$context, this.$this_collectAsStateWithLifecycle, produceStateScope, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, c01341, this) == objE) {
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
    }

    @Composable
    @NotNull
    public static final <T> State<T> collectAsStateWithLifecycle(@NotNull m0<? extends T> m0Var, @Nullable LifecycleOwner lifecycleOwner, @Nullable Lifecycle.State state, @Nullable g gVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(743249048);
        if ((i11 & 1) != 0) {
            lifecycleOwner = (LifecycleOwner) composer.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        }
        if ((i11 & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        Lifecycle.State state2 = state;
        if ((i11 & 4) != 0) {
            gVar = z8.h.f37608a;
        }
        State<T> stateCollectAsStateWithLifecycle = collectAsStateWithLifecycle(m0Var, m0Var.getValue(), lifecycleOwner.getLifecycle(), state2, gVar, composer, ((i10 << 3) & 7168) | 33288, 0);
        composer.endReplaceableGroup();
        return stateCollectAsStateWithLifecycle;
    }

    @Composable
    @NotNull
    public static final <T> State<T> collectAsStateWithLifecycle(@NotNull m0<? extends T> m0Var, @NotNull Lifecycle lifecycle, @Nullable Lifecycle.State state, @Nullable g gVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(-1858162195);
        if ((i11 & 2) != 0) {
            state = Lifecycle.State.STARTED;
        }
        Lifecycle.State state2 = state;
        if ((i11 & 4) != 0) {
            gVar = z8.h.f37608a;
        }
        State<T> stateCollectAsStateWithLifecycle = collectAsStateWithLifecycle(m0Var, m0Var.getValue(), lifecycle, state2, gVar, composer, ((i10 << 3) & 7168) | 33288, 0);
        composer.endReplaceableGroup();
        return stateCollectAsStateWithLifecycle;
    }

    @Composable
    @NotNull
    public static final <T> State<T> collectAsStateWithLifecycle(@NotNull h<? extends T> hVar, T t10, @Nullable LifecycleOwner lifecycleOwner, @Nullable Lifecycle.State state, @Nullable g gVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(-1485997211);
        if ((i11 & 2) != 0) {
            lifecycleOwner = (LifecycleOwner) composer.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner());
        }
        if ((i11 & 4) != 0) {
            state = Lifecycle.State.STARTED;
        }
        Lifecycle.State state2 = state;
        if ((i11 & 8) != 0) {
            gVar = z8.h.f37608a;
        }
        State<T> stateCollectAsStateWithLifecycle = collectAsStateWithLifecycle(hVar, t10, lifecycleOwner.getLifecycle(), state2, gVar, composer, (((i10 >> 3) & 8) << 3) | 33288 | (i10 & 112) | (i10 & 7168), 0);
        composer.endReplaceableGroup();
        return stateCollectAsStateWithLifecycle;
    }

    @Composable
    @NotNull
    public static final <T> State<T> collectAsStateWithLifecycle(@NotNull h<? extends T> hVar, T t10, @NotNull Lifecycle lifecycle, @Nullable Lifecycle.State state, @Nullable g gVar, @Nullable Composer composer, int i10, int i11) {
        composer.startReplaceableGroup(1977777920);
        if ((i11 & 4) != 0) {
            state = Lifecycle.State.STARTED;
        }
        Lifecycle.State state2 = state;
        if ((i11 & 8) != 0) {
            gVar = z8.h.f37608a;
        }
        g gVar2 = gVar;
        Object[] objArr = {hVar, lifecycle, state2, gVar2};
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(lifecycle, state2, gVar2, hVar, null);
        int i12 = i10 >> 3;
        State<T> stateProduceState = SnapshotStateKt.produceState((Object) t10, objArr, (p) anonymousClass1, composer, (i12 & 14) | (i12 & 8) | 576);
        composer.endReplaceableGroup();
        return stateProduceState;
    }
}
