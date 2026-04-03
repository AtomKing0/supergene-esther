package androidx.work.impl.background.systemalarm;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DelayMetCommandHandler f1765a;

    public /* synthetic */ b(DelayMetCommandHandler delayMetCommandHandler) {
        this.f1765a = delayMetCommandHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1765a.startWork();
    }
}
