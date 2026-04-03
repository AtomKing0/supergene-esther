package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.DeveloperConsentOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DeveloperConsentOptionKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DeveloperConsentOptionKt {

    @NotNull
    public static final DeveloperConsentOptionKt INSTANCE = new DeveloperConsentOptionKt();

    /* JADX INFO: compiled from: DeveloperConsentOptionKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final DeveloperConsentOuterClass.DeveloperConsentOption.Builder _builder;

        /* JADX INFO: compiled from: DeveloperConsentOptionKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(DeveloperConsentOuterClass.DeveloperConsentOption.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(DeveloperConsentOuterClass.DeveloperConsentOption.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ DeveloperConsentOuterClass.DeveloperConsentOption _build() {
            DeveloperConsentOuterClass.DeveloperConsentOption developerConsentOptionBuild = this._builder.build();
            t.h(developerConsentOptionBuild, "_builder.build()");
            return developerConsentOptionBuild;
        }

        public final void clearCustomType() {
            this._builder.clearCustomType();
        }

        public final void clearType() {
            this._builder.clearType();
        }

        public final void clearValue() {
            this._builder.clearValue();
        }

        @NotNull
        public final String getCustomType() {
            String customType = this._builder.getCustomType();
            t.h(customType, "_builder.getCustomType()");
            return customType;
        }

        @NotNull
        public final DeveloperConsentOuterClass.DeveloperConsentType getType() {
            DeveloperConsentOuterClass.DeveloperConsentType type = this._builder.getType();
            t.h(type, "_builder.getType()");
            return type;
        }

        @NotNull
        public final DeveloperConsentOuterClass.DeveloperConsentChoice getValue() {
            DeveloperConsentOuterClass.DeveloperConsentChoice value = this._builder.getValue();
            t.h(value, "_builder.getValue()");
            return value;
        }

        public final boolean hasCustomType() {
            return this._builder.hasCustomType();
        }

        public final void setCustomType(@NotNull String value) {
            t.i(value, "value");
            this._builder.setCustomType(value);
        }

        public final void setType(@NotNull DeveloperConsentOuterClass.DeveloperConsentType value) {
            t.i(value, "value");
            this._builder.setType(value);
        }

        public final void setValue(@NotNull DeveloperConsentOuterClass.DeveloperConsentChoice value) {
            t.i(value, "value");
            this._builder.setValue(value);
        }

        private Dsl(DeveloperConsentOuterClass.DeveloperConsentOption.Builder builder) {
            this._builder = builder;
        }
    }

    private DeveloperConsentOptionKt() {
    }
}
