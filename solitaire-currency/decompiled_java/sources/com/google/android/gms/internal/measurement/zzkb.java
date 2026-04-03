package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public class zzkb extends IOException {
    private zzlg zza;

    public zzkb(String str) {
        super(str);
        this.zza = null;
    }

    static zzke zza() {
        return new zzke("Protocol message tag had invalid wire type.");
    }

    static zzkb zzb() {
        return new zzkb("Protocol message end-group tag did not match expected tag.");
    }

    static zzkb zzc() {
        return new zzkb("Protocol message contained an invalid tag (zero).");
    }

    static zzkb zzd() {
        return new zzkb("Protocol message had invalid UTF-8.");
    }

    static zzkb zze() {
        return new zzkb("CodedInputStream encountered a malformed varint.");
    }

    static zzkb zzf() {
        return new zzkb("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzkb zzg() {
        return new zzkb("Failed to parse the message.");
    }

    static zzkb zzh() {
        return new zzkb("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
