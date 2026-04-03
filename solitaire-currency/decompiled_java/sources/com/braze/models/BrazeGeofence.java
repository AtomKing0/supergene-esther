package com.braze.models;

import androidx.compose.animation.core.b;
import androidx.compose.foundation.e;
import bo.app.pa;
import kotlin.jvm.internal.t;
import org.json.JSONException;
import org.json.JSONObject;
import p9.j;

/* JADX INFO: loaded from: classes2.dex */
public final class BrazeGeofence implements IPutIntoJson<JSONObject>, Comparable<BrazeGeofence> {
    public static final pa Companion = new pa();
    private final boolean analyticsEnabledEnter;
    private final boolean analyticsEnabledExit;
    private final int cooldownEnterSeconds;
    private final int cooldownExitSeconds;
    private double distanceFromGeofenceRefresh;
    private final boolean enterEvents;
    private final boolean exitEvents;
    private final String id;
    private final JSONObject jsonObject;
    private final double latitude;
    private final double longitude;
    private final int notificationResponsivenessMs;
    private final int radiusMeter;

    public BrazeGeofence(JSONObject jsonObject, String id, double d10, double d11, int i10, int i11, int i12, boolean z10, boolean z11, boolean z12, boolean z13, int i13) {
        t.i(jsonObject, "jsonObject");
        t.i(id, "id");
        this.jsonObject = jsonObject;
        this.id = id;
        this.latitude = d10;
        this.longitude = d11;
        this.radiusMeter = i10;
        this.cooldownEnterSeconds = i11;
        this.cooldownExitSeconds = i12;
        this.analyticsEnabledEnter = z10;
        this.analyticsEnabledExit = z11;
        this.enterEvents = z12;
        this.exitEvents = z13;
        this.notificationResponsivenessMs = i13;
        this.distanceFromGeofenceRefresh = -1.0d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!t.d(BrazeGeofence.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        t.g(obj, "null cannot be cast to non-null type com.braze.models.BrazeGeofence");
        BrazeGeofence brazeGeofence = (BrazeGeofence) obj;
        return t.d(this.id, brazeGeofence.id) && this.latitude == brazeGeofence.latitude && this.longitude == brazeGeofence.longitude && this.radiusMeter == brazeGeofence.radiusMeter && this.cooldownEnterSeconds == brazeGeofence.cooldownEnterSeconds && this.cooldownExitSeconds == brazeGeofence.cooldownExitSeconds && this.analyticsEnabledEnter == brazeGeofence.analyticsEnabledEnter && this.analyticsEnabledExit == brazeGeofence.analyticsEnabledExit && this.enterEvents == brazeGeofence.enterEvents && this.exitEvents == brazeGeofence.exitEvents && this.notificationResponsivenessMs == brazeGeofence.notificationResponsivenessMs;
    }

    public final boolean equivalentServerData(BrazeGeofence otherGeofence) {
        t.i(otherGeofence, "otherGeofence");
        try {
            return t.d(this, otherGeofence);
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean getAnalyticsEnabledEnter() {
        return this.analyticsEnabledEnter;
    }

    public final boolean getAnalyticsEnabledExit() {
        return this.analyticsEnabledExit;
    }

    public final int getCooldownEnterSeconds() {
        return this.cooldownEnterSeconds;
    }

    public final int getCooldownExitSeconds() {
        return this.cooldownExitSeconds;
    }

    public final boolean getEnterEvents() {
        return this.enterEvents;
    }

    public final boolean getExitEvents() {
        return this.exitEvents;
    }

    public final String getId() {
        return this.id;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    public final int getNotificationResponsivenessMs() {
        return this.notificationResponsivenessMs;
    }

    public final int getRadiusMeter() {
        return this.radiusMeter;
    }

    public final double getRadiusMeters() {
        return this.radiusMeter;
    }

    public int hashCode() {
        return b.a(getRadiusMeters()) + ((((e.a(this.exitEvents) + ((e.a(this.enterEvents) + ((e.a(this.analyticsEnabledExit) + ((e.a(this.analyticsEnabledEnter) + ((((((((b.a(this.longitude) + ((b.a(this.latitude) + ((this.id.hashCode() + (this.jsonObject.hashCode() * 31)) * 31)) * 31)) * 31) + this.radiusMeter) * 31) + this.cooldownEnterSeconds) * 31) + this.cooldownExitSeconds) * 31)) * 31)) * 31)) * 31)) * 31) + this.notificationResponsivenessMs) * 31);
    }

    public final void setDistanceFromGeofenceRefresh(double d10) {
        this.distanceFromGeofenceRefresh = d10;
    }

    public String toString() {
        return j.h("BrazeGeofence{id=" + this.id + ", \n            |latitude, longitude=(" + this.latitude + ", " + this.longitude + "),\n            |radiusMeters=" + this.radiusMeter + ", \n            |cooldownEnterSeconds=" + this.cooldownEnterSeconds + ", \n            |cooldownExitSeconds=" + this.cooldownExitSeconds + ", \n            |analyticsEnabledEnter=" + this.analyticsEnabledEnter + ", \n            |analyticsEnabledExit=" + this.analyticsEnabledExit + ", \n            |enterEvents=" + this.enterEvents + ", \n            |exitEvents=" + this.exitEvents + ", \n            |notificationResponsivenessMs=" + this.notificationResponsivenessMs + ", \n            |distanceFromGeofenceRefresh=" + this.distanceFromGeofenceRefresh + " }\n            |\n        ", null, 1, null);
    }

    @Override // java.lang.Comparable
    public int compareTo(BrazeGeofence other) {
        t.i(other, "other");
        double d10 = this.distanceFromGeofenceRefresh;
        return (d10 != -1.0d && d10 < other.distanceFromGeofenceRefresh) ? -1 : 1;
    }

    @Override // com.braze.models.IPutIntoJson
    public JSONObject forJsonPut() {
        return this.jsonObject;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public BrazeGeofence(JSONObject jsonObject) throws JSONException {
        t.i(jsonObject, "jsonObject");
        String string = jsonObject.getString("id");
        t.h(string, "jsonObject.getString(ID)");
        this(jsonObject, string, jsonObject.getDouble("latitude"), jsonObject.getDouble("longitude"), jsonObject.getInt("radius"), jsonObject.getInt("cooldown_enter"), jsonObject.getInt("cooldown_exit"), jsonObject.getBoolean("analytics_enabled_enter"), jsonObject.getBoolean("analytics_enabled_exit"), jsonObject.optBoolean("enter_events", true), jsonObject.optBoolean("exit_events", true), jsonObject.optInt("notification_responsiveness", 30000));
    }
}
