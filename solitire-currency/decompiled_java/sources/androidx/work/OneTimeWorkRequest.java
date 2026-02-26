package androidx.work;

import androidx.work.WorkRequest;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.w;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OneTimeWorkRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OneTimeWorkRequest extends WorkRequest {

    @NotNull
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: OneTimeWorkRequest.kt */
    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(@NotNull Class<? extends ListenableWorker> workerClass) {
            super(workerClass);
            t.i(workerClass, "workerClass");
        }

        @Override // androidx.work.WorkRequest.Builder
        @NotNull
        public Builder getThisObject$work_runtime_release() {
            return this;
        }

        @NotNull
        public final Builder setInputMerger(@NotNull Class<? extends InputMerger> inputMerger) {
            t.i(inputMerger, "inputMerger");
            WorkSpec workSpec$work_runtime_release = getWorkSpec$work_runtime_release();
            String name = inputMerger.getName();
            t.h(name, "inputMerger.name");
            workSpec$work_runtime_release.inputMergerClassName = name;
            return this;
        }

        @Override // androidx.work.WorkRequest.Builder
        @NotNull
        public OneTimeWorkRequest buildInternal$work_runtime_release() {
            if ((getBackoffCriteriaSet$work_runtime_release() && getWorkSpec$work_runtime_release().constraints.requiresDeviceIdle()) ? false : true) {
                return new OneTimeWorkRequest(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job".toString());
        }
    }

    /* JADX INFO: compiled from: OneTimeWorkRequest.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final OneTimeWorkRequest from(@NotNull Class<? extends ListenableWorker> workerClass) {
            t.i(workerClass, "workerClass");
            return new Builder(workerClass).build();
        }

        @NotNull
        public final List<OneTimeWorkRequest> from(@NotNull List<? extends Class<? extends ListenableWorker>> workerClasses) {
            t.i(workerClasses, "workerClasses");
            List<? extends Class<? extends ListenableWorker>> list = workerClasses;
            ArrayList arrayList = new ArrayList(w.v(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new Builder((Class) it.next()).build());
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OneTimeWorkRequest(@NotNull Builder builder) {
        super(builder.getId$work_runtime_release(), builder.getWorkSpec$work_runtime_release(), builder.getTags$work_runtime_release());
        t.i(builder, "builder");
    }

    @NotNull
    public static final OneTimeWorkRequest from(@NotNull Class<? extends ListenableWorker> cls) {
        return Companion.from(cls);
    }

    @NotNull
    public static final List<OneTimeWorkRequest> from(@NotNull List<? extends Class<? extends ListenableWorker>> list) {
        return Companion.from(list);
    }
}
