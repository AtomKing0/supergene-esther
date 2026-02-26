package bo.app;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public final class ka0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f3236a;

    public ka0(Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        this.f3236a = new q(context);
    }

    public final boolean a() {
        return this.f3236a.getBoolean("appboy_sdk_disabled", false);
    }
}
