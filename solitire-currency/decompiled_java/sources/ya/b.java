package ya;

/* JADX INFO: compiled from: Level.java */
/* JADX INFO: loaded from: classes5.dex */
public enum b {
    ERROR(40, "ERROR"),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f36943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f36944b;

    b(int i10, String str) {
        this.f36943a = i10;
        this.f36944b = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f36944b;
    }
}
