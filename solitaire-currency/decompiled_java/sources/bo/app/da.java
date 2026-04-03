package bo.app;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class da extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ File f2636a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public da(File file) {
        super(0);
        this.f2636a = file;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Could not recursively delete " + this.f2636a.getName();
    }
}
