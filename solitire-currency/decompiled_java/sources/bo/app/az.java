package bo.app;

import com.braze.support.ReflectionUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class az extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final az f2406a = new az();

    public az() {
        super(0);
    }

    @Override // h9.a
    public final Object invoke() {
        return Boolean.valueOf(ReflectionUtils.doesMethodExist("com.google.firebase.messaging.FirebaseMessaging", "getToken", new Class[0]));
    }
}
