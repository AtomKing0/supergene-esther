package gatewayprotocol.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.Timestamp;
import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.TransactionEventRequestOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TransactionDataKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TransactionDataKt {

    @NotNull
    public static final TransactionDataKt INSTANCE = new TransactionDataKt();

    /* JADX INFO: compiled from: TransactionDataKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final TransactionEventRequestOuterClass.TransactionData.Builder _builder;

        /* JADX INFO: compiled from: TransactionDataKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(TransactionEventRequestOuterClass.TransactionData.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(TransactionEventRequestOuterClass.TransactionData.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ TransactionEventRequestOuterClass.TransactionData _build() {
            TransactionEventRequestOuterClass.TransactionData transactionDataBuild = this._builder.build();
            t.h(transactionDataBuild, "_builder.build()");
            return transactionDataBuild;
        }

        public final void clearEventId() {
            this._builder.clearEventId();
        }

        public final void clearProduct() {
            this._builder.clearProduct();
        }

        public final void clearProductId() {
            this._builder.clearProductId();
        }

        public final void clearReceipt() {
            this._builder.clearReceipt();
        }

        public final void clearTimestamp() {
            this._builder.clearTimestamp();
        }

        public final void clearTransaction() {
            this._builder.clearTransaction();
        }

        public final void clearTransactionId() {
            this._builder.clearTransactionId();
        }

        public final void clearTransactionState() {
            this._builder.clearTransactionState();
        }

        @NotNull
        public final ByteString getEventId() {
            ByteString eventId = this._builder.getEventId();
            t.h(eventId, "_builder.getEventId()");
            return eventId;
        }

        @NotNull
        public final String getProduct() {
            String product = this._builder.getProduct();
            t.h(product, "_builder.getProduct()");
            return product;
        }

        @NotNull
        public final String getProductId() {
            String productId = this._builder.getProductId();
            t.h(productId, "_builder.getProductId()");
            return productId;
        }

        @NotNull
        public final String getReceipt() {
            String receipt = this._builder.getReceipt();
            t.h(receipt, "_builder.getReceipt()");
            return receipt;
        }

        @NotNull
        public final Timestamp getTimestamp() {
            Timestamp timestamp = this._builder.getTimestamp();
            t.h(timestamp, "_builder.getTimestamp()");
            return timestamp;
        }

        @NotNull
        public final String getTransaction() {
            String transaction = this._builder.getTransaction();
            t.h(transaction, "_builder.getTransaction()");
            return transaction;
        }

        @NotNull
        public final String getTransactionId() {
            String transactionId = this._builder.getTransactionId();
            t.h(transactionId, "_builder.getTransactionId()");
            return transactionId;
        }

        @NotNull
        public final TransactionEventRequestOuterClass.TransactionState getTransactionState() {
            TransactionEventRequestOuterClass.TransactionState transactionState = this._builder.getTransactionState();
            t.h(transactionState, "_builder.getTransactionState()");
            return transactionState;
        }

        public final boolean hasReceipt() {
            return this._builder.hasReceipt();
        }

        public final boolean hasTimestamp() {
            return this._builder.hasTimestamp();
        }

        public final void setEventId(@NotNull ByteString value) {
            t.i(value, "value");
            this._builder.setEventId(value);
        }

        public final void setProduct(@NotNull String value) {
            t.i(value, "value");
            this._builder.setProduct(value);
        }

        public final void setProductId(@NotNull String value) {
            t.i(value, "value");
            this._builder.setProductId(value);
        }

        public final void setReceipt(@NotNull String value) {
            t.i(value, "value");
            this._builder.setReceipt(value);
        }

        public final void setTimestamp(@NotNull Timestamp value) {
            t.i(value, "value");
            this._builder.setTimestamp(value);
        }

        public final void setTransaction(@NotNull String value) {
            t.i(value, "value");
            this._builder.setTransaction(value);
        }

        public final void setTransactionId(@NotNull String value) {
            t.i(value, "value");
            this._builder.setTransactionId(value);
        }

        public final void setTransactionState(@NotNull TransactionEventRequestOuterClass.TransactionState value) {
            t.i(value, "value");
            this._builder.setTransactionState(value);
        }

        private Dsl(TransactionEventRequestOuterClass.TransactionData.Builder builder) {
            this._builder = builder;
        }
    }

    private TransactionDataKt() {
    }
}
