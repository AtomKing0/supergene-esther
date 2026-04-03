package gatewayprotocol.v1;

import gatewayprotocol.v1.TestDataKt;
import gatewayprotocol.v1.TestDataOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: TestDataKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TestDataKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializetestData, reason: not valid java name */
    public static final TestDataOuterClass.TestData m4197initializetestData(@NotNull l<? super TestDataKt.Dsl, k0> block) {
        t.i(block, "block");
        TestDataKt.Dsl.Companion companion = TestDataKt.Dsl.Companion;
        TestDataOuterClass.TestData.Builder builderNewBuilder = TestDataOuterClass.TestData.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        TestDataKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final TestDataOuterClass.TestData copy(@NotNull TestDataOuterClass.TestData testData, @NotNull l<? super TestDataKt.Dsl, k0> block) {
        t.i(testData, "<this>");
        t.i(block, "block");
        TestDataKt.Dsl.Companion companion = TestDataKt.Dsl.Companion;
        TestDataOuterClass.TestData.Builder builder = testData.toBuilder();
        t.h(builder, "this.toBuilder()");
        TestDataKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
