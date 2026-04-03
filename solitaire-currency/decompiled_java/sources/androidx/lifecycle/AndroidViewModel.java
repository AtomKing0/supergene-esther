package androidx.lifecycle;

import android.app.Application;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public class AndroidViewModel extends ViewModel {

    @NotNull
    private final Application application;

    public AndroidViewModel(@NotNull Application application) {
        t.i(application, "application");
        this.application = application;
    }

    @NotNull
    public <T extends Application> T getApplication() {
        T t10 = (T) this.application;
        t.g(t10, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return t10;
    }
}
