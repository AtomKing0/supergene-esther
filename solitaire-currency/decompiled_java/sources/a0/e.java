package a0;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import ua.q0;

/* JADX INFO: compiled from: FileSystems.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e {
    public static final void a(@NotNull ua.j jVar, @NotNull q0 q0Var) {
        if (jVar.j(q0Var)) {
            return;
        }
        j.d(jVar.o(q0Var));
    }

    public static final void b(@NotNull ua.j jVar, @NotNull q0 q0Var) throws IOException {
        try {
            IOException iOException = null;
            for (q0 q0Var2 : jVar.k(q0Var)) {
                try {
                    if (jVar.l(q0Var2).f()) {
                        b(jVar, q0Var2);
                    }
                    jVar.h(q0Var2);
                } catch (IOException e10) {
                    if (iOException == null) {
                        iOException = e10;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }
}
