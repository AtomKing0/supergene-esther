package b7;

/* JADX INFO: compiled from: SignalCallbackListener.java */
/* JADX INFO: loaded from: classes4.dex */
public class d<T> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.unity3d.scar.adapter.common.a f2223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private g<T> f2224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f2225c;

    public d(com.unity3d.scar.adapter.common.a aVar, f fVar) {
        this(aVar, null, fVar);
    }

    @Override // b7.a
    public void a(String str, String str2, T t10) {
        this.f2225c.a(str, str2);
        g<T> gVar = this.f2224b;
        if (gVar != null) {
            gVar.b(str, t10);
        }
        this.f2223a.b();
    }

    @Override // b7.a
    public void onFailure(String str) {
        this.f2225c.d(str);
        this.f2223a.b();
    }

    public d(com.unity3d.scar.adapter.common.a aVar, g<T> gVar, f fVar) {
        this.f2223a = aVar;
        this.f2224b = gVar;
        this.f2225c = fVar;
    }
}
