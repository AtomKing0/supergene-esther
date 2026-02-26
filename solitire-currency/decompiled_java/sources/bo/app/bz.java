package bo.app;

import com.google.android.gms.tasks.Task;

/* JADX INFO: loaded from: classes2.dex */
public final class bz extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Task f2476a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz(Task task) {
        super(0);
        this.f2476a = task;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Fetching registration token failed using FirebaseMessaging instance with default Firebase installation with exception " + this.f2476a.getException();
    }
}
