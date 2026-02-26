package o2;

import androidx.annotation.Nullable;
import java.util.Map;
import java.util.UUID;
import o2.o;
import o2.w;

/* JADX INFO: compiled from: ErrorStateDrmSession.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e0 implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o.a f31813a;

    public e0(o.a aVar) {
        this.f31813a = (o.a) a4.a.e(aVar);
    }

    @Override // o2.o
    @Nullable
    public n2.b getCryptoConfig() {
        return null;
    }

    @Override // o2.o
    @Nullable
    public o.a getError() {
        return this.f31813a;
    }

    @Override // o2.o
    public final UUID getSchemeUuid() {
        return k2.i.f29126a;
    }

    @Override // o2.o
    public int getState() {
        return 1;
    }

    @Override // o2.o
    public boolean playClearSamplesWithoutKeys() {
        return false;
    }

    @Override // o2.o
    @Nullable
    public Map<String, String> queryKeyStatus() {
        return null;
    }

    @Override // o2.o
    public boolean requiresSecureDecoder(String str) {
        return false;
    }

    @Override // o2.o
    public void a(@Nullable w.a aVar) {
    }

    @Override // o2.o
    public void b(@Nullable w.a aVar) {
    }
}
