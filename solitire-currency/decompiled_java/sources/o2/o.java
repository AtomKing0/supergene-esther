package o2;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import o2.w;

/* JADX INFO: compiled from: DrmSession.java */
/* JADX INFO: loaded from: classes2.dex */
public interface o {

    /* JADX INFO: compiled from: DrmSession.java */
    public static class a extends IOException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31924a;

        public a(Throwable th, int i10) {
            super(th);
            this.f31924a = i10;
        }
    }

    void a(@Nullable w.a aVar);

    void b(@Nullable w.a aVar);

    @Nullable
    n2.b getCryptoConfig();

    @Nullable
    a getError();

    UUID getSchemeUuid();

    int getState();

    boolean playClearSamplesWithoutKeys();

    @Nullable
    Map<String, String> queryKeyStatus();

    boolean requiresSecureDecoder(String str);
}
