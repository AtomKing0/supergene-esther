package gatewayprotocol.v1;

import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.BidRequestEventOuterClass;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AppKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AppKt {

    @NotNull
    public static final AppKt INSTANCE = new AppKt();

    /* JADX INFO: compiled from: AppKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final BidRequestEventOuterClass.App.Builder _builder;

        /* JADX INFO: compiled from: AppKt.kt */
        public static final class CatProxy extends DslProxy {
            private CatProxy() {
            }
        }

        /* JADX INFO: compiled from: AppKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(BidRequestEventOuterClass.App.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(BidRequestEventOuterClass.App.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ BidRequestEventOuterClass.App _build() {
            BidRequestEventOuterClass.App appBuild = this._builder.build();
            t.h(appBuild, "_builder.build()");
            return appBuild;
        }

        public final /* synthetic */ void addAllCat(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllCat(values);
        }

        public final /* synthetic */ void addCat(DslList dslList, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addCat(value);
        }

        public final void clearBundle() {
            this._builder.clearBundle();
        }

        public final /* synthetic */ void clearCat(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearCat();
        }

        public final void clearName() {
            this._builder.clearName();
        }

        public final void clearStoreUrl() {
            this._builder.clearStoreUrl();
        }

        @NotNull
        public final String getBundle() {
            String bundle = this._builder.getBundle();
            t.h(bundle, "_builder.getBundle()");
            return bundle;
        }

        @NotNull
        public final DslList<String, CatProxy> getCat() {
            List<String> catList = this._builder.getCatList();
            t.h(catList, "_builder.getCatList()");
            return new DslList<>(catList);
        }

        @NotNull
        public final String getName() {
            String name = this._builder.getName();
            t.h(name, "_builder.getName()");
            return name;
        }

        @NotNull
        public final String getStoreUrl() {
            String storeUrl = this._builder.getStoreUrl();
            t.h(storeUrl, "_builder.getStoreUrl()");
            return storeUrl;
        }

        public final boolean hasBundle() {
            return this._builder.hasBundle();
        }

        public final boolean hasName() {
            return this._builder.hasName();
        }

        public final boolean hasStoreUrl() {
            return this._builder.hasStoreUrl();
        }

        public final /* synthetic */ void plusAssignAllCat(DslList<String, CatProxy> dslList, Iterable<String> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllCat(dslList, values);
        }

        public final /* synthetic */ void plusAssignCat(DslList<String, CatProxy> dslList, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addCat(dslList, value);
        }

        public final void setBundle(@NotNull String value) {
            t.i(value, "value");
            this._builder.setBundle(value);
        }

        public final /* synthetic */ void setCat(DslList dslList, int i10, String value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.setCat(i10, value);
        }

        public final void setName(@NotNull String value) {
            t.i(value, "value");
            this._builder.setName(value);
        }

        public final void setStoreUrl(@NotNull String value) {
            t.i(value, "value");
            this._builder.setStoreUrl(value);
        }

        private Dsl(BidRequestEventOuterClass.App.Builder builder) {
            this._builder = builder;
        }
    }

    private AppKt() {
    }
}
