package bo.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class nr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vu f3516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean[] f3517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ pr f3519d;

    public nr(pr prVar, vu vuVar) {
        this.f3519d = prVar;
        this.f3516a = vuVar;
        this.f3517b = vuVar.f4139c ? null : new boolean[prVar.f3651g];
    }

    public final OutputStream a() {
        FileOutputStream fileOutputStream;
        mr mrVar;
        pr prVar = this.f3519d;
        if (prVar.f3651g <= 0) {
            throw new IllegalArgumentException("Expected index 0 to be greater than 0 and less than the maximum value count of " + this.f3519d.f3651g);
        }
        synchronized (prVar) {
            vu vuVar = this.f3516a;
            if (vuVar.f4140d != this) {
                throw new IllegalStateException();
            }
            if (!vuVar.f4139c) {
                this.f3517b[0] = true;
            }
            File fileA = vuVar.a(0);
            try {
                fileOutputStream = new FileOutputStream(fileA);
            } catch (FileNotFoundException unused) {
                this.f3519d.f3645a.mkdirs();
                try {
                    fileOutputStream = new FileOutputStream(fileA);
                } catch (FileNotFoundException unused2) {
                    return pr.f3644q;
                }
            }
            mrVar = new mr(this, fileOutputStream);
        }
        return mrVar;
    }
}
