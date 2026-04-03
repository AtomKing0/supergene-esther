package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjt;
import com.google.android.gms.internal.measurement.zzjt.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzjt<MessageType extends zzjt<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzhz<MessageType, BuilderType> {
    private static Map<Object, zzjt<?, ?>> zzc = new ConcurrentHashMap();
    private int zzd = -1;
    protected zzmw zzb = zzmw.zzc();

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
    public static abstract class zza<MessageType extends zzjt<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzhy<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;

        protected zza(MessageType messagetype) {
            this.zzb = messagetype;
            if (messagetype.zzch()) {
                throw new IllegalArgumentException("Default instance must be immutable.");
            }
            this.zza = (MessageType) messagetype.zzbz();
        }

        private final BuilderType zzb(byte[] bArr, int i10, int i11, zzjg zzjgVar) throws zzkb {
            if (!this.zza.zzch()) {
                zzal();
            }
            try {
                zzlu.zza().zza(this.zza).zza(this.zza, bArr, 0, i11, new zzie(zzjgVar));
                return this;
            } catch (zzkb e10) {
                throw e10;
            } catch (IOException e11) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e11);
            } catch (IndexOutOfBoundsException unused) {
                throw zzkb.zzh();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.internal.measurement.zzhy
        /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
        public final BuilderType zzb(zziu zziuVar, zzjg zzjgVar) throws IOException {
            if (!this.zza.zzch()) {
                zzal();
            }
            try {
                zzlu.zza().zza(this.zza).zza(this.zza, zziy.zza(zziuVar), zzjgVar);
                return this;
            } catch (RuntimeException e10) {
                if (e10.getCause() instanceof IOException) {
                    throw ((IOException) e10.getCause());
                }
                throw e10;
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.zzb.zza(zzf.zze, null, null);
            zzaVar.zza = (MessageType) zzai();
            return zzaVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzli
        public final boolean i_() {
            return zzjt.zza(this.zza, false);
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        /* JADX INFO: renamed from: zza */
        public final /* synthetic */ zzhy zzb(zziu zziuVar, zzjg zzjgVar) throws IOException {
            return (zza) zzb(zziuVar, zzjgVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        /* JADX INFO: renamed from: zzae */
        public final /* synthetic */ zzhy clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.measurement.zzlf
        /* JADX INFO: renamed from: zzaf, reason: merged with bridge method [inline-methods] */
        public final MessageType zzah() {
            MessageType messagetype = (MessageType) zzai();
            if (messagetype.i_()) {
                return messagetype;
            }
            throw new zzmu(messagetype);
        }

        @Override // com.google.android.gms.internal.measurement.zzlf
        /* JADX INFO: renamed from: zzag, reason: merged with bridge method [inline-methods] */
        public MessageType zzai() {
            if (!this.zza.zzch()) {
                return this.zza;
            }
            this.zza.zzcf();
            return this.zza;
        }

        @Override // com.google.android.gms.internal.measurement.zzli
        public final /* synthetic */ zzlg zzaj() {
            return this.zzb;
        }

        protected final void zzak() {
            if (this.zza.zzch()) {
                return;
            }
            zzal();
        }

        protected void zzal() {
            MessageType messagetype = (MessageType) this.zzb.zzbz();
            zza(messagetype, this.zza);
            this.zza = messagetype;
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        public final /* synthetic */ zzhy zza(byte[] bArr, int i10, int i11) throws zzkb {
            return zzb(bArr, 0, i11, zzjg.zza);
        }

        @Override // com.google.android.gms.internal.measurement.zzhy
        public final /* synthetic */ zzhy zza(byte[] bArr, int i10, int i11, zzjg zzjgVar) throws zzkb {
            return zzb(bArr, 0, i11, zzjgVar);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzb.equals(messagetype)) {
                return this;
            }
            if (!this.zza.zzch()) {
                zzal();
            }
            zza(this.zza, messagetype);
            return this;
        }

        private static <MessageType> void zza(MessageType messagetype, MessageType messagetype2) {
            zzlu.zza().zza(messagetype).zza(messagetype, messagetype2);
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzjt<MessageType, BuilderType> implements zzli {
        protected zzjj<zze> zzc = zzjj.zzb();

        final zzjj<zze> zza() {
            if (this.zzc.zzf()) {
                this.zzc = (zzjj) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
    protected static class zzc<T extends zzjt<T, ?>> extends zzia<T> {
        private final T zza;

        public zzc(T t10) {
            this.zza = t10;
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
    public static class zzd<ContainingType extends zzlg, Type> extends zzje<ContainingType, Type> {
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
    static final class zze implements zzjl<zze> {
        @Override // java.lang.Comparable
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjl
        public final int zza() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjl
        public final zzng zzb() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjl
        public final zznq zzc() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjl
        public final boolean zzd() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjl
        public final boolean zze() {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjl
        public final zzlf zza(zzlf zzlfVar, zzlg zzlgVar) {
            throw new NoSuchMethodError();
        }

        @Override // com.google.android.gms.internal.measurement.zzjl
        public final zzll zza(zzll zzllVar, zzll zzllVar2) {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@21.6.1 */
    public enum zzf {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        private static final /* synthetic */ int[] zzh = {1, 2, 3, 4, 5, 6, 7};

        public static int[] zza() {
            return (int[]) zzh.clone();
        }
    }

    private final int zza() {
        return zzlu.zza().zza(this).zzb(this);
    }

    private final int zzb(zzly<?> zzlyVar) {
        return zzlyVar == null ? zzlu.zza().zza(this).zza(this) : zzlyVar.zza(this);
    }

    protected static zzka zzca() {
        return zzju.zzd();
    }

    protected static zzjz zzcb() {
        return zzkr.zzd();
    }

    protected static <E> zzkc<E> zzcc() {
        return zzlt.zzd();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzlu.zza().zza(this).zzb(this, (zzjt) obj);
        }
        return false;
    }

    public int hashCode() {
        if (zzch()) {
            return zza();
        }
        if (this.zza == 0) {
            this.zza = zza();
        }
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzli
    public final boolean i_() {
        return zza(this, true);
    }

    public String toString() {
        return zzlh.zza(this, super.toString());
    }

    protected abstract Object zza(int i10, Object obj, Object obj2);

    @Override // com.google.android.gms.internal.measurement.zzli
    public final /* synthetic */ zzlg zzaj() {
        return (zzjt) zza(zzf.zzf, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzhz
    final int zzbt() {
        return this.zzd & Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final int zzbw() {
        return zza((zzly) null);
    }

    protected final <MessageType extends zzjt<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzbx() {
        return (BuilderType) zza(zzf.zze, (Object) null, (Object) null);
    }

    public final BuilderType zzby() {
        return (BuilderType) ((zza) zza(zzf.zze, (Object) null, (Object) null)).zza(this);
    }

    final MessageType zzbz() {
        return (MessageType) zza(zzf.zzd, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzhz
    final void zzc(int i10) {
        if (i10 >= 0) {
            this.zzd = (i10 & Integer.MAX_VALUE) | (this.zzd & Integer.MIN_VALUE);
        } else {
            throw new IllegalStateException("serialized size must be non-negative, was " + i10);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final /* synthetic */ zzlf zzcd() {
        return (zza) zza(zzf.zze, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final /* synthetic */ zzlf zzce() {
        return ((zza) zza(zzf.zze, (Object) null, (Object) null)).zza(this);
    }

    protected final void zzcf() {
        zzlu.zza().zza(this).zzc(this);
        zzcg();
    }

    final void zzcg() {
        this.zzd &= Integer.MAX_VALUE;
    }

    final boolean zzch() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzhz
    final int zza(zzly zzlyVar) {
        if (!zzch()) {
            if (zzbt() != Integer.MAX_VALUE) {
                return zzbt();
            }
            int iZzb = zzb(zzlyVar);
            zzc(iZzb);
            return iZzb;
        }
        int iZzb2 = zzb(zzlyVar);
        if (iZzb2 >= 0) {
            return iZzb2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZzb2);
    }

    static <T extends zzjt<?, ?>> T zza(Class<T> cls) {
        zzjt<?, ?> zzjtVar = zzc.get(cls);
        if (zzjtVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzjtVar = zzc.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (zzjtVar == null) {
            zzjtVar = (T) ((zzjt) zzmz.zza(cls)).zza(zzf.zzf, (Object) null, (Object) null);
            if (zzjtVar != null) {
                zzc.put(cls, zzjtVar);
            } else {
                throw new IllegalStateException();
            }
        }
        return (T) zzjtVar;
    }

    protected static zzjz zza(zzjz zzjzVar) {
        int size = zzjzVar.size();
        return zzjzVar.zza(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzkc<E> zza(zzkc<E> zzkcVar) {
        int size = zzkcVar.size();
        return zzkcVar.zza(size == 0 ? 10 : size << 1);
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

    protected static Object zza(zzlg zzlgVar, String str, Object[] objArr) {
        return new zzlw(zzlgVar, str, objArr);
    }

    protected static <T extends zzjt<?, ?>> void zza(Class<T> cls, T t10) {
        t10.zzcg();
        zzc.put(cls, t10);
    }

    @Override // com.google.android.gms.internal.measurement.zzlg
    public final void zza(zzja zzjaVar) throws IOException {
        zzlu.zza().zza(this).zza(this, zzjc.zza(zzjaVar));
    }

    protected static final <T extends zzjt<T, ?>> boolean zza(T t10, boolean z10) {
        byte bByteValue = ((Byte) t10.zza(zzf.zza, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzd = zzlu.zza().zza(t10).zzd(t10);
        if (z10) {
            t10.zza(zzf.zzb, zZzd ? t10 : null, null);
        }
        return zZzd;
    }
}
