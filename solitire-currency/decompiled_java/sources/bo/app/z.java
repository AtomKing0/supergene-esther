package bo.app;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.braze.support.BrazeLogger;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final pr f4388a;

    public z(File file) throws IOException {
        pr prVarA = pr.a(file);
        kotlin.jvm.internal.t.h(prVarA, "open(directory, appVersion, valueCount, maxSize)");
        this.f4388a = prVarA;
    }

    public final boolean a(String key) {
        kotlin.jvm.internal.t.i(key, "key");
        String strValueOf = String.valueOf(key.hashCode());
        try {
            or orVarB = this.f4388a.b(strValueOf);
            boolean z10 = orVarB != null;
            f9.c.a(orVarB, null);
            return z10;
        } catch (Throwable th) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, th, false, (h9.a) new v(key, strValueOf), 4, (Object) null);
            return false;
        }
    }

    public final Bitmap b(String key) {
        kotlin.jvm.internal.t.i(key, "key");
        String strValueOf = String.valueOf(key.hashCode());
        try {
            or orVarB = this.f4388a.b(strValueOf);
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(orVarB.f3578a[0]);
                f9.c.a(orVarB, null);
                return bitmapDecodeStream;
            } finally {
            }
        } catch (Throwable th) {
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.E, th, false, (h9.a) new w(key, strValueOf), 4, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new x(key, strValueOf), 7, (Object) null);
            return null;
        }
    }

    public final void a(String key, Bitmap bitmap) {
        kotlin.jvm.internal.t.i(key, "key");
        kotlin.jvm.internal.t.i(bitmap, "bitmap");
        String strValueOf = String.valueOf(key.hashCode());
        try {
            nr nrVarA = this.f4388a.a(strValueOf);
            OutputStream outputStreamA = nrVarA.a();
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStreamA);
                outputStreamA.flush();
                v8.k0 k0Var = v8.k0.f35197a;
                f9.c.a(outputStreamA, null);
                if (nrVarA.f3518c) {
                    pr.a(nrVarA.f3519d, nrVarA, false);
                    nrVarA.f3519d.d(nrVarA.f3516a.f4137a);
                } else {
                    pr.a(nrVarA.f3519d, nrVarA, true);
                }
            } finally {
            }
        } catch (Throwable th) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, th, false, (h9.a) new y(key, strValueOf), 4, (Object) null);
        }
    }
}
