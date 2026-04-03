package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.Map;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.s1;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CoroutinesRoom.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CoroutinesRoomKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public static final k0 getQueryDispatcher(@NotNull RoomDatabase roomDatabase) {
        kotlin.jvm.internal.t.i(roomDatabase, "<this>");
        Map<String, Object> backingFieldMap = roomDatabase.getBackingFieldMap();
        Object objB = backingFieldMap.get("QueryDispatcher");
        if (objB == null) {
            objB = s1.b(roomDatabase.getQueryExecutor());
            backingFieldMap.put("QueryDispatcher", objB);
        }
        kotlin.jvm.internal.t.g(objB, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (k0) objB;
    }

    @NotNull
    public static final k0 getTransactionDispatcher(@NotNull RoomDatabase roomDatabase) {
        kotlin.jvm.internal.t.i(roomDatabase, "<this>");
        Map<String, Object> backingFieldMap = roomDatabase.getBackingFieldMap();
        Object objB = backingFieldMap.get("TransactionDispatcher");
        if (objB == null) {
            objB = s1.b(roomDatabase.getTransactionExecutor());
            backingFieldMap.put("TransactionDispatcher", objB);
        }
        kotlin.jvm.internal.t.g(objB, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (k0) objB;
    }
}
