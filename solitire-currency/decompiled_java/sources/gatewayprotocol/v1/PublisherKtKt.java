package gatewayprotocol.v1;

import gatewayprotocol.v1.BidRequestEventOuterClass;
import gatewayprotocol.v1.PublisherKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: PublisherKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PublisherKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializepublisher, reason: not valid java name */
    public static final BidRequestEventOuterClass.Publisher m4189initializepublisher(@NotNull l<? super PublisherKt.Dsl, k0> block) {
        t.i(block, "block");
        PublisherKt.Dsl.Companion companion = PublisherKt.Dsl.Companion;
        BidRequestEventOuterClass.Publisher.Builder builderNewBuilder = BidRequestEventOuterClass.Publisher.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        PublisherKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final BidRequestEventOuterClass.Publisher copy(@NotNull BidRequestEventOuterClass.Publisher publisher, @NotNull l<? super PublisherKt.Dsl, k0> block) {
        t.i(publisher, "<this>");
        t.i(block, "block");
        PublisherKt.Dsl.Companion companion = PublisherKt.Dsl.Companion;
        BidRequestEventOuterClass.Publisher.Builder builder = publisher.toBuilder();
        t.h(builder, "this.toBuilder()");
        PublisherKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
