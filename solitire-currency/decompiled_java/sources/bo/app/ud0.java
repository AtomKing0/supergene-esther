package bo.app;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class ud0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ File f4010a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ud0(File file) {
        super(0);
        this.f4010a = file;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Deleting obsolete asset '" + this.f4010a.getPath() + "' from filesystem.";
    }
}
