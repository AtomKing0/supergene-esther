package v7;

import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: HttpClientEngineBase.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a extends IllegalStateException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final Throwable f35128a;

    public /* synthetic */ a(Throwable th, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : th);
    }

    @Override // java.lang.Throwable
    @Nullable
    public Throwable getCause() {
        return this.f35128a;
    }

    public a(@Nullable Throwable th) {
        super("Client already closed");
        this.f35128a = th;
    }
}
