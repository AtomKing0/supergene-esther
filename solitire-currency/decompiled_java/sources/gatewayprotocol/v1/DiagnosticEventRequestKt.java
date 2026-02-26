package gatewayprotocol.v1;

import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DiagnosticEventRequestKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DiagnosticEventRequestKt {

    @NotNull
    public static final DiagnosticEventRequestKt INSTANCE = new DiagnosticEventRequestKt();

    /* JADX INFO: compiled from: DiagnosticEventRequestKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final DiagnosticEventRequestOuterClass.DiagnosticEventRequest.Builder _builder;

        /* JADX INFO: compiled from: DiagnosticEventRequestKt.kt */
        public static final class BatchProxy extends DslProxy {
            private BatchProxy() {
            }
        }

        /* JADX INFO: compiled from: DiagnosticEventRequestKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(DiagnosticEventRequestOuterClass.DiagnosticEventRequest.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(DiagnosticEventRequestOuterClass.DiagnosticEventRequest.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ DiagnosticEventRequestOuterClass.DiagnosticEventRequest _build() {
            DiagnosticEventRequestOuterClass.DiagnosticEventRequest diagnosticEventRequestBuild = this._builder.build();
            t.h(diagnosticEventRequestBuild, "_builder.build()");
            return diagnosticEventRequestBuild;
        }

        public final /* synthetic */ void addAllBatch(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllBatch(values);
        }

        public final /* synthetic */ void addBatch(DslList dslList, DiagnosticEventRequestOuterClass.DiagnosticEvent value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addBatch(value);
        }

        public final /* synthetic */ void clearBatch(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearBatch();
        }

        public final /* synthetic */ DslList getBatch() {
            List<DiagnosticEventRequestOuterClass.DiagnosticEvent> batchList = this._builder.getBatchList();
            t.h(batchList, "_builder.getBatchList()");
            return new DslList(batchList);
        }

        public final /* synthetic */ void plusAssignAllBatch(DslList<DiagnosticEventRequestOuterClass.DiagnosticEvent, BatchProxy> dslList, Iterable<DiagnosticEventRequestOuterClass.DiagnosticEvent> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllBatch(dslList, values);
        }

        public final /* synthetic */ void plusAssignBatch(DslList<DiagnosticEventRequestOuterClass.DiagnosticEvent, BatchProxy> dslList, DiagnosticEventRequestOuterClass.DiagnosticEvent value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addBatch(dslList, value);
        }

        public final /* synthetic */ void setBatch(DslList dslList, int i10, DiagnosticEventRequestOuterClass.DiagnosticEvent value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.setBatch(i10, value);
        }

        private Dsl(DiagnosticEventRequestOuterClass.DiagnosticEventRequest.Builder builder) {
            this._builder = builder;
        }
    }

    private DiagnosticEventRequestKt() {
    }
}
