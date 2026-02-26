package androidx.sqlite.db;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.File;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SupportSQLiteCompat.kt */
/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SupportSQLiteCompat {

    /* JADX INFO: compiled from: SupportSQLiteCompat.kt */
    @RequiresApi(16)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api16Impl {

        @NotNull
        public static final Api16Impl INSTANCE = new Api16Impl();

        private Api16Impl() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void cancel(@NotNull CancellationSignal cancellationSignal) {
            t.i(cancellationSignal, "cancellationSignal");
            cancellationSignal.cancel();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public static final CancellationSignal createCancellationSignal() {
            return new CancellationSignal();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final boolean deleteDatabase(@NotNull File file) {
            t.i(file, "file");
            return SQLiteDatabase.deleteDatabase(file);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void disableWriteAheadLogging(@NotNull SQLiteDatabase sQLiteDatabase) {
            t.i(sQLiteDatabase, "sQLiteDatabase");
            sQLiteDatabase.disableWriteAheadLogging();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final boolean isWriteAheadLoggingEnabled(@NotNull SQLiteDatabase sQLiteDatabase) {
            t.i(sQLiteDatabase, "sQLiteDatabase");
            return sQLiteDatabase.isWriteAheadLoggingEnabled();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public static final Cursor rawQueryWithFactory(@NotNull SQLiteDatabase sQLiteDatabase, @NotNull String sql, @NotNull String[] selectionArgs, @Nullable String str, @NotNull CancellationSignal cancellationSignal, @NotNull SQLiteDatabase.CursorFactory cursorFactory) {
            t.i(sQLiteDatabase, "sQLiteDatabase");
            t.i(sql, "sql");
            t.i(selectionArgs, "selectionArgs");
            t.i(cancellationSignal, "cancellationSignal");
            t.i(cursorFactory, "cursorFactory");
            Cursor cursorRawQueryWithFactory = sQLiteDatabase.rawQueryWithFactory(cursorFactory, sql, selectionArgs, str, cancellationSignal);
            t.h(cursorRawQueryWithFactory, "sQLiteDatabase.rawQueryW…ationSignal\n            )");
            return cursorRawQueryWithFactory;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void setForeignKeyConstraintsEnabled(@NotNull SQLiteDatabase sQLiteDatabase, boolean z10) {
            t.i(sQLiteDatabase, "sQLiteDatabase");
            sQLiteDatabase.setForeignKeyConstraintsEnabled(z10);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void setWriteAheadLoggingEnabled(@NotNull SQLiteOpenHelper sQLiteOpenHelper, boolean z10) {
            t.i(sQLiteOpenHelper, "sQLiteOpenHelper");
            sQLiteOpenHelper.setWriteAheadLoggingEnabled(z10);
        }
    }

    /* JADX INFO: compiled from: SupportSQLiteCompat.kt */
    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api19Impl {

        @NotNull
        public static final Api19Impl INSTANCE = new Api19Impl();

        private Api19Impl() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public static final Uri getNotificationUri(@NotNull Cursor cursor) {
            t.i(cursor, "cursor");
            Uri notificationUri = cursor.getNotificationUri();
            t.h(notificationUri, "cursor.notificationUri");
            return notificationUri;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final boolean isLowRamDevice(@NotNull ActivityManager activityManager) {
            t.i(activityManager, "activityManager");
            return activityManager.isLowRamDevice();
        }
    }

    /* JADX INFO: compiled from: SupportSQLiteCompat.kt */
    @RequiresApi(21)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api21Impl {

        @NotNull
        public static final Api21Impl INSTANCE = new Api21Impl();

        private Api21Impl() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public static final File getNoBackupFilesDir(@NotNull Context context) {
            t.i(context, "context");
            File noBackupFilesDir = context.getNoBackupFilesDir();
            t.h(noBackupFilesDir, "context.noBackupFilesDir");
            return noBackupFilesDir;
        }
    }

    /* JADX INFO: compiled from: SupportSQLiteCompat.kt */
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api23Impl {

        @NotNull
        public static final Api23Impl INSTANCE = new Api23Impl();

        private Api23Impl() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void setExtras(@NotNull Cursor cursor, @NotNull Bundle extras) {
            t.i(cursor, "cursor");
            t.i(extras, "extras");
            cursor.setExtras(extras);
        }
    }

    /* JADX INFO: compiled from: SupportSQLiteCompat.kt */
    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class Api29Impl {

        @NotNull
        public static final Api29Impl INSTANCE = new Api29Impl();

        private Api29Impl() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        @NotNull
        public static final List<Uri> getNotificationUris(@NotNull Cursor cursor) {
            t.i(cursor, "cursor");
            List<Uri> notificationUris = cursor.getNotificationUris();
            t.f(notificationUris);
            return notificationUris;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final void setNotificationUris(@NotNull Cursor cursor, @NotNull ContentResolver cr, @NotNull List<? extends Uri> uris) {
            t.i(cursor, "cursor");
            t.i(cr, "cr");
            t.i(uris, "uris");
            cursor.setNotificationUris(cr, uris);
        }
    }

    private SupportSQLiteCompat() {
    }
}
