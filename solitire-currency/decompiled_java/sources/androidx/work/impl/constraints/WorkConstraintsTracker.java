package androidx.work.impl.constraints;

import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.controllers.BatteryChargingController;
import androidx.work.impl.constraints.controllers.BatteryNotLowController;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.controllers.NetworkConnectedController;
import androidx.work.impl.constraints.controllers.NetworkMeteredController;
import androidx.work.impl.constraints.controllers.NetworkNotRoamingController;
import androidx.work.impl.constraints.controllers.NetworkUnmeteredController;
import androidx.work.impl.constraints.controllers.StorageNotLowController;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import h9.a;
import h9.l;
import h9.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.d0;
import kotlin.collections.w;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import s9.i;
import s9.j;
import t9.k;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: WorkConstraintsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WorkConstraintsTracker {

    @NotNull
    private final List<ConstraintController<?>> controllers;

    /* JADX INFO: renamed from: androidx.work.impl.constraints.WorkConstraintsTracker$areAllConstraintsMet$1, reason: invalid class name */
    /* JADX INFO: compiled from: WorkConstraintsTracker.kt */
    static final class AnonymousClass1 extends v implements l<ConstraintController<?>, CharSequence> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        @NotNull
        public final CharSequence invoke(@NotNull ConstraintController<?> it) {
            t.i(it, "it");
            String simpleName = it.getClass().getSimpleName();
            t.h(simpleName, "it.javaClass.simpleName");
            return simpleName;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WorkConstraintsTracker(@NotNull List<? extends ConstraintController<?>> controllers) {
        t.i(controllers, "controllers");
        this.controllers = controllers;
    }

    public final boolean areAllConstraintsMet(@NotNull WorkSpec workSpec) {
        t.i(workSpec, "workSpec");
        List<ConstraintController<?>> list = this.controllers;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ConstraintController) obj).isConstrained(workSpec)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            Logger.get().debug(WorkConstraintsTrackerKt.TAG, "Work " + workSpec.id + " constrained by " + d0.r0(arrayList, null, null, null, 0, null, AnonymousClass1.INSTANCE, 31, null));
        }
        return arrayList.isEmpty();
    }

    @NotNull
    public final h<ConstraintsState> track(@NotNull WorkSpec spec) {
        t.i(spec, "spec");
        List<ConstraintController<?>> list = this.controllers;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((ConstraintController) obj).hasConstraint(spec)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(w.v(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((ConstraintController) it.next()).track());
        }
        final h[] hVarArr = (h[]) d0.P0(arrayList2).toArray(new h[0]);
        return j.p(new h<ConstraintsState>() { // from class: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1

            /* JADX INFO: renamed from: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: Zip.kt */
            static final class AnonymousClass2 extends v implements a<ConstraintsState[]> {
                final /* synthetic */ h[] $flowArray;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(h[] hVarArr) {
                    super(0);
                    this.$flowArray = hVarArr;
                }

                @Override // h9.a
                @Nullable
                public final ConstraintsState[] invoke() {
                    return new ConstraintsState[this.$flowArray.length];
                }
            }

            /* JADX INFO: renamed from: androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3, reason: invalid class name */
            /* JADX INFO: compiled from: Zip.kt */
            @f(c = "androidx.work.impl.constraints.WorkConstraintsTracker$track$$inlined$combine$1$3", f = "WorkConstraintsTracker.kt", l = {292}, m = "invokeSuspend")
            public static final class AnonymousClass3 extends kotlin.coroutines.jvm.internal.l implements q<i<? super ConstraintsState>, ConstraintsState[], d<? super k0>, Object> {
                private /* synthetic */ Object L$0;
                /* synthetic */ Object L$1;
                int label;

                public AnonymousClass3(d dVar) {
                    super(3, dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    ConstraintsState constraintsState;
                    Object objE = a9.d.e();
                    int i10 = this.label;
                    if (i10 == 0) {
                        u.b(obj);
                        i iVar = (i) this.L$0;
                        ConstraintsState[] constraintsStateArr = (ConstraintsState[]) ((Object[]) this.L$1);
                        int length = constraintsStateArr.length;
                        int i11 = 0;
                        while (true) {
                            if (i11 >= length) {
                                constraintsState = null;
                                break;
                            }
                            constraintsState = constraintsStateArr[i11];
                            if (!t.d(constraintsState, ConstraintsState.ConstraintsMet.INSTANCE)) {
                                break;
                            }
                            i11++;
                        }
                        if (constraintsState == null) {
                            constraintsState = ConstraintsState.ConstraintsMet.INSTANCE;
                        }
                        this.label = 1;
                        if (iVar.emit(constraintsState, this) == objE) {
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

                @Override // h9.q
                @Nullable
                public final Object invoke(@NotNull i<? super ConstraintsState> iVar, @NotNull ConstraintsState[] constraintsStateArr, @Nullable d<? super k0> dVar) {
                    AnonymousClass3 anonymousClass3 = new AnonymousClass3(dVar);
                    anonymousClass3.L$0 = iVar;
                    anonymousClass3.L$1 = constraintsStateArr;
                    return anonymousClass3.invokeSuspend(k0.f35197a);
                }
            }

            @Override // s9.h
            @Nullable
            public Object collect(@NotNull i<? super ConstraintsState> iVar, @NotNull d dVar) {
                h[] hVarArr2 = hVarArr;
                Object objA = k.a(iVar, hVarArr2, new AnonymousClass2(hVarArr2), new AnonymousClass3(null), dVar);
                return objA == a9.d.e() ? objA : k0.f35197a;
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WorkConstraintsTracker(@NotNull Trackers trackers) {
        this((List<? extends ConstraintController<?>>) kotlin.collections.v.n(new BatteryChargingController(trackers.getBatteryChargingTracker()), new BatteryNotLowController(trackers.getBatteryNotLowTracker()), new StorageNotLowController(trackers.getStorageNotLowTracker()), new NetworkConnectedController(trackers.getNetworkStateTracker()), new NetworkUnmeteredController(trackers.getNetworkStateTracker()), new NetworkNotRoamingController(trackers.getNetworkStateTracker()), new NetworkMeteredController(trackers.getNetworkStateTracker())));
        t.i(trackers, "trackers");
    }
}
