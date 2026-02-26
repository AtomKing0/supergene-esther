package bo.app;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class bj0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ File f2461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2462b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bj0(File file, String str) {
        super(0);
        this.f2461a = file;
        this.f2462b = str;
    }

    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("Error during unpack of zip file ");
        sb.append(this.f2461a.getAbsolutePath());
        sb.append(" to ");
        return h1.a(sb, this.f2462b, '.');
    }
}
