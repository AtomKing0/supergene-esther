package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;

/* JADX INFO: loaded from: classes3.dex */
public final class zzfd extends zzkk<zzfd, zza> implements zzls {
    private static volatile zzmb<zzfd> zzhk;
    private static final zzfd zzhq;
    private int zzhd;
    private byte zzhi = 2;
    private long zzhn = -1;
    private long zzhg = -1;

    public static final class zza extends zzkk.zza<zzfd, zza> implements zzls {
        private zza() {
            super(zzfd.zzhq);
        }

        public final zza zzi(long j10) {
            zzdb();
            ((zzfd) this.zzru).zzf(j10);
            return this;
        }

        public final zza zzj(long j10) {
            zzdb();
            ((zzfd) this.zzru).zza(j10);
            return this;
        }

        /* synthetic */ zza(zzfe zzfeVar) {
            this();
        }
    }

    static {
        zzfd zzfdVar = new zzfd();
        zzhq = zzfdVar;
        zzkk.zza((Class<zzfd>) zzfd.class, zzfdVar);
    }

    private zzfd() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(long j10) {
        this.zzhd |= 2;
        this.zzhg = j10;
    }

    public static zza zzap() {
        return zzhq.zzcw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzf(long j10) {
        this.zzhd |= 1;
        this.zzhn = j10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [com.google.android.gms.internal.drive.zzkk$zzb, com.google.android.gms.internal.drive.zzmb<com.google.android.gms.internal.drive.zzfd>] */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20 */
    @Override // com.google.android.gms.internal.drive.zzkk
    protected final Object zza(int i10, Object obj, Object obj2) {
        ?? r32;
        zzfe zzfeVar = null;
        switch (zzfe.zzhl[i10 - 1]) {
            case 1:
                return new zzfd();
            case 2:
                return new zza(zzfeVar);
            case 3:
                return zzkk.zza(zzhq, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԑ\u0000\u0002Ԑ\u0001", new Object[]{"zzhd", "zzhn", "zzhg"});
            case 4:
                return zzhq;
            case 5:
                zzmb<zzfd> zzmbVar = zzhk;
                Object obj3 = zzmbVar;
                if (zzmbVar == null) {
                    synchronized (zzfd.class) {
                        zzmb<zzfd> zzmbVar2 = zzhk;
                        r32 = zzmbVar2;
                        if (zzmbVar2 == null) {
                            ?? zzbVar = new zzkk.zzb(zzhq);
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
