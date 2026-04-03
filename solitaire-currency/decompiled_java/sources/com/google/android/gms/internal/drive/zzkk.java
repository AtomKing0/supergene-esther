package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;
import com.google.android.gms.internal.drive.zzkk.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzkk<MessageType extends zzkk<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzit<MessageType, BuilderType> {
    private static Map<Object, zzkk<?, ?>> zzrs = new ConcurrentHashMap();
    protected zzmy zzrq = zzmy.zzfa();
    private int zzrr = -1;

    public static class zzb<T extends zzkk<T, ?>> extends zziv<T> {
        private final T zzrt;

        public zzb(T t10) {
            this.zzrt = t10;
        }
    }

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzkk<MessageType, BuilderType> implements zzls {
        protected zzkb<Object> zzrw = zzkb.zzcn();

        final zzkb<Object> zzdg() {
            if (this.zzrw.isImmutable()) {
                this.zzrw = (zzkb) this.zzrw.clone();
            }
            return this.zzrw;
        }
    }

    public static class zzd<ContainingType extends zzlq, Type> extends zzjv<ContainingType, Type> {
    }

    public enum zze {
        public static final int zzrx = 1;
        public static final int zzry = 2;
        public static final int zzrz = 3;
        public static final int zzsa = 4;
        public static final int zzsb = 5;
        public static final int zzsc = 6;
        public static final int zzsd = 7;
        public static final int zzsf = 1;
        public static final int zzsg = 2;
        public static final int zzsi = 1;
        public static final int zzsj = 2;
        private static final /* synthetic */ int[] zzse = {1, 2, 3, 4, 5, 6, 7};
        private static final /* synthetic */ int[] zzsh = {1, 2};
        private static final /* synthetic */ int[] zzsk = {1, 2};

        public static int[] zzdh() {
            return (int[]) zzse.clone();
        }
    }

    protected static <T extends zzkk<?, ?>> void zza(Class<T> cls, T t10) {
        zzrs.put(cls, t10);
    }

    static <T extends zzkk<?, ?>> T zzd(Class<T> cls) {
        zzkk<?, ?> zzkkVar = zzrs.get(cls);
        if (zzkkVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzkkVar = zzrs.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (zzkkVar == null) {
            zzkkVar = (T) ((zzkk) zznd.zzh(cls)).zza(zze.zzsc, (Object) null, (Object) null);
            if (zzkkVar == null) {
                throw new IllegalStateException();
            }
            zzrs.put(cls, zzkkVar);
        }
        return (T) zzkkVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzkk) zza(zze.zzsc, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return zzmd.zzej().zzq(this).equals(this, (zzkk) obj);
        }
        return false;
    }

    public int hashCode() {
        int i10 = this.zzne;
        if (i10 != 0) {
            return i10;
        }
        int iHashCode = zzmd.zzej().zzq(this).hashCode(this);
        this.zzne = iHashCode;
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.drive.zzls
    public final boolean isInitialized() {
        return zza(this, true);
    }

    public String toString() {
        return zzlt.zza(this, super.toString());
    }

    protected abstract Object zza(int i10, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.drive.zzlq
    public final void zzb(zzjr zzjrVar) throws IOException {
        zzmd.zzej().zzf(getClass()).zza(this, zzjt.zza(zzjrVar));
    }

    @Override // com.google.android.gms.internal.drive.zzit
    final int zzbm() {
        return this.zzrr;
    }

    protected final void zzbp() {
        zzmd.zzej().zzq(this).zzd(this);
    }

    protected final <MessageType extends zzkk<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzcw() {
        return (BuilderType) zza(zze.zzsb, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.drive.zzlq
    public final int zzcx() {
        if (this.zzrr == -1) {
            this.zzrr = zzmd.zzej().zzq(this).zzn(this);
        }
        return this.zzrr;
    }

    @Override // com.google.android.gms.internal.drive.zzlq
    public final /* synthetic */ zzlr zzcy() {
        zza zzaVar = (zza) zza(zze.zzsb, (Object) null, (Object) null);
        zzaVar.zza(this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.drive.zzlq
    public final /* synthetic */ zzlr zzcz() {
        return (zza) zza(zze.zzsb, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.drive.zzls
    public final /* synthetic */ zzlq zzda() {
        return (zzkk) zza(zze.zzsc, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.drive.zzit
    final void zzo(int i10) {
        this.zzrr = i10;
    }

    public static abstract class zza<MessageType extends zzkk<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zziu<MessageType, BuilderType> {
        private final MessageType zzrt;
        protected MessageType zzru;
        private boolean zzrv = false;

        protected zza(MessageType messagetype) {
            this.zzrt = messagetype;
            this.zzru = (MessageType) messagetype.zza(zze.zzsa, null, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.drive.zziu
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.zzrt.zza(zze.zzsb, null, null);
            zzaVar.zza((zzkk) zzde());
            return zzaVar;
        }

        @Override // com.google.android.gms.internal.drive.zzls
        public final boolean isInitialized() {
            return zzkk.zza(this.zzru, false);
        }

        @Override // com.google.android.gms.internal.drive.zziu
        public final BuilderType zza(MessageType messagetype) {
            zzdb();
            zza(this.zzru, messagetype);
            return this;
        }

        @Override // com.google.android.gms.internal.drive.zziu
        /* JADX INFO: renamed from: zzbn */
        public final /* synthetic */ zziu clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.drive.zzls
        public final /* synthetic */ zzlq zzda() {
            return this.zzrt;
        }

        protected final void zzdb() {
            if (this.zzrv) {
                MessageType messagetype = (MessageType) this.zzru.zza(zze.zzsa, null, null);
                zza(messagetype, this.zzru);
                this.zzru = messagetype;
                this.zzrv = false;
            }
        }

        @Override // com.google.android.gms.internal.drive.zzlr
        /* JADX INFO: renamed from: zzdc, reason: merged with bridge method [inline-methods] */
        public MessageType zzde() {
            if (this.zzrv) {
                return this.zzru;
            }
            this.zzru.zzbp();
            this.zzrv = true;
            return this.zzru;
        }

        @Override // com.google.android.gms.internal.drive.zzlr
        /* JADX INFO: renamed from: zzdd, reason: merged with bridge method [inline-methods] */
        public final MessageType zzdf() {
            MessageType messagetype = (MessageType) zzde();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzmw(messagetype);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzmd.zzej().zzq(messagetype).zzc(messagetype, messagetype2);
        }
    }

    protected static Object zza(zzlq zzlqVar, String str, Object[] objArr) {
        return new zzme(zzlqVar, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    protected static final <T extends zzkk<T, ?>> boolean zza(T t10, boolean z10) {
        byte bByteValue = ((Byte) t10.zza(zze.zzrx, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzp = zzmd.zzej().zzq(t10).zzp(t10);
        if (z10) {
            t10.zza(zze.zzry, zZzp ? t10 : null, null);
        }
        return zZzp;
    }

    private static <T extends zzkk<T, ?>> T zza(T t10, byte[] bArr, int i10, int i11, zzjx zzjxVar) throws zzkq {
        T t11 = (T) t10.zza(zze.zzsa, null, null);
        try {
            zzmd.zzej().zzq(t11).zza(t11, bArr, 0, i11, new zziz(zzjxVar));
            t11.zzbp();
            if (t11.zzne == 0) {
                return t11;
            }
            throw new RuntimeException();
        } catch (IOException e10) {
            if (e10.getCause() instanceof zzkq) {
                throw ((zzkq) e10.getCause());
            }
            throw new zzkq(e10.getMessage()).zzg(t11);
        } catch (IndexOutOfBoundsException unused) {
            throw zzkq.zzdi().zzg(t11);
        }
    }

    protected static <T extends zzkk<T, ?>> T zza(T t10, byte[] bArr, zzjx zzjxVar) throws zzkq {
        T t11 = (T) zza(t10, bArr, 0, bArr.length, zzjxVar);
        if (t11 == null || t11.isInitialized()) {
            return t11;
        }
        throw new zzkq(new zzmw(t11).getMessage()).zzg(t11);
    }
}
