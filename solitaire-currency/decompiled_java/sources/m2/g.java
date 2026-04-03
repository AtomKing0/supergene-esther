package m2;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: AudioProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
public interface g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ByteBuffer f31273a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    /* JADX INFO: compiled from: AudioProcessor.java */
    public static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f31274e = new a(-1, -1, -1);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f31275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f31276b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f31277c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f31278d;

        public a(int i10, int i11, int i12) {
            this.f31275a = i10;
            this.f31276b = i11;
            this.f31277c = i12;
            this.f31278d = a4.o0.o0(i12) ? a4.o0.Y(i12, i11) : -1;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f31275a == aVar.f31275a && this.f31276b == aVar.f31276b && this.f31277c == aVar.f31277c;
        }

        public int hashCode() {
            return e5.k.b(Integer.valueOf(this.f31275a), Integer.valueOf(this.f31276b), Integer.valueOf(this.f31277c));
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.f31275a + ", channelCount=" + this.f31276b + ", encoding=" + this.f31277c + ']';
        }
    }

    /* JADX INFO: compiled from: AudioProcessor.java */
    public static final class b extends Exception {
        public b(a aVar) {
            super("Unhandled format: " + aVar);
        }
    }

    a a(a aVar) throws b;

    void flush();

    ByteBuffer getOutput();

    boolean isActive();

    boolean isEnded();

    void queueEndOfStream();

    void queueInput(ByteBuffer byteBuffer);

    void reset();
}
