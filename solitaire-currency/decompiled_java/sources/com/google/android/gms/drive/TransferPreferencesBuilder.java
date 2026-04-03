package com.google.android.gms.drive;

import com.google.android.gms.common.internal.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class TransferPreferencesBuilder {
    public static final TransferPreferences DEFAULT_PREFERENCES = new zza(1, true, 256);
    private int zzbl;
    private boolean zzbm;
    private int zzbn;

    static class zza implements TransferPreferences {
        private final int zzbl;
        private final boolean zzbm;
        private final int zzbn;

        zza(int i10, boolean z10, int i11) {
            this.zzbl = i10;
            this.zzbm = z10;
            this.zzbn = i11;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && zza.class == obj.getClass()) {
                zza zzaVar = (zza) obj;
                if (zzaVar.zzbl == this.zzbl && zzaVar.zzbm == this.zzbm && zzaVar.zzbn == this.zzbn) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.android.gms.drive.TransferPreferences
        public final int getBatteryUsagePreference() {
            return this.zzbn;
        }

        @Override // com.google.android.gms.drive.TransferPreferences
        public final int getNetworkPreference() {
            return this.zzbl;
        }

        public final int hashCode() {
            return Objects.hashCode(Integer.valueOf(this.zzbl), Boolean.valueOf(this.zzbm), Integer.valueOf(this.zzbn));
        }

        @Override // com.google.android.gms.drive.TransferPreferences
        public final boolean isRoamingAllowed() {
            return this.zzbm;
        }

        public final String toString() {
            return String.format("NetworkPreference: %s, IsRoamingAllowed %s, BatteryUsagePreference %s", Integer.valueOf(this.zzbl), Boolean.valueOf(this.zzbm), Integer.valueOf(this.zzbn));
        }
    }

    public TransferPreferencesBuilder() {
        this(DEFAULT_PREFERENCES);
    }

    public TransferPreferences build() {
        return new zza(this.zzbl, this.zzbm, this.zzbn);
    }

    public TransferPreferencesBuilder setBatteryUsagePreference(int i10) {
        this.zzbn = i10;
        return this;
    }

    public TransferPreferencesBuilder setIsRoamingAllowed(boolean z10) {
        this.zzbm = z10;
        return this;
    }

    public TransferPreferencesBuilder setNetworkPreference(int i10) {
        this.zzbl = i10;
        return this;
    }

    public TransferPreferencesBuilder(TransferPreferences transferPreferences) {
        this.zzbl = transferPreferences.getNetworkPreference();
        this.zzbm = transferPreferences.isRoamingAllowed();
        this.zzbn = transferPreferences.getBatteryUsagePreference();
    }

    public TransferPreferencesBuilder(FileUploadPreferences fileUploadPreferences) {
        this.zzbl = fileUploadPreferences.getNetworkTypePreference();
        this.zzbm = fileUploadPreferences.isRoamingAllowed();
        this.zzbn = fileUploadPreferences.getBatteryUsagePreference();
    }
}
