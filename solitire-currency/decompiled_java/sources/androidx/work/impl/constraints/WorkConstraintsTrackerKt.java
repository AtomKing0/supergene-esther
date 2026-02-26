package androidx.work.impl.constraints;

import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.a0;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.h2;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import s9.h;
import s9.i;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: WorkConstraintsTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WorkConstraintsTrackerKt {

    @NotNull
    private static final String TAG;

    /* JADX INFO: renamed from: androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1, reason: invalid class name */
    /* JADX INFO: compiled from: WorkConstraintsTracker.kt */
    @f(c = "androidx.work.impl.constraints.WorkConstraintsTrackerKt$listen$1", f = "WorkConstraintsTracker.kt", l = {54}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ OnConstraintsStateChangedListener $listener;
        final /* synthetic */ WorkSpec $spec;
        final /* synthetic */ WorkConstraintsTracker $this_listen;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(WorkConstraintsTracker workConstraintsTracker, WorkSpec workSpec, OnConstraintsStateChangedListener onConstraintsStateChangedListener, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$this_listen = workConstraintsTracker;
            this.$spec = workSpec;
            this.$listener = onConstraintsStateChangedListener;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass1(this.$this_listen, this.$spec, this.$listener, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                h<ConstraintsState> hVarTrack = this.$this_listen.track(this.$spec);
                final OnConstraintsStateChangedListener onConstraintsStateChangedListener = this.$listener;
                final WorkSpec workSpec = this.$spec;
                i<? super ConstraintsState> iVar = new i() { // from class: androidx.work.impl.constraints.WorkConstraintsTrackerKt.listen.1.1
                    @Nullable
                    public final Object emit(@NotNull ConstraintsState constraintsState, @NotNull d<? super k0> dVar) {
                        onConstraintsStateChangedListener.onConstraintsStateChanged(workSpec, constraintsState);
                        return k0.f35197a;
                    }

                    @Override // s9.i
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, d dVar) {
                        return emit((ConstraintsState) obj2, (d<? super k0>) dVar);
                    }
                };
                this.label = 1;
                if (hVarTrack.collect(iVar, this) == objE) {
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
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    static {
        String strTagWithPrefix = Logger.tagWithPrefix("WorkConstraintsTracker");
        t.h(strTagWithPrefix, "tagWithPrefix(\"WorkConstraintsTracker\")");
        TAG = strTagWithPrefix;
    }

    @NotNull
    public static final b2 listen(@NotNull WorkConstraintsTracker workConstraintsTracker, @NotNull WorkSpec spec, @NotNull kotlinx.coroutines.k0 dispatcher, @NotNull OnConstraintsStateChangedListener listener) {
        t.i(workConstraintsTracker, "<this>");
        t.i(spec, "spec");
        t.i(dispatcher, "dispatcher");
        t.i(listener, "listener");
        a0 a0VarB = h2.b(null, 1, null);
        k.d(p0.a(dispatcher.plus(a0VarB)), null, null, new AnonymousClass1(workConstraintsTracker, spec, listener, null), 3, null);
        return a0VarB;
    }
}
