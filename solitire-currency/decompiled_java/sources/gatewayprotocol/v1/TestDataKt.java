package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.TestDataOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TestDataKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TestDataKt {

    @NotNull
    public static final TestDataKt INSTANCE = new TestDataKt();

    /* JADX INFO: compiled from: TestDataKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final TestDataOuterClass.TestData.Builder _builder;

        /* JADX INFO: compiled from: TestDataKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(TestDataOuterClass.TestData.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(TestDataOuterClass.TestData.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ TestDataOuterClass.TestData _build() {
            TestDataOuterClass.TestData testDataBuild = this._builder.build();
            t.h(testDataBuild, "_builder.build()");
            return testDataBuild;
        }

        public final void clearForceCampaignId() {
            this._builder.clearForceCampaignId();
        }

        public final void clearForceCountry() {
            this._builder.clearForceCountry();
        }

        public final void clearForceCountrySubdivision() {
            this._builder.clearForceCountrySubdivision();
        }

        @NotNull
        public final String getForceCampaignId() {
            String forceCampaignId = this._builder.getForceCampaignId();
            t.h(forceCampaignId, "_builder.getForceCampaignId()");
            return forceCampaignId;
        }

        @NotNull
        public final String getForceCountry() {
            String forceCountry = this._builder.getForceCountry();
            t.h(forceCountry, "_builder.getForceCountry()");
            return forceCountry;
        }

        @NotNull
        public final String getForceCountrySubdivision() {
            String forceCountrySubdivision = this._builder.getForceCountrySubdivision();
            t.h(forceCountrySubdivision, "_builder.getForceCountrySubdivision()");
            return forceCountrySubdivision;
        }

        public final boolean hasForceCampaignId() {
            return this._builder.hasForceCampaignId();
        }

        public final boolean hasForceCountry() {
            return this._builder.hasForceCountry();
        }

        public final boolean hasForceCountrySubdivision() {
            return this._builder.hasForceCountrySubdivision();
        }

        public final void setForceCampaignId(@NotNull String value) {
            t.i(value, "value");
            this._builder.setForceCampaignId(value);
        }

        public final void setForceCountry(@NotNull String value) {
            t.i(value, "value");
            this._builder.setForceCountry(value);
        }

        public final void setForceCountrySubdivision(@NotNull String value) {
            t.i(value, "value");
            this._builder.setForceCountrySubdivision(value);
        }

        private Dsl(TestDataOuterClass.TestData.Builder builder) {
            this._builder = builder;
        }
    }

    private TestDataKt() {
    }
}
