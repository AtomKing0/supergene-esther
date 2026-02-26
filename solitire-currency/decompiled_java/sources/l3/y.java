package l3;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: MediaPeriodId.java */
/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f30778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f30779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f30780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f30781d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f30782e;

    public y(Object obj) {
        this(obj, -1L);
    }

    public y a(Object obj) {
        return this.f30778a.equals(obj) ? this : new y(obj, this.f30779b, this.f30780c, this.f30781d, this.f30782e);
    }

    public boolean b() {
        return this.f30779b != -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return this.f30778a.equals(yVar.f30778a) && this.f30779b == yVar.f30779b && this.f30780c == yVar.f30780c && this.f30781d == yVar.f30781d && this.f30782e == yVar.f30782e;
    }

    public int hashCode() {
        return ((((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.f30778a.hashCode()) * 31) + this.f30779b) * 31) + this.f30780c) * 31) + ((int) this.f30781d)) * 31) + this.f30782e;
    }

    public y(Object obj, long j10) {
        this(obj, -1, -1, j10, -1);
    }

    public y(Object obj, long j10, int i10) {
        this(obj, -1, -1, j10, i10);
    }

    public y(Object obj, int i10, int i11, long j10) {
        this(obj, i10, i11, j10, -1);
    }

    protected y(y yVar) {
        this.f30778a = yVar.f30778a;
        this.f30779b = yVar.f30779b;
        this.f30780c = yVar.f30780c;
        this.f30781d = yVar.f30781d;
        this.f30782e = yVar.f30782e;
    }

    private y(Object obj, int i10, int i11, long j10, int i12) {
        this.f30778a = obj;
        this.f30779b = i10;
        this.f30780c = i11;
        this.f30781d = j10;
        this.f30782e = i12;
    }
}
