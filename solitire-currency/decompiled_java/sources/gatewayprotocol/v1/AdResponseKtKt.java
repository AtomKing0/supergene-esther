package gatewayprotocol.v1;

import gatewayprotocol.v1.AdResponseKt;
import gatewayprotocol.v1.AdResponseOuterClass;
import gatewayprotocol.v1.ErrorOuterClass;
import gatewayprotocol.v1.WebviewConfiguration;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AdResponseKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AdResponseKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeadResponse, reason: not valid java name */
    public static final AdResponseOuterClass.AdResponse m4149initializeadResponse(@NotNull l<? super AdResponseKt.Dsl, k0> block) {
        t.i(block, "block");
        AdResponseKt.Dsl.Companion companion = AdResponseKt.Dsl.Companion;
        AdResponseOuterClass.AdResponse.Builder builderNewBuilder = AdResponseOuterClass.AdResponse.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        AdResponseKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final AdResponseOuterClass.AdResponse copy(@NotNull AdResponseOuterClass.AdResponse adResponse, @NotNull l<? super AdResponseKt.Dsl, k0> block) {
        t.i(adResponse, "<this>");
        t.i(block, "block");
        AdResponseKt.Dsl.Companion companion = AdResponseKt.Dsl.Companion;
        AdResponseOuterClass.AdResponse.Builder builder = adResponse.toBuilder();
        t.h(builder, "this.toBuilder()");
        AdResponseKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final ErrorOuterClass.Error getErrorOrNull(@NotNull AdResponseOuterClass.AdResponseOrBuilder adResponseOrBuilder) {
        t.i(adResponseOrBuilder, "<this>");
        if (adResponseOrBuilder.hasError()) {
            return adResponseOrBuilder.getError();
        }
        return null;
    }

    @Nullable
    public static final WebviewConfiguration.WebViewConfiguration getWebviewConfigurationOrNull(@NotNull AdResponseOuterClass.AdResponseOrBuilder adResponseOrBuilder) {
        t.i(adResponseOrBuilder, "<this>");
        if (adResponseOrBuilder.hasWebviewConfiguration()) {
            return adResponseOrBuilder.getWebviewConfiguration();
        }
        return null;
    }
}
