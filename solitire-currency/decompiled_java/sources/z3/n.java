package z3;

import androidx.annotation.Nullable;
import java.io.IOException;

/* JADX INFO: compiled from: DataSourceUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n {
    public static void a(@Nullable k kVar) {
        if (kVar != null) {
            try {
                kVar.close();
            } catch (IOException unused) {
            }
        }
    }
}
