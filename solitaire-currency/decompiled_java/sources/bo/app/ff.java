package bo.app;

import android.app.Activity;

/* JADX INFO: loaded from: classes2.dex */
public final class ff extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f2825a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ff(Activity activity) {
        super(0);
        this.f2825a = activity;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Opened session with activity: " + this.f2825a.getLocalClassName();
    }
}
