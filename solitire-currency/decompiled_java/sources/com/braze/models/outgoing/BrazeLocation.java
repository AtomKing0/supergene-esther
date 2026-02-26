package com.braze.models.outgoing;

import android.location.Location;
import androidx.compose.animation.core.b;
import bo.app.qd;
import bo.app.rd;
import com.braze.models.IBrazeLocation;
import com.braze.support.BrazeLogger;
import com.braze.support.ValidationUtils;
import h9.a;
import kotlin.jvm.internal.t;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class BrazeLocation implements IBrazeLocation {
    private static final qd Companion = new qd();
    private final Double _accuracy;
    private final Double _altitude;
    private final double _latitude;
    private final double _longitude;
    private final Double _verticalAccuracy;

    public BrazeLocation(double d10, double d11, Double d12, Double d13, Double d14) {
        this._latitude = d10;
        this._longitude = d11;
        this._altitude = d12;
        this._accuracy = d13;
        this._verticalAccuracy = d14;
        if (!ValidationUtils.isValidLocation(getLatitude(), getLongitude())) {
            throw new IllegalArgumentException("Unable to create BrazeLocation. Latitude and longitude values are bounded by ±90 and ±180 respectively".toString());
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BrazeLocation)) {
            return false;
        }
        BrazeLocation brazeLocation = (BrazeLocation) obj;
        return Double.compare(this._latitude, brazeLocation._latitude) == 0 && Double.compare(this._longitude, brazeLocation._longitude) == 0 && t.d(this._altitude, brazeLocation._altitude) && t.d(this._accuracy, brazeLocation._accuracy) && t.d(this._verticalAccuracy, brazeLocation._verticalAccuracy);
    }

    public Double getAccuracy() {
        return this._accuracy;
    }

    public Double getAltitude() {
        return this._altitude;
    }

    @Override // com.braze.models.IBrazeLocation
    public double getLatitude() {
        return this._latitude;
    }

    @Override // com.braze.models.IBrazeLocation
    public double getLongitude() {
        return this._longitude;
    }

    public Double getVerticalAccuracy() {
        return this._verticalAccuracy;
    }

    public int hashCode() {
        int iA = (b.a(this._longitude) + (b.a(this._latitude) * 31)) * 31;
        Double d10 = this._altitude;
        int iHashCode = (iA + (d10 == null ? 0 : d10.hashCode())) * 31;
        Double d11 = this._accuracy;
        int iHashCode2 = (iHashCode + (d11 == null ? 0 : d11.hashCode())) * 31;
        Double d12 = this._verticalAccuracy;
        return iHashCode2 + (d12 != null ? d12.hashCode() : 0);
    }

    public String toString() {
        return "BrazeLocation(_latitude=" + this._latitude + ", _longitude=" + this._longitude + ", _altitude=" + this._altitude + ", _accuracy=" + this._accuracy + ", _verticalAccuracy=" + this._verticalAccuracy + ')';
    }

    @Override // com.braze.models.IPutIntoJson
    public JSONObject forJsonPut() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("latitude", getLatitude());
            jSONObject.put("longitude", getLongitude());
            if (getAltitude() != null) {
                jSONObject.put("altitude", getAltitude());
            }
            if (getAccuracy() != null) {
                jSONObject.put("ll_accuracy", getAccuracy());
            }
            if (getVerticalAccuracy() != null) {
                jSONObject.put("alt_accuracy", getVerticalAccuracy());
            }
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (a) rd.f3772a, 4, (Object) null);
        }
        return jSONObject;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BrazeLocation(Location location) {
        this(location.getLatitude(), location.getLongitude(), location.hasAltitude() ? Double.valueOf(location.getAltitude()) : null, location.hasAccuracy() ? Double.valueOf(location.getAccuracy()) : null, qd.a(Companion, location));
        t.i(location, "location");
    }
}
