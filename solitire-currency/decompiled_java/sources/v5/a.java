package v5;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid-interop@@17.1.0 */
/* JADX INFO: loaded from: classes3.dex */
@KeepForSdk
public interface a {

    /* JADX INFO: renamed from: v5.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: com.google.firebase:firebase-iid-interop@@17.1.0 */
    @KeepForSdk
    public interface InterfaceC0711a {
    }

    @KeepForSdk
    void a(InterfaceC0711a interfaceC0711a);

    @KeepForSdk
    void b(@NonNull String str, @NonNull String str2) throws IOException;

    @NonNull
    @KeepForSdk
    Task<String> c();

    @Nullable
    @KeepForSdk
    String getToken();
}
