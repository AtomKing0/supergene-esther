package u0;

/* JADX INFO: compiled from: CallbackException.java */
/* JADX INFO: loaded from: classes2.dex */
final class b extends RuntimeException {
    b(Throwable th) {
        super("Unexpected exception thrown by non-Glide code", th);
    }
}
