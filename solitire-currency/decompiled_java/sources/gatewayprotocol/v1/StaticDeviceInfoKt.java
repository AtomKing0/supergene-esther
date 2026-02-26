package gatewayprotocol.v1;

import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: StaticDeviceInfoKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StaticDeviceInfoKt {

    @NotNull
    public static final StaticDeviceInfoKt INSTANCE = new StaticDeviceInfoKt();

    /* JADX INFO: compiled from: StaticDeviceInfoKt.kt */
    public static final class AndroidKt {

        @NotNull
        public static final AndroidKt INSTANCE = new AndroidKt();

        /* JADX INFO: compiled from: StaticDeviceInfoKt.kt */
        @ProtoDslMarker
        public static final class Dsl {

            @NotNull
            public static final Companion Companion = new Companion(null);

            @NotNull
            private final StaticDeviceInfoOuterClass.StaticDeviceInfo.Android.Builder _builder;

            /* JADX INFO: compiled from: StaticDeviceInfoKt.kt */
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(k kVar) {
                    this();
                }

                public final /* synthetic */ Dsl _create(StaticDeviceInfoOuterClass.StaticDeviceInfo.Android.Builder builder) {
                    t.i(builder, "builder");
                    return new Dsl(builder, null);
                }
            }

            public /* synthetic */ Dsl(StaticDeviceInfoOuterClass.StaticDeviceInfo.Android.Builder builder, k kVar) {
                this(builder);
            }

            public final /* synthetic */ StaticDeviceInfoOuterClass.StaticDeviceInfo.Android _build() {
                StaticDeviceInfoOuterClass.StaticDeviceInfo.Android androidBuild = this._builder.build();
                t.h(androidBuild, "_builder.build()");
                return androidBuild;
            }

            public final void clearAndroidFingerprint() {
                this._builder.clearAndroidFingerprint();
            }

            public final void clearApiLevel() {
                this._builder.clearApiLevel();
            }

            public final void clearApkDeveloperSigningCertificateHash() {
                this._builder.clearApkDeveloperSigningCertificateHash();
            }

            public final void clearAppInstaller() {
                this._builder.clearAppInstaller();
            }

            public final void clearBuildBoard() {
                this._builder.clearBuildBoard();
            }

            public final void clearBuildBootloader() {
                this._builder.clearBuildBootloader();
            }

            public final void clearBuildBrand() {
                this._builder.clearBuildBrand();
            }

            public final void clearBuildDevice() {
                this._builder.clearBuildDevice();
            }

            public final void clearBuildDisplay() {
                this._builder.clearBuildDisplay();
            }

            public final void clearBuildFingerprint() {
                this._builder.clearBuildFingerprint();
            }

            public final void clearBuildHardware() {
                this._builder.clearBuildHardware();
            }

            public final void clearBuildHost() {
                this._builder.clearBuildHost();
            }

            public final void clearBuildId() {
                this._builder.clearBuildId();
            }

            public final void clearBuildProduct() {
                this._builder.clearBuildProduct();
            }

            public final void clearExtensionVersion() {
                this._builder.clearExtensionVersion();
            }

            public final void clearPhoneType() {
                this._builder.clearPhoneType();
            }

            public final void clearSimOperator() {
                this._builder.clearSimOperator();
            }

            public final void clearVersionCode() {
                this._builder.clearVersionCode();
            }

            @NotNull
            public final String getAndroidFingerprint() {
                String androidFingerprint = this._builder.getAndroidFingerprint();
                t.h(androidFingerprint, "_builder.getAndroidFingerprint()");
                return androidFingerprint;
            }

            public final int getApiLevel() {
                return this._builder.getApiLevel();
            }

            @NotNull
            public final String getApkDeveloperSigningCertificateHash() {
                String apkDeveloperSigningCertificateHash = this._builder.getApkDeveloperSigningCertificateHash();
                t.h(apkDeveloperSigningCertificateHash, "_builder.getApkDeveloperSigningCertificateHash()");
                return apkDeveloperSigningCertificateHash;
            }

            @NotNull
            public final String getAppInstaller() {
                String appInstaller = this._builder.getAppInstaller();
                t.h(appInstaller, "_builder.getAppInstaller()");
                return appInstaller;
            }

            @NotNull
            public final String getBuildBoard() {
                String buildBoard = this._builder.getBuildBoard();
                t.h(buildBoard, "_builder.getBuildBoard()");
                return buildBoard;
            }

            @NotNull
            public final String getBuildBootloader() {
                String buildBootloader = this._builder.getBuildBootloader();
                t.h(buildBootloader, "_builder.getBuildBootloader()");
                return buildBootloader;
            }

            @NotNull
            public final String getBuildBrand() {
                String buildBrand = this._builder.getBuildBrand();
                t.h(buildBrand, "_builder.getBuildBrand()");
                return buildBrand;
            }

            @NotNull
            public final String getBuildDevice() {
                String buildDevice = this._builder.getBuildDevice();
                t.h(buildDevice, "_builder.getBuildDevice()");
                return buildDevice;
            }

            @NotNull
            public final String getBuildDisplay() {
                String buildDisplay = this._builder.getBuildDisplay();
                t.h(buildDisplay, "_builder.getBuildDisplay()");
                return buildDisplay;
            }

            @NotNull
            public final String getBuildFingerprint() {
                String buildFingerprint = this._builder.getBuildFingerprint();
                t.h(buildFingerprint, "_builder.getBuildFingerprint()");
                return buildFingerprint;
            }

            @NotNull
            public final String getBuildHardware() {
                String buildHardware = this._builder.getBuildHardware();
                t.h(buildHardware, "_builder.getBuildHardware()");
                return buildHardware;
            }

            @NotNull
            public final String getBuildHost() {
                String buildHost = this._builder.getBuildHost();
                t.h(buildHost, "_builder.getBuildHost()");
                return buildHost;
            }

            @NotNull
            public final String getBuildId() {
                String buildId = this._builder.getBuildId();
                t.h(buildId, "_builder.getBuildId()");
                return buildId;
            }

            @NotNull
            public final String getBuildProduct() {
                String buildProduct = this._builder.getBuildProduct();
                t.h(buildProduct, "_builder.getBuildProduct()");
                return buildProduct;
            }

            public final int getExtensionVersion() {
                return this._builder.getExtensionVersion();
            }

            public final int getPhoneType() {
                return this._builder.getPhoneType();
            }

            @NotNull
            public final String getSimOperator() {
                String simOperator = this._builder.getSimOperator();
                t.h(simOperator, "_builder.getSimOperator()");
                return simOperator;
            }

            public final int getVersionCode() {
                return this._builder.getVersionCode();
            }

            public final boolean hasAndroidFingerprint() {
                return this._builder.hasAndroidFingerprint();
            }

            public final boolean hasApiLevel() {
                return this._builder.hasApiLevel();
            }

            public final boolean hasApkDeveloperSigningCertificateHash() {
                return this._builder.hasApkDeveloperSigningCertificateHash();
            }

            public final boolean hasAppInstaller() {
                return this._builder.hasAppInstaller();
            }

            public final boolean hasBuildBoard() {
                return this._builder.hasBuildBoard();
            }

            public final boolean hasBuildBootloader() {
                return this._builder.hasBuildBootloader();
            }

            public final boolean hasBuildBrand() {
                return this._builder.hasBuildBrand();
            }

            public final boolean hasBuildDevice() {
                return this._builder.hasBuildDevice();
            }

            public final boolean hasBuildDisplay() {
                return this._builder.hasBuildDisplay();
            }

            public final boolean hasBuildFingerprint() {
                return this._builder.hasBuildFingerprint();
            }

            public final boolean hasBuildHardware() {
                return this._builder.hasBuildHardware();
            }

            public final boolean hasBuildHost() {
                return this._builder.hasBuildHost();
            }

            public final boolean hasBuildId() {
                return this._builder.hasBuildId();
            }

            public final boolean hasBuildProduct() {
                return this._builder.hasBuildProduct();
            }

            public final boolean hasExtensionVersion() {
                return this._builder.hasExtensionVersion();
            }

            public final boolean hasPhoneType() {
                return this._builder.hasPhoneType();
            }

            public final boolean hasSimOperator() {
                return this._builder.hasSimOperator();
            }

            public final boolean hasVersionCode() {
                return this._builder.hasVersionCode();
            }

            public final void setAndroidFingerprint(@NotNull String value) {
                t.i(value, "value");
                this._builder.setAndroidFingerprint(value);
            }

            public final void setApiLevel(int i10) {
                this._builder.setApiLevel(i10);
            }

            public final void setApkDeveloperSigningCertificateHash(@NotNull String value) {
                t.i(value, "value");
                this._builder.setApkDeveloperSigningCertificateHash(value);
            }

            public final void setAppInstaller(@NotNull String value) {
                t.i(value, "value");
                this._builder.setAppInstaller(value);
            }

            public final void setBuildBoard(@NotNull String value) {
                t.i(value, "value");
                this._builder.setBuildBoard(value);
            }

            public final void setBuildBootloader(@NotNull String value) {
                t.i(value, "value");
                this._builder.setBuildBootloader(value);
            }

            public final void setBuildBrand(@NotNull String value) {
                t.i(value, "value");
                this._builder.setBuildBrand(value);
            }

            public final void setBuildDevice(@NotNull String value) {
                t.i(value, "value");
                this._builder.setBuildDevice(value);
            }

            public final void setBuildDisplay(@NotNull String value) {
                t.i(value, "value");
                this._builder.setBuildDisplay(value);
            }

            public final void setBuildFingerprint(@NotNull String value) {
                t.i(value, "value");
                this._builder.setBuildFingerprint(value);
            }

            public final void setBuildHardware(@NotNull String value) {
                t.i(value, "value");
                this._builder.setBuildHardware(value);
            }

            public final void setBuildHost(@NotNull String value) {
                t.i(value, "value");
                this._builder.setBuildHost(value);
            }

            public final void setBuildId(@NotNull String value) {
                t.i(value, "value");
                this._builder.setBuildId(value);
            }

            public final void setBuildProduct(@NotNull String value) {
                t.i(value, "value");
                this._builder.setBuildProduct(value);
            }

            public final void setExtensionVersion(int i10) {
                this._builder.setExtensionVersion(i10);
            }

            public final void setPhoneType(int i10) {
                this._builder.setPhoneType(i10);
            }

            public final void setSimOperator(@NotNull String value) {
                t.i(value, "value");
                this._builder.setSimOperator(value);
            }

            public final void setVersionCode(int i10) {
                this._builder.setVersionCode(i10);
            }

            private Dsl(StaticDeviceInfoOuterClass.StaticDeviceInfo.Android.Builder builder) {
                this._builder = builder;
            }
        }

        private AndroidKt() {
        }
    }

    /* JADX INFO: compiled from: StaticDeviceInfoKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final StaticDeviceInfoOuterClass.StaticDeviceInfo.Builder _builder;

        /* JADX INFO: compiled from: StaticDeviceInfoKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(StaticDeviceInfoOuterClass.StaticDeviceInfo.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        /* JADX INFO: compiled from: StaticDeviceInfoKt.kt */
        public static final class StoresProxy extends DslProxy {
            private StoresProxy() {
            }
        }

        public /* synthetic */ Dsl(StaticDeviceInfoOuterClass.StaticDeviceInfo.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ StaticDeviceInfoOuterClass.StaticDeviceInfo _build() {
            StaticDeviceInfoOuterClass.StaticDeviceInfo staticDeviceInfoBuild = this._builder.build();
            t.h(staticDeviceInfoBuild, "_builder.build()");
            return staticDeviceInfoBuild;
        }

        public final /* synthetic */ void addAllStores(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllStores(values);
        }

        public final /* synthetic */ void addStores(DslList dslList, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addStores(value);
        }

        public final void clearAndroid() {
            this._builder.clearAndroid();
        }

        public final void clearAppDebuggable() {
            this._builder.clearAppDebuggable();
        }

        public final void clearBundleId() {
            this._builder.clearBundleId();
        }

        public final void clearBundleVersion() {
            this._builder.clearBundleVersion();
        }

        public final void clearCpuCount() {
            this._builder.clearCpuCount();
        }

        public final void clearCpuModel() {
            this._builder.clearCpuModel();
        }

        public final void clearDeviceMake() {
            this._builder.clearDeviceMake();
        }

        public final void clearDeviceModel() {
            this._builder.clearDeviceModel();
        }

        public final void clearGpuModel() {
            this._builder.clearGpuModel();
        }

        public final void clearIos() {
            this._builder.clearIos();
        }

        public final void clearOsVersion() {
            this._builder.clearOsVersion();
        }

        public final void clearPlatformSpecific() {
            this._builder.clearPlatformSpecific();
        }

        public final void clearRooted() {
            this._builder.clearRooted();
        }

        public final void clearScreenDensity() {
            this._builder.clearScreenDensity();
        }

        public final void clearScreenHeight() {
            this._builder.clearScreenHeight();
        }

        public final void clearScreenSize() {
            this._builder.clearScreenSize();
        }

        public final void clearScreenWidth() {
            this._builder.clearScreenWidth();
        }

        public final /* synthetic */ void clearStores(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearStores();
        }

        public final void clearTotalDiskSpace() {
            this._builder.clearTotalDiskSpace();
        }

        public final void clearTotalRamMemory() {
            this._builder.clearTotalRamMemory();
        }

        public final void clearWebviewUa() {
            this._builder.clearWebviewUa();
        }

        @NotNull
        public final StaticDeviceInfoOuterClass.StaticDeviceInfo.Android getAndroid() {
            StaticDeviceInfoOuterClass.StaticDeviceInfo.Android android2 = this._builder.getAndroid();
            t.h(android2, "_builder.getAndroid()");
            return android2;
        }

        public final boolean getAppDebuggable() {
            return this._builder.getAppDebuggable();
        }

        @NotNull
        public final String getBundleId() {
            String bundleId = this._builder.getBundleId();
            t.h(bundleId, "_builder.getBundleId()");
            return bundleId;
        }

        @NotNull
        public final String getBundleVersion() {
            String bundleVersion = this._builder.getBundleVersion();
            t.h(bundleVersion, "_builder.getBundleVersion()");
            return bundleVersion;
        }

        public final long getCpuCount() {
            return this._builder.getCpuCount();
        }

        @NotNull
        public final String getCpuModel() {
            String cpuModel = this._builder.getCpuModel();
            t.h(cpuModel, "_builder.getCpuModel()");
            return cpuModel;
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
        public final String getGpuModel() {
            String gpuModel = this._builder.getGpuModel();
            t.h(gpuModel, "_builder.getGpuModel()");
            return gpuModel;
        }

        @NotNull
        public final StaticDeviceInfoOuterClass.StaticDeviceInfo.Ios getIos() {
            StaticDeviceInfoOuterClass.StaticDeviceInfo.Ios ios = this._builder.getIos();
            t.h(ios, "_builder.getIos()");
            return ios;
        }

        @NotNull
        public final String getOsVersion() {
            String osVersion = this._builder.getOsVersion();
            t.h(osVersion, "_builder.getOsVersion()");
            return osVersion;
        }

        @NotNull
        public final StaticDeviceInfoOuterClass.StaticDeviceInfo.PlatformSpecificCase getPlatformSpecificCase() {
            StaticDeviceInfoOuterClass.StaticDeviceInfo.PlatformSpecificCase platformSpecificCase = this._builder.getPlatformSpecificCase();
            t.h(platformSpecificCase, "_builder.getPlatformSpecificCase()");
            return platformSpecificCase;
        }

        public final boolean getRooted() {
            return this._builder.getRooted();
        }

        public final int getScreenDensity() {
            return this._builder.getScreenDensity();
        }

        public final int getScreenHeight() {
            return this._builder.getScreenHeight();
        }

        public final int getScreenSize() {
            return this._builder.getScreenSize();
        }

        public final int getScreenWidth() {
            return this._builder.getScreenWidth();
        }

        @NotNull
        public final DslList<String, StoresProxy> getStores() {
            List<String> storesList = this._builder.getStoresList();
            t.h(storesList, "_builder.getStoresList()");
            return new DslList<>(storesList);
        }

        public final long getTotalDiskSpace() {
            return this._builder.getTotalDiskSpace();
        }

        public final long getTotalRamMemory() {
            return this._builder.getTotalRamMemory();
        }

        @NotNull
        public final String getWebviewUa() {
            String webviewUa = this._builder.getWebviewUa();
            t.h(webviewUa, "_builder.getWebviewUa()");
            return webviewUa;
        }

        public final boolean hasAndroid() {
            return this._builder.hasAndroid();
        }

        public final boolean hasAppDebuggable() {
            return this._builder.hasAppDebuggable();
        }

        public final boolean hasBundleId() {
            return this._builder.hasBundleId();
        }

        public final boolean hasBundleVersion() {
            return this._builder.hasBundleVersion();
        }

        public final boolean hasCpuCount() {
            return this._builder.hasCpuCount();
        }

        public final boolean hasCpuModel() {
            return this._builder.hasCpuModel();
        }

        public final boolean hasDeviceMake() {
            return this._builder.hasDeviceMake();
        }

        public final boolean hasDeviceModel() {
            return this._builder.hasDeviceModel();
        }

        public final boolean hasGpuModel() {
            return this._builder.hasGpuModel();
        }

        public final boolean hasIos() {
            return this._builder.hasIos();
        }

        public final boolean hasOsVersion() {
            return this._builder.hasOsVersion();
        }

        public final boolean hasRooted() {
            return this._builder.hasRooted();
        }

        public final boolean hasScreenDensity() {
            return this._builder.hasScreenDensity();
        }

        public final boolean hasScreenHeight() {
            return this._builder.hasScreenHeight();
        }

        public final boolean hasScreenSize() {
            return this._builder.hasScreenSize();
        }

        public final boolean hasScreenWidth() {
            return this._builder.hasScreenWidth();
        }

        public final boolean hasTotalDiskSpace() {
            return this._builder.hasTotalDiskSpace();
        }

        public final boolean hasTotalRamMemory() {
            return this._builder.hasTotalRamMemory();
        }

        public final boolean hasWebviewUa() {
            return this._builder.hasWebviewUa();
        }

        public final /* synthetic */ void plusAssignAllStores(DslList<String, StoresProxy> dslList, Iterable<String> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllStores(dslList, values);
        }

        public final /* synthetic */ void plusAssignStores(DslList<String, StoresProxy> dslList, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addStores(dslList, value);
        }

        public final void setAndroid(@NotNull StaticDeviceInfoOuterClass.StaticDeviceInfo.Android value) {
            t.i(value, "value");
            this._builder.setAndroid(value);
        }

        public final void setAppDebuggable(boolean z10) {
            this._builder.setAppDebuggable(z10);
        }

        public final void setBundleId(@NotNull String value) {
            t.i(value, "value");
            this._builder.setBundleId(value);
        }

        public final void setBundleVersion(@NotNull String value) {
            t.i(value, "value");
            this._builder.setBundleVersion(value);
        }

        public final void setCpuCount(long j10) {
            this._builder.setCpuCount(j10);
        }

        public final void setCpuModel(@NotNull String value) {
            t.i(value, "value");
            this._builder.setCpuModel(value);
        }

        public final void setDeviceMake(@NotNull String value) {
            t.i(value, "value");
            this._builder.setDeviceMake(value);
        }

        public final void setDeviceModel(@NotNull String value) {
            t.i(value, "value");
            this._builder.setDeviceModel(value);
        }

        public final void setGpuModel(@NotNull String value) {
            t.i(value, "value");
            this._builder.setGpuModel(value);
        }

        public final void setIos(@NotNull StaticDeviceInfoOuterClass.StaticDeviceInfo.Ios value) {
            t.i(value, "value");
            this._builder.setIos(value);
        }

        public final void setOsVersion(@NotNull String value) {
            t.i(value, "value");
            this._builder.setOsVersion(value);
        }

        public final void setRooted(boolean z10) {
            this._builder.setRooted(z10);
        }

        public final void setScreenDensity(int i10) {
            this._builder.setScreenDensity(i10);
        }

        public final void setScreenHeight(int i10) {
            this._builder.setScreenHeight(i10);
        }

        public final void setScreenSize(int i10) {
            this._builder.setScreenSize(i10);
        }

        public final void setScreenWidth(int i10) {
            this._builder.setScreenWidth(i10);
        }

        public final /* synthetic */ void setStores(DslList dslList, int i10, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.setStores(i10, value);
        }

        public final void setTotalDiskSpace(long j10) {
            this._builder.setTotalDiskSpace(j10);
        }

        public final void setTotalRamMemory(long j10) {
            this._builder.setTotalRamMemory(j10);
        }

        public final void setWebviewUa(@NotNull String value) {
            t.i(value, "value");
            this._builder.setWebviewUa(value);
        }

        private Dsl(StaticDeviceInfoOuterClass.StaticDeviceInfo.Builder builder) {
            this._builder = builder;
        }
    }

    /* JADX INFO: compiled from: StaticDeviceInfoKt.kt */
    public static final class IosKt {

        @NotNull
        public static final IosKt INSTANCE = new IosKt();

        /* JADX INFO: compiled from: StaticDeviceInfoKt.kt */
        @ProtoDslMarker
        public static final class Dsl {

            @NotNull
            public static final Companion Companion = new Companion(null);

            @NotNull
            private final StaticDeviceInfoOuterClass.StaticDeviceInfo.Ios.Builder _builder;

            /* JADX INFO: compiled from: StaticDeviceInfoKt.kt */
            public static final class Companion {
                private Companion() {
                }

                public /* synthetic */ Companion(k kVar) {
                    this();
                }

                public final /* synthetic */ Dsl _create(StaticDeviceInfoOuterClass.StaticDeviceInfo.Ios.Builder builder) {
                    t.i(builder, "builder");
                    return new Dsl(builder, null);
                }
            }

            /* JADX INFO: compiled from: StaticDeviceInfoKt.kt */
            public static final class SkadnetworkIdProxy extends DslProxy {
                private SkadnetworkIdProxy() {
                }
            }

            public /* synthetic */ Dsl(StaticDeviceInfoOuterClass.StaticDeviceInfo.Ios.Builder builder, k kVar) {
                this(builder);
            }

            public final /* synthetic */ StaticDeviceInfoOuterClass.StaticDeviceInfo.Ios _build() {
                StaticDeviceInfoOuterClass.StaticDeviceInfo.Ios iosBuild = this._builder.build();
                t.h(iosBuild, "_builder.build()");
                return iosBuild;
            }

            public final /* synthetic */ void addAllSkadnetworkId(DslList dslList, Iterable values) {
                t.i(dslList, "<this>");
                t.i(values, "values");
                this._builder.addAllSkadnetworkId(values);
            }

            public final /* synthetic */ void addSkadnetworkId(DslList dslList, String value) {
                t.i(dslList, "<this>");
                t.i(value, "value");
                this._builder.addSkadnetworkId(value);
            }

            public final void clearBuiltSdkVersion() {
                this._builder.clearBuiltSdkVersion();
            }

            public final void clearCanMakePayments() {
                this._builder.clearCanMakePayments();
            }

            public final void clearScreenScale() {
                this._builder.clearScreenScale();
            }

            public final void clearSimulator() {
                this._builder.clearSimulator();
            }

            public final /* synthetic */ void clearSkadnetworkId(DslList dslList) {
                t.i(dslList, "<this>");
                this._builder.clearSkadnetworkId();
            }

            public final void clearSystemBootTime() {
                this._builder.clearSystemBootTime();
            }

            public final void clearXcodeBuildVersion() {
                this._builder.clearXcodeBuildVersion();
            }

            public final void clearXcodeSdkBuildVersion() {
                this._builder.clearXcodeSdkBuildVersion();
            }

            public final void clearXcodeVersion() {
                this._builder.clearXcodeVersion();
            }

            @NotNull
            public final String getBuiltSdkVersion() {
                String builtSdkVersion = this._builder.getBuiltSdkVersion();
                t.h(builtSdkVersion, "_builder.getBuiltSdkVersion()");
                return builtSdkVersion;
            }

            public final boolean getCanMakePayments() {
                return this._builder.getCanMakePayments();
            }

            public final int getScreenScale() {
                return this._builder.getScreenScale();
            }

            public final boolean getSimulator() {
                return this._builder.getSimulator();
            }

            @NotNull
            public final DslList<String, SkadnetworkIdProxy> getSkadnetworkId() {
                List<String> skadnetworkIdList = this._builder.getSkadnetworkIdList();
                t.h(skadnetworkIdList, "_builder.getSkadnetworkIdList()");
                return new DslList<>(skadnetworkIdList);
            }

            public final long getSystemBootTime() {
                return this._builder.getSystemBootTime();
            }

            @NotNull
            public final String getXcodeBuildVersion() {
                String xcodeBuildVersion = this._builder.getXcodeBuildVersion();
                t.h(xcodeBuildVersion, "_builder.getXcodeBuildVersion()");
                return xcodeBuildVersion;
            }

            @NotNull
            public final String getXcodeSdkBuildVersion() {
                String xcodeSdkBuildVersion = this._builder.getXcodeSdkBuildVersion();
                t.h(xcodeSdkBuildVersion, "_builder.getXcodeSdkBuildVersion()");
                return xcodeSdkBuildVersion;
            }

            @NotNull
            public final String getXcodeVersion() {
                String xcodeVersion = this._builder.getXcodeVersion();
                t.h(xcodeVersion, "_builder.getXcodeVersion()");
                return xcodeVersion;
            }

            public final boolean hasBuiltSdkVersion() {
                return this._builder.hasBuiltSdkVersion();
            }

            public final boolean hasCanMakePayments() {
                return this._builder.hasCanMakePayments();
            }

            public final boolean hasScreenScale() {
                return this._builder.hasScreenScale();
            }

            public final boolean hasSimulator() {
                return this._builder.hasSimulator();
            }

            public final boolean hasSystemBootTime() {
                return this._builder.hasSystemBootTime();
            }

            public final boolean hasXcodeBuildVersion() {
                return this._builder.hasXcodeBuildVersion();
            }

            public final boolean hasXcodeSdkBuildVersion() {
                return this._builder.hasXcodeSdkBuildVersion();
            }

            public final boolean hasXcodeVersion() {
                return this._builder.hasXcodeVersion();
            }

            public final /* synthetic */ void plusAssignAllSkadnetworkId(DslList<String, SkadnetworkIdProxy> dslList, Iterable<String> values) {
                t.i(dslList, "<this>");
                t.i(values, "values");
                addAllSkadnetworkId(dslList, values);
            }

            public final /* synthetic */ void plusAssignSkadnetworkId(DslList<String, SkadnetworkIdProxy> dslList, String value) {
                t.i(dslList, "<this>");
                t.i(value, "value");
                addSkadnetworkId(dslList, value);
            }

            public final void setBuiltSdkVersion(@NotNull String value) {
                t.i(value, "value");
                this._builder.setBuiltSdkVersion(value);
            }

            public final void setCanMakePayments(boolean z10) {
                this._builder.setCanMakePayments(z10);
            }

            public final void setScreenScale(int i10) {
                this._builder.setScreenScale(i10);
            }

            public final void setSimulator(boolean z10) {
                this._builder.setSimulator(z10);
            }

            public final /* synthetic */ void setSkadnetworkId(DslList dslList, int i10, String value) {
                t.i(dslList, "<this>");
                t.i(value, "value");
                this._builder.setSkadnetworkId(i10, value);
            }

            public final void setSystemBootTime(long j10) {
                this._builder.setSystemBootTime(j10);
            }

            public final void setXcodeBuildVersion(@NotNull String value) {
                t.i(value, "value");
                this._builder.setXcodeBuildVersion(value);
            }

            public final void setXcodeSdkBuildVersion(@NotNull String value) {
                t.i(value, "value");
                this._builder.setXcodeSdkBuildVersion(value);
            }

            public final void setXcodeVersion(@NotNull String value) {
                t.i(value, "value");
                this._builder.setXcodeVersion(value);
            }

            private Dsl(StaticDeviceInfoOuterClass.StaticDeviceInfo.Ios.Builder builder) {
                this._builder = builder;
            }
        }

        private IosKt() {
        }
    }

    private StaticDeviceInfoKt() {
    }

    @NotNull
    /* JADX INFO: renamed from: -initializeandroid, reason: not valid java name */
    public final StaticDeviceInfoOuterClass.StaticDeviceInfo.Android m4194initializeandroid(@NotNull l<? super AndroidKt.Dsl, k0> block) {
        t.i(block, "block");
        AndroidKt.Dsl.Companion companion = AndroidKt.Dsl.Companion;
        StaticDeviceInfoOuterClass.StaticDeviceInfo.Android.Builder builderNewBuilder = StaticDeviceInfoOuterClass.StaticDeviceInfo.Android.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        AndroidKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    /* JADX INFO: renamed from: -initializeios, reason: not valid java name */
    public final StaticDeviceInfoOuterClass.StaticDeviceInfo.Ios m4195initializeios(@NotNull l<? super IosKt.Dsl, k0> block) {
        t.i(block, "block");
        IosKt.Dsl.Companion companion = IosKt.Dsl.Companion;
        StaticDeviceInfoOuterClass.StaticDeviceInfo.Ios.Builder builderNewBuilder = StaticDeviceInfoOuterClass.StaticDeviceInfo.Ios.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        IosKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
