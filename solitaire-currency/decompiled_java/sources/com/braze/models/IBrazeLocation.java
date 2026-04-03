package com.braze.models;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IBrazeLocation extends IPutIntoJson<JSONObject> {
    double getLatitude();

    double getLongitude();
}
