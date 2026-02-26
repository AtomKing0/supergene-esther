package io.ktor.utils.io;

/* JADX INFO: compiled from: ByteBufferChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Void b(Throwable th) throws Throwable {
        Throwable thE;
        try {
            thE = r.e(th, th);
        } catch (Throwable unused) {
            thE = null;
        }
        if (thE == null) {
            throw th;
        }
        throw thE;
    }
}
