package bo.app;

import com.braze.support.ReflectionUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class zy extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zy f4489a = new zy();

    public zy() {
        super(0);
    }

    @Override // h9.a
    public final Object invoke() {
        return Boolean.valueOf(ReflectionUtils.doesMethodExist("com.google.firebase.iid.FirebaseInstanceId", "getToken", String.class, String.class));
    }
}
