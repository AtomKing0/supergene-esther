package gatewayprotocol.v1;

import gatewayprotocol.v1.AdPlayerConfigResponseKt;
import gatewayprotocol.v1.AdPlayerConfigResponseOuterClass;
import gatewayprotocol.v1.ErrorOuterClass;
import gatewayprotocol.v1.WebviewConfiguration;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AdPlayerConfigResponseKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AdPlayerConfigResponseKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeadPlayerConfigResponse, reason: not valid java name */
    public static final AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse m4147initializeadPlayerConfigResponse(@NotNull l<? super AdPlayerConfigResponseKt.Dsl, k0> block) {
        t.i(block, "block");
        AdPlayerConfigResponseKt.Dsl.Companion companion = AdPlayerConfigResponseKt.Dsl.Companion;
        AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse.Builder builderNewBuilder = AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        AdPlayerConfigResponseKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse copy(@NotNull AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse adPlayerConfigResponse, @NotNull l<? super AdPlayerConfigResponseKt.Dsl, k0> block) {
        t.i(adPlayerConfigResponse, "<this>");
        t.i(block, "block");
        AdPlayerConfigResponseKt.Dsl.Companion companion = AdPlayerConfigResponseKt.Dsl.Companion;
        AdPlayerConfigResponseOuterClass.AdPlayerConfigResponse.Builder builder = adPlayerConfigResponse.toBuilder();
        t.h(builder, "this.toBuilder()");
        AdPlayerConfigResponseKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final ErrorOuterClass.Error getErrorOrNull(@NotNull AdPlayerConfigResponseOuterClass.AdPlayerConfigResponseOrBuilder adPlayerConfigResponseOrBuilder) {
        t.i(adPlayerConfigResponseOrBuilder, "<this>");
        if (adPlayerConfigResponseOrBuilder.hasError()) {
            return adPlayerConfigResponseOrBuilder.getError();
        }
        return null;
    }

    @Nullable
    public static final WebviewConfiguration.WebViewConfiguration getWebviewConfigurationOrNull(@NotNull AdPlayerConfigResponseOuterClass.AdPlayerConfigResponseOrBuilder adPlayerConfigResponseOrBuilder) {
        t.i(adPlayerConfigResponseOrBuilder, "<this>");
        if (adPlayerConfigResponseOrBuilder.hasWebviewConfiguration()) {
            return adPlayerConfigResponseOrBuilder.getWebviewConfiguration();
        }
        return null;
    }
}
