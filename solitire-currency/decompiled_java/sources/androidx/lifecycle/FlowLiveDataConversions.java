package androidx.lifecycle;

import androidx.annotation.RequiresApi;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.room.RoomTrackingLiveData;
import h9.p;
import java.time.Duration;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.e1;
import kotlinx.coroutines.n2;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r9.r;
import s9.m0;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: FlowLiveData.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FlowLiveDataConversions {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: FlowLiveData.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", l = {112, 116}, m = "invokeSuspend")
    static final class AnonymousClass1<T> extends kotlin.coroutines.jvm.internal.l implements p<r<? super T>, z8.d<? super k0>, Object> {
        final /* synthetic */ LiveData<T> $this_asFlow;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: FlowLiveData.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
        static final class C01301 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01301(LiveData<T> liveData, Observer<T> observer, z8.d<? super C01301> dVar) {
                super(2, dVar);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new C01301(this.$this_asFlow, this.$observer, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
                this.$this_asFlow.observeForever(this.$observer);
                return k0.f35197a;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                return ((C01301) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: FlowLiveData.kt */
        static final class AnonymousClass2 extends v implements h9.a<k0> {
            final /* synthetic */ Observer<T> $observer;
            final /* synthetic */ LiveData<T> $this_asFlow;

            /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: FlowLiveData.kt */
            @kotlin.coroutines.jvm.internal.f(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2$1", f = "FlowLiveData.kt", l = {}, m = "invokeSuspend")
            static final class C01311 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {
                final /* synthetic */ Observer<T> $observer;
                final /* synthetic */ LiveData<T> $this_asFlow;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C01311(LiveData<T> liveData, Observer<T> observer, z8.d<? super C01311> dVar) {
                    super(2, dVar);
                    this.$this_asFlow = liveData;
                    this.$observer = observer;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @NotNull
                public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                    return new C01311(this.$this_asFlow, this.$observer, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    a9.d.e();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                    this.$this_asFlow.removeObserver(this.$observer);
                    return k0.f35197a;
                }

                @Override // h9.p
                @Nullable
                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                    return ((C01311) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(LiveData<T> liveData, Observer<T> observer) {
                super(0);
                this.$this_asFlow = liveData;
                this.$observer = observer;
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                invoke2();
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                kotlinx.coroutines.k.d(t1.f29982a, e1.c().getImmediate(), null, new C01311(this.$this_asFlow, this.$observer, null), 2, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LiveData<T> liveData, z8.d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$this_asFlow = liveData;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_asFlow, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Observer observer;
            r rVar;
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                final r rVar2 = (r) this.L$0;
                observer = new Observer() { // from class: androidx.lifecycle.e
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj2) {
                        rVar2.f(obj2);
                    }
                };
                n2 immediate = e1.c().getImmediate();
                C01301 c01301 = new C01301(this.$this_asFlow, observer, null);
                this.L$0 = rVar2;
                this.L$1 = observer;
                this.label = 1;
                if (kotlinx.coroutines.i.g(immediate, c01301, this) == objE) {
                    return objE;
                }
                rVar = rVar2;
            } else {
                if (i10 != 1) {
                    if (i10 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    u.b(obj);
                    return k0.f35197a;
                }
                observer = (Observer) this.L$1;
                rVar = (r) this.L$0;
                u.b(obj);
            }
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$this_asFlow, observer);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (r9.p.a(rVar, anonymousClass2, this) == objE) {
                return objE;
            }
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull r<? super T> rVar, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass1) create(rVar, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.lifecycle.FlowLiveDataConversions$asLiveData$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: FlowLiveData.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.lifecycle.FlowLiveDataConversions$asLiveData$1", f = "FlowLiveData.kt", l = {81}, m = "invokeSuspend")
    static final class C10421<T> extends kotlin.coroutines.jvm.internal.l implements p<LiveDataScope<T>, z8.d<? super k0>, Object> {
        final /* synthetic */ s9.h<T> $this_asLiveData;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10421(s9.h<? extends T> hVar, z8.d<? super C10421> dVar) {
            super(2, dVar);
            this.$this_asLiveData = hVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            C10421 c10421 = new C10421(this.$this_asLiveData, dVar);
            c10421.L$0 = obj;
            return c10421;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull LiveDataScope<T> liveDataScope, @Nullable z8.d<? super k0> dVar) {
            return ((C10421) create(liveDataScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                final LiveDataScope liveDataScope = (LiveDataScope) this.L$0;
                s9.h<T> hVar = this.$this_asLiveData;
                s9.i<? super T> iVar = new s9.i() { // from class: androidx.lifecycle.FlowLiveDataConversions.asLiveData.1.1
                    @Override // s9.i
                    @Nullable
                    public final Object emit(T t10, @NotNull z8.d<? super k0> dVar) {
                        Object objEmit = liveDataScope.emit(t10, dVar);
                        return objEmit == a9.d.e() ? objEmit : k0.f35197a;
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
    }

    @NotNull
    public static final <T> s9.h<T> asFlow(@NotNull LiveData<T> liveData) {
        t.i(liveData, "<this>");
        return s9.j.n(s9.j.f(new AnonymousClass1(liveData, null)));
    }

    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull s9.h<? extends T> hVar) {
        t.i(hVar, "<this>");
        return asLiveData$default(hVar, (z8.g) null, 0L, 3, (Object) null);
    }

    public static /* synthetic */ LiveData asLiveData$default(s9.h hVar, z8.g gVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            gVar = z8.h.f37608a;
        }
        if ((i10 & 2) != 0) {
            j10 = 5000;
        }
        return asLiveData(hVar, gVar, j10);
    }

    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull s9.h<? extends T> hVar, @NotNull z8.g context) {
        t.i(hVar, "<this>");
        t.i(context, "context");
        return asLiveData$default(hVar, context, 0L, 2, (Object) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull s9.h<? extends T> hVar, @NotNull z8.g context, long j10) {
        t.i(hVar, "<this>");
        t.i(context, "context");
        RoomTrackingLiveData roomTrackingLiveData = (LiveData<T>) CoroutineLiveDataKt.liveData(context, j10, new C10421(hVar, null));
        if (hVar instanceof m0) {
            if (ArchTaskExecutor.getInstance().isMainThread()) {
                roomTrackingLiveData.setValue(((m0) hVar).getValue());
            } else {
                roomTrackingLiveData.postValue(((m0) hVar).getValue());
            }
        }
        return roomTrackingLiveData;
    }

    public static /* synthetic */ LiveData asLiveData$default(s9.h hVar, Duration duration, z8.g gVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            gVar = z8.h.f37608a;
        }
        return asLiveData(hVar, duration, gVar);
    }

    @RequiresApi(26)
    @NotNull
    public static final <T> LiveData<T> asLiveData(@NotNull s9.h<? extends T> hVar, @NotNull Duration timeout, @NotNull z8.g context) {
        t.i(hVar, "<this>");
        t.i(timeout, "timeout");
        t.i(context, "context");
        return asLiveData(hVar, context, Api26Impl.INSTANCE.toMillis(timeout));
    }
}
