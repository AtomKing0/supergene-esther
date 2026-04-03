package bo.app;

import com.braze.enums.Month;

/* JADX INFO: loaded from: classes2.dex */
public final class kj extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Month f3257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3258c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kj(int i10, Month month, int i11) {
        super(0);
        this.f3256a = i10;
        this.f3257b = month;
        this.f3258c = i11;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Failed to set date of birth to: " + this.f3256a + '-' + this.f3257b.getValue() + '-' + this.f3258c;
    }
}
