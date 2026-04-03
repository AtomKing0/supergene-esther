package bo.app;

import com.braze.support.DateTimeUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class sg0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f3857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a10 f3858b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public sg0(long j10, k70 k70Var) {
        super(0);
        this.f3857a = j10;
        this.f3858b = k70Var;
    }

    @Override // h9.a
    public final Object invoke() {
        StringBuilder sb = new StringBuilder("Trigger action is not re-eligible for display since only ");
        sb.append(DateTimeUtils.nowInSeconds() - this.f3857a);
        sb.append(" seconds have passed since the last time it was triggered (minimum interval: ");
        int i10 = ((k70) this.f3858b).f3223a;
        sb.append(i10 > 0 ? Integer.valueOf(i10) : null);
        sb.append(").");
        return sb.toString();
    }
}
