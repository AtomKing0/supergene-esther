package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgxs;
import com.google.android.gms.internal.ads.zzgxy;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgxy<MessageType extends zzgxy<MessageType, BuilderType>, BuilderType extends zzgxs<MessageType, BuilderType>> extends zzgvv<MessageType, BuilderType> {
    private static final int zza = Integer.MIN_VALUE;
    private static final int zzb = Integer.MAX_VALUE;
    private static Map<Object, zzgxy<?, ?>> zzc = new ConcurrentHashMap();
    static final int zzr = Integer.MAX_VALUE;
    static final int zzs = 0;
    private int zzd = -1;
    protected zzhat zzt = zzhat.zzc();

    protected static zzgya zzbA() {
        return zzgwc.zzd();
    }

    protected static zzgya zzbB(zzgya zzgyaVar) {
        int size = zzgyaVar.size();
        return zzgyaVar.zzf(size == 0 ? 10 : size + size);
    }

    protected static zzgyb zzbC() {
        return zzgxf.zze();
    }

    protected static zzgyb zzbD(zzgyb zzgybVar) {
        int size = zzgybVar.size();
        return zzgybVar.zzf(size == 0 ? 10 : size + size);
    }

    protected static zzgyf zzbE() {
        return zzgxp.zze();
    }

    protected static zzgyf zzbF(zzgyf zzgyfVar) {
        int size = zzgyfVar.size();
        return zzgyfVar.zzf(size == 0 ? 10 : size + size);
    }

    protected static zzgyg zzbG() {
        return zzgxz.zzg();
    }

    protected static zzgyg zzbH(zzgyg zzgygVar) {
        int size = zzgygVar.size();
        return zzgygVar.zzf(size == 0 ? 10 : size + size);
    }

    protected static zzgyj zzbI() {
        return zzgyy.zzh();
    }

    protected static zzgyj zzbJ(zzgyj zzgyjVar) {
        int size = zzgyjVar.size();
        return zzgyjVar.zzf(size == 0 ? 10 : size + size);
    }

    protected static <E> zzgyk<E> zzbK() {
        return zzgzu.zzd();
    }

    protected static <E> zzgyk<E> zzbL(zzgyk<E> zzgykVar) {
        int size = zzgykVar.size();
        return zzgykVar.zzf(size == 0 ? 10 : size + size);
    }

    static Object zzbR(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e10);
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static Object zzbS(zzgzj zzgzjVar, String str, Object[] objArr) {
        return new zzgzv(zzgzjVar, str, objArr);
    }

    static Method zzbT(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException("Generated message class \"" + cls.getName() + "\" missing method \"" + str + "\".", e10);
        }
    }

    public static <ContainingType extends zzgzj, Type> zzgxw<ContainingType, Type> zzbe(ContainingType containingtype, zzgzj zzgzjVar, zzgyd zzgydVar, int i10, zzhbf zzhbfVar, boolean z10, Class cls) {
        return new zzgxw<>(containingtype, Collections.emptyList(), zzgzjVar, new zzgxv(zzgydVar, i10, zzhbfVar, true, z10), cls);
    }

    public static <ContainingType extends zzgzj, Type> zzgxw<ContainingType, Type> zzbf(ContainingType containingtype, Type type, zzgzj zzgzjVar, zzgyd zzgydVar, int i10, zzhbf zzhbfVar, Class cls) {
        return new zzgxw<>(containingtype, type, zzgzjVar, new zzgxv(zzgydVar, i10, zzhbfVar, false, false), cls);
    }

    static <T extends zzgxy> T zzbh(Class<T> cls) {
        zzgxy<?, ?> zzgxyVarZzbt = zzc.get(cls);
        if (zzgxyVarZzbt == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzgxyVarZzbt = zzc.get(cls);
            } catch (ClassNotFoundException e10) {
                throw new IllegalStateException("Class initialization cannot fail.", e10);
            }
        }
        if (zzgxyVarZzbt == null) {
            zzgxyVarZzbt = ((zzgxy) zzhaz.zzg(cls)).zzbt();
            if (zzgxyVarZzbt == null) {
                throw new IllegalStateException();
            }
            zzc.put(cls, zzgxyVarZzbt);
        }
        return zzgxyVarZzbt;
    }

    protected static <T extends zzgxy<T, ?>> T zzbk(T t10, InputStream inputStream) throws zzgyn {
        int i10 = zzgxi.zzb;
        int i11 = zzgzt.zza;
        T t11 = (T) zzf(t10, inputStream, zzgxi.zza);
        zze(t11);
        return t11;
    }

    protected static <T extends zzgxy<T, ?>> T zzbl(T t10, InputStream inputStream, zzgxi zzgxiVar) throws zzgyn {
        T t11 = (T) zzf(t10, inputStream, zzgxiVar);
        zze(t11);
        return t11;
    }

    protected static <T extends zzgxy<T, ?>> T zzbm(T t10, zzgwm zzgwmVar) throws zzgyn {
        int i10 = zzgxi.zzb;
        int i11 = zzgzt.zza;
        T t11 = (T) zzbr(t10, zzgwmVar, zzgxi.zza);
        zze(t11);
        return t11;
    }

    protected static <T extends zzgxy<T, ?>> T zzbn(T t10, zzgww zzgwwVar) throws zzgyn {
        int i10 = zzgxi.zzb;
        int i11 = zzgzt.zza;
        return (T) zzbs(t10, zzgwwVar, zzgxi.zza);
    }

    protected static <T extends zzgxy<T, ?>> T zzbo(T t10, InputStream inputStream) throws zzgyn {
        zzgww zzgwwVarZzG = zzgww.zzG(inputStream, 4096);
        int i10 = zzgxi.zzb;
        int i11 = zzgzt.zza;
        T t11 = (T) zzbz(t10, zzgwwVarZzG, zzgxi.zza);
        zze(t11);
        return t11;
    }

    protected static <T extends zzgxy<T, ?>> T zzbp(T t10, ByteBuffer byteBuffer) throws zzgyn {
        int i10 = zzgxi.zzb;
        int i11 = zzgzt.zza;
        return (T) zzbv(t10, byteBuffer, zzgxi.zza);
    }

    protected static <T extends zzgxy<T, ?>> T zzbq(T t10, byte[] bArr) throws zzgyn {
        int length = bArr.length;
        int i10 = zzgxi.zzb;
        int i11 = zzgzt.zza;
        T t11 = (T) zzh(t10, bArr, 0, length, zzgxi.zza);
        zze(t11);
        return t11;
    }

    protected static <T extends zzgxy<T, ?>> T zzbr(T t10, zzgwm zzgwmVar, zzgxi zzgxiVar) throws zzgyn {
        T t11 = (T) zzg(t10, zzgwmVar, zzgxiVar);
        zze(t11);
        return t11;
    }

    protected static <T extends zzgxy<T, ?>> T zzbs(T t10, zzgww zzgwwVar, zzgxi zzgxiVar) throws zzgyn {
        T t11 = (T) zzbz(t10, zzgwwVar, zzgxiVar);
        zze(t11);
        return t11;
    }

    protected static <T extends zzgxy<T, ?>> T zzbu(T t10, InputStream inputStream, zzgxi zzgxiVar) throws zzgyn {
        T t11 = (T) zzbz(t10, zzgww.zzG(inputStream, 4096), zzgxiVar);
        zze(t11);
        return t11;
    }

    protected static <T extends zzgxy<T, ?>> T zzbv(T t10, ByteBuffer byteBuffer, zzgxi zzgxiVar) throws zzgyn {
        zzgww zzgwwVarZzH;
        int i10 = zzgww.zzd;
        boolean z10 = false;
        if (byteBuffer.hasArray()) {
            zzgwwVarZzH = zzgww.zzH(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), false);
        } else if (byteBuffer.isDirect() && zzhaz.zzB()) {
            zzgwwVarZzH = new zzgwu(byteBuffer, z10, null);
        } else {
            int iRemaining = byteBuffer.remaining();
            byte[] bArr = new byte[iRemaining];
            byteBuffer.duplicate().get(bArr);
            zzgwwVarZzH = zzgww.zzH(bArr, 0, iRemaining, true);
        }
        T t11 = (T) zzbs(t10, zzgwwVarZzH, zzgxiVar);
        zze(t11);
        return t11;
    }

    protected static <T extends zzgxy<T, ?>> T zzbx(T t10, byte[] bArr, zzgxi zzgxiVar) throws zzgyn {
        T t11 = (T) zzh(t10, bArr, 0, bArr.length, zzgxiVar);
        zze(t11);
        return t11;
    }

    protected static <T extends zzgxy<T, ?>> T zzby(T t10, zzgww zzgwwVar) throws zzgyn {
        int i10 = zzgxi.zzb;
        int i11 = zzgzt.zza;
        return (T) zzbz(t10, zzgwwVar, zzgxi.zza);
    }

    static <T extends zzgxy<T, ?>> T zzbz(T t10, zzgww zzgwwVar, zzgxi zzgxiVar) throws zzgyn {
        T t11 = (T) t10.zzbj();
        try {
            zzhae zzhaeVarZzb = zzgzt.zza().zzb(t11.getClass());
            zzhaeVarZzb.zzh(t11, zzgwx.zzq(zzgwwVar), zzgxiVar);
            zzhaeVarZzb.zzf(t11);
            return t11;
        } catch (zzgyn e10) {
            if (e10.zzk()) {
                throw new zzgyn(e10);
            }
            throw e10;
        } catch (zzhar e11) {
            throw e11.zza();
        } catch (IOException e12) {
            if (e12.getCause() instanceof zzgyn) {
                throw ((zzgyn) e12.getCause());
            }
            throw new zzgyn(e12);
        } catch (RuntimeException e13) {
            if (e13.getCause() instanceof zzgyn) {
                throw ((zzgyn) e13.getCause());
            }
            throw e13;
        }
    }

    private int zzc(zzhae<?> zzhaeVar) {
        if (zzhaeVar != null) {
            return zzhaeVar.zza(this);
        }
        return zzgzt.zza().zzb(getClass()).zza(this);
    }

    protected static <T extends zzgxy> void zzcb(Class<T> cls, T t10) {
        t10.zzbX();
        zzc.put(cls, t10);
    }

    protected static final <T extends zzgxy<T, ?>> boolean zzce(T t10, boolean z10) {
        byte bByteValue = ((Byte) t10.zzbP(zzgxx.GET_MEMOIZED_IS_INITIALIZED)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zZzl = zzgzt.zza().zzb(t10.getClass()).zzl(t10);
        if (z10) {
            t10.zzbQ(zzgxx.SET_MEMOIZED_IS_INITIALIZED, true != zZzl ? null : t10);
        }
        return zZzl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <MessageType extends zzgxu<MessageType, BuilderType>, BuilderType, T> zzgxw<MessageType, T> zzd(zzgxg<MessageType, T> zzgxgVar) {
        return (zzgxw) zzgxgVar;
    }

    private static <T extends zzgxy<T, ?>> T zze(T t10) throws zzgyn {
        if (t10 == null || t10.zzbw()) {
            return t10;
        }
        throw t10.zzaP().zza();
    }

    private static <T extends zzgxy<T, ?>> T zzf(T t10, InputStream inputStream, zzgxi zzgxiVar) throws zzgyn {
        try {
            int i10 = inputStream.read();
            if (i10 == -1) {
                return null;
            }
            zzgww zzgwwVarZzG = zzgww.zzG(new zzgvt(inputStream, zzgww.zzE(i10, inputStream)), 4096);
            T t11 = (T) zzbz(t10, zzgwwVarZzG, zzgxiVar);
            try {
                zzgwwVarZzG.zzy(0);
                return t11;
            } catch (zzgyn e10) {
                throw e10;
            }
        } catch (zzgyn e11) {
            if (e11.zzk()) {
                throw new zzgyn(e11);
            }
            throw e11;
        } catch (IOException e12) {
            throw new zzgyn(e12);
        }
    }

    private static <T extends zzgxy<T, ?>> T zzg(T t10, zzgwm zzgwmVar, zzgxi zzgxiVar) throws zzgyn {
        zzgww zzgwwVarZzl = zzgwmVar.zzl();
        T t11 = (T) zzbz(t10, zzgwwVarZzl, zzgxiVar);
        try {
            zzgwwVarZzl.zzy(0);
            return t11;
        } catch (zzgyn e10) {
            throw e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends zzgxy<T, ?>> T zzh(T t10, byte[] bArr, int i10, int i11, zzgxi zzgxiVar) throws zzgyn {
        if (i11 == 0) {
            return t10;
        }
        T t11 = (T) t10.zzbj();
        try {
            zzhae zzhaeVarZzb = zzgzt.zza().zzb(t11.getClass());
            zzhaeVarZzb.zzi(t11, bArr, i10, i10 + i11, new zzgwa(zzgxiVar));
            zzhaeVarZzb.zzf(t11);
            return t11;
        } catch (zzgyn e10) {
            if (e10.zzk()) {
                throw new zzgyn(e10);
            }
            throw e10;
        } catch (zzhar e11) {
            throw e11.zza();
        } catch (IOException e12) {
            if (e12.getCause() instanceof zzgyn) {
                throw ((zzgyn) e12.getCause());
            }
            throw new zzgyn(e12);
        } catch (IndexOutOfBoundsException unused) {
            throw zzgyn.zzi();
        }
    }

    private void zzi() {
        if (this.zzt == zzhat.zzc()) {
            this.zzt = zzhat.zzf();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return zzgzt.zza().zzb(getClass()).zzk(this, (zzgxy) obj);
    }

    public int hashCode() {
        if (zzcf()) {
            return zzaW();
        }
        if (zzcd()) {
            zzcc(zzaW());
        }
        return zzaX();
    }

    public String toString() {
        return zzgzl.zza(this, super.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzgvv
    int zzaL() {
        return this.zzd & Integer.MAX_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzgvv
    int zzaM(zzhae zzhaeVar) {
        if (!zzcf()) {
            if (zzaL() != Integer.MAX_VALUE) {
                return zzaL();
            }
            int iZzc = zzc(zzhaeVar);
            zzaS(iZzc);
            return iZzc;
        }
        int iZzc2 = zzc(zzhaeVar);
        if (iZzc2 >= 0) {
            return iZzc2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iZzc2);
    }

    @Override // com.google.android.gms.internal.ads.zzgvv
    public zzgzo zzaO() {
        throw new UnsupportedOperationException("Lite does not support the mutable API.");
    }

    @Override // com.google.android.gms.internal.ads.zzgvv
    void zzaS(int i10) {
        if (i10 >= 0) {
            this.zzd = i10 | (this.zzd & Integer.MIN_VALUE);
            return;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + i10);
    }

    int zzaW() {
        return zzgzt.zza().zzb(getClass()).zzb(this);
    }

    int zzaX() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzgzj
    public int zzaY() {
        return zzaM(null);
    }

    protected final <MessageType extends zzgxy<MessageType, BuilderType>, BuilderType extends zzgxs<MessageType, BuilderType>> BuilderType zzaZ() {
        return (BuilderType) zzbP(zzgxx.NEW_BUILDER);
    }

    public final zzgzr<MessageType> zzbN() {
        return (zzgzr) zzbP(zzgxx.GET_PARSER);
    }

    Object zzbO() throws Exception {
        return zzbP(zzgxx.BUILD_MESSAGE_INFO);
    }

    protected Object zzbP(zzgxx zzgxxVar) {
        return zzde(zzgxxVar, null, null);
    }

    protected Object zzbQ(zzgxx zzgxxVar, Object obj) {
        return zzde(zzgxxVar, obj, null);
    }

    void zzbU() {
        this.zzq = 0;
    }

    void zzbV() {
        zzaS(Integer.MAX_VALUE);
    }

    protected void zzbW() {
        zzgzt.zza().zzb(getClass()).zzf(this);
        zzbX();
    }

    void zzbX() {
        this.zzd &= Integer.MAX_VALUE;
    }

    protected void zzbY(int i10, zzgwm zzgwmVar) {
        zzi();
        zzhat zzhatVar = this.zzt;
        zzhatVar.zzg();
        if (i10 == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        zzhatVar.zzj((i10 << 3) | 2, zzgwmVar);
    }

    protected final void zzbZ(zzhat zzhatVar) {
        this.zzt = zzhat.zze(this.zzt, zzhatVar);
    }

    protected final <MessageType extends zzgxy<MessageType, BuilderType>, BuilderType extends zzgxs<MessageType, BuilderType>> BuilderType zzba(MessageType messagetype) {
        BuilderType buildertype = (BuilderType) zzaZ();
        buildertype.zzbj(messagetype);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.ads.zzgzj
    /* JADX INFO: renamed from: zzbb, reason: merged with bridge method [inline-methods] */
    public final BuilderType zzcZ() {
        return (BuilderType) zzbP(zzgxx.NEW_BUILDER);
    }

    /* JADX INFO: renamed from: zzbc, reason: merged with bridge method [inline-methods] */
    public final BuilderType zzbM() {
        BuilderType buildertype = (BuilderType) zzbP(zzgxx.NEW_BUILDER);
        buildertype.zzbj(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.ads.zzgzk
    /* JADX INFO: renamed from: zzbi, reason: merged with bridge method [inline-methods] */
    public final MessageType zzbt() {
        return (MessageType) zzbP(zzgxx.GET_DEFAULT_INSTANCE);
    }

    MessageType zzbj() {
        return (MessageType) zzbP(zzgxx.NEW_MUTABLE_INSTANCE);
    }

    @Override // com.google.android.gms.internal.ads.zzgzk
    public final boolean zzbw() {
        return zzce(this, true);
    }

    protected void zzca(int i10, int i11) {
        zzi();
        zzhat zzhatVar = this.zzt;
        zzhatVar.zzg();
        if (i10 == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        zzhatVar.zzj(i10 << 3, Long.valueOf(i11));
    }

    void zzcc(int i10) {
        this.zzq = i10;
    }

    boolean zzcd() {
        return zzaX() == 0;
    }

    boolean zzcf() {
        return (this.zzd & Integer.MIN_VALUE) != 0;
    }

    protected boolean zzcg(int i10, zzgww zzgwwVar) throws IOException {
        if ((i10 & 7) == 4) {
            return false;
        }
        zzi();
        return this.zzt.zzm(i10, zzgwwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgzj
    public void zzda(zzgxd zzgxdVar) throws IOException {
        zzgzt.zza().zzb(getClass()).zzj(this, zzgxe.zza(zzgxdVar));
    }

    protected abstract Object zzde(zzgxx zzgxxVar, Object obj, Object obj2);
}
