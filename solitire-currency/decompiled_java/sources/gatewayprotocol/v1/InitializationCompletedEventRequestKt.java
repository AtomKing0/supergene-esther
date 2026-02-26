package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.DynamicDeviceInfoOuterClass;
import gatewayprotocol.v1.InitializationCompletedEventRequestOuterClass;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InitializationCompletedEventRequestKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitializationCompletedEventRequestKt {

    @NotNull
    public static final InitializationCompletedEventRequestKt INSTANCE = new InitializationCompletedEventRequestKt();

    /* JADX INFO: compiled from: InitializationCompletedEventRequestKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest.Builder _builder;

        /* JADX INFO: compiled from: InitializationCompletedEventRequestKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest _build() {
            InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest initializationCompletedEventRequestBuild = this._builder.build();
            t.h(initializationCompletedEventRequestBuild, "_builder.build()");
            return initializationCompletedEventRequestBuild;
        }

        public final void clearDynamicDeviceInfo() {
            this._builder.clearDynamicDeviceInfo();
        }

        public final void clearStaticDeviceInfo() {
            this._builder.clearStaticDeviceInfo();
        }

        @NotNull
        public final DynamicDeviceInfoOuterClass.DynamicDeviceInfo getDynamicDeviceInfo() {
            DynamicDeviceInfoOuterClass.DynamicDeviceInfo dynamicDeviceInfo = this._builder.getDynamicDeviceInfo();
            t.h(dynamicDeviceInfo, "_builder.getDynamicDeviceInfo()");
            return dynamicDeviceInfo;
        }

        @NotNull
        public final StaticDeviceInfoOuterClass.StaticDeviceInfo getStaticDeviceInfo() {
            StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfo = this._builder.getStaticDeviceInfo();
            t.h(staticDeviceInfo, "_builder.getStaticDeviceInfo()");
            return staticDeviceInfo;
        }

        public final boolean hasDynamicDeviceInfo() {
            return this._builder.hasDynamicDeviceInfo();
        }

        public final boolean hasStaticDeviceInfo() {
            return this._builder.hasStaticDeviceInfo();
        }

        public final void setDynamicDeviceInfo(@NotNull DynamicDeviceInfoOuterClass.DynamicDeviceInfo value) {
            t.i(value, "value");
            this._builder.setDynamicDeviceInfo(value);
        }

        public final void setStaticDeviceInfo(@NotNull StaticDeviceInfoOuterClass.StaticDeviceInfo value) {
            t.i(value, "value");
            this._builder.setStaticDeviceInfo(value);
        }

        private Dsl(InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest.Builder builder) {
            this._builder = builder;
        }
    }

    private InitializationCompletedEventRequestKt() {
    }
}
