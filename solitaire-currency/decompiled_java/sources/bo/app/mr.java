package bo.app;

import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class mr extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ nr f3446a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mr(nr nrVar, FileOutputStream fileOutputStream) {
        super(fileOutputStream);
        this.f3446a = nrVar;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            ((FilterOutputStream) this).out.close();
        } catch (IOException unused) {
            this.f3446a.f3518c = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public final void flush() {
        try {
            ((FilterOutputStream) this).out.flush();
        } catch (IOException unused) {
            this.f3446a.f3518c = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i10) {
        try {
            ((FilterOutputStream) this).out.write(i10);
        } catch (IOException unused) {
            this.f3446a.f3518c = true;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i10, int i11) {
        try {
            ((FilterOutputStream) this).out.write(bArr, i10, i11);
        } catch (IOException unused) {
            this.f3446a.f3518c = true;
        }
    }
}
