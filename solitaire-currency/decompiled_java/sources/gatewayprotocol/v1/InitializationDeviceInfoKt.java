package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.InitializationRequestOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: InitializationDeviceInfoKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitializationDeviceInfoKt {

    @NotNull
    public static final InitializationDeviceInfoKt INSTANCE = new InitializationDeviceInfoKt();

    /* JADX INFO: compiled from: InitializationDeviceInfoKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final InitializationRequestOuterClass.InitializationDeviceInfo.Builder _builder;

        /* JADX INFO: compiled from: InitializationDeviceInfoKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(InitializationRequestOuterClass.InitializationDeviceInfo.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(InitializationRequestOuterClass.InitializationDeviceInfo.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ InitializationRequestOuterClass.InitializationDeviceInfo _build() {
            InitializationRequestOuterClass.InitializationDeviceInfo initializationDeviceInfoBuild = this._builder.build();
            t.h(initializationDeviceInfoBuild, "_builder.build()");
            return initializationDeviceInfoBuild;
        }

        public final void clearBatteryLevel() {
            this._builder.clearBatteryLevel();
        }

        public final void clearBatteryStatus() {
            this._builder.clearBatteryStatus();
        }

        public final void clearBundleId() {
            this._builder.clearBundleId();
        }

        public final void clearConnectionType() {
            this._builder.clearConnectionType();
        }

        public final void clearCurrentUiTheme() {
            this._builder.clearCurrentUiTheme();
        }

        public final void clearDeviceMake() {
            this._builder.clearDeviceMake();
        }

        public final void clearDeviceModel() {
            this._builder.clearDeviceModel();
        }

        public final void clearHashedDeviceName() {
            this._builder.clearHashedDeviceName();
        }

        public final void clearLanguage() {
            this._builder.clearLanguage();
        }

        public final void clearLocalList() {
            this._builder.clearLocalList();
        }

        public final void clearNetworkOperator() {
            this._builder.clearNetworkOperator();
        }

        public final void clearOsVersion() {
            this._builder.clearOsVersion();
        }

        public final void clearSystemBootTime() {
            this._builder.clearSystemBootTime();
        }

        public final void clearTotalDiskSpace() {
            this._builder.clearTotalDiskSpace();
        }

        public final void clearTotalRamMemory() {
            this._builder.clearTotalRamMemory();
        }

        public final void clearTrackingAuthStatus() {
            this._builder.clearTrackingAuthStatus();
        }

        public final double getBatteryLevel() {
            return this._builder.getBatteryLevel();
        }

        public final int getBatteryStatus() {
            return this._builder.getBatteryStatus();
        }

        @NotNull
        public final String getBundleId() {
            String bundleId = this._builder.getBundleId();
            t.h(bundleId, "_builder.getBundleId()");
            return bundleId;
        }

        @NotNull
        public final String getConnectionType() {
            String connectionType = this._builder.getConnectionType();
            t.h(connectionType, "_builder.getConnectionType()");
            return connectionType;
        }

        public final long getCurrentUiTheme() {
            return this._builder.getCurrentUiTheme();
        }

        @NotNull
        public final String getDeviceMake() {
            String deviceMake = this._builder.getDeviceMake();
            t.h(deviceMake, "_builder.getDeviceMake()");
            return deviceMake;
        }

        @NotNull
        public final String getDeviceModel() {
            String deviceModel = this._builder.getDeviceModel();
            t.h(deviceModel, "_builder.getDeviceModel()");
            return deviceModel;
        }

        @NotNull
        public final String getHashedDeviceName() {
            String hashedDeviceName = this._builder.getHashedDeviceName();
            t.h(hashedDeviceName, "_builder.getHashedDeviceName()");
            return hashedDeviceName;
        }

        @NotNull
        public final String getLanguage() {
            String language = this._builder.getLanguage();
            t.h(language, "_builder.getLanguage()");
            return language;
        }

        @NotNull
        public final String getLocalList() {
            String localList = this._builder.getLocalList();
            t.h(localList, "_builder.getLocalList()");
            return localList;
        }

        @NotNull
        public final String getNetworkOperator() {
            String networkOperator = this._builder.getNetworkOperator();
            t.h(networkOperator, "_builder.getNetworkOperator()");
            return networkOperator;
        }

        @NotNull
        public final String getOsVersion() {
            String osVersion = this._builder.getOsVersion();
            t.h(osVersion, "_builder.getOsVersion()");
            return osVersion;
        }

        public final long getSystemBootTime() {
            return this._builder.getSystemBootTime();
        }

        public final long getTotalDiskSpace() {
            return this._builder.getTotalDiskSpace();
        }

        public final long getTotalRamMemory() {
            return this._builder.getTotalRamMemory();
        }

        public final int getTrackingAuthStatus() {
            return this._builder.getTrackingAuthStatus();
        }

        public final boolean hasTrackingAuthStatus() {
            return this._builder.hasTrackingAuthStatus();
        }

        public final void setBatteryLevel(double d10) {
            this._builder.setBatteryLevel(d10);
        }

        public final void setBatteryStatus(int i10) {
            this._builder.setBatteryStatus(i10);
        }

        public final void setBundleId(@NotNull String value) {
            t.i(value, "value");
            this._builder.setBundleId(value);
        }

        public final void setConnectionType(@NotNull String value) {
            t.i(value, "value");
            this._builder.setConnectionType(value);
        }

        public final void setCurrentUiTheme(long j10) {
            this._builder.setCurrentUiTheme(j10);
        }

        public final void setDeviceMake(@NotNull String value) {
            t.i(value, "value");
            this._builder.setDeviceMake(value);
        }

        public final void setDeviceModel(@NotNull String value) {
            t.i(value, "value");
            this._builder.setDeviceModel(value);
        }

        public final void setHashedDeviceName(@NotNull String value) {
            t.i(value, "value");
            this._builder.setHashedDeviceName(value);
        }

        public final void setLanguage(@NotNull String value) {
            t.i(value, "value");
            this._builder.setLanguage(value);
        }

        public final void setLocalList(@NotNull String value) {
            t.i(value, "value");
            this._builder.setLocalList(value);
        }

        public final void setNetworkOperator(@NotNull String value) {
            t.i(value, "value");
            this._builder.setNetworkOperator(value);
        }

        public final void setOsVersion(@NotNull String value) {
            t.i(value, "value");
            this._builder.setOsVersion(value);
        }

        public final void setSystemBootTime(long j10) {
            this._builder.setSystemBootTime(j10);
        }

        public final void setTotalDiskSpace(long j10) {
            this._builder.setTotalDiskSpace(j10);
        }

        public final void setTotalRamMemory(long j10) {
            this._builder.setTotalRamMemory(j10);
        }

        public final void setTrackingAuthStatus(int i10) {
            this._builder.setTrackingAuthStatus(i10);
        }

        private Dsl(InitializationRequestOuterClass.InitializationDeviceInfo.Builder builder) {
            this._builder = builder;
        }
    }

    private InitializationDeviceInfoKt() {
    }
}
