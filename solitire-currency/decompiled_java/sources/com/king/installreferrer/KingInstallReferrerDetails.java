package com.king.installreferrer;

import android.os.Bundle;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class KingInstallReferrerDetails {
    private static final String KEY_INSTALL_BEGIN_SERVER_TIMESTAMP = "install_begin_timestamp_server_seconds";
    private static final String KEY_INSTALL_BEGIN_TIMESTAMP = "install_begin_timestamp_seconds";
    private static final String KEY_INSTALL_REFERRER = "install_referrer";
    private static final String KEY_REFERRER_CLICK_SERVER_TIMESTAMP = "referrer_click_timestamp_server_seconds";
    private static final String KEY_REFERRER_CLICK_TIMESTAMP = "referrer_click_timestamp_seconds";
    private final Bundle mOriginalBundle;

    public KingInstallReferrerDetails(Bundle bundle) {
        this.mOriginalBundle = bundle;
    }

    public long getInstallBeginServerTimestampSeconds() {
        return this.mOriginalBundle.getLong(KEY_INSTALL_BEGIN_SERVER_TIMESTAMP);
    }

    public long getInstallBeginTimestampSeconds() {
        return this.mOriginalBundle.getLong(KEY_INSTALL_BEGIN_TIMESTAMP);
    }

    public String getInstallReferrer() {
        return this.mOriginalBundle.getString(KEY_INSTALL_REFERRER);
    }

    public long getReferrerClickServerTimestampSeconds() {
        return this.mOriginalBundle.getLong(KEY_REFERRER_CLICK_SERVER_TIMESTAMP);
    }

    public long getReferrerClickTimestampSeconds() {
        return this.mOriginalBundle.getLong(KEY_REFERRER_CLICK_TIMESTAMP);
    }
}
