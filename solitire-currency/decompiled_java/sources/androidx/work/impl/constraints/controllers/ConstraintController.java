package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import h9.a;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r9.r;
import s9.h;
import s9.j;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: ContraintControllers.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ConstraintController<T> {

    @NotNull
    private final ConstraintTracker<T> tracker;

    /* JADX INFO: renamed from: androidx.work.impl.constraints.controllers.ConstraintController$track$1, reason: invalid class name */
    /* JADX INFO: compiled from: ContraintControllers.kt */
    @f(c = "androidx.work.impl.constraints.controllers.ConstraintController$track$1", f = "ContraintControllers.kt", l = {55}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<r<? super ConstraintsState>, d<? super k0>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ConstraintController<T> this$0;

        /* JADX INFO: renamed from: androidx.work.impl.constraints.controllers.ConstraintController$track$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: ContraintControllers.kt */
        static final class C01421 extends v implements a<k0> {
            final /* synthetic */ ConstraintController$track$1$listener$1 $listener;
            final /* synthetic */ ConstraintController<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C01421(ConstraintController constraintController, ConstraintController$track$1$listener$1 constraintController$track$1$listener$1) {
                super(0);
                this.this$0 = constraintController;
                this.$listener = constraintController$track$1$listener$1;
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                invoke2();
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ((ConstraintController) this.this$0).tracker.removeListener(this.$listener);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ConstraintController<T> constraintController, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.this$0 = constraintController;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                final r rVar = (r) this.L$0;
                final ConstraintController<T> constraintController = this.this$0;
                ConstraintListener<T> constraintListener = new ConstraintListener<T>() { // from class: androidx.work.impl.constraints.controllers.ConstraintController$track$1$listener$1
                    @Override // androidx.work.impl.constraints.ConstraintListener
                    public void onConstraintChanged(T t10) {
                        rVar.a().f(constraintController.isConstrained(t10) ? new ConstraintsState.ConstraintsNotMet(constraintController.getReason()) : ConstraintsState.ConstraintsMet.INSTANCE);
                    }
                };
                ((ConstraintController) this.this$0).tracker.addListener(constraintListener);
                C01421 c01421 = new C01421(this.this$0, constraintListener);
                this.label = 1;
                if (r9.p.a(rVar, c01421, this) == objE) {
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
        public final Object mo4invoke(@NotNull r<? super ConstraintsState> rVar, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass1) create(rVar, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public ConstraintController(@NotNull ConstraintTracker<T> tracker) {
        t.i(tracker, "tracker");
        this.tracker = tracker;
    }

    public abstract int getReason();

    public abstract boolean hasConstraint(@NotNull WorkSpec workSpec);

    public final boolean isConstrained(@NotNull WorkSpec workSpec) {
        t.i(workSpec, "workSpec");
        return hasConstraint(workSpec) && isConstrained(this.tracker.readSystemState());
    }

    public abstract boolean isConstrained(T t10);

    @NotNull
    public final h<ConstraintsState> track() {
        return j.f(new AnonymousClass1(this, null));
    }

    public static /* synthetic */ void getReason$annotations() {
    }
}
