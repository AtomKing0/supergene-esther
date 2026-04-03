package com.braze.events;

import bo.app.i90;
import kotlin.jvm.internal.t;

/* JADX INFO: loaded from: classes2.dex */
public final class BrazeSdkAuthenticationErrorEvent {
    private final i90 sdkAuthError;

    public BrazeSdkAuthenticationErrorEvent(i90 sdkAuthError) {
        t.i(sdkAuthError, "sdkAuthError");
        this.sdkAuthError = sdkAuthError;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BrazeSdkAuthenticationErrorEvent) && t.d(this.sdkAuthError, ((BrazeSdkAuthenticationErrorEvent) obj).sdkAuthError);
    }

    public int hashCode() {
        return this.sdkAuthError.hashCode();
    }

    public String toString() {
        return this.sdkAuthError.toString();
    }
}
