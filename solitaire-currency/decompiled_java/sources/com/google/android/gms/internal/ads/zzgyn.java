package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public class zzgyn extends IOException {
    private boolean zza;

    public zzgyn(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    static zzgym zza() {
        return new zzgym("Protocol message tag had invalid wire type.");
    }

    static zzgyn zzb() {
        return new zzgyn("Protocol message end-group tag did not match expected tag.");
    }

    static zzgyn zzc() {
        return new zzgyn("Protocol message contained an invalid tag (zero).");
    }

    static zzgyn zzd() {
        return new zzgyn("Protocol message had invalid UTF-8.");
    }

    static zzgyn zze() {
        return new zzgyn("CodedInputStream encountered a malformed varint.");
    }

    static zzgyn zzf() {
        return new zzgyn("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzgyn zzg() {
        return new zzgyn("Failed to parse the message.");
    }

    static zzgyn zzh() {
        return new zzgyn("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzgyn zzi() {
        return new zzgyn("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    final void zzj() {
        this.zza = true;
    }

    final boolean zzk() {
        return this.zza;
    }

    public zzgyn(String str) {
        super(str);
    }
}
