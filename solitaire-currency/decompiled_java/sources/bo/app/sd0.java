package bo.app;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class sd0 extends kotlin.jvm.internal.v implements h9.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final sd0 f3850a = new sd0();

    public sd0() {
        super(1);
    }

    @Override // h9.l
    public final Object invoke(Object obj) {
        String name = ((File) obj).getName();
        kotlin.jvm.internal.t.h(name, "it.name");
        return name;
    }
}
