package z3;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DataSource.java */
/* JADX INFO: loaded from: classes2.dex */
public interface k extends h {

    /* JADX INFO: compiled from: DataSource.java */
    public interface a {
        k createDataSource();
    }

    long a(o oVar) throws IOException;

    void b(m0 m0Var);

    void close() throws IOException;

    Map<String, List<String>> getResponseHeaders();

    @Nullable
    Uri getUri();
}
