package o2;

import android.media.MediaDrmException;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import l2.t1;
import o2.g0;
import o2.m;

/* JADX INFO: compiled from: DummyExoMediaDrm.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(18)
public final class d0 implements g0 {
    @Override // o2.g0
    public /* synthetic */ void b(byte[] bArr, t1 t1Var) {
        f0.a(this, bArr, t1Var);
    }

    @Override // o2.g0
    public n2.b createCryptoConfig(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // o2.g0
    public int getCryptoType() {
        return 1;
    }

    @Override // o2.g0
    public g0.a getKeyRequest(byte[] bArr, @Nullable List<m.b> list, int i10, @Nullable HashMap<String, String> map) {
        throw new IllegalStateException();
    }

    @Override // o2.g0
    public g0.d getProvisionRequest() {
        throw new IllegalStateException();
    }

    @Override // o2.g0
    public byte[] openSession() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    @Override // o2.g0
    @Nullable
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // o2.g0
    public void provideProvisionResponse(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // o2.g0
    public Map<String, String> queryKeyStatus(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // o2.g0
    public boolean requiresSecureDecoder(byte[] bArr, String str) {
        throw new IllegalStateException();
    }

    @Override // o2.g0
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // o2.g0
    public void release() {
    }

    @Override // o2.g0
    public void a(@Nullable g0.b bVar) {
    }

    @Override // o2.g0
    public void closeSession(byte[] bArr) {
    }
}
