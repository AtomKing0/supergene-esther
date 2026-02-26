package gatewayprotocol.v1;

import gatewayprotocol.v1.AdDataRefreshResponseKt;
import gatewayprotocol.v1.AdDataRefreshResponseOuterClass;
import gatewayprotocol.v1.ErrorOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AdDataRefreshResponseKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AdDataRefreshResponseKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeadDataRefreshResponse, reason: not valid java name */
    public static final AdDataRefreshResponseOuterClass.AdDataRefreshResponse m4144initializeadDataRefreshResponse(@NotNull l<? super AdDataRefreshResponseKt.Dsl, k0> block) {
        t.i(block, "block");
        AdDataRefreshResponseKt.Dsl.Companion companion = AdDataRefreshResponseKt.Dsl.Companion;
        AdDataRefreshResponseOuterClass.AdDataRefreshResponse.Builder builderNewBuilder = AdDataRefreshResponseOuterClass.AdDataRefreshResponse.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        AdDataRefreshResponseKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final AdDataRefreshResponseOuterClass.AdDataRefreshResponse copy(@NotNull AdDataRefreshResponseOuterClass.AdDataRefreshResponse adDataRefreshResponse, @NotNull l<? super AdDataRefreshResponseKt.Dsl, k0> block) {
        t.i(adDataRefreshResponse, "<this>");
        t.i(block, "block");
        AdDataRefreshResponseKt.Dsl.Companion companion = AdDataRefreshResponseKt.Dsl.Companion;
        AdDataRefreshResponseOuterClass.AdDataRefreshResponse.Builder builder = adDataRefreshResponse.toBuilder();
        t.h(builder, "this.toBuilder()");
        AdDataRefreshResponseKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final ErrorOuterClass.Error getErrorOrNull(@NotNull AdDataRefreshResponseOuterClass.AdDataRefreshResponseOrBuilder adDataRefreshResponseOrBuilder) {
        t.i(adDataRefreshResponseOrBuilder, "<this>");
        if (adDataRefreshResponseOrBuilder.hasError()) {
            return adDataRefreshResponseOrBuilder.getError();
        }
        return null;
    }
}
