package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.BidRequestEventOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DeviceKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DeviceKt {

    @NotNull
    public static final DeviceKt INSTANCE = new DeviceKt();

    /* JADX INFO: compiled from: DeviceKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final BidRequestEventOuterClass.Device.Builder _builder;

        /* JADX INFO: compiled from: DeviceKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(BidRequestEventOuterClass.Device.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(BidRequestEventOuterClass.Device.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ BidRequestEventOuterClass.Device _build() {
            BidRequestEventOuterClass.Device deviceBuild = this._builder.build();
            t.h(deviceBuild, "_builder.build()");
            return deviceBuild;
        }

        public final void clearDeviceType() {
            this._builder.clearDeviceType();
        }

        public final void clearIp() {
            this._builder.clearIp();
        }

        public final void clearMake() {
            this._builder.clearMake();
        }

        public final void clearModel() {
            this._builder.clearModel();
        }

        public final void clearOs() {
            this._builder.clearOs();
        }

        public final void clearOsv() {
            this._builder.clearOsv();
        }

        public final void clearUa() {
            this._builder.clearUa();
        }

        public final int getDeviceType() {
            return this._builder.getDeviceType();
        }

        @NotNull
        public final String getIp() {
            String ip = this._builder.getIp();
            t.h(ip, "_builder.getIp()");
            return ip;
        }

        @NotNull
        public final String getMake() {
            String make = this._builder.getMake();
            t.h(make, "_builder.getMake()");
            return make;
        }

        @NotNull
        public final String getModel() {
            String model = this._builder.getModel();
            t.h(model, "_builder.getModel()");
            return model;
        }

        @NotNull
        public final String getOs() {
            String os = this._builder.getOs();
            t.h(os, "_builder.getOs()");
            return os;
        }

        @NotNull
        public final String getOsv() {
            String osv = this._builder.getOsv();
            t.h(osv, "_builder.getOsv()");
            return osv;
        }

        @NotNull
        public final String getUa() {
            String ua2 = this._builder.getUa();
            t.h(ua2, "_builder.getUa()");
            return ua2;
        }

        public final boolean hasDeviceType() {
            return this._builder.hasDeviceType();
        }

        public final boolean hasIp() {
            return this._builder.hasIp();
        }

        public final boolean hasMake() {
            return this._builder.hasMake();
        }

        public final boolean hasModel() {
            return this._builder.hasModel();
        }

        public final boolean hasOs() {
            return this._builder.hasOs();
        }

        public final boolean hasOsv() {
            return this._builder.hasOsv();
        }

        public final boolean hasUa() {
            return this._builder.hasUa();
        }

        public final void setDeviceType(int i10) {
            this._builder.setDeviceType(i10);
        }

        public final void setIp(@NotNull String value) {
            t.i(value, "value");
            this._builder.setIp(value);
        }

        public final void setMake(@NotNull String value) {
            t.i(value, "value");
            this._builder.setMake(value);
        }

        public final void setModel(@NotNull String value) {
            t.i(value, "value");
            this._builder.setModel(value);
        }

        public final void setOs(@NotNull String value) {
            t.i(value, "value");
            this._builder.setOs(value);
        }

        public final void setOsv(@NotNull String value) {
            t.i(value, "value");
            this._builder.setOsv(value);
        }

        public final void setUa(@NotNull String value) {
            t.i(value, "value");
            this._builder.setUa(value);
        }

        private Dsl(BidRequestEventOuterClass.Device.Builder builder) {
            this._builder = builder;
        }
    }

    private DeviceKt() {
    }
}
