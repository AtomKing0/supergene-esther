package ua;

import java.io.RandomAccessFile;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JvmFileHandle.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class s extends h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final RandomAccessFile f34817d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(boolean z10, @NotNull RandomAccessFile randomAccessFile) {
        super(z10);
        kotlin.jvm.internal.t.i(randomAccessFile, "randomAccessFile");
        this.f34817d = randomAccessFile;
    }

    @Override // ua.h
    protected synchronized void q() {
        this.f34817d.close();
    }

    @Override // ua.h
    protected synchronized int x(long j10, @NotNull byte[] array, int i10, int i11) {
        kotlin.jvm.internal.t.i(array, "array");
        this.f34817d.seek(j10);
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                break;
            }
            int i13 = this.f34817d.read(array, i10, i11 - i12);
            if (i13 != -1) {
                i12 += i13;
            } else if (i12 == 0) {
                return -1;
            }
        }
        return i12;
    }

    @Override // ua.h
    protected synchronized long z() {
        return this.f34817d.length();
    }
}
