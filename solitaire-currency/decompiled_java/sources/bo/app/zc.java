package bo.app;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class zc extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ File f4425a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zc(File file) {
        super(0);
        this.f4425a = file;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Retrieving image from local path: " + this.f4425a.getAbsolutePath();
    }
}
