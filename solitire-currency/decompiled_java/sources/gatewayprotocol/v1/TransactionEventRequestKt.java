package gatewayprotocol.v1;

import com.google.protobuf.kotlin.DslList;
import com.google.protobuf.kotlin.DslProxy;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.DynamicDeviceInfoOuterClass;
import gatewayprotocol.v1.StaticDeviceInfoOuterClass;
import gatewayprotocol.v1.TransactionEventRequestOuterClass;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TransactionEventRequestKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TransactionEventRequestKt {

    @NotNull
    public static final TransactionEventRequestKt INSTANCE = new TransactionEventRequestKt();

    /* JADX INFO: compiled from: TransactionEventRequestKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final TransactionEventRequestOuterClass.TransactionEventRequest.Builder _builder;

        /* JADX INFO: compiled from: TransactionEventRequestKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(TransactionEventRequestOuterClass.TransactionEventRequest.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        /* JADX INFO: compiled from: TransactionEventRequestKt.kt */
        public static final class TransactionDataProxy extends DslProxy {
            private TransactionDataProxy() {
            }
        }

        public /* synthetic */ Dsl(TransactionEventRequestOuterClass.TransactionEventRequest.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ TransactionEventRequestOuterClass.TransactionEventRequest _build() {
            TransactionEventRequestOuterClass.TransactionEventRequest transactionEventRequestBuild = this._builder.build();
            t.h(transactionEventRequestBuild, "_builder.build()");
            return transactionEventRequestBuild;
        }

        public final /* synthetic */ void addAllTransactionData(DslList dslList, Iterable values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            this._builder.addAllTransactionData(values);
        }

        public final /* synthetic */ void addTransactionData(DslList dslList, TransactionEventRequestOuterClass.TransactionData value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.addTransactionData(value);
        }

        public final void clearAppStore() {
            this._builder.clearAppStore();
        }

        public final void clearCustomStore() {
            this._builder.clearCustomStore();
        }

        public final void clearDynamicDeviceInfo() {
            this._builder.clearDynamicDeviceInfo();
        }

        public final void clearStaticDeviceInfo() {
            this._builder.clearStaticDeviceInfo();
        }

        public final /* synthetic */ void clearTransactionData(DslList dslList) {
            t.i(dslList, "<this>");
            this._builder.clearTransactionData();
        }

        @NotNull
        public final TransactionEventRequestOuterClass.StoreType getAppStore() {
            TransactionEventRequestOuterClass.StoreType appStore = this._builder.getAppStore();
            t.h(appStore, "_builder.getAppStore()");
            return appStore;
        }

        @NotNull
        public final String getCustomStore() {
            String customStore = this._builder.getCustomStore();
            t.h(customStore, "_builder.getCustomStore()");
            return customStore;
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

        public final /* synthetic */ DslList getTransactionData() {
            List<TransactionEventRequestOuterClass.TransactionData> transactionDataList = this._builder.getTransactionDataList();
            t.h(transactionDataList, "_builder.getTransactionDataList()");
            return new DslList(transactionDataList);
        }

        public final boolean hasDynamicDeviceInfo() {
            return this._builder.hasDynamicDeviceInfo();
        }

        public final boolean hasStaticDeviceInfo() {
            return this._builder.hasStaticDeviceInfo();
        }

        public final /* synthetic */ void plusAssignAllTransactionData(DslList<TransactionEventRequestOuterClass.TransactionData, TransactionDataProxy> dslList, Iterable<TransactionEventRequestOuterClass.TransactionData> values) {
            t.i(dslList, "<this>");
            t.i(values, "values");
            addAllTransactionData(dslList, values);
        }

        public final /* synthetic */ void plusAssignTransactionData(DslList<TransactionEventRequestOuterClass.TransactionData, TransactionDataProxy> dslList, TransactionEventRequestOuterClass.TransactionData value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            addTransactionData(dslList, value);
        }

        public final void setAppStore(@NotNull TransactionEventRequestOuterClass.StoreType value) {
            t.i(value, "value");
            this._builder.setAppStore(value);
        }

        public final void setCustomStore(@NotNull String value) {
            t.i(value, "value");
            this._builder.setCustomStore(value);
        }

        public final void setDynamicDeviceInfo(@NotNull DynamicDeviceInfoOuterClass.DynamicDeviceInfo value) {
            t.i(value, "value");
            this._builder.setDynamicDeviceInfo(value);
        }

        public final void setStaticDeviceInfo(@NotNull StaticDeviceInfoOuterClass.StaticDeviceInfo value) {
            t.i(value, "value");
            this._builder.setStaticDeviceInfo(value);
        }

        public final /* synthetic */ void setTransactionData(DslList dslList, int i10, TransactionEventRequestOuterClass.TransactionData value) {
            t.i(dslList, "<this>");
            t.i(value, "value");
            this._builder.setTransactionData(i10, value);
        }

        private Dsl(TransactionEventRequestOuterClass.TransactionEventRequest.Builder builder) {
            this._builder = builder;
        }
    }

    private TransactionEventRequestKt() {
    }
}
