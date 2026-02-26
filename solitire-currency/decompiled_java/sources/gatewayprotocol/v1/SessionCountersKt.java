package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.SessionCountersOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SessionCountersKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SessionCountersKt {

    @NotNull
    public static final SessionCountersKt INSTANCE = new SessionCountersKt();

    /* JADX INFO: compiled from: SessionCountersKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final SessionCountersOuterClass.SessionCounters.Builder _builder;

        /* JADX INFO: compiled from: SessionCountersKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(SessionCountersOuterClass.SessionCounters.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(SessionCountersOuterClass.SessionCounters.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ SessionCountersOuterClass.SessionCounters _build() {
            SessionCountersOuterClass.SessionCounters sessionCountersBuild = this._builder.build();
            t.h(sessionCountersBuild, "_builder.build()");
            return sessionCountersBuild;
        }

        public final void clearBannerImpressions() {
            this._builder.clearBannerImpressions();
        }

        public final void clearBannerLoadRequests() {
            this._builder.clearBannerLoadRequests();
        }

        public final void clearBannerRequestsAdm() {
            this._builder.clearBannerRequestsAdm();
        }

        public final void clearLoadRequests() {
            this._builder.clearLoadRequests();
        }

        public final void clearLoadRequestsAdm() {
            this._builder.clearLoadRequestsAdm();
        }

        public final int getBannerImpressions() {
            return this._builder.getBannerImpressions();
        }

        public final int getBannerLoadRequests() {
            return this._builder.getBannerLoadRequests();
        }

        public final int getBannerRequestsAdm() {
            return this._builder.getBannerRequestsAdm();
        }

        public final int getLoadRequests() {
            return this._builder.getLoadRequests();
        }

        public final int getLoadRequestsAdm() {
            return this._builder.getLoadRequestsAdm();
        }

        public final void setBannerImpressions(int i10) {
            this._builder.setBannerImpressions(i10);
        }

        public final void setBannerLoadRequests(int i10) {
            this._builder.setBannerLoadRequests(i10);
        }

        public final void setBannerRequestsAdm(int i10) {
            this._builder.setBannerRequestsAdm(i10);
        }

        public final void setLoadRequests(int i10) {
            this._builder.setLoadRequests(i10);
        }

        public final void setLoadRequestsAdm(int i10) {
            this._builder.setLoadRequestsAdm(i10);
        }

        private Dsl(SessionCountersOuterClass.SessionCounters.Builder builder) {
            this._builder = builder;
        }
    }

    private SessionCountersKt() {
    }
}
