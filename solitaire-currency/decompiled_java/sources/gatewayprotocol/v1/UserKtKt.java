package gatewayprotocol.v1;

import gatewayprotocol.v1.BidRequestEventOuterClass;
import gatewayprotocol.v1.UserKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: UserKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UserKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeuser, reason: not valid java name */
    public static final BidRequestEventOuterClass.User m4207initializeuser(@NotNull l<? super UserKt.Dsl, k0> block) {
        t.i(block, "block");
        UserKt.Dsl.Companion companion = UserKt.Dsl.Companion;
        BidRequestEventOuterClass.User.Builder builderNewBuilder = BidRequestEventOuterClass.User.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        UserKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final BidRequestEventOuterClass.User copy(@NotNull BidRequestEventOuterClass.User user, @NotNull l<? super UserKt.Dsl, k0> block) {
        t.i(user, "<this>");
        t.i(block, "block");
        UserKt.Dsl.Companion companion = UserKt.Dsl.Companion;
        BidRequestEventOuterClass.User.Builder builder = user.toBuilder();
        t.h(builder, "this.toBuilder()");
        UserKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
