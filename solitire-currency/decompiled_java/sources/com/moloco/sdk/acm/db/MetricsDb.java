package com.moloco.sdk.acm.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@TypeConverters({com.moloco.sdk.acm.db.a.class})
@Database(entities = {b.class}, version = 1)
public abstract class MetricsDb extends RoomDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f17323a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public static volatile MetricsDb f17324b;

    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public final MetricsDb a(Context context) {
            try {
                Context applicationContext = context.getApplicationContext();
                t.h(applicationContext, "context.applicationContext");
                return (MetricsDb) Room.databaseBuilder(applicationContext, MetricsDb.class, "metrics-db").build();
            } catch (Exception e10) {
                throw new IllegalStateException("Database creation failed", e10);
            }
        }

        @NotNull
        public final MetricsDb b(@NotNull Context context) {
            t.i(context, "context");
            MetricsDb metricsDb = MetricsDb.f17324b;
            if (metricsDb == null) {
                synchronized (this) {
                    metricsDb = MetricsDb.f17324b;
                    if (metricsDb == null) {
                        MetricsDb metricsDbA = MetricsDb.f17323a.a(context);
                        MetricsDb.f17324b = metricsDbA;
                        metricsDb = metricsDbA;
                    }
                }
            }
            return metricsDb;
        }

        public a() {
        }
    }

    @NotNull
    public abstract d c();
}
