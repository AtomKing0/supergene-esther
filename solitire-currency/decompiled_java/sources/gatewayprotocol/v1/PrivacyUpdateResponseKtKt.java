package gatewayprotocol.v1;

import gatewayprotocol.v1.PrivacyUpdateResponseKt;
import gatewayprotocol.v1.PrivacyUpdateResponseOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: PrivacyUpdateResponseKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PrivacyUpdateResponseKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeprivacyUpdateResponse, reason: not valid java name */
    public static final PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse m4188initializeprivacyUpdateResponse(@NotNull l<? super PrivacyUpdateResponseKt.Dsl, k0> block) {
        t.i(block, "block");
        PrivacyUpdateResponseKt.Dsl.Companion companion = PrivacyUpdateResponseKt.Dsl.Companion;
        PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse.Builder builderNewBuilder = PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        PrivacyUpdateResponseKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse copy(@NotNull PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse privacyUpdateResponse, @NotNull l<? super PrivacyUpdateResponseKt.Dsl, k0> block) {
        t.i(privacyUpdateResponse, "<this>");
        t.i(block, "block");
        PrivacyUpdateResponseKt.Dsl.Companion companion = PrivacyUpdateResponseKt.Dsl.Companion;
        PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse.Builder builder = privacyUpdateResponse.toBuilder();
        t.h(builder, "this.toBuilder()");
        PrivacyUpdateResponseKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
