package l8;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PipelinePhaseRelation.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    /* JADX INFO: compiled from: PipelinePhaseRelation.kt */
    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final h f30958a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(@NotNull h relativeTo) {
            super(null);
            t.i(relativeTo, "relativeTo");
            this.f30958a = relativeTo;
        }

        @NotNull
        public final h a() {
            return this.f30958a;
        }
    }

    /* JADX INFO: compiled from: PipelinePhaseRelation.kt */
    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final h f30959a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@NotNull h relativeTo) {
            super(null);
            t.i(relativeTo, "relativeTo");
            this.f30959a = relativeTo;
        }
    }

    /* JADX INFO: compiled from: PipelinePhaseRelation.kt */
    public static final class c extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final c f30960a = new c();

        private c() {
            super(null);
        }
    }

    private i() {
    }

    public /* synthetic */ i(kotlin.jvm.internal.k kVar) {
        this();
    }
}
