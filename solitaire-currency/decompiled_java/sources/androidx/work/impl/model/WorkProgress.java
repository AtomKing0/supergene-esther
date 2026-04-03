package androidx.work.impl.model;

import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.work.Data;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: WorkProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
@Entity(foreignKeys = {@ForeignKey(childColumns = {"work_spec_id"}, entity = WorkSpec.class, onDelete = 5, onUpdate = 5, parentColumns = {"id"})})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class WorkProgress {

    @ColumnInfo(name = "progress")
    @NotNull
    private final Data progress;

    @PrimaryKey
    @ColumnInfo(name = "work_spec_id")
    @NotNull
    private final String workSpecId;

    public WorkProgress(@NotNull String workSpecId, @NotNull Data progress) {
        t.i(workSpecId, "workSpecId");
        t.i(progress, "progress");
        this.workSpecId = workSpecId;
        this.progress = progress;
    }

    @NotNull
    public final Data getProgress() {
        return this.progress;
    }

    @NotNull
    public final String getWorkSpecId() {
        return this.workSpecId;
    }
}
