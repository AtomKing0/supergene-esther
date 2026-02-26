package gatewayprotocol.v1;

import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.DeveloperConsentOuterClass;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DeveloperConsentKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DeveloperConsentKt {

    @NotNull
    public static final DeveloperConsentKt INSTANCE = new DeveloperConsentKt();

    /* JADX INFO: compiled from: DeveloperConsentKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final DeveloperConsentOuterClass.DeveloperConsent.Builder _builder;

        /* JADX INFO: compiled from: DeveloperConsentKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(DeveloperConsentOuterClass.DeveloperConsent.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        /* JADX INFO: compiled from: DeveloperConsentKt.kt */
        public static final class OptionsProxy extends DslProxy {
            private OptionsProxy() {
            }
        }

        public /* synthetic */ Dsl(DeveloperConsentOuterClass.DeveloperConsent.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ DeveloperConsentOuterClass.DeveloperConsent _build() {
            DeveloperConsentOuterClass.DeveloperConsent developerConsentBuild = this._builder.build();
            t.h(developerConsentBuild, "_builder.build()");
            return developerConsentBuild;
        }

        public final /* synthetic */ void addAllOptions(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllOptions(values);
        }

        public final /* synthetic */ void addOptions(DslList dslList, DeveloperConsentOuterClass.DeveloperConsentOption value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addOptions(value);
        }

        public final /* synthetic */ void clearOptions(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearOptions();
        }

        public final /* synthetic */ DslList getOptions() {
            List<DeveloperConsentOuterClass.DeveloperConsentOption> optionsList = this._builder.getOptionsList();
            t.h(optionsList, "_builder.getOptionsList()");
            return new DslList(optionsList);
        }

        public final /* synthetic */ void plusAssignAllOptions(DslList<DeveloperConsentOuterClass.DeveloperConsentOption, OptionsProxy> dslList, Iterable<DeveloperConsentOuterClass.DeveloperConsentOption> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllOptions(dslList, values);
        }

        public final /* synthetic */ void plusAssignOptions(DslList<DeveloperConsentOuterClass.DeveloperConsentOption, OptionsProxy> dslList, DeveloperConsentOuterClass.DeveloperConsentOption value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addOptions(dslList, value);
        }

        public final /* synthetic */ void setOptions(DslList dslList, int i10, DeveloperConsentOuterClass.DeveloperConsentOption value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.setOptions(i10, value);
        }

        private Dsl(DeveloperConsentOuterClass.DeveloperConsent.Builder builder) {
            this._builder = builder;
        }
    }

    private DeveloperConsentKt() {
    }
}
