package com.google.android.gms.internal.drive;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: loaded from: classes3.dex */
final class zznd {
    private static final Logger logger = Logger.getLogger(zznd.class.getName());
    private static final Class<?> zzni;
    private static final boolean zzog;
    private static final Unsafe zzuc;
    private static final boolean zzvy;
    private static final boolean zzvz;
    private static final zzd zzwa;
    private static final boolean zzwb;
    private static final long zzwc;
    private static final long zzwd;
    private static final long zzwe;
    private static final long zzwf;
    private static final long zzwg;
    private static final long zzwh;
    private static final long zzwi;
    private static final long zzwj;
    private static final long zzwk;
    private static final long zzwl;
    private static final long zzwm;
    private static final long zzwn;
    private static final long zzwo;
    private static final long zzwp;
    private static final int zzwq;
    static final boolean zzwr;

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j10, boolean z10) {
            this.zzws.putBoolean(obj, j10, z10);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zze(Object obj, long j10, byte b10) {
            this.zzws.putByte(obj, j10, b10);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final boolean zzl(Object obj, long j10) {
            return this.zzws.getBoolean(obj, j10);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final float zzm(Object obj, long j10) {
            return this.zzws.getFloat(obj, j10);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final double zzn(Object obj, long j10) {
            return this.zzws.getDouble(obj, j10);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final byte zzx(Object obj, long j10) {
            return this.zzws.getByte(obj, j10);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j10, float f10) {
            this.zzws.putFloat(obj, j10, f10);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j10, double d10) {
            this.zzws.putDouble(obj, j10, d10);
        }
    }

    static abstract class zzd {
        Unsafe zzws;

        zzd(Unsafe unsafe) {
            this.zzws = unsafe;
        }

        public abstract void zza(Object obj, long j10, double d10);

        public abstract void zza(Object obj, long j10, float f10);

        public final void zza(Object obj, long j10, int i10) {
            this.zzws.putInt(obj, j10, i10);
        }

        public abstract void zza(Object obj, long j10, boolean z10);

        public abstract void zze(Object obj, long j10, byte b10);

        public final int zzj(Object obj, long j10) {
            return this.zzws.getInt(obj, j10);
        }

        public final long zzk(Object obj, long j10) {
            return this.zzws.getLong(obj, j10);
        }

        public abstract boolean zzl(Object obj, long j10);

        public abstract float zzm(Object obj, long j10);

        public abstract double zzn(Object obj, long j10);

        public abstract byte zzx(Object obj, long j10);

        public final void zza(Object obj, long j10, long j11) {
            this.zzws.putLong(obj, j10, j11);
        }
    }

    static {
        Unsafe unsafeZzff = zzff();
        zzuc = unsafeZzff;
        zzni = zzix.zzbs();
        boolean zZzk = zzk(Long.TYPE);
        zzvy = zZzk;
        boolean zZzk2 = zzk(Integer.TYPE);
        zzvz = zZzk2;
        zzd zzcVar = null;
        if (unsafeZzff != null) {
            if (!zzix.zzbr()) {
                zzcVar = new zzc(unsafeZzff);
            } else if (zZzk) {
                zzcVar = new zzb(unsafeZzff);
            } else if (zZzk2) {
                zzcVar = new zza(unsafeZzff);
            }
        }
        zzwa = zzcVar;
        zzwb = zzfh();
        zzog = zzfg();
        long jZzi = zzi(byte[].class);
        zzwc = jZzi;
        zzwd = zzi(boolean[].class);
        zzwe = zzj(boolean[].class);
        zzwf = zzi(int[].class);
        zzwg = zzj(int[].class);
        zzwh = zzi(long[].class);
        zzwi = zzj(long[].class);
        zzwj = zzi(float[].class);
        zzwk = zzj(float[].class);
        zzwl = zzi(double[].class);
        zzwm = zzj(double[].class);
        zzwn = zzi(Object[].class);
        zzwo = zzj(Object[].class);
        Field fieldZzfi = zzfi();
        zzwp = (fieldZzfi == null || zzcVar == null) ? -1L : zzcVar.zzws.objectFieldOffset(fieldZzfi);
        zzwq = (int) (jZzi & 7);
        zzwr = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private zznd() {
    }

    static void zza(Object obj, long j10, int i10) {
        zzwa.zza(obj, j10, i10);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzc(Object obj, long j10, boolean z10) {
        zzb(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    static boolean zzfd() {
        return zzog;
    }

    static boolean zzfe() {
        return zzwb;
    }

    static Unsafe zzff() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzne());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzfg() {
        Unsafe unsafe = zzuc;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getInt", Object.class, cls2);
            cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
            cls.getMethod("getLong", Object.class, cls2);
            cls.getMethod("putLong", Object.class, cls2, cls2);
            cls.getMethod("getObject", Object.class, cls2);
            cls.getMethod("putObject", Object.class, cls2, Object.class);
            if (zzix.zzbr()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, cls2);
            cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, cls2);
            cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, cls2);
            cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
            cls.getMethod("getDouble", Object.class, cls2);
            cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzfh() {
        Unsafe unsafe = zzuc;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            Class<?> cls2 = Long.TYPE;
            cls.getMethod("getLong", Object.class, cls2);
            if (zzfi() == null) {
                return false;
            }
            if (zzix.zzbr()) {
                return true;
            }
            cls.getMethod("getByte", cls2);
            cls.getMethod("putByte", cls2, Byte.TYPE);
            cls.getMethod("getInt", cls2);
            cls.getMethod("putInt", cls2, Integer.TYPE);
            cls.getMethod("getLong", cls2);
            cls.getMethod("putLong", cls2, cls2);
            cls.getMethod("copyMemory", cls2, cls2, cls2);
            cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String strValueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(strValueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static Field zzfi() {
        Field fieldZzb;
        if (zzix.zzbr() && (fieldZzb = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return fieldZzb;
        }
        Field fieldZzb2 = zzb(Buffer.class, "address");
        if (fieldZzb2 == null || fieldZzb2.getType() != Long.TYPE) {
            return null;
        }
        return fieldZzb2;
    }

    static <T> T zzh(Class<T> cls) {
        try {
            return (T) zzuc.allocateInstance(cls);
        } catch (InstantiationException e10) {
            throw new IllegalStateException(e10);
        }
    }

    private static int zzi(Class<?> cls) {
        if (zzog) {
            return zzwa.zzws.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzj(Class<?> cls) {
        if (zzog) {
            return zzwa.zzws.arrayIndexScale(cls);
        }
        return -1;
    }

    static long zzk(Object obj, long j10) {
        return zzwa.zzk(obj, j10);
    }

    static boolean zzl(Object obj, long j10) {
        return zzwa.zzl(obj, j10);
    }

    static float zzm(Object obj, long j10) {
        return zzwa.zzm(obj, j10);
    }

    static double zzn(Object obj, long j10) {
        return zzwa.zzn(obj, j10);
    }

    static Object zzo(Object obj, long j10) {
        return zzwa.zzws.getObject(obj, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzp(Object obj, long j10) {
        return (byte) (zzj(obj, (-4) & j10) >>> ((int) (((~j10) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte zzq(Object obj, long j10) {
        return (byte) (zzj(obj, (-4) & j10) >>> ((int) ((j10 & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzr(Object obj, long j10) {
        return zzp(obj, j10) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzs(Object obj, long j10) {
        return zzq(obj, j10) != 0;
    }

    static void zza(Object obj, long j10, long j11) {
        zzwa.zza(obj, j10, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int i10 = (((int) j10) & 3) << 3;
        zza(obj, j11, ((255 & b10) << i10) | (zzj(obj, j11) & (~(255 << i10))));
    }

    private static boolean zzk(Class<?> cls) {
        if (!zzix.zzbr()) {
            return false;
        }
        try {
            Class<?> cls2 = zzni;
            Class<?> cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class<?> cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j10, boolean z10) {
            if (zznd.zzwr) {
                zznd.zzb(obj, j10, z10);
            } else {
                zznd.zzc(obj, j10, z10);
            }
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zze(Object obj, long j10, byte b10) {
            if (zznd.zzwr) {
                zznd.zza(obj, j10, b10);
            } else {
                zznd.zzb(obj, j10, b10);
            }
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final boolean zzl(Object obj, long j10) {
            return zznd.zzwr ? zznd.zzr(obj, j10) : zznd.zzs(obj, j10);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final float zzm(Object obj, long j10) {
            return Float.intBitsToFloat(zzj(obj, j10));
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final double zzn(Object obj, long j10) {
            return Double.longBitsToDouble(zzk(obj, j10));
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final byte zzx(Object obj, long j10) {
            return zznd.zzwr ? zznd.zzp(obj, j10) : zznd.zzq(obj, j10);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j10, float f10) {
            zza(obj, j10, Float.floatToIntBits(f10));
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j10, double d10) {
            zza(obj, j10, Double.doubleToLongBits(d10));
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j10, boolean z10) {
            if (zznd.zzwr) {
                zznd.zzb(obj, j10, z10);
            } else {
                zznd.zzc(obj, j10, z10);
            }
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zze(Object obj, long j10, byte b10) {
            if (zznd.zzwr) {
                zznd.zza(obj, j10, b10);
            } else {
                zznd.zzb(obj, j10, b10);
            }
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final boolean zzl(Object obj, long j10) {
            return zznd.zzwr ? zznd.zzr(obj, j10) : zznd.zzs(obj, j10);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final float zzm(Object obj, long j10) {
            return Float.intBitsToFloat(zzj(obj, j10));
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final double zzn(Object obj, long j10) {
            return Double.longBitsToDouble(zzk(obj, j10));
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final byte zzx(Object obj, long j10) {
            return zznd.zzwr ? zznd.zzp(obj, j10) : zznd.zzq(obj, j10);
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j10, float f10) {
            zza(obj, j10, Float.floatToIntBits(f10));
        }

        @Override // com.google.android.gms.internal.drive.zznd.zzd
        public final void zza(Object obj, long j10, double d10) {
            zza(obj, j10, Double.doubleToLongBits(d10));
        }
    }

    static void zza(Object obj, long j10, boolean z10) {
        zzwa.zza(obj, j10, z10);
    }

    static int zzj(Object obj, long j10) {
        return zzwa.zzj(obj, j10);
    }

    static void zza(Object obj, long j10, float f10) {
        zzwa.zza(obj, j10, f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zzb(Object obj, long j10, boolean z10) {
        zza(obj, j10, z10 ? (byte) 1 : (byte) 0);
    }

    static void zza(Object obj, long j10, double d10) {
        zzwa.zza(obj, j10, d10);
    }

    static void zza(Object obj, long j10, Object obj2) {
        zzwa.zzws.putObject(obj, j10, obj2);
    }

    static byte zza(byte[] bArr, long j10) {
        return zzwa.zzx(bArr, zzwc + j10);
    }

    static void zza(byte[] bArr, long j10, byte b10) {
        zzwa.zze(bArr, zzwc + j10, b10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void zza(Object obj, long j10, byte b10) {
        long j11 = (-4) & j10;
        int iZzj = zzj(obj, j11);
        int i10 = ((~((int) j10)) & 3) << 3;
        zza(obj, j11, ((255 & b10) << i10) | (iZzj & (~(255 << i10))));
    }
}
