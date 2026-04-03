package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class j50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f3123b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f3124c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i50 f3125d;

    public /* synthetic */ j50() {
        this(null, null, null, null);
    }

    public final j50 a(String str) {
        this.f3122a = str;
        return this;
    }

    public j50(String str, Boolean bool, Boolean bool2, i50 i50Var) {
        this.f3122a = str;
        this.f3123b = bool;
        this.f3124c = bool2;
        this.f3125d = i50Var;
    }

    public final k50 a() {
        return new k50(this.f3122a, this.f3123b, this.f3124c, this.f3125d);
    }
}
