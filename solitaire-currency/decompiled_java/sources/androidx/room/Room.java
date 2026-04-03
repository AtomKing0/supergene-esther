package androidx.room;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Room.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Room {

    @NotNull
    private static final String CURSOR_CONV_SUFFIX = "_CursorConverter";

    @NotNull
    public static final Room INSTANCE = new Room();

    @NotNull
    public static final String LOG_TAG = "ROOM";

    @NotNull
    public static final String MASTER_TABLE_NAME = "room_master_table";

    private Room() {
    }

    @NotNull
    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> databaseBuilder(@NotNull Context context, @NotNull Class<T> klass, @Nullable String str) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(klass, "klass");
        if (true ^ (str == null || p9.q.z(str))) {
            return new RoomDatabase.Builder<>(context, klass, str);
        }
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder".toString());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final <T, C> T getGeneratedImplementation(@NotNull Class<C> klass, @NotNull String suffix) {
        String str;
        kotlin.jvm.internal.t.i(klass, "klass");
        kotlin.jvm.internal.t.i(suffix, "suffix");
        Package r12 = klass.getPackage();
        kotlin.jvm.internal.t.f(r12);
        String fullPackage = r12.getName();
        String canonicalName = klass.getCanonicalName();
        kotlin.jvm.internal.t.f(canonicalName);
        kotlin.jvm.internal.t.h(fullPackage, "fullPackage");
        if (!(fullPackage.length() == 0)) {
            canonicalName = canonicalName.substring(fullPackage.length() + 1);
            kotlin.jvm.internal.t.h(canonicalName, "this as java.lang.String).substring(startIndex)");
        }
        String str2 = p9.q.F(canonicalName, '.', '_', false, 4, null) + suffix;
        try {
            if (fullPackage.length() == 0) {
                str = str2;
            } else {
                str = fullPackage + '.' + str2;
            }
            Class<?> cls = Class.forName(str, true, klass.getClassLoader());
            kotlin.jvm.internal.t.g(cls, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            return (T) cls.newInstance();
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + klass.getCanonicalName() + ". " + str2 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor " + klass + ".canonicalName");
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + klass + ".canonicalName");
        }
    }

    @NotNull
    public static final <T extends RoomDatabase> RoomDatabase.Builder<T> inMemoryDatabaseBuilder(@NotNull Context context, @NotNull Class<T> klass) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(klass, "klass");
        return new RoomDatabase.Builder<>(context, klass, null);
    }
}
