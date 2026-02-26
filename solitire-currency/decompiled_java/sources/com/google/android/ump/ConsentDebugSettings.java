package com.google.android.ump;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.consent_sdk.zzcl;
import com.google.android.gms.internal.consent_sdk.zzct;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class ConsentDebugSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f9951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9952b;

    /* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
    public static class Builder {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Context f9954b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f9956d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f9953a = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f9955c = 0;

        public Builder(@RecentlyNonNull Context context) {
            this.f9954b = context.getApplicationContext();
        }

        @RecentlyNonNull
        public Builder addTestDeviceHashedId(@RecentlyNonNull String str) {
            this.f9953a.add(str);
            return this;
        }

        @RecentlyNonNull
        public ConsentDebugSettings build() {
            boolean z10 = true;
            if (!zzct.zza(true) && !this.f9953a.contains(zzcl.zza(this.f9954b)) && !this.f9956d) {
                z10 = false;
            }
            return new ConsentDebugSettings(z10, this, null);
        }

        @RecentlyNonNull
        public Builder setDebugGeography(int i10) {
            this.f9955c = i10;
            return this;
        }

        @RecentlyNonNull
        @KeepForSdk
        public Builder setForceTesting(boolean z10) {
            this.f9956d = z10;
            return this;
        }
    }

    /* JADX INFO: compiled from: com.google.android.ump:user-messaging-platform@@3.0.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface DebugGeography {
        public static final int DEBUG_GEOGRAPHY_DISABLED = 0;
        public static final int DEBUG_GEOGRAPHY_EEA = 1;
        public static final int DEBUG_GEOGRAPHY_NOT_EEA = 2;
    }

    /* synthetic */ ConsentDebugSettings(boolean z10, Builder builder, zza zzaVar) {
        this.f9951a = z10;
        this.f9952b = builder.f9955c;
    }

    public int getDebugGeography() {
        return this.f9952b;
    }

    public boolean isTestDevice() {
        return this.f9951a;
    }
}
