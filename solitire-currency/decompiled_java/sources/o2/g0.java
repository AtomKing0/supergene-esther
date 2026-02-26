package o2;

import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import l2.t1;
import o2.m;

/* JADX INFO: compiled from: ExoMediaDrm.java */
/* JADX INFO: loaded from: classes2.dex */
public interface g0 {

    /* JADX INFO: compiled from: ExoMediaDrm.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f31846a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f31847b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f31848c;

        public a(byte[] bArr, String str, int i10) {
            this.f31846a = bArr;
            this.f31847b = str;
            this.f31848c = i10;
        }

        public byte[] a() {
            return this.f31846a;
        }

        public String b() {
            return this.f31847b;
        }
    }

    /* JADX INFO: compiled from: ExoMediaDrm.java */
    public interface b {
        void a(g0 g0Var, @Nullable byte[] bArr, int i10, int i11, @Nullable byte[] bArr2);
    }

    /* JADX INFO: compiled from: ExoMediaDrm.java */
    public interface c {
        g0 acquireExoMediaDrm(UUID uuid);
    }

    /* JADX INFO: compiled from: ExoMediaDrm.java */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f31849a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f31850b;

        public d(byte[] bArr, String str) {
            this.f31849a = bArr;
            this.f31850b = str;
        }

        public byte[] a() {
            return this.f31849a;
        }

        public String b() {
            return this.f31850b;
        }
    }

    void a(@Nullable b bVar);

    void b(byte[] bArr, t1 t1Var);

    void closeSession(byte[] bArr);

    n2.b createCryptoConfig(byte[] bArr) throws MediaCryptoException;

    int getCryptoType();

    a getKeyRequest(byte[] bArr, @Nullable List<m.b> list, int i10, @Nullable HashMap<String, String> map) throws NotProvisionedException;

    d getProvisionRequest();

    byte[] openSession() throws MediaDrmException;

    @Nullable
    byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException;

    void provideProvisionResponse(byte[] bArr) throws DeniedByServerException;

    Map<String, String> queryKeyStatus(byte[] bArr);

    void release();

    boolean requiresSecureDecoder(byte[] bArr, String str);

    void restoreKeys(byte[] bArr, byte[] bArr2);
}
