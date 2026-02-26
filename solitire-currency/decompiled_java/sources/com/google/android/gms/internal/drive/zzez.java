package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzez extends zzkk<zzez, zza> implements zzls {
    private static final zzez zzhj;
    private static volatile zzmb<zzez> zzhk;
    private int zzhd;
    private byte zzhi = 2;
    private int zzhe = 1;
    private long zzhf = -1;
    private long zzhg = -1;
    private long zzhh = -1;

    public static final class zza extends zzkk.zza<zzez, zza> implements zzls {
        private zza() {
            super(zzez.zzhj);
        }

        public final zza zzc(long j10) {
            zzdb();
            ((zzez) this.zzru).setSequenceNumber(j10);
            return this;
        }

        public final zza zzd(long j10) {
            zzdb();
            ((zzez) this.zzru).zza(j10);
            return this;
        }

        public final zza zze(long j10) {
            zzdb();
            ((zzez) this.zzru).zzb(j10);
            return this;
        }

        public final zza zzk(int i10) {
            zzdb();
            ((zzez) this.zzru).zzj(1);
            return this;
        }

        /* synthetic */ zza(zzfa zzfaVar) {
            this();
        }
    }

    static {
        zzez zzezVar = new zzez();
        zzhj = zzezVar;
        zzkk.zza((Class<zzez>) zzez.class, zzezVar);
    }

    private zzez() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSequenceNumber(long j10) {
        this.zzhd |= 2;
        this.zzhf = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(long j10) {
        this.zzhd |= 4;
        this.zzhg = j10;
    }

    public static zza zzaj() {
        return zzhj.zzcw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzb(long j10) {
        this.zzhd |= 8;
        this.zzhh = j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzj(int i10) {
        this.zzhd |= 1;
        this.zzhe = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.drive.zzkk$zzb, com.google.android.gms.internal.drive.zzmb<com.google.android.gms.internal.drive.zzez>] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    @Override // com.google.android.gms.internal.drive.zzkk
    protected final Object zza(int i10, Object obj, Object obj2) {
        ?? r32;
        zzfa zzfaVar = null;
        switch (zzfa.zzhl[i10 - 1]) {
            case 1:
                return new zzez();
            case 2:
                return new zza(zzfaVar);
            case 3:
                return zzkk.zza(zzhj, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0004\u0001Ԅ\u0000\u0002Ԑ\u0001\u0003Ԑ\u0002\u0004Ԑ\u0003", new Object[]{"zzhd", "zzhe", "zzhf", "zzhg", "zzhh"});
            case 4:
                return zzhj;
            case 5:
                zzmb<zzez> zzmbVar = zzhk;
                Object obj3 = zzmbVar;
                if (zzmbVar == null) {
                    synchronized (zzez.class) {
                        zzmb<zzez> zzmbVar2 = zzhk;
                        r32 = zzmbVar2;
                        if (zzmbVar2 == null) {
                            ?? zzbVar = new zzkk.zzb(zzhj);
                            zzhk = zzbVar;
                            r32 = zzbVar;
                        }
                        break;
                    }
                    obj3 = r32;
                }
                return obj3;
            case 6:
                return Byte.valueOf(this.zzhi);
            case 7:
                this.zzhi = (byte) (obj == null ? 0 : 1);
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
