package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import androidx.compose.runtime.InternalComposeApi;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.HashMap;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LiveLiteral.kt */
/* JADX INFO: loaded from: classes.dex */
public final class LiveLiteralKt {
    private static boolean isLiveLiteralsEnabled;

    @NotNull
    private static final HashMap<String, MutableState<Object>> liveLiteralCache = new HashMap<>();

    @InternalComposeApi
    public static final void enableLiveLiterals() {
        isLiveLiteralsEnabled = true;
    }

    public static final boolean isLiveLiteralsEnabled() {
        return isLiveLiteralsEnabled;
    }

    @ComposeCompilerApi
    @InternalComposeApi
    @NotNull
    public static final <T> State<T> liveLiteral(@NotNull String key, T t10) {
        t.i(key, "key");
        HashMap<String, MutableState<Object>> map = liveLiteralCache;
        MutableState<Object> mutableStateMutableStateOf$default = map.get(key);
        if (mutableStateMutableStateOf$default == null) {
            mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(t10, null, 2, null);
            map.put(key, mutableStateMutableStateOf$default);
        }
        return mutableStateMutableStateOf$default;
    }

    @InternalComposeApi
    public static final void updateLiveLiteralValue(@NotNull String key, @Nullable Object obj) {
        boolean z10;
        t.i(key, "key");
        HashMap<String, MutableState<Object>> map = liveLiteralCache;
        MutableState<Object> mutableStateMutableStateOf$default = map.get(key);
        if (mutableStateMutableStateOf$default == null) {
            mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(obj, null, 2, null);
            map.put(key, mutableStateMutableStateOf$default);
            z10 = false;
        } else {
            z10 = true;
        }
        MutableState<Object> mutableState = mutableStateMutableStateOf$default;
        if (z10) {
            mutableState.setValue(obj);
        }
    }

    @ComposeCompilerApi
    @InternalComposeApi
    public static /* synthetic */ void isLiveLiteralsEnabled$annotations() {
    }
}
