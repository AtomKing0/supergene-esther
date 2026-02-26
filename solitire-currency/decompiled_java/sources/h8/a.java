package h8;

import androidx.core.view.InputDeviceCompat;
import java.nio.ByteBuffer;
import org.jetbrains.annotations.NotNull;
import s8.g;

/* JADX INFO: compiled from: ByteBufferPool.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final g<ByteBuffer> f26499a = new s8.b(2048, InputDeviceCompat.SOURCE_TOUCHSCREEN);

    @NotNull
    public static final g<ByteBuffer> a() {
        return f26499a;
    }
}
