package bo.app;

import android.app.Activity;

/* JADX INFO: loaded from: classes2.dex */
public final class me extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f3413a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public me(Activity activity) {
        super(0);
        this.f3413a = activity;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Closed session with activity: " + this.f3413a.getLocalClassName();
    }
}
