package gatewayprotocol.v1;

import gatewayprotocol.v1.DiagnosticEventKt;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import gatewayprotocol.v1.TimestampsOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: DiagnosticEventKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DiagnosticEventKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializediagnosticEvent, reason: not valid java name */
    public static final DiagnosticEventRequestOuterClass.DiagnosticEvent m4160initializediagnosticEvent(@NotNull l<? super DiagnosticEventKt.Dsl, k0> block) {
        t.i(block, "block");
        DiagnosticEventKt.Dsl.Companion companion = DiagnosticEventKt.Dsl.Companion;
        DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder builderNewBuilder = DiagnosticEventRequestOuterClass.DiagnosticEvent.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        DiagnosticEventKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final DiagnosticEventRequestOuterClass.DiagnosticEvent copy(@NotNull DiagnosticEventRequestOuterClass.DiagnosticEvent diagnosticEvent, @NotNull l<? super DiagnosticEventKt.Dsl, k0> block) {
        t.i(diagnosticEvent, "<this>");
        t.i(block, "block");
        DiagnosticEventKt.Dsl.Companion companion = DiagnosticEventKt.Dsl.Companion;
        DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder builder = diagnosticEvent.toBuilder();
        t.h(builder, "this.toBuilder()");
        DiagnosticEventKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final TimestampsOuterClass.Timestamps getTimestampsOrNull(@NotNull DiagnosticEventRequestOuterClass.DiagnosticEventOrBuilder diagnosticEventOrBuilder) {
        t.i(diagnosticEventOrBuilder, "<this>");
        if (diagnosticEventOrBuilder.hasTimestamps()) {
            return diagnosticEventOrBuilder.getTimestamps();
        }
        return null;
    }
}
