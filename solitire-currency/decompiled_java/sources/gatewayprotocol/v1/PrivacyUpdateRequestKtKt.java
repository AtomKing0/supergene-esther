package gatewayprotocol.v1;

import gatewayprotocol.v1.PrivacyUpdateRequestKt;
import gatewayprotocol.v1.PrivacyUpdateRequestOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: PrivacyUpdateRequestKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PrivacyUpdateRequestKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeprivacyUpdateRequest, reason: not valid java name */
    public static final PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest m4187initializeprivacyUpdateRequest(@NotNull l<? super PrivacyUpdateRequestKt.Dsl, k0> block) {
        t.i(block, "block");
        PrivacyUpdateRequestKt.Dsl.Companion companion = PrivacyUpdateRequestKt.Dsl.Companion;
        PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest.Builder builderNewBuilder = PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        PrivacyUpdateRequestKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest copy(@NotNull PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest privacyUpdateRequest, @NotNull l<? super PrivacyUpdateRequestKt.Dsl, k0> block) {
        t.i(privacyUpdateRequest, "<this>");
        t.i(block, "block");
        PrivacyUpdateRequestKt.Dsl.Companion companion = PrivacyUpdateRequestKt.Dsl.Companion;
        PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest.Builder builder = privacyUpdateRequest.toBuilder();
        t.h(builder, "this.toBuilder()");
        PrivacyUpdateRequestKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
