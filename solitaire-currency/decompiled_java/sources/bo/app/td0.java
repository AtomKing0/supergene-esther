package bo.app;

import java.io.File;

/* JADX INFO: loaded from: classes2.dex */
public final class td0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ File[] f3915a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public td0(File[] fileArr) {
        super(0);
        this.f3915a = fileArr;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Local triggered asset directory contains files: " + kotlin.collections.p.d0(this.f3915a, " , ", null, null, 0, null, sd0.f3850a, 30, null);
    }
}
