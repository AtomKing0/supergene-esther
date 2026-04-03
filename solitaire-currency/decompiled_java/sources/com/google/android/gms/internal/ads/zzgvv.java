package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgvu;
import com.google.android.gms.internal.ads.zzgvv;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zzgvv<MessageType extends zzgvv<MessageType, BuilderType>, BuilderType extends zzgvu<MessageType, BuilderType>> implements zzgzj {
    protected int zzq = 0;

    protected static <T> void zzaQ(Iterable<T> iterable, List<? super T> list) {
        zzgvu.zzbd(iterable, list);
    }

    protected static void zzaR(zzgwm zzgwmVar) throws IllegalArgumentException {
        if (!zzgwmVar.zzp()) {
            throw new IllegalArgumentException("Byte string is not UTF-8.");
        }
    }

    private String zzdI(String str) {
        return "Serializing " + getClass().getName() + " to a " + str + " threw an IOException (should never happen).";
    }

    int zzaL() {
        throw new UnsupportedOperationException();
    }

    int zzaM(zzhae zzhaeVar) {
        return zzaL();
    }

    @Override // com.google.android.gms.internal.ads.zzgzj
    public zzgwm zzaN() {
        try {
            int iZzaY = zzaY();
            zzgwm zzgwmVar = zzgwm.zzb;
            byte[] bArr = new byte[iZzaY];
            zzgxd zzgxdVarZzF = zzgxd.zzF(bArr, 0, iZzaY);
            zzda(zzgxdVarZzF);
            zzgxdVarZzF.zzG();
            return new zzgwk(bArr);
        } catch (IOException e10) {
            throw new RuntimeException(zzdI("ByteString"), e10);
        }
    }

    public zzgzo zzaO() {
        throw new UnsupportedOperationException("mutableCopy() is not implemented.");
    }

    zzhar zzaP() {
        return new zzhar(this);
    }

    void zzaS(int i10) {
        throw new UnsupportedOperationException();
    }

    public void zzaT(OutputStream outputStream) throws IOException {
        int iZzaY = zzaY();
        zzgxb zzgxbVar = new zzgxb(outputStream, zzgxd.zzB(zzgxd.zzD(iZzaY) + iZzaY));
        zzgxbVar.zzu(iZzaY);
        zzda(zzgxbVar);
        zzgxbVar.zzL();
    }

    public void zzaU(OutputStream outputStream) throws IOException {
        zzgxb zzgxbVar = new zzgxb(outputStream, zzgxd.zzB(zzaY()));
        zzda(zzgxbVar);
        zzgxbVar.zzL();
    }

    public byte[] zzaV() {
        try {
            int iZzaY = zzaY();
            byte[] bArr = new byte[iZzaY];
            zzgxd zzgxdVarZzF = zzgxd.zzF(bArr, 0, iZzaY);
            zzda(zzgxdVarZzF);
            zzgxdVarZzF.zzG();
            return bArr;
        } catch (IOException e10) {
            throw new RuntimeException(zzdI("byte array"), e10);
        }
    }
}
