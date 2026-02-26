package gatewayprotocol.v1;

import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.DiagnosticTagKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: DiagnosticTagKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DiagnosticTagKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializediagnosticTag, reason: not valid java name */
    public static final DiagnosticEventRequestOuterClass.DiagnosticTag m4163initializediagnosticTag(@NotNull l<? super DiagnosticTagKt.Dsl, k0> block) {
        t.i(block, "block");
        DiagnosticTagKt.Dsl.Companion companion = DiagnosticTagKt.Dsl.Companion;
        DiagnosticEventRequestOuterClass.DiagnosticTag.Builder builderNewBuilder = DiagnosticEventRequestOuterClass.DiagnosticTag.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        DiagnosticTagKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final DiagnosticEventRequestOuterClass.DiagnosticTag copy(@NotNull DiagnosticEventRequestOuterClass.DiagnosticTag diagnosticTag, @NotNull l<? super DiagnosticTagKt.Dsl, k0> block) {
        t.i(diagnosticTag, "<this>");
        t.i(block, "block");
        DiagnosticTagKt.Dsl.Companion companion = DiagnosticTagKt.Dsl.Companion;
        DiagnosticEventRequestOuterClass.DiagnosticTag.Builder builder = diagnosticTag.toBuilder();
        t.h(builder, "this.toBuilder()");
        DiagnosticTagKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
