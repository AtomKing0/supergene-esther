package gatewayprotocol.v1;

import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.CampaignStateOuterClass;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CampaignStateKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CampaignStateKt {

    @NotNull
    public static final CampaignStateKt INSTANCE = new CampaignStateKt();

    /* JADX INFO: compiled from: CampaignStateKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final CampaignStateOuterClass.CampaignState.Builder _builder;

        /* JADX INFO: compiled from: CampaignStateKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(CampaignStateOuterClass.CampaignState.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        /* JADX INFO: compiled from: CampaignStateKt.kt */
        public static final class LoadedCampaignsProxy extends DslProxy {
            private LoadedCampaignsProxy() {
            }
        }

        /* JADX INFO: compiled from: CampaignStateKt.kt */
        public static final class ShownCampaignsProxy extends DslProxy {
            private ShownCampaignsProxy() {
            }
        }

        public /* synthetic */ Dsl(CampaignStateOuterClass.CampaignState.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ CampaignStateOuterClass.CampaignState _build() {
            CampaignStateOuterClass.CampaignState campaignStateBuild = this._builder.build();
            t.h(campaignStateBuild, "_builder.build()");
            return campaignStateBuild;
        }

        public final /* synthetic */ void addAllLoadedCampaigns(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllLoadedCampaigns(values);
        }

        public final /* synthetic */ void addAllShownCampaigns(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllShownCampaigns(values);
        }

        public final /* synthetic */ void addLoadedCampaigns(DslList dslList, CampaignStateOuterClass.Campaign value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addLoadedCampaigns(value);
        }

        public final /* synthetic */ void addShownCampaigns(DslList dslList, CampaignStateOuterClass.Campaign value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addShownCampaigns(value);
        }

        public final /* synthetic */ void clearLoadedCampaigns(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearLoadedCampaigns();
        }

        public final /* synthetic */ void clearShownCampaigns(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearShownCampaigns();
        }

        public final /* synthetic */ DslList getLoadedCampaigns() {
            List<CampaignStateOuterClass.Campaign> loadedCampaignsList = this._builder.getLoadedCampaignsList();
            t.h(loadedCampaignsList, "_builder.getLoadedCampaignsList()");
            return new DslList(loadedCampaignsList);
        }

        public final /* synthetic */ DslList getShownCampaigns() {
            List<CampaignStateOuterClass.Campaign> shownCampaignsList = this._builder.getShownCampaignsList();
            t.h(shownCampaignsList, "_builder.getShownCampaignsList()");
            return new DslList(shownCampaignsList);
        }

        public final /* synthetic */ void plusAssignAllLoadedCampaigns(DslList<CampaignStateOuterClass.Campaign, LoadedCampaignsProxy> dslList, Iterable<CampaignStateOuterClass.Campaign> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllLoadedCampaigns(dslList, values);
        }

        public final /* synthetic */ void plusAssignAllShownCampaigns(DslList<CampaignStateOuterClass.Campaign, ShownCampaignsProxy> dslList, Iterable<CampaignStateOuterClass.Campaign> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllShownCampaigns(dslList, values);
        }

        public final /* synthetic */ void plusAssignLoadedCampaigns(DslList<CampaignStateOuterClass.Campaign, LoadedCampaignsProxy> dslList, CampaignStateOuterClass.Campaign value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addLoadedCampaigns(dslList, value);
        }

        public final /* synthetic */ void plusAssignShownCampaigns(DslList<CampaignStateOuterClass.Campaign, ShownCampaignsProxy> dslList, CampaignStateOuterClass.Campaign value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addShownCampaigns(dslList, value);
        }

        public final /* synthetic */ void setLoadedCampaigns(DslList dslList, int i10, CampaignStateOuterClass.Campaign value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.setLoadedCampaigns(i10, value);
        }

        public final /* synthetic */ void setShownCampaigns(DslList dslList, int i10, CampaignStateOuterClass.Campaign value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.setShownCampaigns(i10, value);
        }

        private Dsl(CampaignStateOuterClass.CampaignState.Builder builder) {
            this._builder = builder;
        }
    }

    private CampaignStateKt() {
    }
}
