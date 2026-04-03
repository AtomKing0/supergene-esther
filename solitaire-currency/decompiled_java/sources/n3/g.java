package n3;

import androidx.annotation.Nullable;
import com.google.common.collect.y;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/* JADX INFO: compiled from: ExoplayerCuesDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f31661a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f31662b = new n();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Deque<o> f31663c = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f31664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f31665e;

    /* JADX INFO: compiled from: ExoplayerCuesDecoder.java */
    class a extends o {
        a() {
        }

        @Override // n2.h
        public void l() {
            g.this.e(this);
        }
    }

    /* JADX INFO: compiled from: ExoplayerCuesDecoder.java */
    private static final class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f31667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final y<n3.b> f31668b;

        public b(long j10, y<n3.b> yVar) {
            this.f31667a = j10;
            this.f31668b = yVar;
        }

        @Override // n3.i
        public List<n3.b> getCues(long j10) {
            return j10 >= this.f31667a ? this.f31668b : y.q();
        }

        @Override // n3.i
        public long getEventTime(int i10) {
            a4.a.a(i10 == 0);
            return this.f31667a;
        }

        @Override // n3.i
        public int getEventTimeCount() {
            return 1;
        }

        @Override // n3.i
        public int getNextEventTimeIndex(long j10) {
            return this.f31667a > j10 ? 0 : -1;
        }
    }

    public g() {
        for (int i10 = 0; i10 < 2; i10++) {
            this.f31663c.addFirst(new a());
        }
        this.f31664d = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(o oVar) {
        a4.a.g(this.f31663c.size() < 2);
        a4.a.a(!this.f31663c.contains(oVar));
        oVar.c();
        this.f31663c.addFirst(oVar);
    }

    @Override // n2.d
    @Nullable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public n dequeueInputBuffer() throws k {
        a4.a.g(!this.f31665e);
        if (this.f31664d != 0) {
            return null;
        }
        this.f31664d = 1;
        return this.f31662b;
    }

    @Override // n2.d
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public o dequeueOutputBuffer() throws k {
        a4.a.g(!this.f31665e);
        if (this.f31664d != 2 || this.f31663c.isEmpty()) {
            return null;
        }
        o oVarRemoveFirst = this.f31663c.removeFirst();
        if (this.f31662b.h()) {
            oVarRemoveFirst.a(4);
        } else {
            n nVar = this.f31662b;
            oVarRemoveFirst.m(this.f31662b.f31588e, new b(nVar.f31588e, this.f31661a.a(((ByteBuffer) a4.a.e(nVar.f31586c)).array())), 0L);
        }
        this.f31662b.c();
        this.f31664d = 0;
        return oVarRemoveFirst;
    }

    @Override // n2.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void queueInputBuffer(n nVar) throws k {
        a4.a.g(!this.f31665e);
        a4.a.g(this.f31664d == 1);
        a4.a.a(this.f31662b == nVar);
        this.f31664d = 2;
    }

    @Override // n2.d
    public void flush() {
        a4.a.g(!this.f31665e);
        this.f31662b.c();
        this.f31664d = 0;
    }

    @Override // n2.d
    public void release() {
        this.f31665e = true;
    }

    @Override // n3.j
    public void setPositionUs(long j10) {
    }
}
