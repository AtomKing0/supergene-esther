package gatewayprotocol.v1;

import com.google.protobuf.Timestamp;
import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.BidRequestEventOuterClass;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BidRequestEventKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BidRequestEventKt {

    @NotNull
    public static final BidRequestEventKt INSTANCE = new BidRequestEventKt();

    /* JADX INFO: compiled from: BidRequestEventKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final BidRequestEventOuterClass.BidRequestEvent.Builder _builder;

        /* JADX INFO: compiled from: BidRequestEventKt.kt */
        public static final class BlockedAppsProxy extends DslProxy {
            private BlockedAppsProxy() {
            }
        }

        /* JADX INFO: compiled from: BidRequestEventKt.kt */
        public static final class BlockedCategoriesProxy extends DslProxy {
            private BlockedCategoriesProxy() {
            }
        }

        /* JADX INFO: compiled from: BidRequestEventKt.kt */
        public static final class BlockedDomainsProxy extends DslProxy {
            private BlockedDomainsProxy() {
            }
        }

        /* JADX INFO: compiled from: BidRequestEventKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(BidRequestEventOuterClass.BidRequestEvent.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(BidRequestEventOuterClass.BidRequestEvent.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ BidRequestEventOuterClass.BidRequestEvent _build() {
            BidRequestEventOuterClass.BidRequestEvent bidRequestEventBuild = this._builder.build();
            t.h(bidRequestEventBuild, "_builder.build()");
            return bidRequestEventBuild;
        }

        public final /* synthetic */ void addAllBlockedApps(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllBlockedApps(values);
        }

        public final /* synthetic */ void addAllBlockedCategories(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllBlockedCategories(values);
        }

        public final /* synthetic */ void addAllBlockedDomains(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllBlockedDomains(values);
        }

        public final /* synthetic */ void addBlockedApps(DslList dslList, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addBlockedApps(value);
        }

        public final /* synthetic */ void addBlockedCategories(DslList dslList, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addBlockedCategories(value);
        }

        public final /* synthetic */ void addBlockedDomains(DslList dslList, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addBlockedDomains(value);
        }

        public final void clearAdType() {
            this._builder.clearAdType();
        }

        public final void clearApp() {
            this._builder.clearApp();
        }

        public final void clearBidFloor() {
            this._builder.clearBidFloor();
        }

        public final void clearBidFloorCurrency() {
            this._builder.clearBidFloorCurrency();
        }

        public final /* synthetic */ void clearBlockedApps(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearBlockedApps();
        }

        public final /* synthetic */ void clearBlockedCategories(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearBlockedCategories();
        }

        public final /* synthetic */ void clearBlockedDomains(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearBlockedDomains();
        }

        public final void clearBundle() {
            this._builder.clearBundle();
        }

        public final void clearDevice() {
            this._builder.clearDevice();
        }

        public final void clearDisplayManager() {
            this._builder.clearDisplayManager();
        }

        public final void clearGameId() {
            this._builder.clearGameId();
        }

        public final void clearGeo() {
            this._builder.clearGeo();
        }

        public final void clearMediationAuctionId() {
            this._builder.clearMediationAuctionId();
        }

        public final void clearMediationServer() {
            this._builder.clearMediationServer();
        }

        public final void clearPlacementId() {
            this._builder.clearPlacementId();
        }

        public final void clearPublisher() {
            this._builder.clearPublisher();
        }

        public final void clearRawBidRequest() {
            this._builder.clearRawBidRequest();
        }

        public final void clearSdkVersion() {
            this._builder.clearSdkVersion();
        }

        public final void clearStatus() {
            this._builder.clearStatus();
        }

        public final void clearTest() {
            this._builder.clearTest();
        }

        public final void clearTestId() {
            this._builder.clearTestId();
        }

        public final void clearTimestamp() {
            this._builder.clearTimestamp();
        }

        public final void clearTmax() {
            this._builder.clearTmax();
        }

        public final void clearTokenInfo() {
            this._builder.clearTokenInfo();
        }

        public final void clearUser() {
            this._builder.clearUser();
        }

        @NotNull
        public final String getAdType() {
            String adType = this._builder.getAdType();
            t.h(adType, "_builder.getAdType()");
            return adType;
        }

        @NotNull
        public final BidRequestEventOuterClass.App getApp() {
            BidRequestEventOuterClass.App app = this._builder.getApp();
            t.h(app, "_builder.getApp()");
            return app;
        }

        @Nullable
        public final BidRequestEventOuterClass.App getAppOrNull(@NotNull Dsl dsl) {
            t.i(dsl, "<this>");
            return BidRequestEventKtKt.getAppOrNull(dsl._builder);
        }

        public final float getBidFloor() {
            return this._builder.getBidFloor();
        }

        @NotNull
        public final String getBidFloorCurrency() {
            String bidFloorCurrency = this._builder.getBidFloorCurrency();
            t.h(bidFloorCurrency, "_builder.getBidFloorCurrency()");
            return bidFloorCurrency;
        }

        @NotNull
        public final DslList<String, BlockedAppsProxy> getBlockedApps() {
            List<String> blockedAppsList = this._builder.getBlockedAppsList();
            t.h(blockedAppsList, "_builder.getBlockedAppsList()");
            return new DslList<>(blockedAppsList);
        }

        @NotNull
        public final DslList<String, BlockedCategoriesProxy> getBlockedCategories() {
            List<String> blockedCategoriesList = this._builder.getBlockedCategoriesList();
            t.h(blockedCategoriesList, "_builder.getBlockedCategoriesList()");
            return new DslList<>(blockedCategoriesList);
        }

        @NotNull
        public final DslList<String, BlockedDomainsProxy> getBlockedDomains() {
            List<String> blockedDomainsList = this._builder.getBlockedDomainsList();
            t.h(blockedDomainsList, "_builder.getBlockedDomainsList()");
            return new DslList<>(blockedDomainsList);
        }

        @NotNull
        public final String getBundle() {
            String bundle = this._builder.getBundle();
            t.h(bundle, "_builder.getBundle()");
            return bundle;
        }

        @NotNull
        public final BidRequestEventOuterClass.Device getDevice() {
            BidRequestEventOuterClass.Device device = this._builder.getDevice();
            t.h(device, "_builder.getDevice()");
            return device;
        }

        @Nullable
        public final BidRequestEventOuterClass.Device getDeviceOrNull(@NotNull Dsl dsl) {
            t.i(dsl, "<this>");
            return BidRequestEventKtKt.getDeviceOrNull(dsl._builder);
        }

        @NotNull
        public final String getDisplayManager() {
            String displayManager = this._builder.getDisplayManager();
            t.h(displayManager, "_builder.getDisplayManager()");
            return displayManager;
        }

        @NotNull
        public final String getGameId() {
            String gameId = this._builder.getGameId();
            t.h(gameId, "_builder.getGameId()");
            return gameId;
        }

        @NotNull
        public final BidRequestEventOuterClass.Geo getGeo() {
            BidRequestEventOuterClass.Geo geo = this._builder.getGeo();
            t.h(geo, "_builder.getGeo()");
            return geo;
        }

        @Nullable
        public final BidRequestEventOuterClass.Geo getGeoOrNull(@NotNull Dsl dsl) {
            t.i(dsl, "<this>");
            return BidRequestEventKtKt.getGeoOrNull(dsl._builder);
        }

        @NotNull
        public final String getMediationAuctionId() {
            String mediationAuctionId = this._builder.getMediationAuctionId();
            t.h(mediationAuctionId, "_builder.getMediationAuctionId()");
            return mediationAuctionId;
        }

        @NotNull
        public final String getMediationServer() {
            String mediationServer = this._builder.getMediationServer();
            t.h(mediationServer, "_builder.getMediationServer()");
            return mediationServer;
        }

        @NotNull
        public final String getPlacementId() {
            String placementId = this._builder.getPlacementId();
            t.h(placementId, "_builder.getPlacementId()");
            return placementId;
        }

        @NotNull
        public final BidRequestEventOuterClass.Publisher getPublisher() {
            BidRequestEventOuterClass.Publisher publisher = this._builder.getPublisher();
            t.h(publisher, "_builder.getPublisher()");
            return publisher;
        }

        @Nullable
        public final BidRequestEventOuterClass.Publisher getPublisherOrNull(@NotNull Dsl dsl) {
            t.i(dsl, "<this>");
            return BidRequestEventKtKt.getPublisherOrNull(dsl._builder);
        }

        @NotNull
        public final String getRawBidRequest() {
            String rawBidRequest = this._builder.getRawBidRequest();
            t.h(rawBidRequest, "_builder.getRawBidRequest()");
            return rawBidRequest;
        }

        @NotNull
        public final String getSdkVersion() {
            String sdkVersion = this._builder.getSdkVersion();
            t.h(sdkVersion, "_builder.getSdkVersion()");
            return sdkVersion;
        }

        @NotNull
        public final BidRequestEventOuterClass.GatewayStatus getStatus() {
            BidRequestEventOuterClass.GatewayStatus status = this._builder.getStatus();
            t.h(status, "_builder.getStatus()");
            return status;
        }

        @Nullable
        public final BidRequestEventOuterClass.GatewayStatus getStatusOrNull(@NotNull Dsl dsl) {
            t.i(dsl, "<this>");
            return BidRequestEventKtKt.getStatusOrNull(dsl._builder);
        }

        public final boolean getTest() {
            return this._builder.getTest();
        }

        public final int getTestId() {
            return this._builder.getTestId();
        }

        @NotNull
        public final Timestamp getTimestamp() {
            Timestamp timestamp = this._builder.getTimestamp();
            t.h(timestamp, "_builder.getTimestamp()");
            return timestamp;
        }

        public final long getTmax() {
            return this._builder.getTmax();
        }

        @NotNull
        public final BidRequestEventOuterClass.TokenInfo getTokenInfo() {
            BidRequestEventOuterClass.TokenInfo tokenInfo = this._builder.getTokenInfo();
            t.h(tokenInfo, "_builder.getTokenInfo()");
            return tokenInfo;
        }

        @Nullable
        public final BidRequestEventOuterClass.TokenInfo getTokenInfoOrNull(@NotNull Dsl dsl) {
            t.i(dsl, "<this>");
            return BidRequestEventKtKt.getTokenInfoOrNull(dsl._builder);
        }

        @NotNull
        public final BidRequestEventOuterClass.User getUser() {
            BidRequestEventOuterClass.User user = this._builder.getUser();
            t.h(user, "_builder.getUser()");
            return user;
        }

        @Nullable
        public final BidRequestEventOuterClass.User getUserOrNull(@NotNull Dsl dsl) {
            t.i(dsl, "<this>");
            return BidRequestEventKtKt.getUserOrNull(dsl._builder);
        }

        public final boolean hasAdType() {
            return this._builder.hasAdType();
        }

        public final boolean hasApp() {
            return this._builder.hasApp();
        }

        public final boolean hasBidFloor() {
            return this._builder.hasBidFloor();
        }

        public final boolean hasBidFloorCurrency() {
            return this._builder.hasBidFloorCurrency();
        }

        public final boolean hasBundle() {
            return this._builder.hasBundle();
        }

        public final boolean hasDevice() {
            return this._builder.hasDevice();
        }

        public final boolean hasDisplayManager() {
            return this._builder.hasDisplayManager();
        }

        public final boolean hasGameId() {
            return this._builder.hasGameId();
        }

        public final boolean hasGeo() {
            return this._builder.hasGeo();
        }

        public final boolean hasMediationServer() {
            return this._builder.hasMediationServer();
        }

        public final boolean hasPlacementId() {
            return this._builder.hasPlacementId();
        }

        public final boolean hasPublisher() {
            return this._builder.hasPublisher();
        }

        public final boolean hasRawBidRequest() {
            return this._builder.hasRawBidRequest();
        }

        public final boolean hasSdkVersion() {
            return this._builder.hasSdkVersion();
        }

        public final boolean hasStatus() {
            return this._builder.hasStatus();
        }

        public final boolean hasTest() {
            return this._builder.hasTest();
        }

        public final boolean hasTestId() {
            return this._builder.hasTestId();
        }

        public final boolean hasTimestamp() {
            return this._builder.hasTimestamp();
        }

        public final boolean hasTmax() {
            return this._builder.hasTmax();
        }

        public final boolean hasTokenInfo() {
            return this._builder.hasTokenInfo();
        }

        public final boolean hasUser() {
            return this._builder.hasUser();
        }

        public final /* synthetic */ void plusAssignAllBlockedApps(DslList<String, BlockedAppsProxy> dslList, Iterable<String> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllBlockedApps(dslList, values);
        }

        public final /* synthetic */ void plusAssignAllBlockedCategories(DslList<String, BlockedCategoriesProxy> dslList, Iterable<String> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllBlockedCategories(dslList, values);
        }

        public final /* synthetic */ void plusAssignAllBlockedDomains(DslList<String, BlockedDomainsProxy> dslList, Iterable<String> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllBlockedDomains(dslList, values);
        }

        public final /* synthetic */ void plusAssignBlockedApps(DslList<String, BlockedAppsProxy> dslList, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addBlockedApps(dslList, value);
        }

        public final /* synthetic */ void plusAssignBlockedCategories(DslList<String, BlockedCategoriesProxy> dslList, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addBlockedCategories(dslList, value);
        }

        public final /* synthetic */ void plusAssignBlockedDomains(DslList<String, BlockedDomainsProxy> dslList, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addBlockedDomains(dslList, value);
        }

        public final void setAdType(@NotNull String value) {
            t.i(value, "value");
            this._builder.setAdType(value);
        }

        public final void setApp(@NotNull BidRequestEventOuterClass.App value) {
            t.i(value, "value");
            this._builder.setApp(value);
        }

        public final void setBidFloor(float f10) {
            this._builder.setBidFloor(f10);
        }

        public final void setBidFloorCurrency(@NotNull String value) {
            t.i(value, "value");
            this._builder.setBidFloorCurrency(value);
        }

        public final /* synthetic */ void setBlockedApps(DslList dslList, int i10, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.setBlockedApps(i10, value);
        }

        public final /* synthetic */ void setBlockedCategories(DslList dslList, int i10, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.setBlockedCategories(i10, value);
        }

        public final /* synthetic */ void setBlockedDomains(DslList dslList, int i10, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.setBlockedDomains(i10, value);
        }

        public final void setBundle(@NotNull String value) {
            t.i(value, "value");
            this._builder.setBundle(value);
        }

        public final void setDevice(@NotNull BidRequestEventOuterClass.Device value) {
            t.i(value, "value");
            this._builder.setDevice(value);
        }

        public final void setDisplayManager(@NotNull String value) {
            t.i(value, "value");
            this._builder.setDisplayManager(value);
        }

        public final void setGameId(@NotNull String value) {
            t.i(value, "value");
            this._builder.setGameId(value);
        }

        public final void setGeo(@NotNull BidRequestEventOuterClass.Geo value) {
            t.i(value, "value");
            this._builder.setGeo(value);
        }

        public final void setMediationAuctionId(@NotNull String value) {
            t.i(value, "value");
            this._builder.setMediationAuctionId(value);
        }

        public final void setMediationServer(@NotNull String value) {
            t.i(value, "value");
            this._builder.setMediationServer(value);
        }

        public final void setPlacementId(@NotNull String value) {
            t.i(value, "value");
            this._builder.setPlacementId(value);
        }

        public final void setPublisher(@NotNull BidRequestEventOuterClass.Publisher value) {
            t.i(value, "value");
            this._builder.setPublisher(value);
        }

        public final void setRawBidRequest(@NotNull String value) {
            t.i(value, "value");
            this._builder.setRawBidRequest(value);
        }

        public final void setSdkVersion(@NotNull String value) {
            t.i(value, "value");
            this._builder.setSdkVersion(value);
        }

        public final void setStatus(@NotNull BidRequestEventOuterClass.GatewayStatus value) {
            t.i(value, "value");
            this._builder.setStatus(value);
        }

        public final void setTest(boolean z10) {
            this._builder.setTest(z10);
        }

        public final void setTestId(int i10) {
            this._builder.setTestId(i10);
        }

        public final void setTimestamp(@NotNull Timestamp value) {
            t.i(value, "value");
            this._builder.setTimestamp(value);
        }

        public final void setTmax(long j10) {
            this._builder.setTmax(j10);
        }

        public final void setTokenInfo(@NotNull BidRequestEventOuterClass.TokenInfo value) {
            t.i(value, "value");
            this._builder.setTokenInfo(value);
        }

        public final void setUser(@NotNull BidRequestEventOuterClass.User value) {
            t.i(value, "value");
            this._builder.setUser(value);
        }

        private Dsl(BidRequestEventOuterClass.BidRequestEvent.Builder builder) {
            this._builder = builder;
        }
    }

    private BidRequestEventKt() {
    }
}
