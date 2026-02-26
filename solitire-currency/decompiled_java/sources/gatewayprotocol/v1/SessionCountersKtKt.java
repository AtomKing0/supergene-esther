package gatewayprotocol.v1;

import gatewayprotocol.v1.SessionCountersKt;
import gatewayprotocol.v1.SessionCountersOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SessionCountersKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SessionCountersKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializesessionCounters, reason: not valid java name */
    public static final SessionCountersOuterClass.SessionCounters m4193initializesessionCounters(@NotNull l<? super SessionCountersKt.Dsl, k0> block) {
        t.i(block, "block");
        SessionCountersKt.Dsl.Companion companion = SessionCountersKt.Dsl.Companion;
        SessionCountersOuterClass.SessionCounters.Builder builderNewBuilder = SessionCountersOuterClass.SessionCounters.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        SessionCountersKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SessionCountersOuterClass.SessionCounters copy(@NotNull SessionCountersOuterClass.SessionCounters sessionCounters, @NotNull l<? super SessionCountersKt.Dsl, k0> block) {
        t.i(sessionCounters, "<this>");
        t.i(block, "block");
        SessionCountersKt.Dsl.Companion companion = SessionCountersKt.Dsl.Companion;
        SessionCountersOuterClass.SessionCounters.Builder builder = sessionCounters.toBuilder();
        t.h(builder, "this.toBuilder()");
        SessionCountersKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
