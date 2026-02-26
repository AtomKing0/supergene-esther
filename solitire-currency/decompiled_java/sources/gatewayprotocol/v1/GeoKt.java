package gatewayprotocol.v1;

import com.google.protobuf.kotlin.ProtoDslMarker;
import gatewayprotocol.v1.BidRequestEventOuterClass;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GeoKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GeoKt {

    @NotNull
    public static final GeoKt INSTANCE = new GeoKt();

    /* JADX INFO: compiled from: GeoKt.kt */
    @ProtoDslMarker
    public static final class Dsl {

        @NotNull
        public static final Companion Companion = new Companion(null);

        @NotNull
        private final BidRequestEventOuterClass.Geo.Builder _builder;

        /* JADX INFO: compiled from: GeoKt.kt */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final /* synthetic */ Dsl _create(BidRequestEventOuterClass.Geo.Builder builder) {
                t.i(builder, "builder");
                return new Dsl(builder, null);
            }
        }

        public /* synthetic */ Dsl(BidRequestEventOuterClass.Geo.Builder builder, k kVar) {
            this(builder);
        }

        public final /* synthetic */ BidRequestEventOuterClass.Geo _build() {
            BidRequestEventOuterClass.Geo geoBuild = this._builder.build();
            t.h(geoBuild, "_builder.build()");
            return geoBuild;
        }

        public final void clearCity() {
            this._builder.clearCity();
        }

        public final void clearCountry() {
            this._builder.clearCountry();
        }

        public final void clearLat() {
            this._builder.clearLat();
        }

        public final void clearLon() {
            this._builder.clearLon();
        }

        public final void clearRegion() {
            this._builder.clearRegion();
        }

        public final void clearType() {
            this._builder.clearType();
        }

        public final void clearZip() {
            this._builder.clearZip();
        }

        @NotNull
        public final String getCity() {
            String city = this._builder.getCity();
            t.h(city, "_builder.getCity()");
            return city;
        }

        @NotNull
        public final String getCountry() {
            String country = this._builder.getCountry();
            t.h(country, "_builder.getCountry()");
            return country;
        }

        public final float getLat() {
            return this._builder.getLat();
        }

        public final float getLon() {
            return this._builder.getLon();
        }

        @NotNull
        public final String getRegion() {
            String region = this._builder.getRegion();
            t.h(region, "_builder.getRegion()");
            return region;
        }

        public final int getType() {
            return this._builder.getType();
        }

        @NotNull
        public final String getZip() {
            String zip = this._builder.getZip();
            t.h(zip, "_builder.getZip()");
            return zip;
        }

        public final boolean hasCity() {
            return this._builder.hasCity();
        }

        public final boolean hasCountry() {
            return this._builder.hasCountry();
        }

        public final boolean hasLat() {
            return this._builder.hasLat();
        }

        public final boolean hasLon() {
            return this._builder.hasLon();
        }

        public final boolean hasRegion() {
            return this._builder.hasRegion();
        }

        public final boolean hasType() {
            return this._builder.hasType();
        }

        public final boolean hasZip() {
            return this._builder.hasZip();
        }

        public final void setCity(@NotNull String value) {
            t.i(value, "value");
            this._builder.setCity(value);
        }

        public final void setCountry(@NotNull String value) {
            t.i(value, "value");
            this._builder.setCountry(value);
        }

        public final void setLat(float f10) {
            this._builder.setLat(f10);
        }

        public final void setLon(float f10) {
            this._builder.setLon(f10);
        }

        public final void setRegion(@NotNull String value) {
            t.i(value, "value");
            this._builder.setRegion(value);
        }

        public final void setType(int i10) {
            this._builder.setType(i10);
        }

        public final void setZip(@NotNull String value) {
            t.i(value, "value");
            this._builder.setZip(value);
        }

        private Dsl(BidRequestEventOuterClass.Geo.Builder builder) {
            this._builder = builder;
        }
    }

    private GeoKt() {
    }
}
