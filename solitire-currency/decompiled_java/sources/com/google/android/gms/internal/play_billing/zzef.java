package com.google.android.gms.internal.play_billing;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzef<T> implements zzeo<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzfp.zzg();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzec zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzdq zzl;
    private final zzff zzm;
    private final zzce zzn;
    private final zzei zzo;
    private final zzdx zzp;

    private zzef(int[] iArr, Object[] objArr, int i10, int i11, zzec zzecVar, int i12, boolean z10, int[] iArr2, int i13, int i14, zzei zzeiVar, zzdq zzdqVar, zzff zzffVar, zzce zzceVar, zzdx zzdxVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i10;
        this.zzf = i11;
        boolean z11 = false;
        if (zzceVar != null && zzceVar.zzf(zzecVar)) {
            z11 = true;
        }
        this.zzh = z11;
        this.zzi = iArr2;
        this.zzj = i13;
        this.zzk = i14;
        this.zzo = zzeiVar;
        this.zzl = zzdqVar;
        this.zzm = zzffVar;
        this.zzn = zzceVar;
        this.zzg = zzecVar;
        this.zzp = zzdxVar;
    }

    private static void zzA(Object obj) {
        if (!zzL(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzB(Object obj, Object obj2, int i10) {
        if (zzI(obj2, i10)) {
            int iZzs = zzs(i10) & 1048575;
            Unsafe unsafe = zzb;
            long j10 = iZzs;
            Object object = unsafe.getObject(obj2, j10);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i10] + " is present but null: " + obj2.toString());
            }
            zzeo zzeoVarZzv = zzv(i10);
            if (!zzI(obj, i10)) {
                if (zzL(object)) {
                    Object objZze = zzeoVarZzv.zze();
                    zzeoVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j10, objZze);
                } else {
                    unsafe.putObject(obj, j10, object);
                }
                zzD(obj, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!zzL(object2)) {
                Object objZze2 = zzeoVarZzv.zze();
                zzeoVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j10, objZze2);
                object2 = objZze2;
            }
            zzeoVarZzv.zzg(object2, object);
        }
    }

    private final void zzC(Object obj, Object obj2, int i10) {
        int i11 = this.zzc[i10];
        if (zzM(obj2, i11, i10)) {
            int iZzs = zzs(i10) & 1048575;
            Unsafe unsafe = zzb;
            long j10 = iZzs;
            Object object = unsafe.getObject(obj2, j10);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i10] + " is present but null: " + obj2.toString());
            }
            zzeo zzeoVarZzv = zzv(i10);
            if (!zzM(obj, i11, i10)) {
                if (zzL(object)) {
                    Object objZze = zzeoVarZzv.zze();
                    zzeoVarZzv.zzg(objZze, object);
                    unsafe.putObject(obj, j10, objZze);
                } else {
                    unsafe.putObject(obj, j10, object);
                }
                zzE(obj, i11, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!zzL(object2)) {
                Object objZze2 = zzeoVarZzv.zze();
                zzeoVarZzv.zzg(objZze2, object2);
                unsafe.putObject(obj, j10, objZze2);
                object2 = objZze2;
            }
            zzeoVarZzv.zzg(object2, object);
        }
    }

    private final void zzD(Object obj, int i10) {
        int iZzp = zzp(i10);
        long j10 = 1048575 & iZzp;
        if (j10 == 1048575) {
            return;
        }
        zzfp.zzq(obj, j10, (1 << (iZzp >>> 20)) | zzfp.zzc(obj, j10));
    }

    private final void zzE(Object obj, int i10, int i11) {
        zzfp.zzq(obj, zzp(i11) & 1048575, i10);
    }

    private final void zzF(Object obj, int i10, Object obj2) {
        zzb.putObject(obj, zzs(i10) & 1048575, obj2);
        zzD(obj, i10);
    }

    private final void zzG(Object obj, int i10, int i11, Object obj2) {
        zzb.putObject(obj, zzs(i11) & 1048575, obj2);
        zzE(obj, i10, i11);
    }

    private final boolean zzH(Object obj, Object obj2, int i10) {
        return zzI(obj, i10) == zzI(obj2, i10);
    }

    private final boolean zzI(Object obj, int i10) {
        int iZzp = zzp(i10);
        long j10 = iZzp & 1048575;
        if (j10 != 1048575) {
            return (zzfp.zzc(obj, j10) & (1 << (iZzp >>> 20))) != 0;
        }
        int iZzs = zzs(i10);
        long j11 = iZzs & 1048575;
        switch (zzr(iZzs)) {
            case 0:
                return Double.doubleToRawLongBits(zzfp.zza(obj, j11)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzfp.zzb(obj, j11)) != 0;
            case 2:
                return zzfp.zzd(obj, j11) != 0;
            case 3:
                return zzfp.zzd(obj, j11) != 0;
            case 4:
                return zzfp.zzc(obj, j11) != 0;
            case 5:
                return zzfp.zzd(obj, j11) != 0;
            case 6:
                return zzfp.zzc(obj, j11) != 0;
            case 7:
                return zzfp.zzw(obj, j11);
            case 8:
                Object objZzf = zzfp.zzf(obj, j11);
                if (objZzf instanceof String) {
                    return !((String) objZzf).isEmpty();
                }
                if (objZzf instanceof zzbq) {
                    return !zzbq.zzb.equals(objZzf);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzfp.zzf(obj, j11) != null;
            case 10:
                return !zzbq.zzb.equals(zzfp.zzf(obj, j11));
            case 11:
                return zzfp.zzc(obj, j11) != 0;
            case 12:
                return zzfp.zzc(obj, j11) != 0;
            case 13:
                return zzfp.zzc(obj, j11) != 0;
            case 14:
                return zzfp.zzd(obj, j11) != 0;
            case 15:
                return zzfp.zzc(obj, j11) != 0;
            case 16:
                return zzfp.zzd(obj, j11) != 0;
            case 17:
                return zzfp.zzf(obj, j11) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzJ(Object obj, int i10, int i11, int i12, int i13) {
        return i11 == 1048575 ? zzI(obj, i10) : (i12 & i13) != 0;
    }

    private static boolean zzK(Object obj, int i10, zzeo zzeoVar) {
        return zzeoVar.zzk(zzfp.zzf(obj, i10 & 1048575));
    }

    private static boolean zzL(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzcs) {
            return ((zzcs) obj).zzw();
        }
        return true;
    }

    private final boolean zzM(Object obj, int i10, int i11) {
        return zzfp.zzc(obj, (long) (zzp(i11) & 1048575)) == i10;
    }

    private static boolean zzN(Object obj, long j10) {
        return ((Boolean) zzfp.zzf(obj, j10)).booleanValue();
    }

    private static final void zzO(int i10, Object obj, zzfx zzfxVar) throws IOException {
        if (obj instanceof String) {
            zzfxVar.zzG(i10, (String) obj);
        } else {
            zzfxVar.zzd(i10, (zzbq) obj);
        }
    }

    static zzfg zzd(Object obj) {
        zzcs zzcsVar = (zzcs) obj;
        zzfg zzfgVar = zzcsVar.zzc;
        if (zzfgVar != zzfg.zzc()) {
            return zzfgVar;
        }
        zzfg zzfgVarZzf = zzfg.zzf();
        zzcsVar.zzc = zzfgVarZzf;
        return zzfgVarZzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0282  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static com.google.android.gms.internal.play_billing.zzef zzl(java.lang.Class r33, com.google.android.gms.internal.play_billing.zzdz r34, com.google.android.gms.internal.play_billing.zzei r35, com.google.android.gms.internal.play_billing.zzdq r36, com.google.android.gms.internal.play_billing.zzff r37, com.google.android.gms.internal.play_billing.zzce r38, com.google.android.gms.internal.play_billing.zzdx r39) {
        /*
            Method dump skipped, instruction units count: 1030
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zzl(java.lang.Class, com.google.android.gms.internal.play_billing.zzdz, com.google.android.gms.internal.play_billing.zzei, com.google.android.gms.internal.play_billing.zzdq, com.google.android.gms.internal.play_billing.zzff, com.google.android.gms.internal.play_billing.zzce, com.google.android.gms.internal.play_billing.zzdx):com.google.android.gms.internal.play_billing.zzef");
    }

    private static double zzm(Object obj, long j10) {
        return ((Double) zzfp.zzf(obj, j10)).doubleValue();
    }

    private static float zzn(Object obj, long j10) {
        return ((Float) zzfp.zzf(obj, j10)).floatValue();
    }

    private static int zzo(Object obj, long j10) {
        return ((Integer) zzfp.zzf(obj, j10)).intValue();
    }

    private final int zzp(int i10) {
        return this.zzc[i10 + 2];
    }

    private final int zzq(int i10, int i11) {
        int length = (this.zzc.length / 3) - 1;
        while (i11 <= length) {
            int i12 = (length + i11) >>> 1;
            int i13 = i12 * 3;
            int i14 = this.zzc[i13];
            if (i10 == i14) {
                return i13;
            }
            if (i10 < i14) {
                length = i12 - 1;
            } else {
                i11 = i12 + 1;
            }
        }
        return -1;
    }

    private static int zzr(int i10) {
        return (i10 >>> 20) & 255;
    }

    private final int zzs(int i10) {
        return this.zzc[i10 + 1];
    }

    private static long zzt(Object obj, long j10) {
        return ((Long) zzfp.zzf(obj, j10)).longValue();
    }

    private final zzcw zzu(int i10) {
        int i11 = i10 / 3;
        return (zzcw) this.zzd[i11 + i11 + 1];
    }

    private final zzeo zzv(int i10) {
        Object[] objArr = this.zzd;
        int i11 = i10 / 3;
        int i12 = i11 + i11;
        zzeo zzeoVar = (zzeo) objArr[i12];
        if (zzeoVar != null) {
            return zzeoVar;
        }
        zzeo zzeoVarZzb = zzel.zza().zzb((Class) objArr[i12 + 1]);
        this.zzd[i12] = zzeoVarZzb;
        return zzeoVarZzb;
    }

    private final Object zzw(int i10) {
        int i11 = i10 / 3;
        return this.zzd[i11 + i11];
    }

    private final Object zzx(Object obj, int i10) {
        zzeo zzeoVarZzv = zzv(i10);
        int iZzs = zzs(i10) & 1048575;
        if (!zzI(obj, i10)) {
            return zzeoVarZzv.zze();
        }
        Object object = zzb.getObject(obj, iZzs);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzeoVarZzv.zze();
        if (object != null) {
            zzeoVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzy(Object obj, int i10, int i11) {
        zzeo zzeoVarZzv = zzv(i11);
        if (!zzM(obj, i10, i11)) {
            return zzeoVarZzv.zze();
        }
        Object object = zzb.getObject(obj, zzs(i11) & 1048575);
        if (zzL(object)) {
            return object;
        }
        Object objZze = zzeoVarZzv.zze();
        if (object != null) {
            zzeoVarZzv.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzz(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:207:0x054e  */
    /* JADX WARN: Type inference failed for: r0v112, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v113, types: [com.google.android.gms.internal.play_billing.zzdk] */
    /* JADX WARN: Type inference failed for: r0v115, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v117, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v134 */
    /* JADX WARN: Type inference failed for: r0v182, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v253, types: [int] */
    /* JADX WARN: Type inference failed for: r0v261 */
    /* JADX WARN: Type inference failed for: r0v263 */
    /* JADX WARN: Type inference failed for: r0v264 */
    /* JADX WARN: Type inference failed for: r0v265 */
    /* JADX WARN: Type inference failed for: r0v266 */
    /* JADX WARN: Type inference failed for: r0v267 */
    /* JADX WARN: Type inference failed for: r0v268 */
    /* JADX WARN: Type inference failed for: r0v269 */
    /* JADX WARN: Type inference failed for: r0v270 */
    /* JADX WARN: Type inference failed for: r0v271 */
    /* JADX WARN: Type inference failed for: r0v272 */
    /* JADX WARN: Type inference failed for: r0v273 */
    /* JADX WARN: Type inference failed for: r0v274 */
    /* JADX WARN: Type inference failed for: r0v275 */
    /* JADX WARN: Type inference failed for: r0v276 */
    /* JADX WARN: Type inference failed for: r0v277 */
    /* JADX WARN: Type inference failed for: r0v278 */
    /* JADX WARN: Type inference failed for: r0v279 */
    /* JADX WARN: Type inference failed for: r0v280 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v123, types: [int] */
    /* JADX WARN: Type inference failed for: r1v126, types: [int] */
    /* JADX WARN: Type inference failed for: r1v165 */
    /* JADX WARN: Type inference failed for: r1v168 */
    /* JADX WARN: Type inference failed for: r1v169 */
    /* JADX WARN: Type inference failed for: r1v171 */
    /* JADX WARN: Type inference failed for: r1v172 */
    /* JADX WARN: Type inference failed for: r1v173 */
    /* JADX WARN: Type inference failed for: r1v83, types: [int] */
    /* JADX WARN: Type inference failed for: r1v85 */
    /* JADX WARN: Type inference failed for: r2v30, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v36, types: [int] */
    /* JADX WARN: Type inference failed for: r2v40, types: [int] */
    /* JADX WARN: Type inference failed for: r2v44, types: [int] */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53, types: [int] */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v88 */
    /* JADX WARN: Type inference failed for: r2v89 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v23, types: [int] */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26, types: [int] */
    /* JADX WARN: Type inference failed for: r3v31 */
    /* JADX WARN: Type inference failed for: r3v35, types: [int] */
    /* JADX WARN: Type inference failed for: r3v36 */
    /* JADX WARN: Type inference failed for: r3v42, types: [int] */
    /* JADX WARN: Type inference failed for: r3v47 */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50 */
    /* JADX WARN: Type inference failed for: r3v51 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31, types: [int] */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v36 */
    /* JADX WARN: Type inference failed for: r4v38, types: [int] */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v61 */
    /* JADX WARN: Type inference failed for: r4v62 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    @Override // com.google.android.gms.internal.play_billing.zzeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(java.lang.Object r20) {
        /*
            Method dump skipped, instruction units count: 2194
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zza(java.lang.Object):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final int zzb(Object obj) {
        int i10;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i11;
        int i12 = 0;
        for (int i13 = 0; i13 < this.zzc.length; i13 += 3) {
            int iZzs = zzs(i13);
            int[] iArr = this.zzc;
            int i14 = 1048575 & iZzs;
            int iZzr = zzr(iZzs);
            int i15 = iArr[i13];
            long j10 = i14;
            int iHashCode = 37;
            switch (iZzr) {
                case 0:
                    i10 = i12 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzfp.zza(obj, j10));
                    byte[] bArr = zzda.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 1:
                    i10 = i12 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzfp.zzb(obj, j10));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 2:
                    i10 = i12 * 53;
                    jDoubleToLongBits = zzfp.zzd(obj, j10);
                    byte[] bArr2 = zzda.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 3:
                    i10 = i12 * 53;
                    jDoubleToLongBits = zzfp.zzd(obj, j10);
                    byte[] bArr3 = zzda.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 4:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzfp.zzc(obj, j10);
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 5:
                    i10 = i12 * 53;
                    jDoubleToLongBits = zzfp.zzd(obj, j10);
                    byte[] bArr4 = zzda.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 6:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzfp.zzc(obj, j10);
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 7:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzda.zza(zzfp.zzw(obj, j10));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 8:
                    i10 = i12 * 53;
                    iFloatToIntBits = ((String) zzfp.zzf(obj, j10)).hashCode();
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 9:
                    i11 = i12 * 53;
                    Object objZzf = zzfp.zzf(obj, j10);
                    if (objZzf != null) {
                        iHashCode = objZzf.hashCode();
                    }
                    i12 = i11 + iHashCode;
                    break;
                case 10:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzfp.zzf(obj, j10).hashCode();
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 11:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzfp.zzc(obj, j10);
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 12:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzfp.zzc(obj, j10);
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 13:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzfp.zzc(obj, j10);
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 14:
                    i10 = i12 * 53;
                    jDoubleToLongBits = zzfp.zzd(obj, j10);
                    byte[] bArr5 = zzda.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 15:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzfp.zzc(obj, j10);
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 16:
                    i10 = i12 * 53;
                    jDoubleToLongBits = zzfp.zzd(obj, j10);
                    byte[] bArr6 = zzda.zzd;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 17:
                    i11 = i12 * 53;
                    Object objZzf2 = zzfp.zzf(obj, j10);
                    if (objZzf2 != null) {
                        iHashCode = objZzf2.hashCode();
                    }
                    i12 = i11 + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzfp.zzf(obj, j10).hashCode();
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 50:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzfp.zzf(obj, j10).hashCode();
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 51:
                    if (zzM(obj, i15, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzm(obj, j10));
                        byte[] bArr7 = zzda.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzM(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzn(obj, j10));
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzM(obj, i15, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = zzt(obj, j10);
                        byte[] bArr8 = zzda.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzM(obj, i15, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = zzt(obj, j10);
                        byte[] bArr9 = zzda.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzM(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzo(obj, j10);
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzM(obj, i15, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = zzt(obj, j10);
                        byte[] bArr10 = zzda.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzM(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzo(obj, j10);
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzM(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzda.zza(zzN(obj, j10));
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzM(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = ((String) zzfp.zzf(obj, j10)).hashCode();
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzM(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzfp.zzf(obj, j10).hashCode();
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzM(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzfp.zzf(obj, j10).hashCode();
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzM(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzo(obj, j10);
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzM(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzo(obj, j10);
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzM(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzo(obj, j10);
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzM(obj, i15, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = zzt(obj, j10);
                        byte[] bArr11 = zzda.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzM(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzo(obj, j10);
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzM(obj, i15, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = zzt(obj, j10);
                        byte[] bArr12 = zzda.zzd;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzM(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzfp.zzf(obj, j10).hashCode();
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i12 * 53) + this.zzm.zzd(obj).hashCode();
        return this.zzh ? (iHashCode2 * 53) + this.zzn.zzb(obj).zza.hashCode() : iHashCode2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:562:0x0cee, code lost:
    
        if (r6 == 1048575) goto L564;
     */
    /* JADX WARN: Code restructure failed: missing block: B:563:0x0cf0, code lost:
    
        r13.putInt(r7, r6, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:564:0x0cf4, code lost:
    
        r3 = r0.zzj;
     */
    /* JADX WARN: Code restructure failed: missing block: B:566:0x0cf8, code lost:
    
        if (r3 >= r0.zzk) goto L681;
     */
    /* JADX WARN: Code restructure failed: missing block: B:567:0x0cfa, code lost:
    
        r5 = r0.zzi;
        r6 = r0.zzc;
        r5 = r5[r3];
        r6 = r6[r5];
        r6 = com.google.android.gms.internal.play_billing.zzfp.zzf(r7, r0.zzs(r5) & 1048575);
     */
    /* JADX WARN: Code restructure failed: missing block: B:568:0x0d0c, code lost:
    
        if (r6 != null) goto L570;
     */
    /* JADX WARN: Code restructure failed: missing block: B:571:0x0d13, code lost:
    
        if (r0.zzu(r5) != null) goto L682;
     */
    /* JADX WARN: Code restructure failed: missing block: B:572:0x0d15, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:573:0x0d18, code lost:
    
        r6 = (com.google.android.gms.internal.play_billing.zzdw) r6;
        r1 = (com.google.android.gms.internal.play_billing.zzdv) r0.zzw(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:574:0x0d20, code lost:
    
        throw null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:575:0x0d21, code lost:
    
        if (r8 != 0) goto L581;
     */
    /* JADX WARN: Code restructure failed: missing block: B:577:0x0d25, code lost:
    
        if (r1 != r37) goto L579;
     */
    /* JADX WARN: Code restructure failed: missing block: B:580:0x0d2c, code lost:
    
        throw com.google.android.gms.internal.play_billing.zzdc.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:582:0x0d2f, code lost:
    
        if (r1 > r37) goto L585;
     */
    /* JADX WARN: Code restructure failed: missing block: B:583:0x0d31, code lost:
    
        if (r4 != r8) goto L585;
     */
    /* JADX WARN: Code restructure failed: missing block: B:584:0x0d33, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:586:0x0d38, code lost:
    
        throw com.google.android.gms.internal.play_billing.zzdc.zze();
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:450:0x09b6 A[PHI: r0 r7 r8 r9 r10 r11 r13
      0x09b6: PHI (r0v32 com.google.android.gms.internal.play_billing.zzef<T>) = 
      (r0v1 com.google.android.gms.internal.play_billing.zzef<T>)
      (r0v1 com.google.android.gms.internal.play_billing.zzef<T>)
      (r0v1 com.google.android.gms.internal.play_billing.zzef<T>)
      (r0v1 com.google.android.gms.internal.play_billing.zzef<T>)
      (r0v8 com.google.android.gms.internal.play_billing.zzef<T>)
      (r0v31 com.google.android.gms.internal.play_billing.zzef<T>)
      (r0v1 com.google.android.gms.internal.play_billing.zzef<T>)
     binds: [B:440:0x096f, B:424:0x0917, B:408:0x08c6, B:333:0x076e, B:284:0x06a8, B:251:0x0607, B:184:0x0487] A[DONT_GENERATE, DONT_INLINE]
      0x09b6: PHI (r7v28 int) = (r7v7 int), (r7v8 int), (r7v9 int), (r7v14 int), (r7v18 int), (r7v23 int), (r7v32 int) binds: [B:440:0x096f, B:424:0x0917, B:408:0x08c6, B:333:0x076e, B:284:0x06a8, B:251:0x0607, B:184:0x0487] A[DONT_GENERATE, DONT_INLINE]
      0x09b6: PHI (r8v73 int) = (r8v52 int), (r8v53 int), (r8v54 int), (r8v56 int), (r8v63 int), (r8v71 int), (r8v76 int) binds: [B:440:0x096f, B:424:0x0917, B:408:0x08c6, B:333:0x076e, B:284:0x06a8, B:251:0x0607, B:184:0x0487] A[DONT_GENERATE, DONT_INLINE]
      0x09b6: PHI (r9v59 int) = (r9v32 int), (r9v33 int), (r9v34 int), (r9v39 int), (r9v46 int), (r9v54 int), (r9v61 int) binds: [B:440:0x096f, B:424:0x0917, B:408:0x08c6, B:333:0x076e, B:284:0x06a8, B:251:0x0607, B:184:0x0487] A[DONT_GENERATE, DONT_INLINE]
      0x09b6: PHI (r10v76 int) = (r10v37 int), (r10v38 int), (r10v39 int), (r10v53 int), (r10v67 int), (r10v74 int), (r10v79 int) binds: [B:440:0x096f, B:424:0x0917, B:408:0x08c6, B:333:0x076e, B:284:0x06a8, B:251:0x0607, B:184:0x0487] A[DONT_GENERATE, DONT_INLINE]
      0x09b6: PHI (r11v34 sun.misc.Unsafe) = 
      (r11v10 sun.misc.Unsafe)
      (r11v11 sun.misc.Unsafe)
      (r11v12 sun.misc.Unsafe)
      (r11v14 sun.misc.Unsafe)
      (r11v22 sun.misc.Unsafe)
      (r11v29 sun.misc.Unsafe)
      (r11v36 sun.misc.Unsafe)
     binds: [B:440:0x096f, B:424:0x0917, B:408:0x08c6, B:333:0x076e, B:284:0x06a8, B:251:0x0607, B:184:0x0487] A[DONT_GENERATE, DONT_INLINE]
      0x09b6: PHI (r13v52 com.google.android.gms.internal.play_billing.zzbc) = 
      (r13v36 com.google.android.gms.internal.play_billing.zzbc)
      (r13v37 com.google.android.gms.internal.play_billing.zzbc)
      (r13v38 com.google.android.gms.internal.play_billing.zzbc)
      (r13v43 com.google.android.gms.internal.play_billing.zzbc)
      (r13v48 com.google.android.gms.internal.play_billing.zzbc)
      (r13v50 com.google.android.gms.internal.play_billing.zzbc)
      (r13v54 com.google.android.gms.internal.play_billing.zzbc)
     binds: [B:440:0x096f, B:424:0x0917, B:408:0x08c6, B:333:0x076e, B:284:0x06a8, B:251:0x0607, B:184:0x0487] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:542:0x0c68 A[PHI: r1 r4 r5 r6 r9 r20
      0x0c68: PHI (r1v191 int) = 
      (r1v167 int)
      (r1v168 int)
      (r1v169 int)
      (r1v170 int)
      (r1v171 int)
      (r1v172 int)
      (r1v175 int)
      (r1v184 int)
      (r1v192 int)
     binds: [B:540:0x0c51, B:537:0x0c30, B:533:0x0c0f, B:530:0x0bf2, B:527:0x0bd5, B:524:0x0bb7, B:522:0x0baa, B:500:0x0b3c, B:467:0x0a27] A[DONT_GENERATE, DONT_INLINE]
      0x0c68: PHI (r4v88 int) = (r4v59 int), (r4v60 int), (r4v61 int), (r4v62 int), (r4v63 int), (r4v64 int), (r4v67 int), (r4v80 int), (r4v89 int) binds: [B:540:0x0c51, B:537:0x0c30, B:533:0x0c0f, B:530:0x0bf2, B:527:0x0bd5, B:524:0x0bb7, B:522:0x0baa, B:500:0x0b3c, B:467:0x0a27] A[DONT_GENERATE, DONT_INLINE]
      0x0c68: PHI (r5v122 com.google.android.gms.internal.play_billing.zzbc) = 
      (r5v106 com.google.android.gms.internal.play_billing.zzbc)
      (r5v107 com.google.android.gms.internal.play_billing.zzbc)
      (r5v108 com.google.android.gms.internal.play_billing.zzbc)
      (r5v109 com.google.android.gms.internal.play_billing.zzbc)
      (r5v110 com.google.android.gms.internal.play_billing.zzbc)
      (r5v111 com.google.android.gms.internal.play_billing.zzbc)
      (r5v114 com.google.android.gms.internal.play_billing.zzbc)
      (r5v118 com.google.android.gms.internal.play_billing.zzbc)
      (r5v123 com.google.android.gms.internal.play_billing.zzbc)
     binds: [B:540:0x0c51, B:537:0x0c30, B:533:0x0c0f, B:530:0x0bf2, B:527:0x0bd5, B:524:0x0bb7, B:522:0x0baa, B:500:0x0b3c, B:467:0x0a27] A[DONT_GENERATE, DONT_INLINE]
      0x0c68: PHI (r6v98 byte[]) = 
      (r6v78 byte[])
      (r6v79 byte[])
      (r6v80 byte[])
      (r6v81 byte[])
      (r6v82 byte[])
      (r6v83 byte[])
      (r6v86 byte[])
      (r6v91 byte[])
      (r6v99 byte[])
     binds: [B:540:0x0c51, B:537:0x0c30, B:533:0x0c0f, B:530:0x0bf2, B:527:0x0bd5, B:524:0x0bb7, B:522:0x0baa, B:500:0x0b3c, B:467:0x0a27] A[DONT_GENERATE, DONT_INLINE]
      0x0c68: PHI (r9v90 int) = (r9v64 int), (r9v65 int), (r9v66 int), (r9v67 int), (r9v68 int), (r9v69 int), (r9v72 int), (r9v82 int), (r9v91 int) binds: [B:540:0x0c51, B:537:0x0c30, B:533:0x0c0f, B:530:0x0bf2, B:527:0x0bd5, B:524:0x0bb7, B:522:0x0baa, B:500:0x0b3c, B:467:0x0a27] A[DONT_GENERATE, DONT_INLINE]
      0x0c68: PHI (r20v36 int) = 
      (r20v16 int)
      (r20v17 int)
      (r20v18 int)
      (r20v19 int)
      (r20v20 int)
      (r20v21 int)
      (r20v24 int)
      (r20v30 int)
      (r20v37 int)
     binds: [B:540:0x0c51, B:537:0x0c30, B:533:0x0c0f, B:530:0x0bf2, B:527:0x0bd5, B:524:0x0bb7, B:522:0x0baa, B:500:0x0b3c, B:467:0x0a27] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:547:0x0c89 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:551:0x0c98  */
    /* JADX WARN: Removed duplicated region for block: B:558:0x0cbf  */
    /* JADX WARN: Removed duplicated region for block: B:624:0x09b9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:627:0x0c6b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:630:0x0059 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:668:0x09c7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:670:0x0c82 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0206  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int zzc(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.gms.internal.play_billing.zzbc r39) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3530
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.play_billing.zzbc):int");
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final Object zze() {
        return ((zzcs) this.zzg).zzl();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006d  */
    @Override // com.google.android.gms.internal.play_billing.zzeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzf(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zzf(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final void zzg(Object obj, Object obj2) {
        zzA(obj);
        obj2.getClass();
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int iZzs = zzs(i10);
            int i11 = 1048575 & iZzs;
            int[] iArr = this.zzc;
            int iZzr = zzr(iZzs);
            int i12 = iArr[i10];
            long j10 = i11;
            switch (iZzr) {
                case 0:
                    if (zzI(obj2, i10)) {
                        zzfp.zzo(obj, j10, zzfp.zza(obj2, j10));
                        zzD(obj, i10);
                    }
                    break;
                case 1:
                    if (zzI(obj2, i10)) {
                        zzfp.zzp(obj, j10, zzfp.zzb(obj2, j10));
                        zzD(obj, i10);
                    }
                    break;
                case 2:
                    if (zzI(obj2, i10)) {
                        zzfp.zzr(obj, j10, zzfp.zzd(obj2, j10));
                        zzD(obj, i10);
                    }
                    break;
                case 3:
                    if (zzI(obj2, i10)) {
                        zzfp.zzr(obj, j10, zzfp.zzd(obj2, j10));
                        zzD(obj, i10);
                    }
                    break;
                case 4:
                    if (zzI(obj2, i10)) {
                        zzfp.zzq(obj, j10, zzfp.zzc(obj2, j10));
                        zzD(obj, i10);
                    }
                    break;
                case 5:
                    if (zzI(obj2, i10)) {
                        zzfp.zzr(obj, j10, zzfp.zzd(obj2, j10));
                        zzD(obj, i10);
                    }
                    break;
                case 6:
                    if (zzI(obj2, i10)) {
                        zzfp.zzq(obj, j10, zzfp.zzc(obj2, j10));
                        zzD(obj, i10);
                    }
                    break;
                case 7:
                    if (zzI(obj2, i10)) {
                        zzfp.zzm(obj, j10, zzfp.zzw(obj2, j10));
                        zzD(obj, i10);
                    }
                    break;
                case 8:
                    if (zzI(obj2, i10)) {
                        zzfp.zzs(obj, j10, zzfp.zzf(obj2, j10));
                        zzD(obj, i10);
                    }
                    break;
                case 9:
                    zzB(obj, obj2, i10);
                    break;
                case 10:
                    if (zzI(obj2, i10)) {
                        zzfp.zzs(obj, j10, zzfp.zzf(obj2, j10));
                        zzD(obj, i10);
                    }
                    break;
                case 11:
                    if (zzI(obj2, i10)) {
                        zzfp.zzq(obj, j10, zzfp.zzc(obj2, j10));
                        zzD(obj, i10);
                    }
                    break;
                case 12:
                    if (zzI(obj2, i10)) {
                        zzfp.zzq(obj, j10, zzfp.zzc(obj2, j10));
                        zzD(obj, i10);
                    }
                    break;
                case 13:
                    if (zzI(obj2, i10)) {
                        zzfp.zzq(obj, j10, zzfp.zzc(obj2, j10));
                        zzD(obj, i10);
                    }
                    break;
                case 14:
                    if (zzI(obj2, i10)) {
                        zzfp.zzr(obj, j10, zzfp.zzd(obj2, j10));
                        zzD(obj, i10);
                    }
                    break;
                case 15:
                    if (zzI(obj2, i10)) {
                        zzfp.zzq(obj, j10, zzfp.zzc(obj2, j10));
                        zzD(obj, i10);
                    }
                    break;
                case 16:
                    if (zzI(obj2, i10)) {
                        zzfp.zzr(obj, j10, zzfp.zzd(obj2, j10));
                        zzD(obj, i10);
                    }
                    break;
                case 17:
                    zzB(obj, obj2, i10);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzl.zzb(obj, obj2, j10);
                    break;
                case 50:
                    int i13 = zzeq.zza;
                    zzfp.zzs(obj, j10, zzdx.zza(zzfp.zzf(obj, j10), zzfp.zzf(obj2, j10)));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (zzM(obj2, i12, i10)) {
                        zzfp.zzs(obj, j10, zzfp.zzf(obj2, j10));
                        zzE(obj, i12, i10);
                    }
                    break;
                case 60:
                    zzC(obj, obj2, i10);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzM(obj2, i12, i10)) {
                        zzfp.zzs(obj, j10, zzfp.zzf(obj2, j10));
                        zzE(obj, i12, i10);
                    }
                    break;
                case 68:
                    zzC(obj, obj2, i10);
                    break;
            }
        }
        zzeq.zzq(this.zzm, obj, obj2);
        if (this.zzh) {
            zzeq.zzp(this.zzn, obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final void zzh(Object obj, byte[] bArr, int i10, int i11, zzbc zzbcVar) throws IOException {
        zzc(obj, bArr, i10, i11, 0, zzbcVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    @Override // com.google.android.gms.internal.play_billing.zzeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzi(java.lang.Object r24, com.google.android.gms.internal.play_billing.zzfx r25) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1912
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zzi(java.lang.Object, com.google.android.gms.internal.play_billing.zzfx):void");
    }

    @Override // com.google.android.gms.internal.play_billing.zzeo
    public final boolean zzj(Object obj, Object obj2) {
        boolean zZzG;
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int iZzs = zzs(i10);
            long j10 = iZzs & 1048575;
            switch (zzr(iZzs)) {
                case 0:
                    if (!zzH(obj, obj2, i10) || Double.doubleToLongBits(zzfp.zza(obj, j10)) != Double.doubleToLongBits(zzfp.zza(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzH(obj, obj2, i10) || Float.floatToIntBits(zzfp.zzb(obj, j10)) != Float.floatToIntBits(zzfp.zzb(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzH(obj, obj2, i10) || zzfp.zzd(obj, j10) != zzfp.zzd(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzH(obj, obj2, i10) || zzfp.zzd(obj, j10) != zzfp.zzd(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzH(obj, obj2, i10) || zzfp.zzc(obj, j10) != zzfp.zzc(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzH(obj, obj2, i10) || zzfp.zzd(obj, j10) != zzfp.zzd(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzH(obj, obj2, i10) || zzfp.zzc(obj, j10) != zzfp.zzc(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzH(obj, obj2, i10) || zzfp.zzw(obj, j10) != zzfp.zzw(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzH(obj, obj2, i10) || !zzeq.zzG(zzfp.zzf(obj, j10), zzfp.zzf(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzH(obj, obj2, i10) || !zzeq.zzG(zzfp.zzf(obj, j10), zzfp.zzf(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzH(obj, obj2, i10) || !zzeq.zzG(zzfp.zzf(obj, j10), zzfp.zzf(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzH(obj, obj2, i10) || zzfp.zzc(obj, j10) != zzfp.zzc(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzH(obj, obj2, i10) || zzfp.zzc(obj, j10) != zzfp.zzc(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzH(obj, obj2, i10) || zzfp.zzc(obj, j10) != zzfp.zzc(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzH(obj, obj2, i10) || zzfp.zzd(obj, j10) != zzfp.zzd(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzH(obj, obj2, i10) || zzfp.zzc(obj, j10) != zzfp.zzc(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzH(obj, obj2, i10) || zzfp.zzd(obj, j10) != zzfp.zzd(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzH(obj, obj2, i10) || !zzeq.zzG(zzfp.zzf(obj, j10), zzfp.zzf(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    zZzG = zzeq.zzG(zzfp.zzf(obj, j10), zzfp.zzf(obj2, j10));
                    break;
                case 50:
                    zZzG = zzeq.zzG(zzfp.zzf(obj, j10), zzfp.zzf(obj2, j10));
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                    long jZzp = zzp(i10) & 1048575;
                    if (zzfp.zzc(obj, jZzp) != zzfp.zzc(obj2, jZzp) || !zzeq.zzG(zzfp.zzf(obj, j10), zzfp.zzf(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    break;
            }
            if (!zZzG) {
                return false;
            }
        }
        if (!this.zzm.zzd(obj).equals(this.zzm.zzd(obj2))) {
            return false;
        }
        if (this.zzh) {
            return this.zzn.zzb(obj).equals(this.zzn.zzb(obj2));
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009b  */
    @Override // com.google.android.gms.internal.play_billing.zzeo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzk(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.zzef.zzk(java.lang.Object):boolean");
    }
}
