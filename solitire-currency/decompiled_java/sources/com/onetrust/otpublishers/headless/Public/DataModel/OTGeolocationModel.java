package com.onetrust.otpublishers.headless.Public.DataModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class OTGeolocationModel {
    public String country;
    public String state;

    @NonNull
    public boolean compareLocation(@Nullable String str) {
        if (str == null) {
            return false;
        }
        return str.equalsIgnoreCase(this.country) || str.equalsIgnoreCase(this.state);
    }
}
