package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgzm<T> implements zzhae<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzhaz.zzi();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgzj zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final int[] zzj;
    private final int zzk;
    private final int zzl;
    private final zzhas zzm;
    private final zzgxj zzn;

    private zzgzm(int[] iArr, Object[] objArr, int i10, int i11, zzgzj zzgzjVar, int i12, boolean z10, int[] iArr2, int i13, int i14, zzgzp zzgzpVar, zzgyw zzgywVar, zzhas zzhasVar, zzgxj zzgxjVar, zzgze zzgzeVar) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i10;
        this.zzf = i11;
        this.zzi = zzgzjVar instanceof zzgxy;
        boolean z11 = false;
        if (zzgxjVar != null && (zzgzjVar instanceof zzgxu)) {
            z11 = true;
        }
        this.zzh = z11;
        this.zzj = iArr2;
        this.zzk = i13;
        this.zzl = i14;
        this.zzm = zzhasVar;
        this.zzn = zzgxjVar;
        this.zzg = zzgzjVar;
    }

    private final Object zzA(Object obj, int i10) {
        zzhae zzhaeVarZzx = zzx(i10);
        int iZzu = zzu(i10) & 1048575;
        if (!zzN(obj, i10)) {
            return zzhaeVarZzx.zze();
        }
        Object object = zzb.getObject(obj, iZzu);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzhaeVarZzx.zze();
        if (object != null) {
            zzhaeVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private final Object zzB(Object obj, int i10, int i11) {
        zzhae zzhaeVarZzx = zzx(i11);
        if (!zzR(obj, i10, i11)) {
            return zzhaeVarZzx.zze();
        }
        Object object = zzb.getObject(obj, zzu(i11) & 1048575);
        if (zzQ(object)) {
            return object;
        }
        Object objZze = zzhaeVarZzx.zze();
        if (object != null) {
            zzhaeVarZzx.zzg(objZze, object);
        }
        return objZze;
    }

    private static Field zzC(Class cls, String str) {
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

    private static void zzD(Object obj) {
        if (!zzQ(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    private final void zzE(Object obj, Object obj2, int i10) {
        if (zzN(obj2, i10)) {
            int iZzu = zzu(i10) & 1048575;
            Unsafe unsafe = zzb;
            long j10 = iZzu;
            Object object = unsafe.getObject(obj2, j10);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i10] + " is present but null: " + obj2.toString());
            }
            zzhae zzhaeVarZzx = zzx(i10);
            if (!zzN(obj, i10)) {
                if (zzQ(object)) {
                    Object objZze = zzhaeVarZzx.zze();
                    zzhaeVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j10, objZze);
                } else {
                    unsafe.putObject(obj, j10, object);
                }
                zzH(obj, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!zzQ(object2)) {
                Object objZze2 = zzhaeVarZzx.zze();
                zzhaeVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j10, objZze2);
                object2 = objZze2;
            }
            zzhaeVarZzx.zzg(object2, object);
        }
    }

    private final void zzF(Object obj, Object obj2, int i10) {
        int i11 = this.zzc[i10];
        if (zzR(obj2, i11, i10)) {
            int iZzu = zzu(i10) & 1048575;
            Unsafe unsafe = zzb;
            long j10 = iZzu;
            Object object = unsafe.getObject(obj2, j10);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.zzc[i10] + " is present but null: " + obj2.toString());
            }
            zzhae zzhaeVarZzx = zzx(i10);
            if (!zzR(obj, i11, i10)) {
                if (zzQ(object)) {
                    Object objZze = zzhaeVarZzx.zze();
                    zzhaeVarZzx.zzg(objZze, object);
                    unsafe.putObject(obj, j10, objZze);
                } else {
                    unsafe.putObject(obj, j10, object);
                }
                zzI(obj, i11, i10);
                return;
            }
            Object object2 = unsafe.getObject(obj, j10);
            if (!zzQ(object2)) {
                Object objZze2 = zzhaeVarZzx.zze();
                zzhaeVarZzx.zzg(objZze2, object2);
                unsafe.putObject(obj, j10, objZze2);
                object2 = objZze2;
            }
            zzhaeVarZzx.zzg(object2, object);
        }
    }

    private final void zzG(Object obj, int i10, zzgzw zzgzwVar) throws IOException {
        long j10 = i10 & 1048575;
        if (zzM(i10)) {
            zzhaz.zzv(obj, j10, zzgzwVar.zzs());
        } else if (this.zzi) {
            zzhaz.zzv(obj, j10, zzgzwVar.zzr());
        } else {
            zzhaz.zzv(obj, j10, zzgzwVar.zzp());
        }
    }

    private final void zzH(Object obj, int i10) {
        int iZzr = zzr(i10);
        long j10 = 1048575 & iZzr;
        if (j10 == 1048575) {
            return;
        }
        zzhaz.zzt(obj, j10, (1 << (iZzr >>> 20)) | zzhaz.zzd(obj, j10));
    }

    private final void zzI(Object obj, int i10, int i11) {
        zzhaz.zzt(obj, zzr(i11) & 1048575, i10);
    }

    private final void zzJ(Object obj, int i10, Object obj2) {
        zzb.putObject(obj, zzu(i10) & 1048575, obj2);
        zzH(obj, i10);
    }

    private final void zzK(Object obj, int i10, int i11, Object obj2) {
        zzb.putObject(obj, zzu(i11) & 1048575, obj2);
        zzI(obj, i10, i11);
    }

    private final boolean zzL(Object obj, Object obj2, int i10) {
        return zzN(obj, i10) == zzN(obj2, i10);
    }

    private static boolean zzM(int i10) {
        return (i10 & 536870912) != 0;
    }

    private final boolean zzN(Object obj, int i10) {
        int iZzr = zzr(i10);
        long j10 = iZzr & 1048575;
        if (j10 != 1048575) {
            return (zzhaz.zzd(obj, j10) & (1 << (iZzr >>> 20))) != 0;
        }
        int iZzu = zzu(i10);
        long j11 = iZzu & 1048575;
        switch (zzt(iZzu)) {
            case 0:
                return Double.doubleToRawLongBits(zzhaz.zzb(obj, j11)) != 0;
            case 1:
                return Float.floatToRawIntBits(zzhaz.zzc(obj, j11)) != 0;
            case 2:
                return zzhaz.zzf(obj, j11) != 0;
            case 3:
                return zzhaz.zzf(obj, j11) != 0;
            case 4:
                return zzhaz.zzd(obj, j11) != 0;
            case 5:
                return zzhaz.zzf(obj, j11) != 0;
            case 6:
                return zzhaz.zzd(obj, j11) != 0;
            case 7:
                return zzhaz.zzz(obj, j11);
            case 8:
                Object objZzh = zzhaz.zzh(obj, j11);
                if (objZzh instanceof String) {
                    return !((String) objZzh).isEmpty();
                }
                if (objZzh instanceof zzgwm) {
                    return !zzgwm.zzb.equals(objZzh);
                }
                throw new IllegalArgumentException();
            case 9:
                return zzhaz.zzh(obj, j11) != null;
            case 10:
                return !zzgwm.zzb.equals(zzhaz.zzh(obj, j11));
            case 11:
                return zzhaz.zzd(obj, j11) != 0;
            case 12:
                return zzhaz.zzd(obj, j11) != 0;
            case 13:
                return zzhaz.zzd(obj, j11) != 0;
            case 14:
                return zzhaz.zzf(obj, j11) != 0;
            case 15:
                return zzhaz.zzd(obj, j11) != 0;
            case 16:
                return zzhaz.zzf(obj, j11) != 0;
            case 17:
                return zzhaz.zzh(obj, j11) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private final boolean zzO(Object obj, int i10, int i11, int i12, int i13) {
        return i11 == 1048575 ? zzN(obj, i10) : (i12 & i13) != 0;
    }

    private static boolean zzP(Object obj, int i10, zzhae zzhaeVar) {
        return zzhaeVar.zzl(zzhaz.zzh(obj, i10 & 1048575));
    }

    private static boolean zzQ(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof zzgxy) {
            return ((zzgxy) obj).zzcf();
        }
        return true;
    }

    private final boolean zzR(Object obj, int i10, int i11) {
        return zzhaz.zzd(obj, (long) (zzr(i11) & 1048575)) == i10;
    }

    private static boolean zzS(Object obj, long j10) {
        return ((Boolean) zzhaz.zzh(obj, j10)).booleanValue();
    }

    private static final void zzT(int i10, Object obj, zzhbh zzhbhVar) throws IOException {
        if (obj instanceof String) {
            zzhbhVar.zzG(i10, (String) obj);
        } else {
            zzhbhVar.zzd(i10, (zzgwm) obj);
        }
    }

    static zzhat zzd(Object obj) {
        zzgxy zzgxyVar = (zzgxy) obj;
        zzhat zzhatVar = zzgxyVar.zzt;
        if (zzhatVar != zzhat.zzc()) {
            return zzhatVar;
        }
        zzhat zzhatVarZzf = zzhat.zzf();
        zzgxyVar.zzt = zzhatVarZzf;
        return zzhatVarZzf;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0282  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static com.google.android.gms.internal.ads.zzgzm zzm(java.lang.Class r33, com.google.android.gms.internal.ads.zzgzg r34, com.google.android.gms.internal.ads.zzgzp r35, com.google.android.gms.internal.ads.zzgyw r36, com.google.android.gms.internal.ads.zzhas r37, com.google.android.gms.internal.ads.zzgxj r38, com.google.android.gms.internal.ads.zzgze r39) {
        /*
            Method dump skipped, instruction units count: 1030
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgzm.zzm(java.lang.Class, com.google.android.gms.internal.ads.zzgzg, com.google.android.gms.internal.ads.zzgzp, com.google.android.gms.internal.ads.zzgyw, com.google.android.gms.internal.ads.zzhas, com.google.android.gms.internal.ads.zzgxj, com.google.android.gms.internal.ads.zzgze):com.google.android.gms.internal.ads.zzgzm");
    }

    private static double zzn(Object obj, long j10) {
        return ((Double) zzhaz.zzh(obj, j10)).doubleValue();
    }

    private static float zzo(Object obj, long j10) {
        return ((Float) zzhaz.zzh(obj, j10)).floatValue();
    }

    private static int zzp(Object obj, long j10) {
        return ((Integer) zzhaz.zzh(obj, j10)).intValue();
    }

    private final int zzq(int i10) {
        if (i10 < this.zze || i10 > this.zzf) {
            return -1;
        }
        return zzs(i10, 0);
    }

    private final int zzr(int i10) {
        return this.zzc[i10 + 2];
    }

    private final int zzs(int i10, int i11) {
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

    private static int zzt(int i10) {
        return (i10 >>> 20) & 255;
    }

    private final int zzu(int i10) {
        return this.zzc[i10 + 1];
    }

    private static long zzv(Object obj, long j10) {
        return ((Long) zzhaz.zzh(obj, j10)).longValue();
    }

    private final zzgye zzw(int i10) {
        int i11 = i10 / 3;
        return (zzgye) this.zzd[i11 + i11 + 1];
    }

    private final zzhae zzx(int i10) {
        Object[] objArr = this.zzd;
        int i11 = i10 / 3;
        int i12 = i11 + i11;
        zzhae zzhaeVar = (zzhae) objArr[i12];
        if (zzhaeVar != null) {
            return zzhaeVar;
        }
        zzhae zzhaeVarZzb = zzgzt.zza().zzb((Class) objArr[i12 + 1]);
        this.zzd[i12] = zzhaeVarZzb;
        return zzhaeVarZzb;
    }

    private final Object zzy(Object obj, int i10, Object obj2, zzhas zzhasVar, Object obj3) {
        int i11 = this.zzc[i10];
        Object objZzh = zzhaz.zzh(obj, zzu(i10) & 1048575);
        if (objZzh == null || zzw(i10) == null) {
            return obj2;
        }
        throw null;
    }

    private final Object zzz(int i10) {
        int i11 = i10 / 3;
        return this.zzd[i11 + i11];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:207:0x054e  */
    /* JADX WARN: Type inference failed for: r0v115, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v118, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v120, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v137 */
    /* JADX WARN: Type inference failed for: r0v185, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v256, types: [int] */
    /* JADX WARN: Type inference failed for: r0v264 */
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
    /* JADX WARN: Type inference failed for: r0v281 */
    /* JADX WARN: Type inference failed for: r0v282 */
    /* JADX WARN: Type inference failed for: r0v283 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v122, types: [int] */
    /* JADX WARN: Type inference failed for: r1v125, types: [int] */
    /* JADX WARN: Type inference failed for: r1v164 */
    /* JADX WARN: Type inference failed for: r1v167 */
    /* JADX WARN: Type inference failed for: r1v168 */
    /* JADX WARN: Type inference failed for: r1v170 */
    /* JADX WARN: Type inference failed for: r1v171 */
    /* JADX WARN: Type inference failed for: r1v172 */
    /* JADX WARN: Type inference failed for: r1v82, types: [int] */
    /* JADX WARN: Type inference failed for: r1v84 */
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
    @Override // com.google.android.gms.internal.ads.zzhae
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(java.lang.Object r20) {
        /*
            Method dump skipped, instruction units count: 2192
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgzm.zza(java.lang.Object):int");
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final int zzb(Object obj) {
        int i10;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i11;
        int i12 = 0;
        for (int i13 = 0; i13 < this.zzc.length; i13 += 3) {
            int iZzu = zzu(i13);
            int[] iArr = this.zzc;
            int i14 = 1048575 & iZzu;
            int iZzt = zzt(iZzu);
            int i15 = iArr[i13];
            long j10 = i14;
            int iHashCode = 37;
            switch (iZzt) {
                case 0:
                    i10 = i12 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(zzhaz.zzb(obj, j10));
                    byte[] bArr = zzgyl.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 1:
                    i10 = i12 * 53;
                    iFloatToIntBits = Float.floatToIntBits(zzhaz.zzc(obj, j10));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 2:
                    i10 = i12 * 53;
                    jDoubleToLongBits = zzhaz.zzf(obj, j10);
                    byte[] bArr2 = zzgyl.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 3:
                    i10 = i12 * 53;
                    jDoubleToLongBits = zzhaz.zzf(obj, j10);
                    byte[] bArr3 = zzgyl.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 4:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzhaz.zzd(obj, j10);
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 5:
                    i10 = i12 * 53;
                    jDoubleToLongBits = zzhaz.zzf(obj, j10);
                    byte[] bArr4 = zzgyl.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 6:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzhaz.zzd(obj, j10);
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 7:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzgyl.zza(zzhaz.zzz(obj, j10));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 8:
                    i10 = i12 * 53;
                    iFloatToIntBits = ((String) zzhaz.zzh(obj, j10)).hashCode();
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 9:
                    i11 = i12 * 53;
                    Object objZzh = zzhaz.zzh(obj, j10);
                    if (objZzh != null) {
                        iHashCode = objZzh.hashCode();
                    }
                    i12 = i11 + iHashCode;
                    break;
                case 10:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzhaz.zzh(obj, j10).hashCode();
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 11:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzhaz.zzd(obj, j10);
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 12:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzhaz.zzd(obj, j10);
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 13:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzhaz.zzd(obj, j10);
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 14:
                    i10 = i12 * 53;
                    jDoubleToLongBits = zzhaz.zzf(obj, j10);
                    byte[] bArr5 = zzgyl.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 15:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzhaz.zzd(obj, j10);
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 16:
                    i10 = i12 * 53;
                    jDoubleToLongBits = zzhaz.zzf(obj, j10);
                    byte[] bArr6 = zzgyl.zzb;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 17:
                    i11 = i12 * 53;
                    Object objZzh2 = zzhaz.zzh(obj, j10);
                    if (objZzh2 != null) {
                        iHashCode = objZzh2.hashCode();
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
                    iFloatToIntBits = zzhaz.zzh(obj, j10).hashCode();
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 50:
                    i10 = i12 * 53;
                    iFloatToIntBits = zzhaz.zzh(obj, j10).hashCode();
                    i12 = i10 + iFloatToIntBits;
                    break;
                case 51:
                    if (zzR(obj, i15, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(zzn(obj, j10));
                        byte[] bArr7 = zzgyl.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 52:
                    if (zzR(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = Float.floatToIntBits(zzo(obj, j10));
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 53:
                    if (zzR(obj, i15, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = zzv(obj, j10);
                        byte[] bArr8 = zzgyl.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 54:
                    if (zzR(obj, i15, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = zzv(obj, j10);
                        byte[] bArr9 = zzgyl.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 55:
                    if (zzR(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzp(obj, j10);
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 56:
                    if (zzR(obj, i15, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = zzv(obj, j10);
                        byte[] bArr10 = zzgyl.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 57:
                    if (zzR(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzp(obj, j10);
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 58:
                    if (zzR(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzgyl.zza(zzS(obj, j10));
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 59:
                    if (zzR(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = ((String) zzhaz.zzh(obj, j10)).hashCode();
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 60:
                    if (zzR(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzhaz.zzh(obj, j10).hashCode();
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 61:
                    if (zzR(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzhaz.zzh(obj, j10).hashCode();
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 62:
                    if (zzR(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzp(obj, j10);
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 63:
                    if (zzR(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzp(obj, j10);
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 64:
                    if (zzR(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzp(obj, j10);
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 65:
                    if (zzR(obj, i15, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = zzv(obj, j10);
                        byte[] bArr11 = zzgyl.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 66:
                    if (zzR(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzp(obj, j10);
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 67:
                    if (zzR(obj, i15, i13)) {
                        i10 = i12 * 53;
                        jDoubleToLongBits = zzv(obj, j10);
                        byte[] bArr12 = zzgyl.zzb;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
                case 68:
                    if (zzR(obj, i15, i13)) {
                        i10 = i12 * 53;
                        iFloatToIntBits = zzhaz.zzh(obj, j10).hashCode();
                        i12 = i10 + iFloatToIntBits;
                    }
                    break;
            }
        }
        int iHashCode2 = (i12 * 53) + ((zzgxy) obj).zzt.hashCode();
        return this.zzh ? (iHashCode2 * 53) + ((zzgxu) obj).zza.zza.hashCode() : iHashCode2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:484:0x0b6f, code lost:
    
        if (r5 == r0) goto L486;
     */
    /* JADX WARN: Code restructure failed: missing block: B:485:0x0b71, code lost:
    
        r14.putInt(r7, r5, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:486:0x0b75, code lost:
    
        r11 = r12.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:488:0x0b7a, code lost:
    
        if (r11 >= r12.zzl) goto L592;
     */
    /* JADX WARN: Code restructure failed: missing block: B:489:0x0b7c, code lost:
    
        zzy(r34, r12.zzj[r11], null, r12.zzm, r34);
        r11 = r11 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:490:0x0b8f, code lost:
    
        if (r9 != 0) goto L495;
     */
    /* JADX WARN: Code restructure failed: missing block: B:491:0x0b91, code lost:
    
        if (r6 != r10) goto L493;
     */
    /* JADX WARN: Code restructure failed: missing block: B:494:0x0b98, code lost:
    
        throw com.google.android.gms.internal.ads.zzgyn.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:495:0x0b99, code lost:
    
        if (r6 > r10) goto L498;
     */
    /* JADX WARN: Code restructure failed: missing block: B:496:0x0b9b, code lost:
    
        if (r8 != r9) goto L498;
     */
    /* JADX WARN: Code restructure failed: missing block: B:497:0x0b9d, code lost:
    
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:499:0x0ba2, code lost:
    
        throw com.google.android.gms.internal.ads.zzgyn.zzg();
     */
    /* JADX WARN: Removed duplicated region for block: B:379:0x0836 A[PHI: r7 r8 r9 r10 r11 r14
      0x0836: PHI (r7v24 int) = (r7v6 int), (r7v8 int), (r7v9 int), (r7v14 int), (r7v18 int), (r7v22 int), (r7v28 int) binds: [B:368:0x07ed, B:352:0x0797, B:336:0x0748, B:261:0x05f4, B:212:0x0529, B:179:0x0497, B:138:0x0392] A[DONT_GENERATE, DONT_INLINE]
      0x0836: PHI (r8v98 int) = (r8v41 int), (r8v43 int), (r8v44 int), (r8v73 int), (r8v89 int), (r8v96 int), (r8v101 int) binds: [B:368:0x07ed, B:352:0x0797, B:336:0x0748, B:261:0x05f4, B:212:0x0529, B:179:0x0497, B:138:0x0392] A[DONT_GENERATE, DONT_INLINE]
      0x0836: PHI (r9v63 int) = (r9v35 int), (r9v37 int), (r9v38 int), (r9v51 int), (r9v59 int), (r9v61 int), (r9v66 int) binds: [B:368:0x07ed, B:352:0x0797, B:336:0x0748, B:261:0x05f4, B:212:0x0529, B:179:0x0497, B:138:0x0392] A[DONT_GENERATE, DONT_INLINE]
      0x0836: PHI (r10v72 int) = (r10v40 int), (r10v42 int), (r10v43 int), (r10v45 int), (r10v57 int), (r10v64 int), (r10v76 int) binds: [B:368:0x07ed, B:352:0x0797, B:336:0x0748, B:261:0x05f4, B:212:0x0529, B:179:0x0497, B:138:0x0392] A[DONT_GENERATE, DONT_INLINE]
      0x0836: PHI (r11v42 int) = (r11v20 int), (r11v22 int), (r11v23 int), (r11v25 int), (r11v34 int), (r11v40 int), (r11v46 int) binds: [B:368:0x07ed, B:352:0x0797, B:336:0x0748, B:261:0x05f4, B:212:0x0529, B:179:0x0497, B:138:0x0392] A[DONT_GENERATE, DONT_INLINE]
      0x0836: PHI (r14v44 sun.misc.Unsafe) = 
      (r14v23 sun.misc.Unsafe)
      (r14v25 sun.misc.Unsafe)
      (r14v26 sun.misc.Unsafe)
      (r14v28 sun.misc.Unsafe)
      (r14v36 sun.misc.Unsafe)
      (r14v42 sun.misc.Unsafe)
      (r14v47 sun.misc.Unsafe)
     binds: [B:368:0x07ed, B:352:0x0797, B:336:0x0748, B:261:0x05f4, B:212:0x0529, B:179:0x0497, B:138:0x0392] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:465:0x0ae3 A[PHI: r8 r10 r11 r12 r36
      0x0ae3: PHI (r8v123 com.google.android.gms.internal.ads.zzgwa) = 
      (r8v104 com.google.android.gms.internal.ads.zzgwa)
      (r8v105 com.google.android.gms.internal.ads.zzgwa)
      (r8v106 com.google.android.gms.internal.ads.zzgwa)
      (r8v107 com.google.android.gms.internal.ads.zzgwa)
      (r8v108 com.google.android.gms.internal.ads.zzgwa)
      (r8v109 com.google.android.gms.internal.ads.zzgwa)
      (r8v110 com.google.android.gms.internal.ads.zzgwa)
      (r8v111 com.google.android.gms.internal.ads.zzgwa)
      (r8v112 com.google.android.gms.internal.ads.zzgwa)
      (r8v116 com.google.android.gms.internal.ads.zzgwa)
      (r8v124 com.google.android.gms.internal.ads.zzgwa)
     binds: [B:463:0x0acc, B:460:0x0aaa, B:457:0x0a8c, B:454:0x0a6e, B:451:0x0a50, B:448:0x0a31, B:441:0x0a09, B:439:0x09fb, B:424:0x09b0, B:420:0x097d, B:396:0x08a8] A[DONT_GENERATE, DONT_INLINE]
      0x0ae3: PHI (r10v101 int) = 
      (r10v80 int)
      (r10v81 int)
      (r10v82 int)
      (r10v83 int)
      (r10v84 int)
      (r10v85 int)
      (r10v86 int)
      (r10v87 int)
      (r10v88 int)
      (r10v94 int)
      (r10v102 int)
     binds: [B:463:0x0acc, B:460:0x0aaa, B:457:0x0a8c, B:454:0x0a6e, B:451:0x0a50, B:448:0x0a31, B:441:0x0a09, B:439:0x09fb, B:424:0x09b0, B:420:0x097d, B:396:0x08a8] A[DONT_GENERATE, DONT_INLINE]
      0x0ae3: PHI (r11v64 int) = 
      (r11v48 int)
      (r11v49 int)
      (r11v50 int)
      (r11v51 int)
      (r11v52 int)
      (r11v53 int)
      (r11v54 int)
      (r11v55 int)
      (r11v56 int)
      (r11v59 int)
      (r11v65 int)
     binds: [B:463:0x0acc, B:460:0x0aaa, B:457:0x0a8c, B:454:0x0a6e, B:451:0x0a50, B:448:0x0a31, B:441:0x0a09, B:439:0x09fb, B:424:0x09b0, B:420:0x097d, B:396:0x08a8] A[DONT_GENERATE, DONT_INLINE]
      0x0ae3: PHI (r12v34 int) = 
      (r12v15 int)
      (r12v16 int)
      (r12v17 int)
      (r12v18 int)
      (r12v19 int)
      (r12v20 int)
      (r12v21 int)
      (r12v22 int)
      (r12v23 int)
      (r12v27 int)
      (r12v35 int)
     binds: [B:463:0x0acc, B:460:0x0aaa, B:457:0x0a8c, B:454:0x0a6e, B:451:0x0a50, B:448:0x0a31, B:441:0x0a09, B:439:0x09fb, B:424:0x09b0, B:420:0x097d, B:396:0x08a8] A[DONT_GENERATE, DONT_INLINE]
      0x0ae3: PHI (r36v21 int) = 
      (r36v3 int)
      (r36v4 int)
      (r36v5 int)
      (r36v6 int)
      (r36v7 int)
      (r36v8 int)
      (r36v9 int)
      (r36v10 int)
      (r36v14 int)
      (r36v16 int)
      (r36v22 int)
     binds: [B:463:0x0acc, B:460:0x0aaa, B:457:0x0a8c, B:454:0x0a6e, B:451:0x0a50, B:448:0x0a31, B:441:0x0a09, B:439:0x09fb, B:424:0x09b0, B:420:0x097d, B:396:0x08a8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:481:0x0b40  */
    /* JADX WARN: Removed duplicated region for block: B:537:0x0839 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:540:0x0ae6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:580:0x084a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:583:0x0af9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final int zzc(java.lang.Object r34, byte[] r35, int r36, int r37, int r38, com.google.android.gms.internal.ads.zzgwa r39) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 3124
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgzm.zzc(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzgwa):int");
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final Object zze() {
        return ((zzgxy) this.zzg).zzbj();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006f  */
    @Override // com.google.android.gms.internal.ads.zzhae
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzf(java.lang.Object r8) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgzm.zzf(java.lang.Object):void");
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final void zzg(Object obj, Object obj2) {
        zzD(obj);
        obj2.getClass();
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int iZzu = zzu(i10);
            int i11 = 1048575 & iZzu;
            int[] iArr = this.zzc;
            int iZzt = zzt(iZzu);
            int i12 = iArr[i10];
            long j10 = i11;
            switch (iZzt) {
                case 0:
                    if (zzN(obj2, i10)) {
                        zzhaz.zzr(obj, j10, zzhaz.zzb(obj2, j10));
                        zzH(obj, i10);
                    }
                    break;
                case 1:
                    if (zzN(obj2, i10)) {
                        zzhaz.zzs(obj, j10, zzhaz.zzc(obj2, j10));
                        zzH(obj, i10);
                    }
                    break;
                case 2:
                    if (zzN(obj2, i10)) {
                        zzhaz.zzu(obj, j10, zzhaz.zzf(obj2, j10));
                        zzH(obj, i10);
                    }
                    break;
                case 3:
                    if (zzN(obj2, i10)) {
                        zzhaz.zzu(obj, j10, zzhaz.zzf(obj2, j10));
                        zzH(obj, i10);
                    }
                    break;
                case 4:
                    if (zzN(obj2, i10)) {
                        zzhaz.zzt(obj, j10, zzhaz.zzd(obj2, j10));
                        zzH(obj, i10);
                    }
                    break;
                case 5:
                    if (zzN(obj2, i10)) {
                        zzhaz.zzu(obj, j10, zzhaz.zzf(obj2, j10));
                        zzH(obj, i10);
                    }
                    break;
                case 6:
                    if (zzN(obj2, i10)) {
                        zzhaz.zzt(obj, j10, zzhaz.zzd(obj2, j10));
                        zzH(obj, i10);
                    }
                    break;
                case 7:
                    if (zzN(obj2, i10)) {
                        zzhaz.zzp(obj, j10, zzhaz.zzz(obj2, j10));
                        zzH(obj, i10);
                    }
                    break;
                case 8:
                    if (zzN(obj2, i10)) {
                        zzhaz.zzv(obj, j10, zzhaz.zzh(obj2, j10));
                        zzH(obj, i10);
                    }
                    break;
                case 9:
                    zzE(obj, obj2, i10);
                    break;
                case 10:
                    if (zzN(obj2, i10)) {
                        zzhaz.zzv(obj, j10, zzhaz.zzh(obj2, j10));
                        zzH(obj, i10);
                    }
                    break;
                case 11:
                    if (zzN(obj2, i10)) {
                        zzhaz.zzt(obj, j10, zzhaz.zzd(obj2, j10));
                        zzH(obj, i10);
                    }
                    break;
                case 12:
                    if (zzN(obj2, i10)) {
                        zzhaz.zzt(obj, j10, zzhaz.zzd(obj2, j10));
                        zzH(obj, i10);
                    }
                    break;
                case 13:
                    if (zzN(obj2, i10)) {
                        zzhaz.zzt(obj, j10, zzhaz.zzd(obj2, j10));
                        zzH(obj, i10);
                    }
                    break;
                case 14:
                    if (zzN(obj2, i10)) {
                        zzhaz.zzu(obj, j10, zzhaz.zzf(obj2, j10));
                        zzH(obj, i10);
                    }
                    break;
                case 15:
                    if (zzN(obj2, i10)) {
                        zzhaz.zzt(obj, j10, zzhaz.zzd(obj2, j10));
                        zzH(obj, i10);
                    }
                    break;
                case 16:
                    if (zzN(obj2, i10)) {
                        zzhaz.zzu(obj, j10, zzhaz.zzf(obj2, j10));
                        zzH(obj, i10);
                    }
                    break;
                case 17:
                    zzE(obj, obj2, i10);
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
                    zzgyk zzgykVarZzf = (zzgyk) zzhaz.zzh(obj, j10);
                    zzgyk zzgykVar = (zzgyk) zzhaz.zzh(obj2, j10);
                    int size = zzgykVarZzf.size();
                    int size2 = zzgykVar.size();
                    if (size > 0 && size2 > 0) {
                        if (!zzgykVarZzf.zzc()) {
                            zzgykVarZzf = zzgykVarZzf.zzf(size2 + size);
                        }
                        zzgykVarZzf.addAll(zzgykVar);
                    }
                    if (size > 0) {
                        zzgykVar = zzgykVarZzf;
                    }
                    zzhaz.zzv(obj, j10, zzgykVar);
                    break;
                case 50:
                    int i13 = zzhag.zza;
                    zzhaz.zzv(obj, j10, zzgze.zzb(zzhaz.zzh(obj, j10), zzhaz.zzh(obj2, j10)));
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
                    if (zzR(obj2, i12, i10)) {
                        zzhaz.zzv(obj, j10, zzhaz.zzh(obj2, j10));
                        zzI(obj, i12, i10);
                    }
                    break;
                case 60:
                    zzF(obj, obj2, i10);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (zzR(obj2, i12, i10)) {
                        zzhaz.zzv(obj, j10, zzhaz.zzh(obj2, j10));
                        zzI(obj, i12, i10);
                    }
                    break;
                case 68:
                    zzF(obj, obj2, i10);
                    break;
            }
        }
        zzhag.zzq(this.zzm, obj, obj2);
        if (this.zzh) {
            zzhag.zzp(this.zzn, obj, obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:319:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhae
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzh(java.lang.Object r10, com.google.android.gms.internal.ads.zzgzw r11, com.google.android.gms.internal.ads.zzgxi r12) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1476
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgzm.zzh(java.lang.Object, com.google.android.gms.internal.ads.zzgzw, com.google.android.gms.internal.ads.zzgxi):void");
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final void zzi(Object obj, byte[] bArr, int i10, int i11, zzgwa zzgwaVar) throws IOException {
        zzc(obj, bArr, i10, i11, 0, zzgwaVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    @Override // com.google.android.gms.internal.ads.zzhae
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zzj(java.lang.Object r24, com.google.android.gms.internal.ads.zzhbh r25) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1840
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgzm.zzj(java.lang.Object, com.google.android.gms.internal.ads.zzhbh):void");
    }

    @Override // com.google.android.gms.internal.ads.zzhae
    public final boolean zzk(Object obj, Object obj2) {
        boolean zZzJ;
        for (int i10 = 0; i10 < this.zzc.length; i10 += 3) {
            int iZzu = zzu(i10);
            long j10 = iZzu & 1048575;
            switch (zzt(iZzu)) {
                case 0:
                    if (!zzL(obj, obj2, i10) || Double.doubleToLongBits(zzhaz.zzb(obj, j10)) != Double.doubleToLongBits(zzhaz.zzb(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 1:
                    if (!zzL(obj, obj2, i10) || Float.floatToIntBits(zzhaz.zzc(obj, j10)) != Float.floatToIntBits(zzhaz.zzc(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 2:
                    if (!zzL(obj, obj2, i10) || zzhaz.zzf(obj, j10) != zzhaz.zzf(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 3:
                    if (!zzL(obj, obj2, i10) || zzhaz.zzf(obj, j10) != zzhaz.zzf(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 4:
                    if (!zzL(obj, obj2, i10) || zzhaz.zzd(obj, j10) != zzhaz.zzd(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 5:
                    if (!zzL(obj, obj2, i10) || zzhaz.zzf(obj, j10) != zzhaz.zzf(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 6:
                    if (!zzL(obj, obj2, i10) || zzhaz.zzd(obj, j10) != zzhaz.zzd(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 7:
                    if (!zzL(obj, obj2, i10) || zzhaz.zzz(obj, j10) != zzhaz.zzz(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 8:
                    if (!zzL(obj, obj2, i10) || !zzhag.zzJ(zzhaz.zzh(obj, j10), zzhaz.zzh(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 9:
                    if (!zzL(obj, obj2, i10) || !zzhag.zzJ(zzhaz.zzh(obj, j10), zzhaz.zzh(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 10:
                    if (!zzL(obj, obj2, i10) || !zzhag.zzJ(zzhaz.zzh(obj, j10), zzhaz.zzh(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 11:
                    if (!zzL(obj, obj2, i10) || zzhaz.zzd(obj, j10) != zzhaz.zzd(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 12:
                    if (!zzL(obj, obj2, i10) || zzhaz.zzd(obj, j10) != zzhaz.zzd(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 13:
                    if (!zzL(obj, obj2, i10) || zzhaz.zzd(obj, j10) != zzhaz.zzd(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 14:
                    if (!zzL(obj, obj2, i10) || zzhaz.zzf(obj, j10) != zzhaz.zzf(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 15:
                    if (!zzL(obj, obj2, i10) || zzhaz.zzd(obj, j10) != zzhaz.zzd(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 16:
                    if (!zzL(obj, obj2, i10) || zzhaz.zzf(obj, j10) != zzhaz.zzf(obj2, j10)) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                case 17:
                    if (!zzL(obj, obj2, i10) || !zzhag.zzJ(zzhaz.zzh(obj, j10), zzhaz.zzh(obj2, j10))) {
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
                    zZzJ = zzhag.zzJ(zzhaz.zzh(obj, j10), zzhaz.zzh(obj2, j10));
                    break;
                case 50:
                    zZzJ = zzhag.zzJ(zzhaz.zzh(obj, j10), zzhaz.zzh(obj2, j10));
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
                    long jZzr = zzr(i10) & 1048575;
                    if (zzhaz.zzd(obj, jZzr) != zzhaz.zzd(obj2, jZzr) || !zzhag.zzJ(zzhaz.zzh(obj, j10), zzhaz.zzh(obj2, j10))) {
                        return false;
                    }
                    continue;
                    break;
                    break;
                default:
                    break;
            }
            if (!zZzJ) {
                return false;
            }
        }
        if (!((zzgxy) obj).zzt.equals(((zzgxy) obj2).zzt)) {
            return false;
        }
        if (this.zzh) {
            return ((zzgxu) obj).zza.equals(((zzgxu) obj2).zza);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x009b  */
    @Override // com.google.android.gms.internal.ads.zzhae
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzl(java.lang.Object r18) {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgzm.zzl(java.lang.Object):boolean");
    }
}
