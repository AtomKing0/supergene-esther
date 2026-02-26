package n3;

import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: SubtitleOutputBuffer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class o extends n2.h implements i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private i f31684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f31685e;

    @Override // n2.a
    public void c() {
        super.c();
        this.f31684d = null;
    }

    @Override // n3.i
    public List<b> getCues(long j10) {
        return ((i) a4.a.e(this.f31684d)).getCues(j10 - this.f31685e);
    }

    @Override // n3.i
    public long getEventTime(int i10) {
        return ((i) a4.a.e(this.f31684d)).getEventTime(i10) + this.f31685e;
    }

    @Override // n3.i
    public int getEventTimeCount() {
        return ((i) a4.a.e(this.f31684d)).getEventTimeCount();
    }

    @Override // n3.i
    public int getNextEventTimeIndex(long j10) {
        return ((i) a4.a.e(this.f31684d)).getNextEventTimeIndex(j10 - this.f31685e);
    }

    public void m(long j10, i iVar, long j11) {
        this.f31594b = j10;
        this.f31684d = iVar;
        if (j11 != Long.MAX_VALUE) {
            j10 = j11;
        }
        this.f31685e = j10;
    }
}
