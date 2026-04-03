package gatewayprotocol.v1;

import gatewayprotocol.v1.DeveloperConsentOptionKt;
import gatewayprotocol.v1.DeveloperConsentOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: DeveloperConsentOptionKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DeveloperConsentOptionKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializedeveloperConsentOption, reason: not valid java name */
    public static final DeveloperConsentOuterClass.DeveloperConsentOption m4158initializedeveloperConsentOption(@NotNull l<? super DeveloperConsentOptionKt.Dsl, k0> block) {
        t.i(block, "block");
        DeveloperConsentOptionKt.Dsl.Companion companion = DeveloperConsentOptionKt.Dsl.Companion;
        DeveloperConsentOuterClass.DeveloperConsentOption.Builder builderNewBuilder = DeveloperConsentOuterClass.DeveloperConsentOption.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        DeveloperConsentOptionKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final DeveloperConsentOuterClass.DeveloperConsentOption copy(@NotNull DeveloperConsentOuterClass.DeveloperConsentOption developerConsentOption, @NotNull l<? super DeveloperConsentOptionKt.Dsl, k0> block) {
        t.i(developerConsentOption, "<this>");
        t.i(block, "block");
        DeveloperConsentOptionKt.Dsl.Companion companion = DeveloperConsentOptionKt.Dsl.Companion;
        DeveloperConsentOuterClass.DeveloperConsentOption.Builder builder = developerConsentOption.toBuilder();
        t.h(builder, "this.toBuilder()");
        DeveloperConsentOptionKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
