package com.moloco.sdk.publisher.bidrequest;

import androidx.compose.runtime.internal.StabilityInferred;
import ca.d;
import da.c0;
import da.i1;
import da.s1;
import da.w1;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.h;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
@h
public final class Geo {
    public static final int $stable = 0;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @Nullable
    private final String city;

    @Nullable
    private final String country;

    @Nullable
    private final Float latitude;

    @Nullable
    private final Float longitude;

    @Nullable
    private final String region;

    @Nullable
    private final String zipCode;

    public static final class Companion {
        public /* synthetic */ Companion(k kVar) {
            this();
        }

        @NotNull
        public final KSerializer<Geo> serializer() {
            return Geo$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ Geo(int i10, String str, String str2, String str3, String str4, Float f10, Float f11, s1 s1Var) {
        if (63 != (i10 & 63)) {
            i1.a(i10, 63, Geo$$serializer.INSTANCE.getDescriptor());
        }
        this.city = str;
        this.country = str2;
        this.region = str3;
        this.zipCode = str4;
        this.latitude = f10;
        this.longitude = f11;
    }

    public static /* synthetic */ Geo copy$default(Geo geo, String str, String str2, String str3, String str4, Float f10, Float f11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = geo.city;
        }
        if ((i10 & 2) != 0) {
            str2 = geo.country;
        }
        String str5 = str2;
        if ((i10 & 4) != 0) {
            str3 = geo.region;
        }
        String str6 = str3;
        if ((i10 & 8) != 0) {
            str4 = geo.zipCode;
        }
        String str7 = str4;
        if ((i10 & 16) != 0) {
            f10 = geo.latitude;
        }
        Float f12 = f10;
        if ((i10 & 32) != 0) {
            f11 = geo.longitude;
        }
        return geo.copy(str, str5, str6, str7, f12, f11);
    }

    public static final /* synthetic */ void write$Self(Geo geo, d dVar, SerialDescriptor serialDescriptor) {
        w1 w1Var = w1.f24648a;
        dVar.h(serialDescriptor, 0, w1Var, geo.city);
        dVar.h(serialDescriptor, 1, w1Var, geo.country);
        dVar.h(serialDescriptor, 2, w1Var, geo.region);
        dVar.h(serialDescriptor, 3, w1Var, geo.zipCode);
        c0 c0Var = c0.f24548a;
        dVar.h(serialDescriptor, 4, c0Var, geo.latitude);
        dVar.h(serialDescriptor, 5, c0Var, geo.longitude);
    }

    @Nullable
    public final String component1() {
        return this.city;
    }

    @Nullable
    public final String component2() {
        return this.country;
    }

    @Nullable
    public final String component3() {
        return this.region;
    }

    @Nullable
    public final String component4() {
        return this.zipCode;
    }

    @Nullable
    public final Float component5() {
        return this.latitude;
    }

    @Nullable
    public final Float component6() {
        return this.longitude;
    }

    @NotNull
    public final Geo copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Float f10, @Nullable Float f11) {
        return new Geo(str, str2, str3, str4, f10, f11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Geo)) {
            return false;
        }
        Geo geo = (Geo) obj;
        return t.d(this.city, geo.city) && t.d(this.country, geo.country) && t.d(this.region, geo.region) && t.d(this.zipCode, geo.zipCode) && t.d(this.latitude, geo.latitude) && t.d(this.longitude, geo.longitude);
    }

    @Nullable
    public final String getCity() {
        return this.city;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final Float getLatitude() {
        return this.latitude;
    }

    @Nullable
    public final Float getLongitude() {
        return this.longitude;
    }

    @Nullable
    public final String getRegion() {
        return this.region;
    }

    @Nullable
    public final String getZipCode() {
        return this.zipCode;
    }

    public int hashCode() {
        String str = this.city;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.country;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.region;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.zipCode;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Float f10 = this.latitude;
        int iHashCode5 = (iHashCode4 + (f10 == null ? 0 : f10.hashCode())) * 31;
        Float f11 = this.longitude;
        return iHashCode5 + (f11 != null ? f11.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "Geo(city=" + this.city + ", country=" + this.country + ", region=" + this.region + ", zipCode=" + this.zipCode + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ')';
    }

    public Geo(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Float f10, @Nullable Float f11) {
        this.city = str;
        this.country = str2;
        this.region = str3;
        this.zipCode = str4;
        this.latitude = f10;
        this.longitude = f11;
    }
}
