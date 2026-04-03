package bo.app;

import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public final class a60 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a60 f2354a = new a60();

    public a60() {
        super(0);
    }

    @Override // h9.a
    public final Object invoke() {
        return "Device API version of " + Build.VERSION.SDK_INT + " is too low to display push permission prompt.";
    }
}
