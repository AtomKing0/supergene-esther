package gatewayprotocol.v1;

import gatewayprotocol.v1.DeveloperConsentKt;
import gatewayprotocol.v1.DeveloperConsentOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: DeveloperConsentKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DeveloperConsentKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializedeveloperConsent, reason: not valid java name */
    public static final DeveloperConsentOuterClass.DeveloperConsent m4157initializedeveloperConsent(@NotNull l<? super DeveloperConsentKt.Dsl, k0> block) {
        t.i(block, "block");
        DeveloperConsentKt.Dsl.Companion companion = DeveloperConsentKt.Dsl.Companion;
        DeveloperConsentOuterClass.DeveloperConsent.Builder builderNewBuilder = DeveloperConsentOuterClass.DeveloperConsent.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        DeveloperConsentKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final DeveloperConsentOuterClass.DeveloperConsent copy(@NotNull DeveloperConsentOuterClass.DeveloperConsent developerConsent, @NotNull l<? super DeveloperConsentKt.Dsl, k0> block) {
        t.i(developerConsent, "<this>");
        t.i(block, "block");
        DeveloperConsentKt.Dsl.Companion companion = DeveloperConsentKt.Dsl.Companion;
        DeveloperConsentOuterClass.DeveloperConsent.Builder builder = developerConsent.toBuilder();
        t.h(builder, "this.toBuilder()");
        DeveloperConsentKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
