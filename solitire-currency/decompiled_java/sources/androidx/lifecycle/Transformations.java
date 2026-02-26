package androidx.lifecycle;

import androidx.annotation.CheckResult;
import androidx.annotation.MainThread;
import androidx.arch.core.util.Function;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: Transformations.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Transformations {

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* JADX INFO: renamed from: androidx.lifecycle.Transformations$distinctUntilChanged$1, reason: invalid class name */
    /* JADX INFO: compiled from: Transformations.kt */
    static final class AnonymousClass1<X> extends v implements h9.l<X, k0> {
        final /* synthetic */ i0 $firstTime;
        final /* synthetic */ MediatorLiveData<X> $outputLiveData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MediatorLiveData<X> mediatorLiveData, i0 i0Var) {
            super(1);
            this.$outputLiveData = mediatorLiveData;
            this.$firstTime = i0Var;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Object obj) {
            invoke2(obj);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(X x10) {
            X value = this.$outputLiveData.getValue();
            if (this.$firstTime.f29826a || ((value == null && x10 != null) || !(value == null || t.d(value, x10)))) {
                this.$firstTime.f29826a = false;
                this.$outputLiveData.setValue(x10);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* JADX INFO: renamed from: androidx.lifecycle.Transformations$map$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transformations.kt */
    static final class C10461<X> extends v implements h9.l<X, k0> {
        final /* synthetic */ MediatorLiveData<Y> $result;
        final /* synthetic */ h9.l<X, Y> $transform;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10461(MediatorLiveData<Y> mediatorLiveData, h9.l<X, Y> lVar) {
            super(1);
            this.$result = mediatorLiveData;
            this.$transform = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Object obj) {
            invoke2(obj);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(X x10) {
            this.$result.setValue(this.$transform.invoke(x10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: androidx.lifecycle.Transformations$map$2, reason: invalid class name */
    /* JADX INFO: compiled from: Transformations.kt */
    public static final class AnonymousClass2 extends v implements h9.l {
        final /* synthetic */ Function $mapFunction;
        final /* synthetic */ MediatorLiveData $result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MediatorLiveData mediatorLiveData, Function function) {
            super(1);
            this.$result = mediatorLiveData;
            this.$mapFunction = function;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m3932invoke(obj);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m3932invoke(Object obj) {
            this.$result.setValue(this.$mapFunction.apply(obj));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* JADX INFO: renamed from: androidx.lifecycle.Transformations$switchMap$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transformations.kt */
    static final class C10471<X> extends v implements h9.l<X, k0> {
        final /* synthetic */ n0<LiveData<Y>> $liveData;
        final /* synthetic */ MediatorLiveData<Y> $result;
        final /* synthetic */ h9.l<X, LiveData<Y>> $transform;

        /* JADX INFO: Add missing generic type declarations: [Y] */
        /* JADX INFO: renamed from: androidx.lifecycle.Transformations$switchMap$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Transformations.kt */
        static final class C01331<Y> extends v implements h9.l<Y, k0> {
            final /* synthetic */ MediatorLiveData<Y> $result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01331(MediatorLiveData<Y> mediatorLiveData) {
                super(1);
                this.$result = mediatorLiveData;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(Object obj) {
                invoke2(obj);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Y y10) {
                this.$result.setValue(y10);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10471(h9.l<X, LiveData<Y>> lVar, n0<LiveData<Y>> n0Var, MediatorLiveData<Y> mediatorLiveData) {
            super(1);
            this.$transform = lVar;
            this.$liveData = n0Var;
            this.$result = mediatorLiveData;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Object obj) {
            invoke2(obj);
            return k0.f35197a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v2, types: [T, androidx.lifecycle.LiveData, java.lang.Object] */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(X x10) {
            ?? r42 = (LiveData) this.$transform.invoke(x10);
            T t10 = this.$liveData.f29834a;
            if (t10 != r42) {
                if (t10 != 0) {
                    MediatorLiveData<Y> mediatorLiveData = this.$result;
                    t.f(t10);
                    mediatorLiveData.removeSource((LiveData) t10);
                }
                this.$liveData.f29834a = r42;
                if (r42 != 0) {
                    MediatorLiveData<Y> mediatorLiveData2 = this.$result;
                    t.f(r42);
                    mediatorLiveData2.addSource(r42, new Transformations$sam$androidx_lifecycle_Observer$0(new C01331(this.$result)));
                }
            }
        }
    }

    @CheckResult
    @MainThread
    @NotNull
    public static final <X> LiveData<X> distinctUntilChanged(@NotNull LiveData<X> liveData) {
        t.i(liveData, "<this>");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        i0 i0Var = new i0();
        i0Var.f29826a = true;
        if (liveData.isInitialized()) {
            mediatorLiveData.setValue(liveData.getValue());
            i0Var.f29826a = false;
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new AnonymousClass1(mediatorLiveData, i0Var)));
        return mediatorLiveData;
    }

    @CheckResult
    @MainThread
    @NotNull
    public static final <X, Y> LiveData<Y> map(@NotNull LiveData<X> liveData, @NotNull h9.l<X, Y> transform) {
        t.i(liveData, "<this>");
        t.i(transform, "transform");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        if (liveData.isInitialized()) {
            mediatorLiveData.setValue(transform.invoke(liveData.getValue()));
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new C10461(mediatorLiveData, transform)));
        return mediatorLiveData;
    }

    @CheckResult
    @MainThread
    @NotNull
    public static final <X, Y> LiveData<Y> switchMap(@NotNull LiveData<X> liveData, @NotNull h9.l<X, LiveData<Y>> transform) {
        LiveData<Y> liveDataInvoke;
        t.i(liveData, "<this>");
        t.i(transform, "transform");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        n0 n0Var = new n0();
        if (liveData.isInitialized() && (liveDataInvoke = transform.invoke(liveData.getValue())) != null && liveDataInvoke.isInitialized()) {
            mediatorLiveData.setValue(liveDataInvoke.getValue());
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new C10471(transform, n0Var, mediatorLiveData)));
        return mediatorLiveData;
    }

    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData map(LiveData liveData, Function mapFunction) {
        t.i(liveData, "<this>");
        t.i(mapFunction, "mapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new AnonymousClass2(mediatorLiveData, mapFunction)));
        return mediatorLiveData;
    }

    @CheckResult
    @MainThread
    public static final /* synthetic */ LiveData switchMap(LiveData liveData, final Function switchMapFunction) {
        t.i(liveData, "<this>");
        t.i(switchMapFunction, "switchMapFunction");
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Observer() { // from class: androidx.lifecycle.Transformations.switchMap.2

            @Nullable
            private LiveData liveData;

            @Nullable
            public final LiveData getLiveData() {
                return this.liveData;
            }

            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                LiveData liveData2 = (LiveData) switchMapFunction.apply(obj);
                LiveData liveData3 = this.liveData;
                if (liveData3 == liveData2) {
                    return;
                }
                if (liveData3 != null) {
                    MediatorLiveData mediatorLiveData2 = mediatorLiveData;
                    t.f(liveData3);
                    mediatorLiveData2.removeSource(liveData3);
                }
                this.liveData = liveData2;
                if (liveData2 != null) {
                    MediatorLiveData mediatorLiveData3 = mediatorLiveData;
                    t.f(liveData2);
                    mediatorLiveData3.addSource(liveData2, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$switchMap$2$onChanged$1(mediatorLiveData)));
                }
            }

            public final void setLiveData(@Nullable LiveData liveData2) {
                this.liveData = liveData2;
            }
        });
        return mediatorLiveData;
    }
}
