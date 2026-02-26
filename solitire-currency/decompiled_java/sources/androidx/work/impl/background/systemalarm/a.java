package androidx.work.impl.background.systemalarm;

/* JADX INFO: compiled from: R8$$SyntheticClass */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DelayMetCommandHandler f1764a;

    public /* synthetic */ a(DelayMetCommandHandler delayMetCommandHandler) {
        this.f1764a = delayMetCommandHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1764a.stopWork();
    }
}
